package io.ktor.client.plugins.cache;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.g;
import io.ktor.http.j;
import io.ktor.http.n;
import io.ktor.http.o;
import io.ktor.http.q;
import io.ktor.http.r;
import io.ktor.http.u;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.k;
import io.ktor.utils.io.core.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class HttpCacheEntryKt {
    public static final Map<String, String> d(io.ktor.client.statement.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        n r101 = r100.getHeaders();
        List<String> r102 = r.f491904a;
        List<String> r103 = r101.a("Vary");
        if (r103 == null) goto L12;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L13;
        List r106 = StringsKt.split$default((String) r105.next(), new String[]{","}, false, 0, 6, null);
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
    L9:
        if (r108.hasNext() == false) goto L11;
        r107.add(StringsKt.trim((String) r108.next()).toString());
        goto L9
    L11:
        CollectionsKt.addAll(r104, r107);
    L13:
        if (r104 == null) goto L15;
        LinkedHashMap r109 = new LinkedHashMap();
        n r110 = r100.a80().c().getHeaders();
        Iterator r111 = r104.iterator();
    L18:
        if (r111.hasNext() == false) goto L23;
        String r112 = (String) r111.next();
        String r113 = r110.get(r112);
        if (r113 != null) goto L22;
        r113 = "";
    L22:
        r109.put(r112, r113);
        goto L18
    L23:
        return r109;
    L15:
        return MapsKt.emptyMap();
    L12:
        r104 = null;
        goto L13
    }

    public static hsc.a b(io.ktor.client.statement.b r110, boolean r111) {
        HttpCacheEntryKt$cacheExpires$1 r100 = HttpCacheEntryKt$cacheExpires$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r100, "fallback");
        List<j> r101 = u.a(r110);
        Long r102 = null;
        if (r111 == false) goto L18;
        List<j> r112 = r101;
        String r103 = "s-maxage";
        if ((r112 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r113 = r112.iterator();
    L11:
        if (r113.hasNext() == false) goto L15;
        if (StringsKt.startsWith$default(((j) r113.next()).f491875a, "s-maxage", false, 2, null) == false) goto L11;
        boolean r114 = true;
    L16:
        if (r114 == false) goto L18;
    L19:
        Iterator<T> r115 = r101.iterator();
    L21:
        if (r115.hasNext() == false) goto L25;
        Object r104 = r115.next();
        if (StringsKt.startsWith$default(((j) r104).f491875a, r103, false, 2, null) == false) goto L21;
    L26:
        j r105 = (j) r104;
        if (r105 == null) goto L35;
        String r106 = r105.f491875a;
        if (r106 == null) goto L35;
        List r116 = StringsKt.split$default(r106, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null);
        if (r116 == null) goto L35;
        String r117 = (String) ListProtector.get(r116, 1);
        if (r117 == null) goto L35;
        r102 = StringsKt.toLongOrNull(r117);
    L35:
        if (r102 == null) goto L37;
        hsc.a r118 = r110.b();
        long r107 = r102.longValue() * 1000;
        Intrinsics.checkNotNullParameter(r118, "<this>");
        return io.ktor.util.date.a.b(Long.valueOf(r118.f487089i + r107));
    L37:
        n r119 = r110.getHeaders();
        List<String> r120 = r.f491904a;
        String r121 = r119.get("Expires");
        if (r121 == null) goto L49;
        if (Intrinsics.areEqual(r121, "0") == true) goto L60;
        if (StringsKt.isBlank(r121) == true) goto L60;
        return g.a(r121);
    L59:
        return r100.invoke();
    L60:
        return r100.invoke();
    L49:
        return r100.invoke();
    L25:
        r104 = null;
    L15:
        r114 = false;
        goto L16
    L7:
        if (r112.isEmpty() == false) goto L9;
    L18:
        r103 = HTTP.MAX_AGE;
        goto L19
    }

    public static final Object a(boolean r100, io.ktor.client.statement.b r101, Continuation<? super b> r102) {
        if ((r102 instanceof HttpCacheEntryKt$HttpCacheEntry$1) == false) goto L7;
        HttpCacheEntryKt$HttpCacheEntry$1 r103 = (HttpCacheEntryKt$HttpCacheEntry$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r100 = r103.Z$0;
        r101 = (io.ktor.client.statement.b) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        byte[] r108 = v.b((k) r105);
        HttpResponseKt.b(r101);
        return new b(b(r101, r100), d(r101), r101, r108);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        ByteReadChannel r109 = r101.a();
        r103.L$0 = r101;
        r103.Z$0 = r100;
        r103.label = 1;
        r105 = ByteReadChannel.a.a(r109, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new HttpCacheEntryKt$HttpCacheEntry$1(r102);
        goto L8
    }

    public static final ValidateStatus c(hsc.a r110, n r111, HttpRequestBuilder r112) {
        Intrinsics.checkNotNullParameter(r110, "cacheExpires");
        Intrinsics.checkNotNullParameter(r111, "responseHeaders");
        Intrinsics.checkNotNullParameter(r112, "request");
        o r100 = r112.f491760c;
        List<String> r101 = r.f491904a;
        List<String> r102 = r111.a("Cache-Control");
        Object r103 = null;
        if (r102 == null) goto L5;
        String r104 = CollectionsKt.joinToString$default(r102, ",", null, null, 0, null, null, 62, null);
    L6:
        List<j> r105 = q.a(r104);
        List<String> r106 = r100.a("Cache-Control");
        if (r106 == null) goto L9;
        String r107 = CollectionsKt.joinToString$default(r106, ",", null, null, 0, null, null, 62, null);
    L10:
        List<j> r108 = q.a(r107);
        j r109 = a.f491674a;
        if (r108.contains(a.f491675b) == false) goto L14;
        HttpCacheKt.f491672a.trace("\"no-cache\" is set for " + r112.f491758a + ", should validate cached response");
        return ValidateStatus.ShouldValidate;
    L14:
        List<j> r113 = r108;
        Iterator<T> r114 = r113.iterator();
    L15:
        int r115 = 0;
        if (r114.hasNext() == false) goto L20;
        Object r116 = r114.next();
        if (StringsKt.startsWith$default(((j) r116).f491875a, "max-age=", false, 2, null) == false) goto L15;
    L21:
        j r117 = (j) r116;
        if (r117 == null) goto L34;
        String r118 = r117.f491875a;
        if (r118 == null) goto L34;
        List r119 = StringsKt.split$default(r118, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null);
        if (r119 == null) goto L34;
        String r120 = (String) ListProtector.get(r119, 1);
        if (r120 == null) goto L34;
        Integer r121 = StringsKt.toIntOrNull(r120);
        if (r121 == null) goto L32;
        int r122 = r121.intValue();
    L33:
        Integer r123 = Integer.valueOf(r122);
    L35:
        if (r123 != null) goto L38;
    L41:
        j r124 = a.f491674a;
        if (r105.contains(a.f491675b) == false) goto L45;
        HttpCacheKt.f491672a.trace("\"no-cache\" is set for " + r112.f491758a + ", should validate cached response");
        return ValidateStatus.ShouldValidate;
    L45:
        long r125 = r110.f487089i - System.currentTimeMillis();
        if (r125 <= 0) goto L50;
        HttpCacheKt.f491672a.trace("Cached response is valid for " + r112.f491758a + ", should not validate");
        return ValidateStatus.ShouldNotValidate;
    L50:
        if (r105.contains(a.f491678e) == false) goto L53;
        HttpCacheKt.f491672a.trace("\"must-revalidate\" is set for " + r112.f491758a + ", should validate cached response");
        return ValidateStatus.ShouldValidate;
    L53:
        Iterator<T> r126 = r113.iterator();
    L55:
        if (r126.hasNext() == false) goto L59;
        Object r127 = r126.next();
        if (StringsKt.startsWith$default(((j) r127).f491875a, "max-stale=", false, 2, null) == false) goto L55;
        r103 = r127;
    L59:
        j r128 = (j) r103;
        if (r128 == null) goto L69;
        String r129 = r128.f491875a;
        if (r129 == null) goto L69;
        String r130 = r129.substring(10);
        if (r130 == null) goto L69;
        Integer r131 = StringsKt.toIntOrNull(r130);
        if (r131 == null) goto L69;
        r115 = r131.intValue();
    L69:
        if ((r125 + (((long) r115) * 1000)) <= 0) goto L72;
        HttpCacheKt.f491672a.trace("Cached response is stale for " + r112.f491758a + " but less than max-stale, should warn");
        return ValidateStatus.ShouldWarn;
    L72:
        HttpCacheKt.f491672a.trace("Cached response is stale for " + r112.f491758a + ", should validate cached response");
        return ValidateStatus.ShouldValidate;
    L38:
        if (r123.intValue() != 0) goto L41;
        HttpCacheKt.f491672a.trace("\"max-age\" is not set for " + r112.f491758a + ", should validate cached response");
        return ValidateStatus.ShouldValidate;
    L32:
        r122 = 0;
    L34:
        r123 = null;
        goto L35
    L20:
        r116 = null;
        goto L21
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
