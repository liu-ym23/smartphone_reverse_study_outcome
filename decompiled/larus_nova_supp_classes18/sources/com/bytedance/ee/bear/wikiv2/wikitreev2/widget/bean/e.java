package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final ConcurrentHashMap<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a> a;
    public final ConcurrentHashMap<String, List<String>> b;

    public static final class a {
    }

    static {
    }

    public e() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }

    public final void a(VirtualNode r5, VirtualNode r6) {
        Intrinsics.checkNotNullParameter(r5, "currentNode");
        Intrinsics.checkNotNullParameter(r6, "parentNode");
        String r0 = r5.getRootToken();
        String r7 = r6.getRootToken();
        String r1 = b.a(r7, r7, 0, "");
        String r8 = b.a(r7, r0, r5.getLevel(), "");
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r2 = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a(r8, r1, r0);
        r2.e = r5.getLevel();
        r2.d = true;
        this.a.put(r8, r2);
        ConcurrentHashMap<String, List<String>> r9 = this.b;
        ArrayList r3 = new ArrayList();
        r3.add(r8);
        r9.put(r0, r3);
    }
}
