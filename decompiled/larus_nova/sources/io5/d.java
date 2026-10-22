package io5;

import com.bytedance.ee.bear.drive.sdk.service.f;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements c {
    public d() {
    }

    @Override // io5.c
    public final byte[] a(String r100, String r101, byte[] r102) {
        if (r102 != null) goto L5;
        tt5.a.d("SM4GcmDecoder", "decodeToByte() sourceData == null");
    L5:
        return ((f) org.koin.java.a.a(f.class)).d0().l(r102, r100, r101);
    }
}
