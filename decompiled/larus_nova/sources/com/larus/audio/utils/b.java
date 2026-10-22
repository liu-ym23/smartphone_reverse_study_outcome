package com.larus.audio.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements m58.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f2a.c f290017a;

    public b(f2a.c r100) {
        Intrinsics.checkNotNullParameter(r100, "logBuilder");
        this.f290017a = r100;
    }

    public final b b(List r100) {
        this.f290017a.f475230c.f475254b = r100;
        return this;
    }

    public final b c(Map r100) {
        LinkedHashMap r101 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator r102 = ((LinkedHashMap) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put(new f2a.f((String) r103.getKey()), r103.getValue());
        goto L4
    L6:
        this.f290017a.d(r101);
        return this;
    }

    public final b d(String r100) {
        this.f290017a.f475230c.f475256d = r100;
        return this;
    }

    public final b e(String r100) {
        this.f290017a.f475230c.f475257e = r100;
        return this;
    }

    @Override // m58.k
    public final void a(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r101, "function");
        this.f290017a.b(r100, r101, r102, 5);
    }
}
