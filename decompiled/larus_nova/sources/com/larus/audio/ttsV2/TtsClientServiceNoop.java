package com.larus.audio.ttsV2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r"}, d2 = {"Lcom/larus/audio/ttsV2/TtsClientServiceNoop;", "Lcom/larus/audio/ttsV2/ITtsClientService;", "<init>", "()V", "isTtsStopped", "", "cancel", "", "reason", "", "isFromManual", "setCurrentConversationId", "cvsId", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsClientServiceNoop implements ITtsClientService {
    public TtsClientServiceNoop() {
    }

    @Override // com.larus.audio.ttsV2.ITtsClientService
    public final void a() {
    }

    @Override // com.larus.audio.ttsV2.ITtsClientService
    public final void cancel(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
    }

    @Override // com.larus.audio.ttsV2.ITtsClientService
    public final boolean isTtsStopped() {
        return true;
    }
}
