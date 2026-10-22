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
import com.bytedance.bdturing.sensor.AccMonitor;
import com.bytedance.bdturing.sensor.GyroMonitor;
import com.bytedance.bdturing.verify.RiskControlService;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
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
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Map;
import jc4.o;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.c0;
import qb4.f;
import qb4.g0;
import qb4.i;
import qb4.j;
import qb4.n;
import qb4.p;
import qb4.t;
import rb4.g;

/* JADX INFO: loaded from: classes12.dex */
public class BdTuringVerifyActivity extends AppCompatActivity implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jc4.a f201662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EventReport.CloseType f201663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f201664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f201665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f201666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f201667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f201668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f201669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TuringVerifyWebView f201670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CardView f201671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f201672k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ac4.b f201673l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f201674m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f201675n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.bdturing.sensor.a f201676o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f201677p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f201678q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f201679r;

    public class a implements g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BdTuringVerifyActivity f201680a;

        @Override // qb4.g0
        public final void a(int r100, String r101, String r102) {
        }

        @Override // qb4.g0
        public final void c() {
            this.f201680a.f201665d = true;
            long r100 = System.currentTimeMillis();
            BdTuringVerifyActivity r101 = this.f201680a;
            EventReport.O(0, r100 - r101.f201675n, r101.f201662a);
        }

        public a(BdTuringVerifyActivity r100) {
            this.f201680a = r100;
        }

        @Override // qb4.g0
        public final void b(int r100, String r101) {
            long r102 = System.currentTimeMillis();
            BdTuringVerifyActivity r103 = this.f201680a;
            EventReport.O(1, r102 - r103.f201675n, r103.f201662a);
            BdTuringVerifyActivity r104 = this.f201680a;
            r104.f201665d = false;
            r104.f201663b = EventReport.CloseType.CLOSE_REASON_PAGE_LOAD_FAILED;
            r104.dismiss();
        }
    }

    public class b extends ac4.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BdTuringVerifyActivity f201681a;

        @Override // ac4.f
        public final void l(String r100, ac4.f.a r101) {
        }

        @Override // ac4.f
        public final void c() {
            this.f201681a.o0();
        }

        @Override // ac4.f
        public final void i() {
            TuringVerifyWebView r100 = this.f201681a.f201670i;
            if (r100 == null) goto L6;
            r100.e();
            return;
        }

        @Override // ac4.f
        public final void p() {
            jc4.a r100 = this.f201681a.f201662a;
            if ((r100 instanceof o) == false) goto L8;
            JSONObject r101 = ((o) r100).f498127o;
            if (r101 == null) goto L9;
            String r102 = ac4.c.b("bytedcert.verifyData", r101, "bytedcert.verifyData");
            this.f201681a.z1(r102);
            return;
        L9:
            return;
        }

        public b(BdTuringVerifyActivity r100) {
            this.f201681a = r100;
        }

        @Override // ac4.f
        public final void e(ac4.c r100) {
            JSONObject r101 = new JSONObject();
            hc4.d.b(r101, "maskTime", Long.valueOf(this.f201681a.f201675n));
            r100.d(1, r101);
        }

        @Override // ac4.f
        public final void f(ac4.c r110) {
            com.bytedance.bdturing.sensor.a r100 = this.f201681a.f201676o;
            r100.getClass();
            JSONObject r101 = new JSONObject();
            int r102 = -1;
            r101.put("s", r100.f202069c.toJsonObj());     // Catch: Exception -> L47
            GyroMonitor r103 = r100.f202068b;     // Catch: Exception -> L47
            if (r103 == null) goto L23;
            JSONObject r104 = r103.getStateRecord();     // Catch: Exception -> L47
            JSONArray r105 = r100.f202068b.getData();     // Catch: Exception -> L21
            JSONArray r106 = r100.f202068b.getAccuracyData();     // Catch: Exception -> L21
            int r107 = r105.length();     // Catch: Exception -> L19
            r101.put("ae", r105);     // Catch: Exception -> L16
            JSONArray r108 = r100.f202068b.getInitialData();     // Catch: Exception -> L16
            int r111 = r108.length();     // Catch: Exception -> L16
            if (r111 > 0) goto L84;
            JSONObject r112 = null;
        L96:
            r101.put("be", r108);     // Catch: Exception -> L45
        L24:
            AccMonitor r109 = r100.f202067a;     // Catch: Exception -> L45
            if (r109 == null) goto L44;
            JSONObject r113 = r109.getStateRecord();     // Catch: Exception -> L45
            JSONArray r114 = r100.f202067a.getData();     // Catch: Exception -> L42
            JSONArray r115 = r100.f202067a.getAccuracyData();     // Catch: Exception -> L42
            int r116 = r114.length();     // Catch: Exception -> L40
            r101.put("qs", r114);     // Catch: Exception -> L38
            JSONArray r117 = r100.f202067a.getInitialData();     // Catch: Exception -> L38
            r102 = r117.length();     // Catch: Exception -> L38
            if (r102 <= 0) goto L33;
            JSONObject r118 = JSONArrayProtectorUtils.getJSONObject(r117, 0);     // Catch: Exception -> L38
        L90:
            r101.put("qa", r117);     // Catch: Exception -> L36
        L55:
            int r119 = r102;
            r102 = r116;
        L56:
            JSONObject r120 = r100.f202072f;
            JSONObject r121 = new JSONObject();     // Catch: Exception -> L74
            r121.put("key", "sensor_detail");     // Catch: Exception -> L74
            StringBuilder r122 = new StringBuilder("gryDataSize=");     // Catch: Exception -> L74
            r122.append(r107);     // Catch: Exception -> L74
            r122.append(":gryInitDataSize=");     // Catch: Exception -> L74
            r122.append(r111);     // Catch: Exception -> L74
            r122.append(":grySampleData=");     // Catch: Exception -> L74
            r122.append(r112);     // Catch: Exception -> L74
            r122.append(":accDataSize=");     // Catch: Exception -> L74
            r122.append(r102);     // Catch: Exception -> L74
            r122.append(":accInitDataSize=");     // Catch: Exception -> L74
            r122.append(r119);     // Catch: Exception -> L74
            r122.append(":accSampleData=");     // Catch: Exception -> L74
            r122.append(r118);     // Catch: Exception -> L74
            if (r106 != null) goto L60;
        L62:
            if (r115 != null) goto L64;
        L66:
            r122.append(":stateRecord=");     // Catch: Exception -> L74
            r122.append(r120);     // Catch: Exception -> L74
            r122.append(":accSateRecord=");     // Catch: Exception -> L74
            r122.append(r113);     // Catch: Exception -> L74
            r122.append(":gyroStateRecord=");     // Catch: Exception -> L74
            r122.append(r104);     // Catch: Exception -> L74
            if (r107 > 0) goto L71;
            if (r102 > 0) goto L71;
            int r123 = 0;
        L72:
            r121.put("result", r123 ^ 1);     // Catch: Exception -> L74
            r121.put("custom", r122.toString());     // Catch: Exception -> L74
            EventReport.w("turing_verify_sdk", r121, null);     // Catch: Exception -> L74
        L76:
            System.currentTimeMillis();
            r110.d(1, r101);
            return;
        L71:
            r123 = 1;
            goto L72
        L64:
            if (r115.length() <= 0) goto L66;
            r122.append(":accAccuracy=");     // Catch: Exception -> L74
            r122.append(r115);     // Catch: Exception -> L74
            goto L66
        L60:
            if (r106.length() <= 0) goto L62;
            r122.append(":gryAccuracy=");     // Catch: Exception -> L74
            r122.append(r106);     // Catch: Exception -> L74
        L74:
            e = move-exception;
            e.printStackTrace();
        L36:
            e = e;
        L54:
            e.printStackTrace();
            goto L55
        L33:
            r118 = null;
        L38:
            e = e;
        L53:
            r118 = null;
        L40:
            e = e;
        L52:
            r116 = -1;
        L42:
            e = e;
        L51:
            r115 = null;
            goto L52
        L44:
            r119 = -1;
            r113 = null;
            r115 = null;
            r118 = null;
        L45:
            e = e;
        L46:
            r113 = null;
            goto L51
        L84:
            r112 = JSONArrayProtectorUtils.getJSONObject(r108, 0);     // Catch: Exception -> L12
        L12:
            e = e;
        L18:
            r112 = null;
        L16:
            e = e;
            r111 = -1;
        L19:
            e = e;
        L50:
            r107 = -1;
            r111 = -1;
            r112 = null;
            r113 = null;
        L21:
            e = e;
        L49:
            r106 = null;
            goto L50
        L23:
            r104 = null;
            r106 = null;
            r107 = -1;
            r111 = -1;
            r112 = null;
        L47:
            e = e;
            r104 = null;
            goto L49
        }

        @Override // ac4.f
        public final void g(ac4.c r100) {
            BdTuringConfig r101 = qb4.b.c.f532315a.f532302a;
            if (r101 == null) goto L5;
            JSONObject r102 = r101.getTheme(this.f201681a.f201674m);
        L6:
            r100.d(1, r102);
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // ac4.f
        public final void j(int r100, int r101, boolean r102) {
            BdTuringVerifyActivity r103 = this.f201681a;
            r103.f201665d = true;
            r103.f201663b = EventReport.CloseType.CLOSE_REASON_APP;
            if (r103.f201666e == false) goto L6;
            return;
        L6:
            if (r103.f201662a.d() == true) goto L10;
            if (r102 == true) goto L10;
            boolean r104 = false;
        L11:
            if (r104 == false) goto L13;
            Point r105 = hc4.f.f(r103);
            int r106 = r105.x;
            int r107 = r105.y;
            int r108 = r106;
        L18:
            ViewGroup.LayoutParams r109 = r103.f201670i.getLayoutParams();
            if (r103.f201667f == false) goto L25;
            int r110 = r109.width;
            if (r110 <= 0) goto L25;
            int r111 = r109.height;
            if (r111 <= 0) goto L25;
            r103.f201670i.f(r108, r107, r110, r111);
            r103.f201667f = false;
            return;
        L25:
            r103.f201670i.post(new j(r103, r104, r109, r108, r107));
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
            BdTuringVerifyActivity r103 = this.f201681a;
            r103.f201665d = true;
            r103.f201663b = EventReport.CloseType.CLOSE_REASON_APP;
            if (r103.f201666e == false) goto L6;
            return;
        L6:
            if (r103.f201662a.d() == true) goto L10;
            if (r102 == true) goto L10;
            boolean r104 = false;
        L11:
            if (r104 == false) goto L13;
            Point r105 = hc4.f.f(r103);
            int r106 = r105.x;
            int r107 = r105.y;
            int r108 = r106;
        L14:
            ViewGroup.LayoutParams r109 = r103.f201670i.getLayoutParams();
            if (r103.f201667f == false) goto L21;
            int r110 = r109.width;
            if (r110 <= 0) goto L21;
            int r111 = r109.height;
            if (r111 <= 0) goto L21;
            r103.f201670i.f(r108, r107, r110, r111);
            r103.f201667f = false;
            return;
        L21:
            r103.f201670i.post(new i(r103, r104, r109, r108, r107));
            return;
        L13:
            r108 = r100;
            r107 = r101;
        L10:
            r104 = true;
            goto L11
        }

        @Override // ac4.f
        public final void m(int r100, String r101, String r102, String r103, JSONObject r104) {
            if (r100 != 0) goto L5;
            boolean r105 = true;
        L6:
            int r106 = n.f532367a;
            EventReport.N(r100, this.f201681a.f201662a);
            if (this.f201681a.f201672k == null) goto L17;
            JSONObject r107 = new JSONObject();
            r107.put("token", r101);     // Catch: JSONException -> L11
            r107.put("mobile", r102);     // Catch: JSONException -> L11
            r107.put("decision", r103);     // Catch: JSONException -> L11
            r107.put("query", r104);     // Catch: JSONException -> L11
        L13:
            if (r105 == false) goto L15;
            this.f201681a.f201672k.onSuccess(r100, r107);
        L16:
            this.f201681a.f201672k = null;
            goto L17
        L15:
            this.f201681a.f201672k.onFail(r100, r107);
        L11:
            e = move-exception;
            Intrinsics.checkNotNullParameter(e, "e");
            e.printStackTrace();
        L17:
            BdTuringVerifyActivity r108 = this.f201681a;
            r108.f201668g = true;
            r108.dismiss();
            return;
        L5:
            r105 = false;
            goto L6
        }
    }

    public class c implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BdTuringVerifyActivity f201682a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public c(BdTuringVerifyActivity r100) {
            this.f201682a = r100;
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
            if (this.f201682a.f201662a.getType() != 2) goto L12;
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
            BdTuringVerifyActivity r107 = this.f201682a;
            r107.f201667f = true;
            r107.z1(r106);
            EventReport.L(r102, this.f201682a.f201662a);
            return;
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
        public final TuringVerifyWebView f201683a;

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = n.f532367a;     // Catch: Throwable -> L11
            TuringVerifyWebView r101 = this.f201683a;     // Catch: Throwable -> L11
            if (r101 == null) goto L14;
            ViewParent r102 = r101.getParent();     // Catch: Throwable -> L11
            if (r102 != null) goto L8;
            return;
        L8:
            if ((r102 instanceof ViewGroup) == false) goto L19;
            ((ViewGroup) r102).removeView(this.f201683a);     // Catch: Throwable -> L11
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

        public d(BdTuringVerifyActivity r100) {
            this.f201683a = r100.f201670i;
        }
    }

    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f201684a = null;

        static {
            int[] r100 = new int[EventReport.CloseType.values().length];
            f201684a = r100;
            r100[EventReport.CloseType.CLOSE_REASON_PAGE_LOAD_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f201684a[EventReport.CloseType.CLOSE_REASON_BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f201684a[EventReport.CloseType.CLOSE_REASON_APP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
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
        ac4.b r102 = this.f201673l;     // Catch: Throwable -> L13
        if (r102 != null) goto L10;
        monitor-exit(this);
        return;
    L10:
        r102.b();     // Catch: Throwable -> L13
        this.f201673l = null;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public boolean A1() {
        com.bytedance.bdturing.setting.e r100 = com.bytedance.bdturing.setting.e.f202077a;
        return com.bytedance.bdturing.setting.e.i();
    }

    @Override // qb4.t
    public final void n1() {
        f r100 = this.f201672k;
        if (r100 == null) goto L5;
        r100.onFail(1001, null);
        this.f201672k = null;
    L5:
        dismiss();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        TuringVerifyWebView r100 = this.f201670i;
        if (r100 == null) goto L9;
        if (r100.canGoBack() == false) goto L9;
        this.f201670i.goBack();
        return;
    L9:
        if (A1() == false) goto L12;
        this.f201663b = EventReport.CloseType.CLOSE_REASON_BACK;
        super.onBackPressed();
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        int r100 = n.f532367a;
        com.bytedance.bdturing.sensor.a r101 = this.f201676o;
        if (r101 == null) goto L50;
        PthreadHandlerThreadV2 r102 = r101.f202070d;     // Catch: Exception -> L11
        if (r102 == null) goto L50;
        r102.quitSafely();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L50:
    L28:
        th = move-exception;
        c0.a.f532328a.c(3, null);
        this.f201672k = null;
        RiskControlService.INSTANCE.release();
        EventReport.P(System.currentTimeMillis() - this.f201675n, "BdTuringVerifyActivity", this.f201662a);
        this.f201662a = null;
        throw th;
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L28
    L46:
        c0.a.f532328a.c(3, null);
        this.f201672k = null;
        RiskControlService.INSTANCE.release();
        EventReport.P(System.currentTimeMillis() - this.f201675n, "BdTuringVerifyActivity", this.f201662a);
        this.f201662a = null;
        return;
    L15:
        if (this.f201670i == null) goto L18;
        y1(getWindow()).post(new d(this));     // Catch: Throwable -> L28 Exception -> L30
        this.f201670i = null;     // Catch: Throwable -> L28 Exception -> L30
    L18:
        if (this.f201666e == true) goto L46;
        this.f201666e = true;     // Catch: Throwable -> L28 Exception -> L30
        unregisterComponentCallbacks(this.f201679r);     // Catch: Throwable -> L28 Exception -> L30
        if (this.f201665d == true) goto L23;
        o0();     // Catch: Throwable -> L28 Exception -> L30
        EventReport.G(this.f201663b, this.f201662a);     // Catch: Throwable -> L28 Exception -> L30
    L34:
        if (this.f201672k == null) goto L46;
        int r103 = e.f201684a[this.f201663b.ordinal()];     // Catch: Throwable -> L28 Exception -> L30
        if (r103 != 1) goto L38;
        this.f201672k.onFail(3, null);     // Catch: Throwable -> L28 Exception -> L30
        goto L46
    L38:
        if (r103 == 2) goto L42;
        if (r103 == 3) goto L41;
        this.f201672k.onFail(1, null);     // Catch: Throwable -> L28 Exception -> L30
        goto L46
    L41:
        this.f201672k.onFail(6, null);     // Catch: Throwable -> L28 Exception -> L30
        goto L46
    L42:
        this.f201672k.onFail(5, null);     // Catch: Throwable -> L28 Exception -> L30
        goto L46
    L23:
        if (this.f201668g == true) goto L25;
        B1(this.f201663b.getName());     // Catch: Throwable -> L28 Exception -> L30
    L25:
        c0 r104 = c0.a.f532328a;     // Catch: Throwable -> L28 Exception -> L30
        c0.b r105 = r104.f532327b;     // Catch: Throwable -> L28 Exception -> L30
        if (r105 == null) goto L34;
        Message r106 = r105.obtainMessage(1, this);     // Catch: Throwable -> L28 Exception -> L30
        r104.f532327b.sendMessageDelayed(r106, 10000);     // Catch: Throwable -> L28 Exception -> L30
        goto L34
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        this.f201676o.a();
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        this.f201676o.b();
        super.onResume();
    }

    public BdTuringVerifyActivity() {
        this.f201663b = EventReport.CloseType.CLOSE_REASON_APP;
        this.f201664c = null;
        this.f201665d = false;
        this.f201666e = false;
        this.f201667f = false;
        this.f201668g = false;
        this.f201677p = new a(this);
        this.f201678q = new b(this);
        this.f201679r = new c(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0111 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
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

    public void initView() {
        this.f201669h = (ImageView) findViewById(com.larus.nova.R.id.loading);
        this.f201670i = (TuringVerifyWebView) findViewById(com.larus.nova.R.id.verify_webview);
        this.f201671j = (CardView) findViewById(com.larus.nova.R.id.web_container);
        if (this.f201662a.d() == false) goto L5;
        Resources r100 = getResources();
        DisplayMetrics r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        ViewGroup.LayoutParams r102 = this.f201670i.getLayoutParams();
        r102.width = r101.widthPixels;
        r102.height = r101.heightPixels;
        this.f201670i.setLayoutParams(r102);
        this.f201670i.setVisibility(0);
    L5:
        this.f201670i.d(this.f201677p, true, this.f201662a);
        p r103 = new p(this.f201662a.c());
        this.f201664c = r103;
        this.f201670i.setOnTouchListener(r103);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        EventReport.H(this.f201662a);
    }

    @Override // qb4.t
    public final void dismiss() {
        finish();
    }

    public static void startActivity(Activity r100) {
        r100.startActivity(new Intent(r100, BdTuringVerifyActivity.class));
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

    public final void B1(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("style", r100);     // Catch: JSONException -> L5
    L7:
        z1(ac4.c.b("bytedcert.goToClose", r101, "bytedcert.goToClose"));
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        RiskControlService r101 = RiskControlService.INSTANCE;
        this.f201662a = r101.getCurrentRequest();
        setContentView(com.larus.nova.R.layout.bdturing_verify_activity);
        EventReport.R(getClass().getSimpleName(), this.f201662a);
        EventReport.K(hc4.f.g(this), this.f201662a);
        this.f201672k = r101.getResultCallBack();
        if (this.f201662a != null) goto L13;
        finish();
        return;
    L13:
        this.f201676o = new com.bytedance.bdturing.sensor.a(this);
        this.f201674m = this.f201662a.getType();
        r101.bindVerifyInterface(this);
        registerComponentCallbacks(this.f201679r);
        initView();
        if (this.f201662a.f498092c == false) goto L16;
        RotateAnimation r102 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r102.setDuration(1000);
        r102.setRepeatCount(-1);
        r102.setInterpolator(new LinearInterpolator());
        this.f201669h.startAnimation(r102);
    L17:
        this.f201675n = System.currentTimeMillis();
        this.f201673l = new ac4.b(this.f201678q, this.f201670i);
        String r103 = this.f201662a.f();
        int r104 = n.f532367a;
        this.f201670i.setInterceptor(new g(r103));
        this.f201670i.loadUrl(r103);
        return;
    L16:
        this.f201669h.setVisibility(8);
        goto L17
    }

    @Override // android.app.Activity
    public final boolean onTouchEvent(MotionEvent r100) {
        p r101 = this.f201664c;
        if (r101 == null) goto L6;
        r101.a(r100);
    L6:
        return super.onTouchEvent(r100);
    }

    public final void z1(String r100) {
        ac4.b r101 = this.f201673l;
        if (r101 != null) goto L6;
        int r102 = n.f532367a;
        return;
    L6:
        r101.a(r100);
    }
}
