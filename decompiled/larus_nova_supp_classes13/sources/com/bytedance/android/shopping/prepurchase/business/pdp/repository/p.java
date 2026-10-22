package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.helper.PdpSliceLocalCacheHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p {
    public volatile n a;
    public final Map<String, c> b;
    public final Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> c;
    public final String d;
    public final com.bytedance.android.shopping.prepurchase.arch.container.ability.j e;
    public final PdpSliceLocalCacheHelper f;

    public static final class a {
    }

    public final class b implements com.bytedance.android.shopping.prepurchase.business.pdp.repository.c, d {
        public final e a;
        public final /* synthetic */ p b;

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.d
        public final void a(PackResponseDTO r2) {
            Intrinsics.checkNotNullParameter(r2, "dTO");
            this.a.a(r2);
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.c
        public final n d(int r3) {
            n r4 = this.a.c(this.b.a, r3);
            this.b.a = r4;
            return r4;
        }

        public b(p r2, e r3) {
            Intrinsics.checkNotNullParameter(r3, "base");
            this.b = r2;
            this.a = r3;
        }
    }

    public final class c {
        public final List<d> a;
        public final b b;

        public final void a(PackResponseDTO r3) {
            Intrinsics.checkNotNullParameter(r3, "dTO");
            Iterator<T> r0 = this.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((d) r0.next()).a(r3);
            goto L4
        }

        public c(b r3, d r4) {
            Intrinsics.checkNotNullParameter(r3, "dataParser");
            Intrinsics.checkNotNullParameter(r4, "cacheHandler");
            this.b = r3;
            this.a = CollectionsKt.listOf(new d[]{r3, r4});
        }
    }

    static {
    }

    public final b a(PackResponseDTO r6) {
        Intrinsics.checkNotNullParameter(r6, "packDTO");
        if (r6.isOptRespProcess() == true) goto L5;
        this.e.d("ProductNetDataLayer", "createOrGetParser isFirstChunk=" + r6.isFirstChunk() + ", hasMultipleChunks=" + r6.hasMultipleChunks() + ", chunkRequestId=" + r6.getStatus().e);
        if (r6.hasMultipleChunks() == true) goto L9;
    L28:
        c r0 = new c(new b(this, new g(this.c, this.f)), new com.bytedance.android.shopping.prepurchase.business.pdp.repository.a(this.d));
        r0.a(r6);
        if (r6.isFirstChunk() == false) goto L41;
        String r7 = r6.getStatus().e;
        if (r7 == null) goto L41;
        Map<String, c> r1 = this.b;
        monitor-enter(r1);
        this.b.put(r7, r0);     // Catch: Throwable -> L37
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r1);
    L37:
        th = move-exception;
        throw th;
    L41:
        return r0.b;
    L9:
        if (r6.isFirstChunk() == true) goto L28;
        String r2 = r6.getStatus().e;
        if (r2 == null) goto L26;
        Map<String, c> r3 = this.b;
        monitor-enter(r3);
        c r4 = this.b.remove(r2);     // Catch: Throwable -> L23
        if (r4 == null) goto L20;
        r4.a(r6);     // Catch: Throwable -> L23
        b r9 = r4.b;     // Catch: Throwable -> L23
        monitor-exit(r3);
        return r9;
    L20:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r3);
    L23:
        th = move-exception;
        throw th;
    L26:
        c r10 = new c(new b(this, new g(this.c, this.f)), new com.bytedance.android.shopping.prepurchase.business.pdp.repository.a(this.d));
        r10.a(r6);
        return r10.b;
    L5:
        return b(r6).b;
    }

    public final synchronized c b(PackResponseDTO r9) {
        monitor-enter(this);
        String r0 = r9.getStatus().e;     // Catch: Throwable -> L33
        c r1 = null;
        if (r0 == null) goto L6;
        c r2 = (c) ((LinkedHashMap) this.b).get(r0);     // Catch: Throwable -> L33
    L7:
        boolean r4 = false;
        if (r9.hasMultipleChunks() == true) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r2 != null) goto L19;
        if (r3 == false) goto L19;
        PackResponseDTO r5 = r9.getHeadChunk();     // Catch: Throwable -> L33
        if (r5 == null) goto L18;
        r1 = b(r5);     // Catch: Throwable -> L33
    L18:
        r2 = r1;
    L19:
        if (r2 != null) goto L21;
        r2 = new c(new b(this, new h(this.c, this.f)), new f(this.d));     // Catch: Throwable -> L33
        r2.a(r9);     // Catch: Throwable -> L33
    L23:
        if (r0 != null) goto L25;
    L26:
        r4 = true;
    L27:
        if (r4 == false) goto L29;
    L31:
        monitor-exit(this);
        return r2;
    L29:
        if (r9.isFirstChunk() == false) goto L31;
        ((LinkedHashMap) this.b).clear();     // Catch: Throwable -> L33
        this.b.put(r0, r2);     // Catch: Throwable -> L33
        goto L31
    L25:
        if (r0.length() != 0) goto L27;
    L21:
        if (r3 == false) goto L23;
        r2.a(r9);     // Catch: Throwable -> L33
        goto L23
    L10:
        if (r9.getValidChunkIndex() <= 0) goto L12;
        r3 = true;
        goto L13
    L6:
        r2 = null;
    L33:
        th = move-exception;
        throw th;
    }

    public p(String r2, com.bytedance.android.shopping.prepurchase.arch.container.ability.j r3, PdpSliceLocalCacheHelper r4) {
        Intrinsics.checkNotNullParameter(r2, "cacheKey");
        Intrinsics.checkNotNullParameter(r3, "logger");
        Intrinsics.checkNotNullParameter(r4, "sliceLocalCacheHelper");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = new n(0);
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }
}
