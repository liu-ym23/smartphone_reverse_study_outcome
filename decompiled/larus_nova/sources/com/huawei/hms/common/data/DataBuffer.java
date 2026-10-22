package com.huawei.hms.common.data;

import android.os.Bundle;
import com.huawei.hms.common.api.Releasable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public interface DataBuffer<T> extends Releasable, Iterable<T> {
    void close();

    T get(int r100);

    int getCount();

    Bundle getMetadata();

    boolean isClosed();

    Iterator<T> iterator();

    @Override // com.huawei.hms.common.api.Releasable
    void release();

    Iterator<T> singleRefIterator();
}
