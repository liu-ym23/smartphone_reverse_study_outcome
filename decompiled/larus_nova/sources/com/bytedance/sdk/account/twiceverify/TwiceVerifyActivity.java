package com.bytedance.sdk.account.twiceverify;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.utils.b;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import pc7.d;
import pc7.e;
import v19.f;

/* JADX INFO: loaded from: classes22.dex */
public class TwiceVerifyActivity extends FragmentActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f269520f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f269521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f269522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f269523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f269524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f269525e;

    public class a extends FragmentManager.FragmentLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TwiceVerifyActivity f269526a;

        public a(TwiceVerifyActivity r100) {
            this.f269526a = r100;
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public final void onFragmentDetached(FragmentManager r100, Fragment r101) {
            super.onFragmentDetached(r100, r101);
            this.f269526a.f269524d--;
            d.a("TwiceVerifyActivity", "onFragmentDetached: " + r101.getClass().getSimpleName() + ", current count: " + this.f269526a.f269524d);
            TwiceVerifyActivity r102 = this.f269526a;
            if (r102.f269524d > 0) goto L6;
            r102.y1(5, "web page close by fragment detached");
            return;
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public final void onFragmentViewDestroyed(FragmentManager r100, Fragment r101) {
            super.onFragmentViewDestroyed(r100, r101);
            d.a("TwiceVerifyActivity", "onFragmentViewDestroyed: ".concat(r101.getClass().getSimpleName()));
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public final void onFragmentAttached(FragmentManager r100, Fragment r101, Context r102) {
            super.onFragmentAttached(r100, r101, r102);
            this.f269526a.f269524d++;
            d.a("TwiceVerifyActivity", "onFragmentAttached: " + r101.getClass().getSimpleName() + ", current count: " + this.f269526a.f269524d);
        }
    }

    public TwiceVerifyActivity() {
        this.f269521a = false;
        this.f269522b = 0;
        com.bytedance.sdk.account.settings.common.a.a();
        this.f269523c = com.bytedance.sdk.account.settings.common.a.f269375a0;
        this.f269524d = 0;
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0112 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if (this.f269523c == false) goto L6;
        y1(5, "activity finish");
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L47;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (this.f269525e == null) goto L6;
        getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.f269525e);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        Intent r100 = getIntent();
        if (r100 != null) goto L5;
    L8:
        d.a("TwiceVerifyActivity", "onResume，is_start = false, fragmentCount=" + this.f269524d + ", isEnableLifeCycleObserverOpt=" + this.f269523c);
        if (this.f269523c == true) goto L11;
    L13:
        y1(5, "web page close cause unknown reason");
        return;
    L11:
        if (this.f269524d <= 0) goto L13;
        return;
    L5:
        if (r100.getBooleanExtra("is_start", false) == false) goto L8;
        d.a("TwiceVerifyActivity", "onResume，is_start = true");
        r100.removeExtra("is_start");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == c.f346341a) goto L9;
        c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
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
        boolean r101 = true;
        if (this.f269523c == false) goto L13;
        this.f269525e = new a(this);
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.f269525e, true);
    L13:
        Intent r102 = getIntent();
        if (r102 != null) goto L16;
    L31:
        d.a("TwiceVerifyActivity", "onCreate，is_start = false");
        y1(5, "TwiceVerifyActivity recreate");
        return;
    L16:
        if (r102.getBooleanExtra("is_start", false) == false) goto L31;
        d.a("TwiceVerifyActivity", "onCreate，is_start = true");
        String r103 = r102.getStringExtra("schema");
        String r104 = r102.getStringExtra("url");
        r102.getStringExtra("data");
        this.f269522b = r102.getIntExtra("afid", 0);
    L26:
        th = move-exception;
        d.b(5, "TwiceVerifyActivity", "openWebPage crash: " + Log.getStackTraceString(th), null);
        r101 = false;
    L28:
        d.a("TwiceVerifyActivity", "openWebPage success: " + r101);
        if (r101 == true) goto L36;
        y1(2, "open web page fail");
        return;
    L36:
        return;
    L19:
        if (TextUtils.isEmpty(r104) == true) goto L21;
        r104 = UriProtector.parse(r104).buildUpon().appendQueryParameter("afid", String.valueOf(this.f269522b)).build().toString();     // Catch: Throwable -> L26
    L21:
        Uri r105 = UriProtector.parse(r103).buildUpon().appendQueryParameter("url", r104).build();     // Catch: Throwable -> L26
        if (b.f269536a.c(r103, r104) == false) goto L24;
        d.a("TwiceVerifyActivity", "openWebPage use externalDepend");     // Catch: Throwable -> L26
        goto L28
    L24:
        com.bytedance.ies.bullet.service.base.router.config.b r106 = new com.bytedance.ies.bullet.service.base.router.config.b();     // Catch: Throwable -> L26
        pc7.a r107 = new pc7.a(this);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r107, "<set-?>");     // Catch: Throwable -> L26
        r106.f247909d = r107;     // Catch: Throwable -> L26
        d.a("TwiceVerifyActivity", "openWebPage use bullet");     // Catch: Throwable -> L26
        boolean r108 = BulletSdk.f246267a;     // Catch: Throwable -> L26
        r101 = BulletSdk.g(this, r105, r106, "");     // Catch: Throwable -> L26
        goto L28
    }

    public final void y1(int r100, String r101) {
        if (this.f269521a == false) goto L5;
        return;
    L5:
        this.f269521a = true;
        e.c().d(this.f269522b, r100, r101);
        finish();
    }

    public static void z1(Context r100, String r101, String r102, String r103, int r104) {
        Intent r105 = new Intent(r100, TwiceVerifyActivity.class);
        r105.putExtra("is_start", true);
        r105.putExtra("schema", r101);
        r105.putExtra("url", r102);
        r105.putExtra("data", r103);
        r105.putExtra("afid", r104);
        if ((r100 instanceof Activity) == true) goto L5;
        r105.addFlags(268435456);
    L5:
        r100.startActivity(r105);
    }
}
