package kc1;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements ReadOnlyProperty<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f502378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<T> f502379b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "getValue");
        this.f502379b = r100;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final T getValue(Object r100, KProperty<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        if (this.f502378a != null) goto L6;
        this.f502378a = this.f502379b.invoke();
    L6:
        return this.f502378a;
    }
}
