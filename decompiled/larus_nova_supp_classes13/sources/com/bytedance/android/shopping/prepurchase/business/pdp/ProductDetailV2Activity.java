package com.bytedance.android.shopping.prepurchase.business.pdp;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;
import com.bytedance.android.shopping.anchorv3.utils.b0;
import com.bytedance.android.shopping.anchorv4.containers.k;
import com.bytedance.android.shopping.anchorv4.helper.t;
import com.bytedance.android.shopping.anchorv4.helper.u;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.prepurchase.arch.container.component.ServiceRegistryImpl;
import com.bytedance.android.shopping.prepurchase.arch.container.model.Biz;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.android.shopping.utils.y;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.OSUtils;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vg3.i0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/ProductDetailV2Activity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "Lcom/bytedance/android/shopping/prepurchase/arch/container/intf/f;", "Lcom/bytedance/android/shopping/anchorv4/containers/h;", "Lp83/g;", "", "Landroidx/appcompat/app/AppCompatActivity;", "getContext", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProductDetailV2Activity extends AbsActivity implements com.bytedance.android.shopping.prepurchase.arch.container.intf.f, com.bytedance.android.shopping.anchorv4.containers.h, p83.g {
    public ImmersionBar j;
    public CompatFrameLayout k;
    public com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> l;
    public final k m;
    public boolean n;
    public com.bytedance.android.shopping.prepurchase.arch.container.intf.a o;
    public PdpRecoveryCompat p;

    public AppCompatActivity getContext() {
        return this;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final Object k7() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final void H() {
        k r0 = this.m;
        PdpRecoveryCompat r1 = this.p;
        if (r1 == null) goto L7;
        AnchorV4Param r2 = r1.a;
        if (r2 == null) goto L7;
        V4NativeParams r3 = r2.getNativeParams();
    L9:
        if (r0.b(r3) == false) goto L11;
        return;
    L11:
        if (isFinishing() == true) goto L15;
        finish();
        return;
    L15:
        return;
    L7:
        r3 = null;
        goto L9
    }

    public final void J1() {
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.l;
        if (r0 == null) goto L12;
        ServiceRegistryImpl r1 = r0.b;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("abilityRegistry");
    L7:
        if (r1 == null) goto L13;
        vg3.g r2 = (vg3.g) r1.getService(vg3.g.class);
        if (r2 == null) goto L14;
        r2.W0();
        return;
    L14:
        return;
    L13:
        return;
    }

    public final View N() {
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.l;
        if (r0 == null) goto L11;
        ServiceRegistryImpl r1 = r0.b;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("abilityRegistry");
    L7:
        if (r1 == null) goto L11;
        i0 r2 = (i0) r1.getService(i0.class);
        if (r2 == null) goto L11;
        return r2.N();
    L11:
        return null;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final ViewGroup getContainerView() {
        CompatFrameLayout r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layout");
    L5:
        return r0;
    }

    public final String getSessionId() {
        PdpRecoveryCompat r0 = this.p;
        if (r0 == null) goto L7;
        AnchorV4Param r1 = r0.a;
        if (r1 == null) goto L7;
        return r1.getSessionId();
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.a i7() {
        if (this.o != null) goto L16;
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.l;
        if (r0 == null) goto L14;
        com.bytedance.android.shopping.prepurchase.arch.container.d<STATE, PdpDataStore> r1 = r0.c;
        if (r1 != 0) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L9:
        og3.b<STATE> r2 = r1.d;
        if (r2 == 0) goto L14;
        e r3 = (e) r2.b;
        if (r3 == null) goto L14;
        boolean r4 = r3.b.a;
    L15:
        int r5 = y.a;
        this.o = new com.bytedance.android.shopping.prepurchase.arch.container.intf.a(y.e(null, Boolean.valueOf(r4), 1), k1.j(this), j56.a.b(this), k1.g());
    L14:
        r4 = false;
    L16:
        com.bytedance.android.shopping.prepurchase.arch.container.intf.a r6 = this.o;
        Intrinsics.checkNotNull(r6);
        return r6;
    }

    public final void onBackPressed() {
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.l;
        if (r0 != null) goto L5;
    L6:
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        return;
    L5:
        if (r0.a() != true) goto L6;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        ImmersionBar r0 = this.j;
        if (r0 == null) goto L9;
        r0.destroy();
    L9:
        if (this.n == true) goto L19;
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r1 = this.l;
        if (r1 == null) goto L18;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r2 = r1.a;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L16:
        r2.c(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle.Event.ON_DESTROY);
        return;
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProductDetailV2Activity() {
        this.m = new k(this);
        boolean r0 = com.bytedance.android.shopping.anchorv4.helper.a.a;
        com.bytedance.android.shopping.anchorv4.helper.a.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final Window f7() {
        return getWindow();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final FragmentManager g7() {
        return getSupportFragmentManager();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    /* JADX INFO: renamed from: getContext, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ FragmentActivity mo2525getContext() {
        return getContext();
    }

    public final void onPause() {
        super.onPause();
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.l;
        if (r0 == null) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r1 = r0.a;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L7:
        r1.c(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle.Event.ON_PAUSE);
        return;
    }

    public final void onResume() {
        super.onResume();
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.l;
        if (r0 == null) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r1 = r0.a;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L7:
        r1.c(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle.Event.ON_RESUME);
        return;
    }

    public final void onStart() {
        super.onStart();
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.l;
        if (r0 == null) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r1 = r0.a;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L7:
        r1.c(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle.Event.ON_START);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.l;
        if (r0 == null) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r1 = r0.a;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L7:
        r1.c(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle.Event.ON_STOP);
    L9:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L20;
        View r2 = getWindow().getDecorView();     // Catch: Throwable -> L17
        if (com.larus.home.impl.utils.c.e == false) goto L15;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L17
        Thread r3 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L17
        if (r3 == com.larus.home.impl.utils.c.a) goto L15;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");     // Catch: Throwable -> L17
    L15:
        r2.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L17
        return;
    L21:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y1() {
        super.y1();
        if (OSUtils.isEMUI3_0() == false) goto L5;
        return;
    L5:
        if (OSUtils.isEMUI3_1() == true) goto L16;
        int r0 = b0.a;
        b0.a(getWindow());
        ImmersionBar r1 = ImmersionBar.with(this);
        this.j = r1;
        if (r1 == null) goto L14;
        ImmersionBar r2 = r1.statusBarDarkFont(true);
        if (r2 == null) goto L15;
        r2.init();
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
    public final void e(boolean r2) {
        ImmersionBar r0 = this.j;
        if (r0 == null) goto L10;
        ImmersionBar r1 = r0.reset();
        if (r1 == null) goto L11;
        ImmersionBar r3 = r1.statusBarDarkFont(r2);
        if (r3 == null) goto L12;
        r3.init();
        return;
    L12:
        return;
    L11:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r7) {
        Intrinsics.checkNotNullParameter(r7, "newConfig");
        super/*androidx.appcompat.app.AppCompatActivity*/.onConfigurationChanged(r7);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L19;
        int r3 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r7 == null) goto L8;
        Integer r4 = Integer.valueOf(r7.orientation);     // Catch: Throwable -> L17
    L9:
        if (r4 != null) goto L12;
    L14:
        if (r3 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r4.intValue() == r3) goto L19;
    L8:
        r4 = null;
    L19:
        this.o = null;
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.l;
        if (r0 == null) goto L25;
        r0.b(r7);
        return;
    L25:
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r13) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        Lazy r0 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L13;
        TrackCatcher.a("product_detail");
    L13:
        Serializable r1 = getIntent().getSerializableExtra("param_key");
        if ((r1 instanceof AnchorV4Param) == true) goto L16;
        r1 = null;
    L16:
        AnchorV4Param r2 = (AnchorV4Param) r1;
        boolean r3 = true;
        if (r13 == null) goto L19;
        overridePendingTransition(2130772246, 2130772248);
    L25:
        super.onCreate(r13);
        int r4 = y.a;
        if (y.a() == true) goto L29;
        this.n = true;
        Set r14 = ECProcessMonitor.a;
        ECProcessMonitor.o().j(-3, "插件加载失败");
        finish();
        return;
    L29:
        if (r2 != null) goto L31;
        this.n = true;
        Set r15 = ECProcessMonitor.a;
        ECProcessMonitor.o().j(-3, "recovery failed");
        finish();
        return;
    L31:
        PdpRecoveryCompat r5 = new PdpRecoveryCompat(r2);
        this.p = r5;
        if (r13 != null) goto L34;
    L36:
        CompatFrameLayout r6 = new CompatFrameLayout(this, null, 6, 0);
        r6.setId(2131384842);
        Unit r7 = Unit.INSTANCE;
        this.k = r6;
        setContentView(r6);
        Bundle r8 = getIntent().getExtras();
        if (r8 != null) goto L39;
        r8 = r13;
    L39:
        if (r8 != null) goto L41;
    L43:
        boolean r9 = false;
    L44:
        PdpRecoveryCompat r10 = this.p;
        if (r10 != null) goto L47;
        this.n = true;
        Set r16 = ECProcessMonitor.a;
        ECProcessMonitor.o().j(-3, "setupContainer error. bundle is null");
        finish();
        return;
    L47:
        AnchorV4Param r11 = r10.a;
        og3.c r12 = new og3.c(Biz.PDP, r11.getSessionId(), new og3.a(r11.getNativeParams().getSourceBtmToken()));
        LinkedHashMap r17 = t.a;
        String r18 = r11.getSessionId();
        Intrinsics.checkNotNullParameter(r18, "sessionId");
        u r19 = (u) t.a.remove(r18);
        com.bytedance.android.shopping.prepurchase.arch.container.b r20 = new com.bytedance.android.shopping.prepurchase.arch.container.b(r12);
        if (r13 == null) goto L50;
        boolean r110 = true;
    L51:
        g r21 = new g(r11, r9, r19, null, r110);
        Intrinsics.checkNotNullParameter(r21, "factory");
        r20.d = r21;
        Intrinsics.checkNotNullParameter(this, "delegate");
        r20.e = this;
        if (r13 != null) goto L55;
        r3 = false;
    L55:
        d r22 = new d(r3);
        Intrinsics.checkNotNullParameter(r22, "service");
        r20.a = r22;
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r23 = new com.bytedance.android.shopping.prepurchase.arch.container.a(r20.a());
        this.l = r23;
        r23.c();
        this.m.c(r11.getNativeParams());
        return;
    L50:
        r110 = false;
        goto L51
    L41:
        if (r8.getBoolean("is_split_screen", false) != true) goto L43;
        r9 = true;
        goto L44
    L34:
        if (r5.a(r13) == true) goto L36;
        this.n = true;
        Set r111 = ECProcessMonitor.a;
        ECProcessMonitor.o().j(-3, "recovery failed");
        finish();
        return;
    L19:
        if (r2 == null) goto L24;
        V4NativeParams r24 = r2.getNativeParams();
        if (r24 == null) goto L24;
        if (r24.getHasCustomWindowAnimation() == true) goto L25;
    L24:
        overridePendingTransition(2130772245, 2130772253);
        goto L25
    }

    public final void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super.onSaveInstanceState(r2);
        PdpRecoveryCompat r0 = this.p;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }
}
