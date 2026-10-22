package com.bytedance.ee.bear.templates.preview.single.common;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSONObject;
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
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010.\u001a\u00020/2\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u00100\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-J\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%02J\u0015\u00103\u001a\u00020/2\b\u00104\u001a\u0004\u0018\u00010%¢\u0006\u0002\u00105J\f\u00106\u001a\b\u0012\u0004\u0012\u00020(0'J\b\u00107\u001a\u0004\u0018\u00010\u0012J2\u00108\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010\u001f2\u0006\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\u001f2\b\u0010=\u001a\u0004\u0018\u00010\u001fJ\u0016\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020%J\u0010\u0010A\u001a\u00020/2\u0006\u0010?\u001a\u00020(H\u0002J\u0006\u0010B\u001a\u00020/J\u0006\u0010C\u001a\u00020/R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020%0'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/single/common/CommonTemplateViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "Lkotlin/Lazy;", "commonPreviewTemplateView", "Lcom/bytedance/ee/bear/templates/preview/single/common/CommonPreviewTemplateView;", "getCommonPreviewTemplateView", "()Lcom/bytedance/ee/bear/templates/preview/single/common/CommonPreviewTemplateView;", "setCommonPreviewTemplateView", "(Lcom/bytedance/ee/bear/templates/preview/single/common/CommonPreviewTemplateView;)V", "templates", "", "Lcom/bytedance/ee/bear/templates/preview/data/Item;", "getTemplates", "()Ljava/util/List;", "setTemplates", "(Ljava/util/List;)V", "defaultItem", "commonPreviewTemplateData", "Lcom/bytedance/ee/bear/templates/preview/data/CommonPreviewTemplateData;", "getCommonPreviewTemplateData", "()Lcom/bytedance/ee/bear/templates/preview/data/CommonPreviewTemplateData;", "setCommonPreviewTemplateData", "(Lcom/bytedance/ee/bear/templates/preview/data/CommonPreviewTemplateData;)V", ResourceData.KEY_TYPE, "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "creating", "", "currTemplatePos", "Landroidx/lifecycle/MutableLiveData;", "", "previewActive", "customCallBack", "Lcom/bytedance/ee/bear/templates/dto/BinderISelectTemplateCallback$Stub;", "config", "Lcom/bytedance/ee/bear/templates/bean/SelectTemplateConfig;", "setCustomCallback", "", "setCustomConfig", "getPreviewActive", "Landroidx/lifecycle/LiveData;", "setPreviewActive", WikiFolderPushPlugin.DATA, "(Ljava/lang/Boolean;)V", "getCurrTemplatePos", "getCurrTemplate", "initTemplates", "json", "objToken", "objType", "docName", "templateId", "showOtherTemplate", "pos", "last", "setCurrTemplatePos", "loadTemplateDataFromNet", "onBackPressed", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public final /* synthetic */ CommonTemplateViewModel a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;

        public b(CommonTemplateViewModel r1, int r2, String r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // com.bytedance.ee.bear.templates.TemplateUtils.a
        public final void onResult(String r7) {
            Intrinsics.checkNotNullParameter(r7, "previewUrl");
            Integer r0 = (Integer) this.a.getCurrTemplatePos().getValue();
            int r1 = this.b;
            if (r0 != null) goto L6;
        L7:
            tt5.a.h(CommonTemplateViewModel.TAG, "showOtherTemplate ignored stale preview url. pos:" + this.b + " current:" + this.a.getCurrTemplatePos().getValue());
            return;
        L6:
            if (r0.intValue() != r1) goto L7;
            Item r2 = this.a.getCurrTemplate();
            String r3 = null;
            if (r2 != null) goto L12;
        L31:
            StringBuilder r8 = new StringBuilder("showOtherTemplate ignored stale preview url. token:");
            r8.append(this.c);
            r8.append(" current:");
            if (r2 == null) goto L34;
            r3 = r2.getObjToken();
        L34:
            r8.append(r3);
            tt5.a.h(CommonTemplateViewModel.TAG, r8.toString());
            return;
        L12:
            if (Intrinsics.areEqual(r2.getObjToken(), this.c) == false) goto L31;
            if (r2.getObjType() != this.d) goto L31;
            CommonPreviewTemplateData r4 = this.a.getCommonPreviewTemplateData();
            if (r4 == null) goto L19;
            String r5 = r4.getTemplateSource();
        L21:
            if (h.a(r5) == true) goto L23;
        L25:
            Bundle r6 = new Bundle();
            r6.putBoolean(CommonTemplateViewModel.BACK_STACK_MARK, false);
            RouteBean r9 = new RouteBean();
            r9.n = r6;
            if (((Boolean) TemplateUtils.b.getValue()).booleanValue() == false) goto L28;
            String r10 = "";
        L29:
            r9.j = r10;
            r9.r = true;
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(r7, r9);
            return;
        L28:
            r10 = "scene_template";
            goto L29
        L23:
            if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.larkform.new.enable") == false) goto L25;
            r7 = com.bytedance.ee.util.io.e.a(com.bytedance.ee.util.io.e.a(r7, "larkForm", "1"), "isTemplatePreview", "true");
            goto L25
        L19:
            r5 = null;
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
        List<Item> r0 = this.templates;
        Integer r1 = (Integer) this.currTemplatePos.getValue();
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L9:
        return (Item) ListProtector.get(r0, r2);
    L7:
        r2 = 0;
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
        Item r0 = getCurrTemplate();
        if (r0 != null) goto L7;
        tt5.a.h(TAG, "template == null");
        return;
    L7:
        if (r0.isBusinessTemplate() == false) goto L9;
    L10:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L15;
        BaseEntity r1 = new BaseEntity(r0.getObjToken(), sbb.e.d(r0.getObjType()), BizDomain.FileBizDomainCCM, "");
        PermissionResponse r2 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r1, "CREATE_COPY"), null);
        r2.getCallback().a(eu5.b.a, r2);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r2) == false) goto L22;
        return;
    L22:
        if (this.customCallBack != null) goto L24;
        e r3 = new d();
    L25:
        Disposable r4 = r3.a(r0, this.commonPreviewTemplateData, this.previewActive);
        if (r4 == null) goto L28;
        getCompositeDisposable().add(r4);
    L28:
        Lazy r5 = CommonTemplatePreviewAnalytic.a;
        CommonPreviewTemplateData r6 = this.commonPreviewTemplateData;
        Intrinsics.checkNotNullParameter(r0, "item");
        JSONObject r7 = CommonTemplatePreviewAnalytic.a(r0, r6);
        r7.put("click_type", "use_click");
        CommonTemplatePreviewAnalytic.b().o("ccm_template_preview_view_click", r7, r0.checkToken());
        return;
    L24:
        r3 = new CustomTemplateCreator(this.customCallBack, this.config);
        goto L25
    L15:
        gj5.b r8 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        FileBizDomain r9 = FileBizDomain.FileBizDomainCCM;
        gj5.c r10 = r8.g("CCM_CREATE_COPY", r9, r0.getObjType(), r0.getObjToken());
        if (r10.a == true) goto L22;
        if (r10.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L22;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_CREATE_COPY", r9, r0.getObjType(), r0.getObjToken());
        return;
    L9:
        if (r0.isCustomTemplate() == false) goto L22;
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

    private final void setCurrTemplatePos(int r2) {
        getCurrTemplatePos().setValue(Integer.valueOf(r2));
    }

    public final void setCommonPreviewTemplateData(CommonPreviewTemplateData r1) {
        this.commonPreviewTemplateData = r1;
    }

    public final void setCommonPreviewTemplateView(CommonPreviewTemplateView r1) {
        this.commonPreviewTemplateView = r1;
    }

    public final void setCustomCallback(BinderISelectTemplateCallback.Stub r1) {
        this.customCallBack = r1;
    }

    public final void setCustomConfig(SelectTemplateConfig r1) {
        this.config = r1;
    }

    public final void setPreviewActive(Boolean r2) {
        this.previewActive.setValue(r2);
    }

    public final void setTemplates(List<Item> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.templates = r2;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    public final boolean showOtherTemplate(int r10, boolean r11) {
        if (r10 >= 0) goto L4;
    L18:
        tt5.a.h(TAG, "showOtherTemplate pos is illegal");
        return false;
    L4:
        if (r10 >= this.templates.size()) goto L18;
        setCurrTemplatePos(r10);
        Item r0 = (Item) ListProtector.get(this.templates, r10);
        String r1 = r0.getObjToken();
        int r2 = r0.getObjType();
        TemplateUtils r3 = TemplateUtils.a;
        int r4 = r0.getObjType();
        String r5 = r0.getObjToken();
        String r6 = this.type;
        b r7 = new b(this, r10, r1, r2);
        r3.getClass();
        TemplateUtils.c(r4, r5, r6, r7);
        if (r11 == false) goto L12;
        Lazy r12 = CommonTemplatePreviewAnalytic.a;
        CommonPreviewTemplateData r13 = this.commonPreviewTemplateData;
        Intrinsics.checkNotNullParameter(r0, "item");
        JSONObject r8 = new JSONObject();
        r8.put("click_type", "last");
        r8.put("template_token", r0.getReportToken());
        r8.put("template_name", r0.getReportName());
        r8.put("target", "ccm_template_preview_view");
        if (r13 == null) goto L11;
        r8.put("template_source", r13.getTemplateSource());
    L11:
        CommonTemplatePreviewAnalytic.b().o("ccm_template_preview_view_click", r8, r0.checkToken());
        return true;
    L12:
        Lazy r14 = CommonTemplatePreviewAnalytic.a;
        CommonPreviewTemplateData r15 = this.commonPreviewTemplateData;
        Intrinsics.checkNotNullParameter(r0, "item");
        JSONObject r9 = new JSONObject();
        r9.put("click_type", "next");
        r9.put("template_token", r0.getReportToken());
        r9.put("template_name", r0.getReportName());
        r9.put("target", "ccm_template_preview_view");
        if (r15 == null) goto L15;
        r9.put("template_source", r15.getTemplateSource());
    L15:
        CommonTemplatePreviewAnalytic.b().o("ccm_template_preview_view_click", r9, r0.checkToken());
        return true;
    }

    public final void initTemplates(String r9, String r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "objToken");
        Intrinsics.checkNotNullParameter(r12, "docName");
        this.defaultItem = new Item(r10, r12, r11, 2, 0, r13);
        if (r9 != null) goto L5;
        return;
    L5:
        CommonPreviewTemplateData r14 = (CommonPreviewTemplateData) z.a(r9, CommonPreviewTemplateData.class);
        this.commonPreviewTemplateData = r14;
        if (r14 == null) goto L9;
        this.templates.addAll(r14.getList());
        setCurrTemplatePos(r14.getInitIndex());
        return;
    }
}
