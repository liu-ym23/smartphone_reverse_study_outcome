package com.bytedance.manager;

import com.bytedance.flow_audio.api.foundation.player.AudioPlayerStatus;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements rw5.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<AudioPlayerStatus> f265479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public uw5.b f265480c;

    @Override // rw5.e
    public final void L0(rw5.d r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceData");
    }

    @Override // rw5.e
    public final void duck(float r100) {
    }

    @Override // rw5.e
    public final void pause() {
    }

    @Override // rw5.e
    public final void resume() {
    }

    @Override // rw5.e
    public final void start() {
    }

    @Override // rw5.e
    public final void stop() {
    }

    @Override // rw5.e
    public final AudioPlayerStatus getStatus() {
        return this.f265479b.invoke();
    }

    public c(g r100) {
        Intrinsics.checkNotNullParameter(r100, "statusProvider");
        this.f265479b = r100;
        this.f265480c = null;
        AudioPlayerStatus r101 = AudioPlayerStatus.Initial;
    }
}
