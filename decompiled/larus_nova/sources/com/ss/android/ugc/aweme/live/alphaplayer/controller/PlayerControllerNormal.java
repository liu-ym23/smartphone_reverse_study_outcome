package com.ss.android.ugc.aweme.live.alphaplayer.controller;

import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.ILoopListener;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IProgressListener;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;
import com.ss.android.ugc.aweme.live.alphaplayer.player.PlayerState;

/* JADX INFO: loaded from: classes40.dex */
public class PlayerControllerNormal implements IPlayerController, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f451098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f451099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PlayerState f451100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IMonitor f451101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AlphaPlayerAction f451102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f451103f;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerControllerNormal$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f451104a = null;

        static {
            int[] r100 = new int[PlayerState.values().length];
            f451104a = r100;
            r100[PlayerState.PREPARED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f451104a[PlayerState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f451104a[PlayerState.NOT_PREPARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f451104a[PlayerState.STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final int a() {
        return 0;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void b(IProgressListener r100, long r101) {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void cancel() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void e(ILoopListener r100) {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final int getDuration() {
        return -1;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final String getPlayerType() {
        return "unknown";
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final View getView() {
        return null;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void h(MaskSrc r100) {
    }

    public final void i() {
        this.f451099b = false;
        this.f451098a = 0;
        AlphaPlayerAction r100 = this.f451102e;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final boolean isPlaying() {
        return false;
    }

    public final void k() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void pause() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void reset() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void startPlay() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void stop() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void resume() {
        if (this.f451099b == false) goto L6;
        startPlay();
        return;
    L6:
        if (this.f451103f == false) goto L10;
        this.f451103f = false;
        k();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        release();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        pause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        resume();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        stop();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void release() {
        throw null;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void attachAlphaView(ViewGroup r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        throw null;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void c(IMonitor r100) {
        this.f451101d = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void d(DataSource r100) {
        f(r100, false);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void detachAlphaView(ViewGroup r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.removeView(null);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final IPlayerController g(AlphaPlayerAction r100) {
        this.f451102e = r100;
        return this;
    }

    public final void l(DataSource r100) throws Exception {
        throw null;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void setSurface(Surface r100) {
        throw null;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController
    public final void f(DataSource r100, boolean r101) {
        throw null;
    }

    public final void j(boolean r100, int r101, int r102, String r110) {
        IMonitor r103 = this.f451101d;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.monitor(r100, "unknown", r101, r102, r110 + ", messageId: " + this.f451098a);
    }
}
