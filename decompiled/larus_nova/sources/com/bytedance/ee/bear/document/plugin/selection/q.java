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

/* JADX INFO: loaded from: classes16.dex */
public final class q implements ocb.a, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class f220947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f220948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f220949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f220950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f220951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ChameleonWebView f220952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GestureDetector f220953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f220954h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<View> f220955i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l f220956j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m f220957k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final n f220958l;

    public final void a() throws Throwable {
        if (this.f220947a != null) goto L35;
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L46;
        Class<?> r102 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L19
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L19
    L32:
        this.f220947a = r102;
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
        if (this.f220948b != null) goto L38;
        this.f220948b = this.f220947a.getMethod("getViewRootNames", new Class[0]);
    L38:
        if (this.f220949c != null) goto L41;
        this.f220949c = this.f220947a.getMethod("getRootView", new Class[]{String.class});
    L41:
        if (this.f220950d != null) goto L48;
        this.f220950d = this.f220947a.getMethod("getInstance", new Class[0]).invoke(null, null);
        return;
    }

    public final void c() {
        com.bytedance.ee.util.ui.j.e(this.f220956j);
        com.bytedance.ee.util.ui.j.d(this.f220956j, 100);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ee.bear.document.plugin.selection.l] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ee.bear.document.plugin.selection.m] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.ee.bear.document.plugin.selection.n] */
    public q() {
        this.f220951e = 0;
        this.f220954h = new int[2];
        this.f220955i = new ArrayList(3);
        this.f220956j = new l(this);
        this.f220957k = new m(this);
        this.f220958l = new n(this);
    }

    public final boolean b(View r100) {
        r100.getLocationOnScreen(this.f220954h);
        int r101 = (com.bytedance.ee.util.ui.n.t() - this.f220951e) - com.bytedance.ee.util.ui.n.d(20);
        tt5.a.b("SelectionHackHelper", "visibleKeyboardHeight " + this.f220951e + " location[1] " + this.f220954h[1] + " keyboardStart " + r101);
        if (this.f220951e > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f220954h[1] <= r101) goto L7;
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        this.f220953g.onTouchEvent(r101);
        return false;
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        this.f220951e = r101;
        c();
    }
}
