package com.bytedance.timon_monitor_impl.pipeline;

import com.bytedance.timon.pipeline.ComponentDeps;
import com.bytedance.timon.pipeline.TimonSystem;
import com.bytedance.timonbase.apicache.ShieldCache;
import gh7.l;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@ComponentDeps(required = {kz5.a.class, dh7.a.class})
public final class h implements TimonSystem {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final String name() {
        return "ShieldFilter";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean postInvoke(dh7.c r110) {
        ReentrantReadWriteLock.ReadLock r100 = r110.f468622b.readLock();
        r100.lock();
        Object r101 = ((LinkedHashMap) r110.f468621a).get(Reflection.getOrCreateKotlinClass(l.class));     // Catch: Throwable -> L47
        Object r102 = null;
        if ((r101 instanceof l) == true) goto L6;
        r101 = null;
    L6:
        l r103 = (l) r101;     // Catch: Throwable -> L47
        r100.unlock();
        if (r103 != null) goto L10;
    L12:
        ReentrantReadWriteLock.ReadLock r104 = r110.f468622b.readLock();
        r104.lock();
        Object r105 = ((LinkedHashMap) r110.f468621a).get(Reflection.getOrCreateKotlinClass(kz5.a.class));     // Catch: Throwable -> L44
        if (r105 == null) goto L43;
        kz5.a r106 = (kz5.a) r105;     // Catch: Throwable -> L44
        r104.unlock();
        ShieldCache r107 = (ShieldCache) ShieldCache.f270792b.getValue();
        lh7.b r108 = r107.f509278a.get(String.valueOf(r106.f506748a));
        if (r108 == null) goto L41;
        com.bytedance.timonbase.apicache.a r111 = new com.bytedance.timonbase.apicache.a(r106.f506748a, r106.f506749b, r106.f506750c, r106.f506751d, r106.f506752e, r106.f506753f);
        if (r103 == null) goto L21;
    L23:
        ReentrantReadWriteLock.ReadLock r109 = r110.f468622b.readLock();
        r109.lock();
        Object r112 = ((LinkedHashMap) r110.f468621a).get(Reflection.getOrCreateKotlinClass(kz5.b.class));     // Catch: Throwable -> L38
        if ((r112 instanceof kz5.b) == false) goto L28;
        r102 = r112;
    L28:
        kz5.b r113 = (kz5.b) r102;     // Catch: Throwable -> L38
        r109.unlock();
        if (r113 == null) goto L37;
        Object r114 = r113.f506756b;
        mh7.a<T> r115 = r108.f509285g;
        if (r115 != 0) goto L34;
    L36:
        r108.f509283e.put(r108.f509284f.invoke((T) r111), r114);
        goto L37
    L34:
        if (r115.a(r111) == true) goto L36;
    L37:
        return true;
    L38:
        th = move-exception;
        r109.unlock();
        throw th;
    L21:
        if (r108.a(r111) == true) goto L23;
        return false;
    L41:
        return true;
    L43:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.api.pipeline.ApiCallInfo");     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        r104.unlock();
        throw th;
    L10:
        if (r103.f481299a != true) goto L12;
        return false;
    L47:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean preInvoke(dh7.c r110) {
        ReentrantReadWriteLock.ReadLock r100 = r110.f468622b.readLock();
        r100.lock();
        Map<KClass<? extends dh7.b>, dh7.b> r101 = r110.f468621a;     // Catch: Throwable -> L35
        LinkedHashMap r102 = (LinkedHashMap) r101;     // Catch: Throwable -> L35
        Object r103 = r102.get(Reflection.getOrCreateKotlinClass(kz5.a.class));     // Catch: Throwable -> L35
        if (r103 == null) goto L34;
        kz5.a r104 = (kz5.a) r103;     // Catch: Throwable -> L35
        r100.unlock();
        ShieldCache r105 = (ShieldCache) ShieldCache.f270792b.getValue();
        String r106 = String.valueOf(r104.f506748a);
        lh7.b r107 = r105.f509278a.get(r106);
        if (r107 != null) goto L9;
        return true;
    L9:
        if (r107.f509279a == false) goto L11;
        return true;
    L11:
        com.bytedance.timonbase.apicache.a r108 = new com.bytedance.timonbase.apicache.a(r104.f506748a, r104.f506749b, r104.f506750c, r104.f506751d, r104.f506752e, r104.f506753f);
        if (r107.a(r108) == false) goto L28;
        ReentrantReadWriteLock.ReadLock r109 = r110.f468622b.readLock();
        r109.lock();
        Map<KClass<? extends dh7.b>, dh7.b> r111 = r110.f468621a;     // Catch: Throwable -> L25
        LinkedHashMap r112 = (LinkedHashMap) r111;     // Catch: Throwable -> L25
        Object r113 = r112.get(Reflection.getOrCreateKotlinClass(dh7.a.class));     // Catch: Throwable -> L25
        if (r113 == null) goto L24;
        dh7.a r114 = (dh7.a) r113;     // Catch: Throwable -> L25
        r109.unlock();
        int r115 = r107.f509281c;
        if (r115 <= 0) goto L20;
        r114.put("shield_count", r115);
        r114.put("shield_strategy", r107.f509287i);
        l r116 = new l(false, r107.f509286h, r107.f509281c, 1);
        r107.f509281c = 0;
    L21:
        r110.a(r116);
        return true;
    L20:
        r116 = new l(false, false, 0, 7);
        goto L21
    L24:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.timon.pipeline.ApmParams");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r109.unlock();
        throw th;
    L28:
        r110.a(new l(true, false, 0, 6));
        if (r107.f509286h == false) goto L31;
        String r117 = r107.f509284f.invoke((T) r108);
        r110.a(new kz5.b(true, r107.f509283e.get(r117), false));
    L31:
        return false;
    L34:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.api.pipeline.ApiCallInfo");     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        r100.unlock();
        throw th;
    }
}
