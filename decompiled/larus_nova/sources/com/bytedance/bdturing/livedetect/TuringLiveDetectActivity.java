package com.bytedance.bdturing.livedetect;

import android.app.Activity;
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
import androidx.lifecycle.Lifecycle;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.view.LiveDetectView;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes14.dex */
public class TuringLiveDetectActivity extends TuringBaseLiveDetectActivity {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f201828y = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f201829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f201830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LiveDetectView f201831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f201832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f201833h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f201834i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f201835j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<Integer, String> f201836k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f201837l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f201838m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f201839n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f201840o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f201841p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public k f201842q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f201843r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f201844s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f201845t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f201846u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public jc4.a f201847v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a f201848w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b f201849x;

    public class a implements xb4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuringLiveDetectActivity f201850a;

        /* JADX INFO: renamed from: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity$a$a, reason: collision with other inner class name */
        public class RunnableC2908a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f201851a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ JSONObject f201852b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String[] f201853c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f201854d;

            public final void a() {
                this.f201854d.f201850a.A1();
                int r100 = this.f201851a;
                if (r100 != 200) goto L30;
                TuringLiveDetectActivity r101 = this.f201854d.f201850a;
                JSONObject r102 = this.f201852b;
                String r103 = "";
                if (r102 == null) goto L7;
                String r104 = r102.optString("ticket");
            L8:
                r101.f201840o = r104;
                TuringLiveDetectActivity r105 = this.f201854d.f201850a;
                JSONObject r106 = this.f201852b;
                if (r106 == null) goto L11;
                r103 = r106.optString("salt");
            L11:
                r105.f201841p = r103;
                EventReport.h(true, "ticket=" + this.f201854d.f201850a.f201840o + ":salt=" + this.f201854d.f201850a.f201841p, this.f201854d.f201850a.f201847v);
                TuringLiveDetectActivity r107 = this.f201854d.f201850a;
                ArrayList r108 = new ArrayList();
                Object[] r110 = new Object[0];
                f06.b r111 = new f06.b("auto_cert_com_bytedance_bdturing_livedetect_TuringLiveDetectActivity_com_bytedance_bdturing_livedetect_TuringLiveDetectActivity_checkPermission_super");
                g06.a r109 = ApiHookConfig.f245611b.get(102607);
                if (r109 == null) goto L14;
                f06.a[] r112 = r109.f479473i;
            L15:
                f06.a[] r113 = r112;
                int r114 = r113.length;
                int r115 = 0;
            L17:
                if (r115 >= r114) goto L24;
                f06.a r116 = r113[r115];
                int r117 = r115;
                int r118 = r114;
                f06.a[] r119 = r113;
                d r120 = r116.preInvoke(102607, "com/bytedance/bdturing/livedetect/TuringLiveDetectActivity", "checkPermission", r107, r110, "void", r111);     // Catch: Exception -> L34
                if (r120.f474982a == true) goto L26;
                r108.add(r116);     // Catch: Exception -> L34
            L26:
                if (r120.f474982a == true) goto L42;
                r107.getClass();
                r107.z1(new com.bytedance.bdturing.livedetect.c(r107));
                return;
            L42:
                return;
            L23:
                r115 = r117 + 1;
                r114 = r118;
                r113 = r119;
                goto L17
            L24:
                r120 = new d(false, null);
                goto L26
            L14:
                r112 = ApiHookConfig.f245613d;
                goto L15
            L7:
                r104 = "";
                goto L8
            L30:
                if (r100 != (-9999)) goto L32;
                EventReport.h(false, "show NetFailDlg", this.f201854d.f201850a.f201847v);
                TuringLiveDetectActivity.H1(this.f201854d.f201850a);
                return;
            L32:
                EventReport.h(false, "show FailDlg:", this.f201854d.f201850a.f201847v);
                this.f201854d.f201850a.N1(this.f201853c);
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

            public RunnableC2908a(a r100, int r101, JSONObject r102, String[] r103) {
                this.f201854d = r100;
                this.f201851a = r101;
                this.f201852b = r102;
                this.f201853c = r103;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Throwable f201855a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f201856b;

            public final void a() {
                EventReport.h(false, "on Error:" + this.f201855a, this.f201856b.f201850a.f201847v);
                this.f201856b.f201850a.A1();
                TuringLiveDetectActivity.H1(this.f201856b.f201850a);
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

            public b(a r100, Throwable r101) {
                this.f201856b = r100;
                this.f201855a = r101;
            }
        }

        public a(TuringLiveDetectActivity r100) {
            this.f201850a = r100;
        }

        @Override // xb4.b
        public final void onError(Throwable r100) {
            TuringLiveDetectActivity r101 = this.f201850a;
            b r102 = new b(this, r100);
            int r103 = TuringLiveDetectActivity.f201828y;
            r101.M1(r102);
        }

        @Override // xb4.b
        public final void a(int r100, JSONObject r101, String... r102) {
            TuringLiveDetectActivity r103 = this.f201850a;
            RunnableC2908a r104 = new RunnableC2908a(this, r100, r101, r102);
            int r105 = TuringLiveDetectActivity.f201828y;
            r103.M1(r104);
        }
    }

    public class b implements xb4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuringLiveDetectActivity f201857a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f201858a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ JSONObject f201859b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String[] f201860c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ b f201861d;

            public final void a() {
                TuringLiveDetectActivity r100 = this.f201861d.f201857a;
                r100.getClass();
                r100.runOnUiThread(new vb4.k(r100));
                boolean r101 = true;
                if (this.f201858a != 200) goto L7;
                TuringLiveDetectActivity r102 = this.f201861d.f201857a;
                r102.f201837l = 0;
                EventReport.c(true, "", r102.f201847v);
                TuringLiveDetectActivity r103 = this.f201861d.f201857a;
                r103.f201831f.setDetectResult(true);
                Handler r104 = r103.f201830e;
                if (r104 == null) goto L15;
                r104.postDelayed(new w(r103), 500);
                return;
            L15:
                return;
            L7:
                this.f201861d.f201857a.f201831f.setDetectResult(false);
                JSONObject r105 = this.f201859b;
                if (r105 == null) goto L10;
                r101 = r105.optBoolean("retryable", false);
            L10:
                EventReport.c(false, "retryable:" + r101, this.f201861d.f201857a.f201847v);
                if (r101 == false) goto L13;
                TuringLiveDetectActivity.F1(this.f201861d.f201857a, this.f201860c);
                return;
            L13:
                this.f201861d.f201857a.N1(this.f201860c);
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

            public a(b r100, int r101, JSONObject r102, String[] r103) {
                this.f201861d = r100;
                this.f201858a = r101;
                this.f201859b = r102;
                this.f201860c = r103;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.bdturing.livedetect.TuringLiveDetectActivity$b$b, reason: collision with other inner class name */
        public class RunnableC2909b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f201862a;

            @Override // java.lang.Runnable
            public final void run() {
                TuringLiveDetectActivity r100 = this.f201862a.f201857a;     // Catch: Throwable -> L4
                r100.getClass();     // Catch: Throwable -> L4
                r100.runOnUiThread(new vb4.k(r100));     // Catch: Throwable -> L4
                TuringLiveDetectActivity.F1(this.f201862a.f201857a, null);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC2909b(b r100) {
                this.f201862a = r100;
            }
        }

        public b(TuringLiveDetectActivity r100) {
            this.f201857a = r100;
        }

        @Override // xb4.b
        public final void onError(Throwable r100) {
            TuringLiveDetectActivity r101 = this.f201857a;
            RunnableC2909b r102 = new RunnableC2909b(this);
            int r103 = TuringLiveDetectActivity.f201828y;
            r101.M1(r102);
        }

        @Override // xb4.b
        public final void a(int r100, JSONObject r101, String... r102) {
            TuringLiveDetectActivity r103 = this.f201857a;
            a r104 = new a(this, r100, r101, r102);
            int r105 = TuringLiveDetectActivity.f201828y;
            r103.M1(r104);
        }
    }

    public class c implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuringLiveDetectActivity f201863a;

        @Override // sb4.l
        public final void a() {
            TuringLiveDetectActivity r100 = this.f201863a;
            int r101 = TuringLiveDetectActivity.f201828y;
            r100.getClass();
            TuringLiveDetectWebActivity.startActivity(r100, e.b(), r100.getString(R.string.turing_live_detect_help));
            EventReport.r(2, 2, "", this.f201863a.f201847v);
        }

        @Override // sb4.l
        public final void b() {
            this.f201863a.finish();
            EventReport.r(2, 1, "", this.f201863a.f201847v);
        }

        @Override // sb4.l
        public final void onCancel() {
            this.f201863a.finish();
            EventReport.r(2, 3, "", this.f201863a.f201847v);
        }

        public c(TuringLiveDetectActivity r100) {
            this.f201863a = r100;
        }
    }

    public void K1() {
    }

    public final void P1() {
        this.f201843r = true;
        O1("");
        this.f201831f.i();
    }

    public final void I1() {
        jc4.a r100 = this.f201847v;
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L8
        r101.put("key", "turing_live_start_create_session");     // Catch: Exception -> L8
        if (TextUtils.isEmpty("mDecisionDetail:") == true) goto L6;
        r101.put("custom", "mDecisionDetail:");     // Catch: Exception -> L8
    L6:
        EventReport.w("turing_verify_sdk", r101, r100);     // Catch: Exception -> L8
    L11:
        if (TextUtils.isEmpty(this.f201839n) == false) goto L14;
        finish();
        return;
    L14:
        B1("");
        LiveDetectService.getInstance().createSession(this.f201839n, this.f201848w);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public final void L1() {
        HashMap r100 = new HashMap();
        r100.put(-1, getResources().getString(R.string.turing_live_detect_no_face));     // Catch: Exception -> L5
        r100.put(0, getString(R.string.turing_live_detect_server_detecting));     // Catch: Exception -> L5
        r100.put(20, getResources().getString(R.string.turing_live_detect_no_face));     // Catch: Exception -> L5
        r100.put(10, getResources().getString(R.string.turing_live_detect_face_small));     // Catch: Exception -> L5
        r100.put(21, getResources().getString(R.string.turing_live_detect_no_face));     // Catch: Exception -> L5
        r100.put(22, getResources().getString(R.string.turing_live_detect_multiple_face));     // Catch: Exception -> L5
        r100.put(40, getResources().getString(R.string.turing_live_detect_face_small));     // Catch: Exception -> L5
        r100.put(41, getResources().getString(R.string.turing_live_detect_face_close));     // Catch: Exception -> L5
        r100.put(42, getResources().getString(R.string.turing_live_detect_face_direction));     // Catch: Exception -> L5
        r100.put(30, getResources().getString(R.string.turing_live_detect_face_occlusion));     // Catch: Exception -> L5
        r100.put(11, getResources().getString(R.string.turing_live_detect_illumination_high));     // Catch: Exception -> L5
        r100.put(12, getResources().getString(R.string.turing_live_detect_illumination_low));     // Catch: Exception -> L5
    L7:
        this.f201836k = r100;
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        super.finish();
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
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        this.f201829d = true;
        k r100 = this.f201842q;
        if (r100 != null) goto L8;
    L10:
        LiveDetectView r101 = this.f201831f;
        if (r101 == null) goto L13;
        r101.f();
    L13:
        this.f201830e.removeCallbacksAndMessages(null);
        this.f201830e = null;
        EventReport.x(TuringLiveDetectActivity.class.getName(), this.f201837l, this.f201847v);
        int r102 = this.f201837l;
        long r103 = System.currentTimeMillis() - this.f201845t;
        jc4.a r104 = this.f201847v;
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L16
        r105.put("key", "live_detect_result");     // Catch: Exception -> L16
        r105.put("result", r102);     // Catch: Exception -> L16
        r105.put("duration", r103);     // Catch: Exception -> L16
        EventReport.w("turing_verify_sdk", r105, r104);     // Catch: Exception -> L16
    L18:
        LiveDetectService.getInstance().onResult(this.f201837l, null);
        this.f201847v = null;
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L8:
        if (r100.isShowing() == false) goto L10;
        C1(this.f201842q);
        this.f201842q = null;
        goto L10
    }

    public TuringLiveDetectActivity() {
        this.f201829d = false;
        this.f201835j = 0;
        this.f201836k = new HashMap();
        this.f201837l = 1;
        this.f201843r = false;
        this.f201846u = 0;
        this.f201848w = new a(this);
        this.f201849x = new b(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (e.e() == false) goto L6;
        super.onBackPressed();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (this.f201843r == false) goto L5;
        return;
    L5:
        this.f201831f.i();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f201843r == false) goto L5;
        return;
    L5:
        LiveDetectView r100 = this.f201831f;
        if (r100.f201969d.get() == 3) goto L9;
        return;
    L9:
        if (r100.f201966a.isAvailable() == true) goto L11;
        r100.f201969d.set(1);
        return;
    L11:
        r100.f201972g.a();
        r100.f201969d.set(2);
        r100.d(r100.f201969d.get());
        r100.f201967b.f();
    }

    public static void C1(k r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void D1(k r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static void G1(TuringLiveDetectActivity r100) {
        r100.getClass();
        r100.f201844s = System.currentTimeMillis();
        r100.f201843r = false;
        jc4.a r101 = r100.f201847v;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L5
        r102.put("key", "turing_live_detect_start");     // Catch: Exception -> L5
        EventReport.w("turing_verify_sdk", r102, r101);     // Catch: Exception -> L5
    L7:
        Window r103 = r100.getWindow();
        WindowManager.LayoutParams r104 = r103.getAttributes();
        r104.screenBrightness = 1.0f;
        r103.setAttributes(r104);
        r100.O1((String) ((HashMap) r100.f201836k).get(20));
        r100.f201831f.h();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void H1(TuringLiveDetectActivity r100) {
        k r101 = r100.f201842q;
        if (r101 == null) goto L5;
        C1(r101);
    L5:
        String r102 = r100.getString(R.string.turing_net_error_dlg_fail_title);
        String r103 = r100.getString(R.string.turing_net_error_dlg_fail_content);
        sb4.b r104 = new sb4.b();
        r104.f541211a = r102;
        r104.f541212b = r103;
        r104.f541213c = r100.getString(R.string.turing_net_error_dlg_left_text);
        r104.f541214d = r100.getString(R.string.turing_net_error_dlg_right_text);
        k r105 = new k(r100, r104, false, new p(r100));
        r100.f201842q = r105;
        D1(r105);
        EventReport.r(1, 0, "", r100.f201847v);
    }

    public final void M1(Runnable r100) {
        Handler r101 = this.f201830e;
        if (r101 == null) goto L7;
        r101.post(r100);
        return;
    }

    public final void N1(String[] r100) {
        k r101 = this.f201842q;
        if (r101 == null) goto L6;
        C1(r101);
    L6:
        if (r100 != null) goto L8;
    L12:
        String r102 = "";
    L13:
        if (r100 != null) goto L15;
    L19:
        String r103 = "";
    L21:
        if (TextUtils.isEmpty(r102) == true) goto L23;
    L25:
        sb4.b r104 = new sb4.b();
        r104.f541211a = r102;
        r104.f541212b = r103;
        r104.f541213c = getString(R.string.turing_live_detect_dlg_fail_left_text);
        r104.f541214d = getString(R.string.turing_live_detect_dlg_fail_right_text);
        k r105 = new k(this, r104, false, new c(this));
        this.f201842q = r105;
        D1(r105);
        EventReport.r(2, 0, "", this.f201847v);
        return;
    L23:
        if (TextUtils.isEmpty(r103) == false) goto L25;
        r102 = getString(R.string.turing_live_detect_dlg_fail_title);
        r103 = getString(R.string.turing_live_detect_dlg_fail_content);
        goto L25
    L15:
        if (r100.length <= 1) goto L19;
        if (TextUtils.isEmpty(r100[1]) == true) goto L19;
        r103 = r100[1];
        goto L21
    L8:
        if (r100.length <= 0) goto L12;
        if (TextUtils.isEmpty(r100[0]) == true) goto L12;
        r102 = r100[0];
        goto L13
    }

    public final void O1(String r100) {
        if ((System.currentTimeMillis() - this.f201835j) >= 500) goto L5;
        return;
    L5:
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        this.f201835j = System.currentTimeMillis();
        this.f201832g.setText(r100);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L19
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L19
    L8:
        super.onCreate(r100);
        getWindow().setFlags(8192, 8192);
        this.f201839n = getIntent().getStringExtra("detail");
        this.f201847v = LiveDetectService.getInstance().getRequest();
        setContentView(R.layout.activity_turing_live_detect);
        this.f201824b = (ImageView) findViewById(R.id.loading);
        LiveDetectView r101 = (LiveDetectView) findViewById(R.id.turing_ldv);
        this.f201831f = r101;
        r101.setBoxStateListener(new r(this));
        this.f201832g = (TextView) findViewById(R.id.tv_detect_state);
        this.f201833h = (TextView) findViewById(R.id.tv_test_img_detect_state);
        this.f201834i = (TextView) findViewById(R.id.tv_test_img_detect_error);
        this.f201838m = (TextView) findViewById(R.id.tv_test_time_use);
        LiveDetectView r102 = this.f201831f;
        com.bytedance.bdturing.setting.e r103 = com.bytedance.bdturing.setting.e.f202077a;
        long r104 = CastLongProtector.parseLong(com.bytedance.bdturing.setting.e.f("timeout"));     // Catch: Exception -> L11
    L14:
        if (r104 > 0) goto L17;
        r104 = 10000;
    L17:
        r102.setDetectTimeOut(r104);
        this.f201831f.setDebugInfoCallBack(new v(this));
        this.f201831f.setDetectStateCallBack(new s(this));
        this.f201845t = System.currentTimeMillis();
        this.f201830e = new Handler();
        LiveDetectService.getInstance().setOnVerify(true);
        K1();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        r104 = 0;
        goto L14
    }

    public static void F1(TuringLiveDetectActivity r100, String[] r101) {
        k r102 = r100.f201842q;
        if (r102 == null) goto L5;
        C1(r102);
    L5:
        sb4.b r103 = new sb4.b();
        String r104 = "";
        if (r101 != null) goto L8;
    L12:
        String r105 = "";
    L13:
        if (r101 == null) goto L20;
        if (r101.length <= 1) goto L20;
        if (TextUtils.isEmpty(r101[1]) == true) goto L20;
        r104 = r101[1];
    L20:
        if (TextUtils.isEmpty(r105) == true) goto L22;
    L24:
        r103.f541211a = r105;
        r103.f541212b = r104;
        r103.f541213c = r100.getResources().getString(R.string.turing_live_detect_dlg_timeout_left_text);
        r103.f541214d = r100.getResources().getString(R.string.turing_live_detect_dlg_timeout_right_text);
        k r106 = new k(r100, r103, e.e(), new q(r100));
        r100.f201842q = r106;
        D1(r106);
        return;
    L22:
        if (TextUtils.isEmpty(r104) == false) goto L24;
        r105 = r100.getResources().getString(R.string.turing_live_detect_dlg_timeout_title);
        r104 = r100.getResources().getString(R.string.turing_live_detect_dlg_timeout_content);
        goto L24
    L8:
        if (r101.length <= 0) goto L12;
        if (TextUtils.isEmpty(r101[0]) == true) goto L12;
        r105 = r101[0];
        goto L13
    }
}
