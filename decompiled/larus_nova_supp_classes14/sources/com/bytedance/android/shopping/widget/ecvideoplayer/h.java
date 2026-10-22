package com.bytedance.android.shopping.widget.ecvideoplayer;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.utils.Error;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements da3.b, b {
    public ECVideoView a;
    public ECVideoPlayer b;
    public da3.d c;

    public h() {
    }

    public final void f() {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onIdle() {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void E() {
        da3.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.E();
        return;
    }

    public final void a() {
        ECVideoPlayer r0 = this.b;
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    public final void b() {
        ECVideoPlayer r0 = this.b;
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public final void c() {
        ECVideoPlayer r0 = this.b;
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void g() {
        da3.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public final int getWatchedDuration() {
        ECVideoPlayer r0 = this.b;
        if (r0 == null) goto L8;
        TTVideoEngine r1 = r0.a;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getWatchedDuration();
    L8:
        return 0;
    }

    public final boolean isPlaying() {
        ECVideoPlayer r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.e() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onPaused() {
        da3.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.onPaused();
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onPlaying() {
        da3.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.onPlaying();
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onRelease() {
        da3.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.onRelease();
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onRenderStart() {
        da3.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.onRenderStart();
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void w() {
        da3.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.w();
        return;
    }

    public final View getView() {
        return this.a;
    }

    public final void e(da3.d r1) {
        this.c = r1;
    }

    public final ECVideoView initialize(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ECVideoView r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ECVideoView r1 = new ECVideoView(r5, null, 6, 0);
        this.a = r1;
        ECVideoPlayer r2 = new ECVideoPlayer(r5);
        r2.a(this);
        this.b = r2;
        ECVideoView r6 = this.a;
        if (r6 == null) goto L8;
        r6.setPlayer(r2);
    L8:
        return r1;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onError(Error r4) {
        da3.d r0 = this.c;
        if (r0 == null) goto L12;
        String r1 = null;
        if (r4 == null) goto L7;
        Integer r2 = Integer.valueOf(r4.code);
    L8:
        if (r4 == null) goto L10;
        r1 = r4.description;
    L10:
        r0.onError(r2, r1);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void release(boolean r1) {
        ECVideoPlayer r2 = this.b;
        if (r2 == null) goto L5;
        r2.q();
    L5:
        ECVideoPlayer r3 = this.b;
        if (r3 == null) goto L10;
        TTVideoEngine r4 = r3.a;
        if (r4 == null) goto L10;
        r4.releaseAsync();
    L10:
        ECVideoPlayer r5 = this.b;
        if (r5 == null) goto L13;
        r5.m(this);
    L13:
        this.b = null;
        this.a = null;
        this.c = null;
    }

    public final void seek(float r5) {
        ECVideoPlayer r0 = this.b;
        if (r0 == null) goto L8;
        int r6 = (int) r5;
        r0.b();
        TTVideoEngine r1 = r0.a;
        if (r1 == null) goto L9;
        r0.b.c(new d(r1, r0, r6));
        return;
    L9:
        return;
    }

    public final void setSpeed(float r3) {
        ECVideoPlayer r0 = this.b;
        if (r0 == null) goto L11;
        PlaybackParams r1 = new PlaybackParams();
        r1.setSpeed(r3);
        TTVideoEngine r4 = r0.a;
        if (r4 == null) goto L7;
        r4.setPlaybackParams(r1);
    L7:
        TTVideoEngine r5 = r0.a;
        if (r5 == null) goto L12;
        r5.getWatchedDuration();
        return;
    L12:
        return;
    }

    public final void d(ExplainPlaybackVideoInfo r2, int r3) {
        if (r3 <= 0) goto L8;
        ECVideoPlayer r0 = this.b;
        if (r0 == null) goto L8;
        TTVideoEngine r1 = r0.a;
        if (r1 == null) goto L8;
        r1.setStartTime(r3);
    L8:
        ECVideoPlayer r4 = this.b;
        if (r4 == null) goto L15;
        String r5 = r2.getPlayUrl();
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        r4.p(r5);
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void h(int r2, int r3) {
        da3.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.h(r2, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onVideoSizeChanged(int r2, int r3) {
        da3.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.onVideoSizeChanged(r2, r3);
        return;
    }
}
