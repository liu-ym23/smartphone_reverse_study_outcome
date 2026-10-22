package io.ktor.client.plugins.cache;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.plugins.j;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.f;
import io.ktor.http.Url;
import io.ktor.http.h;
import io.ktor.http.l0;
import io.ktor.http.n;
import io.ktor.http.u;
import io.ktor.http.w;
import io.ktor.http.x;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class HttpCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f491671a = 0;

    public static final class a implements j<Object, HttpCache> {
        public static Object a(io.ktor.util.pipeline.b r100, io.ktor.client.a r110, Continuation r111) {
            r100.b();
            io.ktor.client.request.c r101 = ((HttpRequestBuilder) r100.getContext()).a();
            x r102 = x.f491925l;
            hsc.a r103 = io.ktor.util.date.a.b(null);
            n.f491892a.getClass();
            h r104 = n.a.f491894b;
            w.f491909d.getClass();
            Object r105 = r100.e(new HttpClientCall(r110, r101, new f(r102, r103, r104, w.f491911f, io.ktor.utils.io.c.a(new byte[0]), r101.f491774e)), r111);
            if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r105;
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((io.ktor.client.plugins.cache.storage.b) r101).f491701d, ((io.ktor.client.plugins.cache.storage.b) r100).f491701d);
        }
    }

    static {
        Intrinsics.checkNotNullParameter("HttpCache", "name");
        new io.ktor.events.a();
    }

    public static final Object a(HttpCache r210, io.ktor.client.request.b r211, io.ktor.client.statement.b r212, Continuation r213) {
        r210.getClass();
        if ((r213 instanceof HttpCache$findAndRefresh$1) == false) goto L7;
        HttpCache$findAndRefresh$1 r100 = (HttpCache$findAndRefresh$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        HttpCache$findAndRefresh$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        io.ktor.client.plugins.cache.storage.b r106 = (io.ktor.client.plugins.cache.storage.b) r102.L$2;
        io.ktor.client.statement.b r107 = (io.ktor.client.statement.b) r102.L$1;
        io.ktor.client.request.b r108 = (io.ktor.client.request.b) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L37:
        return HttpCacheStorageKt.a(r106, r108.a80().f491622a, r108, r107.getCoroutineContext());
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Map<String, String> r109 = (Map) r102.L$4;
        io.ktor.client.plugins.cache.storage.a r110 = (io.ktor.client.plugins.cache.storage.a) r102.L$3;
        io.ktor.client.statement.b r111 = (io.ktor.client.statement.b) r102.L$2;
        io.ktor.client.request.b r112 = (io.ktor.client.request.b) r102.L$1;
        HttpCache r113 = (HttpCache) r102.L$0;
        ResultKt.throwOnFailure(r103);
        io.ktor.client.statement.b r114 = r111;
    L26:
        io.ktor.client.plugins.cache.storage.b r115 = (io.ktor.client.plugins.cache.storage.b) r103;
        if (r115 != null) goto L30;
        return null;
    L30:
        if (r109.isEmpty() == false) goto L32;
        r109 = r115.f491705h;
    L32:
        Url r116 = r112.getUrl();
        r113.getClass();
        hsc.a r117 = HttpCacheEntryKt.b(r114, false);
        Intrinsics.checkNotNullParameter(r109, "varyKeys");
        Intrinsics.checkNotNullParameter(r117, "expires");
        Map<String, String> r214 = r109;
        io.ktor.client.plugins.cache.storage.b r118 = new io.ktor.client.plugins.cache.storage.b(r115.f491698a, r115.f491699b, r115.f491700c, r115.f491701d, r115.f491702e, r117, r115.f491704g, r214, r115.f491706i);
        r102.L$0 = r112;
        r102.L$1 = r114;
        r102.L$2 = r115;
        r102.L$3 = null;
        r102.L$4 = null;
        r102.label = 2;
        Object r119 = r110.b(r116, r118, r102);
        Object r120 = r104;
        if (r119 == r120) goto L39;
        r106 = r115;
        r108 = r112;
        r107 = r114;
    L39:
        return r120;
    L16:
        ResultKt.throwOnFailure(r103);
        Url r121 = r212.a80().c().getUrl();
        boolean r122 = u.a(r212).contains(io.ktor.client.plugins.cache.a.f491676c);
        if (r122 == false) goto L19;
        r210.getClass();
    L19:
        if (r122 == false) goto L21;
        io.ktor.client.plugins.cache.storage.a r123 = null;
        r210.getClass();
    L22:
        io.ktor.client.plugins.cache.storage.a r124 = r123;
        Map<String, String> r125 = HttpCacheEntryKt.d(r212);
        r102.L$0 = r210;
        r102.L$1 = r211;
        r114 = r212;
        r102.L$2 = r114;
        r102.L$3 = r124;
        r102.L$4 = r125;
        r102.label = 1;
        r103 = r210.c(r124, r125, r121, r211, r102);
        if (r103 != r104) goto L25;
        r120 = r104;
        goto L39
    L25:
        r113 = r210;
        r110 = r124;
        r109 = r125;
        r112 = r211;
        goto L26
    L21:
        r123 = null;
        r210.getClass();
    L7:
        r100 = new HttpCache$findAndRefresh$1(r210, r213);
        goto L8
    }

    public static final Object b(HttpCache r100, HttpRequestBuilder r101, io.ktor.http.content.c r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof HttpCache$findResponse$4) == false) goto L7;
        HttpCache$findResponse$4 r104 = (HttpCache$findResponse$4) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L34;
        if (r107 == 1) goto L32;
        if (r107 != 2) goto L31;
        Set r108 = (Set) r104.L$1;
        Function1 r109 = (Function1) r104.L$0;
        ResultKt.throwOnFailure(r106);
        Iterator r110 = SetsKt.plus(r108, (Iterable) r106).iterator();
    L14:
        if (r110.hasNext() == false) goto L45;
        io.ktor.client.plugins.cache.storage.b r111 = (io.ktor.client.plugins.cache.storage.b) r110.next();
        Map<String, String> r112 = r111.f491705h;
        if (r112.isEmpty() == true) goto L29;
        if (r112.isEmpty() == true) goto L26;
        Iterator<Map.Entry<String, String>> r113 = r112.entrySet().iterator();
    L22:
        if (r113.hasNext() == false) goto L26;
        Map.Entry<String, String> r114 = r113.next();
        String r115 = r114.getKey();
        String r116 = r114.getValue();
        if (Intrinsics.areEqual(r109.invoke(r115), r116) == true) goto L22;
        boolean r117 = false;
    L27:
        if (r117 == false) goto L14;
    L26:
        r117 = true;
    L29:
        return r111;
    L45:
        return null;
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L32:
        Function1 r118 = (Function1) r104.L$2;
        Url r119 = (Url) r104.L$1;
        HttpCache r120 = (HttpCache) r104.L$0;
        ResultKt.throwOnFailure(r106);
        r120.getClass();
        r104.L$0 = r118;
        r104.L$1 = (Set) r106;
        r104.L$2 = null;
        r104.label = 2;
        throw null;
    L34:
        ResultKt.throwOnFailure(r106);
        Url r121 = l0.a(r101.f491758a);
        Function1<String, String> r122 = HttpCacheKt.a(r102, new HttpCache$findResponse$lookup$1(r101.f491760c), new HttpCache$findResponse$lookup$2(r101.f491760c));
        r100.getClass();
        r104.L$0 = r100;
        r104.L$1 = r121;
        r104.L$2 = r122;
        r104.label = 1;
        throw null;
    L7:
        r104 = new HttpCache$findResponse$4(r100, r103);
        goto L8
    }

    public final Object c(io.ktor.client.plugins.cache.storage.a r100, Map<String, String> r101, Url r102, io.ktor.client.request.b r103, Continuation<? super io.ktor.client.plugins.cache.storage.b> r110) {
        if ((r110 instanceof HttpCache$findResponse$1) == false) goto L7;
        HttpCache$findResponse$1 r104 = (HttpCache$findResponse$1) r110;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r111 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        Function1<String, String> r108 = (Function1) r104.L$0;
        ResultKt.throwOnFailure(r111);
    L26:
        Iterator r109 = CollectionsKt.sortedWith((Iterable) r111, new b()).iterator();
    L28:
        if (r109.hasNext() == false) goto L40;
        Object r112 = r109.next();
        Map<String, String> r113 = ((io.ktor.client.plugins.cache.storage.b) r112).f491705h;
        if (r113.isEmpty() == false) goto L32;
    L31:
        boolean r114 = true;
    L38:
        if (r114 == false) goto L28;
    L42:
        return (io.ktor.client.plugins.cache.storage.b) r112;
    L32:
        Iterator<Map.Entry<String, String>> r115 = r113.entrySet().iterator();
    L34:
        if (r115.hasNext() == false) goto L31;
        Map.Entry<String, String> r116 = r115.next();
        String r117 = r116.getKey();
        if (Intrinsics.areEqual(r108.invoke(r117), r116.getValue()) == true) goto L34;
        r114 = false;
        goto L38
    L40:
        r112 = null;
        goto L42
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
    L21:
        return r111;
    L16:
        ResultKt.throwOnFailure(r111);
        if ((!r101.isEmpty()) == false) goto L22;
        r104.label = 1;
        r111 = r100.a(r102, r101, r104);
        if (r111 != r106) goto L21;
        return r106;
    L22:
        Function1<String, String> r118 = HttpCacheKt.a(r103.getContent(), new HttpCache$findResponse$requestHeaders$1(r103.getHeaders()), new HttpCache$findResponse$requestHeaders$2(r103.getHeaders()));
        r104.L$0 = r118;
        r104.label = 2;
        r111 = r100.c(r102, r104);
        if (r111 != r106) goto L25;
        return r106;
    L25:
        r108 = r118;
    L7:
        r104 = new HttpCache$findResponse$1(this, r110);
        goto L8
    }
}
