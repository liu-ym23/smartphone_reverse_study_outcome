package com.ss.ugc.live.sdk.msg.utils;

import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.live.sdk.msg.data.SdkUplinkPacket;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f458480a = 0;

    static {
    }

    @JvmStatic
    public static final String a(tlc.f r100) {
        if (r100 == null) goto L20;
        List<com.ss.ugc.live.sdk.msg.network.d> r101 = r100.f546765f;
        if (r101 == null) goto L21;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((com.ss.ugc.live.sdk.msg.network.d) r103).f458296a, "compress_type") == false) goto L8;
    L13:
        com.ss.ugc.live.sdk.msg.network.d r104 = (com.ss.ugc.live.sdk.msg.network.d) r103;
        if (r104 != null) goto L16;
        return null;
    L16:
        return r104.f458297b;
    L12:
        r103 = null;
        goto L13
    L21:
        return null;
    L20:
        return null;
    }

    @JvmStatic
    public static final String b(SdkUplinkPacket r100) {
        if (r100 == null) goto L21;
        Map<String, String> r101 = r100.headers;
        if (r101 == null) goto L21;
        Set<String> r102 = r101.keySet();
        if (r102 == null) goto L21;
        Iterator<T> r103 = r102.iterator();
    L8:
        String r104 = null;
        if (r103.hasNext() == false) goto L13;
        Object r105 = r103.next();
        if (StringsKt.equals(NetResponse.HEADER_KEY_LOG_ID, (String) r105, true) == false) goto L8;
    L14:
        String r106 = (String) r105;
        if (r106 == null) goto L21;
        Map<String, String> r107 = r100.headers;
        if (r107 == null) goto L19;
        r104 = r107.get(r106);
    L19:
        if (r104 == null) goto L21;
        return r104;
    L13:
        r105 = null;
    L21:
        return "";
    }
}
