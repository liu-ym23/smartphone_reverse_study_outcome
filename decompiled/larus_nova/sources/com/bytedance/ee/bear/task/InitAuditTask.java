package com.bytedance.ee.bear.task;

import android.content.Context;
import com.bytedance.ee.bear.middleground.permission.audit.e;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
public class InitAuditTask extends BaseAsyncLaunchTask {
    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final int c() {
        return 5;
    }

    public InitAuditTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask, com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        a.h("InitAuditTask", "execute");
        ((e) org.koin.java.a.a(e.class)).b();
    }
}
