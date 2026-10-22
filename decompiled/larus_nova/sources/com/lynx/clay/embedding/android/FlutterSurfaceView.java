package com.lynx.clay.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: classes32.dex */
public class FlutterSurfaceView extends SurfaceView implements s5a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f380498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SurfaceSnapshotTracker f380499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f380500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f380501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FlutterRenderer f380502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f380503f;

    public class a implements SurfaceHolder.Callback2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlutterSurfaceView f380504a;

        public a(FlutterSurfaceView r100) {
            this.f380504a = r100;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder r100) {
            c5a.c.e();
            FlutterSurfaceView r101 = this.f380504a;
            r101.f380500c = true;
            SurfaceSnapshotTracker r102 = r101.f380499b;
            r102.f380611f++;
            r102.f380613h = -1;
            r102.f380614i = -1;
            r102.f380615j = -1;
            r102.i();
            r102.c();
            c r103 = r102.f380619n;
            if (r103 == null) goto L10;
            SurfaceSnapshotController r104 = (SurfaceSnapshotController) r103;
            r104.f380600j = r102.f380611f;
            r104.t();
            r104.r();
            if (r104.f380595e != SurfaceSnapshotController.OverlayState.FOREGROUND_VISIBLE) goto L8;
            r104.v();
            goto L10
        L8:
            if (r104.j() == false) goto L10;
            r104.k();
        L10:
            FlutterSurfaceView r105 = this.f380504a;
            if (r105.f380501d == false) goto L14;
            r105.f();
            this.f380504a.d();
            return;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder r100) {
            c5a.c.e();
            FlutterSurfaceView r101 = this.f380504a;
            r101.f380500c = false;
            r101.e();
            SurfaceSnapshotTracker r102 = this.f380504a.f380499b;
            r102.j();
            r102.f380613h = -1;
            r102.f380614i = -1;
            r102.f380615j = -1;
            r102.i();
            r102.c();
            c r103 = r102.f380619n;
            if (r103 == null) goto L25;
            SurfaceSnapshotController r104 = (SurfaceSnapshotController) r103;
            if (r102.f380611f != r104.f380600j) goto L25;
            r104.f380600j = -1;
            r104.t();
            r104.r();
            if (r104.f380597g == false) goto L10;
        L11:
            SurfaceSnapshotController.OverlayState r105 = r104.f380595e;
            SurfaceSnapshotController.OverlayState r106 = SurfaceSnapshotController.OverlayState.ARMED_FOR_FOREGROUND;
            if (r105 == r106) goto L25;
            if (r104.g() == false) goto L25;
            if (r104.f380595e != SurfaceSnapshotController.OverlayState.TASK_SNAPSHOT_VISIBLE) goto L19;
            boolean r107 = true;
        L20:
            r104.s(r107);
            r104.r();
            r104.f380595e = r106;
            r104.f380593c.setVisibility(0);
            k r108 = r104.f380593c;
            if (r107 == false) goto L23;
            float r109 = 1.0f;
        L24:
            r108.setAlpha(r109);
            r104.k();
            goto L25
        L23:
            r109 = 0.0f;
            goto L24
        L19:
            r107 = false;
            goto L20
        L10:
            if (r104.f380595e == SurfaceSnapshotController.OverlayState.TASK_SNAPSHOT_VISIBLE) goto L11;
        L25:
            FlutterSurfaceView r110 = this.f380504a;
            if (r110.f380501d == false) goto L32;
            r110.setAlpha(0.0f);
            FlutterRenderer r111 = this.f380504a.f380502e;
            if (r111 == null) goto L31;
            r111.b(true);
            return;
        L31:
            throw new IllegalStateException("disconnectRenderSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }

        @Override // android.view.SurfaceHolder.Callback2
        public final void surfaceRedrawNeeded(SurfaceHolder r100) {
            this.f380504a.f380499b.g(null);
        }

        @Override // android.view.SurfaceHolder.Callback2
        public final void surfaceRedrawNeededAsync(SurfaceHolder r100, Runnable r101) {
            this.f380504a.f380499b.g(r101);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
            c5a.c.e();
            FlutterSurfaceView r104 = this.f380504a;
            if (r104.f380501d == true) goto L5;
            return;
        L5:
            if (r104.f380502e == null) goto L8;
            c5a.c.e();
            r104.f380502e.f380933a.onSurfaceChanged(r102, r103);
            return;
        L8:
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
    }

    public class b implements s5a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlutterSurfaceView f380505a;

        @Override // s5a.b
        public final void a() {
        }

        @Override // s5a.b
        public final void b() {
            SurfaceSnapshotTracker r100 = this.f380505a.f380499b;
            int r101 = r100.f380612g;
            FlutterSurfaceView r102 = r100.f380606a;
            if (r102.f380500c == false) goto L29;
            if (r101 <= 0) goto L29;
            if (r101 != r100.f380611f) goto L29;
            if (r100.f380613h == r101) goto L12;
            SurfaceSnapshotTracker.FlutterUiDisplayResult r103 = SurfaceSnapshotTracker.FlutterUiDisplayResult.WAITING_FOR_SURFACE_CONNECTION;
        L31:
            if (r103 != SurfaceSnapshotTracker.FlutterUiDisplayResult.WAITING_FOR_SURFACE_CONNECTION) goto L33;
            return;
        L33:
            this.f380505a.e();
            if (r103 == SurfaceSnapshotTracker.FlutterUiDisplayResult.DISPLAYED) goto L36;
            return;
        L36:
            c5a.c.e();
            return;
        L12:
            if (r100.f380609d == false) goto L14;
            float r104 = 0.0f;
        L15:
            r102.setAlpha(r104);
            r100.f380614i = r101;
            c r105 = r100.f380619n;
            if (r105 == null) goto L28;
            final SurfaceSnapshotController r106 = (SurfaceSnapshotController) r105;
            if (r101 != r106.f380600j) goto L28;
            if (r106.j() == false) goto L23;
            r106.f380599i |= 1;
            r106.k();
            r106.l();
            goto L28
        L23:
            if (r106.g() == true) goto L28;
            if (r106.f380591a.hasWindowFocus() == false) goto L28;
            r106.f380591a.post(new n(r106));
        L28:
            r100.h(r101);
            r100.d(r101);
            r100.f380612g = -1;
            r103 = SurfaceSnapshotTracker.FlutterUiDisplayResult.DISPLAYED;
            goto L31
        L14:
            r104 = 1.0f;
        L29:
            r100.f380612g = -1;
            r103 = SurfaceSnapshotTracker.FlutterUiDisplayResult.REJECTED;
            goto L31
        }

        public b(FlutterSurfaceView r100) {
            this.f380505a = r100;
        }
    }

    public interface c {
    }

    @Override // s5a.c
    public final void b() {
        if (this.f380502e != null) goto L5;
        c5a.c.d(5, "FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
        return;
    L5:
        if (getWindowToken() == null) goto L11;
        c5a.c.e();
        FlutterRenderer r100 = this.f380502e;
        if (r100 == null) goto L10;
        r100.b(false);
        goto L11
    L10:
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    L11:
        setAlpha(0.0f);
        e();
        this.f380502e = null;
        this.f380501d = false;
        SurfaceSnapshotTracker r101 = this.f380499b;
        r101.j();
        r101.f380613h = -1;
        r101.f380614i = -1;
        r101.f380615j = -1;
        r101.i();
        r101.f380617l = Double.NaN;
        r101.c();
    }

    public final Bitmap c() {
        SurfaceSnapshotTracker r100 = this.f380499b;
        FlutterRenderer r101 = this.f380502e;
        if (r101 != null) goto L5;
        r100.getClass();
    L33:
        return null;
    L5:
        if (r100.f380614i != r100.f380611f) goto L33;
        Bitmap r102 = r101.f380933a.getBitmap();     // Catch: RuntimeException -> L30
        if (r102 != null) goto L11;
        c5a.c.d(5, "FlutterSurfaceSnapshot", "Flutter surface snapshot capture returned null.");     // Catch: RuntimeException -> L30
        goto L33
    L11:
        if (r102.isRecycled() == false) goto L13;
        c5a.c.d(5, "FlutterSurfaceSnapshot", "Flutter surface snapshot capture returned a recycled bitmap.");     // Catch: RuntimeException -> L30
        goto L33
    L13:
        int r103 = r102.getWidth();     // Catch: RuntimeException -> L30
        int r104 = r102.getHeight();     // Catch: RuntimeException -> L30
        long r105 = ((long) r103) * ((long) r104);     // Catch: RuntimeException -> L30
        if (r103 <= 0) goto L28;
        if (r104 <= 0) goto L28;
        if (r105 <= 921600) goto L28;
        double r106 = Math.sqrt(921600.0d / r105);     // Catch: RuntimeException -> L30
        Bitmap r107 = Bitmap.createScaledBitmap(r102, Math.max(1, (int) Math.floor(((double) r103) * r106)), Math.max(1, (int) Math.floor(((double) r104) * r106)), true);     // Catch: OutOfMemoryError -> L24 Throwable -> L26
        if (r107 == r102) goto L23;
        r102.recycle();     // Catch: OutOfMemoryError -> L24 Throwable -> L26
    L23:
        r102 = r107;
    L26:
        e = move-exception;
        c5a.c.f("FlutterSurfaceSnapshot", "Failed to downscale Flutter surface snapshot.", e);     // Catch: RuntimeException -> L30
    L28:
        r100.f380617l = SurfaceSnapshotTracker.b(r102);     // Catch: RuntimeException -> L30
        return r102;
    L30:
        e = move-exception;
        c5a.c.f("FlutterSurfaceSnapshot", "Failed to cache current Flutter surface frame.", e);
        goto L33
    }

    public final void d() {
        if (this.f380502e == null) goto L9;
        if (getHolder() == null) goto L9;
        SurfaceSnapshotTracker r100 = this.f380499b;
        r100.f380613h = r100.f380611f;
        this.f380502e.a(getHolder().getSurface(), true);
        return;
    L9:
        throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
    }

    public final void e() {
        FlutterRenderer r100 = this.f380502e;
        if (r100 == null) goto L5;
        b r101 = this.f380503f;
        r100.f380933a.removeIsDisplayingFlutterUiListener(r101);
    L5:
        this.f380499b.f380612g = -1;
    }

    public final void f() {
        SurfaceSnapshotTracker r100 = this.f380499b;
        r100.f380606a.setAlpha(0.0f);
        r100.f380614i = -1;
        r100.f380612g = r100.f380611f;
        r100.f380613h = -1;
        FlutterRenderer r101 = this.f380502e;
        if (r101 == null) goto L8;
        b r102 = this.f380503f;
        r101.f380933a.removeIsDisplayingFlutterUiListener(r102);
        FlutterRenderer r103 = this.f380502e;
        b r104 = this.f380503f;
        r103.f380933a.addIsDisplayingFlutterUiListener(r104);
        if (r103.f380936d == false) goto L9;
        r104.b();
        return;
    L9:
        return;
    }

    @Override // s5a.c
    public final void pause() {
        if (this.f380502e == null) goto L5;
        e();
        this.f380502e = null;
        this.f380501d = false;
        SurfaceSnapshotTracker r100 = this.f380499b;
        r100.j();
        r100.f380613h = -1;
        r100.f380614i = -1;
        r100.f380615j = -1;
        r100.i();
        r100.f380617l = Double.NaN;
        r100.c();
        return;
    L5:
        c5a.c.d(5, "FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
    }

    @Override // s5a.c
    public FlutterRenderer getAttachedRenderer() {
        return this.f380502e;
    }

    public FlutterSurfaceView(Context r100) {
        this(r100, null, false);
    }

    @Override // s5a.c
    public final void a(FlutterRenderer r100) {
        c5a.c.e();
        if (this.f380502e == null) goto L5;
        c5a.c.e();
        e();
        this.f380502e.b(false);
    L5:
        this.f380502e = r100;
        this.f380501d = true;
        if (this.f380500c == false) goto L8;
        c5a.c.e();
        f();
        d();
        return;
    L8:
        setAlpha(0.0f);
    }

    @Override // android.view.SurfaceView, android.view.View
    public final boolean gatherTransparentRegion(Region r110) {
        if (getAlpha() >= 1.0f) goto L5;
        return false;
    L5:
        int[] r100 = new int[2];
        getLocationInWindow(r100);
        int r101 = r100[0];
        r110.op(r101, r100[1], (getRight() + r101) - getLeft(), (r100[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    public void setSurfaceSnapshotDelegate(c r100) {
        this.f380499b.f380619n = r100;
    }

    public FlutterSurfaceView(Context r100, AttributeSet r101) {
        this(r100, r101, false);
    }

    public FlutterSurfaceView(Context r100, AttributeSet r101, boolean r102) {
        super(r100, r101);
        this.f380500c = false;
        this.f380501d = false;
        a r103 = new a(this);
        this.f380503f = new b(this);
        this.f380498a = r102;
        this.f380499b = new SurfaceSnapshotTracker(this);
        if (r102 == false) goto L5;
        getHolder().setFormat(-2);
        setZOrderOnTop(true);
        setZOrderMediaOverlay(true);
    L5:
        getHolder().addCallback(r103);
        setAlpha(0.0f);
    }
}
