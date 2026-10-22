package com.bytedance.android.livesdk.live.listprovider;

import android.util.Pair;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ String a;

    public j(String r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        m.a.put(this.a, (Pair) r3);
        ALogger.i("FeedCacheListProvider", "pre request finished for " + this.a);
    }
}
