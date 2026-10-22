package com.bytedance.timon_monitor_impl.fuse;

import com.bytedance.timon.pipeline.ComponentDeps;
import com.bytedance.timon.pipeline.TimonSystem;
import dh7.c;
import gh7.h;
import gh7.i;
import gh7.m;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@ComponentDeps(required = {kz5.a.class, dh7.a.class})
public final class a implements TimonSystem {

    /* JADX INFO: renamed from: com.bytedance.timon_monitor_impl.fuse.a$a, reason: collision with other inner class name */
    public static final class C3789a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final String name() {
        return "ApmFuseAddonSystem";
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean postInvoke(c r100) {
        return false;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean preInvoke(c r110) {
        ReentrantReadWriteLock.ReadLock r100 = r110.f468622b.readLock();
        r100.lock();
        Object r101 = ((LinkedHashMap) r110.f468621a).get(Reflection.getOrCreateKotlinClass(i.class));     // Catch: Throwable -> L79
        String r102 = null;
        if ((r101 instanceof i) == true) goto L6;
        r101 = null;
    L6:
        i r103 = (i) r101;     // Catch: Throwable -> L79
        r100.unlock();
        ReentrantReadWriteLock.ReadLock r104 = r110.f468622b.readLock();
        r104.lock();
        Object r105 = ((LinkedHashMap) r110.f468621a).get(Reflection.getOrCreateKotlinClass(kz5.a.class));     // Catch: Throwable -> L76
        if (r105 == null) goto L75;
        kz5.a r106 = (kz5.a) r105;     // Catch: Throwable -> L76
        r104.unlock();
        ReentrantReadWriteLock.ReadLock r107 = r110.f468622b.readLock();
        r107.lock();
        Object r108 = ((LinkedHashMap) r110.f468621a).get(Reflection.getOrCreateKotlinClass(h.class));     // Catch: Throwable -> L71
        if ((r108 instanceof h) == true) goto L15;
        r108 = null;
    L15:
        h r109 = (h) r108;     // Catch: Throwable -> L71
        r107.unlock();
        if (r109 == null) goto L19;
        int r111 = r109.f481286a;
    L20:
        ReentrantReadWriteLock.ReadLock r112 = r110.f468622b.readLock();
        r112.lock();
        Object r113 = ((LinkedHashMap) r110.f468621a).get(Reflection.getOrCreateKotlinClass(m.class));     // Catch: Throwable -> L68
        if ((r113 instanceof m) == true) goto L24;
        r113 = null;
    L24:
        m r114 = (m) r113;     // Catch: Throwable -> L68
        r112.unlock();
        ReentrantReadWriteLock.ReadLock r115 = r110.f468622b.readLock();
        r115.lock();
        Object r116 = ((LinkedHashMap) r110.f468621a).get(Reflection.getOrCreateKotlinClass(dh7.a.class));     // Catch: Throwable -> L65
        if (r116 == null) goto L64;
        dh7.a r117 = (dh7.a) r116;     // Catch: Throwable -> L65
        r115.unlock();
        ReentrantReadWriteLock.ReadLock r118 = r110.f468622b.readLock();
        r118.lock();
        Object r119 = ((LinkedHashMap) r110.f468621a).get(Reflection.getOrCreateKotlinClass(kz5.b.class));     // Catch: Throwable -> L60
        if ((r119 instanceof kz5.b) == true) goto L33;
        r119 = null;
    L33:
        kz5.b r120 = (kz5.b) r119;     // Catch: Throwable -> L60
        r118.unlock();
        boolean r121 = false;
        if (r120 != null) goto L37;
    L39:
        int r122 = 0;
    L40:
        r117.put("is_intercept", r122);
        r117.put("pipeline_name", "TimonFusePipeline");
        r117.put("api_id", String.valueOf(r111));
        if (r114 == null) goto L43;
        Object r123 = null;
        r114.getClass();
    L44:
        r117.put("token", r123);
        if (r120 != null) goto L47;
    L48:
        if (r103 == null) goto L50;
        String r124 = r103.f481287a;
    L51:
        if (r124 != null) goto L53;
    L54:
        r121 = true;
    L55:
        if (r121 == true) goto L59;
    L56:
        if (r103 == null) goto L58;
        r102 = r103.f481287a;
    L58:
        r117.put("fuse_system", r102);
    L59:
        return true;
    L53:
        if (r124.length() != 0) goto L55;
    L50:
        r124 = null;
        goto L51
    L47:
        if (r120.f506755a == true) goto L56;
    L43:
        r123 = null;
        goto L44
    L37:
        if (r120.f506755a != true) goto L39;
        r122 = 1;
    L60:
        th = move-exception;
        r118.unlock();
        throw th;
    L64:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.timon.pipeline.ApmParams");     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        r115.unlock();
        throw th;
    L68:
        th = move-exception;
        r112.unlock();
        throw th;
    L19:
        r111 = r106.f506748a;
    L71:
        th = move-exception;
        r107.unlock();
        throw th;
    L75:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.api.pipeline.ApiCallInfo");     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        r104.unlock();
        throw th;
    L79:
        th = move-exception;
        r100.unlock();
        throw th;
    }
}
