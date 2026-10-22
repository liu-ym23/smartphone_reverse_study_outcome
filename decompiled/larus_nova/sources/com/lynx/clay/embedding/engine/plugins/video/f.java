package com.lynx.clay.embedding.engine.plugins.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.lynx.clay.embedding.android.FlutterView;

/* JADX INFO: loaded from: classes32.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SurfaceTexture f380930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Surface f380931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f380932c;

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final int c() {
        return 1;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void detach() {
        a r100 = this.f380932c;
        if (r100 == null) goto L5;
        r100.setSurface(null);
        this.f380932c = null;
    L5:
        Surface r101 = this.f380931b;
        if (r101 == null) goto L9;
        r101.release();
        this.f380931b = null;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void dispose() {
        detach();
    }

    public f(SurfaceTexture r100) {
        this.f380930a = r100;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void a(FlutterView r100, a r101) {
        if (r100.getAttachedFlutterEngine() != null) goto L5;
        return;
    L5:
        this.f380932c = r101;
        Surface r102 = new Surface(this.f380930a);
        this.f380931b = r102;
        r101.setSurface(r102);
        c5a.c.c("VideoRendererTexture", "attached to view");
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void b(int r100, int r101, int r102, int r103) {
        a r104 = this.f380932c;
        if (r104 == null) goto L6;
        r104.e();
        return;
    }
}
