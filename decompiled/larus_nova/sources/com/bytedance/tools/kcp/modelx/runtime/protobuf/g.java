package com.bytedance.tools.kcp.modelx.runtime.protobuf;

import com.squareup.wire.ProtoWriter;
import okio.Buffer;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Buffer f271005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProtoWriter f271006b;

    public g() {
        Buffer r100 = new Buffer();
        this.f271005a = r100;
        this.f271006b = new ProtoWriter(r100);
    }
}
