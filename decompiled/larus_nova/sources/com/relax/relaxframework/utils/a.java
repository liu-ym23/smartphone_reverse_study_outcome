package com.relax.relaxframework.utils;

import com.relax.runtime.gen.GlobalEventCallback;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<Long, GlobalEventCallback>> f405299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f405300b;

    public a() {
        this.f405299a = new LinkedHashMap();
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Map r102 = (Map) ((LinkedHashMap) this.f405299a).get(r100);
        if (r102 == null) goto L10;
        Collection r103 = r102.values();
        if (r103 == null) goto L12;
        Iterator r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        ((GlobalEventCallback) r104.next()).invoke(r101);
        goto L8
    L13:
        return;
    L12:
        return;
    }
}
