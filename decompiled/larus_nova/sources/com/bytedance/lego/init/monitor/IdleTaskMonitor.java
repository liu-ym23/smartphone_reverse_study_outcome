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

/* JADX INFO: loaded from: classes.dex */
public final class IdleTaskMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f254537a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Pair<String, Long>> f254538b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f254539c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f254540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final IdleTaskMonitor f254541e = null;

    static {
        f254537a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(IdleTaskMonitor.class), "iApmAgent", "getIApmAgent()Lcom/bytedance/services/apm/api/IApmAgent;"))};
        f254541e = new IdleTaskMonitor();
        f254538b = new CopyOnWriteArrayList();
        f254539c = LazyKt.lazy(IdleTaskMonitor$iApmAgent$2.INSTANCE);
        f254540d = -1;
    }

    public IdleTaskMonitor() {
    }

    public static void a() {
        Lazy r100 = f254539c;
        KProperty r101 = f254537a[0];
        if (((IApmAgent) r100.getValue()) == null) goto L15;
        JSONObject r102 = new JSONObject();
        Iterator<Pair<String, Long>> r103 = f254538b.iterator();     // Catch: Throwable -> L17
    L7:
        if (r103.hasNext() == false) goto L10;
        Pair<String, Long> r104 = r103.next();     // Catch: Throwable -> L17
        r102.put((String) r104.first, ((Number) r104.second).longValue());     // Catch: Throwable -> L17
    L10:
        int r105 = c.f254571a;
        c.a("IdleTaskMonitor", "sendIdleTaskMonitor " + r102);
        JSONObject r106 = new JSONObject();
        r106.put("category", InitScheduler.INSTANCE.getINIT_SCHEDULER_CATEGORY$initscheduler_release());
        Lazy r107 = f254539c;
        KProperty r108 = f254537a[0];
        IApmAgent r109 = (IApmAgent) r107.getValue();
        if (r109 == null) goto L13;
        r109.monitorEvent("idle_task_monitor", r106, r102, new JSONObject());
    L13:
        f254538b.clear();
        return;
    L15:
        int r110 = c.f254571a;
    }
}
