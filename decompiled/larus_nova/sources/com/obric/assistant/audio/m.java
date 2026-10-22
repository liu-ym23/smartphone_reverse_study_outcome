package com.obric.assistant.audio;

import com.larus.audio.IAudioService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements IAudioService.a {
    public m() {
    }

    @Override // com.larus.audio.IAudioService.a
    public final void name() {
    }

    @Override // com.larus.audio.IAudioService.a
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        return ObricAudioConnectionStatusMonitor.a();
    }
}
