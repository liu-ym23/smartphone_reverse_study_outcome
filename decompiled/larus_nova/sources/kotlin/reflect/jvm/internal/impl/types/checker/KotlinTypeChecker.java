package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes5.dex */
public interface KotlinTypeChecker {
    public static final KotlinTypeChecker DEFAULT = null;

    public interface TypeConstructorEquality {
        boolean equals(TypeConstructor r100, TypeConstructor r101);
    }

    boolean equalTypes(KotlinType r100, KotlinType r101);

    boolean isSubtypeOf(KotlinType r100, KotlinType r101);

    static {
        DEFAULT = NewKotlinTypeChecker.Companion.getDefault();
    }
}
