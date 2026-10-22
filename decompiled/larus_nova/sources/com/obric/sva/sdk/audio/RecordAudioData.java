package com.obric.sva.sdk.audio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/sva/sdk/audio/RecordAudioData;", "", "readSize", "", "data", "", "<init>", "(I[B)V", "getReadSize", "()I", "getData", "()[B", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordAudioData {
    private final byte[] data;
    private final int readSize;

    public final byte[] getData() {
        return this.data;
    }

    public final int getReadSize() {
        return this.readSize;
    }

    public RecordAudioData(int r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        this.readSize = r100;
        this.data = r101;
    }
}
