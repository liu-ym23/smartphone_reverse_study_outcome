package com.bytedance.timon_monitor_impl.basicpipline;

import com.bytedance.helios.sdk.detector.ApiConfig;
import com.bytedance.timon.pipeline.ComponentDeps;
import com.bytedance.timon.pipeline.TimonSystem;
import gh7.j;
import gh7.n;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@ComponentDeps(required = {n.class, j.class})
public final class e implements TimonSystem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f270748a = null;

    public e() {
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final String name() {
        return "TraceBuilderSystem";
    }

    static {
        f270748a = new e();
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean postInvoke(dh7.c r100) {
        ReentrantReadWriteLock.ReadLock r101 = r100.f468622b.readLock();
        r101.lock();
        Object r102 = ((LinkedHashMap) r100.f468621a).get(Reflection.getOrCreateKotlinClass(j.class));     // Catch: Throwable -> L19
        if (r102 == null) goto L18;
        j r103 = (j) r102;     // Catch: Throwable -> L19
        r101.unlock();
        ReentrantReadWriteLock.ReadLock r104 = r100.f468622b.readLock();
        r104.lock();
        Object r105 = ((LinkedHashMap) r100.f468621a).get(Reflection.getOrCreateKotlinClass(n.class));     // Catch: Throwable -> L14
        if (r105 == null) goto L13;
        n r106 = (n) r105;     // Catch: Throwable -> L14
        r104.unlock();
        HashMap<Integer, com.bytedance.helios.sdk.detector.b> r107 = com.bytedance.helios.sdk.e.f245557a;
        com.bytedance.helios.sdk.detector.b r108 = com.bytedance.helios.sdk.e.a(r103.f481289b);
        ApiConfig r109 = r108.d(r103.f481289b);
        com.bytedance.helios.sdk.detector.b.c(r106.f481302a, r108.getClass().getCanonicalName(), r106.f481308g, r109.f245515d + ".kt");
        int r110 = jh7.a.f499098a;
        r106.f481307f = jh7.a.a(r106.f481302a);
        return true;
    L13:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.timon_monitor_api.pipeline.TraceInfo");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r104.unlock();
        throw th;
    L18:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.timon_monitor_api.pipeline.RuleValidateParams");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean preInvoke(dh7.c r100) {
        ReentrantReadWriteLock.ReadLock r101 = r100.f468622b.readLock();
        r101.lock();
        Map<KClass<? extends dh7.b>, dh7.b> r102 = r100.f468621a;     // Catch: Throwable -> L10
        LinkedHashMap r103 = (LinkedHashMap) r102;     // Catch: Throwable -> L10
        Object r104 = r103.get(Reflection.getOrCreateKotlinClass(n.class));     // Catch: Throwable -> L10
        if (r104 == null) goto L9;
        n r105 = (n) r104;     // Catch: Throwable -> L10
        r101.unlock();
        int r106 = jh7.a.f499098a;
        r105.f481307f = jh7.a.a(r105.f481302a);
        return true;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.timon_monitor_api.pipeline.TraceInfo");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
