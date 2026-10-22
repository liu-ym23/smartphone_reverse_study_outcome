package com.larus.dora.impl.core;

import com.bytedance.dora.vision.DoraDataFrame;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class a1 implements qk4.h {
    public a1() {
    }

    @Override // qk4.h
    public final void b(DoraDataFrame r100) {
    }

    @Override // qk4.h
    public final void a(DoraDataFrame r110) {
        int r100 = r110.f204666id;
        int r101 = r110.scene;
        int r102 = r110.type;
        byte[] r103 = r110.data;
        if (r103 != null) goto L5;
        r103 = new byte[0];
    L5:
        byte[] r104 = r103;
        int r105 = r110.assId;
        byte[] r106 = r110.assData;
        if (r106 != null) goto L8;
        r106 = new byte[0];
    L8:
        byte[] r107 = r106;
        boolean r111 = r110.frameLoss;
        q0 r108 = (q0) this;
        Intrinsics.checkNotNullParameter(r104, "data");
        Intrinsics.checkNotNullParameter(r107, "assData");
        int r109 = r108.f332231a;
        if (r100 != r109) goto L18;
        s0.c(r109, r108.f332235e, r108.f332236f, "success");
        v39.a r112 = new v39.a(r100, r101, r102, r104, r105, r107);
        if (r111 == false) goto L13;
        Object r113 = new v39.b.C7961b(r112);
    L14:
        ((CopyOnWriteArraySet) ((qk4.g) r108.f332232b).f533518e).remove(r108);
        if (r108.f332233c.compareAndSet(false, true) == false) goto L19;
        s0.c(r108.f332231a, r108.f332235e, r108.f332236f, "success, resp=" + r113);
        r108.f332234d.resumeWith(Result.m9449constructorimpl(r113));
        return;
    L19:
        return;
    L13:
        r113 = new v39.b.f(r112);
        goto L14
    }
}
