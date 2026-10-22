package com.bytedance.android.shopping.store.viewmodel;

import android.os.Handler;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.utils.CommonUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements com.bytedance.android.chunkstreamprediction.network.a<ECStoreHomeTabResponseTabkit> {
    public final /* synthetic */ ECStoreViewModel.p a;

    public final void onComplete() {
    }

    public b(ECStoreViewModel.p r1) {
        this.a = r1;
    }

    public final void onFailed(Throwable r2) {
        ECStoreViewModel.access$notifyTabLoadFailed(this.a.a, r2);
    }

    public final void onNext(Object r3) {
        final ECStoreHomeTabResponseTabkit r4 = (ECStoreHomeTabResponseTabkit) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        Integer r0 = r4.getChunkIndex();
        if (r0 != null) goto L6;
    L8:
        Integer r1 = r4.getChunkIndex();
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.intValue() != 1) goto L16;
        Handler r2 = CommonUtils.a;
        CommonUtils.c(false, new ECStoreViewModel$fetchTabChunk$1$1$onNext$2(this, r4));
        return;
    L16:
        return;
    L6:
        if (r0.intValue() != 0) goto L8;
        Handler r5 = CommonUtils.a;
        CommonUtils.d(new ECStoreViewModel$fetchTabChunk$1$1$onNext$1(this, r4));
    }
}
