package com.ss.bytertc.engine.utils;

import android.util.Base64;
import com.larus.network.http.ServiceType;

/* JADX INFO: loaded from: classes40.dex */
public class TokenUtils {
    public TokenUtils() {
    }

    public static String buildToken(String r100, String r101, String r102, String r103) {
        if (r100 == null) goto L11;
        if (r100.isEmpty() == true) goto L11;
        if (r100.contains(ServiceType.BASIC_SERVICE) == false) goto L12;
        return r100;
    L12:
        return "Bearer ".concat(r100);
    L11:
        return "Basic " + Base64.encodeToString(String.format("%s:%s:%s", new Object[]{r101, r102, r103}).getBytes(), 2);
    }
}
