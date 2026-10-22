package com.bytedance.android.shopping.api.mall.ability;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import e93.d;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallAbilityManager {
    public static final ConcurrentHashMap<Class<? extends d>, Map<String, a<? extends d>>> a = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/ability/MallAbilityManager$LifecycleObserverWrapper;", "Le93/d;", "T", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LifecycleObserverWrapper<T extends d> implements LifecycleObserver {
        public final Class<T> a;
        public final T b;
        public final String c;
        public final LifecycleOwner d;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            ConcurrentHashMap<Class<? extends d>, Map<String, a<? extends d>>> r0 = MallAbilityManager.a;
            Class<T> r1 = this.a;
            String r2 = this.c;
            Intrinsics.checkNotNullParameter(r1, "clazz");
            Intrinsics.checkNotNullParameter(r2, "key");
            ConcurrentHashMap<Class<? extends d>, Map<String, a<? extends d>>> r3 = MallAbilityManager.a;
            Map<String, a<? extends d>> r4 = r3.get(r1);
            if (r4 == null) goto L13;
            a<? extends d> r5 = r4.get(r2);
            if (r5 == null) goto L14;
            LifecycleObserverWrapper<T> r6 = r5.b;
            if (r6 == null) goto L9;
            r6.d.getLifecycle().removeObserver(r6);
        L9:
            Map<String, a<? extends d>> r7 = r3.get(r1);
            if (r7 == null) goto L15;
            a<? extends d> r8 = r7.remove(r2);
            return;
        L15:
            return;
        L14:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public LifecycleObserverWrapper(Class r2, d r3, String r4, Fragment r5) {
            Intrinsics.checkNotNullParameter(r2, "clazz");
            Intrinsics.checkNotNullParameter(r3, "ability");
            Intrinsics.checkNotNullParameter(r4, "key");
            Intrinsics.checkNotNullParameter(r5, "owner");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class a<T extends d> {
        public final T a;
        public final LifecycleObserverWrapper<T> b;

        public a(T r2, LifecycleObserverWrapper<T> r3) {
            Intrinsics.checkNotNullParameter(r2, "ability");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static d b(Class r1, Fragment r2) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        String r3 = String.valueOf(r2.hashCode());
        Map<String, a<? extends d>> r4 = a.get(r1);
        if (r4 == null) goto L7;
        a<? extends d> r5 = r4.get(r3);
        if (r5 == null) goto L7;
        d r6 = r5.a;
    L9:
        if ((r6 instanceof d) == true) goto L12;
        return null;
    L12:
        return r6;
    L7:
        r6 = null;
        goto L9
    }

    public static void a(Class r4, d r5, Fragment r6) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        Intrinsics.checkNotNullParameter(r5, "ability");
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        String r0 = String.valueOf(r6.hashCode());
        if (r6.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L22;
        ConcurrentHashMap<Class<? extends d>, Map<String, a<? extends d>>> r1 = a;
        if (r1.get(r4) != null) goto L8;
        r1.put(r4, new LinkedHashMap());
    L8:
        Map<String, a<? extends d>> r2 = r1.get(r4);
        if (r2 == null) goto L11;
        a<? extends d> r3 = r2.get(r0);
    L12:
        LifecycleObserverWrapper r7 = new LifecycleObserverWrapper(r4, r5, r0, r6);
        r6.getLifecycle().addObserver(r7);
        Map<String, a<? extends d>> r8 = r1.get(r4);
        if (r8 == null) goto L15;
        a<? extends d> r9 = r8.put(r0, new a(r5, r7));
    L15:
        if (r3 == null) goto L20;
        LifecycleObserverWrapper<T> r10 = r3.b;
        if (r10 == 0) goto L21;
        r10.d.getLifecycle().removeObserver(r10);
        return;
    L21:
        return;
    L20:
        return;
    L11:
        r3 = null;
        goto L12
    }
}
