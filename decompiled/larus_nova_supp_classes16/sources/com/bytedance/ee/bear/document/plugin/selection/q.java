package com.bytedance.ee.bear.document.plugin.selection;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q implements ocb.a, View.OnTouchListener {
    public Class a;
    public Method b;
    public Method c;
    public Object d;
    public int e;
    public ChameleonWebView f;
    public GestureDetector g;
    public final int[] h;
    public final List<View> i;
    public final l j;
    public final m k;
    public final n l;

    public final void a() throws Throwable {
        if (this.a != null) goto L35;
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L46;
        Class<?> r2 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L19
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L19
    L32:
        this.a = r2;
    L19:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L24;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L24:
        if ((th instanceof PluginClassNotFoundException) == false) goto L26;
        throw th;
    L26:
        if ((th instanceof ClassNotFoundException) == false) goto L28;
    L31:
        r2 = MiraPluginFix.forName("android.view.WindowManagerGlobal");
        goto L32
    L28:
        if ((th instanceof NoClassDefFoundError) == true) goto L31;
        throw th;
    L46:
        r2 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L10
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L14;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L14:
        throw th;
    L35:
        if (this.b != null) goto L38;
        this.b = this.a.getMethod("getViewRootNames", new Class[0]);
    L38:
        if (this.c != null) goto L41;
        this.c = this.a.getMethod("getRootView", new Class[]{String.class});
    L41:
        if (this.d != null) goto L48;
        this.d = this.a.getMethod("getInstance", new Class[0]).invoke(null, null);
        return;
    }

    public final void c() {
        com.bytedance.ee.util.ui.j.e(this.j);
        com.bytedance.ee.util.ui.j.d(this.j, 100);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ee.bear.document.plugin.selection.l] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ee.bear.document.plugin.selection.m] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.ee.bear.document.plugin.selection.n] */
    public q() {
        this.e = 0;
        this.h = new int[2];
        this.i = new ArrayList(3);
        this.j = new l(this);
        this.k = new m(this);
        this.l = new n(this);
    }

    public final boolean b(View r4) {
        r4.getLocationOnScreen(this.h);
        int r5 = (com.bytedance.ee.util.ui.n.t() - this.e) - com.bytedance.ee.util.ui.n.d(20);
        tt5.a.b("SelectionHackHelper", "visibleKeyboardHeight " + this.e + " location[1] " + this.h[1] + " keyboardStart " + r5);
        if (this.e > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.h[1] <= r5) goto L7;
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        this.g.onTouchEvent(r2);
        return false;
    }

    public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        this.e = r2;
        c();
    }
}
