package com.ss.android.ugc.aweme.live.alphaplayer.player;

import android.content.Context;
import android.view.Surface;
import com.ss.android.ugc.aweme.live.alphaplayer.model.VideoInfo;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes40.dex */
public class AbsPlayer<T extends AbsPlayer> implements IMediaPlayer<AbsPlayer<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbsPlayer<T> f451183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f451184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IMediaPlayer.OnCompletionListener<AbsPlayer<T>> f451185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IMediaPlayer.OnPreparedListener<AbsPlayer<T>> f451186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IMediaPlayer.OnErrorListener<AbsPlayer<T>> f451187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IMediaPlayer.OnFirstFrameListener<AbsPlayer<T>> f451188f;

    public AbsPlayer() {
        this(null);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public void a() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public void b() throws Exception {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public int getCurrentPosition() {
        return 0;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public VideoInfo getVideoInfo() throws Exception {
        return null;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public boolean isPlaying() {
        return false;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public void pause() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public void prepareAsync() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public void release() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public void reset() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public void seekTo(int r100) {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public void setDataSource(String r100) throws IOException {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public void setLooping(boolean r100) {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public void setSurface(Surface r100) {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public void start() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public void stop() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public String c() {
        return "AbsPlayer";
    }

    public AbsPlayer(Context r100) {
        this.f451183a = this;
        this.f451184b = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void d(IMediaPlayer.OnFirstFrameListener<AbsPlayer<T>> r100) {
        this.f451188f = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void e(IMediaPlayer.OnErrorListener<AbsPlayer<T>> r100) {
        this.f451187e = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void f(IMediaPlayer.OnPreparedListener<AbsPlayer<T>> r100) {
        this.f451186d = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void g(IMediaPlayer.OnCompletionListener<AbsPlayer<T>> r100) {
        this.f451185c = r100;
    }
}
