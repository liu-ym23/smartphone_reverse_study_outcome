package com.facebook.cache.common;

import com.facebook.common.util.SecureHashUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class CacheKeyUtil {
    public CacheKeyUtil() {
    }

    public static String getFirstResourceId(CacheKey r100) {
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if ((r100 instanceof MultiCacheKey) == false) goto L7;
        return secureHashKey(((MultiCacheKey) r100).getCacheKeys().get(0));
    L7:
        return secureHashKey(r100);
    }

    public static List<String> getResourceIds(CacheKey r100) {
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if ((r100 instanceof MultiCacheKey) == false) goto L8;
        List<CacheKey> r101 = ((MultiCacheKey) r100).getCacheKeys();     // Catch: UnsupportedEncodingException -> L10
        ArrayList r102 = new ArrayList(r101.size());     // Catch: UnsupportedEncodingException -> L10
        int r103 = 0;
    L6:
        if (r103 >= r101.size()) goto L15;
        r102.add(secureHashKey(r101.get(r103)));     // Catch: UnsupportedEncodingException -> L10
        r103 = r103 + 1;     // Catch: UnsupportedEncodingException -> L10
        goto L6
    L15:
        return r102;
    L8:
        ArrayList r104 = new ArrayList(1);     // Catch: UnsupportedEncodingException -> L10
        r104.add(secureHashKey(r100));     // Catch: UnsupportedEncodingException -> L10
        return r104;
    }

    private static String secureHashKey(CacheKey r100) throws UnsupportedEncodingException {
        return SecureHashUtil.makeSHA1HashBase64(r100.getUriString().getBytes("UTF-8"));
    }
}
