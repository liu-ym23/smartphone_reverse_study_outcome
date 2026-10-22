package com.ss.ugc.effectplatform.bridge.network;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lcom/ss/ugc/effectplatform/bridge/network/EmptyByteReadStream;", "Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;", "()V", "available", "", "close", "", "read", "", "b", "", "offset", "len", "effect_bridge_release"}, k = 1, mv = {1, 1, 16})
public final class EmptyByteReadStream implements ByteReadStream {
    public EmptyByteReadStream() {
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public boolean available() {
        return false;
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public void close() {
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public int read() {
        return 0;
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public int read(byte[] r100, int r101, int r102) {
        return 0;
    }
}
