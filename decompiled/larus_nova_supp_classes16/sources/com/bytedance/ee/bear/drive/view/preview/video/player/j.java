package com.bytedance.ee.bear.drive.view.preview.video.player;

import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements sf5.a {
    public final /* synthetic */ e a;

    public final void onRenderStart() {
        tt5.a.h("TTPlayer", "ttPlayer auto play time cause :  " + (SystemClock.elapsedRealtime() - this.a.i));
        com.bytedance.ee.util.ui.j.c(new h(this));
    }

    public j(e r1) {
        this.a = r1;
    }

    public final void h(final int r3) {
        tt5.a.h("TTPlayer", "onPlaybackStateChanged, video view state = " + r3);
        com.bytedance.ee.util.ui.j.c(new g(this, r3));
    }

    public final void j(final Exception r3) {
        tt5.a.h("TTPlayer", "ttPlayer onPlayerError");
        com.bytedance.ee.util.ui.j.c(new i(this, r3));
    }

    public final void onVideoSizeChanged(final int r3, final int r4) {
        tt5.a.h("TTPlayer", "ttPlayer onVideoSizeChanged width = " + r3 + " height = " + r4);
        com.bytedance.ee.util.ui.j.c(new f(this, r3, r4));
    }
}
