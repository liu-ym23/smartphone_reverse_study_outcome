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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DecorateWebViewV2 extends NestedScrollWebViewV2 implements c<WebView>, b {
    public ActionMode H0;
    public boolean L0;
    public boolean P0;
    public d V;
    public boolean V0;
    public List<d> W;
    public Map<d, View[]> k0;
    public List<a> p0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zv4.c
    public WebView getHostView() {
        return this;
    }

    @Override // zv4.b
    public final void c() {
        ActionMode r0 = this.H0;
        if (r0 == null) goto L6;
        r0.finish();
        this.H0 = null;
        return;
    }

    public final d w() {
        if (((ArrayList) this.W).isEmpty() == false) goto L6;
        return null;
    L6:
        List<d> r0 = this.W;
        return (d) ListProtector.get(r0, ((ArrayList) r0).size() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r() {
        LayoutInflater.from(getContext());
        this.W = new ArrayList();
        this.k0 = new HashMap();
        this.p0 = new ArrayList();
    }

    @Override // zv4.c
    public /* bridge */ /* synthetic */ View getHostView() {
        return getHostView();
    }

    @Override // com.bytedance.ee.bear.jsbridge.BridgeWebViewV2
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d r0 = w();
        if (r0 == null) goto L6;
        r0.onAttachedToWindow();
        return;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d r0 = w();
        if (r0 == null) goto L5;
        r0.onDetachedFromWindow();
    L5:
        c();
    }

    public List<d> getDecorateLayers() {
        return this.W;
    }

    public DecorateWebViewV2(Context r1) {
        super(r1);
        this.P0 = true;
        this.V0 = false;
        r();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zv4.c
    public final void b(d r4) {
        if (((ArrayList) this.W).contains(r4) == false) goto L5;
        return;
    L5:
        r4.b(this);
        ((ArrayList) this.W).add(r4);
        View[] r0 = r4.c();
        ((HashMap) this.k0).put(r4, r0);
        if (r0 == null) goto L10;
        int r5 = r0.length;
        int r1 = 0;
    L8:
        if (r1 >= r5) goto L12;
        addView(r0[r1]);
        r1 = r1 + 1;
        goto L8
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zv4.c
    public final void d(d r4) {
        if (((ArrayList) this.W).remove(r4) == true) goto L5;
        return;
    L5:
        r4.d();
        View[] r5 = (View[]) ((HashMap) this.k0).remove(r4);
        if (r5 == null) goto L10;
        int r0 = r5.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L12;
        removeView(r5[r1]);
        r1 = r1 + 1;
        goto L8
    L12:
        return;
    }

    @Override // zv4.b
    public final void e(a r2) {
        if (((ArrayList) this.p0).contains(r2) == true) goto L6;
        ((ArrayList) this.p0).add(r2);
        return;
    }

    @Override // zv4.b
    public final void f(a r2) {
        ((ArrayList) this.p0).remove(r2);
    }

    @Override // com.bytedance.ee.bear.browser.view.NestedScrollWebViewV2
    public final boolean onInterceptTouchEvent(MotionEvent r3) {
        if (r3.getAction() != 0) goto L6;
        this.L0 = false;
    L6:
        if (super.onInterceptTouchEvent(r3) == false) goto L9;
        this.L0 = true;
        return true;
    L9:
        this.V = null;
        return false;
    }

    @Override // com.bytedance.ee.bear.browser.view.NestedScrollWebViewV2
    public final boolean onTouchEvent(MotionEvent r4) {
        if (this.L0 == false) goto L7;
        return super.onTouchEvent(r4);
    L7:
        if (this.V == null) goto L10;
        MotionEvent r0 = MotionEvent.obtain(r4);
        r0.setAction(3);
        super.onTouchEvent(r0);
        r0.recycle();
        return this.V.onTouchEvent(r4);
    L10:
        d r1 = w();
        if (r1 == null) goto L16;
        if (r1.onTouchEvent(r4) == false) goto L16;
        this.V = r1;
        r4.setAction(3);
    L16:
        return super.onTouchEvent(r4);
    }

    @Override // zv4.b
    public void setDisableCustomActionMode(boolean r1) {
        this.V0 = r1;
    }

    public void setEnableOverScrollBy(boolean r1) {
        this.P0 = r1;
    }

    public ActionMode startActionMode(ActionMode.Callback r2) {
        return v(r2, -1);
    }

    public DecorateWebViewV2(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.P0 = true;
        this.V0 = false;
        r();
    }

    @Override // zv4.b
    public ActionMode startActionMode(ActionMode.Callback r1, int r2) {
        return v(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ActionMode v(ActionMode.Callback r5, int r6) {
        if (this.V0 == false) goto L5;
    L10:
        ActionMode.Callback r0 = null;
    L11:
        tt5.a.h("DecorateWebViewV2", "start action mode actionModeCallback " + r0);
        if (r0 == null) goto L19;
        if (x.a() == false) goto L16;
        ActionMode r7 = super/*com.bytedance.ee.larkwebview.base.LarkWebView*/.startActionMode(r0, r6);
    L17:
        this.H0 = r7;
    L27:
        return this.H0;
    L16:
        r7 = super/*android.webkit.WebView*/.startActionMode(r0);
        goto L17
    L19:
        if (hasFocus() == true) goto L21;
        tt5.a.k("DecorateWebViewV2", "WebView has no focus, intercept system actionMode!");
        c();
        goto L27
    L21:
        if (x.a() == false) goto L23;
        ActionMode r8 = super/*com.bytedance.ee.larkwebview.base.LarkWebView*/.startActionMode(r5, r6);
    L24:
        this.H0 = r8;
        goto L27
    L23:
        r8 = super/*android.webkit.WebView*/.startActionMode(r5);
        goto L24
    L5:
        if (CollectionUtils.isEmpty(this.p0) == true) goto L7;
        List<a> r1 = this.p0;
        r0 = ((a) ListProtector.get(r1, ((ArrayList) r1).size() - 1)).prepareActionMode(r5);
        tt5.a.h("DecorateWebViewV2", "delegate is not empty");
        goto L11
    L7:
        d r2 = w();
        if (r2 == null) goto L10;
        r0 = r2.prepareActionMode(r5);
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onOverScrolled(int r2, int r3, boolean r4, boolean r5) {
        super/*android.webkit.WebView*/.onOverScrolled(r2, r3, r4, r5);
        d r0 = w();
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4, r5);
        return;
    }

    public final boolean overScrollBy(int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, boolean r10) {
        if (this.P0 == true) goto L7;
        return true;
    L7:
        return super/*com.bytedance.ee.larkwebview.base.LarkWebView*/.overScrollBy(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }
}
