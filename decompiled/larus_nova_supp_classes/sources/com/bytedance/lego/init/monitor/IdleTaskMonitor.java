package com.bytedance.lego.init.monitor;

import android.util.Pair;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.util.c;
import com.bytedance.services.apm.api.IApmAgent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class IdleTaskMonitor {
    public static final /* synthetic */ KProperty[] a = null;
    public static final CopyOnWriteArrayList<Pair<String, Long>> b = null;
    public static final Lazy c = null;
    public static long d;
    public static final IdleTaskMonitor e = null;

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(IdleTaskMonitor.class), "iApmAgent", "getIApmAgent()Lcom/bytedance/services/apm/api/IApmAgent;"))};
        e = new IdleTaskMonitor();
        b = new CopyOnWriteArrayList();
        c = LazyKt.lazy(IdleTaskMonitor$iApmAgent$2.INSTANCE);
        d = -1;
    }

    public IdleTaskMonitor() {
    }

    public static void a() {
        Lazy r0 = c;
        KProperty r1 = a[0];
        if (((IApmAgent) r0.getValue()) == null) goto L15;
        JSONObject r2 = new JSONObject();
        Iterator<Pair<String, Long>> r3 = b.iterator();     // Catch: Throwable -> L17
    L7:
        if (r3.hasNext() == false) goto L10;
        Pair<String, Long> r4 = r3.next();     // Catch: Throwable -> L17
        r2.put((String) r4.first, ((Number) r4.second).longValue());     // Catch: Throwable -> L17
    L10:
        int r5 = c.a;
        c.a("IdleTaskMonitor", "sendIdleTaskMonitor " + r2);
        JSONObject r6 = new JSONObject();
        r6.put("category", InitScheduler.INSTANCE.getINIT_SCHEDULER_CATEGORY$initscheduler_release());
        Lazy r7 = c;
        KProperty r8 = a[0];
        IApmAgent r9 = (IApmAgent) r7.getValue();
        if (r9 == null) goto L13;
        r9.monitorEvent("idle_task_monitor", r6, r2, new JSONObject());
    L13:
        b.clear();
        return;
    L15:
        int r10 = c.a;
    }
}
