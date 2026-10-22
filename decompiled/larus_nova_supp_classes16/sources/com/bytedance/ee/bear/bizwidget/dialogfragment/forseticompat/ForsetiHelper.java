package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.app.Application;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ForsetiHelper {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static final Lazy m = null;
    public static final Lazy n = null;
    public static final Lazy o = null;
    public static final Lazy p = null;

    public static final class a implements com.ss.android.lark.api.ui.a {
        public final /* synthetic */ Function0<Unit> a;

        public final void a() {
            this.a.invoke();
        }

        public a(Function0<Unit> r1) {
            this.a = r1;
        }
    }

    public static final class b implements com.ss.android.lark.api.ui.a {
        public b() {
        }

        public final void a() {
        }
    }

    static {
        a = LazyKt.lazy(ForsetiHelper$enablePadSpace$2.INSTANCE);
        b = LazyKt.lazy(ForsetiHelper$enableForsetiGoBack$2.INSTANCE);
        c = LazyKt.lazy(ForsetiHelper$enableShowPopOver$2.INSTANCE);
        d = LazyKt.lazy(ForsetiHelper$enableTemplateCenterForseti$2.INSTANCE);
        e = LazyKt.lazy(ForsetiHelper$enableOnlyWikiDocx$2.INSTANCE);
        f = LazyKt.lazy(ForsetiHelper$enableRestoreOrientation$2.INSTANCE);
        g = LazyKt.lazy(ForsetiHelper$enableClearTopPage$2.INSTANCE);
        h = LazyKt.lazy(ForsetiHelper$enableAdapterComment$2.INSTANCE);
        i = LazyKt.lazy(ForsetiHelper$enableFullScreenSwitch$2.INSTANCE);
        j = LazyKt.lazy(ForsetiHelper$enableSplitWindow$2.INSTANCE);
        k = LazyKt.lazy(ForsetiHelper$enableSharePageSoftInputAdjustPan$2.INSTANCE);
        l = LazyKt.lazy(ForsetiHelper$enableUseForsetiGoBack$2.INSTANCE);
        m = LazyKt.lazy(ForsetiHelper$enableBitableSplitWindow$2.INSTANCE);
        n = LazyKt.lazy(ForsetiHelper$enableBitablePanel$2.INSTANCE);
        o = LazyKt.lazy(ForsetiHelper$enableRegisterLifecycle$2.INSTANCE);
        p = LazyKt.lazy(ForsetiHelper$enableFoldRemoveRecentPage$2.INSTANCE);
        tt5.a.h("ForsetiHelper", "isFgOn: " + p());
    }

    public static boolean d() {
        return ((Boolean) h.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean e() {
        return ((Boolean) f.getValue()).booleanValue();
    }

    public static final boolean h() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.android_aside_comment_v2") == false) goto L6;
        tt5.a.h("ForsetiHelper", "support aside comment v2");
        return true;
    L6:
        boolean r0 = p();
        tt5.a.h("ForsetiHelper", "enableAsideComment: asideCommentEnabled:" + r0 + ' ');
        return r0;
    }

    public static boolean i() {
        return ((Boolean) j.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean n() {
        return ((Boolean) a.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean o() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean f() {
        return i();
    }

    @JvmStatic
    public static final boolean k() {
        if (ForsetiFGHelpers.e() == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (ForsetiEmbeddedUtils.d() == false) goto L11;
    L20:
        boolean r3 = true;
    L21:
        if (r3 == false) goto L25;
        if (r0 == false) goto L26;
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
        r3 = false;
        goto L21
    L17:
        if (l("ccm.bitable.candybar_phone_forseti_enable") == false) goto L19;
    L5:
        if (l("ccm.bitable.big_screen_adaptation") == false) goto L7;
        r0 = true;
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
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.forseti") == false) goto L10;
        return true;
    }

    @JvmStatic
    public static final boolean u() {
        if (p() == false) goto L9;
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r0.g("lark.navigation.temporary.section.enable") == false) goto L9;
        if (r0.g("ccm.mobile.temporary_section_enable_ccm") == false) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmStatic
    public static final boolean b(Fragment r3) {
        if (r3 != null) goto L7;
        tt5.a.h("ForsetiHelper", "canUseForsetiGoBack: fragment == null");
        return false;
    L7:
        if (s(r3) == true) goto L11;
        tt5.a.h("ForsetiHelper", "canUseForsetiGoBack: is not in forseti");
        return false;
    L11:
        if (fib.a.a() == true) goto L15;
        tt5.a.h("ForsetiHelper", "canUseForsetiGoBack: splitWindow fg is false");
        return false;
    L15:
        if (((Boolean) l.getValue()).booleanValue() == true) goto L19;
        tt5.a.h("ForsetiHelper", "canUseForsetiGoBack: enableUseForsetiGoBack fg is false");
        return false;
    L19:
        if (ApiUtils.getApi(sua.a.class) != null) goto L23;
        tt5.a.h("ForsetiHelper", "canUseForsetiGoBack: IForsetiApi == null");
        return false;
    L23:
        if (((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r3.getActivity()) != null) goto L26;
        tt5.a.h("ForsetiHelper", "canUseForsetiGoBack: ForsetiRouter.from(fragment) == null");
        return false;
    L26:
        return true;
    }

    @JvmStatic
    public static final boolean c(Fragment r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (b(r3) == true) goto L8;
        return false;
    L8:
        tt5.a.h("ForsetiHelper", "doForsetiGoBack: " + r3);
        tua.b r1 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r3.getActivity());
        if (r1 != null) goto L11;
        return false;
    L11:
        return r1.a(r3);
    }

    @JvmStatic
    public static final Fragment g(Fragment r1) {
        Sequence r2 = SequencesKt.filter(SequencesKt.generateSequence(r1, ForsetiHelper$findCCMForsetiFragment$1.INSTANCE), ForsetiHelper$findCCMForsetiFragment$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return (Fragment) SequencesKt.firstOrNull(r2);
    }

    @JvmStatic
    public static final ForsetiViewModel j(Fragment r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        return (ForsetiViewModel) new ViewModelProvider(r3, new ForsetiViewModelFactory(r3.getActivity())).get(ForsetiViewModel.class);
    }

    public static boolean l(String r4) {
        Intrinsics.checkNotNullParameter(r4, "fgKey");
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r1 = LarkContext.getApplication();
        r0.getClass();
        UserSession r2 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b();
        return ((dn4.a) e0c.k.b(((v) e0c.k.a(r1, v.class)).c(r2), dn4.a.class)).a().isCurrentEnable(r4);
    }

    @JvmStatic
    public static final boolean q(FragmentActivity r1) {
        com.ss.android.lark.forsetiutils.b.a.getClass();
        if (r1 != null) goto L5;
        return false;
    L5:
        tua.b r0 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r1);
        if (r0 == null) goto L11;
        ForsetiMode r2 = r0.T();
        if (r2 == null) goto L11;
        return r2.equals(ForsetiMode.Regular);
    L11:
        return com.ss.android.lark.base.embedded.b.b(r1);
    }

    @JvmStatic
    public static final boolean r(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        if (s(r3) == true) goto L5;
        return false;
    L5:
        tua.b r0 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r3.getActivity());
        if (r0 == null) goto L8;
        ForsetiPageViewType r4 = r0.w(r3);
    L10:
        return CollectionsKt.contains(CollectionsKt.listOf(new ForsetiPageViewType[]{ForsetiPageViewType.MODAL_R_VIEW, ForsetiPageViewType.MODAL_C_FULL_VIEW, ForsetiPageViewType.MODAL_C_HALF_VIEW, ForsetiPageViewType.POPOVER_C_VIEW, ForsetiPageViewType.POPOVER_R_VIEW}), r4);
    L8:
        r4 = null;
        goto L10
    }

    @JvmStatic
    public static final boolean s(Fragment r1) {
        if (p() == false) goto L9;
        if (r1 == null) goto L6;
        com.suite.lark.component.navroute.forseti.g r2 = com.suite.lark.component.navroute.forseti.f.b(r1);
    L7:
        if (r2 == null) goto L9;
        return true;
    L6:
        r2 = null;
    L9:
        return false;
    }

    @JvmStatic
    public static final boolean t(FragmentActivity r2) {
        if (p() == false) goto L10;
        if (r2 == null) goto L6;
        com.suite.lark.component.navroute.forseti.g r3 = com.suite.lark.component.navroute.forseti.f.c(r2, false);
    L7:
        if (r3 == null) goto L11;
        return true;
    L11:
        return false;
    L6:
        r3 = null;
        goto L7
    L10:
        return false;
    }

    @JvmStatic
    public static final void v(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        tua.b r0 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r2.getActivity());
        if (r0 == null) goto L6;
        r0.R(r2, new b());
        return;
    }

    @JvmStatic
    public static final boolean x(Fragment r2) {
        int r0 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.soft_input_mode_fix") == true) goto L5;
    L7:
        return false;
    L5:
        if (s(r2) == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final void a(Fragment r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "listener");
        tua.b r0 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r2.getActivity());
        if (r0 == null) goto L6;
        r0.u(r2, new a(r3));
        return;
    }

    @JvmStatic
    public static final void w(FragmentActivity r4, float r5) {
        if (r4 == null) goto L15;
        Window r0 = r4.getWindow();
        if (r0 == null) goto L16;
        View r1 = r0.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L10;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L10;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L10:
        if (r1 == null) goto L17;
        int r3 = r1.getHeight();
        tua.b r6 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r4);
        if (r6 == null) goto L18;
        r6.b((int) (r3 * r5));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }
}
