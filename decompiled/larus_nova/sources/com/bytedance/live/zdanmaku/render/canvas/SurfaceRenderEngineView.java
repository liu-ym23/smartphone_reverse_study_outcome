package com.bytedance.live.zdanmaku.render.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.SurfaceHolder;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.live.artist.render.RenderRequest;
import com.bytedance.live.zdanmaku.render.canvas.surface.BaseSurfaceView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00078\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u000f8\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/live/zdanmaku/render/canvas/SurfaceRenderEngineView;", "Lcom/bytedance/live/zdanmaku/render/canvas/surface/BaseSurfaceView;", "Lcom/bytedance/live/artist/render/c;", "Ljava/lang/Runnable;", "block", "", "setCoroutineBlock", "Lcom/bytedance/live/artist/render/RenderRequest;", "renderRequest", "setRenderRequest", "<set-?>", "b", "Lcom/bytedance/live/artist/render/RenderRequest;", "getRenderRequest", "()Lcom/bytedance/live/artist/render/RenderRequest;", "Landroid/view/Choreographer$FrameCallback;", "h", "Landroid/view/Choreographer$FrameCallback;", "getFrameTask", "()Landroid/view/Choreographer$FrameCallback;", "setFrameTask", "(Landroid/view/Choreographer$FrameCallback;)V", "frameTask", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "zdanmaku_release"}, k = 1, mv = {1, 4, 0})
public class SurfaceRenderEngineView extends BaseSurfaceView implements com.bytedance.live.artist.render.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f255873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RenderRequest f255874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PthreadHandlerThreadV2 f255875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f255876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f255877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f255878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f255879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Choreographer.FrameCallback f255880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f255881i;

    public static final class a {
    }

    public static final class b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SurfaceRenderEngineView f255882a;

        public b(SurfaceRenderEngineView r100) {
            this.f255882a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            SurfaceRenderEngineView r101 = this.f255882a;
            long r102 = r101.f255877e;
            if (r102 <= 0) goto L5;
            r101.f255878f = (r100 - r102) / 1000000;
        L5:
            r101.f255877e = r100;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public static final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SurfaceRenderEngineView f255883a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            final SurfaceRenderEngineView r101 = this.f255883a;
            r101.getClass();
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.what != 1) goto L36;
            SystemClock.elapsedRealtime();
            if (r101.f255879g == true) goto L33;
        L10:
            final Canvas r102 = null;
        L11:
            if (r102 != null) goto L31;
        L23:
            SystemClock.elapsedRealtime();
            Runnable r103 = r101.f255873a;
            if (r103 == null) goto L37;
            r103.run();
            return;
        L37:
            return;
        L31:
            r102.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L27
            RenderRequest r104 = r101.f255874b;     // Catch: Throwable -> L27
            if (r104 == null) goto L15;
            r104.a(new SurfaceRenderEngineView$render$3(r101, r102));     // Catch: Throwable -> L27
        L15:
            RenderRequest r105 = r101.f255874b;     // Catch: Throwable -> L27
            if (r105 == null) goto L29;
            r105.f254843b = r101.f255878f;     // Catch: Throwable -> L27
        L29:
            if (r101.f255879g == false) goto L23;
            r101.getHolder().unlockCanvasAndPost(r102);     // Catch: Throwable -> L22
            goto L23
        L33:
            r102 = r101.getHolder().lockCanvas();     // Catch: Throwable -> L28
        }

        public c(Looper r100, SurfaceRenderEngineView r101) {
            this.f255883a = r101;
            super(r100);
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SurfaceRenderEngineView f255884a;

        public d(SurfaceRenderEngineView r100) {
            this.f255884a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Choreographer.getInstance().postFrameCallback(this.f255884a.getFrameTask());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e extends CoroutineDispatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SurfaceRenderEngineView f255885a;

        public e(SurfaceRenderEngineView r100) {
            this.f255885a = r100;
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public final void dispatch(CoroutineContext r100, Runnable r101) {
            SurfaceRenderEngineView.d(this.f255885a, r101);
            System.nanoTime();
            c r102 = this.f255885a.f255876d;
            if (r102 == null) goto L6;
            r102.sendEmptyMessage(1);
            return;
        }
    }

    static {
    }

    public SurfaceRenderEngineView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SurfaceRenderEngineView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.live.artist.render.c
    public final Object a(RenderRequest r100, Continuation<? super Unit> r101) {
        return e(this, r100, r101);
    }

    @Override // com.bytedance.live.artist.render.c
    public final void b() {
    }

    @Override // com.bytedance.live.artist.render.c
    public final void c() {
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("Zdanmaku_Surface_Render");
        this.f255875c = r100;
        ThreadMethodProxy.start(r100);
        c r101 = new c(r100.getLooper(), this);
        this.f255876d = r101;
        r101.post(new d(this));
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Choreographer.getInstance().removeFrameCallback(getFrameTask());
        c r100 = this.f255876d;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
    L5:
        PthreadHandlerThreadV2 r101 = this.f255875c;
        if (r101 == null) goto L9;
        r101.quit();
        return;
    }

    public Choreographer.FrameCallback getFrameTask() {
        return this.f255880h;
    }

    public final RenderRequest getRenderRequest() {
        return this.f255874b;
    }

    private final void setCoroutineBlock(Runnable r100) {
        this.f255873a = r100;
    }

    public void setFrameTask(Choreographer.FrameCallback r100) {
        this.f255880h = r100;
    }

    public void setRenderRequest(RenderRequest r100) {
        this.f255874b = r100;
    }

    @Override // com.bytedance.live.zdanmaku.render.canvas.surface.BaseSurfaceView, android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
        this.f255879g = true;
    }

    @Override // com.bytedance.live.zdanmaku.render.canvas.surface.BaseSurfaceView, android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        this.f255879g = false;
    }

    public static final /* synthetic */ void d(SurfaceRenderEngineView r100, Runnable r101) {
        r100.setCoroutineBlock(r101);
    }

    public SurfaceRenderEngineView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        getHolder().setFormat(-3);
        setZOrderOnTop(true);
        this.f255880h = new b(this);
        this.f255881i = new e(this);
    }

    public static /* synthetic */ Object e(SurfaceRenderEngineView r100, RenderRequest r101, Continuation r102) {
        if ((r102 instanceof SurfaceRenderEngineView$render$1) == false) goto L7;
        SurfaceRenderEngineView$render$1 r103 = (SurfaceRenderEngineView$render$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        RenderRequest r108 = (RenderRequest) r103.L$1;
        r100 = (SurfaceRenderEngineView) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        r100.setCoroutineBlock(null);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r100.setRenderRequest(r101);
        e r109 = r100.f255881i;
        SurfaceRenderEngineView$render$2 r110 = new SurfaceRenderEngineView$render$2(null);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        if (BuildersKt.withContext(r109, r110, r103) != r106) goto L17;
        return r106;
    L7:
        r103 = new SurfaceRenderEngineView$render$1(r100, r102);
        goto L8
    }

    public /* synthetic */ SurfaceRenderEngineView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
