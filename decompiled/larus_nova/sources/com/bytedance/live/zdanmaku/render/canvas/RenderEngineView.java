package com.bytedance.live.zdanmaku.render.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.live.artist.render.RenderRequest;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import vk6.f;
import vk6.g;
import vk6.h;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/live/zdanmaku/render/canvas/RenderEngineView;", "Landroid/view/View;", "Lcom/bytedance/live/artist/render/c;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "setCoroutineBlock", "Lcom/bytedance/live/artist/render/RenderRequest;", "renderRequest", "setRenderRequest", "<set-?>", "b", "Lcom/bytedance/live/artist/render/RenderRequest;", "getRenderRequest", "()Lcom/bytedance/live/artist/render/RenderRequest;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "zdanmaku_release"}, k = 1, mv = {1, 4, 0})
public abstract class RenderEngineView extends View implements com.bytedance.live.artist.render.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f255864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RenderRequest f255865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f255866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f255867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f255868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f255869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f255870g;

    public static final class a {
    }

    public static final class b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RenderEngineView f255871a;

        public b(RenderEngineView r100) {
            this.f255871a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            RenderEngineView r101 = this.f255871a;
            long r102 = r101.f255867d;
            if (r102 <= 0) goto L5;
            r101.f255868e = (r100 - r102) / 1000000;
        L5:
            r101.f255867d = r100;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public static final class c extends CoroutineDispatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RenderEngineView f255872a;

        public c(RenderEngineView r100) {
            this.f255872a = r100;
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public final void dispatch(CoroutineContext r100, Runnable r101) {
            RenderEngineView.d(this.f255872a, r101);
            this.f255872a.postInvalidateOnAnimation();
        }
    }

    static {
    }

    public RenderEngineView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RenderEngineView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.live.artist.render.c
    public final Object a(RenderRequest r100, Continuation<? super Unit> r101) {
        return h(this, r100, r101);
    }

    @Override // com.bytedance.live.artist.render.c
    public final void b() {
        setCoroutineBlock(null);
    }

    @Override // com.bytedance.live.artist.render.c
    public final void c() {
    }

    public void e(Canvas r100) {
    }

    public void f(Canvas r100) {
    }

    public abstract void g(Canvas r100, RenderRequest r101);

    public boolean k() {
        return true;
    }

    public final void i() {
        if (k() == false) goto L5;
        f r100 = this.f255866c;
        r100.getClass();
        Choreographer.getInstance().postFrameCallback(r100.f555526c);
        return;
    L5:
        Choreographer.getInstance().postFrameCallback(this.f255869f);
    }

    public final void j() {
        if (k() == false) goto L5;
        f r100 = this.f255866c;
        r100.getClass();
        Choreographer.getInstance().removeFrameCallback(r100.f555526c);
        return;
    L5:
        Choreographer.getInstance().removeFrameCallback(this.f255869f);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    public final RenderRequest getRenderRequest() {
        return this.f255865b;
    }

    private final void setCoroutineBlock(Runnable r100) {
        if (r100 == null) goto L4;
        h r101 = new h(r100);
    L5:
        this.f255864a = r101;
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);     // Catch: Throwable -> L18
        f(r100);     // Catch: Throwable -> L18
        RenderRequest r101 = this.f255865b;     // Catch: Throwable -> L18
        if (r101 == null) goto L6;
        g(r100, r101);     // Catch: Throwable -> L18
    L6:
        if (k() == false) goto L10;
        RenderRequest r102 = this.f255865b;     // Catch: Throwable -> L18
        if (r102 == null) goto L13;
        r102.f254843b = this.f255866c.f555525b;     // Catch: Throwable -> L18
    L13:
        e(r100);     // Catch: Throwable -> L18
        h r103 = this.f255864a;     // Catch: Throwable -> L18
        if (r103 == null) goto L16;
        r103.run();     // Catch: Throwable -> L18
    L16:
        System.currentTimeMillis();     // Catch: Throwable -> L18
        return;
    L10:
        RenderRequest r104 = this.f255865b;     // Catch: Throwable -> L18
        if (r104 == null) goto L13;
        r104.f254843b = this.f255868e;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        g r105 = g.f555528a;
        th.getMessage();
    }

    public void setRenderRequest(RenderRequest r100) {
        this.f255865b = r100;
    }

    public static final /* synthetic */ void d(RenderEngineView r100, Runnable r101) {
        r100.setCoroutineBlock(r101);
    }

    public RenderEngineView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f255866c = new f();
        this.f255869f = new b(this);
        this.f255870g = new c(this);
    }

    public static /* synthetic */ Object h(RenderEngineView r100, RenderRequest r101, Continuation r102) {
        if ((r102 instanceof RenderEngineView$render$1) == false) goto L7;
        RenderEngineView$render$1 r103 = (RenderEngineView$render$1) r102;
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
        r100 = (RenderEngineView) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        r100.setCoroutineBlock(null);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r100.setRenderRequest(r101);
        c r109 = r100.f255870g;
        RenderEngineView$render$2 r110 = new RenderEngineView$render$2(null);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        if (BuildersKt.withContext(r109, r110, r103) != r106) goto L17;
        return r106;
    L7:
        r103 = new RenderEngineView$render$1(r100, r102);
        goto L8
    }

    public /* synthetic */ RenderEngineView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
