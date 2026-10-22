package com.bytedance.bdturing;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.bytedance.bdturing.setting.e;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import jc4.m;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.c0;
import qb4.f;
import qb4.g0;
import qb4.n;
import qb4.o;
import qb4.p;
import qb4.t;
import qb4.y;
import qb4.z;

/* JADX INFO: loaded from: classes6.dex */
public final class c extends Dialog implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ac4.b f201741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f201742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VerifyWebView f201743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CardView f201744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f201745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f201746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f201747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f201748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f201749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f201750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f201751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f201752l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f201753m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f201754n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public f f201755o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public p f201756p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public DialogInterface.OnDismissListener f201757q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public o f201758r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public EventReport.CloseType f201759s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f201760t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final jc4.a f201761u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f201762v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f201763w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final C2907c f201764x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d f201765y;

    /* JADX INFO: loaded from: classes12.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final VerifyWebView f201766a;

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = n.f532367a;     // Catch: Throwable -> L11
            VerifyWebView r101 = this.f201766a;     // Catch: Throwable -> L11
            if (r101 == null) goto L14;
            ViewParent r102 = r101.getParent();     // Catch: Throwable -> L11
            if (r102 != null) goto L8;
            return;
        L8:
            if ((r102 instanceof ViewGroup) == false) goto L19;
            ((ViewGroup) r102).removeView(this.f201766a);     // Catch: Throwable -> L11
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

        public a(c r100) {
            this.f201766a = r100.f201743c;
        }
    }

    /* JADX INFO: loaded from: classes12.dex */
    public class b extends ac4.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f201767a;

        @Override // ac4.f
        public final void c() {
            this.f201767a.o0();
        }

        @Override // ac4.f
        public final void p() {
            jc4.a r100 = this.f201767a.f201761u;
            if ((r100 instanceof jc4.o) == false) goto L11;
            JSONObject r101 = ((jc4.o) r100).f498127o;
            if (r101 == null) goto L12;
            String r102 = ac4.c.b("bytedcert.verifyData", r101, "bytedcert.verifyData");
            ac4.b r103 = this.f201767a.f201741a;
            if (r103 != null) goto L9;
            int r104 = n.f532367a;
            return;
        L9:
            r103.a(r102);
            return;
        L12:
            return;
        }

        public b(c r100) {
            this.f201767a = r100;
        }

        @Override // ac4.f
        public final void e(ac4.c r100) {
            JSONObject r101 = new JSONObject();
            hc4.d.b(r101, "maskTime", Long.valueOf(this.f201767a.f201762v));
            r100.d(1, r101);
        }

        @Override // ac4.f
        public final void g(ac4.c r100) {
            BdTuringConfig r101 = qb4.b.c.f532315a.f532302a;
            if (r101 == null) goto L5;
            JSONObject r102 = r101.getTheme(this.f201767a.f201760t);
        L6:
            r100.d(1, r102);
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // ac4.f
        public final void l(String r100, ac4.f.a r101) {
            m r102 = new m(r100);
            r102.f498092c = false;
            r102.f498091b = false;
            c r103 = this.f201767a;
            r103.f201757q.onDismiss(r103);
            qb4.b.c.f532315a.i(this.f201767a.f201761u.getActivity(), r102, r101);
        }

        @Override // ac4.f
        public final void j(int r100, int r101, boolean r102) {
            c r103 = this.f201767a;
            r103.getClass();
            int r104 = n.f532367a;
            if (r103.f201752l == false) goto L5;
            return;
        L5:
            if (r103.isShowing() == true) goto L8;
            return;
        L8:
            if (r103.f201761u.d() == true) goto L12;
            if (r102 == true) goto L12;
            boolean r105 = false;
        L13:
            Context r106 = r103.f201743c.getContext();
            if ((r106 instanceof Activity) == false) goto L16;
            Activity r107 = (Activity) r106;
        L17:
            if (r105 == false) goto L20;
            if (r107 == null) goto L20;
            Point r108 = hc4.f.f(r107);
            int r109 = r108.x;
            int r110 = r108.y;
            int r111 = r109;
        L25:
            ViewGroup.LayoutParams r112 = r103.f201743c.getLayoutParams();
            if (r103.f201753m == false) goto L32;
            int r113 = r112.width;
            if (r113 <= 0) goto L32;
            int r114 = r112.height;
            if (r114 <= 0) goto L32;
            r103.f201743c.d(r111, r110, r113, r114);
            r103.f201753m = false;
            return;
        L32:
            r103.f201743c.post(new y(r103, r105, r112, r111, r110));
            return;
        L20:
            float r115 = hc4.f.h(r103.f201748h);
            if (r100 <= 0) goto L24;
            if (r101 <= 0) goto L24;
            r100 = Math.round(r100 * r115);
            r101 = Math.round(r115 * r101);
        L24:
            r111 = r100;
            r110 = r101;
            goto L25
        L16:
            r107 = null;
        L12:
            r105 = true;
            goto L13
        }

        @Override // ac4.f
        public final void k(int r100, int r101, boolean r102) {
            c r103 = this.f201767a;
            r103.getClass();
            int r104 = n.f532367a;
            if (r103.f201752l == false) goto L5;
            return;
        L5:
            if (r103.isShowing() == true) goto L8;
            return;
        L8:
            if (r103.f201761u.d() == true) goto L12;
            if (r102 == true) goto L12;
            boolean r105 = false;
        L13:
            Context r106 = r103.f201743c.getContext();
            if ((r106 instanceof Activity) == false) goto L16;
            Activity r107 = (Activity) r106;
        L17:
            if (r105 == false) goto L20;
            if (r107 == null) goto L20;
            Point r108 = hc4.f.f(r107);
            int r109 = r108.x;
            int r110 = r108.y;
            int r111 = r109;
        L21:
            ViewGroup.LayoutParams r112 = r103.f201743c.getLayoutParams();
            if (r103.f201753m == false) goto L28;
            int r113 = r112.width;
            if (r113 <= 0) goto L28;
            int r114 = r112.height;
            if (r114 <= 0) goto L28;
            r103.f201743c.d(r111, r110, r113, r114);
            r103.f201753m = false;
            return;
        L28:
            r103.f201743c.post(new z(r103, r105, r112, r111, r110));
            return;
        L20:
            r111 = r100;
            r110 = r101;
            goto L21
        L16:
            r107 = null;
        L12:
            r105 = true;
            goto L13
        }

        @Override // ac4.f
        public final void m(int r100, String r101, String r102, String r103, JSONObject r104) {
            if (r100 != 0) goto L5;
            boolean r105 = true;
        L6:
            EventReport.N(r100, this.f201767a.f201761u);
            if (this.f201767a.f201755o == null) goto L17;
            JSONObject r106 = new JSONObject();
            r106.put("token", r101);     // Catch: JSONException -> L11
            r106.put("mobile", r102);     // Catch: JSONException -> L11
            r106.put("decision", r103);     // Catch: JSONException -> L11
            r106.put("query", r104);     // Catch: JSONException -> L11
        L13:
            if (r105 == false) goto L15;
            this.f201767a.f201755o.onSuccess(r100, r106);
        L16:
            this.f201767a.f201755o = null;
            goto L17
        L15:
            this.f201767a.f201755o.onFail(r100, r106);
        L11:
            e = move-exception;
            int r107 = n.f532367a;
            Intrinsics.checkNotNullParameter(e, "e");
            e.printStackTrace();
        L17:
            c r108 = this.f201767a;
            r108.f201751k = true;
            Handler r109 = DialogLancet.resolveDialogHandler(r108);
            if (r109 != null) goto L20;
        L22:
            DialogLancet.beforeDialogDismiss(r108);
            r108.dismiss();     // Catch: Throwable -> L25 Exception -> L27
        L31:
            DialogLancet.afterDialogDismiss(r108);
            return;
        L25:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r108);
            throw th;
        L27:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L25
            Throwable r110 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L25
            if (r110 == null) goto L31;
            com.bytedance.crash.d.d(r110, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L25
            goto L31
        L20:
            if (Looper.myLooper() == r109.getLooper()) goto L22;
            r109.post(DialogLancet.createDismissRunnable(r108));
            return;
        L5:
            r105 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdturing.c$c, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes12.dex */
    public class C2907c implements g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f201768a;

        @Override // qb4.g0
        public final void a(int r100, String r101, String r102) {
        }

        @Override // qb4.g0
        public final void c() {
            this.f201768a.f201750j = true;
        }

        public C2907c(c r100) {
            this.f201768a = r100;
        }

        @Override // qb4.g0
        public final void b(int r100, String r101) {
            c r102 = this.f201768a;
            r102.f201750j = false;
            if (r102.f201752l == true) goto L5;
            r102.getClass();
            r102.getClass();
        L5:
            c r103 = this.f201768a;
            r103.f201759s = EventReport.CloseType.CLOSE_REASON_PAGE_LOAD_FAILED;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L8;
        L10:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L13 Exception -> L15
        L19:
            DialogLancet.afterDialogDismiss(r103);
            return;
        L13:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r105 == null) goto L19;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
            goto L19
        L8:
            if (Looper.myLooper() == r104.getLooper()) goto L10;
            r104.post(DialogLancet.createDismissRunnable(r103));
        }
    }

    /* JADX INFO: loaded from: classes12.dex */
    public class d implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f201769a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public d(c r100) {
            this.f201769a = r100;
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
            if (this.f201769a.f201761u.getType() != 2) goto L12;
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
            c r107 = this.f201769a;
            r107.f201753m = true;
            ac4.b r108 = r107.f201741a;
            if (r108 != null) goto L24;
            int r109 = n.f532367a;
        L25:
            EventReport.L(r102, this.f201769a.f201761u);
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

    @Override // qb4.t
    public final synchronized void o0() {
        monitor-enter(this);
        int r100 = n.f532367a;     // Catch: Throwable -> L13
        if (this.f201748h != null) goto L10;
        if (this.f201741a != null) goto L10;
        monitor-exit(this);
        return;
    L10:
        this.f201748h = null;     // Catch: Throwable -> L13
        this.f201741a.b();     // Catch: Throwable -> L13
        this.f201741a = null;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Dialog, android.content.DialogInterface, qb4.t
    public final void dismiss() {
        if (this.f201743c == null) goto L11;
        View r100 = getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r101 = ThreadMethodProxy.currentThread();
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");
    L9:
        r100.post(new a(this));
        this.f201743c = null;
    L11:
        if (this.f201752l == false) goto L13;
        return;
    L13:
        this.f201752l = true;
        if (isShowing() == false) goto L19;
        a(this);     // Catch: Exception -> L17
    L17:
        int r102 = n.f532367a;
    L19:
        if (this.f201761u.getActivity() == null) goto L21;
        this.f201761u.getActivity().unregisterComponentCallbacks(this.f201765y);
    L21:
        o r103 = this.f201758r;
        if (r103 == null) goto L27;
        Activity r104 = r103.f532368a;
        if (r104 == null) goto L26;
        r104.getApplication().unregisterActivityLifecycleCallbacks(r103);
    L26:
        this.f201758r = null;
    L27:
        DialogInterface.OnDismissListener r105 = this.f201757q;
        if (r105 == null) goto L30;
        r105.onDismiss(this);
    L30:
        c0 r106 = c0.a.f532328a;
        c0.b r107 = r106.f532327b;
        if (r107 == null) goto L33;
        Message r108 = r107.obtainMessage(1, this);
        r106.f532327b.sendMessageDelayed(r108, 10000);
    L33:
        f r109 = this.f201755o;
        if (r109 == null) goto L39;
        if (this.f201750j == true) goto L39;
        r109.onFail(3, null);
        this.f201755o = null;
    L39:
        if (this.f201751k == true) goto L50;
        String r110 = this.f201759s.getName();
        JSONObject r111 = new JSONObject();
        r111.put("style", r110);     // Catch: JSONException -> L43
    L45:
        String r112 = ac4.c.b("bytedcert.goToClose", r111, "bytedcert.goToClose");
        ac4.b r113 = this.f201741a;
        if (r113 != null) goto L48;
        int r114 = n.f532367a;
        goto L50
    L48:
        r113.a(r112);
    L43:
        e = move-exception;
        e.printStackTrace();
    L50:
        if (this.f201750j == true) goto L52;
        EventReport.G(this.f201759s, this.f201761u);
        o0();
    L52:
        c0.a.f532328a.c(3, null);
    }

    @Override // qb4.t
    public final void n1() {
        f r100 = this.f201755o;
        if (r100 == null) goto L5;
        r100.onFail(1001, null);
        this.f201755o = null;
    L5:
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r102 == null) goto L19;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r101.getLooper()) goto L10;
        r101.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        this.f201762v = System.currentTimeMillis();
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void b(c r100) {
        if (r100.f201761u.f498092c == false) goto L6;
        r100.f201742b.clearAnimation();
        r100.f201742b.setVisibility(8);
    L6:
        if (r100.f201761u.f498091b == false) goto L9;
        r100.f201749i.setBackgroundColor(-2013265920);
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(LayoutInflater.from(this.f201748h).inflate(R.layout.layout_verify_dialog, null));
        WindowManager.LayoutParams r101 = getWindow().getAttributes();
        r101.width = -1;
        r101.height = -1;
        getWindow().setAttributes(r101);
        this.f201745e = (ViewGroup) findViewById(R.id.view_feedback);
        TextView r102 = (TextView) findViewById(R.id.text_feedback_content);
        this.f201746f = (Button) findViewById(R.id.btn_feedback);
        this.f201747g = (Button) findViewById(R.id.btn_feedback_close);
        this.f201742b = (ImageView) findViewById(R.id.loading);
        this.f201743c = (VerifyWebView) findViewById(R.id.verify_webview);
        this.f201744d = (CardView) findViewById(R.id.web_container);
        this.f201749i = (FrameLayout) findViewById(R.id.dialog_framelayout);
        com.bytedance.bdturing.b r103 = new com.bytedance.bdturing.b(this);
        this.f201746f.setOnClickListener(r103);
        this.f201747g.setOnClickListener(r103);
        this.f201743c.c(this.f201764x);
        p r104 = new p(this.f201761u.c());
        this.f201756p = r104;
        this.f201743c.setOnTouchListener(r104);
        if (this.f201761u.f498092c == false) goto L5;
        RotateAnimation r105 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r105.setDuration(1000);
        r105.setRepeatCount(-1);
        r105.setInterpolator(new LinearInterpolator());
        this.f201742b.startAnimation(r105);
        this.f201749i.setBackgroundColor(-2013265920);
    L7:
        if (this.f201761u.getActivity() == null) goto L9;
        this.f201761u.getActivity().registerComponentCallbacks(this.f201765y);
        EventReport.K(hc4.f.g(this.f201761u.getActivity()), this.f201761u);
    L9:
        o r106 = this.f201758r;
        Activity r107 = r106.f532368a;
        if (r107 == null) goto L12;
        r107.getApplication().registerActivityLifecycleCallbacks(r106);
    L12:
        this.f201761u.getClass();
        setCanceledOnTouchOutside(false);
        e r108 = e.f202077a;
        setCancelable(e.i());
        this.f201741a = new ac4.b(this.f201763w, this.f201743c);
        String r109 = this.f201754n;
        int r110 = n.f532367a;
        this.f201743c.loadUrl(r109);
        if (this.f201761u.d() == false) goto L16;
        Resources r111 = this.f201748h.getResources();
        DisplayMetrics r112 = WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics());
        ViewGroup.LayoutParams r113 = this.f201743c.getLayoutParams();
        r113.width = r112.widthPixels;
        r113.height = r112.heightPixels;
        this.f201743c.setLayoutParams(r113);
        this.f201743c.setVisibility(0);
        return;
    L16:
        return;
    L5:
        this.f201742b.setVisibility(8);
        goto L7
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r100) {
        this.f201756p.a(r100);
        this.f201761u.getClass();
        return super.onTouchEvent(r100);
    }

    @Override // android.app.Dialog
    public final void setOnDismissListener(DialogInterface.OnDismissListener r100) {
        this.f201757q = r100;
    }

    public c(jc4.a r100, f r101) {
        super(r100.getActivity(), R.style.VerifyDialogTheme);
        this.f201750j = false;
        this.f201751k = false;
        this.f201752l = false;
        this.f201753m = false;
        this.f201756p = null;
        this.f201759s = EventReport.CloseType.CLOSE_REASON_APP;
        this.f201763w = new b(this);
        this.f201764x = new C2907c(this);
        this.f201765y = new d(this);
        this.f201761u = r100;
        this.f201760t = r100.getType();
        this.f201754n = r100.f();
        this.f201755o = r101;
        this.f201758r = new o(r100.getActivity());
        this.f201748h = r100.getActivity();
        setOnKeyListener(new com.bytedance.bdturing.d(this));
    }
}
