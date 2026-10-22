package com.huawei.hms.common.data;

import com.huawei.hms.common.internal.Preconditions;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public class DBInnerIter<O> implements Iterator<O> {
    protected final DataBuffer<O> dataBuffer;
    protected int index;

    @Override // java.util.Iterator
    public boolean hasNext() {
        if ((this.index + 1) >= this.dataBuffer.getCount()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public O next() {
        if (hasNext() == false) goto L5;
        DataBuffer<O> r100 = this.dataBuffer;
        int r101 = this.index + 1;
        this.index = r101;
        return r100.get(r101);
    L5:
        return null;
    }

    public DBInnerIter(DataBuffer<O> r100) {
        this.index = -1;
        Preconditions.checkNotNull(r100, "dataBuffer cannot be null");
        this.dataBuffer = r100;
    }
}
