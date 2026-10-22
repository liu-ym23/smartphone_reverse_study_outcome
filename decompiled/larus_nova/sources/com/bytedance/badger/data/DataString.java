package com.bytedance.badger.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/badger/data/DataString;", "Lcom/bytedance/badger/data/IBadgerData;", "data", "", "(Ljava/lang/String;)V", "getData", "toString", "badger-api_release"}, k = 1, mv = {1, 1, 15})
public final class DataString implements IBadgerData {
    private final String data;

    public final String getData() {
        return this.data;
    }

    public String toString() {
        return this.data;
    }

    public DataString(String r100) {
        this.data = r100;
    }
}
