package com.larus.platform.service;

import com.larus.platform.api.y3;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class u2 implements y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u2 f365811a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365812b = null;

    public u2() {
    }

    static {
        f365811a = new u2();
        f365812b = LazyKt.lazy(new t2());
    }

    @Override // com.larus.platform.api.y3
    public final void a() {
        y3 r100 = (y3) f365812b.getValue();
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.larus.platform.api.y3
    public final boolean isBasicMode() {
        y3 r100 = (y3) f365812b.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isBasicMode();
    }

    @Override // com.larus.platform.api.y3
    public final String b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        y3 r101 = (y3) f365812b.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.b(r100);
    }
}
