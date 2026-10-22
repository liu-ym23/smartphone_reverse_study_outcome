package com.bytedance.awemeopen.apps.framework.comment.write.arch.ability;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import yy3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AbilityManager {
    public static final ConcurrentHashMap<Class<? extends b>, Map<String, a<? extends b>>> a = null;
    public static final ConcurrentHashMap<Class<? extends b>, Map<String, MutableLiveData<yy3.a<? extends b>>>> b = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/write/arch/ability/AbilityManager$LifecycleObserverWrapper;", "Lyy3/b;", "T", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class LifecycleObserverWrapper<T extends b> implements LifecycleObserver {
        public final Class<T> a;
        public final T b;
        public final String c;
        public final LifecycleOwner d;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            ConcurrentHashMap<Class<? extends b>, Map<String, a<? extends b>>> r0 = AbilityManager.a;
            Class<T> r1 = this.a;
            String r2 = this.c;
            Intrinsics.checkNotNullParameter(r1, "clazz");
            Intrinsics.checkNotNullParameter(r2, "key");
            ConcurrentHashMap<Class<? extends b>, Map<String, a<? extends b>>> r3 = AbilityManager.a;
            Map<String, a<? extends b>> r4 = r3.get(r1);
            if (r4 == null) goto L14;
            a<? extends b> r5 = r4.get(r2);
            if (r5 == null) goto L15;
            LifecycleObserverWrapper<T> r6 = r5.b;
            if (r6 == null) goto L9;
            r6.d.getLifecycle().removeObserver(r6);
        L9:
            Map<String, a<? extends b>> r7 = r3.get(r1);
            if (r7 == null) goto L12;
            a<? extends b> r8 = r7.remove(r2);
        L12:
            MutableLiveData r9 = AbilityManager.b(r1, r2);
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.interf.AbilityChangeEvent<T of com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.AbilityManager.unbind$lambda$10>>");
            r9.setValue(new yy3.a(new WeakReference(r5.a), new WeakReference(null), 1));
            return;
        L15:
            return;
        }

        public LifecycleObserverWrapper(Class<T> r2, T r3, String r4, LifecycleOwner r5) {
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

    public static final class a<T extends b> {
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
        b = new ConcurrentHashMap();
    }

    public static LiveData b(Class r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "key");
        ConcurrentHashMap<Class<? extends b>, Map<String, MutableLiveData<yy3.a<? extends b>>>> r0 = b;
        if (r0.get(r3) != null) goto L5;
        r0.put(r3, new LinkedHashMap());
    L5:
        Map<String, MutableLiveData<yy3.a<? extends b>>> r1 = r0.get(r3);
        Intrinsics.checkNotNull(r1);
        if (r1.get(r4) != null) goto L8;
        Map<String, MutableLiveData<yy3.a<? extends b>>> r2 = r0.get(r3);
        Intrinsics.checkNotNull(r2);
        r2.put(r4, new MutableLiveData());
    L8:
        Map<String, MutableLiveData<yy3.a<? extends b>>> r5 = r0.get(r3);
        Intrinsics.checkNotNull(r5);
        LiveData r6 = r5.get(r4);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.interf.AbilityChangeEvent<T of com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.AbilityManager.getLiveData>>");
        return r6;
    }

    public static void a(Class r7, b r8, LifecycleOwner r9) {
        Intrinsics.checkNotNullParameter(r7, "clazz");
        Intrinsics.checkNotNullParameter(r8, "ability");
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        String r2 = String.valueOf(r9.hashCode());
        Intrinsics.checkNotNullParameter(r7, "clazz");
        Intrinsics.checkNotNullParameter(r8, "ability");
        Intrinsics.checkNotNullParameter(r2, "key");
        Boolean r0 = Boolean.TRUE;
        Lifecycle r1 = r9.getLifecycle();
        if (r1 == null) goto L5;
        Lifecycle.State r3 = r1.getCurrentState();
    L7:
        if (r3 == Lifecycle.State.DESTROYED) goto L24;
        ConcurrentHashMap<Class<? extends b>, Map<String, a<? extends b>>> r4 = a;
        if (r4.get(r7) != null) goto L12;
        r4.put(r7, new LinkedHashMap());
    L12:
        Map<String, a<? extends b>> r5 = r4.get(r7);
        Intrinsics.checkNotNull(r5);
        a<? extends b> r6 = r5.get(r2);
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        LifecycleObserverWrapper r11 = new LifecycleObserverWrapper(r7, r8, r2, r9);
        if (Intrinsics.areEqual(r0, r0) == false) goto L15;
        r9.getLifecycle().addObserver(r11);
    L15:
        r10.element = r11;
        Map<String, a<? extends b>> r12 = r4.get(r7);
        Intrinsics.checkNotNull(r12);
        r12.put(r2, new a(r8, (LifecycleObserverWrapper) r10.element));
        if (r6 == null) goto L21;
        LifecycleObserverWrapper<T> r13 = r6.b;
        if (r13 == 0) goto L20;
        r13.d.getLifecycle().removeObserver(r13);
    L20:
        MutableLiveData r14 = b(r7, r2);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.interf.AbilityChangeEvent<T of com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.AbilityManager.bindInner>>");
        r14.setValue(new yy3.a(new WeakReference(r8), new WeakReference(r6.a), 2));
        return;
    L21:
        MutableLiveData r15 = b(r7, r2);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.interf.AbilityChangeEvent<T of com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.AbilityManager.bindInner>>");
        r15.setValue(new yy3.a(new WeakReference(r8), new WeakReference(null), 0));
        return;
    L24:
        return;
    L5:
        r3 = null;
        goto L7
    }
}
