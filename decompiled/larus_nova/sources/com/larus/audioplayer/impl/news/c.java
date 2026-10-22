package com.larus.audioplayer.impl.news;

import b88.f;
import com.larus.audioplayer.api.news.UrlAudioLoadState;
import com.larus.platform.api.l0;
import com.larus.platform.api.n;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements b88.b, b.InterfaceC3974b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b88.c f290366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f290367b;

    @Override // b88.b
    public final float e() {
        return this.f290367b.f290340m.a().f365214a;
    }

    @Override // b88.b
    public final int f() {
        return this.f290367b.f290340m.getCurrentPlaybackTime();
    }

    @Override // b88.b
    public final int getAudioDuration() {
        return this.f290367b.f290340m.n();
    }

    @Override // b88.b
    public final boolean isWorking() {
        return this.f290367b.f290342o;
    }

    @Override // b88.b
    public final int k() {
        return this.f290367b.f290340m.o();
    }

    @Override // b88.b
    public final void release() {
        this.f290367b.f290340m.release();
    }

    @Override // b88.b
    public final void c(float r100) {
        this.f290367b.f290340m.c(r100);
    }

    @Override // b88.b
    public final void d(float r100) {
        b r101 = this.f290367b;
        n r102 = new n();
        r102.f365214a = r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "params");
        r101.f290340m.H(r102);
    }

    @Override // b88.b
    public final void g(Function0<Unit> r100) {
        this.f290367b.d(r100);
    }

    @Override // b88.b
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f290367b.c(r100);
    }

    @Override // b88.b
    public final void setLooping(boolean r100) {
        this.f290367b.f290340m.setLooping(r100);
    }

    @Override // b88.b
    public final void h(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "pausedReason");
        this.f290367b.b(r100, r101);
    }

    @Override // b88.b
    public final boolean j(int r100, l0 r101) {
        this.f290367b.f290340m.A(r100, r101);
        return true;
    }

    @Override // com.larus.audioplayer.impl.news.b.InterfaceC3974b
    public final void l(String r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "player");
        b88.c r102 = this.f290366a;
        if (r102 == null) goto L6;
        r102.b(r100);
        return;
    }

    public c(f r210, b88.a r211, b88.c r212) {
        Intrinsics.checkNotNullParameter(r210, "config");
        this.f290366a = r212;
        b r110 = new b(r210.f18200a, r210.f18201b, null, null, r211, r210.f18202c, r210.f18203d, null, null, r210.f18204e, r210.f18205f, r210.f18206g, r210.f18207h, r210.f18208i, r210.f18209j, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE);
        Intrinsics.checkNotNullParameter(this, "callback");
        r110.f290353z = this;
        this.f290367b = r110;
    }

    @Override // com.larus.audioplayer.impl.news.b.InterfaceC3974b
    public final void a(String r100, b r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "player");
        b88.c r103 = this.f290366a;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r102 != 1) goto L7;
        UrlAudioLoadState r104 = UrlAudioLoadState.PLAYABLE;
    L14:
        r103.a(r100, r104);
        return;
    L7:
        if (r102 != 2) goto L9;
        r104 = UrlAudioLoadState.STALLED;
        goto L14
    L9:
        if (r102 == 3) goto L11;
        r104 = UrlAudioLoadState.UNKNOWN;
        goto L14
    L11:
        r104 = UrlAudioLoadState.ERROR;
        goto L14
    }

    @Override // com.larus.audioplayer.impl.news.b.InterfaceC3974b
    public final void b(String r100, b r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "player");
        b88.c r103 = this.f290366a;
        if (r103 == null) goto L6;
        r103.c(r100, r102);
        return;
    }
}
