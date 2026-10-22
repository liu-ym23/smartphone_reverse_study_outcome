package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.plugin;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.ErrorCode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.LoadingState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.PlaybackState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.SeekState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.PlayMode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h;
import com.bytedance.ies.xelement.defaultimpl.player.engine.impl.AudioPlayerServiceImpl;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import o76.c;
import o76.k;
import p76.b;
import q76.a;

/* JADX INFO: loaded from: classes19.dex */
public final class PluginManager implements c, com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m76.c f249952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f249953b;

    public final a<p76.c> b() {
        return (a) this.f249953b.getValue();
    }

    public final void d() {
        this.f249952a.q(this);
        this.f249952a.f(this);
        b().a(PluginManager$release$1.INSTANCE);
        b().f531971a.clear();
    }

    @Override // o76.c
    public final void onCompletion() {
        b().a(AnonymousClass1.INSTANCE);
    }

    @Override // o76.c
    public final void onPrepare() {
        b().a(C105701.INSTANCE);
    }

    @Override // o76.c
    public final void onPrepared() {
        b().a(C105711.INSTANCE);
    }

    @Override // o76.c
    public final void onRenderStart() {
        b().a(C105721.INSTANCE);
    }

    public PluginManager(AudioPlayerServiceImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "playerService");
        this.f249952a = r100;
        this.f249953b = LazyKt.lazy(PluginManager$mPlugins$2.INSTANCE);
        r100.s(this);
        r100.r(this);
    }

    public final void a(p76.c r110) {
        Intrinsics.checkNotNullParameter(r110, CloudControlInf.PLUGIN);
        m76.c r100 = this.f249952a;
        b r101 = new b(r100, r100, r100, r100, r100, r100, r100);
        a<p76.c> r102 = b();
        r110.n(r101);
        if (r102.f531971a.contains(r110) == true) goto L6;
        r102.f531971a.add(r110);
        return;
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.c
    public final void c(final PlayMode r100) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_MODE);
        b().a(new PluginManager$onPlayModeChanged$1(r100));
    }

    @Override // o76.c
    public final void e(final LoadingState r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingState");
        b().a(new PluginManager$onLoadStateChanged$1(r100));
    }

    public final void f(p76.c r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        a<p76.c> r101 = b();
        r100.onDetach();
        r101.f531971a.remove(r100);
    }

    @Override // o76.c
    public final void h(final ErrorCode r100) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        b().a(new PluginManager$onError$1(r100));
    }

    @Override // o76.c
    public final void i(final long r100) {
        b().a(new PluginManager$onPlaybackTimeChanged$1(r100));
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.c
    public final void m(final f r100) {
        b().a(new PluginManager$onCurrentDataSourceChanged$1(r100));
    }

    @Override // o76.c
    public final void p(final PlaybackState r100) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        b().a(new PluginManager$onPlaybackStateChanged$1(r100));
    }

    @Override // o76.c
    public final void q(final SeekState r100) {
        Intrinsics.checkNotNullParameter(r100, "seekState");
        b().a(new PluginManager$onSeekStateChanged$1(r100));
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.c
    public final void r(final h r100) {
        b().a(new PluginManager$onPlaylistChanged$1(r100));
    }

    @Override // o76.c
    public final void s(final long r100) {
        b().a(new PluginManager$onPlaybackTimeChangedFast$1(r100));
    }

    @Override // o76.c
    public final void t(final k r100) {
        b().a(new PluginManager$onPlayableChanged$1(r100));
    }

    @Override // o76.c
    public final void u(final float r100) {
        b().a(new PluginManager$onBufferingUpdate$1(r100));
    }
}
