package com.bytedance.ee.bear.task;

import android.content.Context;
import com.bytedance.ee.bear.contract.h0;
import org.koin.java.a;
import vn5.e;
import vn5.f;
import yn4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DocsUserInfoTask extends BaseAsyncLaunchTask {
    public DocsUserInfoTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask
    public final void a(Context r3) {
        ((h0) a.a(h0.class)).n4(b.e.f).subscribe(new e(), new f());
    }
}
