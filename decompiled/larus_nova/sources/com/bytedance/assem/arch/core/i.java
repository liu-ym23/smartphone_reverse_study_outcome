package com.bytedance.assem.arch.core;

import androidx.lifecycle.LifecycleOwner;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes14.dex */
public class i<T> implements ReadWriteProperty<Object, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f192896b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f192897a;

    public static final class a {
    }

    static {
    }

    public i() {
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public final T getValue(Object r100, KProperty<?> r101) {
        T r102 = this.f192897a;
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new IllegalStateException("Property " + r101.getName() + " should be initialized before get.");
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(Object r100, KProperty<?> r101, T r102) {
        T r103 = this.f192897a;
        this.f192897a = r102;
        LifecycleOwner r104 = (LifecycleOwner) r102;
        LifecycleOwner r105 = (LifecycleOwner) r103;
        ((Assem.a) this).f192858c.getClass();
    }
}
