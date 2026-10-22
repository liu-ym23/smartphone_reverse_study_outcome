package com.larus.extension.offline_message.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/extension/offline_message/api/OfflineMessageConfigNoop;", "Lcom/larus/extension/offline_message/api/IOfflineMessageConfig;", "<init>", "()V", "enabled", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfflineMessageConfigNoop implements IOfflineMessageConfig {
    public OfflineMessageConfigNoop() {
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageConfig
    public final boolean enabled() {
        return false;
    }
}
