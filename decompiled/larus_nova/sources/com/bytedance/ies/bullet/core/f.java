package com.bytedance.ies.bullet.core;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f246498b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, h16.e>> f246499a;

    public static final class a {
    }

    static {
        f246498b = new f();
    }

    public f() {
        this.f246499a = new LinkedHashMap();
    }

    public final void a(String r100, h16.e r101) {
        Intrinsics.checkNotNullParameter(r101, "bulletContainer");
        Map r102 = (Map) ((LinkedHashMap) this.f246499a).get(r100);
        if (r102 == null) goto L5;
        h16.e r103 = (h16.e) r102.remove(String.valueOf(r101.hashCode()));
    L5:
        Iterator r104 = ((LinkedHashMap) this.f246499a).entrySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((Map) ((Map.Entry) r104.next()).getValue()).remove(String.valueOf(r101.hashCode()));
        goto L7
    }
}
