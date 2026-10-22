package com.larus.audio.flow.client;

import com.larus.audio.audiov3.config.audio.player.IAudioPlayerConfigFactory;
import com.ss.ttvideoengine.model.SubInfo;
import g78.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/audio/flow/client/AudioPlayerConfigFactory;", "Lcom/larus/audio/audiov3/config/audio/player/IAudioPlayerConfigFactory;", "<init>", "()V", "create", "Lcom/larus/audio/audiov3/config/audio/player/IAudioPlayerConfig;", "sampleRate", "", "channel", SubInfo.KEY_FORMAT, "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioPlayerConfigFactory implements IAudioPlayerConfigFactory {
    public AudioPlayerConfigFactory() {
    }

    @Override // com.larus.audio.audiov3.config.audio.player.IAudioPlayerConfigFactory
    public final a a(int r100, int r101, int r102) {
        return new a(r100, r101, r102);
    }
}
