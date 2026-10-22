package com.lark.kmp.containerization;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c<TKey> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<TKey> f278585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<TKey, b> f278586b;

    public final d<TKey> getType() {
        return this.f278585a;
    }

    public c(d<TKey> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f278585a = r100;
        this.f278586b = new LinkedHashMap();
    }

    public final b a(TKey r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return (b) ((LinkedHashMap) this.f278586b).get(r100);
    }

    public final b b(TKey r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        LinkedHashMap r102 = (LinkedHashMap) this.f278586b;
        Object r103 = r102.get(r100);
        if (r103 != null) goto L6;
        r103 = new Container(r101);
        r102.put(r100, r103);
    L6:
        return (b) r103;
    }
}
