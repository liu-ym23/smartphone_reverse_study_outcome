package com.ttnet.org.chromium.net.impl;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class CronetUrlRequestMapping {
    public static final String TAG = "CronetUrlRequestMapping";
    private static Map<String, CronetUrlRequest> sRequestMapping;

    public CronetUrlRequestMapping() {
    }

    static {
        sRequestMapping = new ConcurrentHashMap();
    }

    public static CronetUrlRequest GetRequest(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        return sRequestMapping.get(r100);
    }

    public static void RemoveRequest(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        sRequestMapping.remove(r100);
        return;
    }

    public static void AddRequest(String r100, CronetUrlRequest r101) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        if (r101 == null) goto L8;
        sRequestMapping.put(r100, r101);
        return;
    L8:
        return;
    }
}
