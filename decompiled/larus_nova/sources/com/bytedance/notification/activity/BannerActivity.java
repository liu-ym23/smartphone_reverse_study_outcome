package com.bytedance.notification.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.common.push.notification.BaseBannerActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes21.dex */
public class BannerActivity extends BaseBannerActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f266025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f266026b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerActivity f266027a;

        @Override // java.lang.Runnable
        public final void run() {
            f.a("finish BannerActivity");     // Catch: Throwable -> L4
            this.f266027a.finish();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(BannerActivity r100) {
            this.f266027a = r100;
        }
    }

    public BannerActivity() {
        this.f266025a = true;
        this.f266026b = R.anim.banner_out;
    }

    /* JADX INFO: Removed unreachable split cross block B:66:0x0164 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.common.push.notification.BaseBannerActivity, android.app.Activity
    public void finish() {
        com.bytedance.notification.helper.a r100 = com.bytedance.notification.helper.a.a();
        r100.f266073f = false;
        r100.f266072e = 0;
        r100.f266071d = 0;
        r100.f266068a = null;
        r100.f266069b = null;
        super.finish();
        boolean r101 = this.f266025a;
        int r102 = this.f266026b;
        if (r101 == false) goto L6;
        overridePendingTransition(0, r102);
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L15;
        List<ActivityManager.AppTask> r103 = ((ActivityManager) getSystemService(ActivityManager.class)).getAppTasks();
        if (r103 == null) goto L15;
        r103.size();
        if (r103.size() <= 0) goto L15;
        ActivityManager.AppTask r104 = (ActivityManager.AppTask) ListProtector.get(r103, 0);
        if (r104 == null) goto L15;
        f.b("BannerActivityTag", "set topTask excludeFrom Recents to true");
        r104.setExcludeFromRecents(true);
    L15:
        if ((this instanceof FragmentActivity) == true) goto L18;
        return;
    L18:
        if ((this instanceof ChatWindowActivity) == true) goto L71;
        FLogger r105 = FLogger.f375446a;
        r105.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r106 = SystemClock.uptimeMillis();
        Map<Activity, Long> r107 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r107);
        Long r108 = r107.get(this);     // Catch: Throwable -> L60
        if (r108 != null) goto L25;
    L28:
        r107.put(this, Long.valueOf(r106));     // Catch: Throwable -> L60
        monitor-exit(r107);     // Catch: Throwable -> L60
    L57:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L63:
        return;
    L31:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L34;
        r105.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L57
        goto L63
    L34:
        if (isFinishing() == true) goto L37;
        r105.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L57
        goto L63
    L37:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L40;
        r105.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L57
        goto L63
    L40:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L43;
        r105.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L57
        goto L63
    L43:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L46;
        r105.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L57
        goto L63
    L46:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L48;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L57
        goto L63
    L48:
        Intent r109 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L57
        if (r109 == null) goto L63;
        r109.addFlags(268435456);     // Catch: Throwable -> L57
        r109.addFlags(2097152);     // Catch: Throwable -> L57
        r105.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L57
        startActivity(r109);     // Catch: Throwable -> L54
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L57
        goto L63
    L25:
        if ((r106 - r108.longValue()) >= 800) goto L28;
        monitor-exit(r107);     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r110);
        f.b("BannerActivityTag", "onCreate of BannerActivity, sIsShowing is " + com.bytedance.notification.helper.a.a().f266073f);
        if (com.bytedance.notification.helper.a.a().f266073f == false) goto L13;
        f.i("BannerActivityTag", "onCreate of BannerActivity, sIsShowing is true,finish self");
        finish();
        return;
    L13:
        com.bytedance.notification.helper.a r111 = com.bytedance.notification.helper.a.a();
        WeakReference<BannerActivity> r100 = new WeakReference(this);
        r111.getClass();
        Objects.toString(r100);
        r111.f266068a = r100;
        com.bytedance.notification.helper.a.a().f266073f = true;
        WeakReference<View> r112 = com.bytedance.notification.helper.a.a().f266069b;
        if (r112 != null) goto L16;
        f.i("BannerActivityTag", "bannerViewRef is null,finish self");
        finish();
        return;
    L16:
        View r113 = r112.get();
        if (r113 != null) goto L19;
        f.i("BannerActivityTag", "bannerView is null,finish self");
        finish();
        return;
    L19:
        Window r101 = getWindow();
        r101.setGravity(49);     // Catch: Throwable -> L22
        WindowManager.LayoutParams r102 = r101.getAttributes();     // Catch: Throwable -> L22
        r102.x = 35;     // Catch: Throwable -> L22
        r102.y = com.bytedance.notification.helper.a.a().f266070c + getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));     // Catch: Throwable -> L22
        r102.height = -2;     // Catch: Throwable -> L22
        r102.width = -1;     // Catch: Throwable -> L22
        r101.setAttributes(r102);     // Catch: Throwable -> L22
        r101.setFlags(32, 32);     // Catch: Throwable -> L22
        setContentView(r113);     // Catch: Throwable -> L22
        overridePendingTransition(R.anim.banner_in, R.anim.banner_silent);     // Catch: Throwable -> L22
        f.a("onCreate of BannerActivity, sDuration is " + com.bytedance.notification.helper.a.a().f266071d);     // Catch: Throwable -> L22
        r113.postDelayed(new a(this), com.bytedance.notification.helper.a.a().f266071d);     // Catch: Throwable -> L22
        ((v37.a) v37.a.b()).f(com.bytedance.notification.helper.a.a().f266072e, true, "success", "actual");     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        f.f("BannerActivityTag", "exception in banner,finish self ", th);
        finish();
    }

    public static void a(View r100, int r101, long r102, long r103) {
        com.bytedance.notification.helper.a r104 = com.bytedance.notification.helper.a.a();
        r104.f266069b = new WeakReference(r100);
        com.bytedance.notification.helper.a.a().f266070c = r101;
        com.bytedance.notification.helper.a.a().f266071d = r102;
        com.bytedance.notification.helper.a.a().f266072e = r103;
    }
}
