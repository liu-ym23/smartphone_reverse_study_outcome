package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a> f241740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, List<String>> f241741b;

    public static final class a {
    }

    static {
    }

    public e() {
        this.f241740a = new ConcurrentHashMap();
        this.f241741b = new ConcurrentHashMap();
    }

    public final void a(VirtualNode r100, VirtualNode r101) {
        Intrinsics.checkNotNullParameter(r100, "currentNode");
        Intrinsics.checkNotNullParameter(r101, "parentNode");
        String r102 = r100.getRootToken();
        String r103 = r101.getRootToken();
        String r104 = b.a(r103, r103, 0, "");
        String r105 = b.a(r103, r102, r100.getLevel(), "");
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r106 = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a(r105, r104, r102);
        r106.f241736e = r100.getLevel();
        r106.f241735d = true;
        this.f241740a.put(r105, r106);
        ConcurrentHashMap<String, List<String>> r107 = this.f241741b;
        ArrayList r108 = new ArrayList();
        r108.add(r105);
        r107.put(r102, r108);
    }
}
