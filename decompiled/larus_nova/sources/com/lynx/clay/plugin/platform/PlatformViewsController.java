package com.lynx.clay.plugin.platform;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.lynx.clay.embedding.android.FlutterImageView;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.android.b;
import com.lynx.clay.embedding.android.i;
import com.lynx.clay.embedding.engine.FlutterEngine;
import com.lynx.clay.embedding.engine.FlutterOverlaySurface;
import com.lynx.clay.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import e5a.a;
import m5a.h;
import m5a.q;

/* JADX INFO: loaded from: classes32.dex */
public class PlatformViewsController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f380943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f380944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FlutterView f380945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<View> f380946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseBooleanArray f380947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseArray<a.b> f380948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SparseArray<a> f380949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f380950h;

    public void onAttachedToJNI() {
    }

    public final void a() {
        if (this.f380950h == true) goto L13;
        FlutterView r100 = this.f380945c;
        r100.f380520g.pause();
        FlutterImageView r101 = r100.f380518e;
        if (r101 != null) goto L7;
        FlutterImageView r102 = new FlutterImageView(r100.getContext(), r100.getWidth(), r100.getHeight(), FlutterImageView.SurfaceKind.background);
        r100.f380518e = r102;
        r100.addView(r102);
    L8:
        FlutterImageView r103 = r100.f380518e;
        r100.f380520g = r103;
        FlutterEngine r104 = r100.f380531r;
        if (r104 == null) goto L11;
        r103.a(r104.f380695b);
    L11:
        this.f380950h = true;
        return;
    L7:
        r101.e(r100.getWidth(), r100.getHeight());
        goto L8
    }

    public void onDetachedFromJNI() {
    L3:
        if (this.f380946d.size() <= 0) goto L5;
        int r100 = this.f380946d.keyAt(0);
        dispose(r100);
        this.f380947e.delete(r100);
        this.f380948f.remove(r100);
        goto L3
    }

    public void onEndFrame() {
        if (this.f380950h == false) goto L8;
        FlutterImageView r100 = this.f380945c.f380518e;
        if (r100 == null) goto L9;
        r100.c(false);
        return;
    L9:
        return;
    }

    public PlatformViewsController() {
        this.f380947e = new SparseBooleanArray();
        this.f380948f = new SparseArray();
        this.f380950h = false;
        this.f380946d = new SparseArray();
        this.f380949g = new SparseArray();
        if (i.f380663c != null) goto L6;
        i.f380663c = new i();
        return;
    }

    private void bringToFront(int r100) {
        a r101 = this.f380949g.get(r100);
        if (r101 == null) goto L6;
        r101.setVisibility(0);
        r101.bringToFront();
        return;
    }

    private void dispose(int r100) {
        View r101 = this.f380946d.get(r100);
        ViewGroup r102 = (ViewGroup) r101.getParent();
        if (r102 == null) goto L5;
        r102.removeView(r101);
    L5:
        this.f380946d.remove(r100);
        this.f380947e.delete(r100);
        this.f380948f.remove(r100);
        a r103 = this.f380949g.get(r100);
        if (r103 == null) goto L17;
        r103.removeAllViews();
        ViewTreeObserver r104 = r103.getViewTreeObserver();
        if (r104.isAlive() == false) goto L12;
        a.ViewTreeObserverOnGlobalFocusChangeListenerC5743a r105 = r103.f471087i;
        if (r105 == null) goto L12;
        r103.f471087i = null;
        r104.removeOnGlobalFocusChangeListener(r105);
    L12:
        ViewGroup r106 = (ViewGroup) r103.getParent();
        if (r106 == null) goto L15;
        r106.removeView(r103);
    L15:
        this.f380949g.remove(r100);
        return;
    }

    private void hide(int r100) {
        a r101 = this.f380949g.get(r100);
        if (r101 == null) goto L6;
        r101.setVisibility(4);
        return;
    }

    public void onDisplayOverlaySurface(FlutterOverlaySurface r100, int r101, int r102, int r103, int r104, int r105) {
        a();
        if (r105 == 0) goto L10;
        q r106 = h.f512176e.f512178b.get(Integer.valueOf(r105));
        if (r106 != null) goto L7;
        boolean r107 = false;
    L8:
        if (r107 == false) goto L10;
        return;
    L7:
        r106.n(r100, r103, r104);
        r107 = true;
    L10:
        View r108 = r100.a();
        if (r108 != null) goto L14;
        return;
    L14:
        if (r108.getParent() != null) goto L16;
        this.f380945c.addView(r108);
    L16:
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(r103, r104);
        r109.leftMargin = r101;
        r109.topMargin = r102;
        r108.setLayoutParams(r109);
    }

    public void onDisplayPlatformView(int r100, int r101, int r102, int r103, int r110, int r111, int r112, FlutterMutatorsStack r113) {
        Resources r104 = this.f380944b.getResources();
        int r114 = Math.round(r111 / WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density);
        Resources r105 = this.f380944b.getResources();
        int r115 = Math.round(r112 / WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density);
        a();
        if (this.f380949g.get(r100) != null) goto L15;
        View r106 = this.f380946d.get(r100);
        if (r106 == null) goto L22;
        if (r106.getParent() != null) goto L20;
        Context r107 = this.f380944b;
        Resources r108 = r107.getResources();
        float r109 = WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()).density;
        a r116 = new a(r107, this.f380943a);
        if (this.f380947e.get(r100) == false) goto L12;
        r116.setSystemTouchDispatchEnabled(true);
        r116.setTouchDispatchResultListener(this.f380948f.get(r100));
    L12:
        this.f380949g.put(r100, r116);
        r106.setImportantForAccessibility(4);
        r116.addView(r106);
        if (r106.willNotDraw() == true) goto L15;
        this.f380945c.addView(r116);
        goto L15
    L20:
        throw new IllegalStateException("The Android view returned was already added to a parent view.");
    L22:
        throw new IllegalStateException("Android view reference was expected.");
    L15:
        a r117 = this.f380949g.get(r100);
        r117.f471079a = r113;
        r117.f471080b = r101;
        r117.f471081c = r102;
        FrameLayout.LayoutParams r118 = new FrameLayout.LayoutParams(r103, r110);
        r118.leftMargin = r101;
        r118.topMargin = r102;
        r117.setLayoutParams(r118);
        FrameLayout.LayoutParams r119 = new FrameLayout.LayoutParams(r114, r115);
        View r120 = this.f380946d.get(r100);
        if (r120 == null) goto L23;
        r120.setLayoutParams(r119);
        return;
    }
}
