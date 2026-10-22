package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public final class StorageKt {
    public static final <T> T getValue(NotNullLazyValue<? extends T> r100, Object r101, KProperty<?> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "p");
        return r100.invoke();
    }

    public static final <T> T getValue(NullableLazyValue<? extends T> r100, Object r101, KProperty<?> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "p");
        return r100.invoke();
    }
}
