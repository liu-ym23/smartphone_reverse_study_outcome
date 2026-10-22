package com.bytedance.ee.bear.templates.recommend;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.contract.AnalyticConstant$OpenType;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.create.m;
import com.bytedance.ee.bear.list.create.q0;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.templates.TemplateReport;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends BasePresenter<com.bytedance.ee.bear.templates.recommend.a, com.bytedance.ee.bear.templates.recommend.b, com.bytedance.ee.bear.templates.recommend.b.a> implements com.bytedance.ee.bear.templates.recommend.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f239268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f239269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f239270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f239271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f239272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f239273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CreateSelectResult f239274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f239275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f239276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f239277j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f239278a;

        public b(g r100) {
            this.f239278a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            RecommendTemplates r101 = (RecommendTemplates) r100;
            if (r101.getSource() == 2) goto L5;
        L9:
            this.f239278a.f239277j = !r101.getTemplates().isEmpty();
            this.f239278a.getView().T7(r101.getTemplates());
            return;
        L5:
            if (r101.getErr() == null) goto L9;
            g r102 = this.f239278a;
            if (r102.f239277j == true) goto L11;
            r102.getView().E(r101.getErr());
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f239279a;

        public c(g r100) {
            this.f239279a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "t");
            this.f239279a.getView().E(r101);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f239280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TemplateV4 f239281b;

        public d(g r100, TemplateV4 r101) {
            this.f239280a = r100;
            this.f239281b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            DocumentCreateInfo r100 = (DocumentCreateInfo) r210;
            Intrinsics.checkNotNullParameter(r100, "documentCreateInfo");
            tt5.a.h("NewRecommendTemplatePresenter", "create template success");
            this.f239280a.getView().c0();
            this.f239280a.getModel().n7(this.f239281b, true);
            Context r101 = this.f239280a.f239268a.getContext();
            String r102 = this.f239280a.f239269b;
            if (TextUtils.isEmpty(r102) == false) goto L6;
        L22:
            String r103 = "";
        L26:
            q0.e(new com.bytedance.ee.bear.list.create.b(r101, "space_template", r103, r100.f216950d, r100));
            lc5.f.a r104 = lc5.f.f508440a;
            g r105 = this.f239280a;
            String r110 = r105.f239269b;
            String r111 = r105.f239270c;
            String r112 = r105.f239271d;
            String r113 = r100.f216948b;
            String r114 = this.f239281b.getId();
            String r115 = this.f239281b.getObjToken();
            String r116 = this.f239281b.getName();
            TemplateReportV2 r106 = TemplateReportV2.f238768a;
            lc5.j r107 = new lc5.j(r110, r111, r112, r113, r114, r115, r116, TemplateReportV2.b(this.f239281b), r100.f216952f, this.f239281b.getObjType());
            Intrinsics.checkNotNullParameter(r107, "clickParam");
            JSONObject r108 = new JSONObject();
            lc5.f.a.b(r104, new lc5.g(r108, r107.f508461a, r107.f508462b, r107.f508465e, r107.getType(), "", r107.f508464d, DocumentType.FOLDER_NAME, null));
            r108.put("click", r107.f508463c);
            r108.put(PickerReporterConstants.KEY.TARGET, "ccm_docs_page_view");
            String r109 = r107.f508466f;
            if (r109 == null) goto L29;
            r108.put("templates_id", r109);
        L29:
            String r117 = r107.f508467g;
            if (r117 == null) goto L32;
            r108.put("template_token", r117);
        L32:
            String r118 = r107.f508468h;
            if (r118 == null) goto L35;
            r108.put("template_name", r118);
        L35:
            String r119 = r107.f508469i;
            if (r119 == null) goto L38;
            r108.put("template_type", r119);
        L38:
            r108.put("create_file_type", r107.f508470j);
            com.bytedance.ee.bear.contract.d r120 = lc5.f.a.d();
            if (r120 == null) goto L42;
            r120.r("ccm_space_create_new_click", r108, "", false);
            return;
        L42:
            return;
        L6:
            if (Intrinsics.areEqual("home", r102) == false) goto L9;
            String r121 = AnalyticConstant$OpenType.HOME_CREATE_TEMPLATE.getType();
            Intrinsics.checkNotNull(r121);
        L25:
            r103 = r121;
            goto L26
        L9:
            if (Intrinsics.areEqual(WikiSpaceType.PERSONAL, r102) == false) goto L11;
        L24:
            r121 = AnalyticConstant$OpenType.PERSONAL_CREATE_TEMPLATE.getType();
            Intrinsics.checkNotNull(r121);
            goto L25
        L11:
            if (Intrinsics.areEqual("personal_subfolder", r102) == true) goto L24;
            if (Intrinsics.areEqual("personal_folder_root", r102) == true) goto L24;
            if (Intrinsics.areEqual("shared", r102) == false) goto L18;
        L23:
            r121 = AnalyticConstant$OpenType.SHARED_CREATE_TEMPLATE.getType();
            Intrinsics.checkNotNull(r121);
            goto L25
        L18:
            if (Intrinsics.areEqual("shared_subfolder", r102) == true) goto L23;
            if (Intrinsics.areEqual("shared_folder_root", r102) == false) goto L22;
            goto L22
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f239282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TemplateV4 f239283b;

        public e(g r100, TemplateV4 r101) {
            this.f239282a = r100;
            this.f239283b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            tt5.a.d("NewRecommendTemplatePresenter", "create template failed, throwable = " + r101);
            this.f239282a.getView().c0();
            g r102 = this.f239282a;
            m r103 = new m(r102.f239271d, r102.f239269b, "docs_manage", false);
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.f499003a.g() == false) goto L7;
            ErrorResponse r104 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).e(this.f239283b.getObjToken(), Integer.valueOf(this.f239283b.getObjType()), "CREATE_COPY", r101);
            if (r104.getHasHandledUiAction() == false) goto L10;
            r104.getCallback().a(eu5.b.f474075a, r104);
            return;
        L10:
            q0.d(new com.bytedance.ee.bear.list.create.b(this.f239282a.f239268a.getContext(), r103, sbb.e.c(this.f239283b.getObjType())), r101, this.f239282a.f239268a.getString(R.string.Doc_List_TemplateLoadingFailedToast));
            return;
        L7:
            String r105 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).f(this.f239283b.getObjToken(), "CCM_CREATE_COPY", k0.a(r101));
            if (TextUtils.isEmpty(r105) == true) goto L10;
            Toast.showFailureText(eu5.b.f474075a, r105);
        }
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b.a
    public final void o() {
        Fragment r100 = this.f239268a;
        if (r100 == null) goto L7;
        Fragment r101 = r100.getParentFragment();
        if (r101 == null) goto L7;
        Fragment r102 = r101.getParentFragment();
    L9:
        if ((r102 instanceof DialogFragment) == false) goto L21;
        Fragment r103 = this.f239268a.getParentFragment();
        if (r103 == null) goto L13;
        Fragment r104 = r103.getParentFragment();
    L14:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
        ((DialogFragment) r104).dismissAllowingStateLoss();     // Catch: Exception -> L17
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L21;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L21
    L13:
        r104 = null;
    L21:
        Bundle r106 = new Bundle();
        r106.putParcelable("CREATION_LOCATION", this.f239274g);
        r106.putString("SPACE_ID", this.f239275h);
        r106.putString("MODULE", this.f239269b);
        r106.putString("ROOT_TOKEN", this.f239271d);
        r106.putString("enterSource", "create_new_more");
        r106.putString("template_source", "create_new_more");
        RouteBean r107 = new RouteBean();
        r107.a(this.f239268a);
        r107.f236649n = r106;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).yd("/list/template4/activity", r107).h(r106).e();
        TemplateReport.c("from_newcreate_more");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).a("click_template_more_button", new JSONObject());
        jw4.a.c(new jw4.d((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), "template_more", null, this.f239269b, this.f239272e, this.f239273f));
        lc5.f.f508440a.C(new tc5.a(this.f239269b, this.f239270c, "templates_more", "ccm_template_systemcenter_view", this.f239271d, sbb.e.f541294e.f541317b));
        return;
    L7:
        r102 = null;
        goto L9
    }

    public final void H8() {
        Disposable r100 = getModel().K().subscribe(new b(this), new c(this));
        ((CompositeDisposable) this.f239276i.getValue()).add(r100);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        getView().d();
        H8();
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(this.f239268a, new h(this));
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        if (((CompositeDisposable) this.f239276i.getValue()).isDisposed() == true) goto L6;
        ((CompositeDisposable) this.f239276i.getValue()).dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b.a
    public final void L(int r110, TemplateV4 r111) {
        Intrinsics.checkNotNullParameter(r111, ThumbGlideUrl.SOURCE_TEMPLATE);
        tt5.a.b("NewRecommendTemplatePresenter", "onTemplateSelected()...template = " + r111);
        com.bytedance.ee.bear.contract.d r100 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        r100.h("add_doc");
        r100.j("add_doc", EventConstant.Key.MODULE, this.f239269b);
        ConnectionService.NetworkState r101 = com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState();
        boolean r102 = !r101.a();
        if (r111.getEnable() == true) goto L7;
        if (r102 == false) goto L7;
        tt5.a.h("NewRecommendTemplatePresenter", "create template offline, state:" + r101 + ", template enable: " + r111.getEnable());
        Toast.showFailureText(this.f239268a.getContext(), R.string.Doc_List_NoInternetClickMoreToast);
        return;
    L7:
        getView().k0();
        ((CompositeDisposable) this.f239276i.getValue()).add(getModel().x6(r111, this.f239271d, this.f239269b, this.f239275h, this.f239274g).timeout(15, TimeUnit.SECONDS).observeOn(fo5.d.d()).subscribe(new d(this, r111), new e(this, r111)));
        jw4.a.c(new jw4.d((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), ThumbGlideUrl.SOURCE_TEMPLATE + (r110 + 1), null, this.f239269b, this.f239272e, this.f239273f));
    }

    public g(NewRecommendTemplateModel r100, i r101, Fragment r102, String r103, String r104, String r105, CreateSelectResult r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r103, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r104, "subModule");
        Intrinsics.checkNotNullParameter(r105, "parentToken");
        Intrinsics.checkNotNullParameter(r106, "createSelectResult");
        Intrinsics.checkNotNullParameter(r107, "spaceId");
        super(r100, r101);
        this.f239268a = r102;
        this.f239269b = r103;
        this.f239270c = r104;
        this.f239271d = r105;
        this.f239272e = false;
        this.f239273f = false;
        this.f239274g = r106;
        this.f239275h = r107;
        this.f239276i = LazyKt.lazy(NewRecommendTemplatePresenter$compositeDisposable$2.INSTANCE);
    }
}
