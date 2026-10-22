package com.bytedance.timonkit;

import android.app.Application;
import com.bytedance.timon.foundation.impl.EventMonitorImp;
import com.bytedance.timon.foundation.interfaces.ILogger;
import com.bytedance.timonbase.ITMLifecycleService;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.config.TMSettingFetcher;
import com.bytedance.timonbase.report.TMMetric;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.bytedance.timonbase.utils.EnumUtils$WorkType;
import com.bytedance.timonbase.utils.TMThreadUtils;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import sx9.k;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<ITMLifecycleService> f270915a = null;

    static {
        f270915a = new CopyOnWriteArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(final String r110, final int r111, final k r112, final Application r113, final com.bytedance.timonbase.a r114) {
        TMMetric.a r115 = new TMMetric.a(null, 7);
        TMEnv.f270768b = true;
        TMEnv.f270775i = r112;
        TMEnv.f270770d = r111;
        TMEnv.f270771e = r110;
        TMEnv.f270772f = r114.f270787a;
        TMEnv.f270773g = r114.f270788b;
        TMEnv.f270774h = r114.f270789c;
        TMEnv.f270769c = r113;
        boolean r100 = false;
        if ((r113.getApplicationInfo().flags & 2) == 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        int r102 = com.bytedance.timonbase.b.f270799a;
        vg7.a.c().a();
        TMEnv.f270767a = true;
    L8:
        ThreadMethodProxy.currentThread().getName();
        f270915a.clear();
        final TMSettingFetcher r103 = new TMSettingFetcher(Timon$init$fetcher$1.INSTANCE);
        JsonObject r104 = com.bytedance.timonbase.config.a.f270807a;
        com.bytedance.timonbase.config.a.f270808b = new com.bytedance.timonbase.config.a.C3793a(r103);
        TMEnv.f270777k = "timon";
        TMThreadUtils r105 = TMThreadUtils.f270906d;
        Function0<Unit> r106 = new Timon$init$1(r113, r103);
        r105.getClass();
        TMThreadUtils.a(r106);
        if (TMThreadUtils.f270904b == null) goto L11;
        r100 = true;
    L11:
        if (r100 == true) goto L13;
        TMThreadUtils.f270904b = PThreadExecutorsUtils.newFixedThreadPool(8, new DefaultThreadFactory("TMThreadUtils"));
    L13:
        String r107 = (String) r112.invoke();
        ILogger r108 = vg7.a.f554734a;
        vg7.a.f554737d = new EventMonitorImp(r113, r110, r107, r111, TMEnv.f270772f, TMEnv.f270774h);
        ScenesDetector.f270874j.k(r113);
        final Function2<List<? extends ITMLifecycleService>, EnumUtils$WorkType, Unit> r109 = new Timon$init$startService$1(r111, r110, r112, r113, r114);
        Set r116 = ServiceManager.get().getServices(ITMLifecycleService.class);
        ArrayList r117 = new ArrayList();
        Iterator r118 = r116.iterator();
    L15:
        if (r118.hasNext() == false) goto L19;
        Object r119 = r118.next();
        if (((ITMLifecycleService) r119).enable() == false) goto L15;
        r117.add(r119);
        goto L15
    L19:
        LinkedHashMap r120 = new LinkedHashMap();
        Iterator r121 = r117.iterator();
    L21:
        if (r121.hasNext() == false) goto L26;
        Object r122 = r121.next();
        EnumUtils$WorkType r123 = ((ITMLifecycleService) r122).a();
        Object r124 = r120.get(r123);
        if (r124 != null) goto L25;
        r124 = new ArrayList();
        r120.put(r123, r124);
    L25:
        ((List) r124).add(r122);
        goto L21
    L26:
        Iterator r125 = r120.entrySet().iterator();
    L28:
        if (r125.hasNext() == false) goto L35;
        final Map.Entry r126 = (Map.Entry) r125.next();
        EnumUtils$WorkType r127 = (EnumUtils$WorkType) r126.getKey();
        int r128 = a.f270914a[r127.ordinal()];
        if (r128 != 1) goto L31;
        r109.invoke(r126.getValue(), EnumUtils$WorkType.MAIN);
        goto L28
    L31:
        if (r128 != 2) goto L28;
        TMThreadUtils r129 = TMThreadUtils.f270906d;
        Function0<Unit> r130 = new Timon$init$$inlined$forEach$lambda$1(r126, r109);
        r129.getClass();
        TMThreadUtils.a(r130);
        goto L28
    L35:
        TMThreadUtils r131 = TMThreadUtils.f270906d;
        Timon$init$5 r132 = Timon$init$5.INSTANCE;
        r131.getClass();
        TMThreadUtils.a(r132);
        int r133 = TMMetric.f270829a;
        TMMetric.b(r115, TMThreadUtils.b());
        TMMetric.a();
        return;
    L5:
        r101 = false;
        goto L6
    }
}
