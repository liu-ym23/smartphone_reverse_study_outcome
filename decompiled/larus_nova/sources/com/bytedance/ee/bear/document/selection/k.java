package com.bytedance.ee.bear.document.selection;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class k implements ocb.a, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class f221656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f221657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f221658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f221659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f221660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z4 f221661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GestureDetector f221662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f221663h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<View> f221664i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f221665j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f221666k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h f221667l;

    public final void a() throws Throwable {
        if (this.f221656a != null) goto L35;
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L46;
        Class<?> r102 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L19
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L19
    L32:
        this.f221656a = r102;
    L19:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L24;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L24:
        if ((th instanceof PluginClassNotFoundException) == false) goto L26;
        throw th;
    L26:
        if ((th instanceof ClassNotFoundException) == false) goto L28;
    L31:
        r102 = MiraPluginFix.forName("android.view.WindowManagerGlobal");
        goto L32
    L28:
        if ((th instanceof NoClassDefFoundError) == true) goto L31;
        throw th;
    L46:
        r102 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L10
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L14;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L14:
        throw th;
    L35:
        if (this.f221657b != null) goto L38;
        this.f221657b = this.f221656a.getMethod("getViewRootNames", new Class[0]);
    L38:
        if (this.f221658c != null) goto L41;
        this.f221658c = this.f221656a.getMethod("getRootView", new Class[]{String.class});
    L41:
        if (this.f221659d != null) goto L48;
        this.f221659d = this.f221656a.getMethod("getInstance", new Class[0]).invoke(null, null);
        return;
    }

    public final void c() {
        com.bytedance.ee.util.ui.j.e(this.f221665j);
        com.bytedance.ee.util.ui.j.d(this.f221665j, 100);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ee.bear.document.selection.f] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ee.bear.document.selection.g] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.ee.bear.document.selection.h] */
    public k() {
        this.f221660e = 0;
        this.f221663h = new int[2];
        this.f221664i = new ArrayList(3);
        this.f221665j = new f(this);
        this.f221666k = new g(this);
        this.f221667l = new h(this);
    }

    public final boolean b(View r100) {
        r100.getLocationOnScreen(this.f221663h);
        int r101 = (com.bytedance.ee.util.ui.n.t() - this.f221660e) - com.bytedance.ee.util.ui.n.d(20);
        tt5.a.b("SelectionHackHelper", "visibleKeyboardHeight " + this.f221660e + " location[1] " + this.f221663h[1] + " keyboardStart " + r101);
        if (this.f221660e > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f221663h[1] <= r101) goto L7;
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        this.f221662g.onTouchEvent(r101);
        return false;
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        this.f221660e = r101;
        c();
    }
}
