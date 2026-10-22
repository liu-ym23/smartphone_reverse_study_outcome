package com.bytedance.ee.bear.templates.preview.single.common;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.templates.bean.SelectTemplateConfig;
import com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback;
import com.bytedance.ee.bear.templates.h;
import com.bytedance.ee.bear.templates.preview.data.CommonPreviewTemplateData;
import com.bytedance.ee.bear.templates.preview.data.Item;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.z;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010.\u001a\u00020/2\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u00100\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-J\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%02J\u0015\u00103\u001a\u00020/2\b\u00104\u001a\u0004\u0018\u00010%¢\u0006\u0002\u00105J\f\u00106\u001a\b\u0012\u0004\u0012\u00020(0'J\b\u00107\u001a\u0004\u0018\u00010\u0012J2\u00108\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010\u001f2\u0006\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\u001f2\b\u0010=\u001a\u0004\u0018\u00010\u001fJ\u0016\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020%J\u0010\u0010A\u001a\u00020/2\u0006\u0010?\u001a\u00020(H\u0002J\u0006\u0010B\u001a\u00020/J\u0006\u0010C\u001a\u00020/R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020%0'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/single/common/CommonTemplateViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "Lkotlin/Lazy;", "commonPreviewTemplateView", "Lcom/bytedance/ee/bear/templates/preview/single/common/CommonPreviewTemplateView;", "getCommonPreviewTemplateView", "()Lcom/bytedance/ee/bear/templates/preview/single/common/CommonPreviewTemplateView;", "setCommonPreviewTemplateView", "(Lcom/bytedance/ee/bear/templates/preview/single/common/CommonPreviewTemplateView;)V", "templates", "", "Lcom/bytedance/ee/bear/templates/preview/data/Item;", "getTemplates", "()Ljava/util/List;", "setTemplates", "(Ljava/util/List;)V", "defaultItem", "commonPreviewTemplateData", "Lcom/bytedance/ee/bear/templates/preview/data/CommonPreviewTemplateData;", "getCommonPreviewTemplateData", "()Lcom/bytedance/ee/bear/templates/preview/data/CommonPreviewTemplateData;", "setCommonPreviewTemplateData", "(Lcom/bytedance/ee/bear/templates/preview/data/CommonPreviewTemplateData;)V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "creating", "", "currTemplatePos", "Landroidx/lifecycle/MutableLiveData;", "", "previewActive", "customCallBack", "Lcom/bytedance/ee/bear/templates/dto/BinderISelectTemplateCallback$Stub;", "config", "Lcom/bytedance/ee/bear/templates/bean/SelectTemplateConfig;", "setCustomCallback", "", "setCustomConfig", "getPreviewActive", "Landroidx/lifecycle/LiveData;", "setPreviewActive", "data", "(Ljava/lang/Boolean;)V", "getCurrTemplatePos", "getCurrTemplate", "initTemplates", "json", "objToken", "objType", "docName", GXTemplateKey.GAIAX_TEMPLATE_ID, "showOtherTemplate", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "last", "setCurrTemplatePos", "loadTemplateDataFromNet", "onBackPressed", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonTemplateViewModel extends ViewModel {
    private static final String BACK_STACK_MARK = "addToBackStack";
    public static final a Companion = null;
    public static final String TAG = "CommonTemplateViewModel";
    private CommonPreviewTemplateData commonPreviewTemplateData;
    private CommonPreviewTemplateView commonPreviewTemplateView;
    private final Lazy compositeDisposable$delegate;
    private SelectTemplateConfig config;
    private boolean creating;
    private MutableLiveData<Integer> currTemplatePos;
    private BinderISelectTemplateCallback.Stub customCallBack;
    private Item defaultItem;
    private MutableLiveData<Boolean> previewActive;
    private List<Item> templates;
    private String type;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements TemplateUtils.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonTemplateViewModel f239210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f239211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f239212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f239213d;

        public b(CommonTemplateViewModel r100, int r101, String r102, int r103) {
            this.f239210a = r100;
            this.f239211b = r101;
            this.f239212c = r102;
            this.f239213d = r103;
        }

        @Override // com.bytedance.ee.bear.templates.TemplateUtils.a
        public final void onResult(String r100) {
            Intrinsics.checkNotNullParameter(r100, "previewUrl");
            Integer r101 = this.f239210a.getCurrTemplatePos().getValue();
            int r102 = this.f239211b;
            if (r101 != null) goto L6;
        L7:
            tt5.a.h(CommonTemplateViewModel.TAG, "showOtherTemplate ignored stale preview url. pos:" + this.f239211b + " current:" + this.f239210a.getCurrTemplatePos().getValue());
            return;
        L6:
            if (r101.intValue() != r102) goto L7;
            Item r103 = this.f239210a.getCurrTemplate();
            String r104 = null;
            if (r103 != null) goto L12;
        L31:
            StringBuilder r105 = new StringBuilder("showOtherTemplate ignored stale preview url. token:");
            r105.append(this.f239212c);
            r105.append(" current:");
            if (r103 == null) goto L34;
            r104 = r103.getObjToken();
        L34:
            r105.append(r104);
            tt5.a.h(CommonTemplateViewModel.TAG, r105.toString());
            return;
        L12:
            if (Intrinsics.areEqual(r103.getObjToken(), this.f239212c) == false) goto L31;
            if (r103.getObjType() != this.f239213d) goto L31;
            CommonPreviewTemplateData r106 = this.f239210a.getCommonPreviewTemplateData();
            if (r106 == null) goto L19;
            String r107 = r106.getTemplateSource();
        L21:
            if (h.a(r107) == true) goto L23;
        L25:
            Bundle r108 = new Bundle();
            r108.putBoolean(CommonTemplateViewModel.BACK_STACK_MARK, false);
            RouteBean r109 = new RouteBean();
            r109.f236649n = r108;
            if (((Boolean) TemplateUtils.f238777b.getValue()).booleanValue() == false) goto L28;
            String r110 = "";
        L29:
            r109.f236645j = r110;
            r109.f236653r = true;
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(r100, r109);
            return;
        L28:
            r110 = "scene_template";
            goto L29
        L23:
            if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.larkform.new.enable") == false) goto L25;
            r100 = com.bytedance.ee.util.io.e.a(com.bytedance.ee.util.io.e.a(r100, "larkForm", "1"), "isTemplatePreview", "true");
            goto L25
        L19:
            r107 = null;
            goto L21
        }
    }

    static {
        Companion = new a();
    }

    private final CompositeDisposable getCompositeDisposable() {
        return (CompositeDisposable) this.compositeDisposable$delegate.getValue();
    }

    public final Item getCurrTemplate() {
        if (this.templates.size() <= 0) goto L11;
        List<Item> r100 = this.templates;
        Integer r101 = this.currTemplatePos.getValue();
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L9:
        return (Item) ListProtector.get(r100, r102);
    L7:
        r102 = 0;
        goto L9
    L11:
        return this.defaultItem;
    }

    public CommonTemplateViewModel() {
        this.compositeDisposable$delegate = LazyKt.lazy(CommonTemplateViewModel$compositeDisposable$2.INSTANCE);
        this.templates = new ArrayList();
        this.currTemplatePos = new MutableLiveData(-1);
        this.previewActive = new MutableLiveData();
    }

    public final void loadTemplateDataFromNet() {
        Item r100 = getCurrTemplate();
        if (r100 != null) goto L7;
        tt5.a.h(TAG, "template == null");
        return;
    L7:
        if (r100.isBusinessTemplate() == false) goto L9;
    L10:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L15;
        BaseEntity r101 = new BaseEntity(r100.getObjToken(), sbb.e.d(r100.getObjType()), BizDomain.FileBizDomainCCM, "");
        PermissionResponse r102 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r101, "CREATE_COPY"), null);
        r102.getCallback().a(eu5.b.f474075a, r102);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r102) == false) goto L22;
        return;
    L22:
        if (this.customCallBack != null) goto L24;
        e r103 = new d();
    L25:
        Disposable r104 = r103.a(r100, this.commonPreviewTemplateData, this.previewActive);
        if (r104 == null) goto L28;
        getCompositeDisposable().add(r104);
    L28:
        Lazy r105 = CommonTemplatePreviewAnalytic.f239205a;
        CommonPreviewTemplateData r106 = this.commonPreviewTemplateData;
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        JSONObject r107 = CommonTemplatePreviewAnalytic.a(r100, r106);
        r107.put2("click_type", "use_click");
        CommonTemplatePreviewAnalytic.b().o("ccm_template_preview_view_click", r107, r100.checkToken());
        return;
    L24:
        r103 = new CustomTemplateCreator(this.customCallBack, this.config);
        goto L25
    L15:
        gj5.b r108 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        FileBizDomain r109 = FileBizDomain.FileBizDomainCCM;
        gj5.c r110 = r108.g("CCM_CREATE_COPY", r109, r100.getObjType(), r100.getObjToken());
        if (r110.f481503a == true) goto L22;
        if (r110.f481504b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L22;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_CREATE_COPY", r109, r100.getObjType(), r100.getObjToken());
        return;
    L9:
        if (r100.isCustomTemplate() == false) goto L22;
        goto L10
    }

    public final void onBackPressed() {
        getCompositeDisposable().dispose();
    }

    public final CommonPreviewTemplateData getCommonPreviewTemplateData() {
        return this.commonPreviewTemplateData;
    }

    public final CommonPreviewTemplateView getCommonPreviewTemplateView() {
        return this.commonPreviewTemplateView;
    }

    public final MutableLiveData<Integer> getCurrTemplatePos() {
        return this.currTemplatePos;
    }

    public final LiveData<Boolean> getPreviewActive() {
        return this.previewActive;
    }

    public final List<Item> getTemplates() {
        return this.templates;
    }

    public final String getType() {
        return this.type;
    }

    private final void setCurrTemplatePos(int r100) {
        getCurrTemplatePos().setValue(Integer.valueOf(r100));
    }

    public final void setCommonPreviewTemplateData(CommonPreviewTemplateData r100) {
        this.commonPreviewTemplateData = r100;
    }

    public final void setCommonPreviewTemplateView(CommonPreviewTemplateView r100) {
        this.commonPreviewTemplateView = r100;
    }

    public final void setCustomCallback(BinderISelectTemplateCallback.Stub r100) {
        this.customCallBack = r100;
    }

    public final void setCustomConfig(SelectTemplateConfig r100) {
        this.config = r100;
    }

    public final void setPreviewActive(Boolean r100) {
        this.previewActive.setValue(r100);
    }

    public final void setTemplates(List<Item> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templates = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public final boolean showOtherTemplate(int r110, boolean r111) {
        if (r110 >= 0) goto L4;
    L18:
        tt5.a.h(TAG, "showOtherTemplate pos is illegal");
        return false;
    L4:
        if (r110 >= this.templates.size()) goto L18;
        setCurrTemplatePos(r110);
        Item r100 = (Item) ListProtector.get(this.templates, r110);
        String r101 = r100.getObjToken();
        int r102 = r100.getObjType();
        TemplateUtils r103 = TemplateUtils.f238776a;
        int r104 = r100.getObjType();
        String r105 = r100.getObjToken();
        String r106 = this.type;
        b r107 = new b(this, r110, r101, r102);
        r103.getClass();
        TemplateUtils.c(r104, r105, r106, r107);
        if (r111 == false) goto L12;
        Lazy r112 = CommonTemplatePreviewAnalytic.f239205a;
        CommonPreviewTemplateData r113 = this.commonPreviewTemplateData;
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        JSONObject r108 = new JSONObject();
        r108.put2("click_type", "last");
        r108.put2("template_token", r100.getReportToken());
        r108.put2("template_name", r100.getReportName());
        r108.put2(PickerReporterConstants.KEY.TARGET, "ccm_template_preview_view");
        if (r113 == null) goto L11;
        r108.put2("template_source", r113.getTemplateSource());
    L11:
        CommonTemplatePreviewAnalytic.b().o("ccm_template_preview_view_click", r108, r100.checkToken());
        return true;
    L12:
        Lazy r114 = CommonTemplatePreviewAnalytic.f239205a;
        CommonPreviewTemplateData r115 = this.commonPreviewTemplateData;
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        JSONObject r109 = new JSONObject();
        r109.put2("click_type", TeaEventTrack.ACTION_DRAMA_NEXT);
        r109.put2("template_token", r100.getReportToken());
        r109.put2("template_name", r100.getReportName());
        r109.put2(PickerReporterConstants.KEY.TARGET, "ccm_template_preview_view");
        if (r115 == null) goto L15;
        r109.put2("template_source", r115.getTemplateSource());
    L15:
        CommonTemplatePreviewAnalytic.b().o("ccm_template_preview_view_click", r109, r100.checkToken());
        return true;
    }

    public final void initTemplates(String r100, String r110, int r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "objToken");
        Intrinsics.checkNotNullParameter(r112, "docName");
        this.defaultItem = new Item(r110, r112, r111, 2, 0, r113);
        if (r100 != null) goto L5;
        return;
    L5:
        CommonPreviewTemplateData r101 = (CommonPreviewTemplateData) z.a(r100, CommonPreviewTemplateData.class);
        this.commonPreviewTemplateData = r101;
        if (r101 == null) goto L9;
        this.templates.addAll(r101.getList());
        setCurrTemplatePos(r101.getInitIndex());
        return;
    }
}
