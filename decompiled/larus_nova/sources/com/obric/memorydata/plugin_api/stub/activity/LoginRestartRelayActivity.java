package com.obric.memorydata.plugin_api.stub.activity;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.memorydata.plugin_api.login.LoginRestartRelayProtocol;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nka.a;
import nka.b;
import v19.f;

/* JADX INFO: loaded from: classes33.dex */
public class LoginRestartRelayActivity extends Activity {
    private static final String[] MEMORY_TASK_ACTIVITY_PREFIXES = null;
    private static final int PROCESS_EXIT_POLL_COUNT = 20;
    private static final long PROCESS_EXIT_POLL_INTERVAL_MS = 50;
    private static final String TAG = "LoginRestartRelay";
    private final Handler mainHandler;

    public static /* synthetic */ void a(LoginRestartRelayActivity r100, LoginRestartRelayProtocol.RestoreRequest r101) {
        r100.lambda$onCreate$0(r101);
    }

    public static /* synthetic */ void b(LoginRestartRelayActivity r100, LoginRestartRelayProtocol.RestoreRequest r101) {
        r100.lambda$restartAndRestore$1(r101);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public void com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity__finish$___twin___() {
        super.finish();
    }

    public void com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    public void finish() {
        com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r100) {
        com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // android.app.Activity
    public void onStop() {
        com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    static {
        MEMORY_TASK_ACTIVITY_PREFIXES = new String[]{"com.obric.memorydata.memory.ui.", "com.obric.memorydata.plugin_api.stub.activity."};
    }

    private void clearOtherMemoryTasks() {
        ActivityManager r100 = (ActivityManager) getSystemService(ActivityManager.class);
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<ActivityManager.AppTask> r101 = r100.getAppTasks().iterator();
    L7:
        if (r101.hasNext() == false) goto L19;
        ActivityManager.AppTask r102 = r101.next();
        ActivityManager.RecentTaskInfo r103 = r102.getTaskInfo();     // Catch: RuntimeException -> L18
        if (r103 == null) goto L7;
        if (r103.id == getTaskId()) goto L7;
        if (isMemoryTask(r103) == false) goto L7;
        r102.finishAndRemoveTask();     // Catch: RuntimeException -> L18
        goto L7
    }

    public LoginRestartRelayActivity() {
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    private void finishRelay() {
        finish();
        overridePendingTransition(0, 0);
    }

    public static View INVOKEVIRTUAL_com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LoginRestartRelayActivity r100) {
        r100.com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(LoginRestartRelayActivity r110) {
        r110.com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity__finish$___twin___();
        if ((r110 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((r110 instanceof ChatWindowActivity) == false) goto L8;
        return;
    L8:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(r110.getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(r110);     // Catch: Throwable -> L53
        if (r103 != null) goto L13;
    L16:
        r102.put(r110, Long.valueOf(r101));     // Catch: Throwable -> L53
        monitor-exit(r102);     // Catch: Throwable -> L53
    L50:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L19:
        if (((FragmentActivity) r110).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r100.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) r110).getLifecycle().getCurrentState());     // Catch: Throwable -> L50
        return;
    L23:
        if (r110.isFinishing() == true) goto L27;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L50
        return;
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(r110) == true) goto L31;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L50
        return;
    L31:
        if (ActivityLancet.isOnlyActivityInTask(r110) == true) goto L35;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L50
        return;
    L35:
        if (ActivityLancet.isExcludedActivity(r110) == false) goto L39;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L50
        return;
    L39:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L41;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L50
        return;
    L41:
        Intent r104 = r110.getPackageManager().getLaunchIntentForPackage(r110.getPackageName());     // Catch: Throwable -> L50
        if (r104 != null) goto L44;
        return;
    L44:
        r104.addFlags(268435456);     // Catch: Throwable -> L50
        r104.addFlags(2097152);     // Catch: Throwable -> L50
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r110);     // Catch: Throwable -> L50
        r110.startActivity(r104);     // Catch: Throwable -> L47
        r110.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L47
    L61:
        return;
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L50
        return;
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    }

    private boolean isMemoryTask(ActivityManager.RecentTaskInfo r100) {
        ComponentName r101 = r100.baseActivity;
        String r102 = null;
        if (r101 != null) goto L5;
        String r103 = null;
    L7:
        if (matchesMemoryActivity(r103) == true) goto L16;
        ComponentName r104 = r100.topActivity;
        if (r104 == null) goto L13;
        r102 = r104.getClassName();
    L13:
        if (matchesMemoryActivity(r102) == true) goto L16;
        return false;
    L16:
        return true;
    L5:
        r103 = r101.getClassName();
        goto L7
    }

    private boolean isProcessRunning(int r100) {
        ActivityManager r101 = (ActivityManager) getSystemService(ActivityManager.class);
        if (r101 != null) goto L5;
        return false;
    L5:
        List<ActivityManager.RunningAppProcessInfo> r102 = r101.getRunningAppProcesses();
        if (r102 != null) goto L8;
        return false;
    L8:
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L15;
        if (r103.next().pid != r100) goto L10;
        return true;
    L15:
        return false;
    }

    private /* synthetic */ void lambda$onCreate$0(LoginRestartRelayProtocol.RestoreRequest r100) {
        restartAndRestore(r100);
    }

    private /* synthetic */ void lambda$restartAndRestore$1(LoginRestartRelayProtocol.RestoreRequest r100) {
        Intent r101 = r100.getIntent();
        if (r101 != null) goto L10;
    L8:
        finishRelay();
        return;
    L10:
        r101.addFlags(268435456);     // Catch: RuntimeException -> L7
        startActivity(r101);     // Catch: RuntimeException -> L7
        goto L8
    }

    private boolean matchesMemoryActivity(String r100) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L14;
        String[] r101 = MEMORY_TASK_ACTIVITY_PREFIXES;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L14;
        if (r100.startsWith(r101[r103]) == true) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return true;
    }

    private void restartAndRestore(final LoginRestartRelayProtocol.RestoreRequest r100) {
        int r101 = r100.getSourcePid();
        if (r101 > 0) goto L5;
    L7:
        this.mainHandler.post(new b(this, r100));
        return;
    L5:
        if (r101 == Process.myPid()) goto L7;
        Process.killProcess(r101);
        waitForProcessExit(r101);
        goto L7
    }

    private void waitForProcessExit(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= 20) goto L17;
        if (isProcessRunning(r100) == false) goto L7;
        Thread.sleep(50);     // Catch: InterruptedException -> L11
        r101 = r101 + 1;
    L11:
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L7:
        return;
    }

    public void com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity__onCreate$___twin___(Bundle r100) {
        super.onCreate(r100);
        overridePendingTransition(0, 0);
        final LoginRestartRelayProtocol.RestoreRequest r101 = LoginRestartRelayProtocol.consume();     // Catch: RuntimeException -> L9
        if (r101 != null) goto L7;
        finishRelay();
        return;
    L7:
        clearOtherMemoryTasks();
        ThreadMethodProxy.start(new PthreadThreadV2(new a(this, r101), "memory-login-restart"));
        return;
    L9:
        finishRelay();
    }

    public static void com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(LoginRestartRelayActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r100) == false) goto L8;
        f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity__onCreate$___twin___(r101);
    }
}
