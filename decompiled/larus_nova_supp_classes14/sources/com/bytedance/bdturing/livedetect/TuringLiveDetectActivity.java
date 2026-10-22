package com.bytedance.bdturing.livedetect;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.applet.debugger.DebuggerSessionViewModel;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.view.LiveDetectView;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import f06.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import sb4.k;
import sb4.l;
import v19.f;
import vb4.e;
import vb4.p;
import vb4.q;
import vb4.r;
import vb4.s;
import vb4.v;
import vb4.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TuringLiveDetectActivity extends TuringBaseLiveDetectActivity {
    public static final /* synthetic */ int y = 0;
    public boolean d;
    public Handler e;
    public LiveDetectView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public long j;
    public Map<Integer, String> k;
    public int l;
    public TextView m;
    public String n;
    public String o;
    public String p;
    public k q;
    public boolean r;
    public long s;
    public long t;
    public int u;
    public jc4.a v;
    public final a w;
    public final b x;

    public class a implements xb4.b {
        public final /* synthetic */ TuringLiveDetectActivity a;

        /* JADX INFO: renamed from: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0112a implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ String[] c;
            public final /* synthetic */ a d;

            public final void a() {
                this.d.a.A1();
                int r1 = this.a;
                if (r1 != 200) goto L30;
                TuringLiveDetectActivity r2 = this.d.a;
                JSONObject r3 = this.b;
                String r4 = "";
                if (r3 == null) goto L7;
                String r5 = r3.optString("ticket");
            L8:
                r2.o = r5;
                TuringLiveDetectActivity r6 = this.d.a;
                JSONObject r7 = this.b;
                if (r7 == null) goto L11;
                r4 = r7.optString("salt");
            L11:
                r6.p = r4;
                EventReport.h(true, "ticket=" + this.d.a.o + ":salt=" + this.d.a.p, this.d.a.v);
                TuringLiveDetectActivity r8 = this.d.a;
                ArrayList r9 = new ArrayList();
                Object[] r12 = new Object[0];
                f06.b r13 = new f06.b("auto_cert_com_bytedance_bdturing_livedetect_TuringLiveDetectActivity_com_bytedance_bdturing_livedetect_TuringLiveDetectActivity_checkPermission_super");
                g06.a r10 = (g06.a) ApiHookConfig.b.get(102607);
                if (r10 == null) goto L14;
                f06.a[] r11 = r10.i;
            L15:
                f06.a[] r14 = r11;
                int r15 = r14.length;
                int r16 = 0;
            L17:
                if (r16 >= r15) goto L24;
                f06.a r17 = r14[r16];
                int r18 = r16;
                int r19 = r15;
                f06.a[] r110 = r14;
                d r20 = r17.preInvoke(102607, "com/bytedance/bdturing/livedetect/TuringLiveDetectActivity", "checkPermission", r8, r12, "void", r13);     // Catch: Exception -> L34
                if (r20.a == true) goto L26;
                r9.add(r17);     // Catch: Exception -> L34
            L26:
                if (r20.a == true) goto L42;
                r8.getClass();
                r8.z1(new com.bytedance.bdturing.livedetect.c(r8));
                return;
            L42:
                return;
            L23:
                r16 = r18 + 1;
                r15 = r19;
                r14 = r110;
                goto L17
            L24:
                r20 = new d(false, null);
                goto L26
            L14:
                r11 = ApiHookConfig.d;
                goto L15
            L7:
                r5 = "";
                goto L8
            L30:
                if (r1 != (-9999)) goto L32;
                EventReport.h(false, "show NetFailDlg", this.d.a.v);
                TuringLiveDetectActivity.H1(this.d.a);
                return;
            L32:
                EventReport.h(false, "show FailDlg:", this.d.a.v);
                this.d.a.N1(this.c);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0112a(a r1, int r2, JSONObject r3, String[] r4) {
                this.d = r1;
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ Throwable a;
            public final /* synthetic */ a b;

            public final void a() {
                EventReport.h(false, "on Error:" + this.a, this.b.a.v);
                this.b.a.A1();
                TuringLiveDetectActivity.H1(this.b.a);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(a r1, Throwable r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public a(TuringLiveDetectActivity r1) {
            this.a = r1;
        }

        @Override // xb4.b
        public final void onError(Throwable r3) {
            TuringLiveDetectActivity r0 = this.a;
            b r1 = new b(this, r3);
            int r4 = TuringLiveDetectActivity.y;
            r0.M1(r1);
        }

        @Override // xb4.b
        public final void a(int r3, JSONObject r4, String... r5) {
            TuringLiveDetectActivity r0 = this.a;
            RunnableC0112a r1 = new RunnableC0112a(this, r3, r4, r5);
            int r6 = TuringLiveDetectActivity.y;
            r0.M1(r1);
        }
    }

    public class b implements xb4.b {
        public final /* synthetic */ TuringLiveDetectActivity a;

        public class a implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ String[] c;
            public final /* synthetic */ b d;

            /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Activity, com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity, com.bytedance.bdturing.livedetect.TuringLiveDetectActivity, java.lang.Object] */
            public final void a() {
                ?? r0 = this.d.a;
                r0.getClass();
                r0.runOnUiThread(new vb4.k(r0));
                boolean r2 = true;
                if (this.a != 200) goto L7;
                TuringLiveDetectActivity r1 = this.d.a;
                r1.l = 0;
                EventReport.c(true, "", r1.v);
                TuringLiveDetectActivity r3 = this.d.a;
                r3.f.setDetectResult(true);
                Handler r4 = r3.e;
                if (r4 == null) goto L15;
                r4.postDelayed(new w(r3), 500);
                return;
            L15:
                return;
            L7:
                this.d.a.f.setDetectResult(false);
                JSONObject r5 = this.b;
                if (r5 == null) goto L10;
                r2 = r5.optBoolean("retryable", false);
            L10:
                EventReport.c(false, "retryable:" + r2, this.d.a.v);
                if (r2 == false) goto L13;
                TuringLiveDetectActivity.F1(this.d.a, this.c);
                return;
            L13:
                this.d.a.N1(this.c);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(b r1, int r2, JSONObject r3, String[] r4) {
                this.d = r1;
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity$b$b, reason: collision with other inner class name */
        public class RunnableC0113b implements Runnable {
            public final /* synthetic */ b a;

            /* JADX WARN: Type inference failed for: r0v2, types: [android.app.Activity, com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity, com.bytedance.bdturing.livedetect.TuringLiveDetectActivity, java.lang.Object] */
            @Override // java.lang.Runnable
            public final void run() {
                ?? r0 = this.a.a;     // Catch: Throwable -> L4
                r0.getClass();     // Catch: Throwable -> L4
                r0.runOnUiThread(new vb4.k(r0));     // Catch: Throwable -> L4
                TuringLiveDetectActivity.F1(this.a.a, null);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0113b(b r1) {
                this.a = r1;
            }
        }

        public b(TuringLiveDetectActivity r1) {
            this.a = r1;
        }

        @Override // xb4.b
        public final void onError(Throwable r3) {
            TuringLiveDetectActivity r4 = this.a;
            RunnableC0113b r0 = new RunnableC0113b(this);
            int r1 = TuringLiveDetectActivity.y;
            r4.M1(r0);
        }

        @Override // xb4.b
        public final void a(int r3, JSONObject r4, String... r5) {
            TuringLiveDetectActivity r0 = this.a;
            a r1 = new a(this, r3, r4, r5);
            int r6 = TuringLiveDetectActivity.y;
            r0.M1(r1);
        }
    }

    public class c implements l {
        public final /* synthetic */ TuringLiveDetectActivity a;

        public final void a() {
            AppCompatActivity r0 = this.a;
            int r1 = TuringLiveDetectActivity.y;
            r0.getClass();
            TuringLiveDetectWebActivity.startActivity(r0, e.b(), r0.getString(2131923600));
            EventReport.r(2, 2, "", this.a.v);
        }

        public final void b() {
            this.a.finish();
            EventReport.r(2, 1, "", this.a.v);
        }

        public final void onCancel() {
            this.a.finish();
            EventReport.r(2, 3, "", this.a.v);
        }

        public c(TuringLiveDetectActivity r1) {
            this.a = r1;
        }
    }

    public void K1() {
    }

    public final void P1() {
        this.r = true;
        O1("");
        this.f.i();
    }

    public final void I1() {
        jc4.a r1 = this.v;
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L8
        r2.put("key", "turing_live_start_create_session");     // Catch: Exception -> L8
        if (TextUtils.isEmpty("mDecisionDetail:") == true) goto L6;
        r2.put("custom", "mDecisionDetail:");     // Catch: Exception -> L8
    L6:
        EventReport.w("turing_verify_sdk", r2, r1);     // Catch: Exception -> L8
    L11:
        if (TextUtils.isEmpty(this.n) == false) goto L14;
        finish();
        return;
    L14:
        B1("");
        LiveDetectService.getInstance().createSession(this.n, this.w);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L1() {
        HashMap r0 = new HashMap();
        r0.put(-1, getResources().getString(2131923604));     // Catch: Exception -> L5
        r0.put(0, getString(2131923608));     // Catch: Exception -> L5
        r0.put(20, getResources().getString(2131923604));     // Catch: Exception -> L5
        r0.put(10, getResources().getString(2131923599));     // Catch: Exception -> L5
        r0.put(21, getResources().getString(2131923604));     // Catch: Exception -> L5
        r0.put(22, getResources().getString(2131923603));     // Catch: Exception -> L5
        r0.put(40, getResources().getString(2131923599));     // Catch: Exception -> L5
        r0.put(41, getResources().getString(2131923596));     // Catch: Exception -> L5
        r0.put(42, getResources().getString(2131923597));     // Catch: Exception -> L5
        r0.put(30, getResources().getString(2131923598));     // Catch: Exception -> L5
        r0.put(11, getResources().getString(2131923601));     // Catch: Exception -> L5
        r0.put(12, getResources().getString(2131923602));     // Catch: Exception -> L5
    L7:
        this.k = r0;
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity
    public void finish() {
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

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        this.d = true;
        k r0 = this.q;
        if (r0 != null) goto L8;
    L10:
        LiveDetectView r1 = this.f;
        if (r1 == null) goto L13;
        r1.f();
    L13:
        this.e.removeCallbacksAndMessages(null);
        this.e = null;
        EventReport.x(TuringLiveDetectActivity.class.getName(), this.l, this.v);
        int r2 = this.l;
        long r3 = System.currentTimeMillis() - this.t;
        jc4.a r4 = this.v;
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L16
        r5.put("key", "live_detect_result");     // Catch: Exception -> L16
        r5.put("result", r2);     // Catch: Exception -> L16
        r5.put("duration", r3);     // Catch: Exception -> L16
        EventReport.w("turing_verify_sdk", r5, r4);     // Catch: Exception -> L16
    L18:
        LiveDetectService.getInstance().onResult(this.l, null);
        this.v = null;
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L8:
        if (r0.isShowing() == false) goto L10;
        C1(this.q);
        this.q = null;
        goto L10
    }

    public TuringLiveDetectActivity() {
        this.d = false;
        this.j = 0;
        this.k = new HashMap();
        this.l = 1;
        this.r = false;
        this.u = 0;
        this.w = new a(this);
        this.x = new b(this);
    }

    public final void onBackPressed() {
        if (e.e() == false) goto L6;
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        if (this.r == false) goto L5;
        return;
    L5:
        this.f.i();
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        if (this.r == false) goto L5;
        return;
    L5:
        LiveDetectView r0 = this.f;
        if (r0.d.get() == 3) goto L9;
        return;
    L9:
        if (r0.a.isAvailable() == true) goto L11;
        r0.d.set(1);
        return;
    L11:
        r0.g.a();
        r0.d.set(2);
        r0.d(r0.d.get());
        r0.b.f();
    }

    public static void C1(k r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void D1(k r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void G1(TuringLiveDetectActivity r4) {
        r4.getClass();
        r4.s = System.currentTimeMillis();
        r4.r = false;
        jc4.a r0 = r4.v;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L5
        r1.put("key", "turing_live_detect_start");     // Catch: Exception -> L5
        EventReport.w("turing_verify_sdk", r1, r0);     // Catch: Exception -> L5
    L7:
        Window r2 = r4.getWindow();
        WindowManager.LayoutParams r3 = r2.getAttributes();
        r3.screenBrightness = 1.0f;
        r2.setAttributes(r3);
        r4.O1((String) ((HashMap) r4.k).get(20));
        r4.f.h();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void H1(TuringLiveDetectActivity r4) {
        k r0 = r4.q;
        if (r0 == null) goto L5;
        C1(r0);
    L5:
        String r1 = r4.getString(2131923614);
        String r2 = r4.getString(2131923613);
        sb4.b r3 = new sb4.b();
        r3.a = r1;
        r3.b = r2;
        r3.c = r4.getString(2131923615);
        r3.d = r4.getString(2131923616);
        k r5 = new k(r4, r3, false, new p(r4));
        r4.q = r5;
        D1(r5);
        EventReport.r(1, 0, "", r4.v);
    }

    public final void M1(Runnable r2) {
        Handler r0 = this.e;
        if (r0 == null) goto L7;
        r0.post(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N1(String[] r6) {
        k r0 = this.q;
        if (r0 == null) goto L6;
        C1(r0);
    L6:
        if (r6 != null) goto L8;
    L12:
        String r2 = "";
    L13:
        if (r6 != null) goto L15;
    L19:
        String r7 = "";
    L21:
        if (TextUtils.isEmpty(r2) == true) goto L23;
    L25:
        sb4.b r3 = new sb4.b();
        r3.a = r2;
        r3.b = r7;
        r3.c = getString(2131923587);
        r3.d = getString(2131923588);
        k r8 = new k(this, r3, false, new c(this));
        this.q = r8;
        D1(r8);
        EventReport.r(2, 0, "", this.v);
        return;
    L23:
        if (TextUtils.isEmpty(r7) == false) goto L25;
        r2 = getString(2131923589);
        r7 = getString(2131923586);
        goto L25
    L15:
        if (r6.length <= 1) goto L19;
        if (TextUtils.isEmpty(r6[1]) == true) goto L19;
        r7 = r6[1];
        goto L21
    L8:
        if (r6.length <= 0) goto L12;
        if (TextUtils.isEmpty(r6[0]) == true) goto L12;
        r2 = r6[0];
        goto L13
    }

    public final void O1(String r6) {
        if ((System.currentTimeMillis() - this.j) >= 500) goto L5;
        return;
    L5:
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        this.j = System.currentTimeMillis();
        this.g.setText(r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L19
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L19
    L8:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r6);
        getWindow().setFlags(8192, 8192);
        this.n = getIntent().getStringExtra("detail");
        this.v = LiveDetectService.getInstance().getRequest();
        setContentView(2131558522);
        this.b = (ImageView) findViewById(2131378977);
        LiveDetectView r7 = (LiveDetectView) findViewById(2131389969);
        this.f = r7;
        r7.setBoxStateListener(new r(this));
        this.g = (TextView) findViewById(2131390491);
        this.h = (TextView) findViewById(2131391571);
        this.i = (TextView) findViewById(2131391570);
        this.m = (TextView) findViewById(2131391572);
        LiveDetectView r8 = this.f;
        com.bytedance.bdturing.setting.e r0 = com.bytedance.bdturing.setting.e.a;
        long r3 = CastLongProtector.parseLong(com.bytedance.bdturing.setting.e.f("timeout"));     // Catch: Exception -> L11
    L14:
        if (r3 > 0) goto L17;
        r3 = DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS;
    L17:
        r8.setDetectTimeOut(r3);
        this.f.setDebugInfoCallBack(new v(this));
        this.f.setDetectStateCallBack(new s(this));
        this.t = System.currentTimeMillis();
        this.e = new Handler();
        LiveDetectService.getInstance().setOnVerify(true);
        K1();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        r3 = 0;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void F1(TuringLiveDetectActivity r5, String[] r6) {
        k r0 = r5.q;
        if (r0 == null) goto L5;
        C1(r0);
    L5:
        sb4.b r1 = new sb4.b();
        String r2 = "";
        if (r6 != null) goto L8;
    L12:
        String r3 = "";
    L13:
        if (r6 == null) goto L20;
        if (r6.length <= 1) goto L20;
        if (TextUtils.isEmpty(r6[1]) == true) goto L20;
        r2 = r6[1];
    L20:
        if (TextUtils.isEmpty(r3) == true) goto L22;
    L24:
        r1.a = r3;
        r1.b = r2;
        r1.c = r5.getResources().getString(2131923593);
        r1.d = r5.getResources().getString(2131923594);
        k r7 = new k(r5, r1, e.e(), new q(r5));
        r5.q = r7;
        D1(r7);
        return;
    L22:
        if (TextUtils.isEmpty(r2) == false) goto L24;
        r3 = r5.getResources().getString(2131923595);
        r2 = r5.getResources().getString(2131923592);
        goto L24
    L8:
        if (r6.length <= 0) goto L12;
        if (TextUtils.isEmpty(r6[0]) == true) goto L12;
        r3 = r6[0];
        goto L13
    }
}
