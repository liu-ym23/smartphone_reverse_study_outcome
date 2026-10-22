package com.bytedance.locallife.biz.fmp;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f256699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f256700b;

    public static final class a {
    }

    static {
    }

    public d(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f256699a = r100;
        this.f256700b = true;
    }

    public final void update(d r100) {
        Intrinsics.checkNotNullParameter(r100, "dataEvent");
        if (this.f256700b == true) goto L11;
        Iterator<Map.Entry<String, String>> r101 = r100.f256699a.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<String, String> r102 = r101.next();
        this.f256699a.put(r102.getKey(), r102.getValue());
        goto L6
    L8:
        this.f256700b = r100.f256700b;
        return;
    }
}
