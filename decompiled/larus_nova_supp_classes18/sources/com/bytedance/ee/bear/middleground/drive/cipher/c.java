package com.bytedance.ee.bear.middleground.drive.cipher;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.sdk.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static volatile c b;
    public a a;

    public c() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.cipher_delete_enable", false);
        tt5.a.h("Middleground_Cipher_CipherRustPBWrapper", "init cipherFG:" + r0);
        if (r0 == false) goto L6;
        a r1 = new a();
        this.a = r1;
        g.e.a.b(Command.PUSH_CIPHER_CHANGED_EVENT, r1);
        return;
    }
}
