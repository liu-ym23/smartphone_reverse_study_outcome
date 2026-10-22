package com.bytedance.ee.bear.task;

import android.app.Application;
import android.content.Context;
import com.bytedance.ee.bear.basesdk.config.f;
import com.bytedance.ee.bear.contract.a0;
import com.bytedance.ee.bear.contract.config.TenantInfo;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.doc.resupdate.g;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import ib5.d;
import ib5.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import on4.y;
import org.koin.java.a;
import s45.p;
import sa5.h;
import sa5.l;
import t45.c;
import yn4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DocsCentralTask extends BaseTask {
    public final List<Class<? extends ILaunchTask>> i() {
        ArrayList r0 = new ArrayList();
        r0.add(DocsBaseTask.class);
        return r0;
    }

    public DocsCentralTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseTask
    public final void a(Context r4) {
        TenantInfo r5 = b.e.b;
        p.u = r5.e.a;
        p.t = r5.a;
        ((c) k.a(LarkContext.getApplication(), c.class)).K5(b.e.b.c);
        ((h0) a.a(h0.class)).j9(b.e.f);
        f r6 = new f();
        tt5.a.h("ExternalLinkBrowserConfigs", "setup");
        com.bytedance.ee.bear.externallink.a.a = r6;
        l r7 = new l(new h());
        xn4.a r0 = new xn4.a();
        qnb.b.a = r0;
        qnb.b.b = r0.a();
        rnb.c.a = r0.b();
        Application r1 = eu5.b.a;
        e.a = r1;
        nv4.b.a = new ib5.b(new l(new h()));
        ((a0) k.a(LarkContext.getApplication(), a0.class)).E1(new ib5.c());
        ((zo5.b) a.a(zo5.b.class)).init(r1);
        ((g) a.a(g.class)).init(r1);
        dw4.a.a = new d();
        y r2 = new y();
        s45.h r3 = s45.g.a;
        Intrinsics.checkNotNullParameter(r2, "dependency");
        s45.g.a = r2;
        com.ss.android.lark.jsruntime.vmsdk.c r8 = com.ss.android.lark.jsruntime.vmsdk.g.a;
        com.ss.android.lark.jsruntime.vmsdk.g.b = new xx4.a();
        com.ss.android.lark.jsruntime.vmsdk.g.a = new xx4.b();
        com.ss.android.lark.jsruntime.vmsdk.g.c = r7;
        int r9 = mnb.a.a;
        rnb.c.c("ccm_JSRuntimeFactory", "installAhaRuntimePluginIfNeed, AHA is unsupported in OfficeSDK");
    }
}
