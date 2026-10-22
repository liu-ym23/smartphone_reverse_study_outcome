package com.bytedance.ee.bear.task;

import android.content.Context;
import com.bytedance.ee.bear.appsetting.c;
import tt5.a;
import vn5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class InitCipherTask extends BaseAsyncLaunchTask {
    public final int c() {
        return 5;
    }

    public InitCipherTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask
    public final void a(Context r3) {
        boolean r4 = c.a.a.i("spacekit.mobile.cipher_delete_enable", false);
        a.h("InitCipherTask", "cipherFG:" + r4);
        if (r4 == false) goto L6;
        ((ue5.a) org.koin.java.a.a(ue5.a.class)).b(new g());
        return;
    }
}
