package com.bytedance.live.zdanmaku.render.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.live.artist.render.RenderRequest;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import vk6.g;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/live/zdanmaku/render/canvas/CanvasRenderEngineView;", "Lcom/bytedance/live/zdanmaku/render/canvas/RenderEngineView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zdanmaku_release"}, k = 1, mv = {1, 4, 0})
public final class CanvasRenderEngineView extends RenderEngineView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.live.artist.utils.b f255863h;

    public CanvasRenderEngineView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CanvasRenderEngineView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.live.zdanmaku.render.canvas.RenderEngineView
    public final void g(Canvas r100, RenderRequest r101) {
        com.bytedance.live.artist.utils.b r102 = this.f255863h;
        CanvasRenderEngineView$render$1 r103 = new CanvasRenderEngineView$render$1(this, r101, r100);
        r102.f254856a.put("renderAllUnits", Long.valueOf(System.nanoTime()));
        r103.invoke();
        r102.a("renderAllUnits");
    }

    public CanvasRenderEngineView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        g r103 = g.f555528a;
        this.f255863h = new com.bytedance.live.artist.utils.b();
    }

    public /* synthetic */ CanvasRenderEngineView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
