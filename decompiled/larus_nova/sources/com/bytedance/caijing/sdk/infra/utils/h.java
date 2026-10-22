package com.bytedance.caijing.sdk.infra.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h {
    static {
    }

    public static Map a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = UriProtector.getQueryParameterNames(r100).iterator();     // Catch: Exception -> L9
    L5:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();     // Catch: Exception -> L9
        r101.put(r103, UriProtector.getQueryParameter(r100, r103));     // Catch: Exception -> L9
    L8:
        return r101;
    }
}
