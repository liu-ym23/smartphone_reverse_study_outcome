package com.bytedance.timon_monitor_impl.pipeline;

import com.bytedance.timon.pipeline.TimonSystem;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements TimonSystem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f270762a = null;

    public d() {
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final String name() {
        return "EventId";
    }

    static {
        f270762a = new d();
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean postInvoke(dh7.c r100) {
        ReentrantReadWriteLock.ReadLock r101 = r100.f468622b.readLock();
        r101.lock();
        Map<KClass<? extends dh7.b>, dh7.b> r102 = r100.f468621a;     // Catch: Throwable -> L12
        LinkedHashMap r103 = (LinkedHashMap) r102;     // Catch: Throwable -> L12
        Object r104 = r103.get(Reflection.getOrCreateKotlinClass(gh7.d.class));     // Catch: Throwable -> L12
        if ((r104 instanceof gh7.d) == true) goto L6;
        r104 = null;
    L6:
        gh7.d r105 = (gh7.d) r104;     // Catch: Throwable -> L12
        r101.unlock();
        if (r105 != null) goto L17;
        r100.a(new gh7.d(StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null)));
        return true;
    L17:
        return true;
    L12:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean preInvoke(dh7.c r100) {
        ReentrantReadWriteLock.ReadLock r101 = r100.f468622b.readLock();
        r101.lock();
        Map<KClass<? extends dh7.b>, dh7.b> r102 = r100.f468621a;     // Catch: Throwable -> L12
        LinkedHashMap r103 = (LinkedHashMap) r102;     // Catch: Throwable -> L12
        Object r104 = r103.get(Reflection.getOrCreateKotlinClass(gh7.d.class));     // Catch: Throwable -> L12
        if ((r104 instanceof gh7.d) == true) goto L6;
        r104 = null;
    L6:
        gh7.d r105 = (gh7.d) r104;     // Catch: Throwable -> L12
        r101.unlock();
        if (r105 != null) goto L17;
        r100.a(new gh7.d(StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null)));
        return true;
    L17:
        return true;
    L12:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
