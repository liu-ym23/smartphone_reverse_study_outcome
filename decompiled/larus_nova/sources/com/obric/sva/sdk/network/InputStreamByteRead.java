package com.obric.sva.sdk.network;

import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/sva/sdk/network/InputStreamByteRead;", "Lcom/ss/ugc/effectplatform/bridge/network/ByteReadStream;", "inputStream", "Ljava/io/InputStream;", "<init>", "(Ljava/io/InputStream;)V", "getInputStream", "()Ljava/io/InputStream;", "read", "", "b", "", "offset", "len", "available", "", "close", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputStreamByteRead implements ByteReadStream {
    private final InputStream inputStream;

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public boolean available() {
        if (this.inputStream.available() < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public void close() {
        this.inputStream.close();
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public int read() {
        return this.inputStream.read();
    }

    public final InputStream getInputStream() {
        return this.inputStream;
    }

    public InputStreamByteRead(InputStream r100) {
        Intrinsics.checkNotNullParameter(r100, "inputStream");
        this.inputStream = r100;
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.ByteReadStream
    public int read(byte[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "b");
        return this.inputStream.read(r100, r101, r102);
    }
}
