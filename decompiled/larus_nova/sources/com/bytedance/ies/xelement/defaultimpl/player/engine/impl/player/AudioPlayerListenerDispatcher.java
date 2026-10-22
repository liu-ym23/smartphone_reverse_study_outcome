package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.ErrorCode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.LoadingState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.PlaybackState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.SeekState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.impl.plugin.PluginManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import o76.c;
import o76.d;
import o76.k;

/* JADX INFO: loaded from: classes19.dex */
public final class AudioPlayerListenerDispatcher implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f249886a;

    public final q76.a<c> b() {
        return (q76.a) this.f249886a.getValue();
    }

    public AudioPlayerListenerDispatcher() {
        this.f249886a = LazyKt.lazy(AudioPlayerListenerDispatcher$mListeners$2.INSTANCE);
    }

    public final void c() {
        b().f531971a.clear();
    }

    @Override // o76.c
    public final void onCompletion() {
        b().a(AnonymousClass1.INSTANCE);
    }

    @Override // o76.c
    public final void onPrepare() {
        b().a(C105671.INSTANCE);
    }

    @Override // o76.c
    public final void onPrepared() {
        b().a(C105681.INSTANCE);
    }

    @Override // o76.c
    public final void onRenderStart() {
        b().a(C105691.INSTANCE);
    }

    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        q76.a<c> r101 = b();
        if (r101.f531971a.contains(r100) == true) goto L6;
        r101.f531971a.add(r100);
        return;
    }

    @Override // o76.c
    public final void e(final LoadingState r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingState");
        b().a(new AudioPlayerListenerDispatcher$onLoadStateChanged$1(r100));
    }

    @Override // o76.d
    public final void f(PluginManager r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        b().f531971a.remove(r100);
    }

    @Override // o76.c
    public final void h(final ErrorCode r100) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        b().a(new AudioPlayerListenerDispatcher$onError$1(r100));
    }

    @Override // o76.c
    public final void i(final long r100) {
        b().a(new AudioPlayerListenerDispatcher$onPlaybackTimeChanged$1(r100));
    }

    @Override // o76.c
    public final void p(final PlaybackState r100) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        b().a(new AudioPlayerListenerDispatcher$onPlaybackStateChanged$1(r100));
    }

    @Override // o76.c
    public final void q(final SeekState r100) {
        Intrinsics.checkNotNullParameter(r100, "seekState");
        b().a(new AudioPlayerListenerDispatcher$onSeekStateChanged$1(r100));
    }

    @Override // o76.c
    public final void s(final long r100) {
        b().a(new AudioPlayerListenerDispatcher$onPlaybackTimeChangedFast$1(r100));
    }

    @Override // o76.c
    public final void t(final k r100) {
        b().a(new AudioPlayerListenerDispatcher$onPlayableChanged$1(r100));
    }

    @Override // o76.c
    public final void u(final float r100) {
        b().a(new AudioPlayerListenerDispatcher$onBufferingUpdate$1(r100));
    }
}
