package com.bytedance.ee.bear.task;

import android.content.Context;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.o4;
import com.bytedance.ee.bear.document.p4;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.ArrayList;
import java.util.List;
import tt5.a;
import w35.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class EditorTask extends BaseTask {
    public final List<Class<? extends ILaunchTask>> i() {
        ArrayList r0 = new ArrayList();
        r0.add(DocsCentralTask.class);
        return r0;
    }

    public EditorTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseTask
    public final void a(Context r3) {
        a.h("EditorTask", "onCreate()...");
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L9;
        p4 r4 = new p4();
        if (r4.a != null) goto L7;
        h.a();
    L7:
        ((h0) org.koin.java.a.a(h0.class)).Pe(new o4(r4));
        return;
    }
}
