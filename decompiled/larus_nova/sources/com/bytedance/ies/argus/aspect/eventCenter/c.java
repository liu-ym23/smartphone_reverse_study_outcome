package com.bytedance.ies.argus.aspect.eventCenter;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f245839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f245840b;

    public c() {
        this.f245839a = new ConcurrentHashMap();
        this.f245840b = new AtomicInteger(0);
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        StringBuilder r101 = new StringBuilder();
        r101.append(System.currentTimeMillis());
        r101.append('-');
        r101.append(this.f245840b.getAndAdd(1));
        r101.append('-');
        r101.append(UUID.randomUUID());
        String r102 = r101.toString();
        this.f245839a.put(r102, r100);
        return r102;
    }

    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Iterator<T> r101 = this.f245839a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((Map.Entry) r102).getValue(), r100) == false) goto L4;
    L9:
        Map.Entry r103 = (Map.Entry) r102;
        if (r103 != null) goto L12;
        return null;
    L12:
        return (String) r103.getKey();
    L8:
        r102 = null;
        goto L9
    }
}
