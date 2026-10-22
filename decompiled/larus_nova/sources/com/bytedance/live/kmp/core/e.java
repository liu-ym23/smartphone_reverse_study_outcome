package com.bytedance.live.kmp.core;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements vh6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<vh6.d<?>, Object> f255140a;

    public e() {
        this.f255140a = new LinkedHashMap();
    }

    @Override // vh6.b
    public final <T> T a(vh6.d<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r101 = (T) ((LinkedHashMap) this.f255140a).get(r100);
        if ((r101 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r101;
    }

    public final <T> void b(vh6.d<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f255140a.put(r100, r101);
    }
}
