package com.bytedance.express.cache;

import android.util.LruCache;
import com.bytedance.express.ExprRunner;
import com.bytedance.express.command.b;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class CacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LruCache<String, List<b>> f243190a;

    public CacheManager(int r100) {
        if (r100 <= 0) goto L6;
        this.f243190a = new LruCache(r100);
        return;
    }

    public final void a(final String r100, final List<? extends b> r101) {
        ExprRunner.f243177f.getClass();
        com.bytedance.express.b r102 = ExprRunner.f243176e;
        if (r102 == null) goto L6;
        r102.a(new CacheManager$cache$1(this, r100, r101));
        return;
    }
}
