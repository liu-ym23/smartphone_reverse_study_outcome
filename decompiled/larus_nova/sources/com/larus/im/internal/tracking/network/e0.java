package com.larus.im.internal.tracking.network;

import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class e0 {
    public static final String a(Map r100) {
        if (r100 == null) goto L20;
        Set r101 = r100.entrySet();
        if (r101 == null) goto L21;
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        if (StringsKt.equals((String) ((Map.Entry) r103).getKey(), NetResponse.HEADER_KEY_LOG_ID, true) == false) goto L8;
    L13:
        Map.Entry r104 = (Map.Entry) r103;
        if (r104 != null) goto L16;
        return null;
    L16:
        return (String) r104.getValue();
    L12:
        r103 = null;
        goto L13
    L21:
        return null;
    L20:
        return null;
    }

    public static final s b(gd9.f r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new s(r100.f480978a, r100.f480979b, r100.f480980c, r100.f480981d, r100.f480982e, r100.f480983f);
    }
}
