package com.bytedance.bdturing;

import android.R;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.bdturing.verify.RiskControlService;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import jc4.o;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.c0;
import qb4.f;
import qb4.g;
import qb4.g0;
import qb4.h;
import qb4.n;
import qb4.p;
import qb4.t;

/* JADX INFO: loaded from: classes12.dex */
public class BdTuringQaSmsVerifyActivity extends AppCompatActivity implements t {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f201639r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jc4.a f201640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EventReport.CloseType f201641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f201642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f201643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f201644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f201645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f201646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f201647h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VerifyWebView f201648i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CardView f201649j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f201650k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ac4.b f201651l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f201652m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f201653n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f201654o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f201655p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f201656q;

    public class a implements g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BdTuringQaSmsVerifyActivity f201657a;

        @Override // qb4.g0
        public final void a(int r100, String r101, String r102) {
        }

        @Override // qb4.g0
        public final void c() {
            this.f201657a.f201643d = true;
            long r100 = System.currentTimeMillis();
            BdTuringQaSmsVerifyActivity r101 = this.f201657a;
            EventReport.O(0, r100 - r101.f201653n, r101.f201640a);
        }

        public a(BdTuringQaSmsVerifyActivity r100) {
            this.f201657a = r100;
        }

        @Override // qb4.g0
        public final void b(int r100, String r101) {
            long r102 = System.currentTimeMillis();
            BdTuringQaSmsVerifyActivity r103 = this.f201657a;
            EventReport.O(1, r102 - r103.f201653n, r103.f201640a);
            BdTuringQaSmsVerifyActivity r104 = this.f201657a;
            r104.f201643d = false;
            r104.f201641b = EventReport.CloseType.CLOSE_REASON_PAGE_LOAD_FAILED;
            r104.dismiss();
        }
    }

    public class b extends ac4.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BdTuringQaSmsVerifyActivity f201658a;

        @Override // ac4.f
        public final void l(String r100, ac4.f.a r101) {
        }

        @Override // ac4.f
        public final void c() {
            int r100 = n.f532367a;
            this.f201658a.o0();
        }

        @Override // ac4.f
        public final void p() {
            jc4.a r100 = this.f201658a.f201640a;
            if ((r100 instanceof o) == false) goto L11;
            JSONObject r101 = ((o) r100).f498127o;
            if (r101 == null) goto L12;
            String r102 = ac4.c.b("bytedcert.verifyData", r101, "bytedcert.verifyData");
            ac4.b r103 = this.f201658a.f201651l;
            if (r103 != null) goto L9;
            int r104 = n.f532367a;
            return;
        L9:
            r103.a(r102);
            return;
        L12:
            return;
        }

        public b(BdTuringQaSmsVerifyActivity r100) {
            this.f201658a = r100;
        }

        @Override // ac4.f
        public final void e(ac4.c r100) {
            JSONObject r101 = new JSONObject();
            hc4.d.b(r101, "maskTime", Long.valueOf(this.f201658a.f201653n));
            r100.d(1, r101);
        }

        @Override // ac4.f
        public final void g(ac4.c r100) {
            BdTuringConfig r101 = qb4.b.c.f532315a.f532302a;
            if (r101 == null) goto L5;
            JSONObject r102 = r101.getTheme(this.f201658a.f201652m);
        L6:
            r100.d(1, r102);
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // ac4.f
        public final void j(int r100, int r101, boolean r102) {
            BdTuringQaSmsVerifyActivity r103 = this.f201658a;
            r103.f201643d = true;
            r103.f201641b = EventReport.CloseType.CLOSE_REASON_APP;
            if (r103.f201644e == false) goto L6;
            return;
        L6:
            if (r103.f201640a.d() == true) goto L10;
            if (r102 == true) goto L10;
            boolean r104 = false;
        L11:
            if (r104 == false) goto L13;
            Point r105 = hc4.f.f(r103);
            int r106 = r105.x;
            int r107 = r105.y;
            int r108 = r106;
        L18:
            ViewGroup.LayoutParams r109 = r103.f201648i.getLayoutParams();
            if (r103.f201645f == false) goto L25;
            int r110 = r109.width;
            if (r110 <= 0) goto L25;
            int r111 = r109.height;
            if (r111 <= 0) goto L25;
            r103.f201648i.d(r108, r107, r110, r111);
            r103.f201645f = false;
            return;
        L25:
            r103.f201648i.post(new h(r103, r104, r109, r108, r107));
            return;
        L13:
            float r112 = hc4.f.h(r103);
            if (r100 <= 0) goto L17;
            if (r101 <= 0) goto L17;
            r100 = Math.round(r100 * r112);
            r101 = Math.round(r112 * r101);
        L17:
            r108 = r100;
            r107 = r101;
        L10:
            r104 = true;
            goto L11
        }

        @Override // ac4.f
        public final void k(int r100, int r101, boolean r102) {
            BdTuringQaSmsVerifyActivity r103 = this.f201658a;
            int r104 = BdTuringQaSmsVerifyActivity.f201639r;
            r103.getClass();
            int r105 = n.f532367a;
            r103.f201643d = true;
            r103.f201641b = EventReport.CloseType.CLOSE_REASON_APP;
            if (r103.f201644e == false) goto L6;
            return;
        L6:
            if (r103.f201640a.d() == true) goto L10;
            if (r102 == true) goto L10;
            boolean r106 = false;
        L11:
            if (r106 == false) goto L13;
            Point r107 = hc4.f.f(r103);
            int r108 = r107.x;
            int r109 = r107.y;
            int r110 = r108;
        L14:
            ViewGroup.LayoutParams r111 = r103.f201648i.getLayoutParams();
            if (r103.f201645f == false) goto L21;
            int r112 = r111.width;
            if (r112 <= 0) goto L21;
            int r113 = r111.height;
            if (r113 <= 0) goto L21;
            r103.f201648i.d(r110, r109, r112, r113);
            r103.f201645f = false;
            return;
        L21:
            r103.f201648i.post(new g(r103, r106, r111, r110, r109));
            return;
        L13:
            r110 = r100;
            r109 = r101;
        L10:
            r106 = true;
            goto L11
        }

        @Override // ac4.f
        public final void m(int r100, String r101, String r102, String r103, JSONObject r104) {
            if (r100 != 0) goto L5;
            boolean r105 = true;
        L6:
            int r106 = n.f532367a;
            EventReport.N(r100, this.f201658a.f201640a);
            if (this.f201658a.f201650k == null) goto L17;
            JSONObject r107 = new JSONObject();
            r107.put("token", r101);     // Catch: JSONException -> L11
            r107.put("mobile", r102);     // Catch: JSONException -> L11
            r107.put("decision", r103);     // Catch: JSONException -> L11
            r107.put("query", r104);     // Catch: JSONException -> L11
        L13:
            if (r105 == false) goto L15;
            this.f201658a.f201650k.onSuccess(r100, r107);
        L16:
            this.f201658a.f201650k = null;
            goto L17
        L15:
            this.f201658a.f201650k.onFail(r100, r107);
        L11:
            e = move-exception;
            Intrinsics.checkNotNullParameter(e, "e");
            e.printStackTrace();
        L17:
            BdTuringQaSmsVerifyActivity r108 = this.f201658a;
            r108.f201646g = true;
            r108.dismiss();
            return;
        L5:
            r105 = false;
            goto L6
        }
    }

    public class c implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BdTuringQaSmsVerifyActivity f201659a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public c(BdTuringQaSmsVerifyActivity r100) {
            this.f201659a = r100;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
            int r101 = r100.orientation;
            if (r101 == 1) goto L6;
            if (r101 == 2) goto L6;
            return;
        L6:
            if (r101 != 1) goto L8;
            int r102 = 2;
        L10:
            if (this.f201659a.f201640a.getType() != 2) goto L12;
            boolean r103 = true;
        L13:
            int r104 = n.f532367a;
            if (r103 == true) goto L16;
            return;
        L16:
            JSONObject r105 = new JSONObject();
            r105.put("orientation", r102);     // Catch: JSONException -> L19
        L21:
            String r106 = ac4.c.b("bytedcert.orientation_changing", r105, "bytedcert.orientation_changing");
            BdTuringQaSmsVerifyActivity r107 = this.f201659a;
            r107.f201645f = true;
            ac4.b r108 = r107.f201651l;
            if (r108 != null) goto L24;
            int r109 = n.f532367a;
        L25:
            EventReport.L(r102, this.f201659a.f201640a);
            return;
        L24:
            r108.a(r106);
        L19:
            e = move-exception;
            e.printStackTrace();
            goto L21
        L12:
            r103 = false;
            goto L13
        L8:
            r102 = 1;
            goto L10
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final VerifyWebView f201660a;

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = n.f532367a;     // Catch: Throwable -> L11
            VerifyWebView r101 = this.f201660a;     // Catch: Throwable -> L11
            if (r101 == null) goto L14;
            ViewParent r102 = r101.getParent();     // Catch: Throwable -> L11
            if (r102 != null) goto L8;
            return;
        L8:
            if ((r102 instanceof ViewGroup) == false) goto L19;
            ((ViewGroup) r102).removeView(this.f201660a);     // Catch: Throwable -> L11
            return;
        L19:
            return;
        L14:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }

        public d(BdTuringQaSmsVerifyActivity r100) {
            this.f201660a = r100.f201648i;
        }
    }

    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f201661a = null;

        static {
            int[] r100 = new int[EventReport.CloseType.values().length];
            f201661a = r100;
            r100[EventReport.CloseType.CLOSE_REASON_PAGE_LOAD_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f201661a[EventReport.CloseType.CLOSE_REASON_BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f201661a[EventReport.CloseType.CLOSE_REASON_APP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // qb4.t
    public final boolean isShowing() {
        return true;
    }

    @Override // qb4.t
    public final synchronized void o0() {
        monitor-enter(this);
        int r100 = n.f532367a;     // Catch: Throwable -> L13
        c0.b r101 = c0.a.f532328a.f532327b;     // Catch: Throwable -> L13
        if (r101 == null) goto L6;
        r101.removeMessages(1);     // Catch: Throwable -> L13
    L6:
        ac4.b r102 = this.f201651l;     // Catch: Throwable -> L13
        if (r102 != null) goto L10;
        monitor-exit(this);
        return;
    L10:
        r102.b();     // Catch: Throwable -> L13
        this.f201651l = null;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // qb4.t
    public final void n1() {
        f r100 = this.f201650k;
        if (r100 == null) goto L5;
        r100.onFail(1001, null);
        this.f201650k = null;
    L5:
        dismiss();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        int r100 = n.f532367a;
        VerifyWebView r101 = this.f201648i;
        if (r101 != null) goto L5;
    L8:
        com.bytedance.bdturing.setting.e r102 = com.bytedance.bdturing.setting.e.f202077a;
        if (com.bytedance.bdturing.setting.e.i() == false) goto L12;
        this.f201641b = EventReport.CloseType.CLOSE_REASON_BACK;
        super.onBackPressed();
        return;
    L12:
        return;
    L5:
        if (r101.canGoBack() == false) goto L8;
        this.f201648i.goBack();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        int r100 = n.f532367a;
    L20:
        th = move-exception;
        c0.a.f532328a.c(3, null);
        this.f201650k = null;
        RiskControlService.INSTANCE.release();
        EventReport.P(System.currentTimeMillis() - this.f201653n, "BdTuringQaSmsVerifyActivity", this.f201640a);
        this.f201640a = null;
        throw th;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
    L38:
        c0.a.f532328a.c(3, null);
        this.f201650k = null;
        RiskControlService.INSTANCE.release();
        EventReport.P(System.currentTimeMillis() - this.f201653n, "BdTuringQaSmsVerifyActivity", this.f201640a);
        this.f201640a = null;
        return;
    L7:
        if (this.f201648i == null) goto L10;
        y1(getWindow()).post(new d(this));     // Catch: Throwable -> L20 Exception -> L22
        this.f201648i = null;     // Catch: Throwable -> L20 Exception -> L22
    L10:
        if (this.f201644e == true) goto L38;
        this.f201644e = true;     // Catch: Throwable -> L20 Exception -> L22
        unregisterComponentCallbacks(this.f201656q);     // Catch: Throwable -> L20 Exception -> L22
        if (this.f201643d == true) goto L15;
        o0();     // Catch: Throwable -> L20 Exception -> L22
        EventReport.G(this.f201641b, this.f201640a);     // Catch: Throwable -> L20 Exception -> L22
    L26:
        if (this.f201650k == null) goto L38;
        int r101 = e.f201661a[this.f201641b.ordinal()];     // Catch: Throwable -> L20 Exception -> L22
        if (r101 != 1) goto L30;
        this.f201650k.onFail(3, null);     // Catch: Throwable -> L20 Exception -> L22
        goto L38
    L30:
        if (r101 == 2) goto L34;
        if (r101 == 3) goto L33;
        this.f201650k.onFail(1, null);     // Catch: Throwable -> L20 Exception -> L22
        goto L38
    L33:
        this.f201650k.onFail(6, null);     // Catch: Throwable -> L20 Exception -> L22
        goto L38
    L34:
        this.f201650k.onFail(5, null);     // Catch: Throwable -> L20 Exception -> L22
        goto L38
    L15:
        if (this.f201646g == true) goto L17;
        z1(this.f201641b.getName());     // Catch: Throwable -> L20 Exception -> L22
    L17:
        c0 r102 = c0.a.f532328a;     // Catch: Throwable -> L20 Exception -> L22
        c0.b r103 = r102.f532327b;     // Catch: Throwable -> L20 Exception -> L22
        if (r103 == null) goto L26;
        Message r104 = r103.obtainMessage(1, this);     // Catch: Throwable -> L20 Exception -> L22
        r102.f532327b.sendMessageDelayed(r104, 10000);     // Catch: Throwable -> L20 Exception -> L22
        goto L26
    }

    public BdTuringQaSmsVerifyActivity() {
        this.f201641b = EventReport.CloseType.CLOSE_REASON_APP;
        this.f201642c = null;
        this.f201643d = false;
        this.f201644e = false;
        this.f201645f = false;
        this.f201646g = false;
        this.f201654o = new a(this);
        this.f201655p = new b(this);
        this.f201656q = new c(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0111 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
    public final void onStop() {
        super.onStop();
        EventReport.H(this.f201640a);
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    @Override // qb4.t
    public final void dismiss() {
        finish();
    }

    public static void startActivity(Activity r100) {
        r100.startActivity(new Intent(r100, BdTuringQaSmsVerifyActivity.class));
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
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        setContentView(com.larus.nova.R.layout.bdturing_qa_sms_verify_activity);
        RiskControlService r101 = RiskControlService.INSTANCE;
        jc4.a r102 = r101.getCurrentRequest();
        this.f201640a = r102;
        EventReport.R("BdTuringQaSmsVerifyActivity", r102);
        EventReport.K(hc4.f.g(this), this.f201640a);
        this.f201650k = r101.getResultCallBack();
        jc4.a r103 = this.f201640a;
        if (r103 != null) goto L13;
        finish();
        return;
    L13:
        this.f201652m = r103.getType();
        r101.bindVerifyInterface(this);
        registerComponentCallbacks(this.f201656q);
        this.f201647h = (ImageView) findViewById(com.larus.nova.R.id.loading);
        this.f201648i = (VerifyWebView) findViewById(com.larus.nova.R.id.verify_webview);
        this.f201649j = (CardView) findViewById(com.larus.nova.R.id.web_container);
        if (this.f201640a.d() == false) goto L16;
        Resources r104 = getResources();
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
        ViewGroup.LayoutParams r106 = this.f201648i.getLayoutParams();
        r106.width = r105.widthPixels;
        r106.height = r105.heightPixels;
        this.f201648i.setLayoutParams(r106);
        this.f201648i.setVisibility(0);
    L16:
        this.f201648i.c(this.f201654o);
        p r107 = new p(this.f201640a.c());
        this.f201642c = r107;
        this.f201648i.setOnTouchListener(r107);
        if (this.f201640a.f498092c == false) goto L19;
        RotateAnimation r108 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r108.setDuration(1000);
        r108.setRepeatCount(-1);
        r108.setInterpolator(new LinearInterpolator());
        this.f201647h.startAnimation(r108);
    L20:
        this.f201653n = System.currentTimeMillis();
        this.f201651l = new ac4.b(this.f201655p, this.f201648i);
        this.f201640a.f();
        int r109 = n.f532367a;
        this.f201648i.loadUrl(this.f201640a.f());
        return;
    L19:
        this.f201647h.setVisibility(8);
        goto L20
    }

    @Override // android.app.Activity
    public final boolean onTouchEvent(MotionEvent r100) {
        p r101 = this.f201642c;
        if (r101 == null) goto L6;
        r101.a(r100);
    L6:
        return super.onTouchEvent(r100);
    }

    public final void z1(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("style", r100);     // Catch: JSONException -> L5
    L7:
        String r102 = ac4.c.b("bytedcert.goToClose", r101, "bytedcert.goToClose");
        ac4.b r103 = this.f201651l;
        if (r103 != null) goto L10;
        int r104 = n.f532367a;
        return;
    L10:
        r103.a(r102);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
