package com.bytedance.kmp.network.response;

import okio.Buffer;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements f<byte[]> {
    public a() {
    }

    @Override // com.bytedance.kmp.network.response.f
    public final Object a(e r100) {
        if (r100 == null) goto L11;
        Buffer r101 = e.b(r100.a());
        if (r101 == null) goto L11;
        byte[] r102 = r101.readByteArray();     // Catch: Throwable -> L8
        r101.close();
        return r102;
    L8:
        th = move-exception;
        r101.close();
        throw th;
    L11:
        return null;
    }
}
