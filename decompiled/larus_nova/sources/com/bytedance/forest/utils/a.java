package com.bytedance.forest.utils;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C3497a f244506d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f244507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f244508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f244509c;

    /* JADX INFO: renamed from: com.bytedance.forest.utils.a$a, reason: collision with other inner class name */
    public static final class C3497a {
        public C3497a() {
        }

        public static a a(String r100, RequestParams r101, Forest r102) {
            String r103 = "";
            if (r101.f244270J == false) goto L13;
            WebResourceRequest r104 = r101.C;
            String r105 = r101.b();
            boolean r106 = r104 instanceof WebResourceRequest;
            if (r106 == false) goto L15;
            if (r106 == true) goto L8;
            r104 = null;
        L8:
            if (r104 == null) goto L12;
            Map<String, String> r107 = r104.getRequestHeaders();
            if (r107 == null) goto L12;
            r105 = r107.get("user-agent");
        L12:
            r105 = null;
        L15:
            if (StringsKt.isBlank(r100) == false) goto L35;
            String r108 = r101.f244272b;
            boolean r109 = false;
            if (r108.length() != 0) goto L19;
            boolean r110 = true;
        L20:
            if (r110 == false) goto L31;
            if (r102 == null) goto L29;
            com.bytedance.forest.model.i r111 = r102.getConfig();
            if (r111 == null) goto L29;
            GeckoConfig r112 = r111.f244346h;
            if (r112 == null) goto L29;
            r108 = r112.f244241b;
            if (r108 != null) goto L31;
        L29:
            r108 = "";
        L31:
            if (r108.length() != 0) goto L33;
            r109 = true;
        L33:
            if (r109 == false) goto L37;
            return null;
        L37:
            if (StringsKt.isBlank(r100) == false) goto L39;
            r100 = "https://gecko.offline.resource/" + r108 + '/' + r101.f244273c + '/' + r101.f244274d;
        L39:
            Set<String> r113 = r101.I;
            if (r105 == null) goto L43;
            r103 = r105;
        L43:
            return b(r100, r113, r103);
        L19:
            r110 = false;
            goto L20
        L35:
            r108 = "";
            goto L37
        L13:
            r105 = "";
            goto L15
        }

        public static a b(String r110, Set r111, String r112) {
            LinkedHashMap r100 = null;
            if (StringsKt.isBlank(r110) == false) goto L55;
            return null;
        L55:
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
            Object r102 = Result.m9449constructorimpl(UriProtector.parse(r110));     // Catch: Throwable -> L7
        L10:
            if (Result.m9455isFailureimpl(r102) == false) goto L12;
            r102 = null;
        L12:
            Uri r103 = (Uri) r102;
            if (r103 == null) goto L53;
            String r104 = "";
            if (r111 != null) goto L21;
            if (GeckoXAdapter.Companion.canParsed(r103) == true) goto L47;
            String r113 = r103.getQuery();
        L48:
            String r114 = s.c(r110);
            if (r113 == null) goto L52;
            r104 = r113;
        L52:
            return new a(r114, r104, r112);
        L47:
            r113 = "";
            goto L48
        L21:
            if (r111.isEmpty() == false) goto L23;
            r113 = s.c(r110);
            goto L48
        L23:
            Set r115 = r111;
            LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r115, 10)), 16));
            Iterator r116 = r115.iterator();
        L25:
            if (r116.hasNext() == false) goto L27;
            Object r106 = r116.next();
            r105.put(r106, s.b(r103, (String) r106));
            goto L25
        L27:
            LinkedHashMap r117 = new LinkedHashMap();
            Iterator r107 = r105.entrySet().iterator();
        L28:
            boolean r108 = true;
            if (r107.hasNext() == false) goto L37;
            Map.Entry r109 = (Map.Entry) r107.next();
            if (r109.getValue() != null) goto L34;
            r108 = false;
        L34:
            if (r108 == false) goto L28;
            r117.put(r109.getKey(), r109.getValue());
            goto L28
        L37:
            if ((!r117.isEmpty()) == false) goto L39;
            r100 = r117;
        L39:
            if (r100 == null) goto L47;
            ArrayList r118 = new ArrayList(r100.size());
            Iterator r119 = r100.entrySet().iterator();
        L42:
            if (r119.hasNext() == false) goto L44;
            Map.Entry r120 = (Map.Entry) r119.next();
            r118.add(((String) r120.getKey()) + com.alipay.sdk.m.n.a.f25612h + ((String) r120.getValue()));
            goto L42
        L44:
            r113 = CollectionsKt.joinToString$default(r118, "&", null, null, 0, null, null, 62, null);
            if (r113 == null) goto L47;
        L53:
            i.e(i.f244548a, "CacheIdentifier", "can not parse to uri from " + r110, null, true, 116);
            return null;
        L7:
            th = move-exception;
            Result.Companion r121 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
        }
    }

    static {
        f244506d = new C3497a();
    }

    public final int hashCode() {
        return (((this.f244507a.hashCode() * 31) + this.f244508b.hashCode()) * 31) + this.f244509c.hashCode();
    }

    public final String toString() {
        return "CacheIdentifier(baseUrl='" + this.f244507a + "', queryString='" + this.f244508b + "', userAgent='" + this.f244509c + "')";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        a r102 = (a) r100;
        if ((!Intrinsics.areEqual(this.f244507a, r102.f244507a)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.f244508b, r102.f244508b)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.f244509c, r102.f244509c)) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.utils.CacheIdentifier");
    L8:
        r101 = null;
        goto L10
    }

    public a(String r100, String r101, String r102) {
        this.f244507a = r100;
        this.f244508b = r101;
        this.f244509c = r102;
    }
}
