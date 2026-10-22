package com.bytedance.timon_monitor_impl.pipeline;

import com.bytedance.timon.pipeline.ComponentDeps;
import com.bytedance.timon.pipeline.TimonSystem;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@ComponentDeps(required = {kz5.a.class})
public final class e implements TimonSystem {

    public static final class a {
        public static gh7.h a(kz5.a r100) {
            Object r101 = r100.f506751d;
            if (r101 != null) goto L5;
        L9:
            return null;
        L5:
            if ((r101 instanceof Method) == false) goto L9;
            StringBuilder r102 = new StringBuilder();
            Method r103 = (Method) r101;
            r102.append(r103.getDeclaringClass().getName());
            r102.append('.');
            r102.append(r103.getName());
            String r104 = r102.toString();
            Integer r105 = e06.f.b(e06.f.f470645a.get(r104));
            if (r105 == null) goto L9;
            return new gh7.h(r105.intValue());
        }
    }

    static {
    }

    public e() {
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final String name() {
        return "ReflectParser";
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean postInvoke(dh7.c r100) {
        ReentrantReadWriteLock.ReadLock r101 = r100.f468622b.readLock();
        r101.lock();
        Map<KClass<? extends dh7.b>, dh7.b> r102 = r100.f468621a;     // Catch: Throwable -> L24
        LinkedHashMap r103 = (LinkedHashMap) r102;     // Catch: Throwable -> L24
        Object r104 = r103.get(Reflection.getOrCreateKotlinClass(kz5.a.class));     // Catch: Throwable -> L24
        if (r104 == null) goto L23;
        kz5.a r105 = (kz5.a) r104;     // Catch: Throwable -> L24
        r101.unlock();
        if (r105.f506754g == false) goto L21;
        ReentrantReadWriteLock.ReadLock r106 = r100.f468622b.readLock();
        r106.lock();
        boolean r107 = r100.f468621a.containsKey(Reflection.getOrCreateKotlinClass(gh7.h.class));     // Catch: Throwable -> L18
        r106.unlock();
        if (r107 == true) goto L21;
        gh7.h r108 = a.a(r105);
        if (r108 == null) goto L16;
        r100.a(r108);
        return true;
    L16:
        return false;
    L18:
        th = move-exception;
        r106.unlock();
        throw th;
    L21:
        return true;
    L23:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.api.pipeline.ApiCallInfo");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean preInvoke(dh7.c r100) {
        ReentrantReadWriteLock.ReadLock r101 = r100.f468622b.readLock();
        r101.lock();
        Map<KClass<? extends dh7.b>, dh7.b> r102 = r100.f468621a;     // Catch: Throwable -> L17
        LinkedHashMap r103 = (LinkedHashMap) r102;     // Catch: Throwable -> L17
        Object r104 = r103.get(Reflection.getOrCreateKotlinClass(kz5.a.class));     // Catch: Throwable -> L17
        if (r104 == null) goto L16;
        kz5.a r105 = (kz5.a) r104;     // Catch: Throwable -> L17
        r101.unlock();
        if (r105.f506754g == false) goto L13;
        gh7.h r106 = a.a(r105);
        if (r106 == null) goto L11;
        r100.a(r106);
        return true;
    L11:
        return false;
    L13:
        return true;
    L16:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.api.pipeline.ApiCallInfo");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
