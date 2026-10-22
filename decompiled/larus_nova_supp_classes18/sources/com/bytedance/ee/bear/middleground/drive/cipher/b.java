package com.bytedance.ee.bear.middleground.drive.cipher;

import android.os.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements ue5.a {
    public b() {
    }

    @Override // ue5.a
    public final void a(ue5.b r4) {
        if (c.b == null) goto L5;
    L14:
        a r0 = c.b.a;
        if (r0 == null) goto L17;
        tt5.a.h("CipherChangeEventLister", "unRegisterCipherCallback " + r4);
        a.HandlerC0075a r1 = r0.b;
        r1.getClass();
        r1.sendMessage(Message.obtain(r1, 3, r4));
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
        if (c.b != null) goto L9;
        c.b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // ue5.a
    public final void b(ue5.b r4) {
        if (c.b == null) goto L5;
    L14:
        a r0 = c.b.a;
        if (r0 == null) goto L17;
        tt5.a.h("CipherChangeEventLister", "registerCipherCallback " + r4);
        a.HandlerC0075a r1 = r0.b;
        r1.getClass();
        r1.sendMessage(Message.obtain(r1, 2, r4));
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
        if (c.b != null) goto L9;
        c.b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
        goto L14
    }
}
