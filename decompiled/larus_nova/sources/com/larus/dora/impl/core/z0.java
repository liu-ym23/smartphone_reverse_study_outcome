package com.larus.dora.impl.core;

import com.bytedance.dora.vision.DoraDataFrame;

/* JADX INFO: loaded from: classes27.dex */
public abstract class z0 implements qk4.h {
    public z0() {
    }

    @Override // qk4.h
    public final void a(DoraDataFrame r100) {
    }

    public abstract void c(int r100, int r101, int r102, byte[] r103, int r104, byte[] r105, boolean r106);

    @Override // qk4.h
    public final void b(DoraDataFrame r110) {
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
        boolean r108 = true;
        if (r110.seq != (r110.count - 1)) goto L12;
        r108 = false;
    L12:
        c(r100, r101, r102, r104, r105, r107, r108);
    }
}
