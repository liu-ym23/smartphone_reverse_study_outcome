package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ConstantValue<T> {
    private final T value;

    public abstract KotlinType getType(ModuleDescriptor r100);

    public int hashCode() {
        T r100 = getValue();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return String.valueOf(getValue());
    }

    public T getValue() {
        return this.value;
    }

    public ConstantValue(T r100) {
        this.value = r100;
    }

    public boolean equals(Object r100) {
        if (this == r100) goto L13;
        T r101 = getValue();
        Object r102 = null;
        if ((r100 instanceof ConstantValue) == false) goto L6;
        ConstantValue r103 = (ConstantValue) r100;
    L7:
        if (r103 == null) goto L10;
        r102 = r103.getValue();
    L10:
        if (Intrinsics.areEqual(r101, r102) == true) goto L13;
        return false;
    L6:
        r103 = null;
    L13:
        return true;
    }
}
