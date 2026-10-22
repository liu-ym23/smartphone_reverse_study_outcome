package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLTextureView;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/GLTextureView;", "Ltja/a;", "Landroid/view/View;", "getView", "Loja/b;", "playerController", "", "setPlayerController", "Lrja/a;", "renderer", "setVideoRenderer", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "scaleType", "setScaleType", "getScaleType", "q", "Loja/b;", "getMPlayerController", "()Loja/b;", "setMPlayerController", "(Loja/b;)V", "mPlayerController", "Landroid/view/Surface;", "r", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mSurface", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaVideoGLTextureView extends GLTextureView implements tja.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f396601l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f396602m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f396603n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ScaleType f396604o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public rja.a f396605p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public oja.b f396606q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Surface f396607r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final a f396608s;

    public static final class a implements rja.a.InterfaceC7494a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlphaVideoGLTextureView f396609a;

        public a(AlphaVideoGLTextureView r100) {
            this.f396609a = r100;
        }

        @Override // rja.a.InterfaceC7494a
        public final void a(Surface r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            Surface r101 = this.f396609a.getMSurface();
            if (r101 == null) goto L5;
            r101.release();
        L5:
            this.f396609a.setMSurface(r100);
            this.f396609a.f396601l = true;
            oja.b r102 = this.f396609a.getMPlayerController();
            if (r102 == null) goto L8;
            r102.a(r100);
        L8:
            oja.b r103 = this.f396609a.getMPlayerController();
            if (r103 == null) goto L12;
            r103.resume();
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rja.a f396610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f396611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f396612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AlphaVideoGLTextureView f396613d;

        public b(rja.a r100, int r101, int r102, AlphaVideoGLTextureView r103) {
            this.f396610a = r100;
            this.f396611b = r101;
            this.f396612c = r102;
            this.f396613d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            rja.a r100 = this.f396610a;     // Catch: Throwable -> L4
            float r101 = this.f396611b;     // Catch: Throwable -> L4
            float r102 = this.f396612c;     // Catch: Throwable -> L4
            AlphaVideoGLTextureView r103 = this.f396613d;     // Catch: Throwable -> L4
            r100.h(r101, r102, r103.f396602m, r103.f396603n);     // Catch: Throwable -> L4
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
        rja.a r100 = this.f396605p;
        if (r100 == null) goto L6;
        r100.onCompletion();
        return;
    }

    @Override // tja.a
    public final void onFirstFrame() {
        rja.a r100 = this.f396605p;
        if (r100 == null) goto L6;
        r100.onFirstFrame();
        return;
    }

    @Override // tja.a
    public final void release() {
        a r100 = this.f396608s;
        Surface r101 = r100.f396609a.getMSurface();
        if (r101 == null) goto L5;
        r101.release();
    L5:
        r100.f396609a.setMSurface(null);
        r100.f396609a.f396601l = false;
    }

    @Override // tja.a
    public final boolean a() {
        return this.f396601l;
    }

    public final oja.b getMPlayerController() {
        return this.f396606q;
    }

    public final Surface getMSurface() {
        return this.f396607r;
    }

    @Override // tja.a
    public ScaleType getScaleType() {
        return this.f396604o;
    }

    public AlphaVideoGLTextureView(Context r100) {
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
        this.f396606q = r100;
    }

    public final void setMSurface(Surface r100) {
        this.f396607r = r100;
    }

    @Override // tja.a
    public void setPlayerController(oja.b r100) {
        Intrinsics.checkNotNullParameter(r100, "playerController");
        this.f396606q = r100;
    }

    public void setScaleType(ScaleType r100) {
        Intrinsics.checkNotNullParameter(r100, "scaleType");
        this.f396604o = r100;
        rja.a r101 = this.f396605p;
        if (r101 == null) goto L6;
        r101.m(r100);
        return;
    }

    @Override // tja.a
    public void setVideoRenderer(rja.a r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f396605p = r100;
        setRenderer(r100);
        rja.a r101 = this.f396605p;
        if (r101 == null) goto L5;
        r101.f(this.f396608s);
    L5:
        setRenderMode(0);
    }

    public AlphaVideoGLTextureView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f396604o = ScaleType.ScaleAspectFill;
        a r102 = new a(this);
        this.f396608s = r102;
        setEGLContextClientVersion(2);
        setEGLConfigChooser(new GLTextureView.b(this, 8, 16));
        rja.a r103 = this.f396605p;
        if (r103 == null) goto L5;
        r103.f(r102);
    L5:
        setPreserveEGLContextOnPause(true);
        setOpaque(false);
    }

    @Override // tja.a
    public final void c(float r100, float r101) {
        float r102 = 0;
        if (r100 > r102) goto L5;
    L7:
        rja.a r103 = this.f396605p;
        if (r103 == null) goto L17;
        b r104 = new b(r103, getMeasuredWidth(), getMeasuredHeight(), this);
        GLTextureView.i r105 = this.f396616b;
        r105.getClass();
        GLTextureView.j r106 = GLTextureView.f396614k;
        monitor-enter(r106);
        r105.K.add(r104);     // Catch: Throwable -> L14
        r106.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r106);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        return;
    L5:
        if (r101 <= r102) goto L7;
        this.f396602m = r100;
        this.f396603n = r101;
        goto L7
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        c(this.f396602m, this.f396603n);
    }
}
