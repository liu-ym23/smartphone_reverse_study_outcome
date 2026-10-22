package com.larus.minor.impl;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Observer;
import com.bytedance.keva.Keva;
import com.bytedance.router.SmartRouter;
import com.larus.account.base.api.ILoginService;
import com.larus.apm.api.IApm;
import com.larus.bmhome.auth.LaunchBiz;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.MinorInfoData;
import com.larus.bmhome.auth.PopupConfig;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.h0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.utils.LaunchLandingConfigHelperDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.minor.model.MinorConfigItems;
import com.larus.platform.service.AccountService;
import com.larus.setting.api.SettingService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes4.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f359217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f359218b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f359219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f359220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f359221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<com.larus.minor.api.c> f359222f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f359223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f359224h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f359225i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static wk9.a f359226j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f359227k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f359228l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f359229m;

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f359230a;

        public a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f359230a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f359230a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f359230a.invoke(r100);
        }
    }

    public v() {
    }

    static {
        f359217a = new v();
        AtomicBoolean r100 = new AtomicBoolean(false);
        f359218b = r100;
        f359222f = new CopyOnWriteArrayList();
        f359223g = true;
        f359224h = LazyKt.lazy(new l());
        f359225i = true;
        r100.set(b().getBoolean("key_is_in_minor_mode_".concat(AccountService.f365697a.getUserId()), false));
        f359229m = r100.get();
        FLogger.f375446a.i("MinorStatusManager", "init minor mode status " + r100);
        IActionBarService r101 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r101 != null) goto L5;
    L9:
        t0.c(new m());
        IApm r102 = (IApm) ServiceManager.get().getService(IApm.class);
        if (r102 == null) goto L13;
        r102.b(r100.get());
        return;
    L13:
        return;
    L5:
        if (r100.get() == false) goto L7;
        String r103 = "-minor";
    L8:
        r101.j(r103);
        goto L9
    L7:
        r103 = "";
        goto L8
    }

    public static Keva b() {
        return (Keva) f359224h.getValue();
    }

    public static void c() {
        FLogger r100 = FLogger.f375446a;
        r100.i("MinorStatusManager", "goMainActivityIfPendingReturn");
        if (f359219c == true) goto L5;
        return;
    L5:
        if (f359220d == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(f359221e, AccountService.f365697a.getUserId()) == true) goto L10;
        return;
    L10:
        r100.i("MinorStatusManager", "goMainActivityIfPendingReturn goMainActivity");
        f359219c = false;
        r100.i("MinorStatusManager", "goMainActivity");
        com.bytedance.router.i r101 = SmartRouter.buildRoute(AppHost.f326268a.getApplication().getApplicationContext(), "//main_page");
        Bundle r102 = BundleKt.bundleOf();
        r102.putString("argPreviousPage", "minor_setting");
        r101.f267554c.putExtras(r102);
        r101.f267554c.addFlags(268468224);
        r101.d();
    }

    public static void e() {
        List<com.larus.minor.api.c> r100 = f359222f;
        if (r100 == null) goto L8;
        Iterator r101 = ((CopyOnWriteArrayList) r100).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((com.larus.minor.api.c) r101.next()).AT();
        goto L6
    L10:
        return;
    }

    public static void f() {
        if (f359219c == true) goto L5;
        return;
    L5:
        AuthModelDelegate r100 = AuthModelDelegate.f297134b;
        e0 r101 = r100.e().getValue();
        boolean r102 = false;
        List r103 = CollectionsKt.listOf(new c1[]{r100.H().getValue(), r100.l().getValue(), r100.i().getValue(), r100.E().getValue()});
        boolean r104 = r103 instanceof Collection;
        if (r104 == true) goto L8;
    L10:
        Iterator r105 = r103.iterator();
    L12:
        if (r105.hasNext() == false) goto L21;
        c1 r106 = (c1) r105.next();
        if (r106 != null) goto L16;
    L18:
        boolean r107 = false;
    L19:
        if (r107 == false) goto L12;
        boolean r108 = true;
    L23:
        if (r108 == false) goto L26;
        e();
        FLogger.f375446a.e("MinorStatusManager", "request split launch when enter minor mode");
        return;
    L26:
        if (r104 == true) goto L28;
    L30:
        Iterator r109 = r103.iterator();
    L32:
        if (r109.hasNext() == false) goto L47;
        c1 r110 = (c1) r109.next();
        if (r110 != null) goto L36;
    L38:
        boolean r111 = false;
    L39:
        if (r111 == true) goto L41;
    L44:
        boolean r112 = true;
    L45:
        if (r112 == false) goto L32;
        boolean r113 = true;
    L48:
        if (r113 == false) goto L50;
        return;
    L50:
        if (r101 != null) goto L52;
    L54:
        boolean r114 = false;
    L55:
        if (r114 == false) goto L66;
        LaunchInfo r115 = r101.f297186a;
        if (r115 != null) goto L60;
        return;
    L60:
        if (r115.I0() != true) goto L63;
        return;
    L63:
        if (ILoginService.f286097a.getAccountInfo().f531528a == true) goto L65;
        return;
    L65:
        LaunchLandingConfigHelperDelegate.f314922b.e(r115.M0());
        f359220d = true;
        c();
        return;
    L66:
        if (r101 != null) goto L68;
    L70:
        if (r102 == false) goto L84;
        e();
        FLogger.f375446a.e("MinorStatusManager", "request launchInfo when enter minor mode");
        return;
    L84:
        return;
    L68:
        if (r101.f297187b != 3) goto L70;
        r102 = true;
        goto L70
    L52:
        if (r101.f297187b != 2) goto L54;
        r114 = true;
        goto L55
    L41:
        if (r110.f295753d == 0) goto L44;
        r112 = false;
        goto L45
    L36:
        if (r110.f295751b != 2) goto L38;
        r111 = true;
    L47:
        r113 = false;
        goto L48
    L28:
        if (r103.isEmpty() == false) goto L30;
    L16:
        if (r106.f295751b != 3) goto L18;
        r107 = true;
    L21:
        r108 = false;
        goto L23
    L8:
        if (r103.isEmpty() == false) goto L10;
        goto L10
    }

    public static void d(boolean r100) {
        SettingService.f367887a.g();
        AtomicBoolean r101 = f359218b;
        r101.set(r100);
        IActionBarService r102 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r102 != null) goto L5;
    L9:
        t0.a(new u());
        HomeService.f344094a.T();
        if (f359229m == true) goto L14;
        if (r100 == true) goto L14;
        boolean r103 = false;
    L15:
        f359229m = r103;
        b().storeBoolean("key_is_in_minor_mode_".concat(AccountService.f365697a.getUserId()), r101.get());     // Catch: Exception -> L18
    L20:
        AuthModelDelegate.f297134b.n();
        FLogger.f375446a.i("MinorStatusManager", "goMainActivityPendingReturn");
        f359220d = false;
        f359221e = AccountService.f365697a.getUserId();
        f359219c = true;
        if (r100 == false) goto L28;
        List<com.larus.minor.api.c> r104 = f359222f;
        if (r104 == null) goto L34;
        Iterator r105 = ((CopyOnWriteArrayList) r104).iterator();
    L26:
        if (r105.hasNext() == false) goto L34;
        ((com.larus.minor.api.c) r105.next()).S1();
    L34:
        AuthModelDelegate.f297134b.t("enterMinorMode", SetsKt.setOf(LaunchBiz.FULL), true);
        return;
    L28:
        List<com.larus.minor.api.c> r106 = f359222f;
        if (r106 == null) goto L34;
        Iterator r107 = ((CopyOnWriteArrayList) r106).iterator();
    L32:
        if (r107.hasNext() == false) goto L34;
        ((com.larus.minor.api.c) r107.next()).b1();
    L18:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "saveMinorStatusToLocal");
    L14:
        r103 = true;
        goto L15
    L5:
        if (r101.get() == false) goto L7;
        String r108 = "_minor";
    L8:
        r102.j(r108);
        goto L9
    L7:
        r108 = "";
        goto L8
    }

    public final Object a(com.larus.minor.impl.component.c r110, Continuation r111) {
        if ((r111 instanceof MinorStatusManager$checkTipsShow$1) == false) goto L7;
        MinorStatusManager$checkTipsShow$1 r100 = (MinorStatusManager$checkTipsShow$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        long r105 = r100.J$0;
        ResultKt.throwOnFailure(r102);
    L119:
        if (((Boolean) r102).booleanValue() == false) goto L121;
        Keva r106 = b();     // Catch: Exception -> L124
        AccountService r107 = AccountService.f365697a;     // Catch: Exception -> L124
        r106.storeLong("key_tips_show_time_".concat(r107.getUserId()), r105);     // Catch: Exception -> L124
        b().storeInt("key_tips_show_count_".concat(r107.getUserId()), f359228l + 1);     // Catch: Exception -> L124
    L127:
        return Boxing.boxBoolean(true);
    L124:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "saveMinorStatusToLocal");
        goto L127
    L121:
        return Boxing.boxBoolean(false);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r108 = r100.J$0;
        ResultKt.throwOnFailure(r102);
    L87:
        if (((Boolean) r102).booleanValue() == false) goto L89;
        b().storeLong("key_tips_show_time_".concat(AccountService.f365697a.getUserId()), r108);     // Catch: Exception -> L92
    L95:
        return Boxing.boxBoolean(true);
    L92:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "saveMinorStatusToLocal");
        goto L95
    L89:
        return Boxing.boxBoolean(false);
    L17:
        Function0 r109 = (Function0) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Function0 r112 = r109;
    L30:
        if (f359218b.get() == true) goto L32;
    L34:
        boolean r113 = false;
    L35:
        FLogger r114 = FLogger.f375446a;
        r114.i("MinorStatusManager", "checkTipsShow isInMinorMode " + r113);
        if (r113 == true) goto L38;
        long r115 = System.currentTimeMillis() / ((long) 1000);
        if (f359226j != null) goto L63;
        c1<h0> r116 = AuthModelDelegate.f297134b.a().getValue();
        if (r116 == null) goto L46;
        h0 r117 = r116.f295753d;
        if (r117 == null) goto L46;
        MinorInfoData r118 = r117.f();
    L47:
        if (r118 == null) goto L62;
        List r119 = CollectionsKt.mutableListOf(new String[]{MinorConfigItems.SHOW_VIDEO, MinorConfigItems.AI_CREATION, MinorConfigItems.ENTER_WEB});
        PopupConfig r120 = r118.a();
        if (r120 == null) goto L53;
        Integer r121 = r120.b();
        if (r121 == null) goto L53;
        int r122 = r121.intValue();
    L54:
        PopupConfig r123 = r118.a();
        if (r123 == null) goto L59;
        Integer r124 = r123.a();
        if (r124 == null) goto L59;
        int r125 = r124.intValue();
    L60:
        f359226j = new wk9.a(r119, r122, r125);
    L59:
        r125 = 0;
    L53:
        r122 = 1;
        goto L54
    L62:
        return Boxing.boxBoolean(false);
    L46:
        r118 = null;
    L63:
        StringBuilder r126 = new StringBuilder("checkTipsShow showTipsType, tipsShowTime ");
        r126.append(f359227k);
        r126.append(", count ");
        r126.append(f359228l);
        r126.append(" hasJoinedMinor ");
        r126.append(f359229m);
        r126.append(", config with type ");
        wk9.a r127 = f359226j;
        if (r127 == null) goto L66;
        Integer r128 = Boxing.boxInt(r127.f560138b);
    L67:
        r126.append(r128);
        r126.append(",  max count ");
        wk9.a r129 = f359226j;
        if (r129 == null) goto L70;
        Integer r130 = Boxing.boxInt(r129.f560139c);
    L71:
        r126.append(r130);
        r114.i("MinorStatusManager", r126.toString());
        wk9.a r131 = f359226j;
        if (r131 != null) goto L74;
    L76:
        boolean r132 = false;
    L77:
        if (r132 == false) goto L98;
        r114.i("MinorStatusManager", "tips show time " + f359227k + ", hasJoinedMinor " + f359229m);
        if (f359227k != 0) goto L97;
        if (f359229m == true) goto L97;
        MainCoroutineDispatcher r133 = Dispatchers.getMain();
        MinorStatusManager$checkTipsShow$canShow$1 r134 = new MinorStatusManager$checkTipsShow$canShow$1(r112, null);
        r100.L$0 = null;
        r100.J$0 = r115;
        r100.label = 2;
        r102 = BuildersKt.withContext(r133, r134, r100);
        if (r102 != r103) goto L85;
        return r103;
    L85:
        r108 = r115;
    L97:
        return Boxing.boxBoolean(false);
    L98:
        if (r131 == null) goto L100;
        int r135 = r131.f560139c;
    L102:
        if (f359228l >= r135) goto L104;
        boolean r136 = true;
    L106:
        if ((r115 - f359227k) < 86400) goto L108;
        boolean r137 = true;
    L109:
        r114.i("MinorStatusManager", "checkTipsShow timeEnable " + r137 + ", countEnable " + r136);
        if (r136 == false) goto L129;
        if (r137 == false) goto L129;
        if (f359229m == true) goto L129;
        MainCoroutineDispatcher r138 = Dispatchers.getMain();
        MinorStatusManager$checkTipsShow$canShow$2 r139 = new MinorStatusManager$checkTipsShow$canShow$2(r112, null);
        r100.L$0 = null;
        r100.J$0 = r115;
        r100.label = 3;
        r102 = BuildersKt.withContext(r138, r139, r100);
        if (r102 != r103) goto L117;
        return r103;
    L117:
        r105 = r115;
    L129:
        return Boxing.boxBoolean(false);
    L108:
        r137 = false;
        goto L109
    L104:
        r136 = false;
        goto L106
    L100:
        r135 = 0;
        goto L102
    L74:
        if (r131.f560138b != 1) goto L76;
        r132 = true;
        goto L77
    L70:
        r130 = null;
        goto L71
    L66:
        r128 = null;
        goto L67
    L38:
        return Boxing.boxBoolean(false);
    L32:
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L34;
        r113 = true;
        goto L35
    L18:
        ResultKt.throwOnFailure(r102);
        FLogger r140 = FLogger.f375446a;
        r140.i("MinorStatusManager", "checkTipsShow");
        if (b().getBoolean("key_never_show_again_".concat(AccountService.f365697a.getUserId()), false) == false) goto L23;
        r140.i("MinorStatusManager", "checkTipsShow neverShowMinorTipCheck");
        return Boxing.boxBoolean(false);
    L23:
        if (f359225i == false) goto L25;
        f359225i = false;
        CoroutineDispatcher r141 = Dispatchers.getIO();
        MinorStatusManager$checkTipsShow$2 r142 = new MinorStatusManager$checkTipsShow$2(null);
        r112 = r110;
        r100.L$0 = r112;
        r100.label = 1;
        if (BuildersKt.withContext(r141, r142, r100) != r103) goto L30;
        return r103;
    L25:
        return Boxing.boxBoolean(false);
    L7:
        r100 = new MinorStatusManager$checkTipsShow$1(this, r111);
        goto L8
    }
}
