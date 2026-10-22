package com.bytedance.android.shopping.deepfeed.data;

import com.bytedance.android.shopping.deepfeed.data.repo.l;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedProductDataCenter {
    public static final HashMap<String, l> a = null;
    public static final ConcurrentHashMap<String, DeepFeedQueryParam> b = null;
    public static final ConcurrentHashMap<String, SoftReference<Pair<DeepFeedQueryParam, l>>> c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;

    public static boolean b() {
        return ((Boolean) d.getValue()).booleanValue();
    }

    static {
        a = new HashMap();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = LazyKt.lazy(DeepFeedProductDataCenter$preInflateEnabled$2.INSTANCE);
        e = LazyKt.lazy(DeepFeedProductDataCenter$paramCacheEnabled$2.INSTANCE);
    }

    public static l a(DeepFeedQueryParam r3) {
        Intrinsics.checkNotNullParameter(r3, "param");
        String r0 = String.valueOf(r3.getUid());
        HashMap<String, l> r1 = a;
        l r2 = r1.get(r0);
        if (r2 != null) goto L6;
        l.s.getClass();
        Intrinsics.checkNotNullParameter(r3, "params");
        l r4 = new l(r3);
        r1.put(r0, r4);
        return r4;
    L6:
        return r2;
    }
}
