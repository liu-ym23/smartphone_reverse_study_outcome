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

/* JADX INFO: loaded from: classes16.dex */
public class DriveWebView extends DriveNestedScrollWebView implements m85.a {
    public static final /* synthetic */ int H = 0;
    public ViewOwner A;
    public a55.a B;
    public z C;
    public String D;
    public int E;
    public EncryptData F;
    public final otb.j G;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public i f225915o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f225916p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View.OnClickListener f225917q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Runnable f225918r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f225919s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PointF f225920t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PointF f225921u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f225922v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public g f225923w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Handler f225924x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PointValue f225925y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public DriveComponentRenderVM f225926z;

    public class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveWebView f225927a;

        public a(DriveWebView r100) {
            this.f225927a = r100;
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final boolean f(String r100) {
            this.f225927a.f225922v = true;
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
        this.f225915o = new i();
        this.f225916p = new c();
        setWebViewClient(this.f225915o);
        setWebChromeClient(this.f225916p);
        f(new a(this));
        this.f225923w = new g(this);
        Lazy<otb.n> r100 = TTWebViewUtil.f437209a;
        otb.e r101 = TTWebViewUtil.a.a(this);
        otb.m r102 = (otb.m) r101;
        r102.c(this.G);
    }

    @Override // m85.a
    public final void onRelease() {
        this.f225924x.removeCallbacksAndMessages(null);
        a55.a r100 = this.B;
        if (r100 == null) goto L6;
        r100.onRelease();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.DriveNestedScrollWebView, android.view.ViewGroup
    public /* bridge */ /* synthetic */ int getNestedScrollAxes() {
        return super.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f225926z.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public DriveWebView(Context r100) {
        super(r100);
        this.f225924x = new Handler(Looper.getMainLooper());
        this.f225925y = new PointValue(false, 0);
        this.E = 0;
        this.G = new e(this);
        b();
    }

    public static /* synthetic */ a55.b e(DriveWebView r100) {
        return r100.getOnContextMenuItemClickListener();
    }

    public final void f(j r100) {
        i r101 = this.f225915o;
        if (r101 == null) goto L6;
        r101.f225978a.add(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.DriveNestedScrollWebView, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L17;
        if (r101 != 1) goto L19;
        this.f225921u = new PointF(r100.getX(), r100.getY());
        long r102 = System.currentTimeMillis() - this.f225919s;
        this.f225922v = false;
        this.f225924x.removeCallbacks(this.f225923w);
        PointF r103 = this.f225920t;
        if (r103 == null) goto L19;
        PointF r104 = this.f225921u;
        if (r104 == null) goto L19;
        float r105 = Math.abs(r103.x - r104.x);
        float r106 = Math.abs(this.f225920t.y - this.f225921u.y);
        if (r102 > 150) goto L19;
        if (Math.max(r105, r106) > 10.0f) goto L19;
        this.f225924x.postDelayed(this.f225923w, 150);
    L19:
        return super.onTouchEvent(r100);
    L17:
        requestDisallowInterceptTouchEvent(true);
        this.f225919s = System.currentTimeMillis();
        this.f225920t = new PointF(r100.getX(), r100.getY());
        goto L19
    }

    public void setCopyErrorCode(int r100) {
        this.E = r100;
    }

    public void setCopyPermission(PointValue r100) {
        if (r100 == null) goto L4;
        this.f225925y = r100;
    L4:
        tt5.a.h("DriveWebView", "mCanCopy:" + this.f225925y.getAllow());
    }

    public void setEncryptData(EncryptData r100) {
        this.F = r100;
    }

    public void setFileModel(z r100) {
        this.C = r100;
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.DriveNestedScrollWebView, android.view.View, androidx.core.view.NestedScrollingChild
    public /* bridge */ /* synthetic */ void setNestedScrollingEnabled(boolean r100) {
        super.setNestedScrollingEnabled(r100);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        this.f225917q = r100;
    }

    public void setOnFullScreenSwitchListener(Runnable r100) {
        this.f225918r = r100;
    }

    public void setTenantId(String r100) {
        this.D = r100;
    }

    public DriveWebView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225924x = new Handler(Looper.getMainLooper());
        this.f225925y = new PointValue(false, 0);
        this.E = 0;
        this.G = new e(this);
        b();
    }

    public static boolean d(DriveWebView r100, ActionMode r101) {
        r100.getClass();
        tt5.a.b("DriveWebView", "onMenuItemClick");
        a55.b r102 = r100.getOnContextMenuItemClickListener();
        a55.a r103 = (a55.a) r102;
        if (r103.b(R.id.copy, true, r100.E, r100.getContext(), r100.D, r100.f225925y) == true) goto L5;
        r101.finish();
        return true;
    L5:
        EncryptData r104 = r100.F;
        if (r104 != null) goto L8;
    L10:
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).i();
    L11:
        return false;
    L8:
        if (r104.isBlock() == false) goto L10;
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).j(r100.F.getEncryptId());
        goto L11
    }

    public final void g(ViewOwner r100, ViewOwner r101) {
        this.A = r101;
        DriveComponentRenderVM r102 = (DriveComponentRenderVM) r100.viewModel(DriveComponentRenderVM.class);
        this.f225926z = r102;
        if (r102.needBindReleaseListener() == false) goto L6;
        this.f225926z.bindReleaseListener(this);
        setLayerType(2, null);
        return;
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback r100, int r101) {
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).s() == false) goto L6;
        r100 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).r(r100);
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        r100 = new h(this, r100);
    L8:
        final ActionMode r102 = super.startActionMode(r100, r101);
        int r103 = 0;
        if (this.f225925y.getAllow() == true) goto L11;
    L13:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L29;
        if (r102 == null) goto L34;
        Menu r105 = r102.getMenu();
        if (r105 == null) goto L34;
        int r106 = r105.size();
    L22:
        if (r103 >= r106) goto L34;
        MenuItem r107 = r105.getItem(r103);
        if (r107.getTitle() == null) goto L28;
        if (r107.getTitle().equals(getResources().getString(R.string.copy)) == false) goto L28;
        tt5.a.b("DriveWebView", "menuItem:" + r107);
        r107.setOnMenuItemClickListener(new f(this, r102));
    L28:
        r103 = r103 + 1;
    L34:
        return r102;
    L29:
        if (r102 == null) goto L34;
        Menu r108 = r102.getMenu();     // Catch: Exception -> L32
        r108.clear();     // Catch: Exception -> L32
        r108.add(769711401, 0, 0, getResources().getString(com.larus.nova.R.string.Drive_Drive_Action_Copy));     // Catch: Exception -> L32
    L32:
        e = move-exception;
        tt5.a.f("DriveWebView", e, false);
        goto L34
    L11:
        if (this.E != 0) goto L13;
        r104 = true;
        goto L15
    }

    public DriveWebView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225924x = new Handler(Looper.getMainLooper());
        this.f225925y = new PointValue(false, 0);
        this.E = 0;
        this.G = new e(this);
        b();
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onOverScrolled(int r100, int r101, boolean r102, boolean r103) {
        super.onOverScrolled(r100, r101, r102, r103);
        if (r102 == false) goto L6;
        requestDisallowInterceptTouchEvent(false);
        return;
    }
}
