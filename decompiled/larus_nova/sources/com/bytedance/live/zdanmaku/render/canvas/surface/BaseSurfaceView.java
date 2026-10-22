package com.bytedance.live.zdanmaku.render.canvas.surface;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB%\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/live/zdanmaku/render/canvas/surface/BaseSurfaceView;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zdanmaku_release"}, k = 1, mv = {1, 4, 0})
public class BaseSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
    }

    public void surfaceCreated(SurfaceHolder r100) {
    }

    public void surfaceDestroyed(SurfaceHolder r100) {
    }

    public BaseSurfaceView(Context r100) {
        super(r100);
        getHolder().addCallback(this);
    }

    public BaseSurfaceView(Context r100, AttributeSet r101) {
        super(r100, r101);
        getHolder().addCallback(this);
    }

    public BaseSurfaceView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        getHolder().addCallback(this);
    }
}
