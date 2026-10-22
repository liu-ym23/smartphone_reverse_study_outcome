package tz5;

import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.timon.pipeline.ComponentDeps;
import com.bytedance.timon.pipeline.TimonSystem;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@ComponentDeps(required = {PrivacyEvent.class})
public final class c implements TimonSystem {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final String name() {
        return "FrequencySystem";
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean postInvoke(dh7.c r100) {
        return true;
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
        ConcurrentHashMap<String, CopyOnWriteArrayList<Pair<Long, Integer>>> r106 = zz5.c.f574094a;
        zz5.c.f(r105);
        return true;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.api.consumer.PrivacyEvent");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
