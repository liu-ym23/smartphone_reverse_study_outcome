package com.bytedance.ee.bear.task;

import android.content.Context;
import com.bytedance.ee.bear.middleground.permission.audit.e;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class InitAuditTask extends BaseAsyncLaunchTask {
    public final int c() {
        return 5;
    }

    public InitAuditTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask
    public final void a(Context r2) {
        a.h("InitAuditTask", "execute");
        ((e) org.koin.java.a.a(e.class)).b();
    }
}
