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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

        public final Object apply(Object r3) throws Exception {
            BatchAuthorizeResult r0 = new BatchAuthorizeResult();
            r0.setSuccess(false);
            r0.setMsg(((Throwable) r3).getMessage());
            return r0;
        }
    }

    public static /* synthetic */ void Mo(BatchAuthorizeViewModel r0, String r1, EmbededDocumentInfo r2) {
        r0.lambda$getEmbededDocumentInfo$0(r1, r2);
    }

    public static /* synthetic */ void No(BatchAuthorizeViewModel r0, Boolean r1, p r2) {
        r0.lambda$batchAuthorize$4(r1, r2);
    }

    public static /* synthetic */ p Oo(BatchAuthorizeResult r0, BatchAuthorizeResult r1, BatchAuthorizeResult r2, BatchAuthorizeResult r3) {
        return lambda$cancelBatchAuthorize$6(r0, r1, r2, r3);
    }

    public static /* synthetic */ void Po(Throwable r0) {
        lambda$batchAuthorize$5(r0);
    }

    public static /* synthetic */ void Qo(NetService.e r0, Result r1) {
        lambda$recordAuthorizeState$10(r0, r1);
    }

    public static /* synthetic */ p So(BatchAuthorizeResult r0, BatchAuthorizeResult r1, BatchAuthorizeResult r2, BatchAuthorizeResult r3) {
        return lambda$batchAuthorize$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ Publisher To(BatchAuthorizeViewModel r0, List r1) {
        return r0.lambda$cancelBatchAuthorize$7(r1);
    }

    public static /* synthetic */ void Wo(BatchAuthorizeViewModel r0, Boolean r1, ArrayList r2, p r3) {
        r0.lambda$cancelBatchAuthorize$8(r1, r2, r3);
    }

    public static /* synthetic */ Publisher Yo(BatchAuthorizeViewModel r0, List r1) {
        return r0.lambda$batchAuthorize$3(r1);
    }

    public static /* synthetic */ void Zo(Throwable r0) {
        lambda$updateCardState$13(r0);
    }

    public static /* synthetic */ void ap(Throwable r0) {
        lambda$cancelBatchAuthorize$9(r0);
    }

    public static /* synthetic */ void bp(NetService.e r0, Result r1) {
        lambda$updateCardState$12(r0, r1);
    }

    public static /* synthetic */ void cp(BatchAuthorizeViewModel r0, Throwable r1) {
        r0.lambda$getEmbededDocumentInfo$1(r1);
    }

    public static /* synthetic */ void yo(Throwable r0) {
        lambda$recordAuthorizeState$11(r0);
    }

    private AuthorizeStateNode.BatchAuthorizeState calculationBatchNewState() {
        EmbededDocumentInfo r0 = this.documentInfo;
        if (r0 == null) goto L33;
        if (r0.getResult() == null) goto L33;
        if (this.documentInfo.getResult().getResult() == null) goto L33;
        if (this.documentInfo.getResult().getResult().isEmpty() == true) goto L33;
        Iterator<EmbededDocumentInfo.NodeInfo> r1 = this.documentInfo.getResult().getResult().iterator();
        int r2 = 0;
        int r3 = 0;
    L13:
        if (r1.hasNext() == false) goto L24;
        EmbededDocumentInfo.NodeInfo r4 = r1.next();
        if (r4.isSenderHasSharePermission() == false) goto L20;
        if (r4.isChat_has_permission() == true) goto L20;
        r2 = r2 + 1;
    L20:
        if (r4.isSenderHasSharePermission() == false) goto L13;
        if (r4.isChat_has_permission() == false) goto L13;
        r3 = r3 + 1;
        goto L13
    L24:
        if (r2 > 0) goto L26;
        if (r3 <= 0) goto L31;
        return AuthorizeStateNode.BatchAuthorizeState.MODE_ALL_DISBATCH;
    L31:
        return AuthorizeStateNode.BatchAuthorizeState.MODE_UNABLE;
    L26:
        return AuthorizeStateNode.BatchAuthorizeState.MODE_ALL_BATCH;
    L33:
        return AuthorizeStateNode.BatchAuthorizeState.MODE_UNABLE;
    }

    public void getEmbededDocumentInfo() {
        NetService.d r0 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new mg5.b());
        NetService.f r2 = new NetService.f("/space/api/platform/doc/card/embeded/" + this.info.getTaskId() + "/obj/list");
        ((NetService.e) r2).c = 2;
        r2.b("origin_object_token", this.info.getToken());
        r2.b("origin_object_type", String.valueOf(this.info.getType()));
        EmbededDocumentInfo r1 = this.documentInfo;
        if (r1 != null) goto L5;
    L8:
        final String r3 = "";
    L9:
        r2.b("cursor", r3);
        r0.a(r2).observeOn(fo5.d.d()).subscribe(new i(this, r3), new j(this));
        return;
    L5:
        if (r1.getResult() == null) goto L8;
        r3 = r1.getResult().getNext_cusor();
        goto L9
    }

    public void updateCardState() {
        NetService.d r0 = ((NetService) org.koin.java.a.a(NetService.class)).Rb(Result.class);
        String r1 = "/space/api/platform/doc/card/embeded/" + this.info.getTaskId() + "/count";
        UpdateCardRequest r2 = new UpdateCardRequest();
        r2.setObjectToken(this.info.getToken());
        r2.setObjectType(this.info.getType());
        final NetService.f r3 = new NetService.f(r1);
        ((NetService.e) r3).j = JSON.toJSONString(r2);
        ((NetService.e) r3).c = 1;
        r0.a(r3).observeOn(fo5.d.d()).subscribe(new l(r3), new m());
    }

    public void updatePermissionAndNoCount() {
        EmbededDocumentInfo r0 = this.documentInfo;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getResult() == null) goto L10;
        AuthorizeStateNode r1 = new AuthorizeStateNode();
        r1.setHasPermissionCount(this.documentInfo.getResult().getTotal_has_permission());
        r1.setNoPermissionCount(this.documentInfo.getResult().getTotal_no_permission());
        r1.setState(calculationBatchNewState());
        getStateData().setValue(r1);
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

    private /* synthetic */ Publisher lambda$batchAuthorize$3(List r7) throws Exception {
        Boolean r0 = Boolean.FALSE;
        return Flowable.zip(getBatchResult(r7, 0, "/space/api/suite/permission/role/create/", r0), getBatchResult(r7, 1, "/space/api/suite/permission/role/create/", r0), getBatchResult(r7, 2, "/space/api/suite/permission/role/create/", r0), getBatchResult(r7, 3, "/space/api/suite/permission/role/create/", r0), new k());
    }

    private static /* synthetic */ void lambda$batchAuthorize$5(Throwable r2) throws Exception {
        Toast.cancelLoading();
        tt5.a.d(TAG, "batchAuthorize error " + r2.getMessage());
    }

    private /* synthetic */ Publisher lambda$cancelBatchAuthorize$7(List r7) throws Exception {
        Boolean r0 = Boolean.TRUE;
        return Flowable.zip(getBatchResult(r7, 0, "/space/api/suite/permission/role/delete/", r0), getBatchResult(r7, 1, "/space/api/suite/permission/role/delete/", r0), getBatchResult(r7, 2, "/space/api/suite/permission/role/delete/", r0), getBatchResult(r7, 3, "/space/api/suite/permission/role/delete/", r0), new com.bytedance.ee.bear.middleground.permission.batchauthorize.model.a());
    }

    private static /* synthetic */ void lambda$cancelBatchAuthorize$9(Throwable r2) throws Exception {
        Toast.cancelLoading();
        tt5.a.d(TAG, "cancelBatchAuthorize error " + r2.getMessage());
    }

    private /* synthetic */ void lambda$getEmbededDocumentInfo$1(Throwable r2) throws Exception {
        EmbededDocumentInfo.EmbededData r0 = new EmbededDocumentInfo.EmbededData(new EmbededDocumentInfo());
        getDocNewData().setValue(r0);
        tt5.a.d(TAG, "getEmbededDocumentInfo ");
    }

    private static /* synthetic */ void lambda$recordAuthorizeState$11(Throwable r1) throws Exception {
        tt5.a.d(TAG, "recordAuthorizeState ");
    }

    private static /* synthetic */ void lambda$updateCardState$13(Throwable r1) throws Exception {
        tt5.a.d(TAG, "updateCardState ");
    }

    public int getHasPermissionResultSize(Boolean r2) {
        EmbededDocumentInfo r0 = this.documentInfo;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.getResult() != null) goto L7;
        return 0;
    L7:
        if (this.documentInfo.getResult().getResult() != null) goto L9;
        return 0;
    L9:
        return ng5.a.a(this.documentInfo.getResult().getResult(), r2).size();
    }

    public void recordAuthorizeState(ArrayList<RecordAuthorizeRequest.AuthObject> r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.size() <= 0) goto L9;
        NetService.d r0 = ((NetService) org.koin.java.a.a(NetService.class)).Rb(Result.class);
        String r1 = "/space/api/platform/doc/card/embeded/" + this.info.getTaskId() + "/obj";
        RecordAuthorizeRequest r2 = new RecordAuthorizeRequest();
        r2.setOriginToken(this.info.getToken());
        r2.setOriginType(this.info.getType());
        r2.setObjectArrayList(r6);
        final NetService.f r7 = new NetService.f(r1);
        ((NetService.e) r7).j = JSON.toJSONString(r2);
        ((NetService.e) r7).c = 1;
        r0.a(r7).observeOn(fo5.d.d()).subscribe(new d(r7), new e());
        return;
    }

    public void setHasPages(MutableLiveData<Boolean> r1) {
        this.hasPages = r1;
    }

    public void setInfo(BatchAuthorizeInfo r1) {
        this.info = r1;
    }

    private void lambda$batchAuthorize$4(Boolean r18, p r19) throws Exception {
        ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r3 = ng5.a.c(r19);
        if (r3.isEmpty() == false) goto L6;
        ng5.a.f(r19, null, r18);
        getSingleAuthList().setValue(new SingeAuthorizeNode(false, -1, true));
        return;
    L6:
        ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r4 = ng5.a.e(r3);
        if (r4 != null) goto L9;
    L11:
        ArrayList<SingeAuthorizeNode> r5 = ng5.a.i(r3, true, 0);
        ng5.a.f(r19, r5, r18);
        if (r3.size() <= 1) goto L14;
        getAuthOperateData().setValue(r5);
        return;
    L14:
        SingeAuthorizeNode r1 = (SingeAuthorizeNode) ListProtector.get(r5, 0);
        r1.setNodeInfo((BatchAuthorizeResult.BatchAuthorizeNode) ListProtector.get(r3, 0));
        getSingleAuthList().setValue(r1);
        if (r1.isSuccess() == false) goto L23;
        String r2 = r1.getToken();
        String r6 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        JSONObject r7 = new JSONObject();
        int r9 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L19;
        String r10 = ThumbGlideUrl.SOURCE_VC;
    L20:
        com.bytedance.ee.bear.middleground.permission.c.a(r7, r2, r9, r10, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r7.put("object_id", r2);
        r7.put("click", "authorize");
        r7.put("target", "none");
        r7.put("is_ask_owner", false);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_cited_doc_authorize_click", r7);
        return;
    L19:
        r10 = "none";
        goto L20
    L23:
        return;
    L9:
        if (r4.size() <= 0) goto L11;
        updateCount(true, r4.size());
        recordAuthorizeState(ng5.a.d(this.tokenPermMap, r4, 1));
        goto L11
    }

    private void lambda$getEmbededDocumentInfo$0(String r5, EmbededDocumentInfo r6) throws Exception {
        if (r6.isSuccess() == true) goto L5;
    L32:
        getDocNewData().setValue(new EmbededDocumentInfo.EmbededData(new EmbededDocumentInfo()));
        return;
    L5:
        if (r6.getResult() == null) goto L32;
        if (r6.getResult().getResult() == null) goto L32;
        if ((!r6.getResult().isIs_last()) == true) goto L11;
        getHasPages().setValue(Boolean.FALSE);
    L13:
        if (r6.getResult().getResult().size() <= 0) goto L28;
        if (r6.getResult() != null) goto L17;
    L22:
        ArrayList<EmbededDocumentInfo.NodeInfo> r0 = null;
    L23:
        Iterator<EmbededDocumentInfo.NodeInfo> r1 = r0.iterator();
    L25:
        if (r1.hasNext() == false) goto L28;
        EmbededDocumentInfo.NodeInfo r2 = r1.next();
        this.tokenPermMap.put(r2.getObject_token(), Integer.valueOf(r2.getPerm_type()));
        goto L25
    L17:
        if (r6.getResult().getResult() == null) goto L22;
        if (r6.getResult().getResult().size() <= 0) goto L22;
        r0 = r6.getResult().getResult();
    L28:
        if (r5.isEmpty() == false) goto L30;
        this.documentInfo = r6;
    L31:
        getDocNewData().setValue(r6.getResult());
        return;
    L30:
        this.documentInfo.getResult().setNext_cusor(r6.getResult().getNext_cusor());
        this.documentInfo.getResult().getResult().addAll(r6.getResult().getResult());
        goto L31
    L11:
        getHasPages().setValue(Boolean.TRUE);
        goto L13
    }

    private static /* synthetic */ void lambda$recordAuthorizeState$10(NetService.e r1, Result r2) throws Exception {
        tt5.a.h(TAG, "recordAuthorizeState " + r1.toString());
    }

    private static /* synthetic */ void lambda$updateCardState$12(NetService.e r1, Result r2) throws Exception {
        tt5.a.h(TAG, "updateCardState " + r1);
    }

    private void updateCount(boolean r3, int r4) {
        EmbededDocumentInfo r0 = this.documentInfo;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getResult() == null) goto L14;
        int r1 = this.documentInfo.getResult().getTotal_has_permission();
        int r2 = this.documentInfo.getResult().getTotal_no_permission();
        if (r3 == false) goto L10;
        int r5 = r1 + r4;
        int r6 = r2 - r4;
    L11:
        this.documentInfo.getResult().setTotal_has_permission(r5);
        this.documentInfo.getResult().setTotal_no_permission(r6);
        return;
    L10:
        r6 = r2 + r4;
        r5 = r1 - r4;
        goto L11
    }

    public void batchAuthorize(ArrayList<EmbededDocumentInfo.NodeInfo> r2, final Boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.size() <= 0) goto L15;
        ArrayList<EmbededDocumentInfo.NodeInfo> r4 = ng5.a.a(r2, Boolean.FALSE);
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.size() <= 0) goto L16;
        Flowable.fromIterable(r4).buffer(50).toList().toFlowable().flatMap(new f(this)).observeOn(fo5.d.d()).subscribe(new g(this, r3), new h());
        return;
    L16:
        return;
    }

    public void cancelBatchAuthorize(ArrayList<EmbededDocumentInfo.NodeInfo> r3, final Boolean r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.size() <= 0) goto L15;
        final ArrayList<EmbededDocumentInfo.NodeInfo> r5 = ng5.a.a(r3, Boolean.TRUE);
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.size() <= 0) goto L16;
        Flowable.fromIterable(r5).buffer(50).toList().toFlowable().flatMap(new n(this)).observeOn(fo5.d.d()).subscribe(new b(this, r4, r5), new c());
        return;
    L16:
        return;
    }

    private /* synthetic */ void lambda$cancelBatchAuthorize$8(Boolean r6, ArrayList r7, p r8) throws Exception {
        ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r0 = ng5.a.c(r8);
        if (r0.isEmpty() == false) goto L6;
        ng5.a.g(r8, null, r6);
        getSingleAuthList().setValue(new SingeAuthorizeNode(false, -1, false));
        return;
    L6:
        ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r1 = ng5.a.e(r0);
        if (r1 != null) goto L9;
    L11:
        ArrayList<SingeAuthorizeNode> r2 = ng5.a.i(r0, false, r0.size());
        ng5.a.g(r8, r2, r6);
        if (r7.size() <= 1) goto L15;
        getAuthOperateData().setValue(r2);
    L18:
        tt5.a.h(TAG, "cancelBatchAuthorize ");
        return;
    L15:
        if (r2.size() <= 0) goto L17;
        getSingleAuthList().setValue((SingeAuthorizeNode) ListProtector.get(r2, 0));
        goto L18
    L17:
        getSingleAuthList().setValue(new SingeAuthorizeNode(false, -1, false));
        goto L18
    L9:
        if (r1.size() <= 0) goto L11;
        updateCount(false, r1.size());
        recordAuthorizeState(ng5.a.d(this.tokenPermMap, r1, 0));
        goto L11
    }

    private Flowable<BatchAuthorizeResult> getBatchResult(List<List<EmbededDocumentInfo.NodeInfo>> r8, int r9, String r10, Boolean r11) {
        if (r8 != null) goto L5;
    L25:
        BatchAuthorizeResult r12 = new BatchAuthorizeResult();
        r12.setSuccess(true);
        return Flowable.just(r12);
    L5:
        if (r9 >= r8.size()) goto L25;
        List r13 = (List) ListProtector.get(r8, r9);
        BatchAuthorizeRequest r14 = new BatchAuthorizeRequest();
        ArrayList<BatchAuthorizeRequest.BatchRequestNode> r1 = new ArrayList();
        Iterator r15 = r13.iterator();
    L9:
        if (r15.hasNext() == false) goto L23;
        EmbededDocumentInfo.NodeInfo r2 = (EmbededDocumentInfo.NodeInfo) r15.next();
        BatchAuthorizeRequest.BatchRequestNode r3 = new BatchAuthorizeRequest.BatchRequestNode();
        BatchAuthorizeRequest.Collabrator r4 = new BatchAuthorizeRequest.Collabrator();
        r4.setId(CastLongProtector.parseLong(this.info.getChatId()));
        r4.setEntityType(this.info.getChatType());
        if (r2.getPerm_type() != (-1)) goto L18;
        if (r11.booleanValue() == false) goto L15;
        long r5 = 0;
    L16:
        r4.setRole(r5);
    L22:
        r3.setCollabrator(r4);
        r3.setToken(r2.getObject_token());
        r3.setEntityType(r2.getObject_type() + "");
        r1.add(r3);
        goto L9
    L15:
        r5 = 1;
        goto L16
    L18:
        if (r11.booleanValue() == false) goto L20;
        long r6 = 10;
    L21:
        r4.setRole(r6);
        goto L22
    L20:
        r6 = 11;
        goto L21
    L23:
        r14.setData(r1);
        NetService.d r16 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new mg5.a());
        NetService.f r17 = new NetService.f(r10);
        ((NetService.e) r17).j = JSON.toJSONString(r14);
        ((NetService.e) r17).c = 1;
        return r16.a(r17).onErrorReturn(new a());
    }

    private static /* synthetic */ p lambda$batchAuthorize$2(BatchAuthorizeResult r1, BatchAuthorizeResult r2, BatchAuthorizeResult r3, BatchAuthorizeResult r4) throws Exception {
        return new p(r1, r2, r3, r4);
    }

    private static /* synthetic */ p lambda$cancelBatchAuthorize$6(BatchAuthorizeResult r1, BatchAuthorizeResult r2, BatchAuthorizeResult r3, BatchAuthorizeResult r4) throws Exception {
        return new p(r1, r2, r3, r4);
    }
}
