package com.bytedance.locallife.biz.base;

import en6.o;
import en6.r;
import en6.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends com.bytedance.locallife.dito.common.b {
    public b() {
    }

    @Override // com.bytedance.locallife.dito.common.b, com.bytedance.locallife.dito.Dito.a
    public final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (Intrinsics.areEqual(r100, tp6.b.class) == false) goto L7;
        return (T) s.f473188a;
    L7:
        if (Intrinsics.areEqual(r100, gq6.a.class) == false) goto L11;
        return (T) o.f473179a;
    L11:
        if (Intrinsics.areEqual(r100, lp6.d.class) == false) goto L15;
        return (T) r.f473185a;
    L15:
        if (Intrinsics.areEqual(r100, pp6.a.class) == false) goto L19;
        return (T) new DitoReceiverRegisterImpl();
    L19:
        if (Intrinsics.areEqual(r100, cq6.a.class) == false) goto L23;
        return (T) d.f256553a;
    L23:
        return (T) super.a(r100);
    }
}
