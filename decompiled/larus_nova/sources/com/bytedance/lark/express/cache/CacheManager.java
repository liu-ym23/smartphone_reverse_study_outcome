package com.bytedance.lark.express.cache;

import android.util.LruCache;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import rd6.b;
import rd6.c;
import sd6.a;

/* JADX INFO: loaded from: classes28.dex */
public final class CacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, List<a>> f252926a;

    public CacheManager() {
        this.f252926a = new LruCache(200);
    }

    public final void a(final String r100, final List<? extends a> r101) {
        Intrinsics.checkNotNullParameter(r100, "expr");
        Intrinsics.checkNotNullParameter(r101, "commands");
        c r102 = b.f537281b;
        if (r102 == null) goto L6;
        r102.a(new CacheManager$cache$1(this, r100, r101));
        return;
    }
}
