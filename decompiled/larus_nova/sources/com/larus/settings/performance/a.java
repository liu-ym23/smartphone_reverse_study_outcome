package com.larus.settings.performance;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes31.dex */
public final class a<T> implements ReadWriteProperty<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<T> f368548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f368549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f368550c;

    /* JADX INFO: renamed from: com.larus.settings.performance.a$a, reason: collision with other inner class name */
    public static final class C4489a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4489a f368551a = null;

        static {
            f368551a = new C4489a();
        }

        public C4489a() {
        }
    }

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "initializer");
        this.f368548a = r100;
        this.f368549b = new Object();
        this.f368550c = C4489a.f368551a;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public final T getValue(Object r100, KProperty<?> r101) {
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Object r102 = this.f368549b;
        monitor-enter(r102);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f368550c != C4489a.f368551a) goto L7;
        this.f368550c = this.f368548a.invoke();     // Catch: Throwable -> L10
    L7:
        T r103 = (T) this.f368550c;
        monitor-exit(r102);
        return r103;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(Object r100, KProperty<?> r101, T r102) {
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Object r103 = this.f368549b;
        monitor-enter(r103);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f368550c != C4489a.f368551a) goto L8;
        monitor-exit(r103);
        return;
    L8:
        this.f368550c = r102;     // Catch: Throwable -> L11
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r103);
    }
}
