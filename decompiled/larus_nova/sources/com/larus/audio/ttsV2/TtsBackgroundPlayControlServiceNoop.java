package com.larus.audio.ttsV2;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/audio/ttsV2/TtsBackgroundPlayControlServiceNoop;", "Lcom/larus/audio/ttsV2/ITtsBackgroundPlayControlService;", "<init>", "()V", "allowPlayWhenAppBackground", "", "shouldStopWhenEnterBackgroundDuringPlayback", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsBackgroundPlayControlServiceNoop implements ITtsBackgroundPlayControlService {
    public TtsBackgroundPlayControlServiceNoop() {
    }

    @Override // com.larus.audio.ttsV2.ITtsBackgroundPlayControlService
    public final boolean a() {
        return false;
    }

    @Override // com.larus.audio.ttsV2.ITtsBackgroundPlayControlService
    public final boolean b() {
        return true;
    }
}
