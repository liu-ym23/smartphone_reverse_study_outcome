package com.bytedance.ee.bear.task;

import android.content.Context;
import com.bytedance.ee.bear.appsetting.c;
import tt5.a;
import vn5.g;

/* JADX INFO: loaded from: classes18.dex */
public class InitCipherTask extends BaseAsyncLaunchTask {
    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final int c() {
        return 5;
    }

    public InitCipherTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask, com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        boolean r101 = c.a.f206237a.i("spacekit.mobile.cipher_delete_enable", false);
        a.h("InitCipherTask", "cipherFG:" + r101);
        if (r101 == false) goto L6;
        ((ue5.a) org.koin.java.a.a(ue5.a.class)).b(new g());
        return;
    }
}
