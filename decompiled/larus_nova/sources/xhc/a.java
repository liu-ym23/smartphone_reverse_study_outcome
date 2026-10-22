package xhc;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
public final class a<T> implements ReadWriteProperty<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<? extends T> f563916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f563917b;

    public a(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "initializer");
        this.f563916a = r100;
        this.f563917b = b.f563918a;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public final T getValue(Object r100, KProperty<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        T r102 = (T) this.f563917b;
        b r103 = b.f563918a;
        if (r102 == r103) goto L5;
        return r102;
    L5:
        monitor-enter(this);
        T r104 = (T) this.f563917b;
        if (r104 != r103) goto L10;
        Function0<? extends T> r105 = this.f563916a;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L12
        r104 = r105.invoke();     // Catch: Throwable -> L12
        this.f563917b = r104;     // Catch: Throwable -> L12
        this.f563916a = null;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r104;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(Object r100, KProperty<?> r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f563917b = r102;
    }
}
