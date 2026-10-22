package com.larus.audio.flow.client.factory;

import com.larus.audio.IFlowTtsClientFactory;
import com.larus.audio.flow.client.FlowTtsClientImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/audio/flow/client/factory/FlowTtsClientFactoryImpl;", "Lcom/larus/audio/IFlowTtsClientFactory;", "<init>", "()V", "createTtsClient", "Lcom/larus/audio/IFlowTtsClientService;", "tag", "", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowTtsClientFactoryImpl implements IFlowTtsClientFactory {
    public FlowTtsClientFactoryImpl() {
    }

    @Override // com.larus.audio.IFlowTtsClientFactory
    public final FlowTtsClientImpl a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        return new FlowTtsClientImpl(r100);
    }
}
