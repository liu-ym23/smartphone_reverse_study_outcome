package com.obric.assistant.network.restrict;

import com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor;
import com.larus.utils.logger.FLogger;
import hm9.s;
import java.net.URL;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class g implements NativeRequestInterceptor.b {
    public g() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor.b
    public final void a() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor.b
    public final NativeRequestInterceptor.c b(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L39;
        return null;
    L39:
        URL r101 = new URL(r110);     // Catch: Exception -> L38
        hm9.j r102 = hm9.j.f485959a;     // Catch: Exception -> L38
        s r103 = hm9.j.f485966h;     // Catch: Exception -> L38
        if (r103.f485995y != 2) goto L22;
        if (r103.B == false) goto L37;
        String r104 = r101.getHost();     // Catch: Exception -> L38
        String r105 = r101.getPath();     // Catch: Exception -> L38
        Intrinsics.checkNotNullParameter(r104, "host");     // Catch: Exception -> L38
        Intrinsics.checkNotNullParameter(r105, "path");     // Catch: Exception -> L38
        if (r103.a(r104, r105) != 3) goto L37;
        FLogger.f375446a.i("ObricBackgroundNetworkRestrict", "onRequestInterceptorCallback obric native intercepted, url: " + r110);     // Catch: Exception -> L38
        NativeRequestInterceptor.c r111 = new NativeRequestInterceptor.c(NativeRequestInterceptor.RequestModified.BOTH_MODIFIED);     // Catch: Exception -> L38
        r111.f244672b = MapsKt.mapOf(new Pair[]{TuplesKt.to("new", "headers"), TuplesKt.to("x-metasec-ttnet-native-drop", "1")});     // Catch: Exception -> L38
        return r111;
    L22:
        if (r103.B == false) goto L37;
        String r112 = r101.getPath();     // Catch: Exception -> L38
        Intrinsics.checkNotNull(r112);     // Catch: Exception -> L38
        if (StringsKt.startsWith$default(r112, "/ies/speed", false, 2, null) == false) goto L26;
    L33:
        boolean r113 = true;
    L34:
        if (r113 == false) goto L37;
        NativeRequestInterceptor.c r114 = new NativeRequestInterceptor.c(NativeRequestInterceptor.RequestModified.BOTH_MODIFIED);     // Catch: Exception -> L38
        r114.f244672b = MapsKt.mapOf(new Pair[]{TuplesKt.to("new", "headers"), TuplesKt.to("x-metasec-ttnet-native-drop", "1")});     // Catch: Exception -> L38
        return r114;
    L26:
        if (StringsKt.startsWith$default(r112, "/resolve", false, 2, null) == true) goto L33;
        if (StringsKt.startsWith$default(r112, "/get_domains/v5", false, 2, null) == true) goto L33;
        if (StringsKt.startsWith$default(r112, "/passport/token/beat", false, 2, null) == true) goto L33;
        r113 = false;
    L37:
        return null;
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L10
    }
}
