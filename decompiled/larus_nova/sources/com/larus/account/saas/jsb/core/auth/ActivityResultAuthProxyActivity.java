package com.larus.account.saas.jsb.core.auth;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sdk.account.platform.base.ActivityResultHandler;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/jsb/core/auth/ActivityResultAuthProxyActivity;", "Landroid/app/Activity;", "<init>", "()V", "account-saas-jsb-core_release"}, k = 1, mv = {1, 7, 1})
public final class ActivityResultAuthProxyActivity extends Activity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f286370d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActivityResultHandler f286371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f286372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f286373c;

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public final void b() {
        if (this.f286373c == false) goto L5;
        return;
    L5:
        this.f286373c = true;
        this.f286371a = null;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L12
        Function0<Unit> r101 = this.f286372b;     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        r101.invoke();     // Catch: Throwable -> L12
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L12
    L14:
        this.f286372b = null;
        finish();
        overridePendingTransition(0, 0);
        return;
    L9:
        r102 = null;
    L12:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0110 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ActivityResultAuthProxyActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L48
        if (r103 != null) goto L13;
    L16:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L48
        monitor-exit(r102);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r100.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r104 == null) goto L51;
        r104.addFlags(268435456);     // Catch: Throwable -> L45
        r104.addFlags(2097152);     // Catch: Throwable -> L45
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r104);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        if (this.f286373c == true) goto L14;
        this.f286373c = true;
        this.f286371a = null;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        Function0<Unit> r101 = this.f286372b;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        r101.invoke();     // Catch: Throwable -> L11
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L11
    L13:
        this.f286372b = null;
        goto L14
    L8:
        r102 = null;
    L11:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L14:
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public ActivityResultAuthProxyActivity() {
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        ConcurrentHashMap<String, a.C3942a> r101 = a.f286380a;
        Intent r102 = getIntent();
        if (r102 == null) goto L16;
        String r103 = r102.getStringExtra("account_saas_auth_request_id");
        if (r103 == null) goto L16;
        a.C3942a r104 = a.f286380a.remove(r103);
    L17:
        if (r104 != null) goto L24;
        b();
        return;
    L24:
        r104.f286381a.invoke(this);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        r104.f286382b.invoke(th);
        b();
        return;
    L16:
        r104 = null;
        goto L17
    }

    public final void a(ActivityResultHandler r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        if (this.f286373c == false) goto L7;
        if (r101 == null) goto L9;
        r101.invoke();
        return;
    L9:
        return;
    L7:
        this.f286371a = r100;
        this.f286372b = r101;
    }

    @Override // android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        ActivityResultHandler r103 = this.f286371a;
        if (r103 == null) goto L6;
        r103.onActivityResult(r100, r101, r102);
        return;
    }
}
