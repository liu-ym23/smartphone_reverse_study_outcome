package com.bytedance.android.shopping.store.slicecard;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final ConcurrentHashMap<String, ImageRequest[]> a = null;
    public static final c b = null;

    public c() {
    }

    static {
        b = new c();
        a = new ConcurrentHashMap();
    }

    public final void update(String r2, ImageRequest[] r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        a.put(r2, r3);
    }
}
