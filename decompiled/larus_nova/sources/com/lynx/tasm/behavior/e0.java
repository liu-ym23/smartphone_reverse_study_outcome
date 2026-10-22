package com.lynx.tasm.behavior;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;
import com.lynx.tasm.behavior.ui.scroll.UIScrollView;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<UIBody> f382006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f382007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f382008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f382009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewTreeObserver f382010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f382011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f382012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f382013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f382014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f382015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Handler f382016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f382017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RectF f382018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f382019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f382020o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int[] f382021p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f382022q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f382023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f382024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int[] f382025t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f382026u;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f382027a;

        public final void a() {
            TraceEvent.beginSection("ObserverManager.ObserverHandler");
            this.f382027a.i();     // Catch: Throwable -> L5
        L7:
            TraceEvent.endSection("ObserverManager.ObserverHandler");
            return;
        L5:
            th = move-exception;
            LLog.e(this.f382027a.f382026u, "observerManager.intersectionObserverHandler failed: " + th.toString());
            goto L7
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

        public a(e0 r100) {
            this.f382027a = r100;
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f382028a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.f382028a.k();
        }

        public b(e0 r100) {
            this.f382028a = r100;
        }
    }

    public class c implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f382029a;

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            this.f382029a.k();
        }

        public c(e0 r100) {
            this.f382029a = r100;
        }
    }

    public class d implements ViewTreeObserver.OnDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f382030a;

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            this.f382030a.k();
        }

        public d(e0 r100) {
            this.f382030a = r100;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f382031a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f382031a.h();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(e0 r100) {
            this.f382031a = r100;
        }
    }

    public static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<e0> f382032a;

        public final void a() {
            e0 r100 = this.f382032a.get();
            if (r100 == null) goto L25;
            long r101 = r100.f382019n;
            if (r101 == 0) goto L12;
            Handler r102 = r100.f382016k;
            if (r102 == null) goto L12;
            f r103 = r100.f382017l;
            if (r103 == null) goto L12;
            r102.postDelayed(r103, r101);
        L12:
            if (r100.f382006a.get() != null) goto L14;
            return;
        L14:
            if (r100.f382011f == false) goto L27;
            RectF r104 = r100.d(r100.f382006a.get());
            if (r104.equals(r100.f382018m) == true) goto L23;
            Handler r105 = r100.f382014i;
            if (r105 == null) goto L23;
            e r106 = r100.f382015j;
            if (r106 == null) goto L23;
            r105.post(r106);
        L23:
            r100.f382018m = r104;
            return;
        L27:
            return;
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

        public f(e0 r100) {
            this.f382032a = new WeakReference(r100);
        }
    }

    public void i() {
    }

    public final void b() {
        LLog.i(this.f382026u, "addToObserverTree");
        UIBody r100 = this.f382006a.get();
        if (r100 == null) goto L5;
        LynxContext r101 = r100.getLynxContext();
    L6:
        if (r101 == null) goto L11;
        int r102 = r101.getObserverFrameRate();
        if (r102 <= 0) goto L10;
        this.f382012g = Math.max(16, 1000 / r102);
    L10:
        this.f382022q = r101.getEnableDisexposureWhenLynxHidden();
        this.f382023r = r101.getEnableExposureWhenLayout();
    L11:
        j();
        if (this.f382014i != null) goto L15;
        this.f382014i = new Handler(Looper.getMainLooper());
    L15:
        if (this.f382015j != null) goto L17;
        this.f382015j = new e(this);
    L17:
        this.f382014i.post(this.f382015j);
        if (this.f382016k != null) goto L21;
        this.f382016k = new Handler(Looper.getMainLooper());
    L21:
        if (this.f382017l != null) goto L23;
        this.f382017l = new f(this);
    L23:
        this.f382016k.postDelayed(this.f382017l, this.f382019n);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void c() {
        LLog.i(this.f382026u, MapMonitorConst.EVENT_DESTROY);
        Handler r100 = this.f382014i;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
        this.f382014i = null;
    L5:
        Handler r101 = this.f382016k;
        if (r101 == null) goto L8;
        r101.removeCallbacksAndMessages(null);
        this.f382016k = null;
    L8:
        ViewTreeObserver r102 = this.f382010e;
        if (r102 != null) goto L11;
    L12:
        UIBody.UIBodyView r103 = f();
        if (r103 != null) goto L15;
        LLog.e(this.f382026u, "LynxObserver getViewTreeObserver failed since rootView is null");
        ViewTreeObserver r104 = null;
    L16:
        this.f382010e = r104;
    L17:
        ViewTreeObserver r105 = this.f382010e;
        if (r105 != null) goto L21;
        LLog.e(this.f382026u, "LynxObserverManager remove listeners failed since observer is null");
        return;
    L21:
        r105.removeOnGlobalLayoutListener(this.f382007b);
        this.f382010e.removeOnScrollChangedListener(this.f382008c);
        this.f382010e.removeOnDrawListener(this.f382009d);
        this.f382010e = null;
        this.f382007b = null;
        this.f382008c = null;
        this.f382009d = null;
        return;
    L15:
        r104 = r103.getViewTreeObserver();
        goto L16
    L11:
        if (r102.isAlive() == true) goto L17;
        goto L12
    }

    public final UIBody.UIBodyView f() {
        UIBody r100 = this.f382006a.get();
        if (r100 != null) goto L7;
        LLog.e(this.f382026u, "LynxObserver getRootView failed since rootUI is null");
        return null;
    L7:
        return r100.getBodyView();
    }

    public final void h() {
        if (this.f382011f == true) goto L7;
        LLog.e(this.f382026u, "Lynx observerHandler failed since rootView not draw");
        return;
    L7:
        if (this.f382020o == false) goto L10;
        LLog.w(this.f382026u, "Lynx observerHandler failed since inner function is delayed");
        return;
    L10:
        UIThreadUtils.runOnUiThreadImmediately(new a(this));
    }

    public final void k() {
        if (this.f382014i != null) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis() - this.f382013h;
        long r101 = this.f382012g;
        if (r100 <= r101) goto L9;
        this.f382013h = System.currentTimeMillis();
        this.f382014i.post(this.f382015j);
        this.f382024s = false;
        return;
    L9:
        if (this.f382024s == false) goto L11;
        return;
    L11:
        this.f382014i.postDelayed(this.f382015j, r101);
        this.f382024s = true;
    }

    public final void j() {
        UIBody.UIBodyView r100 = f();
        if (r100 != null) goto L5;
        LLog.e(this.f382026u, "LynxObserver getViewTreeObserver failed since rootView is null");
        ViewTreeObserver r101 = null;
    L6:
        if (r101 != null) goto L10;
        LLog.e(this.f382026u, "LynxObserverManager add listeners failed since observer is null");
        return;
    L10:
        if (this.f382007b != null) goto L13;
        this.f382007b = new b(this);
    L13:
        if (this.f382008c != null) goto L16;
        this.f382008c = new c(this);
    L16:
        if (this.f382009d != null) goto L19;
        this.f382009d = new d(this);
    L19:
        if (r101 == this.f382010e) goto L22;
        this.f382010e = r101;
        r101.addOnGlobalLayoutListener(this.f382007b);
        this.f382010e.addOnScrollChangedListener(this.f382008c);
        this.f382010e.addOnDrawListener(this.f382009d);
        return;
    L22:
        return;
    L5:
        r101 = r100.getViewTreeObserver();
        goto L6
    }

    public e0(String r100) {
        this.f382018m = null;
        this.f382023r = false;
        this.f382024s = false;
        this.f382006a = null;
        this.f382011f = false;
        this.f382012g = 50;
        this.f382019n = 50;
        this.f382013h = 0;
        this.f382014i = null;
        this.f382015j = null;
        this.f382020o = false;
        this.f382021p = new int[2];
        this.f382025t = new int[2];
        this.f382022q = true;
        this.f382026u = r100;
    }

    public final RectF d(LynxBaseUI r100) {
        RectF r101 = new RectF();
        if (r100 != null) goto L7;
        LLog.e(this.f382026u, "LynxObserverManager getBoundsOnScreenOfLynxBaseUI failed since ui is null");
        return r101;
    L7:
        if (LynxEnv.inst().enableTransformForPositionCalculation() == false) goto L11;
        RectF r102 = com.lynx.tasm.behavior.ui.utils.h.f(r100, new RectF(0.0f, 0.0f, r100.getWidth(), r100.getHeight()));
        r101.set(r102.left, r102.top, r102.right, r102.bottom);
        return r101;
    L11:
        if ((r100 instanceof LynxUI) == false) goto L14;
        e(((LynxUI) r100).getView(), r101);
        float r103 = r101.left;
        r101.set(r103, r101.top, r100.getWidth() + r103, r101.top + r100.getHeight());
    L26:
        return r101;
    L14:
        if ((r100 instanceof LynxFlattenUI) == false) goto L26;
        LynxBaseUI r104 = r100.getParentBaseUI();
    L16:
        if (r104 == null) goto L20;
        if ((r104 instanceof LynxUI) == true) goto L20;
        r104 = r104.getParentBaseUI();
    L20:
        if (r104 == null) goto L26;
        View r105 = ((LynxUI) r104).getView();
        e(r105, r101);
        if ((r104 instanceof UIScrollView) == false) goto L24;
        AndroidScrollView r106 = (AndroidScrollView) r105;
        r101.offset(-r106.getRealScrollX(), -r106.getRealScrollY());
    L25:
        r101.offset(r100.getLeft(), r100.getTop());
        float r107 = r101.left;
        r101.set(r107, r101.top, r100.getWidth() + r107, r101.top + r100.getHeight());
        goto L26
    L24:
        r101.offset(-r105.getScrollX(), -r105.getScrollY());
        goto L25
    }

    public final RectF g(LynxContext r100) {
        if (r100 == null) goto L15;
        Activity r101 = r100.getActivity();
        int[] r102 = new int[2];
        if (r101 == null) goto L13;
        Window r103 = r101.getWindow();
        if (r103 == null) goto L13;
        View r104 = r103.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L12;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L12;
        com.larus.home.impl.utils.c.a(r105, "getDecorView");
    L12:
        r104.getLocationOnScreen(r102);
    L13:
        int r106 = r102[0];
        int r107 = r102[1];
        int[] r108 = this.f382025t;
        return new RectF(r106, r107, r106 + r108[0], r107 + r108[1]);
    L15:
        LLog.e(this.f382026u, "getWindowRect func failed since context is null");
        return new RectF();
    }

    public final void l(LynxContext r100) {
        DisplayMetrics r101 = DisplayMetricsHolder.getRealScreenDisplayMetrics(r100);
        int[] r102 = this.f382025t;
        r102[0] = r101.widthPixels;
        r102[1] = r101.heightPixels;
    }

    public final void e(View r100, RectF r101) {
        if (r100 != null) goto L5;
        LLog.e(this.f382026u, "LynxObserverManager getLeftAndTopOfBoundsInScreen failed since view is null");
        return;
    L5:
        r100.getLocationOnScreen(this.f382021p);
        int[] r102 = this.f382021p;
        r101.offset(r102[0], r102[1]);
    }
}
