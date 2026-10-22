package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.app.Application;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.forsetiutils.ForsetiEmbeddedUtils;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.CarUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes16.dex */
public final class ForsetiHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f216439a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f216440b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f216441c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f216442d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f216443e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f216444f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f216445g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f216446h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f216447i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f216448j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f216449k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f216450l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f216451m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f216452n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f216453o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f216454p = null;

    public static final class a implements com.ss.android.lark.api.ui.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f216455a;

        @Override // com.ss.android.lark.api.ui.a
        public final void a() {
            this.f216455a.invoke();
        }

        public a(Function0<Unit> r100) {
            this.f216455a = r100;
        }
    }

    public static final class b implements com.ss.android.lark.api.ui.a {
        public b() {
        }

        @Override // com.ss.android.lark.api.ui.a
        public final void a() {
        }
    }

    static {
        f216439a = LazyKt.lazy(ForsetiHelper$enablePadSpace$2.INSTANCE);
        f216440b = LazyKt.lazy(ForsetiHelper$enableForsetiGoBack$2.INSTANCE);
        f216441c = LazyKt.lazy(ForsetiHelper$enableShowPopOver$2.INSTANCE);
        f216442d = LazyKt.lazy(ForsetiHelper$enableTemplateCenterForseti$2.INSTANCE);
        f216443e = LazyKt.lazy(ForsetiHelper$enableOnlyWikiDocx$2.INSTANCE);
        f216444f = LazyKt.lazy(ForsetiHelper$enableRestoreOrientation$2.INSTANCE);
        f216445g = LazyKt.lazy(ForsetiHelper$enableClearTopPage$2.INSTANCE);
        f216446h = LazyKt.lazy(ForsetiHelper$enableAdapterComment$2.INSTANCE);
        f216447i = LazyKt.lazy(ForsetiHelper$enableFullScreenSwitch$2.INSTANCE);
        f216448j = LazyKt.lazy(ForsetiHelper$enableSplitWindow$2.INSTANCE);
        f216449k = LazyKt.lazy(ForsetiHelper$enableSharePageSoftInputAdjustPan$2.INSTANCE);
        f216450l = LazyKt.lazy(ForsetiHelper$enableUseForsetiGoBack$2.INSTANCE);
        f216451m = LazyKt.lazy(ForsetiHelper$enableBitableSplitWindow$2.INSTANCE);
        f216452n = LazyKt.lazy(ForsetiHelper$enableBitablePanel$2.INSTANCE);
        f216453o = LazyKt.lazy(ForsetiHelper$enableRegisterLifecycle$2.INSTANCE);
        f216454p = LazyKt.lazy(ForsetiHelper$enableFoldRemoveRecentPage$2.INSTANCE);
        tt5.a.h("ForsetiHelper", "isFgOn: " + p());
    }

    public static boolean d() {
        return ((Boolean) f216446h.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean e() {
        return ((Boolean) f216444f.getValue()).booleanValue();
    }

    public static final boolean h() {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.android_aside_comment_v2") == false) goto L6;
        tt5.a.h("ForsetiHelper", "support aside comment v2");
        return true;
    L6:
        boolean r100 = p();
        tt5.a.h("ForsetiHelper", "enableAsideComment: asideCommentEnabled:" + r100 + ' ');
        return r100;
    }

    public static boolean i() {
        return ((Boolean) f216448j.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean n() {
        return ((Boolean) f216439a.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean o() {
        return ((Boolean) f216441c.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean f() {
        return i();
    }

    @JvmStatic
    public static final boolean k() {
        if (ForsetiFGHelpers.e() == true) goto L5;
    L7:
        boolean r100 = false;
    L9:
        if (ForsetiEmbeddedUtils.d() == false) goto L11;
    L20:
        boolean r101 = true;
    L21:
        if (r101 == false) goto L25;
        if (r100 == false) goto L26;
        return true;
    L26:
        return false;
    L25:
        return false;
    L11:
        if (ForsetiEmbeddedUtils.b() == false) goto L15;
        if (l("ccm.bitable.fold_display_forseti_enable") == true) goto L20;
    L15:
        if (ForsetiEmbeddedUtils.f() == true) goto L17;
    L19:
        r101 = false;
        goto L21
    L17:
        if (l("ccm.bitable.candybar_phone_forseti_enable") == false) goto L19;
    L5:
        if (l("ccm.bitable.big_screen_adaptation") == false) goto L7;
        r100 = true;
        goto L9
    }

    @JvmStatic
    public static final boolean m() {
        if (p() == true) goto L5;
    L7:
        return false;
    L5:
        if (l("ccm.mobile.enable_multi_float") == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean p() {
        if (CarUtils.a() == false) goto L6;
        return true;
    L6:
        if (ForsetiConfig.b() == true) goto L8;
    L10:
        return false;
    L8:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.forseti") == false) goto L10;
        return true;
    }

    @JvmStatic
    public static final boolean u() {
        if (p() == false) goto L9;
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        if (r100.g("lark.navigation.temporary.section.enable") == false) goto L9;
        if (r100.g("ccm.mobile.temporary_section_enable_ccm") == false) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmStatic
    public static final boolean b(Fragment r100) {
        if (r100 != null) goto L7;
        tt5.a.h("ForsetiHelper", "canUseForsetiGoBack: fragment == null");
        return false;
    L7:
        if (s(r100) == true) goto L11;
        tt5.a.h("ForsetiHelper", "canUseForsetiGoBack: is not in forseti");
        return false;
    L11:
        if (fib.a.a() == true) goto L15;
        tt5.a.h("ForsetiHelper", "canUseForsetiGoBack: splitWindow fg is false");
        return false;
    L15:
        if (((Boolean) f216450l.getValue()).booleanValue() == true) goto L19;
        tt5.a.h("ForsetiHelper", "canUseForsetiGoBack: enableUseForsetiGoBack fg is false");
        return false;
    L19:
        if (ApiUtils.getApi(sua.a.class) != null) goto L23;
        tt5.a.h("ForsetiHelper", "canUseForsetiGoBack: IForsetiApi == null");
        return false;
    L23:
        if (((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r100.getActivity()) != null) goto L26;
        tt5.a.h("ForsetiHelper", "canUseForsetiGoBack: ForsetiRouter.from(fragment) == null");
        return false;
    L26:
        return true;
    }

    @JvmStatic
    public static final boolean c(Fragment r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (b(r100) == true) goto L8;
        return false;
    L8:
        tt5.a.h("ForsetiHelper", "doForsetiGoBack: " + r100);
        tua.b r101 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r100.getActivity());
        if (r101 != null) goto L11;
        return false;
    L11:
        return r101.a(r100);
    }

    @JvmStatic
    public static final Fragment g(Fragment r100) {
        Sequence r101 = SequencesKt.filter(SequencesKt.generateSequence(r100, ForsetiHelper$findCCMForsetiFragment$1.INSTANCE), ForsetiHelper$findCCMForsetiFragment$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return (Fragment) SequencesKt.firstOrNull(r101);
    }

    @JvmStatic
    public static final ForsetiViewModel j(Fragment r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return (ForsetiViewModel) new ViewModelProvider(r100, new ForsetiViewModelFactory(r100.getActivity())).get(ForsetiViewModel.class);
    }

    public static boolean l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fgKey");
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        Application r102 = LarkContext.getApplication();
        r101.getClass();
        UserSession r103 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r102, com.ss.android.lark.passportc.convention.a.class)).b();
        return ((dn4.a) e0c.k.b(((v) e0c.k.a(r102, v.class)).c(r103), dn4.a.class)).a().isCurrentEnable(r100);
    }

    @JvmStatic
    public static final boolean q(FragmentActivity r100) {
        com.ss.android.lark.forsetiutils.b.f424768a.getClass();
        if (r100 != null) goto L5;
        return false;
    L5:
        tua.b r101 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r100);
        if (r101 == null) goto L11;
        ForsetiMode r102 = r101.T();
        if (r102 == null) goto L11;
        return r102.equals(ForsetiMode.Regular);
    L11:
        return com.ss.android.lark.base.embedded.b.b(r100);
    }

    @JvmStatic
    public static final boolean r(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        if (s(r100) == true) goto L5;
        return false;
    L5:
        tua.b r101 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r100.getActivity());
        if (r101 == null) goto L8;
        ForsetiPageViewType r102 = r101.w(r100);
    L10:
        return CollectionsKt.contains(CollectionsKt.listOf(new ForsetiPageViewType[]{ForsetiPageViewType.MODAL_R_VIEW, ForsetiPageViewType.MODAL_C_FULL_VIEW, ForsetiPageViewType.MODAL_C_HALF_VIEW, ForsetiPageViewType.POPOVER_C_VIEW, ForsetiPageViewType.POPOVER_R_VIEW}), r102);
    L8:
        r102 = null;
        goto L10
    }

    @JvmStatic
    public static final boolean s(Fragment r100) {
        if (p() == false) goto L9;
        if (r100 == null) goto L6;
        com.suite.lark.component.navroute.forseti.g r101 = com.suite.lark.component.navroute.forseti.f.b(r100);
    L7:
        if (r101 == null) goto L9;
        return true;
    L6:
        r101 = null;
    L9:
        return false;
    }

    @JvmStatic
    public static final boolean t(FragmentActivity r100) {
        if (p() == false) goto L10;
        if (r100 == null) goto L6;
        com.suite.lark.component.navroute.forseti.g r101 = com.suite.lark.component.navroute.forseti.f.c(r100, false);
    L7:
        if (r101 == null) goto L11;
        return true;
    L11:
        return false;
    L6:
        r101 = null;
        goto L7
    L10:
        return false;
    }

    @JvmStatic
    public static final void v(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        tua.b r101 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r100.getActivity());
        if (r101 == null) goto L6;
        r101.R(r100, new b());
        return;
    }

    @JvmStatic
    public static final boolean x(Fragment r100) {
        int r101 = fib.a.f477428a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.soft_input_mode_fix") == true) goto L5;
    L7:
        return false;
    L5:
        if (s(r100) == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final void a(Fragment r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "listener");
        tua.b r102 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r100.getActivity());
        if (r102 == null) goto L6;
        r102.u(r100, new a(r101));
        return;
    }

    @JvmStatic
    public static final void w(FragmentActivity r100, float r101) {
        if (r100 == null) goto L15;
        Window r102 = r100.getWindow();
        if (r102 == null) goto L16;
        View r103 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L10;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L10;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L10:
        if (r103 == null) goto L17;
        int r105 = r103.getHeight();
        tua.b r106 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r100);
        if (r106 == null) goto L18;
        r106.b((int) (r105 * r101));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }
}
