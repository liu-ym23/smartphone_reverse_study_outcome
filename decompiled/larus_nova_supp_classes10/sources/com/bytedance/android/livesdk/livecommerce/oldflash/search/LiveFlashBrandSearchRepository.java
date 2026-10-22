package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import xi2.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveFlashBrandSearchRepository implements a {
    public boolean a;
    public final k0 b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.search.a
    public final Map<String, List<Pair<String, String>>> e() {
        k0 r0 = this.b;
        if (r0 == null) goto L6;
        String r1 = r0.a();
        if (r1 == null) goto L6;
    L48:
        int r2 = m0.a;     // Catch: Exception -> L9
        xi2.b r3 = (xi2.b) m0.a.a.fromJson(r1, xi2.b.class);     // Catch: Exception -> L9
    L11:
        if (r3 == null) goto L15;
        boolean r4 = true;
        if (r3.b() != true) goto L15;
    L16:
        this.a = r4;
        LinkedHashMap r5 = new LinkedHashMap();
        ArrayList r6 = new ArrayList();
        k0 r7 = this.b;
        if (r7 == null) goto L47;
        List<String> r8 = r7.b();
        if (r8 == null) goto L47;
        if (r3 == null) goto L23;
        List<String> r9 = r3.a();
        if (r9 == null) goto L23;
    L24:
        IntIterator r10 = CollectionsKt.getIndices(r8).iterator();
    L26:
        if (r10.hasNext() == false) goto L32;
        int r11 = r10.nextInt();
        if (r9.size() <= r11) goto L30;
        String r12 = (String) ListProtector.get(r9, r11);
    L31:
        r6.add(TuplesKt.to(ListProtector.get(r8, r11), r12));
        goto L26
    L30:
        r12 = "";
        goto L31
    L32:
        if (r3 == null) goto L47;
        Map<String, List<Integer>> r13 = r3.c();
        if (r13 == null) goto L47;
        Iterator<Map.Entry<String, List<Integer>>> r14 = r13.entrySet().iterator();
    L37:
        if (r14.hasNext() == false) goto L47;
        Map.Entry<String, List<Integer>> r15 = r14.next();
        List<Integer> r16 = r15.getValue();     // Catch: Exception -> L45
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));     // Catch: Exception -> L45
        Iterator<T> r18 = r16.iterator();     // Catch: Exception -> L45
    L41:
        if (r18.hasNext() == false) goto L43;
        r17.add((Pair) ListProtector.get(r6, ((Number) r18.next()).intValue()));     // Catch: Exception -> L45
        goto L41
    L43:
        r5.put(r15.getKey(), r17);     // Catch: Exception -> L45
    L45:
        e = move-exception;
        ECExceptionMonitor.c(String.valueOf(e.getMessage()));
    L23:
        r9 = CollectionsKt.emptyList();
    L47:
        return r5;
    L15:
        r4 = false;
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r3 = null;
    L6:
        r1 = "";
        goto L48
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.search.a
    public final String b() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.search.a
    public final String c() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.search.a
    public final boolean d() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.search.a
    public final Object a(String r4, Continuation<? super List<Pair<String, String>>> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new LiveFlashBrandSearchRepository$searchData$2(this, r4, null), r5);
    }

    public LiveFlashBrandSearchRepository(k0 r2, String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "categoryId");
        Intrinsics.checkNotNullParameter(r4, "shopId");
        Intrinsics.checkNotNullParameter(r5, "originText");
        Intrinsics.checkNotNullParameter(r6, "defaultString");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
