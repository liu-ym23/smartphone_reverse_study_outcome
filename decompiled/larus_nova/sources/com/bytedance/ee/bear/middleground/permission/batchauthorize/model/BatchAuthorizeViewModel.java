package com.bytedance.ee.bear.middleground.permission.batchauthorize.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata.AuthorizeStateNode;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata.SingeAuthorizeNode;
import com.bytedance.ee.bear.middleground_permission_export.model.batchauthorize.BatchAuthorizeInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import lg5.p;
import org.json.JSONObject;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes18.dex */
public class BatchAuthorizeViewModel extends ViewModel {
    private static final String TAG = "BatchAuthorizeViewModel";
    private final MutableLiveData<ArrayList<SingeAuthorizeNode>> authOperateData;
    private final MutableLiveData<Boolean> cancelAuth;
    private final MutableLiveData<EmbededDocumentInfo.EmbededData> docNewData;
    private EmbededDocumentInfo documentInfo;
    private MutableLiveData<Boolean> hasPages;
    private BatchAuthorizeInfo info;
    private final MutableLiveData<SingeAuthorizeNode> singleAuthList;
    private final MutableLiveData<AuthorizeStateNode> stateData;
    private final HashMap<String, Integer> tokenPermMap;

    public class a implements Function<Throwable, BatchAuthorizeResult> {
        public a() {
        }

        @Override // io.reactivex.functions.Function
        public final BatchAuthorizeResult apply(Throwable r100) throws Exception {
            BatchAuthorizeResult r101 = new BatchAuthorizeResult();
            r101.setSuccess(false);
            r101.setMsg(r100.getMessage());
            return r101;
        }
    }

    public static /* synthetic */ void Mo(BatchAuthorizeViewModel r100, String r101, EmbededDocumentInfo r102) {
        r100.lambda$getEmbededDocumentInfo$0(r101, r102);
    }

    public static /* synthetic */ void No(BatchAuthorizeViewModel r100, Boolean r101, p r102) {
        r100.lambda$batchAuthorize$4(r101, r102);
    }

    public static /* synthetic */ p Oo(BatchAuthorizeResult r100, BatchAuthorizeResult r101, BatchAuthorizeResult r102, BatchAuthorizeResult r103) {
        return lambda$cancelBatchAuthorize$6(r100, r101, r102, r103);
    }

    public static /* synthetic */ void Po(Throwable r100) {
        lambda$batchAuthorize$5(r100);
    }

    public static /* synthetic */ void Qo(NetService.e r100, Result r101) {
        lambda$recordAuthorizeState$10(r100, r101);
    }

    public static /* synthetic */ p So(BatchAuthorizeResult r100, BatchAuthorizeResult r101, BatchAuthorizeResult r102, BatchAuthorizeResult r103) {
        return lambda$batchAuthorize$2(r100, r101, r102, r103);
    }

    public static /* synthetic */ Publisher To(BatchAuthorizeViewModel r100, List r101) {
        return r100.lambda$cancelBatchAuthorize$7(r101);
    }

    public static /* synthetic */ void Wo(BatchAuthorizeViewModel r100, Boolean r101, ArrayList r102, p r103) {
        r100.lambda$cancelBatchAuthorize$8(r101, r102, r103);
    }

    public static /* synthetic */ Publisher Yo(BatchAuthorizeViewModel r100, List r101) {
        return r100.lambda$batchAuthorize$3(r101);
    }

    public static /* synthetic */ void Zo(Throwable r100) {
        lambda$updateCardState$13(r100);
    }

    public static /* synthetic */ void ap(Throwable r100) {
        lambda$cancelBatchAuthorize$9(r100);
    }

    public static /* synthetic */ void bp(NetService.e r100, Result r101) {
        lambda$updateCardState$12(r100, r101);
    }

    public static /* synthetic */ void cp(BatchAuthorizeViewModel r100, Throwable r101) {
        r100.lambda$getEmbededDocumentInfo$1(r101);
    }

    public static /* synthetic */ void yo(Throwable r100) {
        lambda$recordAuthorizeState$11(r100);
    }

