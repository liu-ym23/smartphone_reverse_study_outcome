package com.bytedance.android.livesdk.livecommerce.livereplay.repository;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECScrollProductCardRepository$generateObservablePagedList$1 extends MutablePropertyReference0Impl {
    public ECScrollProductCardRepository$generateObservablePagedList$1(a r7) {
        super(r7, a.class, "dataSourceFactory", "getDataSourceFactory()Lcom/bytedance/android/livesdk/livecommerce/livereplay/repository/ECScrollProductCardDataSourceFactory;", 0);
    }

    public Object get() {
        ECScrollProductCardDataSourceFactory r0 = ((a) ((CallableReference) this).receiver).a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataSourceFactory");
    L5:
        return r0;
    }

    public void set(Object r2) {
        ECScrollProductCardDataSourceFactory r3 = (ECScrollProductCardDataSourceFactory) r2;
        ((a) ((CallableReference) this).receiver).a = r3;
    }
}
