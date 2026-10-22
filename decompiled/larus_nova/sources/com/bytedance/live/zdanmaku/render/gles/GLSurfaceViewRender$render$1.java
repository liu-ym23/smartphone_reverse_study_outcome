package com.bytedance.live.zdanmaku.render.gles;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@"}, d2 = {"Lcom/bytedance/live/artist/render/RenderRequest;", "renderRequest", "Lkotlin/coroutines/Continuation;", "", "continuation", "", ChameleonOpenTracker.Stage.RENDER}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "com.bytedance.live.zdanmaku.render.gles.GLSurfaceViewRender", f = "GLSurfaceViewRender.kt", i = {0, 0}, l = {47}, m = "render$suspendImpl", n = {"this", "renderRequest"}, s = {"L$0", "L$1"})
public final class GLSurfaceViewRender$render$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GLSurfaceViewRender this$0;

    public GLSurfaceViewRender$render$1(GLSurfaceViewRender r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return GLSurfaceViewRender.e(this.this$0, null, this);
    }
}
