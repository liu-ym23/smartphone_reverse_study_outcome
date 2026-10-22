package com.bytedance.awemeopen.apps.framework.comment.write.arch.ability;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import yy3.b;

/* JADX INFO: loaded from: classes14.dex */
public final class AbilityManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends b>, Map<String, a<? extends b>>> f194383a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends b>, Map<String, MutableLiveData<yy3.a<? extends b>>>> f194384b = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/write/arch/ability/AbilityManager$LifecycleObserverWrapper;", "Lyy3/b;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class LifecycleObserverWrapper<T extends b> implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f194385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f194386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f194387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LifecycleOwner f194388d;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            ConcurrentHashMap<Class<? extends b>, Map<String, a<? extends b>>> r100 = AbilityManager.f194383a;
            Class<T> r101 = this.f194385a;
            String r102 = this.f194387c;
            Intrinsics.checkNotNullParameter(r101, "clazz");
            Intrinsics.checkNotNullParameter(r102, "key");
            ConcurrentHashMap<Class<? extends b>, Map<String, a<? extends b>>> r103 = AbilityManager.f194383a;
            Map<String, a<? extends b>> r104 = r103.get(r101);
            if (r104 == null) goto L14;
            a<? extends b> r105 = r104.get(r102);
            if (r105 == null) goto L15;
            LifecycleObserverWrapper<T> r106 = r105.f194390b;
            if (r106 == null) goto L9;
            r106.f194388d.getLifecycle().removeObserver(r106);
        L9:
            Map<String, a<? extends b>> r107 = r103.get(r101);
            if (r107 == null) goto L12;
            a<? extends b> r108 = r107.remove(r102);
        L12:
            LiveData r109 = AbilityManager.b(r101, r102);
            Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.interf.AbilityChangeEvent<T of com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.AbilityManager.unbind$lambda$10>>");
            ((MutableLiveData) r109).setValue(new yy3.a(new WeakReference(r105.f194389a), new WeakReference(null), 1));
            return;
        L15:
            return;
        }

        public LifecycleObserverWrapper(Class<T> r100, T r101, String r102, LifecycleOwner r103) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            Intrinsics.checkNotNullParameter(r101, "ability");
            Intrinsics.checkNotNullParameter(r102, "key");
            Intrinsics.checkNotNullParameter(r103, "owner");
            this.f194385a = r100;
            this.f194386b = r101;
            this.f194387c = r102;
            this.f194388d = r103;
        }
    }

    public static final class a<T extends b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f194389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LifecycleObserverWrapper<T> f194390b;

        public a(T r100, LifecycleObserverWrapper<T> r101) {
            Intrinsics.checkNotNullParameter(r100, "ability");
            this.f194389a = r100;
            this.f194390b = r101;
        }
    }

    static {
        f194383a = new ConcurrentHashMap();
        f194384b = new ConcurrentHashMap();
    }

    public static LiveData b(Class r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "key");
        ConcurrentHashMap<Class<? extends b>, Map<String, MutableLiveData<yy3.a<? extends b>>>> r102 = f194384b;
        if (r102.get(r100) != null) goto L5;
        r102.put(r100, new LinkedHashMap());
    L5:
        Map<String, MutableLiveData<yy3.a<? extends b>>> r103 = r102.get(r100);
        Intrinsics.checkNotNull(r103);
        if (r103.get(r101) != null) goto L8;
        Map<String, MutableLiveData<yy3.a<? extends b>>> r104 = r102.get(r100);
        Intrinsics.checkNotNull(r104);
        r104.put(r101, new MutableLiveData());
    L8:
        Map<String, MutableLiveData<yy3.a<? extends b>>> r105 = r102.get(r100);
        Intrinsics.checkNotNull(r105);
        MutableLiveData<yy3.a<? extends b>> r106 = r105.get(r101);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.interf.AbilityChangeEvent<T of com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.AbilityManager.getLiveData>>");
        return r106;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, androidx.lifecycle.LifecycleObserver, com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.AbilityManager$LifecycleObserverWrapper] */
    public static void a(Class r100, b r101, LifecycleOwner r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "ability");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "<this>");
        String r103 = String.valueOf(r102.hashCode());
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "ability");
        Intrinsics.checkNotNullParameter(r103, "key");
        Boolean r104 = Boolean.TRUE;
        Lifecycle r105 = r102.getLifecycle();
        if (r105 == null) goto L5;
        Lifecycle.State r106 = r105.getCurrentState();
    L7:
        if (r106 == Lifecycle.State.DESTROYED) goto L24;
        ConcurrentHashMap<Class<? extends b>, Map<String, a<? extends b>>> r107 = f194383a;
        if (r107.get(r100) != null) goto L12;
        r107.put(r100, new LinkedHashMap());
    L12:
        Map<String, a<? extends b>> r108 = r107.get(r100);
        Intrinsics.checkNotNull(r108);
        a<? extends b> r109 = r108.get(r103);
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        ?? r111 = new LifecycleObserverWrapper(r100, r101, r103, r102);
        if (Intrinsics.areEqual(r104, r104) == false) goto L15;
        r102.getLifecycle().addObserver(r111);
    L15:
        r110.element = r111;
        Map<String, a<? extends b>> r112 = r107.get(r100);
        Intrinsics.checkNotNull(r112);
        r112.put(r103, new a(r101, (LifecycleObserverWrapper) r110.element));
        if (r109 == null) goto L21;
        LifecycleObserverWrapper<T> r113 = r109.f194390b;
        if (r113 == 0) goto L20;
        r113.f194388d.getLifecycle().removeObserver(r113);
    L20:
        LiveData r114 = b(r100, r103);
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.interf.AbilityChangeEvent<T of com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.AbilityManager.bindInner>>");
        ((MutableLiveData) r114).setValue(new yy3.a(new WeakReference(r101), new WeakReference(r109.f194389a), 2));
        return;
    L21:
        LiveData r115 = b(r100, r103);
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.interf.AbilityChangeEvent<T of com.bytedance.awemeopen.apps.framework.comment.write.arch.ability.AbilityManager.bindInner>>");
        ((MutableLiveData) r115).setValue(new yy3.a(new WeakReference(r101), new WeakReference(null), 0));
        return;
    L24:
        return;
    L5:
        r106 = null;
        goto L7
    }
}
