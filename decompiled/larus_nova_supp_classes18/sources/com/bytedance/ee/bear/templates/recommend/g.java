package com.bytedance.ee.bear.templates.recommend;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.contract.AnalyticConstant;
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
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends BasePresenter<com.bytedance.ee.bear.templates.recommend.a, com.bytedance.ee.bear.templates.recommend.b, com.bytedance.ee.bear.templates.recommend.b.a> implements com.bytedance.ee.bear.templates.recommend.b.a {
    public final Fragment a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final CreateSelectResult g;
    public final String h;
    public final Lazy i;
    public boolean j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            RecommendTemplates r4 = (RecommendTemplates) r3;
            if (r4.getSource() == 2) goto L5;
        L9:
            this.a.j = !r4.getTemplates().isEmpty();
            ((com.bytedance.ee.bear.templates.recommend.b) this.a.getView()).T7(r4.getTemplates());
            return;
        L5:
            if (r4.getErr() == null) goto L9;
            g r0 = this.a;
            if (r0.j == true) goto L11;
            ((com.bytedance.ee.bear.templates.recommend.b) r0.getView()).E(r4.getErr());
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ g a;

        public c(g r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "t");
            ((com.bytedance.ee.bear.templates.recommend.b) this.a.getView()).E(r3);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ TemplateV4 b;

        public d(g r1, TemplateV4 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r22) {
            DocumentCreateInfo r7 = (DocumentCreateInfo) r22;
            Intrinsics.checkNotNullParameter(r7, "documentCreateInfo");
            tt5.a.h("NewRecommendTemplatePresenter", "create template success");
            ((com.bytedance.ee.bear.templates.recommend.b) this.a.getView()).c0();
            ((com.bytedance.ee.bear.templates.recommend.a) this.a.getModel()).n7(this.b, true);
            Context r2 = this.a.a.getContext();
            String r1 = this.a.b;
            if (TextUtils.isEmpty(r1) == false) goto L6;
        L22:
            String r4 = "";
        L26:
            q0.e(new com.bytedance.ee.bear.list.create.b(r2, "space_template", r4, r7.d, r7));
            lc5.f.a r3 = lc5.f.a;
            g r5 = this.a;
            String r11 = r5.b;
            String r12 = r5.c;
            String r13 = r5.d;
            String r14 = r7.b;
            String r15 = this.b.getId();
            String r16 = this.b.getObjToken();
            String r17 = this.b.getName();
            TemplateReportV2 r6 = TemplateReportV2.a;
            lc5.j r8 = new lc5.j(r11, r12, r13, r14, r15, r16, r17, TemplateReportV2.b(this.b), r7.f, this.b.getObjType());
            Intrinsics.checkNotNullParameter(r8, "clickParam");
            JSONObject r9 = new JSONObject();
            lc5.f.a.b(r3, new lc5.g(r9, r8.a, r8.b, r8.e, r8.getType(), "", r8.d, DocumentType.FOLDER_NAME, null));
            r9.put("click", r8.c);
            r9.put("target", "ccm_docs_page_view");
            String r10 = r8.f;
            if (r10 == null) goto L29;
            r9.put("templates_id", r10);
        L29:
            String r18 = r8.g;
            if (r18 == null) goto L32;
            r9.put("template_token", r18);
        L32:
            String r19 = r8.h;
            if (r19 == null) goto L35;
            r9.put("template_name", r19);
        L35:
            String r20 = r8.i;
            if (r20 == null) goto L38;
            r9.put("template_type", r20);
        L38:
            r9.put("create_file_type", r8.j);
            com.bytedance.ee.bear.contract.d r21 = lc5.f.a.d();
            if (r21 == null) goto L42;
            r21.r("ccm_space_create_new_click", r9, "", false);
            return;
        L42:
            return;
        L6:
            if (Intrinsics.areEqual("home", r1) == false) goto L9;
            String r23 = AnalyticConstant.OpenType.HOME_CREATE_TEMPLATE.getType();
            Intrinsics.checkNotNull(r23);
        L25:
            r4 = r23;
            goto L26
        L9:
            if (Intrinsics.areEqual(WikiSpaceType.PERSONAL, r1) == false) goto L11;
        L24:
            r23 = AnalyticConstant.OpenType.PERSONAL_CREATE_TEMPLATE.getType();
            Intrinsics.checkNotNull(r23);
            goto L25
        L11:
            if (Intrinsics.areEqual("personal_subfolder", r1) == true) goto L24;
            if (Intrinsics.areEqual("personal_folder_root", r1) == true) goto L24;
            if (Intrinsics.areEqual("shared", r1) == false) goto L18;
        L23:
            r23 = AnalyticConstant.OpenType.SHARED_CREATE_TEMPLATE.getType();
            Intrinsics.checkNotNull(r23);
            goto L25
        L18:
            if (Intrinsics.areEqual("shared_subfolder", r1) == true) goto L23;
            if (Intrinsics.areEqual("shared_folder_root", r1) == false) goto L22;
            goto L22
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ TemplateV4 b;

        public e(g r1, TemplateV4 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            Intrinsics.checkNotNullParameter(r7, "throwable");
            tt5.a.d("NewRecommendTemplatePresenter", "create template failed, throwable = " + r7);
            ((com.bytedance.ee.bear.templates.recommend.b) this.a.getView()).c0();
            g r1 = this.a;
            m r0 = new m(r1.d, r1.b, "docs_manage", false);
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == false) goto L7;
            ErrorResponse r2 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).e(this.b.getObjToken(), Integer.valueOf(this.b.getObjType()), "CREATE_COPY", r7);
            if (r2.getHasHandledUiAction() == false) goto L10;
            r2.getCallback().a(eu5.b.a, r2);
            return;
        L10:
            q0.d(new com.bytedance.ee.bear.list.create.b(this.a.a.getContext(), r0, sbb.e.c(this.b.getObjType())), r7, this.a.a.getString(2131887996));
            return;
        L7:
            String r3 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).f(this.b.getObjToken(), "CCM_CREATE_COPY", k0.a(r7));
            if (TextUtils.isEmpty(r3) == true) goto L10;
            Toast.showFailureText(eu5.b.a, r3);
        }
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b.a
    public final void o() {
        Fragment r0 = this.a;
        if (r0 == null) goto L7;
        Fragment r1 = r0.getParentFragment();
        if (r1 == null) goto L7;
        Fragment r2 = r1.getParentFragment();
    L9:
        if ((r2 instanceof DialogFragment) == false) goto L21;
        Fragment r3 = this.a.getParentFragment();
        if (r3 == null) goto L13;
        Fragment r4 = r3.getParentFragment();
    L14:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
        ((DialogFragment) r4).dismissAllowingStateLoss();     // Catch: Exception -> L17
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L21;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L21
    L13:
        r4 = null;
    L21:
        Bundle r6 = new Bundle();
        r6.putParcelable("CREATION_LOCATION", this.g);
        r6.putString("SPACE_ID", this.h);
        r6.putString("MODULE", this.b);
        r6.putString("ROOT_TOKEN", this.d);
        r6.putString("enterSource", "create_new_more");
        r6.putString("template_source", "create_new_more");
        RouteBean r7 = new RouteBean();
        r7.a(this.a);
        r7.n = r6;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).yd("/list/template4/activity", r7).h(r6).e();
        TemplateReport.c("from_newcreate_more");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).a("click_template_more_button", new JSONObject());
        jw4.a.c(new jw4.d((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), "template_more", null, this.b, this.e, this.f));
        lc5.f.a.C(new tc5.a(this.b, this.c, "templates_more", "ccm_template_systemcenter_view", this.d, sbb.e.e.b));
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void H8() {
        Disposable r0 = ((com.bytedance.ee.bear.templates.recommend.a) getModel()).K().subscribe(new b(this), new c(this));
        ((CompositeDisposable) this.i.getValue()).add(r0);
    }

    public final void create() {
        super.create();
        ((com.bytedance.ee.bear.templates.recommend.b) getView()).d();
        H8();
        com.bytedance.ee.bear.contract.j.a.a.a().observe(this.a, new h(this));
    }

    public final void destroy() {
        super.destroy();
        if (((CompositeDisposable) this.i.getValue()).isDisposed() == true) goto L6;
        ((CompositeDisposable) this.i.getValue()).dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b.a
    public final void L(int r13, TemplateV4 r14) {
        Intrinsics.checkNotNullParameter(r14, ThumbGlideUrl.SOURCE_TEMPLATE);
        tt5.a.b("NewRecommendTemplatePresenter", "onTemplateSelected()...template = " + r14);
        com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        r1.h("add_doc");
        r1.j("add_doc", "module", this.b);
        ConnectionService.NetworkState r2 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState();
        boolean r5 = !r2.a();
        if (r14.getEnable() == true) goto L7;
        if (r5 == false) goto L7;
        tt5.a.h("NewRecommendTemplatePresenter", "create template offline, state:" + r2 + ", template enable: " + r14.getEnable());
        Toast.showFailureText(this.a.getContext(), 2131887937);
        return;
    L7:
        ((com.bytedance.ee.bear.templates.recommend.b) getView()).k0();
        ((CompositeDisposable) this.i.getValue()).add(((com.bytedance.ee.bear.templates.recommend.a) getModel()).x6(r14, this.d, this.b, this.h, this.g).timeout(15, TimeUnit.SECONDS).observeOn(fo5.d.d()).subscribe(new d(this, r14), new e(this, r14)));
        jw4.a.c(new jw4.d((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), ThumbGlideUrl.SOURCE_TEMPLATE + (r13 + 1), null, this.b, this.e, this.f));
    }

    public g(NewRecommendTemplateModel r2, i r3, Fragment r4, String r5, String r6, String r7, CreateSelectResult r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "module");
        Intrinsics.checkNotNullParameter(r6, "subModule");
        Intrinsics.checkNotNullParameter(r7, "parentToken");
        Intrinsics.checkNotNullParameter(r8, "createSelectResult");
        Intrinsics.checkNotNullParameter(r9, "spaceId");
        super(r2, r3);
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = false;
        this.f = false;
        this.g = r8;
        this.h = r9;
        this.i = LazyKt.lazy(NewRecommendTemplatePresenter$compositeDisposable$2.INSTANCE);
    }
}
