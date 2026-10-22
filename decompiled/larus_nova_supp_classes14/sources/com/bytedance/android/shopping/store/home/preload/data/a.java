package com.bytedance.android.shopping.store.home.preload.data;

import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import kotlin.Triple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements com.bytedance.android.chunkstreamprediction.network.b.b<ECStoreHomeTabResponseTabkit> {
    public final /* synthetic */ Triple a;

    public a(Triple<ECStoreHomeTabResponseTabkit[], Long, fl.b> r1) {
        this.a = r1;
    }

    public void call(com.bytedance.android.chunkstreamprediction.network.b<ECStoreHomeTabResponseTabkit> r2, com.bytedance.android.chunkstreamprediction.network.a<ECStoreHomeTabResponseTabkit> r3) {
        if (r3 == null) goto L4;
        r3.onNext(((ECStoreHomeTabResponseTabkit[]) this.a.getFirst())[0]);
    L4:
        if (r3 == null) goto L7;
        r3.onNext(((ECStoreHomeTabResponseTabkit[]) this.a.getFirst())[1]);
        return;
    }
}
