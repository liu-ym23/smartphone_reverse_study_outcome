package com.ss.android.videoshop.mediaview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes40.dex */
public class TextureContainerLayout extends FrameLayout implements cjc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextureVideoView f456023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f456024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f456025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f456026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f456027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f456028f;

    @Override // cjc.c
    public ViewGroup getVideoContainer() {
        return this;
    }

    @Override // cjc.c
    public final void c() {
        this.f456024b.setVisibility(8);
        this.f456024b.setImageBitmap(null);
    }

    public final void d() {
        TextureVideoView r100 = this.f456023a;
        int r101 = Build.VERSION.SDK_INT;
        float r102 = 1.0f;
        if (r101 < 26) goto L39;
        String r103 = Build.MODEL;
        if (r103.equals("TAH-AN00") == false) goto L8;
    L33:
        boolean r104 = true;
    L35:
        if (r101 != 29) goto L38;
        if (r104 == true) goto L39;
    L38:
        r102 = 0.99f;
        goto L39
    L8:
        if (r103.equals("TAH-N29") == true) goto L33;
        if (r103.equals("RLI-AN00") == true) goto L33;
        if (r103.equals("RLI-N29") == true) goto L33;
        if (r103.equals("TAH-AN00m") == true) goto L33;
        if (r103.equals("RHA-AN00m") == true) goto L33;
        if (r103.equals("MRX-AL09") == true) goto L33;
        if (r103.equals("MRX-AL19") == true) goto L33;
        if (r103.equals("MRX-AN19") == true) goto L33;
        if (r103.equals("MRX-W09") == true) goto L33;
        if (r103.equals("IN2010") == true) goto L33;
        if (r103.equals("SM-G9650") == true) goto L33;
        if (r103.equals("MRX-W19") == true) goto L33;
        r104 = false;
    L39:
        r100.setAlpha(r102);
    }

    @Override // cjc.c
    public int getVideoHeight() {
        return this.f456023a.getVideoHeight();
    }

    @Override // cjc.c
    public int getVideoViewMarginTop() {
        TextureVideoView r100 = this.f456023a;
        if (r100 == null) goto L8;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        return -1;
    L7:
        return ((ViewGroup.MarginLayoutParams) r101).topMargin;
    L8:
        return -1;
    }

    @Override // cjc.c
    public int getVideoWidth() {
        return this.f456023a.getVideoWidth();
    }

    @Override // cjc.c
    public View getBlackCoverView() {
        return this.f456025c;
    }

    public cjc.b getGestureTargetView() {
        return this.f456023a;
    }

    @Override // cjc.c
    public int getTextureLayout() {
        return this.f456028f;
    }

    public TextureVideoView getTextureVideoView() {
        return this.f456023a;
    }

    @Override // cjc.c
    public a getVideoView() {
        return this.f456023a;
    }

    public TextureContainerLayout(Context r100) {
        super(r100);
        this.f456028f = 0;
        e(r100);
    }

    @Override // cjc.c
    public final void a(int r100) {
        this.f456028f = r100;
        TextureVideoView r101 = this.f456023a;
        if (r101 == null) goto L6;
        r101.f456037i.h(r100);
        return;
    }

    @Override // cjc.c
    public final void b(Bitmap r100) {
        if (r100 == null) goto L5;
        this.f456024b.setImageBitmap(r100);
        this.f456024b.setVisibility(0);
        return;
    }

    public final void e(Context r100) {
        setClipChildren(false);
        this.f456023a = new TextureVideoView(r100);
        d();
        setBackgroundColor(-16777216);
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -1);
        r101.gravity = 17;
        addView(this.f456023a, r101);
        ImageView r102 = new ImageView(r100);
        this.f456024b = r102;
        addView(r102, new FrameLayout.LayoutParams(-1, -1));
        UIUtils.setViewVisibility(this.f456024b, 8);
        UIUtils.setViewVisibility(this.f456023a, 8);
        View r103 = new View(r100);
        this.f456025c = r103;
        r103.setBackgroundColor(-16777216);
        addView(this.f456025c, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // cjc.c
    public void setCropStrategy(gjc.a r100) {
        this.f456023a.setCropStrategy(r100);
    }

    @Override // cjc.c
    public void setOptimizeBlackSide(boolean r100) {
        TextureVideoView r101 = this.f456023a;
        if (r101 == null) goto L6;
        r101.setOptimizeBlackSide(r100);
        return;
    }

    @Override // cjc.c
    public void setOptimizeNormalFillScreen(boolean r100) {
        TextureVideoView r101 = this.f456023a;
        if (r101 == null) goto L6;
        r101.setOptimizeNormalFillScreen(r100);
        return;
    }

    public void setTextureLayout(int r100) {
        a(r100);
    }

    @Override // cjc.c
    public void setZoomingEnabled(boolean r100) {
        TextureVideoView r101 = this.f456023a;
        if (r101 == null) goto L6;
        r101.setZoomingEnabled(r100);
        return;
    }

    public TextureContainerLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f456028f = 0;
        e(r100);
    }

    @Override // cjc.c
    public final void setVideoSize(int r100, int r101) {
        if (this.f456026d == r100) goto L5;
    L6:
        this.f456026d = r100;
        this.f456027e = r101;
        ajc.b.a("TextureContainerLayout", "setVideoSize videoWidth:" + r100 + " videoHeight:" + r101);
        TextureVideoView r102 = this.f456023a;
        if (r102 == null) goto L11;
        r102.f456037i.i(r100, r101);
        return;
    L11:
        return;
    L5:
        if (this.f456027e != r101) goto L6;
    }

    public TextureContainerLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f456028f = 0;
        e(r100);
    }
}
