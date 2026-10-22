package com.bytedance.android.shopping.deepfeed.data;

import android.net.Uri;
import com.bytedance.android.shopping.deepfeed.data.repo.l;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DeepFeedProductDataCenter$preloadFromUri$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ String $url;

    public DeepFeedProductDataCenter$preloadFromUri$1(String r1, String r2) {
        this.$cacheKey = r1;
        this.$url = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m777invoke() {
        if (DeepFeedProductDataCenter.c.containsKey(this.$cacheKey) == false) goto L26;
        return;
    L26:
        Uri r0 = UriProtector.parse(this.$url);     // Catch: Throwable -> L25
        Uri.Builder r1 = r0.buildUpon().clearQuery();     // Catch: Throwable -> L25
        Set r2 = UriProtector.getQueryParameterNames(r0);     // Catch: Throwable -> L25
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L25
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L25
    L7:
        if (r4.hasNext() == false) goto L11;
        Object r5 = r4.next();     // Catch: Throwable -> L25
        if ((!Intrinsics.areEqual((String) r5, "filters")) == false) goto L7;
        r3.add(r5);     // Catch: Throwable -> L25
        goto L7
    L11:
        Iterator r6 = r3.iterator();     // Catch: Throwable -> L25
    L13:
        if (r6.hasNext() == false) goto L17;
        String r7 = (String) r6.next();     // Catch: Throwable -> L25
        String r8 = UriProtector.getQueryParameter(r0, r7);     // Catch: Throwable -> L25
        if (r8 == null) goto L13;
        r1.appendQueryParameter(r7, r8);     // Catch: Throwable -> L25
        goto L13
    L17:
        Uri r9 = r1.build();     // Catch: Throwable -> L25
        DeepFeedQueryParam r10 = c.a(r9);     // Catch: Throwable -> L25
        l r11 = DeepFeedProductDataCenter.a(r10);     // Catch: Throwable -> L25
        r11.f(r9);     // Catch: Throwable -> L25
        DeepFeedProductDataCenter.c.putIfAbsent(this.$cacheKey, new SoftReference(TuplesKt.to(r10, r11)));     // Catch: Throwable -> L25
    L18:
        ConcurrentHashMap<String, SoftReference<Pair<DeepFeedQueryParam, l>>> r12 = DeepFeedProductDataCenter.c;     // Catch: Throwable -> L25
        if (r12.size() <= 8) goto L23;
        String r13 = (String) CollectionsKt.firstOrNull(r12.keySet());     // Catch: Throwable -> L25
        if (r13 == null) goto L18;
        SoftReference<Pair<DeepFeedQueryParam, l>> r14 = r12.remove(r13);     // Catch: Throwable -> L25
        goto L18
    L23:
        int r15 = b.a;     // Catch: Throwable -> L25
        DeepFeedProductDataCenter.b();     // Catch: Throwable -> L25
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m777invoke();
        return Unit.INSTANCE;
    }
}
