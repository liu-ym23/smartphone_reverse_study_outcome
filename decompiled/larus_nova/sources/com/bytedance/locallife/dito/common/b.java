package com.bytedance.locallife.dito.common;

import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.common.log.DitoCommonLog;
import com.bytedance.locallife.dito.common.reporter.DitoCommonReporter;
import com.bytedance.locallife.dito.common.request.ChunkHandler;
import com.bytedance.locallife.dito.common.request.m;
import com.bytedance.locallife.dito.config.e;
import com.bytedance.locallife.dito.config.h;
import com.bytedance.locallife.dito.config.i;
import com.bytedance.locallife.dito.config.j;
import com.bytedance.locallife.dito.config.k;
import com.bytedance.locallife.dito.performance.r;
import kotlin.jvm.internal.Intrinsics;
import sq6.d;

/* JADX INFO: loaded from: classes21.dex */
public class b extends Dito.a {
    public b() {
    }

    @Override // com.bytedance.locallife.dito.Dito.a
    public <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (Intrinsics.areEqual(r100, rq6.c.class) == false) goto L6;
        T r101 = (T) DitoCommonLog.f257357a;
    L39:
        if (r101 != null) goto L42;
        return null;
    L42:
        return r101;
    L6:
        if (Intrinsics.areEqual(r100, d.class) == false) goto L9;
        r101 = (T) DitoCommonReporter.f257648a;
        goto L39
    L9:
        if (Intrinsics.areEqual(r100, cq6.a.class) == false) goto L12;
        r101 = (T) new wp6.a();
        goto L39
    L12:
        if (Intrinsics.areEqual(r100, dq6.a.class) == false) goto L15;
        r101 = (T) mp6.a.f514720a;
        goto L39
    L15:
        if (Intrinsics.areEqual(r100, j.class) == false) goto L18;
        r101 = (T) zp6.a.f573199a;
        goto L39
    L18:
        if (Intrinsics.areEqual(r100, k.class) == false) goto L21;
        r101 = (T) zp6.b.f573203a;
        goto L39
    L21:
        if (Intrinsics.areEqual(r100, r.class) == false) goto L24;
        r101 = (T) vp6.a.f556649a;
        goto L39
    L24:
        if (Intrinsics.areEqual(r100, ChunkHandler.class) == false) goto L27;
        r101 = (T) m.f257683b;
        goto L39
    L27:
        if (Intrinsics.areEqual(r100, sq6.c.class) == false) goto L30;
        r101 = (T) new qp6.a();
        goto L39
    L30:
        if (Intrinsics.areEqual(r100, i.class) == false) goto L33;
        r101 = (T) yp6.a.f568720a;
        goto L39
    L33:
        if (Intrinsics.areEqual(r100, e.class) == false) goto L36;
        r101 = (T) np6.a.f520041a;
        goto L39
    L36:
        if (Intrinsics.areEqual(r100, h.class) == false) goto L38;
        r101 = (T) new com.bytedance.locallife.dito.common.settings.a();
        goto L39
    L38:
        r101 = (T) super.a(r100);
        goto L39
    }
}
