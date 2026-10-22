package com.bytedance.applet.debugger;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.api.DebuggerOpenArgs;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u0011\u001a\u00020\u0006H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/applet/debugger/AppletDebuggerActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/bytedance/ai/api/IAppletDebuggerActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onActivityResult", "requestCode", "", "resultCode", "data", "onDestroy", "createHostContainer", "Landroidx/fragment/app/FragmentContainerView;", "registerBackHandler", "handleOpenIntent", "", "attachHost", "Lcom/bytedance/applet/debugger/AppletDebuggerHostFragment;", "openArgs", "Lcom/bytedance/ai/api/DebuggerOpenArgs;", "findHost", "getChatFragment", "Landroidx/fragment/app/Fragment;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDebuggerActivity extends FlowCommonAppCompatActivity implements com.bytedance.ai.api.n {
    public static final /* synthetic */ int g = 0;

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
        r2.i("ActivityLancet", "finish ".concat(AppletDebuggerActivity.class.getName()));
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

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppletDebuggerActivity.class.getName()));
    L5:
        IAISDKDebugService.a.c(null);
        super.onDestroy();
    }

    public final AppletDebuggerHostFragment O1() {
        Fragment r0 = getSupportFragmentManager().findFragmentByTag("applet_debugger_host");
        if ((r0 instanceof AppletDebuggerHostFragment) == true) goto L7;
        return null;
    L7:
        return (AppletDebuggerHostFragment) r0;
    }

    public final Fragment getChatFragment() {
        AppletDebuggerHostFragment r0 = O1();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getChatFragment();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        N1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public AppletDebuggerActivity() {
    }

    public static View N1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final boolean P1(Intent r12) {
        final DebuggerOpenArgs r1 = null;
        if (r12 == null) goto L5;
        Serializable r13 = r12.getSerializableExtra("applet_debugger_open_args");
    L7:
        if ((r13 instanceof DebuggerOpenArgs) == false) goto L9;
        r1 = (DebuggerOpenArgs) r13;
    L9:
        if (r1 != null) goto L12;
        FLogger.a.e("AppletDebuggerActivity", "Debugger open args are missing");
        return false;
    L12:
        final AppletDebuggerHostFragment r14 = O1();
        if (r14 == null) goto L15;
        Intrinsics.checkNotNullParameter(r1, "args");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14.getViewLifecycleOwner()), null, null, new AppletDebuggerHostFragment$switchMode$1(r14, r1.getMode(), new k(r14, r1), new l(r14, r1), null), 3, null);
        return true;
    L15:
        int r15 = AppletDebuggerHostFragment.m;
        Intrinsics.checkNotNullParameter(r1, "args");
        AppletDebuggerHostFragment r16 = new AppletDebuggerHostFragment();
        Bundle r2 = new Bundle();
        r2.putSerializable("applet_debugger_open_args", r1);
        r16.setArguments(r2);
        FragmentTransaction r0 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r16, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "applet_debugger_host", 2131363153) == true) goto L19;
        r0 = r0.replace(2131363153, r16, "applet_debugger_host");
    L19:
        r0.commitNow();
        return true;
    L5:
        r13 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r4) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r4);
        FragmentContainerView r0 = new FragmentContainerView(this);
        r0.setId(2131363153);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(r0);
        Window r1 = getWindow();
        if (r1 == null) goto L13;
        View r2 = N1(r1);
    L14:
        setRootView(r2);
        L1();
        getOnBackPressedDispatcher().addCallback(this, new AppletDebuggerActivity$registerBackHandler$1(this));
        if (r4 != null) goto L20;
        if (P1(getIntent()) == true) goto L25;
        finish();
        return;
    L25:
        return;
    L20:
        if (O1() != null) goto L27;
        FLogger.a.e("AppletDebuggerActivity", "restored Debugger host is missing");
        finish();
        return;
    L27:
        return;
    L13:
        r2 = null;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNewIntent(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r2);
        setIntent(r2);
        if (P1(r2) == true) goto L6;
        finish();
        return;
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r4 == null) goto L15;
        Bundle r5 = r4.getExtras();
        if (r5 == null) goto L16;
        AppletDebuggerHostFragment r6 = O1();
        if (r6 == null) goto L17;
        Intrinsics.checkNotNullParameter(r5, "bundle");
        xe8.a r7 = r6.getChatFragment();
        if ((r7 instanceof xe8.a) == false) goto L11;
        xe8.a r8 = r7;
    L12:
        if (r8 == null) goto L18;
        r8.Lc(r5, 100, -1);
        return;
    L18:
        return;
    L11:
        r8 = null;
        goto L12
    L17:
        return;
    L16:
        return;
    }
}
