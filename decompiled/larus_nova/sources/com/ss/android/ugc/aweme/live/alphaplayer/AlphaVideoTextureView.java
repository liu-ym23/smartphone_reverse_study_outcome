package com.ss.android.ugc.aweme.live.alphaplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;
import com.ss.android.ugc.aweme.live.alphaplayer.render.IRender;
import com.ss.android.ugc.aweme.live.alphaplayer.render.VideoRenderer;
import java.util.List;
import wgc.b;

/* JADX INFO: loaded from: classes40.dex */
public class AlphaVideoTextureView extends GLTextureView implements IAlphaVideoView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f450986m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f450987n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f450988o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DataSource.ScaleType f450989p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public IRender f450990q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public IPlayerController f450991r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Surface f450992s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public EventHelper f450993t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f450994u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public IPlayerController.OnElementClickListener f450995v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f450996w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final IRender.SurfaceListener f450997x;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.live.alphaplayer.AlphaVideoTextureView$5, reason: invalid class name */
    public class AnonymousClass5 implements IRender.SurfaceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlphaVideoTextureView f451006a;

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.render.IRender.SurfaceListener
        public final int b() {
            return this.f451006a.f450991r.a();
        }

        public AnonymousClass5(AlphaVideoTextureView r100) {
            this.f451006a = r100;
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.render.IRender.SurfaceListener
        public final void a(Surface r100) {
            if (r100.isValid() == false) goto L17;
            Surface r101 = this.f451006a.f450992s;
            if (r101 == null) goto L8;
            r101.release();
        L8:
            AlphaVideoTextureView r102 = this.f451006a;
            r102.f450992s = r100;
            r102.f450986m = true;
            AlphaVideoTextureView r103 = this.f451006a;     // Catch: Exception -> L11
            r103.f450991r.setSurface(r103.f450992s);     // Catch: Exception -> L11
        L13:
            this.f451006a.f450991r.resume();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            goto L13
        }
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public View getView() {
        return this;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public final void onCompletion() {
        VideoRenderer r100 = (VideoRenderer) this.f450990q;
        r100.f451229n.compareAndSet(true, false);
        r100.f451229n.get();
        r100.f451232q.requestRender();
        r100.g();
        r100.B = null;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public final void onFirstFrame() {
        VideoRenderer r100 = (VideoRenderer) this.f450990q;
        r100.f451230o.set(0);
        r100.f451229n.compareAndSet(false, true);
        r100.f451229n.get();
        r100.f451232q.requestRender();
        r100.F = true;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public final void release() {
        IRender.SurfaceListener r100 = this.f450997x;
        if (r100 == null) goto L8;
        AnonymousClass5 r101 = (AnonymousClass5) r100;
        Surface r102 = r101.f451006a.f450992s;
        if (r102 == null) goto L7;
        r102.release();
    L7:
        r101.f451006a.f450986m = false;
        r101.f451006a.f450992s = null;
    L8:
        IRender r103 = this.f450990q;
        if (r103 == null) goto L12;
        ((VideoRenderer) r103).e();
        return;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.GLTextureView, android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        g(new AnonymousClass4(this));
    }

    @Override // android.view.View
    public final boolean performClick() {
        return super.performClick();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public final boolean a() {
        return this.f450986m;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public boolean getLastFrameHold() {
        return this.f450994u;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public DataSource.ScaleType getScaleType() {
        return this.f450989p;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public final boolean b(ViewGroup r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        r100.removeView(this);
        return true;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public final boolean d(ViewGroup r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        ViewGroup r101 = (ViewGroup) getParent();
        if (r101 != r100) goto L8;
        return true;
    L8:
        b(r101);
        if (r100.indexOfChild(this) != (-1)) goto L12;
        r100.addView(this);
        return true;
    L12:
        return false;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public final void e(final List<MaskSrc> r100) {
        g(new AnonymousClass3(this, r100));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f450996w == false) goto L13;
        if (this.f450995v == null) goto L13;
        EventHelper r101 = this.f450993t;
        if (r101 == null) goto L13;
        if (r101.a(this, r100) == false) goto L13;
        return true;
    L13:
        return super.onTouchEvent(r100);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setConfigParams(final DataSource.DataInfo r100) {
        this.f450989p = r100.f451136b;
        if (this.f450990q != null) goto L5;
        return;
    L5:
        g(new AnonymousClass1(this, r100));
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setEnableElementEvent(boolean r100) {
        this.f450996w = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setFirstGLFrameListener(IPlayerController.FirstGLFrameListener r100) {
        ((VideoRenderer) this.f450990q).E = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setLastFrameHold(boolean r100) {
        this.f450994u = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setOnElementClickListener(IPlayerController.OnElementClickListener r100) {
        this.f450995v = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setPlayerController(IPlayerController r100) {
        this.f450991r = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setVideoRenderer(IRender r100) {
        this.f450990q = r100;
        this.f450993t = new EventHelper(r100, new b(this));
        setRenderer(r100);
        IRender r101 = this.f450990q;
        if (r101 == null) goto L5;
        ((VideoRenderer) r101).f451231p = this.f450997x;
    L5:
        setRenderMode(0);
    }

    public AlphaVideoTextureView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f450996w = false;
        AnonymousClass5 r102 = new AnonymousClass5(this);
        this.f450997x = r102;
        if (isInEditMode() == true) goto L9;
        setEGLContextClientVersion(2);
        setEGLConfigChooser(new GLTextureView.ComponentSizeChooser(this, 8, 16));
        IRender r103 = this.f450990q;
        if (r103 == null) goto L7;
        ((VideoRenderer) r103).f451231p = r102;
    L7:
        setPreserveEGLContextOnPause(true);
        setOpaque(false);
        return;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public final void c(float r100, float r101) {
        if (r100 <= 0.0f) goto L8;
        if (r101 <= 0.0f) goto L8;
        this.f450987n = r100;
        this.f450988o = r101;
    L8:
        if (this.f450990q != null) goto L10;
        return;
    L10:
        final float r102 = getMeasuredWidth();
        final float r103 = getMeasuredHeight();
        g(new AnonymousClass2(this, r102, r103));
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        c(this.f450987n, this.f450988o);
    }
}
