package com.bytedance.ee.bear.browser.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import zv4.a;
import zv4.b;
import zv4.c;
import zv4.d;

/* JADX INFO: loaded from: classes16.dex */
public class DecorateWebViewV2 extends NestedScrollWebViewV2 implements c<WebView>, b {
    public ActionMode H0;
    public boolean L0;
    public boolean P0;
    public d V;
    public boolean V0;
    public List<d> W;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Map<d, View[]> f216650k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public List<a> f216651p0;

    @Override // zv4.c
    public WebView getHostView() {
        return this;
    }

    @Override // zv4.b
    public final void c() {
        ActionMode r100 = this.H0;
        if (r100 == null) goto L6;
        r100.finish();
        this.H0 = null;
        return;
    }

    public final d w() {
        if (((ArrayList) this.W).isEmpty() == false) goto L6;
        return null;
    L6:
        List<d> r100 = this.W;
        return (d) ListProtector.get(r100, ((ArrayList) r100).size() - 1);
    }

    private void r() {
        LayoutInflater.from(getContext());
        this.W = new ArrayList();
        this.f216650k0 = new HashMap();
        this.f216651p0 = new ArrayList();
    }

    @Override // zv4.c
    public /* bridge */ /* synthetic */ View getHostView() {
        return getHostView();
    }

    @Override // com.bytedance.ee.bear.jsbridge.BridgeWebViewV2, com.bytedance.ee.larkwebview.base.LarkWebView, com.bytedance.ee.larkwebview.base.g, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d r100 = w();
        if (r100 == null) goto L6;
        r100.onAttachedToWindow();
        return;
    }

    @Override // com.bytedance.ee.bear.webview.fps.FpsWebViewV2, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d r100 = w();
        if (r100 == null) goto L5;
        r100.onDetachedFromWindow();
    L5:
        c();
    }

    public List<d> getDecorateLayers() {
        return this.W;
    }

    public DecorateWebViewV2(Context r100) {
        super(r100);
        this.P0 = true;
        this.V0 = false;
        r();
    }

    @Override // zv4.c
    public final void b(d r100) {
        if (((ArrayList) this.W).contains(r100) == false) goto L5;
        return;
    L5:
        r100.b(this);
        ((ArrayList) this.W).add(r100);
        View[] r101 = r100.c();
        ((HashMap) this.f216650k0).put(r100, r101);
        if (r101 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L12;
        addView(r101[r103]);
        r103 = r103 + 1;
        goto L8
    L12:
        return;
    }

    @Override // zv4.c
    public final void d(d r100) {
        if (((ArrayList) this.W).remove(r100) == true) goto L5;
        return;
    L5:
        r100.d();
        View[] r101 = (View[]) ((HashMap) this.f216650k0).remove(r100);
        if (r101 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L12;
        removeView(r101[r103]);
        r103 = r103 + 1;
        goto L8
    L12:
        return;
    }

    @Override // zv4.b
    public final void e(a r100) {
        if (((ArrayList) this.f216651p0).contains(r100) == true) goto L6;
        ((ArrayList) this.f216651p0).add(r100);
        return;
    }

    @Override // zv4.b
    public final void f(a r100) {
        ((ArrayList) this.f216651p0).remove(r100);
    }

    @Override // com.bytedance.ee.bear.browser.view.NestedScrollWebViewV2, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 0) goto L6;
        this.L0 = false;
    L6:
        if (super.onInterceptTouchEvent(r100) == false) goto L9;
        this.L0 = true;
        return true;
    L9:
        this.V = null;
        return false;
    }

    @Override // com.bytedance.ee.bear.browser.view.NestedScrollWebViewV2, com.bytedance.ee.larkwebview.base.LarkWebView, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.L0 == false) goto L7;
        return super.onTouchEvent(r100);
    L7:
        if (this.V == null) goto L10;
        MotionEvent r101 = MotionEvent.obtain(r100);
        r101.setAction(3);
        super.onTouchEvent(r101);
        r101.recycle();
        return this.V.onTouchEvent(r100);
    L10:
        d r102 = w();
        if (r102 == null) goto L16;
        if (r102.onTouchEvent(r100) == false) goto L16;
        this.V = r102;
        r100.setAction(3);
    L16:
        return super.onTouchEvent(r100);
    }

    @Override // zv4.b
    public void setDisableCustomActionMode(boolean r100) {
        this.V0 = r100;
    }

    public void setEnableOverScrollBy(boolean r100) {
        this.P0 = r100;
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback r100) {
        return v(r100, -1);
    }

    public DecorateWebViewV2(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.P0 = true;
        this.V0 = false;
        r();
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, android.view.View, zv4.b
    public ActionMode startActionMode(ActionMode.Callback r100, int r101) {
        return v(r100, r101);
    }

    public final ActionMode v(ActionMode.Callback r100, int r101) {
        if (this.V0 == false) goto L5;
    L10:
        ActionMode.Callback r102 = null;
    L11:
        tt5.a.h("DecorateWebViewV2", "start action mode actionModeCallback " + r102);
        if (r102 == null) goto L19;
        if (x.a() == false) goto L16;
        ActionMode r103 = super.startActionMode(r102, r101);
    L17:
        this.H0 = r103;
    L27:
        return this.H0;
    L16:
        r103 = super.startActionMode(r102);
        goto L17
    L19:
        if (hasFocus() == true) goto L21;
        tt5.a.k("DecorateWebViewV2", "WebView has no focus, intercept system actionMode!");
        c();
        goto L27
    L21:
        if (x.a() == false) goto L23;
        ActionMode r104 = super.startActionMode(r100, r101);
    L24:
        this.H0 = r104;
        goto L27
    L23:
        r104 = super.startActionMode(r100);
        goto L24
    L5:
        if (CollectionUtils.isEmpty(this.f216651p0) == true) goto L7;
        List<a> r105 = this.f216651p0;
        r102 = ((a) ListProtector.get(r105, ((ArrayList) r105).size() - 1)).prepareActionMode(r100);
        tt5.a.h("DecorateWebViewV2", "delegate is not empty");
        goto L11
    L7:
        d r106 = w();
        if (r106 == null) goto L10;
        r102 = r106.prepareActionMode(r100);
        goto L11
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onOverScrolled(int r100, int r101, boolean r102, boolean r103) {
        super.onOverScrolled(r100, r101, r102, r103);
        d r104 = w();
        if (r104 == null) goto L6;
        r104.a(r100, r101, r102, r103);
        return;
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, android.view.View
    public final boolean overScrollBy(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, boolean r110) {
        if (this.P0 == true) goto L7;
        return true;
    L7:
        return super.overScrollBy(r100, r101, r102, r103, r104, r105, r106, r107, r110);
    }
}
