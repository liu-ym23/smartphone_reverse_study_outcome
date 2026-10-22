package com.lynx.tasm.behavior;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class n {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final WeakHashMap<View, g> f382111n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxContext f382112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f382113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f382114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f382115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q f382116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f382117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f382118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f382119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f382120i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f382121j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WeakHashMap<Object, ViewTreeObserver.OnGlobalLayoutListener> f382122k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final WeakHashMap<Object, f> f382123l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f382124m;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f382125a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f382125a.e();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(n r100) {
            this.f382125a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f382126a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f382126a.f382116e.d().requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(n r100) {
            this.f382126a = r100;
        }
    }

    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f382127a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            LLog.d("Lynx", "onGlobalLayout invoked.");
            this.f382127a.b();
        }

        public c(n r100) {
            this.f382127a = r100;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Object> f382128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<View> f382129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference<View> f382130c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f382131d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f382132e;

        public final boolean a() {
            if (this.f382128a.get() != null) goto L5;
        L9:
            return false;
        L5:
            if (this.f382129b.get() == null) goto L9;
            if (this.f382130c.get() == null) goto L9;
            return true;
        }

        public final boolean b(Object r100) {
            if (r100 != null) goto L4;
        L6:
            return false;
        L4:
            if (this.f382128a.get() != r100) goto L6;
            return true;
        }

        public d(Object r100, View r101, LynxView r102, boolean r103, float r104) {
            this.f382128a = new WeakReference(r100);
            this.f382129b = new WeakReference(r101);
            this.f382130c = new WeakReference(r102);
            this.f382131d = r103;
            this.f382132e = r104;
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakHashMap<View, d> f382133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<d> f382134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference<Object> f382135c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public WeakReference<View> f382136d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f382137e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f382138f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public g f382139g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public p f382140h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f382141i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f382142j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f382143k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f382144l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f382145m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f382146n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f382147o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public WeakReference<d> f382148p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Runnable f382149q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public View f382150r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ n f382151s;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f382152a;

            @Override // java.lang.Runnable
            public final void run() {
                e r100 = this.f382152a;     // Catch: Throwable -> L4
                r100.f382149q = null;     // Catch: Throwable -> L4
                r100.f382150r = null;     // Catch: Throwable -> L4
                r100.n();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(e r100) {
                this.f382152a = r100;
            }
        }

        public final void e() {
            d r100 = this.f382148p.get();
            if (r100 != null) goto L5;
        L7:
            int r101 = this.f382146n;
            if (r101 != 1) goto L13;
            if (r100 == null) goto L11;
            q(r100);
        L11:
            this.f382141i = this.f382147o;
            v(false);
            return;
        L13:
            if (r101 != 2) goto L20;
            this.f382141i = 0;
            if (r100 == null) goto L17;
            q(r100);
            v(false);
            return;
        L17:
            q(null);
            l(false);
            return;
        L20:
            return;
        L5:
            if (r100.a() == true) goto L7;
            r100 = null;
            goto L7
        }

        public final void g() {
            Runnable r100 = this.f382149q;
            if (r100 == null) goto L7;
            View r101 = this.f382150r;
            if (r101 == null) goto L7;
            r101.removeCallbacks(r100);
        L7:
            this.f382149q = null;
            this.f382150r = null;
        }

        public final d j() {
            d r100 = this.f382134b.get();
            if (r100 != null) goto L5;
        L7:
            return null;
        L5:
            if (r100.a() == false) goto L7;
            return r100;
        }

        public final View m() {
            View r100 = this.f382137e;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Activity r101 = com.lynx.tasm.utils.a.getActivity(this.f382151s.f382112a);
            if (r101 != null) goto L8;
            return null;
        L8:
            if (r101.getWindow() != null) goto L11;
            return null;
        L11:
            return a(r101.getWindow());
        }

        public final void n() {
            if (this.f382146n == 0) goto L5;
            boolean r100 = false;
            if (this.f382143k == true) goto L20;
            e();
            this.f382146n = 0;
            this.f382147o = 0;
            this.f382148p = new WeakReference(null);
            return;
        L20:
            if (Build.VERSION.SDK_INT < 30) goto L28;
            View r101 = this.f382138f;
            if (r101 == null) goto L28;
            WindowInsets r102 = r101.getRootWindowInsets();
            if (r102 == null) goto L28;
            d(r102);
            r100 = true;
        L28:
            if (r100 == true) goto L30;
            e();
        L30:
            h();
            return;
        L5:
            if (this.f382143k == true) goto L7;
            return;
        L7:
            if (Build.VERSION.SDK_INT < 30) goto L15;
            View r103 = this.f382138f;
            if (r103 == null) goto L15;
            WindowInsets r104 = r103.getRootWindowInsets();
            if (r104 == null) goto L15;
            d(r104);
        L15:
            h();
        }

        public final void t() {
            View r100 = this.f382137e;
            if (r100 != null) goto L5;
        L14:
            this.f382137e = null;
            this.f382140h = null;
            return;
        L5:
            if (this.f382140h == null) goto L14;
            ViewTreeObserver r101 = r100.getViewTreeObserver();     // Catch: Exception -> L12
            if (r101 == null) goto L14;
            if (r101.isAlive() == false) goto L14;
            r101.removeOnGlobalFocusChangeListener(this.f382140h);     // Catch: Exception -> L12
        L12:
            e = move-exception;
            LLog.w("Lynx", "stop KeyboardAvoidingContext failed for " + e.toString());
            goto L14
        }

        public final void u() {
            int r100 = Build.VERSION.SDK_INT;
            if (r100 < 30) goto L12;
            g r101 = this.f382139g;
            if (r101 == null) goto L12;
            r101.f382154b.remove(this);
            if (r101.f382154b.isEmpty() == false) goto L12;
            if (r100 < 30) goto L11;
            r101.f382153a.setWindowInsetsAnimationCallback(null);
        L11:
            n.f382111n.remove(r101.f382153a);
        L12:
            this.f382138f = null;
            this.f382139g = null;
            h();
        }

        public final void h() {
            g();
            this.f382146n = 0;
            this.f382147o = 0;
            this.f382148p = new WeakReference(null);
            this.f382143k = false;
            this.f382144l = 0;
            this.f382145m = 0.0f;
        }

        public final void s() {
            g();
            this.f382146n = 0;
            this.f382147o = 0;
            this.f382148p = new WeakReference(null);
            if (this.f382143k == true) goto L17;
            boolean r100 = true;
            if (Build.VERSION.SDK_INT >= 30) goto L7;
        L9:
            boolean r101 = false;
        L10:
            if (r101 == true) goto L12;
        L14:
            boolean r102 = false;
        L15:
            if (r102 == true) goto L17;
        L18:
            l(r100);
            t();
            u();
            this.f382133a.clear();
            this.f382134b = new WeakReference(null);
            this.f382135c = new WeakReference(null);
            this.f382136d = new WeakReference(null);
            this.f382141i = 0;
            return;
        L12:
            if (this.f382146n == 0) goto L14;
            r102 = true;
            goto L15
        L7:
            if (this.f382139g == null) goto L9;
            r101 = true;
        L17:
            r100 = false;
            goto L18
        }

        public e(n r100) {
            this.f382151s = r100;
            this.f382133a = new WeakHashMap();
            this.f382134b = new WeakReference(null);
            this.f382135c = new WeakReference(null);
            this.f382136d = new WeakReference(null);
            this.f382141i = 0;
            this.f382142j = 0.0f;
            this.f382143k = false;
            this.f382144l = 0;
            this.f382145m = 0.0f;
            this.f382146n = 0;
            this.f382147o = 0;
            this.f382148p = new WeakReference(null);
        }

        public static View a(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        public static long k(WindowInsetsAnimation r100) {
            if (Build.VERSION.SDK_INT < 30) goto L8;
            if (r100 == null) goto L8;
            if (r100.getDurationMillis() < 0) goto L8;
            long r101 = r100.getDurationMillis();
        L10:
            return r101 + 80;
        L8:
            r101 = 285;
            goto L10
        }

        public final void b(d r100) {
            if (r100.a() == false) goto L26;
            q(r100);
            r(r100.f382128a.get());
            boolean r101 = true;
            if (this.f382146n != 1) goto L9;
            this.f382148p = new WeakReference(r100);
        L9:
            if (this.f382143k == false) goto L11;
        L23:
            r101 = false;
        L24:
            v(r101);
            return;
        L11:
            if (Build.VERSION.SDK_INT >= 30) goto L13;
        L15:
            boolean r102 = false;
        L16:
            if (r102 == true) goto L18;
        L20:
            boolean r103 = false;
        L21:
            if (r103 == true) goto L23;
        L18:
            if (this.f382146n == 0) goto L20;
            r103 = true;
            goto L21
        L13:
            if (this.f382139g == null) goto L15;
            r102 = true;
            goto L16
        }

        public final boolean d(WindowInsets r100) {
            int r101 = Build.VERSION.SDK_INT;
            if (r101 < 30) goto L26;
            if (r100 == null) goto L26;
            if (r101 < 30) goto L8;
            int r102 = Math.max(0, r100.getInsets(WindowInsets.Type.ime()).bottom - r100.getInsets(WindowInsets.Type.navigationBars()).bottom);
        L9:
            d r103 = j();
            if (r103 != null) goto L12;
        L16:
            View r104 = this.f382136d.get();
            if (r104 != null) goto L19;
            this.f382141i = r102;
        L25:
            return true;
        L19:
            int r105 = this.f382144l;
            if (r105 <= 0) goto L23;
            if (r102 <= 0) goto L23;
            float r106 = (this.f382145m * r102) / r105;
        L24:
            this.f382141i = r102;
            c(r104, r106, false);
        L23:
            r106 = 0.0f;
            goto L24
        L12:
            if (r103.a() == false) goto L16;
            this.f382141i = r102;
            c(r103.f382130c.get(), f(r103, r102, r100), false);
            return true;
        L8:
            r102 = 0;
        L26:
            return false;
        }

        public final d i(View r100) {
        L3:
            if (r100 == null) goto L13;
            d r101 = this.f382133a.get(r100);
            if (r101 != null) goto L7;
        L9:
            Object r102 = r100.getParent();
            if ((r102 instanceof View) == true) goto L11;
            r100 = null;
            goto L3
        L11:
            r100 = (View) r102;
            goto L3
        L7:
            if (r101.a() == false) goto L9;
            return r101;
        L13:
            return null;
        }

        public final void l(boolean r100) {
            d r101 = j();
            if (r101 == null) goto L5;
            View r102 = r101.f382130c.get();
        L6:
            if (r102 != null) goto L9;
            r102 = this.f382136d.get();
        L9:
            if (r102 == null) goto L11;
        L12:
            c(r102, 0.0f, r100);
            return;
        L11:
            if (this.f382142j != 0.0f) goto L12;
            return;
        L5:
            r102 = null;
            goto L6
        }

        public final void p(long r100) {
            g();
            if (this.f382146n == 0) goto L5;
        L7:
            View r101 = this.f382138f;
            if (r101 != null) goto L10;
            r101 = m();
        L10:
            if (r101 != null) goto L13;
            n();
            return;
        L13:
            this.f382150r = r101;
            a r102 = new a(this);
            this.f382149q = r102;
            r101.postDelayed(r102, r100);
            return;
        L5:
            if (this.f382143k == true) goto L7;
        }

        public final void q(d r100) {
            this.f382134b = new WeakReference(r100);
        }

        public final void r(Object r100) {
            if (r100 == null) goto L5;
            this.f382135c = new WeakReference(r100);
            return;
        }

        public final void v(boolean r100) {
            d r101 = j();
            if (r101 != null) goto L5;
        L9:
            q(null);
            l(r100);
            return;
        L5:
            if (r101.a() == false) goto L9;
            c(r101.f382130c.get(), f(r101, this.f382141i, null), r100);
        }

        public final void c(View r100, float r101, boolean r102) {
            float r103 = Math.max(0.0f, r101);
            if (r100 != null) goto L6;
            this.f382142j = r103;
            return;
        L6:
            this.f382136d = new WeakReference(r100);
            this.f382142j = r103;
            r100.animate().cancel();
            if (r102 == false) goto L9;
            r100.animate().translationY(-r103).setDuration(285).setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f)).start();
            return;
        L9:
            r100.setTranslationY(-r103);
        }

        public final float f(d r210, int r211, WindowInsets r212) {
            if (r210.f382131d == true) goto L5;
            return 0.0f;
        L5:
            View r100 = r210.f382129b.get();
            View r101 = r210.f382130c.get();
            Activity r102 = com.lynx.tasm.utils.a.getActivity(this.f382151s.f382112a);
            if (r100 == null) goto L83;
            if (r101 == null) goto L86;
            if (r102 == null) goto L87;
            View r103 = a(r102.getWindow());
            if (r103 != null) goto L13;
            return 0.0f;
        L13:
            if (r103.getHeight() <= 0) goto L85;
            int r104 = Build.VERSION.SDK_INT;
            if (r104 >= 24) goto L18;
        L20:
            boolean r105 = false;
        L21:
            View r106 = r210.f382129b.get();
            View r110 = r210.f382130c.get();
            if (r106 == null) goto L68;
            if (r110 == null) goto L68;
            if (r103.getHeight() <= 0) goto L68;
            if (r103.getHeight() > 0) goto L30;
            View r111 = r100;
            View r112 = r101;
        L64:
            int r113 = -1;
        L65:
            if (r113 < 0) goto L69;
            int[] r107 = new int[2];
            int[] r108 = new int[2];
            r106.getLocationOnScreen(r107);
            r103.getLocationOnScreen(r108);
            float r109 = ((((r107[1] - r108[1]) + r106.getHeight()) - r110.getTranslationY()) - r113) + r210.f382132e;
            float r114 = 0.0f;
            float r115 = Math.max(0.0f, r109);
        L71:
            if (r115 < r114) goto L73;
            return r115;
        L73:
            if (r211 > 0) goto L75;
            return r114;
        L75:
            q r116 = this.f382151s.f382116e;
            if (r116 == null) goto L78;
            int r117 = r116.e();
            int r118 = 2;
            char r119 = 1;
        L79:
            int[] r120 = new int[r118];
            View r121 = r111;
            r121.getLocationOnScreen(r120);
            return Math.max(0.0f, (r211 - (r117 - ((r120[r119] + r121.getHeight()) - r112.getTranslationY()))) + r210.f382132e);
        L78:
            r118 = 2;
            int[] r122 = new int[2];
            r103.getLocationOnScreen(r122);
            r119 = 1;
            r117 = r122[1] + r103.getHeight();
        L69:
            r114 = 0.0f;
            r115 = -1.0f;
            goto L71
        L30:
            int r123 = r103.getHeight();
            int[] r124 = new int[2];
            r103.getLocationOnScreen(r124);
            if (r104 < 30) goto L45;
            if (r212 != null) goto L34;
            WindowInsets r125 = r103.getRootWindowInsets();
        L35:
            if (r125 == null) goto L45;
            int r126 = r125.getInsets(WindowInsets.Type.ime()).bottom;
            if (r126 <= 0) goto L39;
        L42:
            boolean r127 = true;
        L43:
            if (r127 == false) goto L46;
            int r128 = Math.max(0, Math.min(r123 - r126, r123));
        L47:
            Rect r129 = new Rect();
            r103.getWindowVisibleDisplayFrame(r129);
            r112 = r101;
            int r130 = r124[0];
            r111 = r100;
            if (r129.intersect(new Rect(r130, r124[1], r103.getWidth() + r130, r124[1] + r123)) == false) goto L56;
            int r131 = r129.bottom - r124[1];
            int r132 = r123 - r131;
            if (r132 <= 0) goto L56;
            if (r127 == true) goto L57;
            if (r211 <= 0) goto L56;
            if (r132 < (r211 * 0.5f)) goto L56;
        L57:
            if (r105 == false) goto L60;
            if (r131 < 0) goto L60;
        L63:
            r113 = r131;
        L60:
            if (r128 < 0) goto L62;
            r113 = r128;
            goto L65
        L62:
            if (r131 < 0) goto L64;
        L56:
            r131 = -1;
        L46:
            r128 = -1;
            goto L47
        L39:
            if (r125.isVisible(WindowInsets.Type.ime()) == true) goto L42;
            r127 = false;
            goto L43
        L34:
            r125 = r212;
        L45:
            r127 = false;
        L68:
            r111 = r100;
            r112 = r101;
            goto L69
        L18:
            if (r102.isInMultiWindowMode() == false) goto L20;
            r105 = true;
            goto L21
        L85:
            return 0.0f;
        L87:
            return 0.0f;
        L86:
            return 0.0f;
        L83:
            return 0.0f;
        }

        public final d o(Object r100, View r101, LynxView r110, boolean r111, float r112) {
            if (r100 == null) goto L20;
            if (r101 == null) goto L22;
            d r102 = new d(r100, r101, r110, r111, r112);
            this.f382133a.put(r101, r102);
            if (Build.VERSION.SDK_INT < 30) goto L19;
            View r103 = m();
            if (r103 == null) goto L19;
            if (this.f382138f == r103) goto L13;
        L15:
            u();
            this.f382138f = r103;
            WeakHashMap<View, g> r104 = n.f382111n;
            g r113 = r104.get(r103);
            if (r113 != null) goto L18;
            r113 = new g(r103);
            r104.put(r103, r113);
        L18:
            r113.f382154b.put(this, Boolean.TRUE);
            this.f382139g = r113;
            goto L19
        L13:
            if (this.f382139g == null) goto L15;
        L19:
            return r102;
        L22:
            return null;
        L20:
            return null;
        }
    }

    public interface f {
        void f();

        void g(int r100);
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f382153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakHashMap<e, Boolean> f382154b;

        public class a extends WindowInsetsAnimation.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f382155a;

            public a(g r100) {
                this.f382155a = r100;
                super(1);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final void onEnd(WindowInsetsAnimation r100) {
                if (g.b(r100) == false) goto L13;
                WindowInsets r101 = this.f382155a.f382153a.getRootWindowInsets();
                Iterator r102 = g.a(this.f382155a).iterator();
            L6:
                if (r102.hasNext() == false) goto L18;
                e r103 = (e) r102.next();
                if (r103.d(r101) == true) goto L12;
                if (r103.f382146n == 0) goto L12;
                r103.e();
            L12:
                r103.h();
                goto L6
            L18:
                return;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final void onPrepare(WindowInsetsAnimation r100) {
                if (g.b(r100) == false) goto L11;
                Iterator r101 = g.a(this.f382155a).iterator();
            L6:
                if (r101.hasNext() == false) goto L15;
                e r102 = (e) r101.next();
                if (r102.f382143k == true) goto L10;
                r102.f382144l = r102.f382141i;
                r102.f382145m = r102.f382142j;
            L10:
                r102.f382143k = true;
                r102.p(e.k(r100));
                goto L6
            L15:
                return;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final WindowInsets onProgress(WindowInsets r100, List<WindowInsetsAnimation> r101) {
                if (Build.VERSION.SDK_INT < 30) goto L12;
                if (r101 == null) goto L12;
                Iterator<WindowInsetsAnimation> r102 = r101.iterator();
            L8:
                if (r102.hasNext() == false) goto L12;
                if (g.b(r102.next()) == false) goto L8;
                boolean r103 = true;
            L13:
                if (r103 == false) goto L18;
                Iterator r104 = g.a(this.f382155a).iterator();
            L16:
                if (r104.hasNext() == false) goto L18;
                ((e) r104.next()).d(r100);
            L18:
                return r100;
            L12:
                r103 = false;
                goto L13
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation r100, WindowInsetsAnimation.Bounds r101) {
                if (g.b(r100) == false) goto L11;
                Iterator r102 = g.a(this.f382155a).iterator();
            L6:
                if (r102.hasNext() == false) goto L11;
                e r103 = (e) r102.next();
                if (r103.f382143k == true) goto L10;
                r103.f382144l = r103.f382141i;
                r103.f382145m = r103.f382142j;
            L10:
                r103.f382143k = true;
                r103.p(e.k(r100));
            L11:
                return r101;
            }
        }

        public g(View r100) {
            this.f382154b = new WeakHashMap();
            a r101 = new a(this);
            this.f382153a = r100;
            if (Build.VERSION.SDK_INT < 30) goto L6;
            r100.setWindowInsetsAnimationCallback(r101);
            return;
        }

        public static ArrayList a(g r100) {
            r100.getClass();
            return new ArrayList(r100.f382154b.keySet());
        }

        public static boolean b(WindowInsetsAnimation r100) {
            if (Build.VERSION.SDK_INT < 30) goto L8;
            if (r100 == null) goto L8;
            if ((r100.getTypeMask() & WindowInsets.Type.ime()) == 0) goto L8;
            return true;
        L8:
            return false;
        }
    }

    public final synchronized void d() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f382115d == false) goto L9;
        LLog.d("Lynx", "KeyboardEvent already started");     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L9:
        if (UIThreadUtils.isOnUiThread() == true) goto L11;
        UIThreadUtils.runOnUiThread(new a(this));     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L11:
        e();     // Catch: Throwable -> L14
        goto L12
    }

    static {
        f382111n = new WeakHashMap();
    }

    public final void b() {
        Activity r100 = com.lynx.tasm.utils.a.getActivity(this.f382112a);     // Catch: Exception -> L47
        if (r100 != null) goto L7;
        LLog.e("Lynx", "KeyboardEvent's context must be Activity.");     // Catch: Exception -> L47
        return;
    L7:
        LynxContext r101 = this.f382112a;     // Catch: Exception -> L47
        View r102 = a(r100.getWindow());     // Catch: Exception -> L47
        boolean r103 = r101.useRelativeKeyboardHeightApi();     // Catch: Exception -> L47
        if (r101.getUIBody() != null) goto L10;
        return;
    L10:
        WeakReference r104 = new WeakReference(r101.getUIBody().getBodyView());     // Catch: Exception -> L47
        this.f382116e.d().getWindowVisibleDisplayFrame(this.f382119h);     // Catch: Exception -> L47
        int r105 = this.f382116e.d().getHeight() + this.f382119h.top;     // Catch: Exception -> L47
        int r106 = this.f382116e.d().getHeight();     // Catch: Exception -> L47
        if (this.f382118g != 0) goto L13;
        this.f382118g = r102.getHeight();     // Catch: Exception -> L47
    L13:
        this.f382117f = this.f382116e.e() - this.f382119h.top;     // Catch: Exception -> L47
        int r107 = r100.getWindow().getWindowManager().getDefaultDisplay().getRotation();     // Catch: Exception -> L47
        int r108 = this.f382118g;     // Catch: Exception -> L47
        int r109 = this.f382117f;     // Catch: Exception -> L47
        double r110 = ((double) r106) / ((double) r109);     // Catch: Exception -> L47
        if (r107 == 0) goto L17;
        if (r107 == 2) goto L17;
    L20:
        int r111 = 0;
        if (r110 >= 0.9d) goto L23;
        boolean r112 = true;
    L24:
        UIBody.UIBodyView r113 = (UIBody.UIBodyView) r104.get();     // Catch: Exception -> L47
        if (r112 == false) goto L27;
        int r114 = (int) ((r108 - r106) / this.f382114c);     // Catch: Exception -> L47
    L28:
        if (r103 == false) goto L31;
        if (r113 == null) goto L31;
        int[] r115 = new int[2];     // Catch: Exception -> L47
        r113.getLocationOnScreen(r115);     // Catch: Exception -> L47
        float r116 = (r115[1] + r113.getHeight()) - r105;     // Catch: Exception -> L47
        float r117 = this.f382114c;     // Catch: Exception -> L47
    L33:
        r111 = (int) (r116 / r117);     // Catch: Exception -> L47
    L34:
        LLog.d("Lynx", "KeyboardEvent visible = " + r112 + ", height = " + r114 + ", compatHeight = " + r111);     // Catch: Exception -> L47
        if (r114 != this.f382120i) goto L39;
        if (r103 == true) goto L38;
    L40:
        Iterator<Map.Entry<Object, ViewTreeObserver.OnGlobalLayoutListener>> r118 = this.f382122k.entrySet().iterator();     // Catch: Exception -> L47
    L42:
        if (r118.hasNext() == false) goto L56;
        Map.Entry<Object, ViewTreeObserver.OnGlobalLayoutListener> r119 = r118.next();     // Catch: Exception -> L47
        if (r119.getKey() == null) goto L42;
        r119.getValue().onGlobalLayout();     // Catch: Exception -> L47
        goto L42
    L56:
        return;
    L38:
        if (r111 == this.f382121j) goto L40;
    L39:
        c(r112, r111);     // Catch: Exception -> L47
        this.f382120i = r114;     // Catch: Exception -> L47
        this.f382121j = r111;     // Catch: Exception -> L47
    L31:
        if (r112 == false) goto L34;
        r116 = r109 - r106;     // Catch: Exception -> L47
        r117 = this.f382114c;     // Catch: Exception -> L47
        goto L33
    L27:
        r114 = 0;
        goto L28
    L23:
        r112 = false;
    L17:
        if (r110 >= 0.4d) goto L20;
        UIThreadUtils.runOnUiThread(new b(this));     // Catch: Exception -> L47
        return;
    L47:
        e = move-exception;
        LLog.e("Lynx", e.getMessage());
    }

    public final void e() {
        LLog.d("Lynx", "KeyboardEvent starting");
        Activity r100 = com.lynx.tasm.utils.a.getActivity(this.f382112a);
        if (r100 != null) goto L7;
        LLog.e("Lynx", "KeyboardEvent's context must be Activity");
        return;
    L7:
        if (this.f382116e != null) goto L9;
        this.f382116e = new q(r100);
    L9:
        e r101 = this.f382124m;
        View r102 = a(r100.getWindow());
        if (r102 != null) goto L13;
        r101.getClass();
    L18:
        c r103 = new c(this);
        this.f382113b = r103;
        q.a(this.f382116e.getWindow()).getViewTreeObserver().addOnGlobalLayoutListener(r103);
        this.f382116e.f();
        this.f382115d = true;
        return;
    L13:
        if (r101.f382137e == r102) goto L15;
    L17:
        r101.t();
        r101.f382137e = r102;
        r101.f382140h = new p(r101);
        r102.getViewTreeObserver().addOnGlobalFocusChangeListener(r101.f382140h);
        goto L18
    L15:
        if (r101.f382140h == null) goto L17;
        goto L17
    }

    public final void f() {
        LLog.d("Lynx", "KeyboardEvent stopping");
        c r100 = this.f382113b;     // Catch: Exception -> L17
        if (r100 == null) goto L15;
        q r101 = this.f382116e;     // Catch: Exception -> L17
        if (r101 == null) goto L15;
        q.a(r101.getWindow()).getViewTreeObserver().removeOnGlobalLayoutListener(r100);     // Catch: Exception -> L17
        q r102 = this.f382116e;     // Catch: Exception -> L17
        String r103 = q.f382168a;     // Catch: Exception -> L17
        if (r102.isShowing() == false) goto L15;
        q.b(r102);     // Catch: RuntimeException -> L11 WindowManager.BadTokenException -> L13 Exception -> L17
    L13:
        e = move-exception;
        LLog.w(r103, e.toString());     // Catch: Exception -> L17
    L11:
        e = move-exception;
        LLog.w(r103, e.toString());     // Catch: Exception -> L17
    L15:
        this.f382124m.s();     // Catch: Exception -> L17
    L19:
        this.f382115d = false;
        return;
    L17:
        e = move-exception;
        LLog.w("Lynx", "stop KeyboardEvent failed for " + e.toString());
        goto L19
    }

    public n(LynxContext r100) {
        this.f382113b = null;
        this.f382115d = false;
        this.f382117f = 0;
        this.f382118g = 0;
        this.f382120i = 0;
        this.f382121j = 0;
        this.f382122k = new WeakHashMap();
        this.f382123l = new WeakHashMap();
        this.f382124m = new e(this);
        LLog.d("Lynx", "KeyboardEvent initialized.");
        this.f382112a = r100;
        this.f382114c = r100.getScreenMetrics().density;
        this.f382119h = new Rect();
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void c(boolean r100, int r101) {
        if (this.f382112a.getEventEmitter() == null) goto L9;
        JavaOnlyArray r102 = new JavaOnlyArray();
        if (r100 == false) goto L7;
        String r103 = "on";
    L8:
        r102.pushString(r103);
        r102.pushInt(r101);
        r102.pushInt(r101);
        this.f382112a.sendGlobalEvent("keyboardstatuschanged", r102);
        goto L9
    L7:
        r103 = "off";
    L9:
        Iterator<Map.Entry<Object, f>> r104 = this.f382123l.entrySet().iterator();
    L11:
        if (r104.hasNext() == false) goto L16;
        f r105 = r104.next().getValue();
        if (r100 == true) goto L14;
        r105.f();
        goto L11
    L14:
        r105.g((int) (r101 * this.f382114c));
        goto L11
    }
}
