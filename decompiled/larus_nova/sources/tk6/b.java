package tk6;

import android.graphics.Canvas;

/* JADX INFO: loaded from: classes19.dex */
public class b<T> extends of6.c<T> implements com.bytedance.live.zdanmaku.render.canvas.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Canvas f546532f;

    @Override // com.bytedance.live.zdanmaku.render.canvas.d
    public final void b(Canvas r100) {
        this.f546532f = r100;
        Object r101 = this.f523105c;
        if ((r101 instanceof com.bytedance.live.zdanmaku.render.canvas.d) == true) goto L5;
        r101 = null;
    L5:
        com.bytedance.live.zdanmaku.render.canvas.d r102 = (com.bytedance.live.zdanmaku.render.canvas.d) r101;
        if (r102 == null) goto L9;
        r102.b(r100);
        return;
    }

    public b(Object r100, e r101) {
        super(r100, r101);
    }
}
