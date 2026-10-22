package com.bytedance.reparo.secondary;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.reparo.core.PatchEventReporter;
import com.bytedance.reparo.core.common.event.Event;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static void a(Application r100, b r101, ScheduledExecutorService r102) {
        String r103 = e97.f.b(r100);
        boolean r104 = TextUtils.equals(r100.getPackageName(), e97.f.b(r100));
        Event.f267340o = r103;
        Event.f267341p = Boolean.valueOf(r104);
        HashSet<String> r105 = Logger.f267464b;
        r105.add(Logger.class.getName());
        r105.add(com.bytedance.reparo.core.k.class.getName());
        r105.add(b97.a.class.getName());
        r105.add(Logger.a.class.getName());
        if ((com.bytedance.reparo.core.k.f267379a instanceof Logger.a) == true) goto L5;
        com.bytedance.reparo.core.k.f267379a = Logger.f267463a;
    L5:
        d r106 = new d();
        c.f267474a = r106;
        PatchEventReporter.f267313b = r106;
        f.f267479e = r102;
        f.f267480f = r100;
        MonitorService.f267468d = r101;
        MonitorService.f267469e = r100;
        a97.e.f2290c = new j();
        r102.execute(new k(r100, r101));
        r102.execute(new h(r100, r102));
    }
}
