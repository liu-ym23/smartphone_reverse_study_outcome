package com.larus.dora.impl.guide;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.dora.device.DoraDevice;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraGuideService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraTextBtnBalloonBinding;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.service.GuideSession$setStateListener$1;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.settings.value.e10;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.BalloonCenterAlign;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraKeepAliveGuide implements t39.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f335913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f335914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f335915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f335916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f335917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t39.m f335918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Balloon f335919g;

    public static final class a {
    }

    static {
    }

    @Override // t39.l
    public final Unit a() {
        g49.d.d("DoraKeepAliveGuide", "startGuide()");
        if (h() == true) goto L5;
        i(1);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // t39.l
    public final int f() {
        return DoraGuideMeta.DoraKeepAliveGuide.getGuideId();
    }

    public final boolean h() {
        IDoraGuideService r100 = (IDoraGuideService) ServiceManager.get().getService(IDoraGuideService.class);
        if (r100 == null) goto L5;
        boolean r101 = r100.b();
    L6:
        if (r101 == false) goto L8;
        g49.d.d("DoraKeepAliveGuide", "guide suppressed: dora guide is degraded");
    L8:
        return r101;
    L5:
        r101 = true;
        goto L6
    }

    public final String toString() {
        return "DoraKeepAliveGuide(state=" + this.f335917e + ')';
    }

    public DoraKeepAliveGuide(String r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        this.f335913a = r100;
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r101 == null) goto L5;
        long r102 = r101.t();
    L6:
        this.f335914b = r102;
        IDoraService r103 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r103 == null) goto L9;
        int r104 = r103.F();
    L10:
        this.f335915c = r104;
        this.f335916d = LazyKt.lazy(new d0());
        return;
    L9:
        r104 = 3;
        goto L10
    L5:
        r102 = 10000;
        goto L6
    }

    @Override // t39.l
    public final void b(GuideSession$setStateListener$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        g49.d.d("DoraKeepAliveGuide", "setStateListener() called with " + r100);
        this.f335918f = r100;
    }

    @Override // t39.l
    public final Object c(Continuation<? super Boolean> r110) {
        if ((r110 instanceof DoraKeepAliveGuide$isGuideConditionMet$1) == false) goto L7;
        DoraKeepAliveGuide$isGuideConditionMet$1 r100 = (DoraKeepAliveGuide$isGuideConditionMet$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        DoraDevice r105 = (DoraDevice) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L74:
        if (((Boolean) r111).booleanValue() == false) goto L78;
        return Boxing.boxBoolean(true);
    L78:
        if (com.larus.dora.impl.alive.a.a((IFlowCompanionDeviceManager) this.f335916d.getValue()) == false) goto L103;
        IFlowCompanionDeviceManager r112 = (IFlowCompanionDeviceManager) this.f335916d.getValue();
        if (r112 != null) goto L82;
    L84:
        boolean r113 = false;
    L85:
        if (r113 == true) goto L93;
        IFlowCompanionDeviceManager r114 = (IFlowCompanionDeviceManager) this.f335916d.getValue();
        if (r114 != null) goto L89;
    L91:
        boolean r115 = false;
    L92:
        if (r115 == true) goto L93;
    L102:
        return Boxing.boxBoolean(!r104);
    L89:
        if (r114.c(r105.f204390sn) != true) goto L91;
        r115 = true;
    L93:
        IFlowCompanionDeviceManager r116 = (IFlowCompanionDeviceManager) this.f335916d.getValue();
        if (r116 != null) goto L96;
    L98:
        boolean r117 = false;
    L99:
        if (r117 == false) goto L102;
        r104 = true;
        goto L102
    L96:
        if (r116.m(r105.f204389mac) != true) goto L98;
        r117 = true;
        goto L99
    L82:
        if (r112.b(r105.f204389mac) != true) goto L84;
        r113 = true;
        goto L85
    L103:
        int r118 = com.larus.dora.impl.alive.y.f332024a;
        AppHost.Companion r119 = AppHost.f326268a;
        Object r106 = r119.getApplication().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        if ((r106 instanceof PowerManager) == false) goto L106;
        PowerManager r107 = (PowerManager) r106;
    L107:
        if (r107 != null) goto L110;
    L112:
        boolean r120 = false;
    L113:
        if (r120 == false) goto L117;
        g49.d.d("DoraKeepAliveGuide", "checkShowState: ignoring battery optimizations enabled, not shown");
        return Boxing.boxBoolean(false);
    L117:
        return Boxing.boxBoolean(true);
    L110:
        if (Build.VERSION.SDK_INT < 23) goto L112;
        r120 = r107.isIgnoringBatteryOptimizations(r119.getApplication().getPackageName());
        goto L113
    L106:
        r107 = null;
        goto L107
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        IObricDoraService r121 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r121 != null) goto L17;
    L19:
        boolean r122 = false;
    L20:
        if (r122 == false) goto L24;
        g49.d.d("DoraKeepAliveGuide", "Keep-alive guide condition not met: hidden by Obric");
        return Boxing.boxBoolean(false);
    L24:
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L28;
        g49.d.d("DoraKeepAliveGuide", "Keep-alive guide condition not met: user not login");
        return Boxing.boxBoolean(false);
    L28:
        if (h() == true) goto L30;
        e10 r123 = e10.f368561a;
        boolean r124 = e10.N();
        com.larus.dora.impl.util.b0.f338123a.getClass();
        if (com.larus.dora.impl.util.b0.j().getBoolean("dora_cdm_keep_alive_nova", false) == false) goto L35;
        if (r124 == true) goto L35;
        boolean r108 = true;
    L37:
        if (com.larus.dora.impl.util.b0.j().getInt("dora_keep_alive_balloon_close_times", 0) < this.f335915c) goto L39;
        boolean r109 = true;
    L40:
        g49.d.d("DoraKeepAliveGuide", "closeTimes=" + com.larus.dora.impl.util.b0.j().getInt("dora_keep_alive_balloon_close_times", 0) + ", bubbleCounts=" + this.f335915c + ", isCdmKeepAliveNovaClosed=" + r108 + ", isCdmKeepAliveNovaEnabled=" + r124);
        if (r109 == false) goto L46;
        if (r108 == false) goto L46;
        com.larus.dora.impl.util.b0.j().storeBoolean("dora_cdm_keep_alive_nova", false);
        int r125 = com.larus.dora.impl.util.b0.j().getInt("dora_keep_alive_balloon_close_times", 0);
        if (r125 <= 0) goto L50;
        com.larus.dora.impl.util.b0.j().storeInt("dora_keep_alive_balloon_close_times", r125 - 1);
    L50:
        DoraDevice r126 = DoraAdapterExtKt.h(kj4.a.g());
        int r127 = kj4.a.g().getDoraLinkState(r126);
        if (r126 == null) goto L119;
        if (r127 != 2) goto L119;
        ArrayList r128 = (ArrayList) com.larus.dora.impl.util.b0.i();
        if (r128.isEmpty() == false) goto L58;
        int r129 = 0;
    L66:
        if (r129 < 1) goto L69;
        g49.d.d("DoraKeepAliveGuide", "checkShowState: today is shown more than 1");
        return Boxing.boxBoolean(false);
    L69:
        kj4.a r130 = kj4.a.g();
        r100.L$0 = r126;
        r100.label = 1;
        Object r131 = DoraAdapterExtKt.s(r130);
        if (r131 != r102) goto L72;
        return r102;
    L72:
        r105 = r126;
        r111 = r131;
        goto L74
    L58:
        Iterator r132 = r128.iterator();
        r129 = 0;
    L60:
        if (r132.hasNext() == false) goto L66;
        if (DateUtils.isToday(((Number) r132.next()).longValue()) == false) goto L60;
        r129 = r129 + 1;
        if (r129 >= 0) goto L60;
        CollectionsKt.throwCountOverflow();
    L119:
        return Boxing.boxBoolean(false);
    L46:
        com.larus.dora.impl.util.b0.j().storeBoolean("dora_cdm_keep_alive_nova", r124);
        if (r109 == false) goto L50;
        return Boxing.boxBoolean(false);
    L39:
        r109 = false;
    L35:
        r108 = false;
        goto L37
    L30:
        return Boxing.boxBoolean(false);
    L17:
        if (r121.j() != true) goto L19;
        r122 = true;
    L7:
        r100 = new DoraKeepAliveGuide$isGuideConditionMet$1(this, r110);
        goto L8
    }

    public final LarusDoraTextBtnBalloonBinding g(Fragment r100) {
        if (r100 == null) goto L5;
        final Context r101 = r100.getContext();
        if (r101 == null) goto L5;
    L6:
        final LarusDoraTextBtnBalloonBinding r102 = LarusDoraTextBtnBalloonBinding.a(LayoutInflater.from(r101));
        e1.d(r102.f333301c, new e0(r102));
        final g0 r103 = new g0(this);
        TextView r104 = r102.f333302d;
        int r105 = j0.f375426a;
        r104.setText(j0.d(R.string.larus_dora_keep_alive_cdn_balloon_tips_cn));
        r102.f333300b.setText(j0.d(R.string.larus_dora_btn_turn_on_cn));
        e1.d(r102.f333300b, new f0(r101, r103));
        return r102;
    L5:
        r101 = AppHost.f326268a.getApplication();
        goto L6
    }

    public final void i(int r100) {
        if (this.f335917e != r100) goto L5;
        return;
    L5:
        int r101 = this.f335917e;
        this.f335917e = r100;
        g49.d.d("DoraKeepAliveGuide", "Guide state changed: prev=" + r101 + ", new=" + r100);
        t39.m r102 = this.f335918f;
        if (r102 == null) goto L9;
        r102.b(this, r100, r101);
        return;
    }

    @Override // t39.l
    public final Object d(Fragment r100, View r101, Continuation<? super Unit> r102) {
        g49.d.d("DoraKeepAliveGuide", "dismissGuide() called, fragment=" + r100 + ", anchorView=" + r101);
        Balloon r103 = this.f335919g;     // Catch: Exception -> L10
        if (r103 == null) goto L6;
        r103.h();     // Catch: Exception -> L10
    L6:
        this.f335919g = null;     // Catch: Exception -> L10
        i(3);     // Catch: Exception -> L10
        g49.d.d("DoraKeepAliveGuide", "onReadyShowNextGuide() triggered after dismissGuide");     // Catch: Exception -> L10
        t39.m r104 = this.f335918f;     // Catch: Exception -> L10
        if (r104 == null) goto L15;
        r104.a(this);     // Catch: Exception -> L10
    L15:
        return Unit.INSTANCE;
    L10:
        e = move-exception;
        g49.d.c("DoraKeepAliveGuide", "dismissGuide() exception: " + e.getMessage(), e);
        i(404);
        t39.m r105 = this.f335918f;
        if (r105 == null) goto L15;
        r105.a(this);
        goto L15
    }

    @Override // t39.l
    public final Object e(Fragment r100, View r101, Continuation<? super Unit> r110) {
        g49.d.d("DoraKeepAliveGuide", "showGuide() called, fragment=" + r100 + ", anchorView=" + r101);
        if (h() == true) goto L5;
        i(2);
        LarusDoraTextBtnBalloonBinding r102 = g(r100);     // Catch: Exception -> L24
        if (r100 == null) goto L11;
        Context r103 = r100.getContext();     // Catch: Exception -> L24
        if (r103 == null) goto L11;
    L12:
        Balloon.a r104 = new Balloon.a(r103);     // Catch: Exception -> L24
        r104.f406037d = 1.0f;     // Catch: Exception -> L24
        r104.j(86);     // Catch: Exception -> L24
        r104.f406065z = 16.0f;     // Catch: Exception -> L24
        r104.e(ArrowPositionRules.ALIGN_BALLOON);     // Catch: Exception -> L24
        r104.f(0);     // Catch: Exception -> L24
        r104.f406055p = 0.5f;     // Catch: Exception -> L24
        r104.f406061v = 0;     // Catch: Exception -> L24
        r104.g(BalloonAnimation.FADE);     // Catch: Exception -> L24
        r104.f406044g0 = false;     // Catch: Exception -> L24
        r104.W = r100;     // Catch: Exception -> L24
        r104.V = this.f335914b;     // Catch: Exception -> L24
        r104.h(false);     // Catch: Exception -> L24
        r104.k(r102);     // Catch: Exception -> L24
        r104.l(new c0(this));     // Catch: Exception -> L24
        Balloon r105 = r104.b();     // Catch: Exception -> L24
        com.larus.dora.impl.util.b0 r106 = com.larus.dora.impl.util.b0.f338123a;     // Catch: Exception -> L24
        long r107 = System.currentTimeMillis();     // Catch: Exception -> L24
        r106.getClass();     // Catch: Exception -> L24
        com.larus.dora.impl.util.b0.a(r107);     // Catch: Exception -> L24
        int r108 = j49.a.f497373a;     // Catch: Exception -> L24
        j49.a.d();     // Catch: Exception -> L24
        this.f335919g = r105;     // Catch: Exception -> L24
        r102.f333299a.setTag(r105);     // Catch: Exception -> L24
        if (r101 == null) goto L15;
        r105.s(r101, 0, c7.b(Boxing.boxInt(8)));     // Catch: Exception -> L24
    L29:
        return Unit.INSTANCE;
    L15:
        if (r100 == null) goto L17;
        View r109 = r100.getView();     // Catch: Exception -> L24
    L18:
        if (r109 == null) goto L20;
        r105.y(r109, 0, 0, BalloonCenterAlign.TOP);     // Catch: Exception -> L24
        goto L29
    L20:
        g49.d.b("DoraKeepAliveGuide", "showGuide() failed: no anchor and fragment view is null");     // Catch: Exception -> L24
        i(404);     // Catch: Exception -> L24
        t39.m r111 = this.f335918f;     // Catch: Exception -> L24
        if (r111 == null) goto L29;
        r111.a(this);     // Catch: Exception -> L24
        goto L29
    L17:
        r109 = null;
    L11:
        r103 = AppHost.f326268a.getApplication();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        g49.d.c("DoraKeepAliveGuide", "showGuide() exception: " + e.getMessage(), e);
        i(404);
        g49.d.d("DoraKeepAliveGuide", "onReadyShowNextGuide() triggered after error");
        t39.m r112 = this.f335918f;
        if (r112 == null) goto L29;
        r112.a(this);
        goto L29
    L5:
        return Unit.INSTANCE;
    }
}
