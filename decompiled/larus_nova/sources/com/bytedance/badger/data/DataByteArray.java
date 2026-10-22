package com.bytedance.badger.data;

import kotlin.Metadata;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/badger/data/DataByteArray;", "Lcom/bytedance/badger/data/IBadgerData;", "data", "", "([B)V", "getData", "toString", "", "badger-api_release"}, k = 1, mv = {1, 1, 15})
public final class DataByteArray implements IBadgerData {
    private final byte[] data;

    public String toString() {
        return new String(this.data, Charsets.UTF_8);
    }

    public final byte[] getData() {
        return this.data;
    }

    public DataByteArray(byte[] r100) {
        this.data = r100;
    }
}
