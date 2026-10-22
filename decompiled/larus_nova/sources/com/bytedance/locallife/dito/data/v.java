package com.bytedance.locallife.dito.data;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f258263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, Object> f258264b;

    public v() {
        this.f258263a = true;
    }

    public v(Object r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getClass().getName();
    L5:
        this(true, r101, r100);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public v(boolean r100, Object r101) {
        if (r101 == null) goto L4;
        String r102 = r101.getClass().getName();
    L5:
        this(r100, r102, r101);
        return;
    L4:
        r102 = null;
        goto L5
    }

    public static Object a(v r100, Class r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "clazz");
        String r102 = r101.getName();
        Intrinsics.checkNotNullParameter(r102, "key");
        Map<String, Object> r103 = r100.f258264b;
        if (r103 == null) goto L5;
        Object r104 = ((LinkedHashMap) r103).get(r102);
    L6:
        if (r104 != null) goto L8;
        r104 = null;
    L8:
        if (r104 != null) goto L11;
        return null;
    L11:
        return r104;
    L5:
        r104 = null;
        goto L6
    }

    public v(boolean r100, String r101, Object r102) {
        this();
        this.f258263a = r100;
        if (r101 == null) goto L6;
        LinkedHashMap r103 = new LinkedHashMap();
        this.f258264b = r103;
        Intrinsics.checkNotNull(r103);
        r103.put(r101, r102);
        return;
    }
}