    private AuthorizeStateNode.BatchAuthorizeState calculationBatchNewState() {
        EmbededDocumentInfo r100 = this.documentInfo;
        if (r100 == null) goto L33;
        if (r100.getResult() == null) goto L33;
        if (this.documentInfo.getResult().getResult() == null) goto L33;
        if (this.documentInfo.getResult().getResult().isEmpty() == true) goto L33;
        Iterator<EmbededDocumentInfo.NodeInfo> r101 = this.documentInfo.getResult().getResult().iterator();
        int r102 = 0;
        int r103 = 0;
    L13:
        if (r101.hasNext() == false) goto L24;
        EmbededDocumentInfo.NodeInfo r104 = r101.next();
        if (r104.isSenderHasSharePermission() == false) goto L20;
        if (r104.isChat_has_permission() == true) goto L20;
        r102 = r102 + 1;
    L20:
        if (r104.isSenderHasSharePermission() == false) goto L13;
        if (r104.isChat_has_permission() == false) goto L13;
        r103 = r103 + 1;
        goto L13
    L24:
        if (r102 > 0) goto L26;
        if (r103 <= 0) goto L31;
        return AuthorizeStateNode.BatchAuthorizeState.MODE_ALL_DISBATCH;
    L31:
        return AuthorizeStateNode.BatchAuthorizeState.MODE_UNABLE;
    L26:
        return AuthorizeStateNode.BatchAuthorizeState.MODE_ALL_BATCH;
    L33:
        return AuthorizeStateNode.BatchAuthorizeState.MODE_UNABLE;
    }

