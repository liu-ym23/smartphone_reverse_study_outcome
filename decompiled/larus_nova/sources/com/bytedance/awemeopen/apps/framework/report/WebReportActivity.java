package com.bytedance.awemeopen.apps.framework.report;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/report/WebReportActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class WebReportActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f197609a = 0;

    public static final class a {
        public static void a(Context r100, int r101, String r102, String r103, String r110, String r111, int r112) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "objectId");
            Intrinsics.checkNotNullParameter(r103, "authorOpenId");
            Intrinsics.checkNotNullParameter(r110, "enterFrom");
            Intrinsics.checkNotNullParameter(r111, "hostEnterFrom");
            Intent r104 = new Intent(r100, WebReportActivity.class);
            r104.addFlags(268435456);
            r104.putExtra("reportType", r101);
            r104.putExtra("enterFrom", r110);
            r104.putExtra("objectId", r102);
            r104.putExtra("authorOpenId", r103);
            r104.putExtra("hostEnterFrom", r111);
            r104.putExtra("awemeType", r112);
            r100.startActivity(r104);
        }
    }

    static {
    }

    public WebReportActivity() {
        new LinkedHashMap();
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(WebReportActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(WebReportActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        super.onBackPressed();
    }

    public static View y1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        if (Build.VERSION.SDK_INT < 23) goto L13;
        y1(getWindow()).setSystemUiVisibility(8192);
    L13:
        Fragment r101 = getSupportFragmentManager().findFragmentByTag("tag_AosWebReportFragment");
        if (r101 != null) goto L16;
        r101 = new AosWebReportFragment();
        r101.setArguments(getIntent().getExtras());
    L16:
        int r102 = com.bytedance.awemeopen.apps.framework.utils.d.f197686a;
        com.bytedance.awemeopen.apps.framework.utils.d.a.c(getSupportFragmentManager(), R.id.content, r101, "tag_AosWebReportFragment");
    }
}
