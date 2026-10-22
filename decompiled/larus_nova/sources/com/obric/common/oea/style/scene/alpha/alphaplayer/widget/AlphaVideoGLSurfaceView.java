package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.amap.api.col.s.ce;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A¢\u0006\u0004\bC\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u001a\u0010\u0015\u001a\u00020\u00108\u0006X\u0086D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\"\u0010(\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010/\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00106\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006E"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Ltja/a;", "Landroid/view/View;", "getView", "Loja/b;", "playerController", "", "setPlayerController", "Lrja/a;", "renderer", "setVideoRenderer", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "scaleType", "setScaleType", "getScaleType", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getGL_CONTEXT_VERSION", "()I", "GL_CONTEXT_VERSION", "", "c", FaceService.girlLabel, "getMVideoWidth", "()F", "setMVideoWidth", "(F)V", "mVideoWidth", "d", "getMVideoHeight", "setMVideoHeight", "mVideoHeight", "e", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "getMScaleType", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "setMScaleType", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;)V", "mScaleType", "f", "Lrja/a;", "getMRenderer", "()Lrja/a;", "setMRenderer", "(Lrja/a;)V", "mRenderer", ce.f26391f, "Loja/b;", "getMPlayerController", "()Loja/b;", "setMPlayerController", "(Loja/b;)V", "mPlayerController", "Landroid/view/Surface;", "h", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mSurface", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaVideoGLSurfaceView extends GLSurfaceView implements tja.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f396587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f396588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f396589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f396590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ScaleType f396591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public rja.a f396592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public oja.b f396593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Surface f396594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f396595i;

    public static final class a implements rja.a.InterfaceC7494a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlphaVideoGLSurfaceView f396596a;

        public a(AlphaVideoGLSurfaceView r100) {
            this.f396596a = r100;
        }

        @Override // rja.a.InterfaceC7494a
        public final void a(Surface r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            Surface r101 = this.f396596a.getMSurface();
            if (r101 == null) goto L5;
            r101.release();
        L5:
            this.f396596a.setMSurface(r100);
            this.f396596a.f396588b = true;
            oja.b r102 = this.f396596a.getMPlayerController();
            if (r102 == null) goto L8;
            r102.a(r100);
        L8:
            oja.b r103 = this.f396596a.getMPlayerController();
            if (r103 == null) goto L12;
            r103.resume();
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rja.a f396597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f396598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f396599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AlphaVideoGLSurfaceView f396600d;

        public b(rja.a r100, int r101, int r102, AlphaVideoGLSurfaceView r103) {
            this.f396597a = r100;
            this.f396598b = r101;
            this.f396599c = r102;
            this.f396600d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f396597a.h(this.f396598b, this.f396599c, this.f396600d.getMVideoWidth(), this.f396600d.getMVideoHeight());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public View getView() {
        return this;
    }

    @Override // tja.a
    public final void onCompletion() {
        rja.a r100 = this.f396592f;
        if (r100 == null) goto L6;
        r100.onCompletion();
        return;
    }

    @Override // tja.a
    public final void onFirstFrame() {
        rja.a r100 = this.f396592f;
        if (r100 == null) goto L6;
        r100.onFirstFrame();
        return;
    }

    @Override // tja.a
    public final void release() {
        a r100 = this.f396595i;
        Surface r101 = r100.f396596a.getMSurface();
        if (r101 == null) goto L5;
        r101.release();
    L5:
        r100.f396596a.setMSurface(null);
        r100.f396596a.f396588b = false;
    }

    @Override // tja.a
    public final boolean a() {
        return this.f396588b;
    }

    public final int getGL_CONTEXT_VERSION() {
        return this.f396587a;
    }

    public final oja.b getMPlayerController() {
        return this.f396593g;
    }

    public final rja.a getMRenderer() {
        return this.f396592f;
    }

    public final ScaleType getMScaleType() {
        return this.f396591e;
    }

    public final Surface getMSurface() {
        return this.f396594h;
    }

    public final float getMVideoHeight() {
        return this.f396590d;
    }

    public final float getMVideoWidth() {
        return this.f396589c;
    }

    @Override // tja.a
    public ScaleType getScaleType() {
        return this.f396591e;
    }

    public AlphaVideoGLSurfaceView(Context r100) {
        this(r100, null);
    }

    @Override // tja.a
    public final void b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        r100.removeView(this);
    }

    @Override // tja.a
    public final void d(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        if (r100.indexOfChild(this) != (-1)) goto L9;
        ViewParent r101 = getParent();
        if (r101 == null) goto L7;
        ((ViewGroup) r101).removeView(this);
    L7:
        r100.addView(this);
        return;
    }

    public final void setMPlayerController(oja.b r100) {
        this.f396593g = r100;
    }

    public final void setMRenderer(rja.a r100) {
        this.f396592f = r100;
    }

    public final void setMScaleType(ScaleType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f396591e = r100;
    }

    public final void setMSurface(Surface r100) {
        this.f396594h = r100;
    }

    public final void setMVideoHeight(float r100) {
        this.f396590d = r100;
    }

    public final void setMVideoWidth(float r100) {
        this.f396589c = r100;
    }

    @Override // tja.a
    public void setPlayerController(oja.b r100) {
        Intrinsics.checkNotNullParameter(r100, "playerController");
        this.f396593g = r100;
    }

    public void setScaleType(ScaleType r100) {
        Intrinsics.checkNotNullParameter(r100, "scaleType");
        this.f396591e = r100;
        rja.a r101 = this.f396592f;
        if (r101 == null) goto L6;
        r101.m(r100);
        return;
    }

    @Override // tja.a
    public void setVideoRenderer(rja.a r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f396592f = r100;
        setRenderer(r100);
        rja.a r101 = this.f396592f;
        if (r101 == null) goto L5;
        r101.f(this.f396595i);
    L5:
        setRenderMode(0);
    }

    public AlphaVideoGLSurfaceView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f396587a = 2;
        this.f396591e = ScaleType.ScaleAspectFill;
        a r102 = new a(this);
        this.f396595i = r102;
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(-3);
        rja.a r103 = this.f396592f;
        if (r103 == null) goto L5;
        r103.f(r102);
    L5:
        setZOrderOnTop(true);
        setPreserveEGLContextOnPause(true);
    }

    @Override // tja.a
    public final void c(float r100, float r101) {
        float r102 = 0;
        if (r100 > r102) goto L5;
    L7:
        rja.a r103 = this.f396592f;
        if (r103 == null) goto L11;
        queueEvent(new b(r103, getMeasuredWidth(), getMeasuredHeight(), this));
        return;
    L11:
        return;
    L5:
        if (r101 <= r102) goto L7;
        this.f396589c = r100;
        this.f396590d = r101;
        goto L7
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        c(this.f396589c, this.f396590d);
    }
}
