package com.skydoves.balloon.internals;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes34.dex */
public final class b<T> implements ReadWriteProperty<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f406154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f406155b;

    public b(T r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "invalidator");
        this.f406154a = r101;
        this.f406155b = r100;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public final T getValue(Object r100, KProperty<?> r101) {
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return this.f406155b;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(Object r100, KProperty<?> r101, T r102) {
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        if (Intrinsics.areEqual(this.f406155b, r102) == true) goto L6;
        this.f406155b = r102;
        this.f406154a.invoke();
        return;
    }
}
