package com.bytedance.ee.bear.middleground.drive.cipher;

import android.os.Message;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements ue5.a {
    public b() {
    }

    @Override // ue5.a
    public final void a(ue5.b r100) {
        if (c.f232406b == null) goto L5;
    L14:
        a r101 = c.f232406b.f232407a;
        if (r101 == null) goto L17;
        tt5.a.h("CipherChangeEventLister", "unRegisterCipherCallback " + r100);
        a.HandlerC3322a r102 = r101.f232404b;
        r102.getClass();
        r102.sendMessage(Message.obtain(r102, 3, r100));
        return;
    L17:
        tt5.a.h("Middleground_Cipher_CipherRustPBWrapper", "registerCipherCallback mCipherChangeEventLister == null");
        return;
    L5:
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c.f232406b != null) goto L9;
        c.f232406b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // ue5.a
    public final void b(ue5.b r100) {
        if (c.f232406b == null) goto L5;
    L14:
        a r101 = c.f232406b.f232407a;
        if (r101 == null) goto L17;
        tt5.a.h("CipherChangeEventLister", "registerCipherCallback " + r100);
        a.HandlerC3322a r102 = r101.f232404b;
        r102.getClass();
        r102.sendMessage(Message.obtain(r102, 2, r100));
        return;
    L17:
        tt5.a.h("Middleground_Cipher_CipherRustPBWrapper", "registerCipherCallback mCipherChangeEventLister == null");
        return;
    L5:
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c.f232406b != null) goto L9;
        c.f232406b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
        goto L14
    }
}
