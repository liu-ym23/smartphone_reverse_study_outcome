package com.bytedance.android.shopping.model;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/model/ECLubanLogData;", "Ljava/io/Serializable;", "isLuban", "", "isAdEvent", "(II)V", "()I", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLubanLogData implements Serializable {
    private final int isAdEvent;
    private final int isLuban;

    public final int isAdEvent() {
        return this.isAdEvent;
    }

    public final int isLuban() {
        return this.isLuban;
    }

    public ECLubanLogData(int r1, int r2) {
        this.isLuban = r1;
        this.isAdEvent = r2;
    }
}
