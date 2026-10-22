package com.bytedance.tools.kcp.modelx.runtime.internal;

import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public static final void a(Class<?> r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "name");
        vh7.d r104 = f.f554983a;
        String r105 = "field [" + r101 + "] has different tags: [" + r102 + ", " + r103 + "], type: " + r100;
        if (r105 == null) goto L6;
        f.f554984b.error(r105);
        return;
    }
}
