package com.bytedance.live.zdanmaku.render.gles;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.bytedance.live.artist.render.RenderRequest;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0017\u0018\u0019B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002R(\u0010\u000b\u001a\b\u0018\u00010\nR\u00020\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/live/zdanmaku/render/gles/GLSurfaceViewRender;", "Landroid/opengl/GLSurfaceView;", "Lcom/bytedance/live/artist/render/c;", "Ljava/lang/Runnable;", "block", "", "setCoroutineBlock", "Lcom/bytedance/live/artist/render/RenderRequest;", "renderRequest", "setRenderRequest", "Lcom/bytedance/live/zdanmaku/render/gles/GLSurfaceViewRender$b;", ChameleonOpenTracker.Stage.RENDER, "Lcom/bytedance/live/zdanmaku/render/gles/GLSurfaceViewRender$b;", "getRender", "()Lcom/bytedance/live/zdanmaku/render/gles/GLSurfaceViewRender$b;", "setRender", "(Lcom/bytedance/live/zdanmaku/render/gles/GLSurfaceViewRender$b;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "zdanmaku_release"}, k = 1, mv = {1, 4, 0})
public abstract class GLSurfaceViewRender extends GLSurfaceView implements com.bytedance.live.artist.render.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f255889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f255890b;

    public static final class a {
    }

    public final class b implements GLSurfaceView.Renderer {
    }

    public static final class c {
    }

    public static final class d extends CoroutineDispatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GLSurfaceViewRender f255891a;

        public d(GLSurfaceViewRender r100) {
            this.f255891a = r100;
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public final void dispatch(CoroutineContext r100, Runnable r101) {
            GLSurfaceViewRender.d(this.f255891a, r101);
            this.f255891a.postInvalidateOnAnimation();
        }
    }

    static {
    }

    private final void setRenderRequest(RenderRequest r100) {
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

    public final b getRender() {
        return null;
    }

    public final void setRender(b r100) {
    }

    private final void setCoroutineBlock(Runnable r100) {
        this.f255889a = r100;
    }

    public GLSurfaceViewRender(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f255890b = new d(this);
    }

    public static final /* synthetic */ void d(GLSurfaceViewRender r100, Runnable r101) {
        r100.setCoroutineBlock(r101);
    }

    public static /* synthetic */ Object e(GLSurfaceViewRender r100, RenderRequest r101, Continuation r102) {
        if ((r102 instanceof GLSurfaceViewRender$render$1) == false) goto L7;
        GLSurfaceViewRender$render$1 r103 = (GLSurfaceViewRender$render$1) r102;
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
        r100 = (GLSurfaceViewRender) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        r100.setCoroutineBlock(null);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r100.setRenderRequest(r101);
        r100.requestRender();
        d r109 = r100.f255890b;
        GLSurfaceViewRender$render$2 r110 = new GLSurfaceViewRender$render$2(null);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        if (BuildersKt.withContext(r109, r110, r103) != r106) goto L17;
        return r106;
    L7:
        r103 = new GLSurfaceViewRender$render$1(r100, r102);
        goto L8
    }
}
