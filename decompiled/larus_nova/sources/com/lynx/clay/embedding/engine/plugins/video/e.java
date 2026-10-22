package com.lynx.clay.embedding.engine.plugins.video;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.lynx.clay.embedding.android.FlutterSurfaceView;
import com.lynx.clay.embedding.android.FlutterTextureView;
import com.lynx.clay.embedding.android.FlutterView;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FlutterView f380927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f380928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f380929c;

    public e() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final int c() {
        return 0;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void detach() {
        View r100 = this.f380928b;
        if (r100 != null) goto L5;
    L7:
        this.f380928b = null;
        this.f380927a = null;
        a r101 = this.f380929c;
        if (r101 == null) goto L11;
        r101.c();
        this.f380929c = null;
        return;
    L11:
        return;
    L5:
        if (r100.getParent() == null) goto L7;
        ((ViewGroup) r100.getParent()).removeView(r100);
        goto L7
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void dispose() {
        detach();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void a(FlutterView r100, a r101) {
        this.f380927a = r100;
        View r102 = r101.createView(r100.getContext());
        this.f380928b = r102;
        if (r102 == null) goto L11;
        ViewParent r103 = r102.getParent();
        if (r103 == r100) goto L11;
        if (r103 == null) goto L10;
        ((ViewGroup) r103).removeView(r102);
    L10:
        r100.addView(r102, -1);
    L11:
        View r104 = r100.getChildAt(0);
        if ((r104 instanceof FlutterSurfaceView) == false) goto L14;
    L15:
        r104.bringToFront();
    L16:
        this.f380929c = r101;
        return;
    L14:
        if ((r104 instanceof FlutterTextureView) == false) goto L16;
        goto L15
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void b(int r100, int r101, int r102, int r103) {
        if (this.f380927a != null) goto L5;
        return;
    L5:
        if (this.f380928b == null) goto L23;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(r102, r103);     // Catch: Throwable -> L13
        r104.leftMargin = r100;     // Catch: Throwable -> L13
        r104.topMargin = r101;     // Catch: Throwable -> L13
        this.f380928b.setLayoutParams(r104);     // Catch: Throwable -> L13
        View r105 = this.f380927a.getChildAt(0);     // Catch: Throwable -> L13
        if ((r105 instanceof FlutterSurfaceView) == false) goto L9;
    L10:
        r105.bringToFront();     // Catch: Throwable -> L13
    L11:
        this.f380928b.setVisibility(0);     // Catch: Throwable -> L13
    L15:
        a r106 = this.f380929c;
        if (r106 == null) goto L18;
        r106.e();
    L18:
        this.f380928b.requestLayout();
        return;
    L9:
        if ((r105 instanceof FlutterTextureView) == false) goto L11;
    L13:
        th = move-exception;
        c5a.c.d(6, "VideoRendererHybrid", "onDisplay " + th);
        goto L15
    }
}
