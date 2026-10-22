package com.ss.android.lark.resource.service.impl;

import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public static Map<String, Resource> a(Map<String, com.bytedance.lark.pb.media.v1.Resource> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == null) goto L13;
        Iterator<String> r102 = r100.keySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        com.bytedance.lark.pb.media.v1.Resource r104 = r100.get(r103);
        if (r104 != null) goto L10;
        Resource r105 = null;
    L11:
        if (r105 == null) goto L6;
        r101.put(r103, r105);
        goto L6
    L10:
        r105 = new Resource(r104.key, r104.path, r104.is_encrypted);
    L13:
        return r101;
    }
}
