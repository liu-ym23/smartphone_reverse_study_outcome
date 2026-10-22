package com.bytedance.tools.kcp.modelx.runtime.protobuf;

import com.squareup.wire.ProtoWriter;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f270997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f270998c;

    @Override // com.bytedance.tools.kcp.modelx.runtime.protobuf.d
    public final int b() {
        return this.f270998c.length;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.protobuf.d
    public final int c() {
        return this.f270997b;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.protobuf.d
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        byte[] r101 = this.f270998c;
        Intrinsics.checkNotNullParameter(r101, "value");
        ProtoWriter r102 = r100.f271006b;
        ByteString.a r103 = ByteString.Companion;
        int r104 = r101.length;
        r103.getClass();
        r102.writeBytes(ByteString.a.d(r101, 0, r104));
    }

    public a(int r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        super(r100);
        this.f270998c = r101;
        this.f270997b = 2;
    }
}
