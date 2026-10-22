package com.ss.android.cert.manager.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class JsbManager {
    private static final Map<String, IJsbHelper> jsbHelperMap = null;

    public JsbManager() {
    }

    static {
        jsbHelperMap = new HashMap();
    }

    public static IJsbHelper getJsbHelper(String r100) {
        return jsbHelperMap.get(r100);
    }

    public static void removeJsbHelper(IJsbHelper r100) {
        Iterator<Map.Entry<String, IJsbHelper>> r101 = jsbHelperMap.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        if (r101.next().getValue() != r100) goto L4;
        r101.remove();
        return;
    }

    public static void removeJsbHelper(String r100) {
        jsbHelperMap.remove(r100);
    }

    public static void addJsbHelper(String r100, IJsbHelper r101) {
        jsbHelperMap.put(r100, r101);
    }
}
