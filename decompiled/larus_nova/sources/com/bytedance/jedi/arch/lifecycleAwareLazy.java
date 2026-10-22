package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelEnsuranceKt;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u00042\u00020\u0005B\u001d\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nB+\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\rJ+\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00028\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0014¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0007J\b\u0010\u001c\u001a\u00020\fH\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00028\u00008VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/bytedance/jedi/arch/lifecycleAwareLazy;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Landroidx/lifecycle/LifecycleObserver;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "initializer", "Lkotlin/Function0;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;)V", "keyFactory", "", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "_value", "", "lock", "value", "getValue$annotations", "()V", "getValue", "()Landroidx/lifecycle/ViewModel;", "ensureViewModel", "", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/ViewModel;Lkotlin/jvm/functions/Function0;)V", "isInitialized", "", WidgetCostModule.TYPE_ON_START, "toString", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class lifecycleAwareLazy<T extends ViewModel> implements Lazy<T>, Serializable, LifecycleObserver {
    private volatile Object _value;
    private Function0<? extends T> initializer;
    private final Function0<String> keyFactory;
    private final lifecycleAwareLazy<T> lock;
    private final LifecycleOwner owner;

    public static /* synthetic */ void getValue$annotations() {
    }

    @Override // kotlin.Lazy
    public T getValue() {
        Object r100 = this._value;
        UNINITIALIZED_VALUE r101 = UNINITIALIZED_VALUE.INSTANCE;
        if (r100 == r101) goto L6;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type T of com.bytedance.jedi.arch.lifecycleAwareLazy");
        return (T) r100;
    L6:
        lifecycleAwareLazy<T> r102 = this.lock;
        monitor-enter(r102);
        Object r103 = this._value;     // Catch: Throwable -> L14
        if (r103 == r101) goto L11;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type T of com.bytedance.jedi.arch.lifecycleAwareLazy._get_value_$lambda$0");     // Catch: Throwable -> L14
        T r104 = (T) r103;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);
        return r104;
    L11:
        Function0<? extends T> r105 = this.initializer;     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L14
        r104 = r105.invoke();     // Catch: Throwable -> L14
        this._value = r104;     // Catch: Throwable -> L14
        this.initializer = null;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this._value == UNINITIALIZED_VALUE.INSTANCE) goto L5;
        return true;
    L5:
        return false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onStart() {
        if (isInitialized() == true) goto L6;
        getValue();
    L6:
        if (this.keyFactory != null) goto L8;
        this.owner.getLifecycle().removeObserver(this);
        return;
    L8:
        ensureViewModel(this.owner, getValue(), this.keyFactory);
    }

    public String toString() {
        if (isInitialized() == true) goto L7;
        return "Lazy value not initialized yet.";
    L7:
        return getValue().toString();
    }

    @Override // kotlin.Lazy
    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    public lifecycleAwareLazy(LifecycleOwner r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "initializer");
        this(r100, null, r101);
    }

    public lifecycleAwareLazy(LifecycleOwner r100, Function0<String> r101, Function0<? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r102, "initializer");
        this.owner = r100;
        this.keyFactory = r101;
        this.initializer = r102;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
        this.lock = this;
        r100.getLifecycle().addObserver(this);
    }

    public void ensureViewModel(LifecycleOwner r100, T r101, Function0<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "keyFactory");
        ViewModelEnsuranceKt.ensureViewModel((Fragment) r100, r101, r102);
    }
}
