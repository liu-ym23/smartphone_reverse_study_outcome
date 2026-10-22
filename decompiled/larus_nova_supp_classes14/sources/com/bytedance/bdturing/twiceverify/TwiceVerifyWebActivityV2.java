package com.bytedance.bdturing.twiceverify;

import ac4.e;
import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.TuringVerifyWebView;
import com.bytedance.bdturing.verify.TwiceVerifyService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hc4.d;
import java.util.Map;
import jc4.k;
import jc4.r;
import org.json.JSONObject;
import qb4.g0;
import qb4.n;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TwiceVerifyWebActivityV2 extends AppCompatActivity {
    public TuringVerifyWebView a;
    public View b;
    public jc4.a c;
    public long d;
    public a$b e;
    public EventReport.CloseType f;
    public boolean g;
    public final a h;
    public final b i;

    public class a extends e {
        public final /* synthetic */ TwiceVerifyWebActivityV2 b;

        @Override // ac4.e
        public final void e() {
            int r0 = n.a;
            TuringVerifyWebView r1 = this.b.a;
            if (r1 == null) goto L6;
            r1.e();
            return;
        }

        @Override // ac4.e
        public final void c(ac4.c r4) {
            JSONObject r0 = new JSONObject();
            d.b(r0, "maskTime", Long.valueOf(this.b.d));
            r4.d(1, r0);
        }

        public a(TwiceVerifyWebActivityV2 r1, Activity r2) {
            this.b = r1;
            super(r2);
        }

        @Override // ac4.e
        public final void d(int r2, String r3) {
            TwiceVerifyService.a r0 = this.b.e;
            if (r0 == null) goto L8;
            if (r2 != 0) goto L6;
            r0.b();
        L7:
            this.b.e = null;
            goto L8
        L6:
            r0.a(r2, r3);
        L8:
            this.b.finish();
        }
    }

    public class b implements g0 {
        public final /* synthetic */ TwiceVerifyWebActivityV2 a;

        public final void c() {
            TwiceVerifyWebActivityV2 r0 = this.a;
            r0.g = false;
            TuringVerifyWebView r2 = r0.a;
            if (r2 == null) goto L5;
            r2.setVisibility(0);
        L5:
            View r1 = r0.b;
            if (r1 == null) goto L9;
            r1.setVisibility(0);
            return;
        }

        public b(TwiceVerifyWebActivityV2 r1) {
            this.a = r1;
        }

        public final void b(int r4, String r5) {
            Toast.makeText(this.a, "ERROR:" + r4 + ";MSG:" + r5, 1).show();
            if (com.bytedance.bdturing.twiceverify.a.a().a == null) goto L5;
            com.bytedance.bdturing.twiceverify.a.a().a.dismissLoading();
        L5:
            TwiceVerifyWebActivityV2 r6 = this.a;
            r6.f = EventReport.CloseType.CLOSE_REASON_PAGE_LOAD_FAILED;
            r6.finish();
        }

        public final void a(int r1, String r2, String r3) {
            this.a.g = true;
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EventReport.CloseType.values().length];
            a = r0;
            r0[EventReport.CloseType.CLOSE_REASON_BACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[EventReport.CloseType.CLOSE_REASON_PAGE_LOAD_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[EventReport.CloseType.CLOSE_REASON_APP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
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

    public final void onBackPressed() {
        if (this.g == true) goto L6;
        com.bytedance.bdturing.setting.e r0 = com.bytedance.bdturing.setting.e.a;
        if (com.bytedance.bdturing.setting.e.i() == true) goto L6;
        return;
    L6:
        this.f = EventReport.CloseType.CLOSE_REASON_BACK;
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        if (this.e == null) goto L16;
        int r0 = c.a[this.f.ordinal()];
        if (r0 != 1) goto L10;
        this.e.a(2, "user close");
        goto L16
    L10:
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L13;
        this.e.a(1, "closed by unknown reason");
        goto L16
    L13:
        this.e.a(6, "closed by app");
        goto L16
    L14:
        this.e.a(3, "web page load failed");
    L16:
        this.a = null;
        this.e = null;
        com.bytedance.bdturing.twiceverify.a r1 = com.bytedance.bdturing.twiceverify.a.a();
        r1.b = null;
        r1.c = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TwiceVerifyWebActivityV2() {
        this.a = null;
        this.b = null;
        this.f = EventReport.CloseType.CLOSE_REASON_APP;
        this.g = false;
        this.h = new a(this, this);
        this.i = new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.app.Activity*/.onAttachedToWindow();
        View r0 = y1(getWindow());
        setFinishOnTouchOutside(false);
        WindowManager.LayoutParams r1 = (WindowManager.LayoutParams) r0.getLayoutParams();
        r1.gravity = 80;
        r1.width = UIUtils.getScreenWidth(this);
        com.bytedance.bdturing.twiceverify.a.a().getClass();
        r1.height = (int) UIUtils.dip2Px(this, 304.0f);
        jc4.a r3 = this.c;
        if (r3 != null) goto L5;
    L13:
        getWindowManager().updateViewLayout(r0, r1);
        return;
    L5:
        if ((r3 instanceof jc4.b) == false) goto L8;
        r1.height = (int) UIUtils.dip2Px(this, 290.0f);
        goto L13
    L8:
        if ((r3 instanceof r) == false) goto L11;
        r1.height = (int) UIUtils.dip2Px(this, 304.0f);
        goto L13
    L11:
        if ((r3 instanceof k) == false) goto L13;
        r1.height = (int) UIUtils.dip2Px(this, 272.0f);
        goto L13
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
    public final void onCreate(Bundle r4) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r4);
        setContentView(2131558794);
        this.e = com.bytedance.bdturing.twiceverify.a.a().b;
        if (com.bytedance.bdturing.twiceverify.a.a().a == null) goto L13;
        com.bytedance.bdturing.twiceverify.a.a().a.showLoading();
    L13:
        this.c = com.bytedance.bdturing.twiceverify.a.a().c;
        this.b = findViewById(2131388959);
        if (this.a != null) goto L16;
        TuringVerifyWebView r5 = findViewById(2131364072);
        this.a = r5;
        r5.d(this.i, true, this.c);
    L16:
        TuringVerifyWebView r6 = this.a;
        if (r6 == null) goto L19;
        r6.setVisibility(4);
    L19:
        View r7 = this.b;
        if (r7 == null) goto L22;
        r7.setVisibility(4);
    L22:
        this.a.getSettings().setJavaScriptEnabled(true);
        new ac4.b(this.h, this.a);
        jc4.a r8 = this.c;
        if (r8 == null) goto L25;
        String r9 = r8.f();
    L26:
        this.a.loadUrl(r9);
        EventReport.I(this.c);
        com.bytedance.bdturing.twiceverify.a.a().getClass();
        this.d = System.currentTimeMillis();
        return;
    L25:
        r9 = "";
        goto L26
    }
}
