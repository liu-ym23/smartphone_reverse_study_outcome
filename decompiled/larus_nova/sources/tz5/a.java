package tz5;

import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.timon.pipeline.ComponentDeps;
import com.bytedance.timon.pipeline.TimonSystem;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@ComponentDeps(required = {PrivacyEvent.class})
public final class a implements TimonSystem {

    /* JADX INFO: renamed from: tz5.a$a, reason: collision with other inner class name */
    public static final class C7808a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final String name() {
        return "EventFieldSystem";
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
        int r106 = sz5.a.f543945b;
        sz5.a.C7673a.a(r105);
        sz5.a.C7673a.b(r105);
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
        int r106 = sz5.a.f543945b;
        sz5.a.C7673a.a(r105);
        sz5.a.C7673a.b(r105);
        return true;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.api.consumer.PrivacyEvent");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