    public void getEmbededDocumentInfo() {
        NetService.d r100 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new mg5.b());
        NetService.f r101 = new NetService.f("/space/api/platform/doc/card/embeded/" + this.info.getTaskId() + "/obj/list");
        r101.f216906c = 2;
        r101.b("origin_object_token", this.info.getToken());
        r101.b("origin_object_type", String.valueOf(this.info.getType()));
        EmbededDocumentInfo r102 = this.documentInfo;
        if (r102 != null) goto L5;
    L8:
        final String r103 = "";
    L9:
        r101.b(EffectConfiguration.KEY_CURSOR, r103);
        r100.a(r101).observeOn(fo5.d.d()).subscribe(new i(this, r103), new j(this));
        return;
    L5:
        if (r102.getResult() == null) goto L8;
        r103 = r102.getResult().getNext_cusor();
        goto L9
    }

    public void updateCardState() {
        NetService.d r100 = ((NetService) org.koin.java.a.a(NetService.class)).Rb(Result.class);
        String r101 = "/space/api/platform/doc/card/embeded/" + this.info.getTaskId() + "/count";
        UpdateCardRequest r102 = new UpdateCardRequest();
        r102.setObjectToken(this.info.getToken());
        r102.setObjectType(this.info.getType());
        final NetService.f r103 = new NetService.f(r101);
        r103.f216913j = JSON.toJSONString(r102);
        r103.f216906c = 1;
        r100.a(r103).observeOn(fo5.d.d()).subscribe(new l(r103), new m());
    }

    public void updatePermissionAndNoCount() {
        EmbededDocumentInfo r100 = this.documentInfo;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getResult() == null) goto L10;
        AuthorizeStateNode r101 = new AuthorizeStateNode();
        r101.setHasPermissionCount(this.documentInfo.getResult().getTotal_has_permission());
        r101.setNoPermissionCount(this.documentInfo.getResult().getTotal_no_permission());
        r101.setState(calculationBatchNewState());
        getStateData().setValue(r101);
        return;
    }

    public BatchAuthorizeViewModel() {
        this.cancelAuth = new MutableLiveData();
        this.singleAuthList = new MutableLiveData();
        this.stateData = new MutableLiveData();
        this.tokenPermMap = new HashMap();
        this.hasPages = new MutableLiveData();
        this.docNewData = new MutableLiveData();
        this.authOperateData = new MutableLiveData();
    }

    public MutableLiveData<ArrayList<SingeAuthorizeNode>> getAuthOperateData() {
        return this.authOperateData;
    }

    public MutableLiveData<Boolean> getCancelAuth() {
        return this.cancelAuth;
    }

    public MutableLiveData<EmbededDocumentInfo.EmbededData> getDocNewData() {
        return this.docNewData;
    }

    public EmbededDocumentInfo getDocumentInfo() {
        return this.documentInfo;
    }

    public MutableLiveData<Boolean> getHasPages() {
        return this.hasPages;
    }

    public BatchAuthorizeInfo getInfo() {
        return this.info;
    }

    public MutableLiveData<SingeAuthorizeNode> getSingleAuthList() {
        return this.singleAuthList;
    }

    public MutableLiveData<AuthorizeStateNode> getStateData() {
        return this.stateData;
    }

    private /* synthetic */ Publisher lambda$batchAuthorize$3(List r100) throws Exception {
        Boolean r101 = Boolean.FALSE;
        return Flowable.zip(getBatchResult(r100, 0, "/space/api/suite/permission/role/create/", r101), getBatchResult(r100, 1, "/space/api/suite/permission/role/create/", r101), getBatchResult(r100, 2, "/space/api/suite/permission/role/create/", r101), getBatchResult(r100, 3, "/space/api/suite/permission/role/create/", r101), new k());
    }

    private static /* synthetic */ void lambda$batchAuthorize$5(Throwable r100) throws Exception {
        Toast.cancelLoading();
        tt5.a.d(TAG, "batchAuthorize error " + r100.getMessage());
    }

    private /* synthetic */ Publisher lambda$cancelBatchAuthorize$7(List r100) throws Exception {
        Boolean r101 = Boolean.TRUE;
        return Flowable.zip(getBatchResult(r100, 0, "/space/api/suite/permission/role/delete/", r101), getBatchResult(r100, 1, "/space/api/suite/permission/role/delete/", r101), getBatchResult(r100, 2, "/space/api/suite/permission/role/delete/", r101), getBatchResult(r100, 3, "/space/api/suite/permission/role/delete/", r101), new com.bytedance.ee.bear.middleground.permission.batchauthorize.model.a());
    }

    private static /* synthetic */ void lambda$cancelBatchAuthorize$9(Throwable r100) throws Exception {
        Toast.cancelLoading();
        tt5.a.d(TAG, "cancelBatchAuthorize error " + r100.getMessage());
    }

    private /* synthetic */ void lambda$getEmbededDocumentInfo$1(Throwable r100) throws Exception {
        EmbededDocumentInfo.EmbededData r101 = new EmbededDocumentInfo.EmbededData(new EmbededDocumentInfo());
        getDocNewData().setValue(r101);
        tt5.a.d(TAG, "getEmbededDocumentInfo ");
    }

    private static /* synthetic */ void lambda$recordAuthorizeState$11(Throwable r100) throws Exception {
        tt5.a.d(TAG, "recordAuthorizeState ");
    }

    private static /* synthetic */ void lambda$updateCardState$13(Throwable r100) throws Exception {
        tt5.a.d(TAG, "updateCardState ");
    }

    public int getHasPermissionResultSize(Boolean r100) {
        EmbededDocumentInfo r101 = this.documentInfo;
        if (r101 != null) goto L5;
        return 0;
    L5:
        if (r101.getResult() != null) goto L7;
        return 0;
    L7:
        if (this.documentInfo.getResult().getResult() != null) goto L9;
        return 0;
    L9:
        return ng5.a.a(this.documentInfo.getResult().getResult(), r100).size();
    }

    public void recordAuthorizeState(ArrayList<RecordAuthorizeRequest.AuthObject> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L9;
        NetService.d r101 = ((NetService) org.koin.java.a.a(NetService.class)).Rb(Result.class);
        String r102 = "/space/api/platform/doc/card/embeded/" + this.info.getTaskId() + "/obj";
        RecordAuthorizeRequest r103 = new RecordAuthorizeRequest();
        r103.setOriginToken(this.info.getToken());
        r103.setOriginType(this.info.getType());
        r103.setObjectArrayList(r100);
        final NetService.f r104 = new NetService.f(r102);
        r104.f216913j = JSON.toJSONString(r103);
        r104.f216906c = 1;
        r101.a(r104).observeOn(fo5.d.d()).subscribe(new d(r104), new e());
        return;
    }

    public void setHasPages(MutableLiveData<Boolean> r100) {
        this.hasPages = r100;
    }

    public void setInfo(BatchAuthorizeInfo r100) {
        this.info = r100;
    }

    private void lambda$batchAuthorize$4(Boolean r110, p r111) throws Exception {
        ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r100 = ng5.a.c(r111);
        if (r100.isEmpty() == false) goto L6;
        ng5.a.f(r111, null, r110);
        getSingleAuthList().setValue(new SingeAuthorizeNode(false, -1, true));
        return;
    L6:
        ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r101 = ng5.a.e(r100);
        if (r101 != null) goto L9;
    L11:
        ArrayList<SingeAuthorizeNode> r102 = ng5.a.i(r100, true, 0);
        ng5.a.f(r111, r102, r110);
        if (r100.size() <= 1) goto L14;
        getAuthOperateData().setValue(r102);
        return;
    L14:
        SingeAuthorizeNode r103 = (SingeAuthorizeNode) ListProtector.get(r102, 0);
        r103.setNodeInfo((BatchAuthorizeResult.BatchAuthorizeNode) ListProtector.get(r100, 0));
        getSingleAuthList().setValue(r103);
        if (r103.isSuccess() == false) goto L23;
        String r104 = r103.getToken();
        String r105 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        Intrinsics.checkNotNullParameter(r104, "token");
        JSONObject r106 = new JSONObject();
        int r107 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L19;
        String r112 = ThumbGlideUrl.SOURCE_VC;
    L20:
        com.bytedance.ee.bear.middleground.permission.c.a(r106, r104, r107, r112, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
        r106.put("object_id", r104);
        r106.put("click", "authorize");
        r106.put(PickerReporterConstants.KEY.TARGET, "none");
        r106.put("is_ask_owner", false);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_cited_doc_authorize_click", r106);
        return;
    L19:
        r112 = "none";
        goto L20
    L23:
        return;
    L9:
        if (r101.size() <= 0) goto L11;
        updateCount(true, r101.size());
        recordAuthorizeState(ng5.a.d(this.tokenPermMap, r101, 1));
        goto L11
    }

    private void lambda$getEmbededDocumentInfo$0(String r100, EmbededDocumentInfo r101) throws Exception {
        if (r101.isSuccess() == true) goto L5;
    L32:
        getDocNewData().setValue(new EmbededDocumentInfo.EmbededData(new EmbededDocumentInfo()));
        return;
    L5:
        if (r101.getResult() == null) goto L32;
        if (r101.getResult().getResult() == null) goto L32;
        if ((!r101.getResult().isIs_last()) == true) goto L11;
        getHasPages().setValue(Boolean.FALSE);
    L13:
        if (r101.getResult().getResult().size() <= 0) goto L28;
        if (r101.getResult() != null) goto L17;
    L22:
        ArrayList<EmbededDocumentInfo.NodeInfo> r102 = null;
    L23:
        Iterator<EmbededDocumentInfo.NodeInfo> r103 = r102.iterator();
    L25:
        if (r103.hasNext() == false) goto L28;
        EmbededDocumentInfo.NodeInfo r104 = r103.next();
        this.tokenPermMap.put(r104.getObject_token(), Integer.valueOf(r104.getPerm_type()));
        goto L25
    L17:
        if (r101.getResult().getResult() == null) goto L22;
        if (r101.getResult().getResult().size() <= 0) goto L22;
        r102 = r101.getResult().getResult();
    L28:
        if (r100.isEmpty() == false) goto L30;
        this.documentInfo = r101;
    L31:
        getDocNewData().setValue(r101.getResult());
        return;
    L30:
        this.documentInfo.getResult().setNext_cusor(r101.getResult().getNext_cusor());
        this.documentInfo.getResult().getResult().addAll(r101.getResult().getResult());
        goto L31
    L11:
        getHasPages().setValue(Boolean.TRUE);
        goto L13
    }

    private static /* synthetic */ void lambda$recordAuthorizeState$10(NetService.e r100, Result r101) throws Exception {
        tt5.a.h(TAG, "recordAuthorizeState " + r100.toString());
    }

    private static /* synthetic */ void lambda$updateCardState$12(NetService.e r100, Result r101) throws Exception {
        tt5.a.h(TAG, "updateCardState " + r100);
    }

    private void updateCount(boolean r100, int r101) {
        EmbededDocumentInfo r102 = this.documentInfo;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.getResult() == null) goto L14;
        int r103 = this.documentInfo.getResult().getTotal_has_permission();
        int r104 = this.documentInfo.getResult().getTotal_no_permission();
        if (r100 == false) goto L10;
        int r105 = r103 + r101;
        int r106 = r104 - r101;
    L11:
        this.documentInfo.getResult().setTotal_has_permission(r105);
        this.documentInfo.getResult().setTotal_no_permission(r106);
        return;
    L10:
        r106 = r104 + r101;
        r105 = r103 - r101;
        goto L11
    }

    public void batchAuthorize(ArrayList<EmbededDocumentInfo.NodeInfo> r100, final Boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L15;
        ArrayList<EmbededDocumentInfo.NodeInfo> r102 = ng5.a.a(r100, Boolean.FALSE);
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.size() <= 0) goto L16;
        Flowable.fromIterable(r102).buffer(50).toList().toFlowable().flatMap(new f(this)).observeOn(fo5.d.d()).subscribe(new g(this, r101), new h());
        return;
    L16:
        return;
    }

    public void cancelBatchAuthorize(ArrayList<EmbededDocumentInfo.NodeInfo> r100, final Boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L15;
        final ArrayList<EmbededDocumentInfo.NodeInfo> r102 = ng5.a.a(r100, Boolean.TRUE);
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.size() <= 0) goto L16;
        Flowable.fromIterable(r102).buffer(50).toList().toFlowable().flatMap(new n(this)).observeOn(fo5.d.d()).subscribe(new b(this, r101, r102), new c());
        return;
    L16:
        return;
    }

    private /* synthetic */ void lambda$cancelBatchAuthorize$8(Boolean r100, ArrayList r101, p r102) throws Exception {
        ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r103 = ng5.a.c(r102);
        if (r103.isEmpty() == false) goto L6;
        ng5.a.g(r102, null, r100);
        getSingleAuthList().setValue(new SingeAuthorizeNode(false, -1, false));
        return;
    L6:
        ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r104 = ng5.a.e(r103);
        if (r104 != null) goto L9;
    L11:
        ArrayList<SingeAuthorizeNode> r105 = ng5.a.i(r103, false, r103.size());
        ng5.a.g(r102, r105, r100);
        if (r101.size() <= 1) goto L15;
        getAuthOperateData().setValue(r105);
    L18:
        tt5.a.h(TAG, "cancelBatchAuthorize ");
        return;
    L15:
        if (r105.size() <= 0) goto L17;
        getSingleAuthList().setValue((SingeAuthorizeNode) ListProtector.get(r105, 0));
        goto L18
    L17:
        getSingleAuthList().setValue(new SingeAuthorizeNode(false, -1, false));
        goto L18
    L9:
        if (r104.size() <= 0) goto L11;
        updateCount(false, r104.size());
        recordAuthorizeState(ng5.a.d(this.tokenPermMap, r104, 0));
        goto L11
    }

    private Flowable<BatchAuthorizeResult> getBatchResult(List<List<EmbededDocumentInfo.NodeInfo>> r100, int r101, String r110, Boolean r111) {
        if (r100 != null) goto L5;
    L25:
        BatchAuthorizeResult r102 = new BatchAuthorizeResult();
        r102.setSuccess(true);
        return Flowable.just(r102);
    L5:
        if (r101 >= r100.size()) goto L25;
        List r103 = (List) ListProtector.get(r100, r101);
        BatchAuthorizeRequest r104 = new BatchAuthorizeRequest();
        ArrayList<BatchAuthorizeRequest.BatchRequestNode> r105 = new ArrayList();
        Iterator r106 = r103.iterator();
    L9:
        if (r106.hasNext() == false) goto L23;
        EmbededDocumentInfo.NodeInfo r107 = (EmbededDocumentInfo.NodeInfo) r106.next();
        BatchAuthorizeRequest.BatchRequestNode r108 = new BatchAuthorizeRequest.BatchRequestNode();
        BatchAuthorizeRequest.Collabrator r109 = new BatchAuthorizeRequest.Collabrator();
        r109.setId(CastLongProtector.parseLong(this.info.getChatId()));
        r109.setEntityType(this.info.getChatType());
        if (r107.getPerm_type() != (-1)) goto L18;
        if (r111.booleanValue() == false) goto L15;
        long r112 = 0;
    L16:
        r109.setRole(r112);
    L22:
        r108.setCollabrator(r109);
        r108.setToken(r107.getObject_token());
        r108.setEntityType(r107.getObject_type() + "");
        r105.add(r108);
        goto L9
    L15:
        r112 = 1;
        goto L16
    L18:
        if (r111.booleanValue() == false) goto L20;
        long r113 = 10;
    L21:
        r109.setRole(r113);
        goto L22
    L20:
        r113 = 11;
        goto L21
    L23:
        r104.setData(r105);
        NetService.d r114 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new mg5.a());
        NetService.f r115 = new NetService.f(r110);
        r115.f216913j = JSON.toJSONString(r104);
        r115.f216906c = 1;
        return r114.a(r115).onErrorReturn(new a());
    }

    private static /* synthetic */ p lambda$batchAuthorize$2(BatchAuthorizeResult r100, BatchAuthorizeResult r101, BatchAuthorizeResult r102, BatchAuthorizeResult r103) throws Exception {
        return new p(r100, r101, r102, r103);
    }

    private static /* synthetic */ p lambda$cancelBatchAuthorize$6(BatchAuthorizeResult r100, BatchAuthorizeResult r101, BatchAuthorizeResult r102, BatchAuthorizeResult r103) throws Exception {
        return new p(r100, r101, r102, r103);
    }
}
