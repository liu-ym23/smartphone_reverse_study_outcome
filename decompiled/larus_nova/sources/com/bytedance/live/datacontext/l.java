package com.bytedance.live.datacontext;

import io.reactivex.Observable;

/* JADX INFO: loaded from: classes19.dex */
public interface l<T> {
    Observable<?> a();

    T getValue();

    void setValue(T r100);
}
