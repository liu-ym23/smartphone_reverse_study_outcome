package com.larus.kmp.voice_setting.voice.network;

import androidx.collection.SieveCacheKt;
import com.larus.dora.impl.ota.g2.j0;
import gd9.e;
import juc.d;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class c {
    public static final <T> a<T> a(e r100, d<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "serializer");
        wt7.c r102 = wt7.a.f561230a;
        String r103 = r100.f480968d;
        d<a<T>> r104 = a.Companion.serializer(r101);
        r102.getClass();
        a<T> r105 = (a) wt7.c.a(r103, r104);
        if (r105 == null) goto L5;
        return r105;
    L5:
        return new a(-999, null, 14);
    }

    public static final <T> b.a b(a<T> r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        long r102 = r100.f353984a;
        boolean r103 = true;
        if (r102 != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L9;
        return null;
    L9:
        String r105 = r100.f353985b;
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        if (SieveCacheKt.NodeMetaAndPreviousMask <= r102) goto L15;
    L17:
        r103 = false;
    L18:
        if (r103 == false) goto L20;
        int r106 = (int) r102;
    L21:
        if (r101 != null) goto L28;
        if (StringsKt.isBlank(r105) == false) goto L25;
        String r107 = "BizResponse is not success, code=" + r100.f353984a;
    L26:
        r101 = new Exception(r107);
        goto L28
    L25:
        r107 = r105;
    L28:
        return new b.a(r106, r105, r101);
    L20:
        r106 = -1000;
        goto L21
    L15:
        if (r102 >= j0.G2_OTA_SPACE_RESERVE_BYTES) goto L17;
    L5:
        r104 = false;
        goto L6
    }
}
