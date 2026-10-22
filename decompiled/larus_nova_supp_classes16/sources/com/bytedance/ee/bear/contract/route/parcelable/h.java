package com.bytedance.ee.bear.contract.route.parcelable;

import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface h {
    Flowable a();

    boolean hasMore();

    Flowable load();
}
