package com.bytedance.android.livesdk.livecommerce.playback.video;

import android.content.Context;
import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e {
    public ExplainPlaybackVideoInfo a;
    public ECReplayVideo b;
    public final boolean c;
    public final Context d;
    public final da3.b e;

    public final boolean a() {
        int r0 = bj2.a.a;
        bj2.a.b("VideoPlayBackPlayController", "isPlaying:" + this.e.isPlaying());
        return this.e.isPlaying();
    }

    public final void b() {
        bj2.a.b("VideoPlayBackPlayController", "pauseVideo");
        this.e.b();
    }

    public final void d() {
        bj2.a.b("VideoPlayBackPlayController", "resumeVideo");
        this.e.c();
    }

    public final Context getContext() {
        return this.d;
    }

    public final void c(boolean r3) {
        bj2.a.b("VideoPlayBackPlayController", "release");
        this.e.release(r3);
    }

    public final void e(da3.d r3) {
        int r0 = bj2.a.a;
        bj2.a.b("VideoPlayBackPlayController", "setECVideoListener:" + r3);
        this.e.e(r3);
    }

    public e(Context r2, da3.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "playbackVideoView");
        this.d = r2;
        this.e = r3;
        this.c = aj2.a.a();
    }
}
