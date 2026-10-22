package com.obric.autoaction.app.launcherpage.knowledge;

import android.R;
import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.volcengine.zeus.activity.GenerateProxyActivity;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class KnowledgeStubActivity extends GenerateProxyActivity {
    public void com_obric_autoaction_app_launcherpage_knowledge_KnowledgeStubActivity__finish$___twin___() {
        super.finish();
    }

    public void com_obric_autoaction_app_launcherpage_knowledge_KnowledgeStubActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.volcengine.zeus.activity.GenerateProxyActivity, android.app.Activity, com.volcengine.zeus.activity.b
    public void finish() {
        com_obric_autoaction_app_launcherpage_knowledge_KnowledgeStubActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // com.volcengine.zeus.activity.GenerateProxyActivity, com.volcengine.zeus.activity.b
    public String getPluginPkgName() {
        return "com.obric.aiagent.plugin";
    }

    @Override // com.volcengine.zeus.activity.GenerateProxyActivity, android.app.Activity
    public void onStop() {
        com_obric_autoaction_app_launcherpage_knowledge_KnowledgeStubActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public KnowledgeStubActivity() {
    }

    public static View INVOKEVIRTUAL_com_obric_autoaction_app_launcherpage_knowledge_KnowledgeStubActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void com_obric_autoaction_app_launcherpage_knowledge_KnowledgeStubActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(KnowledgeStubActivity r1) {
        r1.com_obric_autoaction_app_launcherpage_knowledge_KnowledgeStubActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_obric_autoaction_app_launcherpage_knowledge_KnowledgeStubActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_autoaction_app_launcherpage_knowledge_KnowledgeStubActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(KnowledgeStubActivity r11) {
        r11.com_obric_autoaction_app_launcherpage_knowledge_KnowledgeStubActivity__finish$___twin___();
        if ((r11 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((r11 instanceof ChatWindowActivity) == false) goto L8;
        return;
    L8:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(r11.getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(r11);     // Catch: Throwable -> L53
        if (r6 != null) goto L13;
    L16:
        r5.put(r11, Long.valueOf(r3));     // Catch: Throwable -> L53
        monitor-exit(r5);     // Catch: Throwable -> L53
    L50:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L19:
        if (((FragmentActivity) r11).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r2.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) r11).getLifecycle().getCurrentState());     // Catch: Throwable -> L50
        return;
    L23:
        if (r11.isFinishing() == true) goto L27;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L50
        return;
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L31;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L50
        return;
    L31:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L35;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L50
        return;
    L35:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L39;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L50
        return;
    L39:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L41;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L50
        return;
    L41:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L50
        if (r1 != null) goto L44;
        return;
    L44:
        r1.addFlags(268435456);     // Catch: Throwable -> L50
        r1.addFlags(2097152);     // Catch: Throwable -> L50
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L50
        r11.startActivity(r1);     // Catch: Throwable -> L47
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L47
    L61:
        return;
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L50
        return;
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    }
}
