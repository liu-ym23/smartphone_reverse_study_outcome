package com.larus.tts;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/tts/ChatTtsServiceNoop;", "Lcom/larus/tts/IChatTtsService;", "<init>", "()V", "getTtsSwitchStatus", "", "ttsSwitch", "", "isMainBot", "cvsId", "", "getGlobalTtsSwitchStatus", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTtsServiceNoop implements IChatTtsService {
    public ChatTtsServiceNoop() {
    }

    @Override // com.larus.tts.IChatTtsService
    public final boolean a(int r100) {
        return false;
    }

    @Override // com.larus.tts.IChatTtsService
    public final boolean b(int r100, boolean r101, String r102) {
        return false;
    }
}
