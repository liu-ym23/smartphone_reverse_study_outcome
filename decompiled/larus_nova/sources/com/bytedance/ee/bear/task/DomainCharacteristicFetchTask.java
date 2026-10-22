package com.bytedance.ee.bear.task;

import android.content.Context;
import com.bytedance.ee.bear.lark.dependency.k;
import com.ss.android.lark.utils.LarkContext;
import org.koin.java.a;
import s45.c;
import s45.p;

/* JADX INFO: loaded from: classes18.dex */
public class DomainCharacteristicFetchTask extends BaseAsyncLaunchTask {
    public DomainCharacteristicFetchTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask, com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        p.a().Sa(((k) a.a(k.class)).d());
        ((c) e0c.k.a(LarkContext.getApplication(), c.class)).dd(false);
        ((t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class)).S8();
    }
}
