package com.lynx.clay.embedding.engine;

import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.clay.embedding.android.FlutterImageView;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.android.FunctorView;
import com.lynx.clay.plugin.platform.PlatformViewsController;

/* JADX INFO: loaded from: classes32.dex */
public class FlutterOverlaySurface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterImageView f380702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PlatformViewsController f380703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FunctorView f380704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f380705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f380706e;

    public final View a() {
        if (this.f380706e == false) goto L7;
        return this.f380702a;
    L7:
        if (this.f380704c != null) goto L12;
        if (this.f380705d == 0) goto L12;
        FunctorView r100 = new FunctorView(this.f380703b.f380945c.getContext());
        this.f380704c = r100;
        r100.setSharedImageSink(this.f380705d);
        this.f380704c.setAlpha(1.0f);
    L12:
        return this.f380704c;
    }

    public void dispose() {
        if (this.f380706e == false) goto L6;
        this.f380702a.b();
        this.f380702a.f380490a.close();
        return;
    L6:
        FunctorView r100 = this.f380704c;
        if (r100 == null) goto L9;
        r100.setAlpha(0.0f);
        this.f380704c.invalidate();
        this.f380704c.g();
    L9:
        this.f380705d = 0;
    }

    public Surface getSurface() {
        return this.f380702a.getSurface();
    }

    public boolean onSurfaceUpdated() {
        if (this.f380706e == true) goto L5;
        FunctorView r100 = this.f380704c;
        if (r100 != null) goto L9;
        return false;
    L9:
        r100.l();
        this.f380704c.postInvalidateOnAnimation();
        return true;
    L5:
        return this.f380702a.c(false);
    }

    public void bringToFront() {
        a().bringToFront();
    }

    public void removeFromParent() {
        ViewGroup r100 = (ViewGroup) a().getParent();
        if (r100 == null) goto L6;
        r100.removeView(a());
        return;
    }

    public FlutterOverlaySurface(FlutterImageView r100) {
        this.f380706e = false;
        this.f380706e = true;
        this.f380702a = r100;
        this.f380703b = null;
    }

    public static FlutterOverlaySurface createWithImageView(PlatformViewsController r100) {
        FlutterView r101 = r100.f380945c;
        FlutterImageView r102 = new FlutterImageView(r101.getContext(), r101.getWidth(), r101.getHeight(), FlutterImageView.SurfaceKind.overlay);
        FlutterEngine r103 = r101.f380531r;
        if (r103 == null) goto L6;
        r102.a(r103.f380695b);
    L6:
        return new FlutterOverlaySurface(r102);
    }

    public FlutterOverlaySurface(PlatformViewsController r100, long r101) {
        this.f380706e = false;
        this.f380706e = false;
        this.f380703b = r100;
        this.f380705d = r101;
        this.f380702a = null;
    }

    public static FlutterOverlaySurface createWithFunctorView(PlatformViewsController r100, long r101) {
        return new FlutterOverlaySurface(r100, r101);
    }
}
