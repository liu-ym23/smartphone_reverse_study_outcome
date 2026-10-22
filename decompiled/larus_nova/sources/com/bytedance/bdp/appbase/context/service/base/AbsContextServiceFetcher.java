package com.bytedance.bdp.appbase.context.service.base;

import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.appbase.context.service.ContextService;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class AbsContextServiceFetcher {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f200771b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f200772a;

    public static final class a extends AbsContextServiceFetcher {
        @Override // com.bytedance.bdp.appbase.context.service.base.AbsContextServiceFetcher
        public final HashMap<Class<?>, Class<ContextService<?>>> b() {
            return new HashMap();
        }

        public a() {
        }
    }

    public static final class b {
    }

    public abstract HashMap<Class<?>, Class<ContextService<?>>> b();

    static {
        f200771b = new a();
    }

    public AbsContextServiceFetcher() {
        this.f200772a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new AbsContextServiceFetcher$mContextServiceImplClassMap$2(this));
    }

    public final <T extends ContextService<?>> T a(BdpAppContext r110, Class<T> r111) {
        T r100 = null;
        if (Intrinsics.areEqual(this, f200771b) == false) goto L5;
        return null;
    L5:
        Class r112 = (Class) ((HashMap) this.f200772a.getValue()).get(r111);
        if (r112 != null) goto L8;
        return null;
    L8:
        Constructor<?>[] r101 = r112.getDeclaredConstructors();
        if (r101 == null) goto L36;
        if (r101.length != 0) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L36;
        int r103 = r101.length;
        int r104 = 0;
    L16:
        if (r104 >= r103) goto L33;
        Constructor<?> r105 = r101[r104];
        Class<?>[] r106 = r105.getParameterTypes();
        if (r106 == null) goto L32;
        if (r106.length != 1) goto L32;
        if (r106[0].isInstance(r110) == false) goto L32;
        r105.setAccessible(true);
        Object r113 = r105.newInstance(new Object[]{r110});
        if (r113 == null) goto L26;
        boolean r107 = r113 instanceof ContextService;
    L27:
        if (r107 == false) goto L31;
        r100 = (T) r113;
        if (r100 == null) goto L34;
        r100.init$bdp_infrastructure_release();
    L34:
        return r100;
    L31:
        g94.b.c().o(new Object[]{new IllegalArgumentException("not ContextService " + r112)});
        goto L34
    L26:
        r107 = true;
    L32:
        r104 = r104 + 1;
        goto L16
    L33:
        g94.b.c().o(new Object[]{new RuntimeException("cannot find correct constructor " + r112)});
        goto L34
    L13:
        r102 = false;
    L36:
        throw new IllegalArgumentException("Can't get even one available constructor for " + r112);
    }
}
