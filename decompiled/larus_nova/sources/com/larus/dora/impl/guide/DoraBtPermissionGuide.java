package com.larus.dora.impl.guide;

import android.media.AudioManager;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraGuideService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.service.GuideSession$setStateListener$1;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.platform.api.g1;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraBtPermissionGuide implements t39.l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f335898k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f335899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f335900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f335901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f335902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f335903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t39.m f335904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f335905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f335906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f335907i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f335908j;

    public static final class a {
        public static void a(long r100, boolean r101) {
            g49.d.a("DoraBtPermissionGuide", "[Event] try to report bt permission status, currentDay=" + r100 + ", granted=" + r101);
            DoraBuryPointManager r102 = DoraBuryPointManager.f331862a;
            r102.getClass();
            g49.d.d(DoraBuryPointManager.f331863b, "[Event] reportBtPermissionStatus, granted=" + r101);
            Pair[] r103 = new Pair[2];
            if (r101 == false) goto L5;
            String r104 = "on";
        L6:
            int r105 = 0;
            r103[0] = TuplesKt.to("bt_permission_status", r104);
            r103[1] = TuplesKt.to("scene", "bt_permission_guide_condition_check");
            r102.L("d_bt_permission_status", MapsKt.mapOf(r103));
            com.larus.dora.impl.util.b0.f338123a.getClass();     // Catch: Exception -> L16
            com.larus.dora.impl.util.b0.j().storeLong("dora_bt_permission_status_last_day", r100);     // Catch: Exception -> L16
            Keva r106 = com.larus.dora.impl.util.b0.j();     // Catch: Exception -> L16
            if (r101 == false) goto L10;
            int r107 = 1;
        L11:
            r106.storeInt("dora_bt_permission_status_last_value", r107);     // Catch: Exception -> L16
            StringBuilder r108 = new StringBuilder("[State] update bt permission status keva success, day=");     // Catch: Exception -> L16
            r108.append(r100);     // Catch: Exception -> L16
            r108.append(", value=");     // Catch: Exception -> L16
            if (r101 == false) goto L14;
            r105 = 1;
        L14:
            r108.append(r105);     // Catch: Exception -> L16
            g49.d.a("DoraBtPermissionGuide", r108.toString());     // Catch: Exception -> L16
            return;
        L10:
            r107 = 0;
        L16:
            e = move-exception;
            g49.d.c("DoraBtPermissionGuide", "[Exception] store bt permission status to keva failed: " + e.getMessage(), e);
            return;
        L5:
            r104 = "off";
            goto L6
        }
    }

    public static final class b implements g1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraBtPermissionGuide f335909a;

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogDismiss(boolean r100) {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogShow() {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onSettingPageReturn() {
        }

        public b(DoraBtPermissionGuide r100) {
            this.f335909a = r100;
        }

        @Override // com.larus.platform.api.g1.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
            g49.d.d("DoraBtPermissionGuide", "Permission result, allGranted=" + r100 + ", grantedList=" + r101 + ", deniedList=" + r102 + ", goSettingsShown=" + r103);
            this.f335909a.i(3);
            g49.d.d("DoraBtPermissionGuide", "onReadyShowNextGuide() triggered after permission result");
            DoraBtPermissionGuide r104 = this.f335909a;
            t39.m r105 = r104.f335904f;
            if (r105 == null) goto L5;
            r105.a(r104);
        L5:
            DoraBuryPointManager.f331862a.G(r100, this.f335909a.f335899a);
        }
    }

    static {
    }

    @Override // t39.l
    public final Unit a() {
        g49.d.d("DoraBtPermissionGuide", "startGuide()");
        if (h() == true) goto L5;
        i(1);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // t39.l
    public final int f() {
        return DoraGuideMeta.DoraBtPermissionGuide.getGuideId();
    }

    public final boolean h() {
        IDoraGuideService r100 = (IDoraGuideService) ServiceManager.get().getService(IDoraGuideService.class);
        if (r100 == null) goto L5;
        boolean r101 = r100.b();
    L6:
        if (r101 == false) goto L8;
        g49.d.d("DoraBtPermissionGuide", "guide suppressed: dora guide is degraded");
    L8:
        return r101;
    L5:
        r101 = true;
        goto L6
    }

    public final String toString() {
        return "DoraBtPermissionGuide(state=" + this.f335903e + ')';
    }

    @Override // t39.l
    public final void b(GuideSession$setStateListener$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        g49.d.d("DoraBtPermissionGuide", "setStateListener() called with " + r100);
        this.f335904f = r100;
    }

    @Override // t39.l
    public final Object c(Continuation<? super Boolean> r110) {
        if ((r110 instanceof DoraBtPermissionGuide$isGuideConditionMet$1) == false) goto L7;
        DoraBtPermissionGuide$isGuideConditionMet$1 r100 = (DoraBtPermissionGuide$isGuideConditionMet$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L23;
        if (r103 == 1) goto L22;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L20;
        if (r103 != 4) goto L19;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L16
        String r112 = "DoraBtPermissionGuide";
    L93:
        boolean r104 = ((Boolean) r102).booleanValue();     // Catch: Exception -> L99
        StringBuilder r105 = new StringBuilder("ServerStrategy result: ");     // Catch: Exception -> L99
        if (r104 == false) goto L96;
        boolean r113 = true;
    L97:
        r105.append(r113);     // Catch: Exception -> L99
        g49.d.d(r112, r105.toString());     // Catch: Exception -> L99
        boolean r114 = r104;
    L104:
        return Boxing.boxBoolean(r114);
    L99:
        Exception e100 = e;
    L100:
        g49.d.c(r112, "ServerStrategy check failed: " + e100.getMessage(), e100);
    L102:
        r114 = false;
        goto L104
    L96:
        r113 = false;
    L16:
        e100 = e;
        r112 = "DoraBtPermissionGuide";
        goto L100
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r102);
        r112 = "DoraBtPermissionGuide";
    L78:
        if (((Boolean) r102).booleanValue() == true) goto L81;
        g49.d.d(r112, "Permission guide condition not met: channel and user strategy not met");
        return Boxing.boxBoolean(false);
    L81:
        Object r106 = AppHost.f326268a.getApplication().getSystemService("audio");
        if ((r106 instanceof AudioManager) == false) goto L84;
        AudioManager r107 = (AudioManager) r106;
    L85:
        if (r107 != null) goto L88;
        g49.d.b(r112, "AudioManager is null, cannot determine A2DP state");
        return Boxing.boxBoolean(false);
    L88:
        boolean r108 = r107.isBluetoothA2dpOn();
        g49.d.d(r112, "isGuideConditionMet() A2DP on: " + r108);
        if (r108 == true) goto L109;
        g49.d.d(r112, "A2DP off, skip showing bluetooth permission guide");
        goto L102
    L109:
        com.larus.dora.impl.guide.strategy.f r109 = new com.larus.dora.impl.guide.strategy.f();     // Catch: Exception -> L99
        r100.label = 4;     // Catch: Exception -> L99
        r102 = r109.a();     // Catch: Exception -> L99
        if (r102 != r111) goto L93;
        return r111;
    L84:
        r107 = null;
        goto L85
    L21:
        ResultKt.throwOnFailure(r102);
        boolean r115 = true;
    L71:
        if (Intrinsics.areEqual((Boolean) r102, Boxing.boxBoolean(r115)) == true) goto L74;
        g49.d.d("DoraBtPermissionGuide", "H device is not enabled");
        return Boxing.boxBoolean(false);
    L74:
        r100.label = 3;
        r102 = g(r100);
        if (r102 != r111) goto L78;
        return r111;
    L22:
        ResultKt.throwOnFailure(r102);
    L34:
        boolean r116 = ((Boolean) r102).booleanValue();
        long r117 = System.currentTimeMillis() / 86400000;
        com.larus.dora.impl.util.b0.f338123a.getClass();     // Catch: Exception -> L58
        long r118 = com.larus.dora.impl.util.b0.j().getLong("dora_bt_permission_status_last_day", -1);     // Catch: Exception -> L58
        int r119 = com.larus.dora.impl.util.b0.j().getInt("dora_bt_permission_status_last_value", -1);     // Catch: Exception -> L58
        if (r118 == (-1)) goto L54;
        if (r119 == (-1)) goto L54;
        if (r117 == r118) goto L43;
        boolean r120 = true;
    L44:
        if (r119 != 1) goto L46;
        boolean r121 = true;
    L47:
        if (r116 == r121) goto L49;
        boolean r122 = true;
    L50:
        if (r120 == true) goto L54;
        if (r122 == true) goto L54;
        boolean r123 = false;
    L55:
        if (r123 == true) goto L57;
        g49.d.a("DoraBtPermissionGuide", "[State] skip bt permission status report, same day and same status. currentDay=" + r117 + ", lastDay=" + r118 + ", currentGranted=" + r116 + ", lastValue=" + r119);
    L60:
        if (r116 == false) goto L64;
        g49.d.d("DoraBtPermissionGuide", "Bluetooth permissions already granted, no need to show permission guide");
        return Boxing.boxBoolean(false);
    L64:
        if (this.f335900b == true) goto L67;
        g49.d.d("DoraBtPermissionGuide", "Bluetooth permission guide condition not met: main bot guide not enabled");
        return Boxing.boxBoolean(false);
    L67:
        DoraSetting r124 = DoraSetting.f338023a;
        Function0 r125 = new r();
        r100.label = 2;
        r115 = true;
        r102 = r124.b(5000, 100, "DoraBtPermissionGuide-updateConnectDeviceShouldShowState-isHDeviceEnabled", r125, r100);
        if (r102 != r111) goto L71;
        return r111;
    L57:
        a.a(r117, r116);
        goto L60
    L49:
        r122 = false;
        goto L50
    L46:
        r121 = false;
        goto L47
    L43:
        r120 = false;
    L54:
        r123 = true;
    L58:
        e = move-exception;
        g49.d.c("DoraBtPermissionGuide", "[Exception] read bt permission status from keva failed, treat as never reported: " + e.getMessage(), e);
        a.a(r117, r116);
        goto L60
    L23:
        ResultKt.throwOnFailure(r102);
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L28;
        g49.d.d("DoraBtPermissionGuide", "Bluetooth permission guide condition not met: user not login");
        return Boxing.boxBoolean(false);
    L28:
        if (h() == true) goto L30;
        com.larus.dora.impl.guide.strategy.a r126 = (com.larus.dora.impl.guide.strategy.a) this.f335905g.getValue();
        r100.label = 1;
        r126.getClass();
        r102 = com.larus.dora.impl.guide.strategy.a.c();
        if (r102 != r111) goto L34;
        return r111;
    L30:
        return Boxing.boxBoolean(false);
    L7:
        r100 = new DoraBtPermissionGuide$isGuideConditionMet$1(this, r110);
        goto L8
    }

    public final Object g(Continuation<? super Boolean> r100) {
        if ((r100 instanceof DoraBtPermissionGuide$isChannelOrUserStrategyMet$1) == false) goto L7;
        DoraBtPermissionGuide$isChannelOrUserStrategyMet$1 r101 = (DoraBtPermissionGuide$isChannelOrUserStrategyMet$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L19;
        if (r105 == 1) goto L18;
        if (r105 == 2) goto L17;
        if (r105 != 3) goto L16;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L38
    L36:
        boolean r106 = ((Boolean) r103).booleanValue();     // Catch: Exception -> L38
    L40:
        if (r106 == true) goto L44;
        g49.d.d("DoraBtPermissionGuide", "Permission guide condition not met: user is new or same-day first enter main bot page");
        return Boxing.boxBoolean(false);
    L44:
        return Boxing.boxBoolean(true);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
    L30:
        if (((Boolean) r103).booleanValue() == true) goto L33;
        g49.d.d("DoraBtPermissionGuide", "Permission guide condition not met: frequency interval not reached");
        return Boxing.boxBoolean(false);
    L33:
        com.larus.dora.impl.guide.strategy.d r107 = (com.larus.dora.impl.guide.strategy.d) this.f335906h.getValue();     // Catch: Exception -> L38
        r101.label = 3;     // Catch: Exception -> L38
        r107.getClass();     // Catch: Exception -> L38
        r103 = com.larus.dora.impl.guide.strategy.d.a();     // Catch: Exception -> L38
        if (r103 != r104) goto L36;
        return r104;
    L18:
        ResultKt.throwOnFailure(r103);
    L23:
        if (((Boolean) r103).booleanValue() == false) goto L26;
        g49.d.d("DoraBtPermissionGuide", "ChannelStrategy allows, short-circuit to true");
        return Boxing.boxBoolean(true);
    L26:
        g49.d.d("DoraBtPermissionGuide", "isGuideConditionMet(), checking user strategy");
        com.larus.dora.impl.guide.strategy.c r108 = (com.larus.dora.impl.guide.strategy.c) this.f335907i.getValue();
        r101.label = 2;
        r103 = r108.a();
        if (r103 != r104) goto L30;
        return r104;
    L19:
        ResultKt.throwOnFailure(r103);
        g49.d.d("DoraBtPermissionGuide", "isChannelOrUserStrategyMet(), checking strategy");
        g49.d.d("DoraBtPermissionGuide", "isGuideConditionMet(), checking channel strategy");
        com.larus.dora.impl.guide.strategy.b r109 = (com.larus.dora.impl.guide.strategy.b) this.f335908j.getValue();
        r101.label = 1;
        r103 = r109.a();
        if (r103 != r104) goto L23;
        return r104;
    L38:
        e = move-exception;
        g49.d.c("DoraBtPermissionGuide", "NotNewUserStrategy check failed: " + e.getMessage(), e);
        r106 = false;
    L7:
        r101 = new DoraBtPermissionGuide$isChannelOrUserStrategyMet$1(this, r100);
        goto L8
    }

    public final void i(int r100) {
        if (this.f335903e != r100) goto L5;
        return;
    L5:
        int r101 = this.f335903e;
        this.f335903e = r100;
        g49.d.d("DoraBtPermissionGuide", "Guide state changed: prev=" + r101 + ", new=" + r100);
        t39.m r102 = this.f335904f;
        if (r102 == null) goto L9;
        r102.b(this, this.f335903e, r101);
        return;
    }

    @Override // t39.l
    public final Object d(Fragment r100, View r101, Continuation<? super Unit> r102) {
        g49.d.d("DoraBtPermissionGuide", "dismissGuide() called, no-op");
        return Unit.INSTANCE;
    }

    @Override // t39.l
    public final Object e(Fragment r110, View r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof DoraBtPermissionGuide$showGuide$1) == false) goto L7;
        DoraBtPermissionGuide$showGuide$1 r100 = (DoraBtPermissionGuide$showGuide$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 != 1) goto L15;
        r110 = (Fragment) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Exception -> L26
    L13:
        Fragment r104 = r110;
        i2 r114 = i2.f365748b;     // Catch: Exception -> L26
        ((com.larus.dora.impl.guide.strategy.a) this.f335905g.getValue()).getClass();     // Catch: Exception -> L26
        List r105 = com.larus.dora.impl.guide.strategy.a.a();     // Catch: Exception -> L26
        b r106 = new b(this);     // Catch: Exception -> L26
        ((com.larus.dora.impl.guide.strategy.a) this.f335905g.getValue()).getClass();     // Catch: Exception -> L26
        g1.a.a(r104, r105, r106, com.larus.dora.impl.guide.strategy.a.b(), null, 16);     // Catch: Exception -> L26
        DoraBuryPointManager.f331862a.H(this.f335899a);     // Catch: Exception -> L26
    L31:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r113);
        g49.d.d("DoraBtPermissionGuide", "showGuide() called, fragment=" + r110 + ", anchorView=" + r111);
        if (h() == true) goto L19;
        g49.d.d("DoraBtPermissionGuide", "update state to SHOWING");
        ((com.larus.dora.impl.guide.strategy.c) this.f335907i.getValue()).b();     // Catch: Exception -> L26
        com.larus.dora.impl.guide.strategy.b r115 = (com.larus.dora.impl.guide.strategy.b) this.f335908j.getValue();     // Catch: Exception -> L26
        r100.L$0 = r110;     // Catch: Exception -> L26
        r100.label = 1;     // Catch: Exception -> L26
        if (r115.b() != r102) goto L13;
        return r102;
    L19:
        return Unit.INSTANCE;
    L26:
        e = move-exception;
        g49.d.c("DoraBtPermissionGuide", "showGuide() permission request failed: " + e.getMessage(), e);
        i(404);
        g49.d.d("DoraBtPermissionGuide", "onReadyShowNextGuide() triggered after error");
        t39.m r116 = this.f335904f;
        if (r116 == null) goto L31;
        r116.a(this);
    L7:
        r100 = new DoraBtPermissionGuide$showGuide$1(this, r112);
        goto L8
    }

    public DoraBtPermissionGuide(String r100, boolean r101, long r102, List<String> r103) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r103, "targetChannels");
        this.f335899a = r100;
        this.f335900b = r101;
        this.f335901c = r102;
        this.f335902d = r103;
        this.f335905g = LazyKt.lazy(new s());
        this.f335906h = LazyKt.lazy(new t());
        this.f335907i = LazyKt.lazy(new u(this));
        this.f335908j = LazyKt.lazy(new v(this));
    }
}
