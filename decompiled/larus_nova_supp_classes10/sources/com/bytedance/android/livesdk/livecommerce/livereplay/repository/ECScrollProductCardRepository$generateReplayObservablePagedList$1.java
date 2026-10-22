package com.bytedance.android.livesdk.livecommerce.livereplay.repository;

import com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.ECReplayScrollProductCardDataSourceFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECScrollProductCardRepository$generateReplayObservablePagedList$1 extends MutablePropertyReference0Impl {
    public ECScrollProductCardRepository$generateReplayObservablePagedList$1(a r7) {
        super(r7, a.class, "dataReplaySourceFactory", "getDataReplaySourceFactory()Lcom/bytedance/android/livesdk/livecommerce/livereplay/replayrepository/ECReplayScrollProductCardDataSourceFactory;", 0);
    }

    public Object get() {
        ECReplayScrollProductCardDataSourceFactory r0 = ((a) ((CallableReference) this).receiver).b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataReplaySourceFactory");
    L5:
        return r0;
    }

    public void set(Object r2) {
        ECReplayScrollProductCardDataSourceFactory r3 = (ECReplayScrollProductCardDataSourceFactory) r2;
        ((a) ((CallableReference) this).receiver).b = r3;
    }
}
