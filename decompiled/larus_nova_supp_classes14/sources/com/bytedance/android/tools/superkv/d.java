package com.bytedance.android.tools.superkv;

import android.util.LruCache;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements e, f.a {
    public final boolean a;
    public final f b;
    public final LruCache<String, Object> c;

    public class a implements f {
        @Override // com.bytedance.android.tools.superkv.f
        public final void a() {
        }

        @Override // com.bytedance.android.tools.superkv.f
        public final int b(List r1) {
            return 1;
        }

        @Override // com.bytedance.android.tools.superkv.f
        public final int c(String r1, String r2) {
            return 1;
        }

        @Override // com.bytedance.android.tools.superkv.f
        public final bm3.b get(String r1) {
            return null;
        }

        @Override // com.bytedance.android.tools.superkv.f
        public final void release() {
        }

        @Override // com.bytedance.android.tools.superkv.f
        public final void remove(String r1) {
        }

        public a() {
        }
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final List b() {
        if (this.a == false) goto L5;
        this.b.a();
    L5:
        Object r0 = this.c.get("__prefetch_cache_key_array");
        if (r0 != null) goto L8;
        bm3.b r1 = c("__prefetch_cache_key_array", 10);
        if (r1 != null) goto L14;
        return null;
    L14:
        return r1.k;
    L8:
        return (List) r0;
    }

    public d() {
        this.a = false;
        this.c = new LruCache(Integer.MAX_VALUE);
        this.b = new a();
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final void a(Collection r3) {
        this.b.b(new ArrayList(r3));
        this.c.put("__prefetch_cache_key_array", r3);
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final String getString(String r2) {
        if (this.a == false) goto L5;
        this.b.a();
    L5:
        Object r0 = this.c.get(r2);
        if (r0 != null) goto L8;
        bm3.b r3 = c(r2, 8);
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.i;
    L8:
        return (String) r0;
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final void remove(String r2) {
        this.b.remove(r2);
        this.c.remove(r2);
    }

    public d(String r2, int r3) throws IOException {
        this.a = false;
        this.c = new LruCache(r3);
        this.b = new g(r2, this);
    }

    public final bm3.b c(String r5, int r6) {
        bm3.b r0 = this.b.get(r5);
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.c != r6) goto L10;
        return r0;
    L10:
        throw new IllegalStateException("Wrong type with key: " + r5 + ", expected: " + bm3.b.b(Integer.valueOf(r6)) + ", found: " + bm3.b.b(Integer.valueOf(r0.c)));
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final void putString(String r2, String r3) {
        this.b.c(r2, r3);
        this.c.put(r2, r3);
    }
}
