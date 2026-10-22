package com.bytedance.locallife.sdk;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.life.service.map.LifeCollectMap;
import com.bytedance.android.locallife.core.service.LifeServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/sdk/LifeBusinessInitializer;", "", "()V", "init", "", "locallife-sdk-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LifeBusinessInitializer {
    public static final LifeBusinessInitializer INSTANCE = null;

    static {
        INSTANCE = new LifeBusinessInitializer();
    }

    private LifeBusinessInitializer() {
    }

    public final void init() {
        ConcurrentHashMap<Class<?>, Object> r100 = LifeServiceManager.f162660a;
        LifeCollectMap r101 = kz6.a.f506758a;
        Intrinsics.checkNotNullParameter(r101, PromotionProductPrivilegesStruct.SERVICES);
        monitor-enter(LifeServiceManager.class);
        ConcurrentHashMap<Class<?>, Object> r102 = LifeServiceManager.f162660a;     // Catch: Throwable -> L39
        if (r102.size() != 0) goto L7;
        r102.putAll(r101);     // Catch: Throwable -> L39
    L36:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L39
        monitor-exit(LifeServiceManager.class);
        return;
    L7:
        Iterator r104 = r101.entrySet().iterator();     // Catch: Throwable -> L39
    L9:
        if (r104.hasNext() == false) goto L36;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L39
        Class<?> r106 = (Class) r105.getKey();     // Catch: Throwable -> L39
        Object r107 = r105.getValue();     // Catch: Throwable -> L39
        if (r107 == null) goto L34;
        ConcurrentHashMap<Class<?>, Object> r108 = LifeServiceManager.f162660a;     // Catch: Throwable -> L39
        Object r109 = r108.get(r106);     // Catch: Throwable -> L39
        ArrayList r110 = new ArrayList();     // Catch: Throwable -> L39
        if ((r109 instanceof List) == true) goto L15;
        Object r111 = null;
    L16:
        List r112 = (List) r111;     // Catch: Throwable -> L39
        if (r112 == null) goto L19;
        int r113 = r112.size();     // Catch: Throwable -> L39
    L21:
        if (r113 < 1) goto L26;
        if (r109 == null) goto L25;
        r110.addAll((List) r109);     // Catch: Throwable -> L39
    L29:
        if ((r107 instanceof List) == false) goto L31;
        r110.addAll((Collection) r107);     // Catch: Throwable -> L39
    L32:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L39
        r108.put(r106, r110);     // Catch: Throwable -> L39
        goto L9
    L31:
        r110.add(r107);     // Catch: Throwable -> L39
        goto L32
    L25:
        throw new NullPointerException("null cannot be cast to non-null type java.util.List<*>");     // Catch: Throwable -> L39
    L26:
        if (r109 == null) goto L29;
        r110.add(r109);     // Catch: Throwable -> L39
        goto L29
    L19:
        r113 = 0;
        goto L21
    L15:
        r111 = r109;
        goto L16
    L34:
        monitor-exit(LifeServiceManager.class);
        return;
    L39:
        th = move-exception;
        throw th;
    }
}
