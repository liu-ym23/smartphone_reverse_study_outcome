package com.ss.android.ugc.aweme.live.alphaplayer.multi_player;

import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.ILoopListener;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IProgressListener;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;

/* JADX INFO: loaded from: classes40.dex */
public class MultiPlayerController implements IPlayerController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlayerController f451181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PlayerController f451182b;

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void e(ILoopListener r100) {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void f(DataSource r100, boolean r101) {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final String getPlayerType() {
        return null;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void h(MaskSrc r100) {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void setSurface(Surface r100) {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final int a() {
        return this.f451181a.a();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void cancel() {
        this.f451181a.cancel();
        this.f451182b.cancel();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final int getDuration() {
        return this.f451181a.getDuration();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final View getView() {
        return this.f451181a.getView();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final boolean isPlaying() {
        if (this.f451181a.isPlaying() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f451182b.isPlaying() == false) goto L7;
        return true;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void pause() {
        this.f451181a.pause();
        this.f451182b.pause();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void release() {
        this.f451181a.release();
        this.f451182b.release();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void reset() {
        this.f451181a.reset();
        this.f451182b.reset();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void resume() {
        this.f451181a.resume();
        this.f451182b.resume();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void startPlay() {
        this.f451181a.startPlay();
        this.f451182b.startPlay();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void stop() {
        this.f451181a.stop();
        this.f451182b.stop();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void attachAlphaView(ViewGroup r100) {
        this.f451181a.attachAlphaView(r100);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void c(IMonitor r100) {
        this.f451181a.f451069g = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void d(DataSource r100) {
        this.f451181a.f(r100, false);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void detachAlphaView(ViewGroup r100) {
        this.f451181a.detachAlphaView(r100);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final IPlayerController g(AlphaPlayerAction r100) {
        PlayerController r101 = this.f451181a;
        r101.f451070h = r100;
        return r101;
    }

    public final void i(ViewGroup r100) {
        this.f451182b.attachAlphaView(r100);
    }

    public final void j(ViewGroup r100) {
        this.f451182b.detachAlphaView(r100);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void b(IProgressListener r100, long r101) {
        this.f451181a.b(r100, r101);
    }

    public MultiPlayerController(Configuration r100, AbsPlayer r101, AbsPlayer r102) {
        Configuration r103 = r100.a();
        r103.f451010d = "alpha-play-thread";
        Configuration r104 = r100.a();
        r104.f451010d = "alpha-play-background-thread";
        r104.f451009c = 1;
        this.f451181a = new PlayerController(r103, r101);
        this.f451182b = new PlayerController(r104, r102);
    }
}
