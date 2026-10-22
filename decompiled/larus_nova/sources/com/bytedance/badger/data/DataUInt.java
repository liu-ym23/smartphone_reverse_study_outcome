package com.bytedance.badger.data;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/bytedance/badger/data/DataUInt;", "Lcom/bytedance/badger/data/IBadgerData;", "udata", "Lkotlin/UInt;", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getUdata", "()I", "I", "getData", "", "toString", "", "badger-api_release"}, k = 1, mv = {1, 1, 15})
public final class DataUInt implements IBadgerData {
    private final int udata;

    public String toString() {
        return UInt.m9590toStringimpl(this.udata);
    }

    public final int getData() {
        return this.udata;
    }

    public final int getUdata() {
        return this.udata;
    }

    private DataUInt(int r100) {
        this.udata = r100;
    }

    public /* synthetic */ DataUInt(int r100, DefaultConstructorMarker r101) {
        this(r100);
    }
}
