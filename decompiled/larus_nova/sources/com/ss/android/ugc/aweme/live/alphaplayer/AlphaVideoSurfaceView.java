package com.ss.android.ugc.aweme.live.alphaplayer;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.SurfaceViewHacker;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;
import com.ss.android.ugc.aweme.live.alphaplayer.render.IRender;
import com.ss.android.ugc.aweme.live.alphaplayer.render.VideoRenderer;
import java.util.List;
import wgc.a;

/* JADX INFO: loaded from: classes40.dex */
public class AlphaVideoSurfaceView extends GLSurfaceView implements IAlphaVideoView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile NewInstanceCallback f450965m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f450966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f450967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f450968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DataSource.ScaleType f450969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IRender f450970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IPlayerController f450971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Surface f450972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EventHelper f450973h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f450974i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f450975j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IPlayerController.OnElementClickListener f450976k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final IRender.SurfaceListener f450977l;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.live.alphaplayer.AlphaVideoSurfaceView$5, reason: invalid class name */
    public class AnonymousClass5 implements IRender.SurfaceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlphaVideoSurfaceView f450985a;

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.render.IRender.SurfaceListener
        public final int b() {
            return this.f450985a.f450971f.a();
        }

        public AnonymousClass5(AlphaVideoSurfaceView r100) {
            this.f450985a = r100;
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.render.IRender.SurfaceListener
        public final void a(Surface r100) {
            if (r100.isValid() == false) goto L17;
            Surface r101 = this.f450985a.f450972g;
            if (r101 == null) goto L8;
            r101.release();
        L8:
            AlphaVideoSurfaceView r102 = this.f450985a;
            r102.f450972g = r100;
            r102.f450966a = true;
            AlphaVideoSurfaceView r103 = this.f450985a;     // Catch: Exception -> L11
            r103.f450971f.setSurface(r103.f450972g);     // Catch: Exception -> L11
        L13:
            this.f450985a.f450971f.resume();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            goto L13
        }
    }

    public interface NewInstanceCallback {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public View getView() {
        return this;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public final void onCompletion() {
        VideoRenderer r100 = (VideoRenderer) this.f450970e;
        r100.f451229n.compareAndSet(true, false);
        r100.f451229n.get();
        r100.f451232q.requestRender();
        r100.g();
        r100.B = null;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public final void onFirstFrame() {
        VideoRenderer r100 = (VideoRenderer) this.f450970e;
        r100.f451230o.set(0);
        r100.f451229n.compareAndSet(false, true);
        r100.f451229n.get();
        r100.f451232q.requestRender();
        r100.F = true;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public final void release() {
        IRender.SurfaceListener r100 = this.f450977l;
        if (r100 == null) goto L8;
        AnonymousClass5 r101 = (AnonymousClass5) r100;
        Surface r102 = r101.f450985a.f450972g;
        if (r102 == null) goto L7;
        r102.release();
    L7:
        r101.f450985a.f450966a = false;
        r101.f450985a.f450972g = null;
    L8:
        IRender r103 = this.f450970e;
        if (r103 == null) goto L12;
        ((VideoRenderer) r103).e();
        return;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        queueEvent(new AnonymousClass4());
    }

    @Override // android.view.View
    public final boolean performClick() {
        return super.performClick();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public final boolean a() {
        return this.f450966a;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public boolean getLastFrameHold() {
        return this.f450974i;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public DataSource.ScaleType getScaleType() {
        return this.f450969d;
    }

    public static void setNewInstanceCallback(NewInstanceCallback r100) {
        f450965m = r100;
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
        queueEvent(new AnonymousClass3(this, r100));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f450975j == false) goto L13;
        if (this.f450976k == null) goto L13;
        EventHelper r101 = this.f450973h;
        if (r101 == null) goto L13;
        if (r101.a(this, r100) == false) goto L13;
        return true;
    L13:
        return super.onTouchEvent(r100);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setConfigParams(final DataSource.DataInfo r100) {
        this.f450969d = r100.f451136b;
        if (this.f450970e != null) goto L5;
        return;
    L5:
        queueEvent(new AnonymousClass1(this, r100));
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setEnableElementEvent(boolean r100) {
        this.f450975j = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setFirstGLFrameListener(IPlayerController.FirstGLFrameListener r100) {
        ((VideoRenderer) this.f450970e).E = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setLastFrameHold(boolean r100) {
        this.f450974i = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setOnElementClickListener(IPlayerController.OnElementClickListener r100) {
        this.f450976k = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setPlayerController(IPlayerController r100) {
        this.f450971f = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public void setVideoRenderer(IRender r100) {
        this.f450970e = r100;
        this.f450973h = new EventHelper(r100, new a(this));
        setRenderer(r100);
        IRender r101 = this.f450970e;
        if (r101 == null) goto L5;
        ((VideoRenderer) r101).f451231p = this.f450977l;
    L5:
        setRenderMode(0);
    }

    public AlphaVideoSurfaceView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f450975j = false;
        AnonymousClass5 r102 = new AnonymousClass5(this);
        this.f450977l = r102;
        NewInstanceCallback r103 = f450965m;
        if (r103 == null) goto L6;
        ((SurfaceViewHacker.a) r103).a(this);
    L6:
        if (isInEditMode() == true) goto L12;
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(-3);
        IRender r104 = this.f450970e;
        if (r104 == null) goto L10;
        ((VideoRenderer) r104).f451231p = r102;
    L10:
        setZOrderOnTop(true);
        setPreserveEGLContextOnPause(true);
        return;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.IAlphaVideoView
    public final void c(float r100, float r101) {
        if (r100 <= 0.0f) goto L8;
        if (r101 <= 0.0f) goto L8;
        this.f450967b = r100;
        this.f450968c = r101;
    L8:
        if (this.f450970e != null) goto L10;
        return;
    L10:
        final float r102 = getMeasuredWidth();
        final float r103 = getMeasuredHeight();
        queueEvent(new AnonymousClass2(this, r102, r103));
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        c(this.f450967b, this.f450968c);
    }
}
