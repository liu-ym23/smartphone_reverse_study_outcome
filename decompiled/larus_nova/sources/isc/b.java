package isc;

import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes41.dex */
public final class b {
    public static final a a(Type r100, KClass<?> r101, KType r102) {
        Intrinsics.checkNotNullParameter(r100, "reifiedType");
        Intrinsics.checkNotNullParameter(r101, "kClass");
        return new a(r101, r100, r102);
    }
}
