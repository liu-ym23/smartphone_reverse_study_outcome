package luc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import nuc.m2;
import nuc.n2;

/* JADX INFO: loaded from: classes5.dex */
public final class n {
    public static final m2 a(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r101, "kind");
        if ((!StringsKt.isBlank(r100)) == false) goto L17;
        Map<KClass<? extends Object>, juc.d<? extends Object>> r102 = n2.f520740a;
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r101, "kind");
        Iterator<KClass<? extends Object>> r103 = n2.f520740a.keySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L15;
        String r104 = r103.next().getSimpleName();
        Intrinsics.checkNotNull(r104);
        String r105 = n2.a(r104);
        if (StringsKt.equals(r100, "kotlin." + r105, true) == true) goto L13;
        if (StringsKt.equals(r100, r105, true) == false) goto L6;
    L13:
        throw new IllegalArgumentException(StringsKt.trimIndent("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + r100 + " there already exist " + n2.a(r105) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
    L15:
        return new m2(r100, r101);
    L17:
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    @ExperimentalSerializationApi
    public static final q b(String r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r101, "original");
        if ((!StringsKt.isBlank(r100)) == false) goto L15;
        if ((!(r101.getKind() instanceof e)) == false) goto L13;
        if ((!Intrinsics.areEqual(r100, r101.f())) == false) goto L11;
        return new q(r100, r101);
    L11:
        throw new IllegalArgumentException(("The name of the wrapped descriptor (" + r100 + ") cannot be the same as the name of the original descriptor (" + r101.f() + ')').toString());
    L13:
        throw new IllegalArgumentException("For primitive descriptors please use 'PrimitiveSerialDescriptor' instead".toString());
    L15:
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static /* synthetic */ i d(String r100, f[] r101) {
        return c(r100, r101, new m());
    }

    public static final i c(String r100, f[] r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r101, "typeParameters");
        Intrinsics.checkNotNullParameter(r102, "builderAction");
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        a r103 = new a(r100);
        r102.invoke(r103);
        return new i(r100, p.a.f510877a, ((ArrayList) r103.f510839c).size(), ArraysKt.toList(r101), r103);
    L7:
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static /* synthetic */ i f(String r100, o r101, f[] r102) {
        return e(r100, r101, r102, new l());
    }

    @InternalSerializationApi
    public static final i e(String r100, o r101, f[] r102, Function1 r110) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r101, "kind");
        Intrinsics.checkNotNullParameter(r102, "typeParameters");
        Intrinsics.checkNotNullParameter(r110, "builder");
        if ((!StringsKt.isBlank(r100)) == false) goto L11;
        if ((!Intrinsics.areEqual(r101, p.a.f510877a)) == false) goto L9;
        a r103 = new a(r100);
        r110.invoke(r103);
        return new i(r100, r101, ((ArrayList) r103.f510839c).size(), ArraysKt.toList(r102), r103);
    L9:
        throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
    L11:
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }
}
