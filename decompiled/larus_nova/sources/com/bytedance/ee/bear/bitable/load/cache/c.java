package com.bytedance.ee.bear.bitable.load.cache;

import android.util.LruCache;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends LruCache<a, BitableResourceData> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f214475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f214476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f214477c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f214478d;

        public final int hashCode() {
            return (((((this.f214477c.hashCode() * 31) + this.f214475a.hashCode()) * 31) + this.f214476b.hashCode()) * 31) + this.f214478d.hashCode();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.load.cache.ResourceDataCache.CacheKey");
            a r102 = (a) r100;
            if (Intrinsics.areEqual(this.f214477c, r102.f214477c) == true) goto L15;
        L21:
            return false;
        L15:
            if (Intrinsics.areEqual(this.f214475a, r102.f214475a) == false) goto L21;
            if (Intrinsics.areEqual(this.f214476b, r102.f214476b) == false) goto L21;
            if (Intrinsics.areEqual(this.f214478d, r102.f214478d) == false) goto L21;
            return true;
        L8:
            r101 = null;
            goto L10
        }

        public a(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "baseToken");
            Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.BLOCK_ID);
            Intrinsics.checkNotNullParameter(r102, "resKey");
            Intrinsics.checkNotNullParameter(r103, "objToken");
            this.f214475a = r100;
            this.f214476b = r101;
            this.f214477c = r102;
            this.f214478d = r103;
        }
    }

    public static final class b {
    }

    static {
    }

    public c(int r100) {
        super(r100);
    }

    @Override // android.util.LruCache
    public final int sizeOf(a r100, BitableResourceData r101) {
        BitableResourceData r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r102 == null) goto L7;
        String r103 = r102.getResValue();
        if (r103 == null) goto L7;
        return r103.length();
    L7:
        return 0;
    }
}
