package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player;

import android.content.Context;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.ErrorCode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.PlaybackState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.SeekState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.engine.i;
import com.bytedance.ies.xelement.defaultimpl.player.engine.impl.plugin.PluginManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import o76.c;
import o76.d;
import o76.e;
import o76.f;
import o76.h;
import o76.j;
import o76.k;

/* JADX INFO: loaded from: classes19.dex */
public final class AudioPlayerController implements o76.b, d, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f249880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l76.a f249881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f249882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f249883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f249884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f249885f;

    @Override // o76.i
    public final n76.b j() {
        return ((r76.a) this.f249883d.getValue()).f536464b;
    }

    public final a o() {
        return (a) this.f249884e.getValue();
    }

    public final MusicPlayerImpl p() {
        return (MusicPlayerImpl) this.f249882c.getValue();
    }

    public final void r() {
        ((AudioPlayerListenerDispatcher) this.f249885f.getValue()).c();
        o().c();
        MusicPlayerImpl r100 = p();
        r100.f249893f = null;
        r100.b().release();
    }

    @Override // o76.b
    public final PlaybackState c() {
        MusicPlayerImpl r100 = p();
        if (r100.f249893f != null) goto L6;
        return PlaybackState.PLAYBACK_STATE_STOPPED;
    L6:
        return r100.b().getPlaybackState();
    }

    public final long i() {
        MusicPlayerImpl r100 = p();
        k r101 = r100.f249893f;
        long r102 = 0;
        if (r101 == null) goto L10;
        if (r101 == null) goto L9;
        r102 = r100.b().getDuration();
    L9:
        return (r102 * ((long) r100.b().a())) / ((long) 100);
    L10:
        return 0;
    }

    public final long l() {
        MusicPlayerImpl r100 = p();
        if (r100.f249893f != null) goto L6;
        return 0;
    L6:
        return r100.b().getCurrentPlaybackTime();
    }

    public final long n() {
        MusicPlayerImpl r100 = p();
        if (r100.f249893f != null) goto L6;
        return 0;
    L6:
        return r100.b().getDuration();
    }

    public final long q() {
        MusicPlayerImpl r100 = p();
        if (r100.f249893f != null) goto L6;
        return 0;
    L6:
        return r100.b().b();
    }

    @Override // o76.b
    public final void a(n76.b r100) {
        if (o().a(r100) == false) goto L5;
        return;
    L5:
        MusicPlayerImpl r101 = p();
        if (r101.f249893f == null) goto L10;
        r101.b().resume();
        return;
    }

    @Override // o76.b
    public final void b(n76.b r100) {
        if (o().b(r100) == false) goto L5;
        return;
    L5:
        MusicPlayerImpl r101 = p();
        if (r101.f249893f == null) goto L10;
        r101.b().pause();
        return;
    }

    @Override // o76.b
    public final void d(n76.b r100) {
        if (o().d(r100) == false) goto L5;
        return;
    L5:
        MusicPlayerImpl r101 = p();
        long r102 = r101.f249894g;
        r101.b().c(r102);
        r101.f249894g = 0;
    }

    public final void e(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((AudioPlayerListenerDispatcher) this.f249885f.getValue()).a(r100);
    }

    @Override // o76.d
    public final void f(PluginManager r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((AudioPlayerListenerDispatcher) this.f249885f.getValue()).f(r100);
    }

    @Override // o76.b
    public final void g(n76.b r100) {
        if (o().g(r100) == false) goto L5;
        return;
    L5:
        MusicPlayerImpl r101 = p();
        if (r101.f249893f == null) goto L10;
        r101.b().stop();
        return;
    }

    @Override // o76.f
    public final void h(e r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        o().h(r100);
    }

    @Override // o76.b
    public final void k(k r100) {
        k r101 = o().l(r100);
        MusicPlayerImpl r102 = p();
        r102.f249893f = r101;
        r102.f249892e = MusicPlayerImpl.ResourcesType.INIT;
        r102.c(ErrorCode.INVALIDATE_PLAYER_MODEL);
        ((AudioPlayerListenerDispatcher) this.f249885f.getValue()).t(r101);
    }

    @Override // o76.f
    public final void m(e r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        o().m(r100);
    }

    public final void t(h r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        MusicPlayerImpl r101 = p();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "factory");
        r101.f249895h = r100;
    }

    public AudioPlayerController(Context r100, l76.a r101) {
        Intrinsics.checkNotNullParameter(r100, "mAppContext");
        Intrinsics.checkNotNullParameter(r101, "mAudioErrorMonitor");
        this.f249880a = r100;
        this.f249881b = r101;
        this.f249882c = LazyKt.lazy(new AudioPlayerController$mPlayerImpl$2(this));
        this.f249883d = LazyKt.lazy(new AudioPlayerController$mReasonCollectInterceptor$2(this));
        this.f249884e = LazyKt.lazy(new AudioPlayerController$mInterceptorDispatcher$2(this));
        this.f249885f = LazyKt.lazy(new AudioPlayerController$mListenerDispatcher$2(this));
    }

    public final void s(long r100, j r101) {
        if (o().f() == false) goto L5;
        return;
    L5:
        MusicPlayerImpl r102 = p();
        k r103 = r102.f249893f;
        if (r103 == null) goto L14;
        if (r103 != null) goto L9;
        PlaybackState r104 = PlaybackState.PLAYBACK_STATE_STOPPED;
    L11:
        if (r104 == PlaybackState.PLAYBACK_STATE_STOPPED) goto L14;
        r102.f249889b.q(SeekState.SEEKING);
        r102.b().f(r100, new b(r101, r102));
        return;
    L9:
        r104 = r102.b().getPlaybackState();
    L14:
        r102.f249894g = r100;
        if ((r102.b() instanceof i) == false) goto L19;
        i r105 = (i) r102.b();
        r105.f249934h = r102.f249894g;
        return;
    }
}
