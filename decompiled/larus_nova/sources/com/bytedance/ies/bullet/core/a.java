package com.bytedance.ies.bullet.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Object> f246462b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f246463a;

    /* JADX INFO: renamed from: com.bytedance.ies.bullet.core.a$a, reason: collision with other inner class name */
    public static final class C3522a {
    }

    static {
        f246462b = Collections.synchronizedList(new ArrayList());
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        this.f246463a = r100;
    }

    @Override // com.bytedance.ies.bullet.core.p
    public final h16.e a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        f r101 = f.f246498b;
        String r102 = this.f246463a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Map r103 = (Map) ((LinkedHashMap) r101.f246499a).get(r102);
        if (r103 == null) goto L18;
        Iterator r104 = r103.keySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L19;
        String r105 = (String) r104.next();
        h16.e r106 = (h16.e) r103.get(r105);
        if (r106 == null) goto L10;
        String r107 = r106.getSessionId();
    L12:
        if (Intrinsics.areEqual(r107, r100) == false) goto L6;
        return (h16.e) r103.get(r105);
    L10:
        r107 = null;
        goto L12
    L19:
        return null;
    L18:
        return null;
    }
}
