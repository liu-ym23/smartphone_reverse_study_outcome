package com.huawei.hms.common.data;

import com.huawei.hms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public class SingleRefDBInnerIter<T> extends DBInnerIter<T> {
    @Override // com.huawei.hms.common.data.DBInnerIter, java.util.Iterator
    public T next() {
        if (hasNext() == true) goto L6;
        return null;
    L6:
        int r100 = this.index + 1;
        this.index = r100;
        if (r100 != 0) goto L10;
        Preconditions.checkState(this.dataBuffer.get(0) instanceof DataBufferRef, "DataBuffer reference of type " + this.dataBuffer.get(0).getClass() + " is not movable");
        ((DataBufferRef) this.dataBuffer.get(0)).getWindowIndex(this.index);
    L10:
        return (T) this.dataBuffer.get(0);
    }

    public SingleRefDBInnerIter(DataBuffer<T> r100) {
        super(r100);
    }
}
