package com.bytedance.ee.bear.middleground.drive.cipher;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.sdk.g;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f232406b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f232407a;

    public c() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.cipher_delete_enable", false);
        tt5.a.h("Middleground_Cipher_CipherRustPBWrapper", "init cipherFG:" + r100);
        if (r100 == false) goto L6;
        a r101 = new a();
        this.f232407a = r101;
        g.e.f439875a.b(Command.PUSH_CIPHER_CHANGED_EVENT, r101);
        return;
    }
}
