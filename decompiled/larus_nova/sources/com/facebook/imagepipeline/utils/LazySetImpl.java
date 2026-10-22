package com.facebook.imagepipeline.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/facebook/imagepipeline/utils/LazySetImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/imagepipeline/utils/LazySet;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "isInitialized", "", "toString", "", "imagepipeline_noasanRelease"}, k = 1, mv = {1, 1, 16})
final class LazySetImpl<T> implements LazySet<T> {
    private volatile Object _value;
    private Function0<? extends T> initializer;
    private final Object lock;

    @Override // com.facebook.imagepipeline.utils.LazySet
    public T getValue() {
        T r100 = (T) this._value;
        UNINITIALIZED_VALUE r101 = UNINITIALIZED_VALUE.INSTANCE;
        if (r100 == r101) goto L5;
        return r100;
    L5:
        Object r102 = this.lock;
        monitor-enter(r102);
        T r103 = (T) this._value;
        if (r103 != r101) goto L14;
        Function0<? extends T> r104 = this.initializer;     // Catch: Throwable -> L16
        if (r104 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L16
    L13:
        r103 = r104.invoke();     // Catch: Throwable -> L16
        this._value = r103;     // Catch: Throwable -> L16
        this.initializer = null;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r102);
        return r103;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.utils.LazySet
    public boolean isInitialized() {
        if (this._value == UNINITIALIZED_VALUE.INSTANCE) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (isInitialized() == true) goto L7;
        return "Lazy value not initialized yet.";
    L7:
        return String.valueOf(getValue());
    }

    @Override // com.facebook.imagepipeline.utils.LazySet
    public void setValue(T r100) {
        if (Intrinsics.areEqual(this._value, UNINITIALIZED_VALUE.INSTANCE) == false) goto L12;
        Object r101 = this.lock;
        monitor-enter(r101);
        this._value = r100;     // Catch: Throwable -> L9
        this.initializer = null;     // Catch: Throwable -> L9
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r101);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        this._value = r100;
    }

    public LazySetImpl(Function0<? extends T> r100, Object r101) {
        this.initializer = r100;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
        if (r101 != null) goto L6;
        r101 = this;
    L6:
        this.lock = r101;
    }

    public /* synthetic */ LazySetImpl(Function0 r100, Object r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
