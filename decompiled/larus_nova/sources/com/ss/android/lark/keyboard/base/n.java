package com.ss.android.lark.keyboard.base;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Object, Object> f428238a;

    public interface a<V> {
    }

    public n() {
        this.f428238a = new LinkedHashMap();
    }

    public final <V> V a(a<V> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        V r101 = (V) ((LinkedHashMap) this.f428238a).get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101;
    }

    public final void b(a r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f428238a.put(r100, r101);
    }
}
