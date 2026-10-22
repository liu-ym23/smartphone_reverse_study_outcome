package com.bytedance.kmp.network.cinterop;

import okio.Buffer;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends com.bytedance.kmp.network.response.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f252491a;

    @Override // com.bytedance.kmp.network.response.e
    public final Buffer a() {
        Buffer r100 = new Buffer();
        byte[] r101 = this.f252491a;
        if (r101 != null) goto L6;
        r101 = new byte[0];
    L6:
        return r100.write(r101);
    }

    public a(byte[] r100) {
        this.f252491a = r100;
    }
}
