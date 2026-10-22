package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: loaded from: classes42.dex */
public final class ClassicTypeSystemContextKt {
    public static final /* synthetic */ UnwrappedType access$makeDefinitelyNotNullOrNotNullInternal(UnwrappedType r100) {
        return makeDefinitelyNotNullOrNotNullInternal(r100);
    }

    private static final UnwrappedType makeDefinitelyNotNullOrNotNullInternal(UnwrappedType r100) {
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull$default(r100, false, 1, null);
    }
}
