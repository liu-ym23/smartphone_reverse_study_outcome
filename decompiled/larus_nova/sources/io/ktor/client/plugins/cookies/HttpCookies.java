package io.ktor.client.plugins.cookies;

import androidx.collection.SieveCacheKt;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.ktor.client.plugins.j;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.CodecsKt;
import io.ktor.http.CookieDateParser;
import io.ktor.http.CookieEncoding;
import io.ktor.http.CookieKt;
import io.ktor.http.InvalidCookieDateException;
import io.ktor.http.Url;
import io.ktor.http.d;
import io.ktor.http.g;
import io.ktor.http.g0;
import io.ktor.http.l0;
import io.ktor.http.n;
import io.ktor.http.o;
import io.ktor.http.r;
import io.ktor.util.t;
import io.ktor.utils.io.core.k;
import io.ktor.utils.io.core.v;
import java.io.Closeable;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class HttpCookies implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f491710a = null;

    public static final class a implements j<Object, HttpCookies> {
        public a() {
        }
    }

    static {
        f491710a = new a();
        Intrinsics.checkNotNullParameter("HttpCookies", "name");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }

    public final Object a(HttpRequestBuilder r210, Continuation<? super Unit> r211) {
        if ((r211 instanceof HttpCookies$captureHeaderCookies$1) == false) goto L7;
        HttpCookies$captureHeaderCookies$1 r100 = (HttpCookies$captureHeaderCookies$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        HttpCookies r102 = this;
    L8:
        Object r103 = r100.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Iterator r105 = (Iterator) r100.L$2;
        Url r106 = (Url) r100.L$1;
        HttpCookies r107 = (HttpCookies) r100.L$0;
        ResultKt.throwOnFailure(r103);
    L23:
        if (r105.hasNext() == false) goto L28;
        d r108 = (d) r105.next();
        r107.getClass();
        r100.L$0 = r107;
        r100.L$1 = r106;
        r100.L$2 = r105;
        r100.label = 1;
        throw null;
    L28:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        g0 r109 = r210.f491758a;
        Intrinsics.checkNotNullParameter(r109, "<this>");
        ArrayList r110 = null;
        g0 r111 = new g0(null);
        l0.c(r111, r109);
        r106 = r111.b();
        o r112 = r210.f491760c;
        List<String> r113 = r.f491904a;
        String r114 = r112.i("Cookie");
        if (r114 == null) goto L20;
        c.f491711a.trace("Saving cookie " + r114 + " for " + r210.f491758a);
        Map<String, String> r115 = CookieKt.a(r114, true);
        r110 = new ArrayList(r115.size());
        Iterator<Map.Entry<String, String>> r116 = r115.entrySet().iterator();
    L18:
        if (r116.hasNext() == false) goto L20;
        Map.Entry<String, String> r117 = r116.next();
        r110.add(new d(r117.getKey(), r117.getValue(), CookieEncoding.URI_ENCODING, 0, null, null, null, false, false, MapsKt.emptyMap()));
    L20:
        if (r110 == null) goto L28;
        r105 = r110.iterator();
        r107 = r102;
    L7:
        r102 = this;
        r100 = new HttpCookies$captureHeaderCookies$1(r102, r211);
        goto L8
    }

    public final Object b(io.ktor.client.statement.b r210, Continuation<? super Unit> r211) {
        if ((r211 instanceof HttpCookies$saveCookiesFrom$1) == false) goto L7;
        HttpCookies$saveCookiesFrom$1 r100 = (HttpCookies$saveCookiesFrom$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        Iterator r104 = (Iterator) r100.L$2;
        Url r105 = (Url) r100.L$1;
        HttpCookies r106 = (HttpCookies) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L169:
        if (r104.hasNext() == false) goto L171;
        d r107 = (d) r104.next();
        r106.getClass();
        r100.L$0 = r106;
        r100.L$1 = r105;
        r100.L$2 = r104;
        r100.label = 1;
        throw null;
    L171:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        Url r108 = HttpResponseKt.c(r210).getUrl();
        n r109 = r210.getHeaders();
        List<String> r110 = r.f491904a;
        List<String> r111 = r109.a("Set-Cookie");
        if (r111 == null) goto L20;
        Iterator<T> r112 = r111.iterator();
    L18:
        if (r112.hasNext() == false) goto L20;
        String r113 = (String) r112.next();
        c.f491711a.trace("Received cookie " + r113 + " in response for " + r210.a80().c().getUrl());
    L20:
        Intrinsics.checkNotNullParameter(r210, "<this>");
        n r114 = r210.getHeaders();
        List<String> r115 = r.f491904a;
        List<String> r116 = r114.a("Set-Cookie");
        if (r116 == null) goto L166;
        ArrayList r117 = new ArrayList();
        Iterator<T> r118 = r116.iterator();
    L23:
        boolean r119 = false;
        int r120 = 0;
        if (r118.hasNext() == false) goto L56;
        String r121 = (String) r118.next();
        Intrinsics.checkNotNullParameter(r121, "<this>");
        int r122 = StringsKt.indexOf$default(r121, ',', 0, false, 6, null);
        if (r122 != (-1)) goto L28;
        List r123 = CollectionsKt.listOf(r121);
    L55:
        CollectionsKt.addAll(r117, r123);
        goto L23
    L28:
        ArrayList r124 = new ArrayList();
        int r125 = StringsKt.indexOf$default(r121, com.alipay.sdk.m.n.a.f25612h, r122, false, 4, null);
        int r126 = r122;
        int r127 = StringsKt.indexOf$default(r121, ';', r122, false, 4, null);
        int r128 = r125;
    L30:
        if (r120 >= r121.length()) goto L52;
        if (r126 <= 0) goto L52;
        if (r128 >= r126) goto L35;
        r128 = StringsKt.indexOf$default(r121, com.alipay.sdk.m.n.a.f25612h, r126, false, 4, null);
    L35:
        int r129 = r128;
        int r130 = StringsKt.indexOf$default(r121, ',', r126 + 1, false, 4, null);
    L36:
        int r131 = r126;
        if (r130 < 0) goto L40;
        if (r130 >= r129) goto L40;
        r126 = r130;
        r130 = StringsKt.indexOf$default(r121, ',', r130 + 1, false, 4, null);
    L40:
        int r132 = r130;
        if (r127 >= r131) goto L44;
        r127 = StringsKt.indexOf$default(r121, ';', r131, false, 4, null);
    L44:
        if (r129 < 0) goto L45;
        if (r127 == (-1)) goto L49;
        if (r127 > r129) goto L49;
    L50:
        r128 = r129;
        r126 = r132;
    L49:
        r124.add(r121.substring(r120, r131));
        r120 = r131 + 1;
        goto L50
    L45:
        r124.add(r121.substring(r120));
    L54:
        r123 = r124;
    L52:
        if (r120 >= r121.length()) goto L54;
        r124.add(r121.substring(r120));
        goto L54
    L56:
        ArrayList r133 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator r134 = r117.iterator();
    L58:
        if (r134.hasNext() == false) goto L165;
        String r135 = (String) r134.next();
        Set<String> r136 = CookieKt.f491808a;
        Intrinsics.checkNotNullParameter(r135, "cookiesHeader");
        Map<String, String> r137 = CookieKt.a(r135, r119);
        Iterator<T> r138 = r137.entrySet().iterator();
    L61:
        if (r138.hasNext() == false) goto L164;
        Map.Entry r139 = (Map.Entry) r138.next();
        if ((!StringsKt.startsWith$default((String) r139.getKey(), "$", r119, 2, null)) == false) goto L61;
        String r140 = r137.get("$x-enc");
        if (r140 == null) goto L68;
        CookieEncoding r141 = CookieEncoding.valueOf(r140);
        if (r141 == null) goto L68;
    L69:
        CookieEncoding r142 = r141;
        LinkedHashMap r143 = new LinkedHashMap(MapsKt.mapCapacity(r137.size()));
        Iterator<T> r144 = r137.entrySet().iterator();
    L71:
        if (r144.hasNext() == false) goto L73;
        Map.Entry r145 = (Map.Entry) r144.next();
        r143.put(t.c((String) r145.getKey()), r145.getValue());
        goto L71
    L73:
        String r146 = (String) r139.getKey();
        String r147 = (String) r139.getValue();
        Intrinsics.checkNotNullParameter(r147, "encodedValue");
        Intrinsics.checkNotNullParameter(r142, "encoding");
        int r148 = CookieKt.a.f491811a[r142.ordinal()];
        if (r148 == 1) goto L135;
        if (r148 == 2) goto L135;
        if (r148 == 3) goto L82;
        if (r148 != 4) goto L81;
        r147 = CodecsKt.e(r147, 0, 0, true, 11);
        hsc.a r149 = null;
        r134 = r134;
        r108 = r108;
    L140:
        String r150 = r147;
        hsc.a r151 = r149;
    L141:
        String r152 = (String) r143.get(HTTP.MAX_AGE);
        if (r152 == null) goto L144;
        int r153 = (int) RangesKt.coerceIn(CastLongProtector.parseLong(r152), 0, SieveCacheKt.NodeLinkMask);
    L145:
        String r154 = (String) r143.get("expires");
        if (r154 == null) goto L151;
        List<String> r155 = g.f491860a;
        Intrinsics.checkNotNullParameter(r154, "<this>");
        String r156 = StringsKt.trim(r154).toString();
        r151 = CookieDateParser.c(r156);     // Catch: InvalidCookieDateException -> L150
    L150:
        r151 = g.a(r156);
    L151:
        hsc.a r157 = r151;
        String r158 = (String) r143.get("domain");
        String r159 = (String) r143.get("path");
        boolean r212 = r143.containsKey("secure");
        boolean r213 = r143.containsKey("httponly");
        LinkedHashMap r160 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r161 = r137.entrySet().iterator();
    L153:
        if (r161.hasNext() == false) goto L162;
        Map.Entry<String, String> r162 = r161.next();
        String r163 = r162.getKey();
        if (CookieKt.f491808a.contains(t.c(r163)) == false) goto L157;
    L159:
        boolean r164 = false;
    L160:
        if (r164 == false) goto L153;
        r160.put(r162.getKey(), r162.getValue());
        goto L153
    L157:
        if (Intrinsics.areEqual(r163, r139.getKey()) == true) goto L159;
        r164 = true;
        goto L160
    L162:
        r133.add(new d(r146, r150, r142, r153, r157, r158, r159, r212, r213, r160));
        r119 = false;
        r134 = r134;
        r108 = r108;
        goto L58
    L144:
        r153 = 0;
        goto L145
    L81:
        throw new NoWhenBranchMatchedException();
    L82:
        int[] r165 = io.ktor.util.d.f491951a;
        Intrinsics.checkNotNullParameter(r147, "<this>");
        Intrinsics.checkNotNullParameter(r147, "<this>");
        io.ktor.utils.io.core.j r166 = new io.ktor.utils.io.core.j(null);
        int r167 = StringsKt.getLastIndex(r147);     // Catch: Throwable -> L132
    L85:
        if ((-1) >= r167) goto L93;
        if (r147.charAt(r167) != '=') goto L89;
        boolean r168 = true;
    L90:
        if (r168 == false) goto L91;
        r167 = r167 - 1;     // Catch: Throwable -> L132
        goto L85
    L91:
        String r169 = r147.substring(0, r167 + 1);     // Catch: Throwable -> L132
    L94:
        v.d(r166, r169);     // Catch: Throwable -> L132
        k r170 = r166.m();     // Catch: Throwable -> L132
        Intrinsics.checkNotNullParameter(r170, "<this>");
        io.ktor.utils.io.core.j r171 = new io.ktor.utils.io.core.j(null);
        int r172 = 4;
        byte[] r173 = new byte[4];     // Catch: Throwable -> L129
    L98:
        if (r170.k() <= 0) goto L109;
        int r174 = io.ktor.utils.io.core.o.a(r170, r173, 0, r172);     // Catch: Throwable -> L129
        int r175 = 0;
        int r176 = 0;
        int r177 = 0;
    L100:
        if (r175 >= r172) goto L102;
        r177 = r177 | (((byte) (((byte) io.ktor.util.d.f491951a[(r173[r175] & UByte.MAX_VALUE) == true ? 1 : 0]) & 63)) << ((3 - r176) * 6));     // Catch: Throwable -> L129
        r175 = r175 + 1;     // Catch: Throwable -> L129
        r172 = 4;
        r176 = r176 + 1;     // Catch: Throwable -> L129
        goto L100
    L102:
        int r178 = 4 - r174;     // Catch: Throwable -> L129
        if (r178 > 2) goto L108;
        int r179 = 2;
    L105:
        r171.l((byte) ((r177 >> (r179 * 8)) & 255));     // Catch: Throwable -> L129
        if (r179 == r178) goto L108;
        r179 = r179 - 1;     // Catch: Throwable -> L129
    L108:
        r172 = 4;
        goto L98
    L109:
        k r180 = r171.m();     // Catch: Throwable -> L129
        Intrinsics.checkNotNullParameter(r180, "<this>");
        Intrinsics.checkNotNullParameter(r180, "<this>");
        long r181 = Integer.MAX_VALUE;
        Intrinsics.checkNotNullParameter(r180, "<this>");
        if ((r180 instanceof k) == false) goto L113;
        long r182 = r180.k();
    L114:
        byte[] r183 = new byte[(int) RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r181, r182), 0)];
        int r184 = 0;
    L115:
        if (r184 >= Integer.MAX_VALUE) goto L121;
        int r185 = io.ktor.utils.io.core.o.a(r180, r183, r184, Math.min(Integer.MAX_VALUE, r183.length) - r184);
        if (r185 <= 0) goto L121;
        r184 = r184 + r185;
        if (r183.length != r184) goto L115;
        r183 = Arrays.copyOf(r183, r184 * 2);
    L121:
        if (r184 < 0) goto L128;
        if (r184 == r183.length) goto L126;
        r183 = Arrays.copyOf(r183, r184);
    L126:
        String r186 = new String(r183, 0, r183.length, Charsets.UTF_8);
        r151 = null;
        r150 = r186;
        goto L141
    L128:
        throw new EOFException("Not enough bytes available to read 0 bytes: " + (0 - r184) + " more required");
    L113:
        r182 = Math.max(r180.k(), 16);
    L129:
        th = move-exception;
        r171.close();
        throw th;
    L89:
        r168 = false;
        goto L90
    L93:
        r169 = "";
    L132:
        th = move-exception;
        r166.close();
        throw th;
    L135:
        r134 = r134;
        r108 = r108;
        r149 = null;
        if (StringsKt.startsWith$default(StringsKt.trimStart(r147).toString(), "\"", false, 2, null) == false) goto L140;
        if (StringsKt.endsWith$default(StringsKt.trimEnd(r147).toString(), "\"", false, 2, null) == false) goto L140;
        r147 = StringsKt.removeSurrounding(StringsKt.trim(r147).toString(), "\"");
    L68:
        r141 = CookieEncoding.RAW;
        goto L69
    L164:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L165:
        Url r214 = r108;
        Object r187 = r133;
    L167:
        r104 = ((Iterable) r187).iterator();
        r106 = this;
        r105 = r214;
        goto L169
    L166:
        r214 = r108;
        r187 = CollectionsKt.emptyList();
    L7:
        r100 = new HttpCookies$saveCookiesFrom$1(this, r211);
        goto L8
    }

    public final Object c(HttpRequestBuilder r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof HttpCookies$sendCookiesWith$1) == false) goto L7;
        HttpCookies$sendCookiesWith$1 r100 = (HttpCookies$sendCookiesWith$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = (HttpRequestBuilder) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L17:
        List r113 = (List) r112;
        if ((!r113.isEmpty()) == false) goto L20;
        xwc.c r104 = c.f491711a;
        String r114 = CollectionsKt.joinToString$default(r113, "; ", null, null, 0, null, HttpCookiesKt$renderClientCookies$1.INSTANCE, 30, null);
        o r105 = r110.f491760c;
        List<String> r106 = r.f491904a;
        r105.b("Cookie", r114);
        c.f491711a.trace("Sending cookie " + r114 + " for " + r110.f491758a);
    L22:
        return Unit.INSTANCE;
    L20:
        o r115 = r110.f491760c;
        List<String> r116 = r.f491904a;
        r115.getClass();
        Intrinsics.checkNotNullParameter("Cookie", "name");
        r115.f491945b.remove("Cookie");
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        g0 r117 = r110.f491758a;
        Intrinsics.checkNotNullParameter(r117, "<this>");
        g0 r107 = new g0(null);
        l0.c(r107, r117);
        Url r118 = r107.b();
        r100.L$0 = r110;
        r100.label = 1;
        r112 = fm(r118, r100);
        if (r112 != r102) goto L17;
        return r102;
    L7:
        r100 = new HttpCookies$sendCookiesWith$1(this, r111);
        goto L8
    }

    public final Object fm(Url r100, Continuation<? super List<d>> r101) {
        if ((r101 instanceof HttpCookies$get$1) == false) goto L7;
        HttpCookies$get$1 r102 = (HttpCookies$get$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L16;
        if (r105 != 2) goto L15;
        ResultKt.throwOnFailure(r104);
        return r104;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Url r106 = (Url) r102.L$1;
        HttpCookies r107 = (HttpCookies) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r107.getClass();
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        throw null;
    L18:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.label = 1;
        throw null;
    L7:
        r102 = new HttpCookies$get$1(this, r101);
        goto L8
    }
}
