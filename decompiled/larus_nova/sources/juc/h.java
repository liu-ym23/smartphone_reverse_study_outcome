package juc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.InternalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
public final class h {
    @InternalSerializationApi
    public static final <T> c<T> a(nuc.b<T> r100, muc.c r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "decoder");
        c<T> r103 = r100.a(r101, r102);
        if (r103 == null) goto L5;
        return r103;
    L5:
        nuc.c.a(r102, r100.c());
        throw null;
    }

    @InternalSerializationApi
    public static final <T> n<T> b(nuc.b<T> r100, muc.f r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        n<T> r103 = r100.b(r101, r102);
        if (r103 != null) goto L9;
        KClass r104 = Reflection.getOrCreateKotlinClass(r102.getClass());
        KClass<T> r105 = r100.c();
        Intrinsics.checkNotNullParameter(r104, "subClass");
        Intrinsics.checkNotNullParameter(r105, "baseClass");
        String r106 = r104.getSimpleName();
        if (r106 != null) goto L7;
        r106 = String.valueOf(r104);
    L7:
        nuc.c.a(r106, r105);
        throw null;
    L9:
        return r103;
    }
}
