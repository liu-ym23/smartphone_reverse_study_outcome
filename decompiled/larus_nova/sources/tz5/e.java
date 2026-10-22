package tz5;

import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.timon.pipeline.ComponentDeps;
import com.bytedance.timon.pipeline.TimonSystem;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@ComponentDeps(required = {PrivacyEvent.class})
public final class e implements TimonSystem {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final String name() {
        return "JsbEventFetcherSystem";
    }

    public static void a(PrivacyEvent r100) {
        if (r100.D != null) goto L22;
        hz5.j.Companion.getClass();
        Object r101 = hz5.j.a.a().getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L10
        if (r101 == null) goto L9;
        hz5.j r102 = (hz5.j) r101;     // Catch: Exception -> L10
    L11:
        hz5.j.access$setINSTANCE$cp(r102);
        hz5.j r103 = hz5.j.access$getINSTANCE$cp();
        if (r103 == null) goto L16;
        List<hz5.i> r104 = r103.getJsbEvents();
        if (r104 == null) goto L16;
    L18:
        if ((!r104.isEmpty()) == false) goto L23;
        r100.E = r104;
        r100.D = PrefetchTiming.JSB;
        return;
    L23:
        return;
    L16:
        r104 = CollectionsKt.emptyList();
        goto L18
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.api.consumer.JsbEventFetcher");     // Catch: Exception -> L10
    L10:
        r102 = null;
        goto L11
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean postInvoke(dh7.c r100) {
        ReentrantReadWriteLock.ReadLock r101 = r100.f468622b.readLock();
        r101.lock();
        Map<KClass<? extends dh7.b>, dh7.b> r102 = r100.f468621a;     // Catch: Throwable -> L10
        LinkedHashMap r103 = (LinkedHashMap) r102;     // Catch: Throwable -> L10
        Object r104 = r103.get(Reflection.getOrCreateKotlinClass(PrivacyEvent.class));     // Catch: Throwable -> L10
        if (r104 == null) goto L9;
        PrivacyEvent r105 = (PrivacyEvent) r104;     // Catch: Throwable -> L10
        r101.unlock();
        a(r105);
        return true;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.api.consumer.PrivacyEvent");     // Catch: Throwable -> L10
    L10:
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
        Object r104 = r103.get(Reflection.getOrCreateKotlinClass(PrivacyEvent.class));     // Catch: Throwable -> L10
        if (r104 == null) goto L9;
        PrivacyEvent r105 = (PrivacyEvent) r104;     // Catch: Throwable -> L10
        r101.unlock();
        a(r105);
        return true;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.api.consumer.PrivacyEvent");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
