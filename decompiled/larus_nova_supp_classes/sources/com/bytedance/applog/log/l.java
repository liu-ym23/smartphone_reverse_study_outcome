package com.bytedance.applog.log;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class l {
    public static final CopyOnWriteArraySet<j> a = null;
    public static final Map<String, j> b = null;

    static {
        a = new CopyOnWriteArraySet();
        b = new ConcurrentHashMap();
    }

    public static void a(k r2) {
        CopyOnWriteArraySet<j> r0 = a;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<j> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().a(r2);
        goto L7
    }
}
