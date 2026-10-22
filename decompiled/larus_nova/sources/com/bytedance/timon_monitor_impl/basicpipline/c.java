package com.bytedance.timon_monitor_impl.basicpipline;

import com.bytedance.timon.pipeline.ComponentDeps;
import com.bytedance.timon.pipeline.TimonSystem;
import com.bytedance.timonbase.TMEnv;
import gh7.j;
import gh7.n;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@ComponentDeps(required = {n.class})
public final class c implements TimonSystem {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f270746b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f270747a;

    public static final class a {
        public a() {
        }

        public static void b(dh7.c r100, boolean r101) {
            ReentrantReadWriteLock.ReadLock r102 = r100.f468622b.readLock();
            r102.lock();
            Map<KClass<? extends dh7.b>, dh7.b> r103 = r100.f468621a;     // Catch: Throwable -> L24
            LinkedHashMap r104 = (LinkedHashMap) r103;     // Catch: Throwable -> L24
            Object r105 = r104.get(Reflection.getOrCreateKotlinClass(j.class));     // Catch: Throwable -> L24
            if (r105 == null) goto L23;
            j r106 = (j) r105;     // Catch: Throwable -> L24
            r102.unlock();
            ReentrantReadWriteLock.ReadLock r107 = r100.f468622b.readLock();
            r107.lock();
            Map<KClass<? extends dh7.b>, dh7.b> r108 = r100.f468621a;     // Catch: Throwable -> L19
            LinkedHashMap r109 = (LinkedHashMap) r108;     // Catch: Throwable -> L19
            Object r110 = r109.get(Reflection.getOrCreateKotlinClass(n.class));     // Catch: Throwable -> L19
            if (r110 == null) goto L18;
            final n r111 = (n) r110;     // Catch: Throwable -> L19
            r107.unlock();
            r111.f481305d.put("IsUrgent", String.valueOf(r101));
            r111.f481306e.put("IsUrgent", String.valueOf(r101));
            a(r111.f481305d, r106, r111);
            a(r111.f481306e, r106, r111);
            CopyOnWriteArrayList<Function0<Unit>> r112 = com.bytedance.timonbase.cache.a.f270801a;
            Function0<Unit> r113 = new NpthReportSystem$Companion$reportNpth$1(r111);
            if (TMEnv.f270768b == false) goto L13;
            r113.invoke();
            return;
        L13:
            CopyOnWriteArrayList<Function0<Unit>> r114 = com.bytedance.timonbase.cache.a.f270801a;
            if (r114.size() >= 100) goto L30;
            r114.add(r113);
            return;
        L30:
            return;
        L18:
            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.timon_monitor_api.pipeline.TraceInfo");     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            r107.unlock();
            throw th;
        L23:
            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.timon_monitor_api.pipeline.RuleValidateParams");     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            r102.unlock();
            throw th;
        }

        public static void a(Map r110, j r111, n r112) {
            r110.put("SDKVersion", "3.1.18-cn");
            r110.put("EventSource", "byteX");
            r110.put("EventId", String.valueOf(r111.f481289b));
            r110.put("apiId", String.valueOf(r111.f481289b));
            r110.put("EventName", r112.f481308g);
            r110.put("EventType", r112.f481309h);
            r110.put("EventTriggerScene", "TimonBasicMode");
            r110.put("EventStartedExtraInfo", CollectionsKt.joinToString$default(r112.f481310i, null, null, null, 0, null, null, 63, null));
            r110.put("EventWarningTypes", CollectionsKt.joinToString$default(r112.f481311j, null, null, null, 0, null, null, 63, null));
            String r113 = r111.f481290c;
            String r100 = "";
            if (r113 != null) goto L6;
            r113 = "";
        L6:
            r110.put("permissionType", r113);
            String r114 = r111.f481294g;
            if (r114 == null) goto L9;
            r100 = r114;
        L9:
            r110.put("certToken", r100);
            r110.put("dataTypes", CollectionsKt.joinToString$default(r111.f481291d, null, null, null, 0, null, null, 63, null));
        }
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final String name() {
        return "CacheReportSystem";
    }

    static {
        f270746b = new a();
    }

    public c() {
        this.f270747a = false;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean postInvoke(dh7.c r100) {
        a r101 = f270746b;
        boolean r102 = this.f270747a;
        r101.getClass();
        a.b(r100, r102);
        return true;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean preInvoke(dh7.c r100) {
        a r101 = f270746b;
        boolean r102 = this.f270747a;
        r101.getClass();
        a.b(r100, r102);
        return true;
    }
}
