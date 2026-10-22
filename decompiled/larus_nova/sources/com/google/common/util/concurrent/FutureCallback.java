package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface FutureCallback<V> {
    void onFailure(Throwable r100);

    void onSuccess(@ParametricNullness V r100);
}
