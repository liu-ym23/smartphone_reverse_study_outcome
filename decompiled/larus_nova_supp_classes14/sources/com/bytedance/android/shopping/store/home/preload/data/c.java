package com.bytedance.android.shopping.store.home.preload.data;

import android.util.LruCache;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements com.bytedance.android.chunkstreamprediction.network.a<ECStoreHomeTabResponseTabkit> {
    public ECStoreHomeTabResponseTabkit a;
    public final /* synthetic */ d b;

    public final void onComplete() {
    }

    public final void onFailed(Throwable r1) {
    }

    public c(d r1) {
        this.b = r1;
    }

    public final void onNext(Object r8) {
        ECStoreHomeTabResponseTabkit r9 = (ECStoreHomeTabResponseTabkit) r8;
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.getStatusCode() != 0) goto L20;
        Integer r0 = r9.getChunkIndex();
        if (r0 != null) goto L10;
    L12:
        Integer r1 = r9.getChunkIndex();
        if (r1 != null) goto L16;
        return;
    L16:
        if (r1.intValue() != 1) goto L22;
        d r2 = this.b;
        LruCache<String, Triple<ECStoreHomeTabResponseTabkit[], Long, fl.b>> r3 = r2.a.c;
        String r4 = r2.b;
        ECStoreHomeTabResponseTabkit r5 = this.a;
        Intrinsics.checkNotNull(r5);
        r3.put(r4, new Triple(new ECStoreHomeTabResponseTabkit[]{r5, r9}, Long.valueOf(System.currentTimeMillis()), this.b.c));
        return;
    L22:
        return;
    L10:
        if (r0.intValue() != 0) goto L12;
        this.a = r9;
        return;
    }
}
