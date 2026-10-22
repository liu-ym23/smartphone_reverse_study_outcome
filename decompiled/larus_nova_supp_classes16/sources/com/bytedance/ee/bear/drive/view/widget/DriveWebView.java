package com.bytedance.ee.bear.drive.view.widget;

import android.R;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.drive.biz.permission.inject.PointValue;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.permission.EncryptData;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveWebView extends DriveNestedScrollWebView implements m85.a {
    public static final /* synthetic */ int H = 0;
    public ViewOwner A;
    public a55.a B;
    public z C;
    public String D;
    public int E;
    public EncryptData F;
    public final otb.j G;
    public i o;
    public c p;
    public View.OnClickListener q;
    public Runnable r;
    public long s;
    public PointF t;
    public PointF u;
    public boolean v;
    public g w;
    public final Handler x;
    public PointValue y;
    public DriveComponentRenderVM z;

    public class a extends j {
        public final /* synthetic */ DriveWebView a;

        public a(DriveWebView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final boolean f(String r2) {
            this.a.v = true;
            return this instanceof com.bytedance.ee.bear.drive.view.preview.htmlrender.b.c;
        }
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "DriveWebView";
    }

    private a55.b getOnContextMenuItemClickListener() {
        if (this.B != null) goto L6;
        this.B = new a55.a(this.A, this.C);
    L6:
        return this.B;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ee.bear.drive.view.widget.g] */
    public final void b() {
        this.o = new i();
        this.p = new c();
        setWebViewClient(this.o);
        setWebChromeClient(this.p);
        f(new a(this));
        this.w = new g(this);
        Lazy r0 = TTWebViewUtil.a;
        otb.m r1 = TTWebViewUtil.a.a(this);
        otb.m r2 = r1;
        r2.c(this.G);
    }

    @Override // m85.a
    public final void onRelease() {
        this.x.removeCallbacksAndMessages(null);
        a55.a r0 = this.B;
        if (r0 == null) goto L6;
        r0.onRelease();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.DriveNestedScrollWebView, android.view.ViewGroup
    public /* bridge */ /* synthetic */ int getNestedScrollAxes() {
        return super.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.z.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public DriveWebView(Context r2) {
        super(r2);
        this.x = new Handler(Looper.getMainLooper());
        this.y = new PointValue(false, 0);
        this.E = 0;
        this.G = new e(this);
        b();
    }

    public static /* synthetic */ a55.b e(DriveWebView r0) {
        return r0.getOnContextMenuItemClickListener();
    }

    public final void f(j r2) {
        i r0 = this.o;
        if (r0 == null) goto L6;
        r0.a.add(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.DriveNestedScrollWebView, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        int r0 = r8.getAction();
        if (r0 == 0) goto L17;
        if (r0 != 1) goto L19;
        this.u = new PointF(r8.getX(), r8.getY());
        long r1 = System.currentTimeMillis() - this.s;
        this.v = false;
        this.x.removeCallbacks(this.w);
        PointF r2 = this.t;
        if (r2 == null) goto L19;
        PointF r3 = this.u;
        if (r3 == null) goto L19;
        float r4 = Math.abs(r2.x - r3.x);
        float r5 = Math.abs(this.t.y - this.u.y);
        if (r1 > 150) goto L19;
        if (Math.max(r4, r5) > 10.0f) goto L19;
        this.x.postDelayed(this.w, 150);
    L19:
        return super.onTouchEvent(r8);
    L17:
        requestDisallowInterceptTouchEvent(true);
        this.s = System.currentTimeMillis();
        this.t = new PointF(r8.getX(), r8.getY());
        goto L19
    }

    public void setCopyErrorCode(int r1) {
        this.E = r1;
    }

    public void setCopyPermission(PointValue r2) {
        if (r2 == null) goto L4;
        this.y = r2;
    L4:
        tt5.a.h("DriveWebView", "mCanCopy:" + this.y.getAllow());
    }

    public void setEncryptData(EncryptData r1) {
        this.F = r1;
    }

    public void setFileModel(z r1) {
        this.C = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.DriveNestedScrollWebView, android.view.View
    public /* bridge */ /* synthetic */ void setNestedScrollingEnabled(boolean r1) {
        super.setNestedScrollingEnabled(r1);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
        this.q = r1;
    }

    public void setOnFullScreenSwitchListener(Runnable r1) {
        this.r = r1;
    }

    public void setTenantId(String r1) {
        this.D = r1;
    }

    public DriveWebView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.x = new Handler(Looper.getMainLooper());
        this.y = new PointValue(false, 0);
        this.E = 0;
        this.G = new e(this);
        b();
    }

    public static boolean d(DriveWebView r8, ActionMode r9) {
        r8.getClass();
        tt5.a.b("DriveWebView", "onMenuItemClick");
        a55.b r0 = r8.getOnContextMenuItemClickListener();
        a55.a r1 = (a55.a) r0;
        if (r1.b(R.id.copy, true, r8.E, r8.getContext(), r8.D, r8.y) == true) goto L5;
        r9.finish();
        return true;
    L5:
        EncryptData r10 = r8.F;
        if (r10 != null) goto L8;
    L10:
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).i();
    L11:
        return false;
    L8:
        if (r10.isBlock() == false) goto L10;
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).j(r8.F.getEncryptId());
        goto L11
    }

    public final void g(ViewOwner r1, ViewOwner r2) {
        this.A = r2;
        DriveComponentRenderVM r3 = (DriveComponentRenderVM) r1.viewModel(DriveComponentRenderVM.class);
        this.z = r3;
        if (r3.needBindReleaseListener() == false) goto L6;
        this.z.bindReleaseListener(this);
        setLayerType(2, null);
        return;
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback r8, int r9) {
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).s() == false) goto L6;
        r8 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).r(r8);
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        r8 = new h(this, r8);
    L8:
        final ActionMode r10 = super.startActionMode(r8, r9);
        int r0 = 0;
        if (this.y.getAllow() == true) goto L11;
    L13:
        boolean r11 = false;
    L15:
        if (r11 == false) goto L29;
        if (r10 == null) goto L34;
        Menu r12 = r10.getMenu();
        if (r12 == null) goto L34;
        int r2 = r12.size();
    L22:
        if (r0 >= r2) goto L34;
        MenuItem r3 = r12.getItem(r0);
        if (r3.getTitle() == null) goto L28;
        if (r3.getTitle().equals(getResources().getString(R.string.copy)) == false) goto L28;
        tt5.a.b("DriveWebView", "menuItem:" + r3);
        r3.setOnMenuItemClickListener(new f(this, r10));
    L28:
        r0 = r0 + 1;
    L34:
        return r10;
    L29:
        if (r10 == null) goto L34;
        Menu r13 = r10.getMenu();     // Catch: Exception -> L32
        r13.clear();     // Catch: Exception -> L32
        r13.add(769711401, 0, 0, getResources().getString(2131888362));     // Catch: Exception -> L32
    L32:
        e = move-exception;
        tt5.a.f("DriveWebView", e, false);
        goto L34
    L11:
        if (this.E != 0) goto L13;
        r11 = true;
        goto L15
    }

    public DriveWebView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.x = new Handler(Looper.getMainLooper());
        this.y = new PointValue(false, 0);
        this.E = 0;
        this.G = new e(this);
        b();
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onOverScrolled(int r1, int r2, boolean r3, boolean r4) {
        super.onOverScrolled(r1, r2, r3, r4);
        if (r3 == false) goto L6;
        requestDisallowInterceptTouchEvent(false);
        return;
    }
}
