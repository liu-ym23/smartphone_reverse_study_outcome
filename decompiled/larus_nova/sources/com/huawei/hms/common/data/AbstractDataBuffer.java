package com.huawei.hms.common.data;

import android.os.Bundle;
import com.huawei.hms.support.api.client.Result;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractDataBuffer<T> extends Result implements DataBuffer<T> {
    protected final DataHolder mDataHolder;

    @Override // com.huawei.hms.common.data.DataBuffer
    public abstract T get(int r100);

    @Override // com.huawei.hms.common.data.DataBuffer
    public int getCount() {
        DataHolder r100 = this.mDataHolder;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getCount();
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    public Bundle getMetadata() {
        DataHolder r100 = this.mDataHolder;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getMetadata();
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    public boolean isClosed() {
        DataHolder r100 = this.mDataHolder;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.isClosed();
    }

    @Override // com.huawei.hms.common.data.DataBuffer, java.lang.Iterable
    public Iterator<T> iterator() {
        return new DBInnerIter(this);
    }

    @Override // com.huawei.hms.common.data.DataBuffer, com.huawei.hms.common.api.Releasable
    public void release() {
        DataHolder r100 = this.mDataHolder;
        if (r100 == null) goto L6;
        r100.close();
        return;
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    public Iterator<T> singleRefIterator() {
        return new SingleRefDBInnerIter(this);
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    public final void close() {
        release();
    }

    public AbstractDataBuffer(DataHolder r100) {
        this.mDataHolder = r100;
    }
}
