package com.bytedance.tools.kcp.modelx.runtime.protobuf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f271001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f271002c;

    @Override // com.bytedance.tools.kcp.modelx.runtime.protobuf.d
    public final int c() {
        return 0;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.protobuf.d
    public final int b() {
        return this.f271001b;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.protobuf.d
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        int r101 = this.f271002c;
        if (r101 < 0) goto L5;
        r100.f271006b.writeVarint32(r101);
        return;
    L5:
        r100.f271006b.writeVarint64(r101);
    }

    public c(int r100, int r101) {
        super(r100);
        this.f271002c = r101;
        if (r101 < 0) goto L5;
        int r102 = e.a(r101);
    L6:
        this.f271001b = r102;
        return;
    L5:
        r102 = 10;
        goto L6
    }
}
