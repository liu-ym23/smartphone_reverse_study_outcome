package com.bytedance.ee.bear.templates.center;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.search.SearchFragment;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import onc.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends BasePresenter<Object, Object, c> implements c {
    public final Context a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Tab2.values().length];
            r0[Tab2.CUSTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Tab2.BUSNISS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    @Override // com.bytedance.ee.bear.templates.center.c
    public final void M6() {
        tt5.a.h("TemplateCenterPresenter", "onSearchIconClicked");
        BaseActivity r0 = this.a;
        if ((r0 instanceof TemplateCenterActivity) == false) goto L10;
        BaseActivity r1 = (TemplateCenterActivity) r0;
        r1.getClass();
        int r2 = SearchFragment.l;
        Intrinsics.checkNotNullParameter(r1, "context");
        Fragment r3 = Fragment.instantiate(r1, SearchFragment.class.getName(), new Bundle());
        FragmentTransaction r4 = r1.getSupportFragmentManager().beginTransaction().setCustomAnimations(2130772290, 2130772289, 2130772288, 2130772293);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131367728) == true) goto L8;
        r4 = r4.add(2131367728, r3);
    L8:
        r4.addToBackStack(null).commitAllowingStateLoss();
        TemplateReportV2 r5 = TemplateReportV2.a;
        JSONObject r6 = new JSONObject();
        r6.put("click_type", "search_input_click");
        r6.put("template_source", TemplateReportV2.c);
        r6.put("target", "none");
        TemplateReportV2.a().n(TemplateReportV2.b, r6);
        return;
    L10:
        if ((r0 instanceof FragmentActivity) == false) goto L18;
        FragmentActivity r7 = (FragmentActivity) r0;
        if (ForsetiHelper.t(r7) == false) goto L19;
        com.suite.lark.component.navroute.forseti.g r8 = com.suite.lark.component.navroute.forseti.f.c(r7, true);
        if (r8 == null) goto L20;
        r8.d(n.a);
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.c
    public final void h0(int r13, Tab2 r14) {
        Intrinsics.checkNotNullParameter(r14, "tab");
        org.json.JSONObject r0 = new org.json.JSONObject();     // Catch: Exception -> L18
        r0.put(ResourceData.KEY_TYPE, this.a.getString(r14.getValue()));     // Catch: Exception -> L18
        r0.put("lang", ((i0) this.c.getValue()).a());     // Catch: Exception -> L18
        ((com.bytedance.ee.bear.contract.d) this.b.getValue()).a("click_template_primary_tab", r0);     // Catch: Exception -> L18
        int r15 = b.a[r14.ordinal()];     // Catch: Exception -> L18
        if (r15 == 1) goto L9;
        if (r15 == 2) goto L8;
        TemplateReportV2 r16 = TemplateReportV2.a;     // Catch: Exception -> L18
        TemplateReportV2.j("system_template_click", "ccm_template_systemcenter_view");     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter("ccm_template_systemcenter_view_click", "<set-?>");     // Catch: Exception -> L18
        TemplateReportV2.b = "ccm_template_systemcenter_view_click";     // Catch: Exception -> L18
    L10:
        TemplateReportV2 r6 = TemplateReportV2.a;     // Catch: Exception -> L18
        if (r13 == 1) goto L15;
        if (r13 == 2) goto L14;
        String r7 = "ccm_template_systemcenter_view";
    L16:
        TemplateReportV2.l(r6, r7, "", null, null, 12);     // Catch: Exception -> L18
        return;
    L14:
        r7 = "ccm_template_enterprisecenter_view";
        goto L16
    L15:
        r7 = "ccm_template_usercenter_view";
        goto L16
    L8:
        TemplateReportV2 r17 = TemplateReportV2.a;     // Catch: Exception -> L18
        TemplateReportV2.j("enterprise_template_click", "ccm_template_enterprisecenter_view");     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter("ccm_template_enterprisecenter_view_click", "<set-?>");     // Catch: Exception -> L18
        TemplateReportV2.b = "ccm_template_enterprisecenter_view_click";     // Catch: Exception -> L18
        goto L10
    L9:
        TemplateReportV2 r18 = TemplateReportV2.a;     // Catch: Exception -> L18
        TemplateReportV2.j("user_template_click", "ccm_template_usercenter_view");     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter("ccm_template_usercenter_view_click", "<set-?>");     // Catch: Exception -> L18
        TemplateReportV2.b = "ccm_template_usercenter_view_click";     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
    }

    public f(e r2, TemplateCenterView r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r2, r3);
        this.a = r4;
        this.b = LazyKt.lazy(TemplateCenterPresenter$analyticService$2.INSTANCE);
        this.c = LazyKt.lazy(TemplateCenterPresenter$localeService$2.INSTANCE);
    }
}
