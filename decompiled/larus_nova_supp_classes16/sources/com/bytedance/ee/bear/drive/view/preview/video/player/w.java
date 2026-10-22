package com.bytedance.ee.bear.drive.view.preview.video.player;

import android.content.Context;
import android.os.SystemClock;
import android.view.Surface;
import android.view.TextureView;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import com.bytedance.ee.bear.middleground.drive.export.player.view.VideoSurfaceView;
import com.bytedance.lark.lark_markdown_render_android.BuildConfig;
import com.ss.ttvideoengine.TTVideoEngine;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w extends e {
    public VideoSurfaceView n;
    public Surface o;

    public class a implements VideoSurfaceView.a {
        public final /* synthetic */ w a;

        public a(w r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.player.e
    public final void release() {
        tt5.a.h("TTVideoPlayer", BuildConfig.BUILD_TYPE);
        this.a.setSurface(null);
        VideoSurfaceView r0 = this.n;
        if (r0 == null) goto L8;
        TextureView r1 = r0.c;
        if (r1 == null) goto L7;
        r1.setSurfaceTextureListener(null);
    L7:
        this.n = null;
    L8:
        super.release();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.video.player.e
    public final void start() {
        tt5.a.h("TTVideoPlayer", BatterySceneData.OPT_START);
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L6;
        tt5.a.h("TTVideoPlayer", "start, videoEngine is null.");
        return;
    L6:
        this.i = SystemClock.elapsedRealtime();
        if (r0.getPlaybackState() != 1) goto L11;
        tt5.a.h("TTVideoPlayer", "start, player is already playing.");
        return;
    L11:
        if (this.o != null) goto L14;
        tt5.a.h("TTVideoPlayer", "start, surface not set.");
        return;
    L14:
        r0.play();
    }

    public w(Context r1) {
        super(r1);
    }

    public final void l(VideoSurfaceView r4) {
        if (r4 != null) goto L5;
        tt5.a.d("TTVideoPlayer", "setVideoSurfaceView, videoSurfaceView == null");
        return;
    L5:
        this.n = r4;
        a r0 = new a(this);
        if (r4.b == null) goto L8;
        tt5.a.h("VideoSurfaceView", "useSurface, reuse current surface");
        Surface r5 = r4.b;
        this.o = r5;
        this.a.setSurface(r5);
        start();
        return;
    L8:
        r4.c.setSurfaceTextureListener(new com.bytedance.ee.bear.middleground.drive.export.player.view.a(r4, r0));
    }
}
