package io5;

import com.bytedance.ee.bear.drive.sdk.service.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements c {
    public d() {
    }

    @Override // io5.c
    public final byte[] a(String r3, String r4, byte[] r5) {
        if (r5 != null) goto L5;
        tt5.a.d("SM4GcmDecoder", "decodeToByte() sourceData == null");
    L5:
        return ((f) org.koin.java.a.a(f.class)).d0().l(r5, r3, r4);
    }
}
