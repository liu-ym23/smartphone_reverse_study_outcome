package com.obric.sva.sdk.audio;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"com/obric/sva/sdk/audio/AecModel$audioPlayConfig$1", "", "sampleRate", "", "getSampleRate", "()I", "channelConfig", "getChannelConfig", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AecModel$audioPlayConfig$1 {
    private final int channelConfig;
    private final int sampleRate;

    public AecModel$audioPlayConfig$1() {
        this.sampleRate = 16000;
        this.channelConfig = 4;
    }

    public final int getChannelConfig() {
        return this.channelConfig;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }
}
