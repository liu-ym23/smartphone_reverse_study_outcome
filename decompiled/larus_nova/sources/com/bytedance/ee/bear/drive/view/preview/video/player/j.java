package com.bytedance.ee.bear.drive.view.preview.video.player;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes16.dex */
public final class j implements sf5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f225581a;

    @Override // sf5.a
    public final void onRenderStart() {
        tt5.a.h("TTPlayer", "ttPlayer auto play time cause :  " + (SystemClock.elapsedRealtime() - this.f225581a.f225563i));
        com.bytedance.ee.util.ui.j.c(new h(this));
    }

    public j(e r100) {
        this.f225581a = r100;
    }

    @Override // sf5.a
    public final void h(final int r100) {
        tt5.a.h("TTPlayer", "onPlaybackStateChanged, video view state = " + r100);
        com.bytedance.ee.util.ui.j.c(new g(this, r100));
    }

    @Override // sf5.a
    public final void j(final Exception r100) {
        tt5.a.h("TTPlayer", "ttPlayer onPlayerError");
        com.bytedance.ee.util.ui.j.c(new i(this, r100));
    }

    @Override // sf5.a
    public final void onVideoSizeChanged(final int r100, final int r101) {
        tt5.a.h("TTPlayer", "ttPlayer onVideoSizeChanged width = " + r100 + " height = " + r101);
        com.bytedance.ee.util.ui.j.c(new f(this, r100, r101));
    }
}
