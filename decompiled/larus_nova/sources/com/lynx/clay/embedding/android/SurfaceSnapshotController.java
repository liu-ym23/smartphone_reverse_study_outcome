package com.lynx.clay.embedding.android;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: classes32.dex */
public final class SurfaceSnapshotController implements FlutterSurfaceView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterView f380591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FlutterSurfaceView f380592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f380593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f380594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OverlayState f380595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f380596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f380597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f380598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f380599i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f380600j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f380601k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Runnable f380602l;

    public static final enum OverlayState extends Enum<OverlayState> {
        public static final OverlayState ARMED_FOR_FOREGROUND = null;
        public static final OverlayState FADING_OUT = null;
        public static final OverlayState FOREGROUND_VISIBLE = null;
        public static final OverlayState HIDDEN = null;
        public static final OverlayState TASK_SNAPSHOT_VISIBLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OverlayState[] f380603a = null;

        static {
            OverlayState r100 = new OverlayState("HIDDEN", 0);
            HIDDEN = r100;
            OverlayState r101 = new OverlayState("TASK_SNAPSHOT_VISIBLE", 1);
            TASK_SNAPSHOT_VISIBLE = r101;
            OverlayState r102 = new OverlayState("ARMED_FOR_FOREGROUND", 2);
            ARMED_FOR_FOREGROUND = r102;
            OverlayState r103 = new OverlayState("FOREGROUND_VISIBLE", 3);
            FOREGROUND_VISIBLE = r103;
            OverlayState r104 = new OverlayState("FADING_OUT", 4);
            FADING_OUT = r104;
            f380603a = new OverlayState[]{r100, r101, r102, r103, r104};
        }

        public static OverlayState[] values() {
            return (OverlayState[]) f380603a.clone();
        }

        public static OverlayState valueOf(String r100) {
            return (OverlayState) r27.a.a(OverlayState.class, r100);
        }

        public OverlayState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f380604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SurfaceSnapshotController f380605b;

        public final void a() {
            SurfaceSnapshotController r100 = this.f380605b;
            if (r100.f380602l == this) goto L5;
            return;
        L5:
            r100.f380602l = null;
            if (r100.f380600j != this.f380604a) goto L16;
            OverlayState r101 = r100.f380595e;
            OverlayState r102 = OverlayState.FADING_OUT;
            if (r101 != r102) goto L17;
            if (r101 != r102) goto L19;
            k r103 = r100.f380593c;
            if (r103 != null) goto L14;
            r100.h();
            return;
        L14:
            r103.animate().cancel();
            r103.animate().alpha(0.0f).setDuration(120).setListener(new s(r100, r103)).start();
            return;
        L19:
            return;
        L17:
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

        public a(SurfaceSnapshotController r100, int r101) {
            this.f380605b = r100;
            this.f380604a = r101;
        }
    }

    public static final class b {
        private b() {
        }

        public static void a(ViewTreeObserver r100, Runnable r101) {
            r100.registerFrameCommitCallback(r101);
        }
    }

    public final void n() {
        this.f380597g = false;
        if (j() == true) goto L5;
        return;
    L5:
        if (this.f380593c != null) goto L8;
        return;
    L8:
        if (this.f380595e != OverlayState.TASK_SNAPSHOT_VISIBLE) goto L35;
        FlutterSurfaceView r100 = this.f380592b;
        if (r100 == null) goto L35;
        if (r100.getParent() != this.f380591a) goto L35;
        FlutterSurfaceView r101 = this.f380592b;
        SurfaceSnapshotTracker r102 = r101.f380499b;
        boolean r103 = r101.f380501d;
        FlutterRenderer r104 = r101.f380502e;
        SurfaceHolder r105 = r102.f380606a.getHolder();
        if (com.lynx.clay.util.d.a(r102.f380606a) == true) goto L16;
    L31:
        boolean r106 = false;
    L32:
        if (r106 == false) goto L35;
        h();
        this.f380592b.setVisibility(0);
        return;
    L16:
        if (r102.f380606a.f380500c == false) goto L31;
        if (r103 == false) goto L31;
        if (r104 == null) goto L31;
        if (r105 == null) goto L31;
        if (r105.getSurface() == null) goto L31;
        if (r105.getSurface().isValid() == false) goto L31;
        int r107 = r102.f380613h;
        int r108 = r102.f380611f;
        if (r107 != r108) goto L31;
        if (r102.f380614i != r108) goto L31;
        if (r102.f380609d == true) goto L31;
        r106 = true;
    L35:
        this.f380601k++;
        if (this.f380595e != OverlayState.FADING_OUT) goto L39;
        k();
        return;
    L39:
        v();
    }

    public final void a() {
        if (this.f380592b != null) goto L5;
        return;
    L5:
        if (this.f380591a.isShown() == true) goto L8;
        return;
    L8:
        if (this.f380592b.getParent() != null) goto L11;
        this.f380592b.setVisibility(0);
        this.f380591a.addView(this.f380592b, 0, new FrameLayout.LayoutParams(-1, -1));
    L13:
        this.f380592b.setVisibility(0);
        k();
        return;
    L11:
        if (this.f380592b.getParent() == this.f380591a) goto L13;
    }

    public final void b() {
        if (this.f380596f == true) goto L5;
        return;
    L5:
        this.f380591a.setBackground(this.f380594d);
        this.f380594d = null;
        this.f380596f = false;
    }

    public final void c() {
        this.f380595e = OverlayState.HIDDEN;
        r();
        FlutterSurfaceView r100 = this.f380592b;
        if (r100 == null) goto L5;
        SurfaceSnapshotTracker r101 = r100.f380499b;
        r101.j();
        r101.f380609d = false;
        r101.f380606a.animate().cancel();
        r101.i();
    L5:
        this.f380597g = false;
        this.f380601k++;
        b();
        k r102 = this.f380593c;
        if (r102 == null) goto L14;
        r102.animate().cancel();
        this.f380593c.animate().setListener(null);
        k r103 = this.f380593c;
        r103.f380668b = null;
        r103.setLayerType(0, null);
        k r104 = this.f380593c;
        r104.f380668b = null;
        Bitmap r105 = r104.f380667a;
        if (r105 != null) goto L10;
    L12:
        r104.f380667a = null;
        r104.invalidate();
        this.f380591a.removeView(this.f380593c);
        this.f380593c = null;
        return;
    L10:
        if (r105.isRecycled() == true) goto L12;
        r104.f380667a.recycle();
        goto L12
    }

    public final void d() {
        if (this.f380593c == null) goto L5;
        return;
    L5:
        k r100 = new k(this.f380591a.getContext());
        this.f380593c = r100;
        r100.setAlpha(0.0f);
        this.f380591a.addView(this.f380593c, new FrameLayout.LayoutParams(-1, -1));
        k();
    }

    public final void e() {
        FlutterSurfaceView r100 = this.f380592b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getParent() != this.f380591a) goto L8;
        return;
    L8:
        if (this.f380592b.getParent() != null) goto L12;
        this.f380591a.addView(this.f380592b, 0, new FrameLayout.LayoutParams(-1, -1));
        return;
    }

    public final boolean g() {
        k r100 = this.f380593c;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.f380596f == false) goto L16;
        Bitmap r101 = r100.f380667a;
        if (r101 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r101.isRecycled() == true) goto L11;
        r102 = true;
        goto L12
    L16:
        return false;
    }

    public final void h() {
        this.f380595e = OverlayState.HIDDEN;
        r();
        this.f380597g = false;
        this.f380601k++;
        if (this.f380593c == null) goto L5;
        FlutterSurfaceView r100 = this.f380592b;
        if (r100 == null) goto L18;
        SurfaceSnapshotTracker r101 = r100.f380499b;
        r101.j();
        r101.f380609d = false;
        r101.f380606a.animate().cancel();
        r101.i();
        if (this.f380598h == false) goto L13;
        e();
    L13:
        FlutterSurfaceView r102 = this.f380592b;
        if (this.f380598h == false) goto L16;
        int r103 = 0;
    L17:
        r102.setVisibility(r103);
        goto L18
    L16:
        r103 = 4;
    L18:
        this.f380593c.animate().cancel();
        this.f380593c.animate().setListener(null);
        k r104 = this.f380593c;
        r104.f380668b = null;
        r104.setLayerType(0, null);
        this.f380593c.setVisibility(0);
        this.f380593c.setAlpha(0.0f);
        return;
    L5:
        if (this.f380598h == false) goto L20;
        e();
        return;
    }

    public final boolean j() {
        if (this.f380595e == OverlayState.HIDDEN) goto L5;
        return true;
    L5:
        return false;
    }

    public final void k() {
        k r100 = this.f380593c;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.bringToFront();
        this.f380593c.invalidate();
    }

    public final void l() {
        if (this.f380593c != null) goto L5;
        return;
    L5:
        if (this.f380595e == OverlayState.FOREGROUND_VISIBLE) goto L7;
        return;
    L7:
        if ((this.f380599i & 13) == 13) goto L10;
        return;
    L10:
        if (f(2) == false) goto L13;
        u(260);
        return;
    L13:
        if (this.f380602l != null) goto L21;
        r r100 = new r(this, this.f380600j);
        this.f380602l = r100;
        this.f380591a.postDelayed(r100, 800);
        return;
    }

    public final void m() {
        if (this.f380592b != null) goto L5;
        return;
    L5:
        this.f380597g = true;
        d();
        if (g() == true) goto L10;
        q();
        return;
    }

    public final void q() {
        if (this.f380592b != null) goto L5;
        return;
    L5:
        if (j() == true) goto L24;
        Bitmap r100 = this.f380592b.c();
        if (r100 == null) goto L23;
        d();
        b();
        s(false);
        k r101 = this.f380593c;
        if (r101.f380667a == r100) goto L12;
    L14:
        r101.f380668b = null;
        Bitmap r102 = r101.f380667a;
        if (r102 != null) goto L17;
    L19:
        r101.f380667a = null;
        r101.invalidate();
        r101.f380667a = r100;
        r101.invalidate();
    L20:
        this.f380593c.setVisibility(0);
        this.f380593c.setAlpha(0.0f);
        i(r100);
        return;
    L17:
        if (r102.isRecycled() == true) goto L19;
        r101.f380667a.recycle();
        goto L19
    L12:
        if (r100.isRecycled() == true) goto L14;
        r101.invalidate();
        goto L20
    L23:
        return;
    }

    public final void r() {
        Runnable r100 = this.f380602l;
        if (r100 == null) goto L6;
        this.f380591a.removeCallbacks(r100);
        this.f380602l = null;
    L6:
        this.f380599i = 0;
    }

    public final void t() {
        if (this.f380595e == OverlayState.FADING_OUT) goto L5;
        return;
    L5:
        this.f380595e = OverlayState.FOREGROUND_VISIBLE;
        s(true);
        k r100 = this.f380593c;
        if (r100 != null) goto L8;
        return;
    L8:
        r100.setVisibility(0);
        this.f380593c.invalidate();
        k();
    }

    public final void v() {
        k r100 = this.f380593c;
        if (r100 != null) goto L5;
        return;
    L5:
        OverlayState r101 = OverlayState.FOREGROUND_VISIBLE;
        this.f380595e = r101;
        r100.animate().cancel();
        this.f380593c.animate().setListener(null);
        this.f380593c.setVisibility(0);
        this.f380593c.setAlpha(1.0f);
        this.f380593c.invalidate();
        this.f380593c.requestLayout();
        p(true);
        if (f(8) == true) goto L13;
        final k r102 = this.f380593c;
        if (r102 == null) goto L13;
        if (this.f380595e != r101) goto L13;
        r102.f380668b = new q(this, r102);
        r102.invalidate();
    L13:
        FlutterSurfaceView r103 = this.f380592b;
        if (r103 == null) goto L22;
        SurfaceSnapshotTracker r104 = r103.f380499b;
        boolean r105 = r104.f380609d;
        r104.j();
        r104.f380609d = true;
        r104.f380606a.animate().cancel();
        r104.f380606a.setAlpha(0.0f);
        if (r105 == true) goto L18;
        r104.i();
    L18:
        int r106 = r104.f380614i;
        int r107 = r104.f380611f;
        if (r106 != r107) goto L21;
        r104.h(r107);
    L21:
        a();
    L22:
        k();
        this.f380593c.post(new l(this));
    }

    public SurfaceSnapshotController(FlutterView r100) {
        this.f380595e = OverlayState.HIDDEN;
        this.f380596f = false;
        this.f380597g = false;
        this.f380598h = false;
        this.f380599i = 0;
        this.f380600j = -1;
        this.f380601k = 0;
        this.f380591a = r100;
    }

    public final boolean f(int r100) {
        if ((r100 & this.f380599i) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void i(Bitmap r100) {
        if (r100.isRecycled() == false) goto L6;
        return;
    L6:
        if (this.f380596f == true) goto L8;
        this.f380594d = this.f380591a.getBackground();
        this.f380596f = true;
    L8:
        BitmapDrawable r101 = new BitmapDrawable(this.f380591a.getResources(), r100);
        r101.setGravity(119);
        this.f380591a.setBackground(r101);
    }

    public final void o(boolean r100) {
        OverlayState r101 = this.f380595e;
        OverlayState r102 = OverlayState.TASK_SNAPSHOT_VISIBLE;
        if (r101 != r102) goto L5;
        return;
    L5:
        if (g() == false) goto L21;
        FlutterSurfaceView r103 = this.f380592b;
        if (r103 == null) goto L18;
        SurfaceSnapshotTracker r104 = r103.f380499b;
        if (Build.VERSION.SDK_INT >= 30) goto L12;
        r104.getClass();
        goto L18
    L12:
        if (r104.f380606a.getContext().getApplicationInfo().targetSdkVersion < 30) goto L18;
        if (r104.f380610e == true) goto L18;
        r104.f380606a.setZOrderOnTop(true);
        r104.f380610e = true;
    L18:
        s(true);
        r();
        this.f380595e = r102;
        this.f380593c.setVisibility(0);
        this.f380593c.setAlpha(1.0f);
        p(true);
        k();
        w(r100);
        return;
    }

    public final void p(boolean r100) {
        final k r101 = this.f380593c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (j() == true) goto L8;
        return;
    L8:
        if (r101.getLayerType() == 2) goto L10;
        r101.setLayerType(2, null);
    L10:
        k();
        this.f380591a.invalidate();
        View r102 = this.f380591a.getRootView();
        if (r102 == null) goto L14;
        r102.invalidate();
    L14:
        if (r101.getWidth() > 0) goto L16;
        return;
    L16:
        if (r101.getHeight() > 0) goto L18;
        return;
    L18:
        if (com.lynx.clay.util.d.a(r101) == false) goto L32;
        r101.buildLayer();     // Catch: IllegalStateException -> L22
        return;
    L22:
        if (r100 == false) goto L30;
        r101.post(new m(this, r101));
        return;
    L30:
        return;
    }

    public final void s(boolean r100) {
        Runnable r101 = this.f380602l;
        if (r101 == null) goto L6;
        this.f380591a.removeCallbacks(r101);
        this.f380602l = null;
    L6:
        k r102 = this.f380593c;
        if (r102 != null) goto L9;
        return;
    L9:
        r102.animate().cancel();
        this.f380593c.animate().setListener(null);
        k r103 = this.f380593c;
        if (r100 == false) goto L12;
        float r104 = 1.0f;
    L13:
        r103.setAlpha(r104);
        return;
    L12:
        r104 = 0.0f;
        goto L13
    }

    public final void u(long r100) {
        OverlayState r101 = this.f380595e;
        OverlayState r102 = OverlayState.FADING_OUT;
        if (r101 != r102) goto L5;
        return;
    L5:
        Runnable r103 = this.f380602l;
        if (r103 == null) goto L9;
        this.f380591a.removeCallbacks(r103);
        this.f380602l = null;
    L9:
        this.f380595e = r102;
        if (this.f380592b == null) goto L13;
        a();
        SurfaceSnapshotTracker r104 = this.f380592b.f380499b;
        r104.j();
        r104.f380609d = false;
        r104.i();
        r104.f380606a.animate().cancel();
        r104.f380606a.setAlpha(1.0f);
        k();
    L13:
        a r105 = new a(this, this.f380600j);
        this.f380602l = r105;
        this.f380591a.postDelayed(r105, r100);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.lynx.clay.embedding.android.o, java.lang.Runnable] */
    public final void w(final boolean r100) {
        final k r101 = this.f380593c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f380595e != OverlayState.TASK_SNAPSHOT_VISIBLE) goto L21;
        final int r102 = this.f380601k + 1;
        this.f380601k = r102;
        final ?? r103 = new o(this, r102, r101, r100);
        ViewTreeObserver r104 = this.f380591a.getViewTreeObserver();
        if (Build.VERSION.SDK_INT >= 29) goto L10;
    L14:
        r101.postOnAnimation(new p(r101, r103));
    L15:
        r101.invalidate();
        this.f380591a.invalidate();
        View r105 = this.f380591a.getRootView();
        if (r105 == null) goto L20;
        r105.invalidate();
        return;
    L20:
        return;
    L10:
        if (this.f380591a.isHardwareAccelerated() == false) goto L14;
        if (r104.isAlive() == false) goto L14;
        b.a(r104, r103);
        goto L15
    }
}
