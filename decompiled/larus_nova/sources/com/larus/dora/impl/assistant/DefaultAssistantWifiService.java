package com.larus.dora.impl.assistant;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/assistant/DefaultAssistantWifiService;", "Lcom/larus/dora/impl/assistant/AssistantWifiService;", "<init>", "()V", "requestWifi", "Lcom/larus/dora/impl/assistant/AssistantWifiOperationResult;", "owner", "", "releaseWifi", "queryWifiState", "Lcom/larus/dora/impl/assistant/AssistantWifiStateResult;", "setWifiEnabledForDebug", "enabled", "", "queryWifiStateForDebug", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultAssistantWifiService implements AssistantWifiService {
    public DefaultAssistantWifiService() {
    }

    @Override // com.larus.dora.impl.assistant.AssistantWifiService
    public final b c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        return null;
    }

    @Override // com.larus.dora.impl.assistant.AssistantWifiService
    public final c b() {
        return new c(false, false, null, null);
    }

    @Override // com.larus.dora.impl.assistant.AssistantWifiService
    public final b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        return new b(false, null, null);
    }
}
