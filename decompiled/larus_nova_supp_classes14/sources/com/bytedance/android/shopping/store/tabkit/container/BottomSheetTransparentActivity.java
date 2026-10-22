package com.bytedance.android.shopping.store.tabkit.container;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.store.tabkit.TabKitAbilityConfig;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/BottomSheetTransparentActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomSheetTransparentActivity extends FragmentActivity {
    public static final /* synthetic */ int e = 0;
    public final BottomSheetTransparentActivity$fragmentLifeCallBack$1 a;
    public TabKitBottomSheetFragment b;
    public TabKitRouterParams c;
    public TabKitAbilityConfig d;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(BottomSheetTransparentActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z1() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        TabKitRouterParams r1 = this.c;     // Catch: Throwable -> L21
        if (r1 != null) goto L5;
    L19:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
        return;
    L5:
        if (r1.get_maskAlphaOpt() != true) goto L19;
        TabKitRouterParams r2 = this.c;     // Catch: Throwable -> L21
        if (r2 == null) goto L11;
        Double r3 = r2.getMaskAlpha();     // Catch: Throwable -> L21
        if (r3 == null) goto L11;
        float r4 = (float) r3.doubleValue();     // Catch: Throwable -> L21
    L13:
        if (r4 <= 0) goto L19;
        Window r5 = getWindow();     // Catch: Throwable -> L21
        if (r5 == null) goto L19;
        View r6 = y1(r5);     // Catch: Throwable -> L21
        if (r6 == null) goto L19;
        r6.setBackgroundColor(-16777216);     // Catch: Throwable -> L21
        r6.setAlpha(r4);     // Catch: Throwable -> L21
    L11:
        r4 = 0.0f;
    L21:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.shopping.store.tabkit.container.BottomSheetTransparentActivity$fragmentLifeCallBack$1] */
    public BottomSheetTransparentActivity() {
        this.a = new BottomSheetTransparentActivity$fragmentLifeCallBack$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static View y1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r8) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        d.a(this);
        Intent r0 = getIntent();
        Serializable r2 = null;
        if (r0 == null) goto L39;
        Bundle r1 = r0.getBundleExtra("biz_arguments");
        Context r3 = BadParcelableCrashOptimizer.getContext();
        if (r1 == null) goto L16;
        if (r3 == null) goto L16;
        r1.setClassLoader(r3.getClassLoader());
    L16:
        if (r1 == null) goto L39;
        long r4 = r1.getLong(TabkitFirstFramePref.KEY_TABKIT_MONITOR);
        Map<Long, TabkitFirstFramePref> r5 = ok3.a.e;
        TabkitFirstFramePref r6 = ok3.a.C0149a.a(r4);
        if (r6 == null) goto L21;
        TabkitFramePref.recordTime$default(r6, "t_on_create_activity", null, 2, null);
    L21:
        Object r7 = r1.get(TabKitRouterParams.KEY_ROUTER_PARAMS);
        if ((r7 instanceof TabKitRouterParams) == true) goto L24;
        r7 = null;
    L24:
        TabKitRouterParams r9 = (TabKitRouterParams) r7;
        if (r9 == null) goto L39;
        TabKitAbilityConfig r10 = new TabKitAbilityConfig(r9);
        this.c = r9;
        this.d = r10;
        if (r10.b("enable_anniex_async_create") == false) goto L39;
        if (r10.b("disable_anniex_container") == true) goto L39;
        if (r6 == null) goto L34;
        TabkitFramePref.recordTime$default(r6, "t_start_pre_create_annie", null, 2, null);
    L34:
        if (r1.getString("pre_create_anniex_uid") == null) goto L39;
        int r11 = ECSdk.a;
        IECHostService r12 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r12 == null) goto L39;
        r12.getECAnnieXHostService();
    L39:
        super.onCreate(r8);
        Intrinsics.checkNotNullParameter(this, "$this$makeStatusBarTransparent");
        l0.d(getWindow());
        TabKitAbilityConfig r13 = this.d;
        boolean r14 = true;
        if (r13 != null) goto L42;
    L44:
        boolean r15 = false;
    L45:
        if (r15 == false) goto L47;
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.a, false);
        z1();
    L47:
        Fragment r16 = getSupportFragmentManager().findFragmentByTag("tabkit_bottom_sheet_fragment");
        if ((r16 instanceof TabKitBottomSheetFragment) == true) goto L50;
        r16 = null;
    L50:
        TabKitBottomSheetFragment r17 = (TabKitBottomSheetFragment) r16;
        this.b = r17;
        if (r17 != null) goto L84;
        Serializable r18 = getIntent().getSerializableExtra("tabkit_fragment_clazz");
        if ((r18 instanceof Class) == false) goto L56;
        r2 = r18;
    L56:
        Class r19 = (Class) r2;
        if (r19 == null) goto L63;
        int r20 = TabKitBottomSheetFragment.p;
        Bundle r21 = getIntent().getBundleExtra("biz_arguments");
        Context r22 = BadParcelableCrashOptimizer.getContext();
        if (r21 == null) goto L62;
        if (r22 == null) goto L62;
        r21.setClassLoader(r22.getClassLoader());
    L62:
        this.b = TabKitBottomSheetFragment.a.a(r19, r21);
    L63:
        TabKitAbilityConfig r23 = this.d;
        if (r23 != null) goto L66;
    L68:
        boolean r24 = false;
    L69:
        if (r24 == false) goto L77;
        TabKitBottomSheetFragment r25 = this.b;
        if (r25 == null) goto L84;
        FragmentManager r26 = getSupportFragmentManager();
        LandscapeRestrictionOperation r27 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r25, "tabkit_bottom_sheet_fragment", r27);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r26, r25, r27) == true) goto L84;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L93
    L76:
        r25.showNow(r26, "tabkit_bottom_sheet_fragment");
        goto L84
    L77:
        TabKitBottomSheetFragment r28 = this.b;
        if (r28 == null) goto L84;
        FragmentManager r29 = getSupportFragmentManager();
        LandscapeRestrictionOperation r30 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r28, "tabkit_bottom_sheet_fragment", r30);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r29, r28, r30) == true) goto L84;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L94
    L83:
        r28.show(r29, "tabkit_bottom_sheet_fragment");
        goto L84
    L66:
        if (r23.b("tabkit_show_now") != true) goto L68;
        r24 = true;
    L84:
        TabKitAbilityConfig r31 = this.d;
        if (r31 != null) goto L87;
    L89:
        r14 = false;
    L90:
        if (r14 == true) goto L101;
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.a, false);
        z1();
        return;
    L101:
        return;
    L87:
        if (r31.b("tabkit_show_now") != true) goto L89;
    L42:
        if (r13.b("tabkit_show_now") != true) goto L44;
        r15 = true;
        goto L45
    }
}
