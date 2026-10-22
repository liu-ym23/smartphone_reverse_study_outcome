package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: loaded from: classes42.dex */
public final class TypeEnhancementUtilsKt {
    private static final NullabilityQualifier getNullabilityForErrors(JavaTypeQualifiers r100) {
        if (r100.isNullabilityQualifierForWarning() == false) goto L6;
        return null;
    L6:
        return r100.getNullability();
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext r100, KotlinTypeMarker r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "type");
        return r100.hasAnnotation(r101, JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION);
    }

    private static final NullabilityQualifier select(Set<? extends NullabilityQualifier> r100, NullabilityQualifier r101, boolean r102) {
        NullabilityQualifier r103 = NullabilityQualifier.FORCE_FLEXIBILITY;
        if (r101 != r103) goto L6;
        return r103;
    L6:
        return (NullabilityQualifier) select(r100, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, r101, r102);
    }

    public static final JavaTypeQualifiers computeQualifiersForOverride(JavaTypeQualifiers r100, Collection<JavaTypeQualifiers> r101, boolean r102, boolean r103, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "superQualifiers");
        Collection<JavaTypeQualifiers> r104 = r101;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L8;
        NullabilityQualifier r107 = getNullabilityForErrors((JavaTypeQualifiers) r106.next());
        if (r107 == null) goto L4;
        r105.add(r107);
        goto L4
    L8:
        NullabilityQualifier r108 = select(CollectionsKt.toSet(r105), getNullabilityForErrors(r100), r102);
        if (r108 != null) goto L17;
        ArrayList r109 = new ArrayList();
        Iterator<T> r111 = r104.iterator();
    L12:
        if (r111.hasNext() == false) goto L16;
        NullabilityQualifier r112 = ((JavaTypeQualifiers) r111.next()).getNullability();
        if (r112 == null) goto L12;
        r109.add(r112);
        goto L12
    L16:
        NullabilityQualifier r113 = select(CollectionsKt.toSet(r109), r100.getNullability(), r102);
    L18:
        ArrayList r114 = new ArrayList();
        Iterator<T> r115 = r104.iterator();
    L20:
        if (r115.hasNext() == false) goto L24;
        MutabilityQualifier r116 = ((JavaTypeQualifiers) r115.next()).getMutability();
        if (r116 == null) goto L20;
        r114.add(r116);
        goto L20
    L24:
        MutabilityQualifier r117 = (MutabilityQualifier) select(CollectionsKt.toSet(r114), MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, r100.getMutability(), r102);
        NullabilityQualifier r118 = null;
        boolean r119 = true;
        if (r113 == null) goto L36;
        if (r110 == true) goto L32;
        if (r103 == true) goto L29;
    L31:
        boolean r120 = false;
    L33:
        if (r120 == true) goto L36;
        r118 = r113;
        goto L36
    L29:
        if (r113 != NullabilityQualifier.NULLABLE) goto L31;
    L32:
        r120 = true;
    L36:
        if (r118 == NullabilityQualifier.NOT_NULL) goto L38;
    L50:
        boolean r121 = false;
    L51:
        if (r118 == null) goto L54;
        if (r108 == r113) goto L54;
    L56:
        return new JavaTypeQualifiers(r118, r117, r121, r119);
    L54:
        r119 = false;
        goto L56
    L38:
        if (r100.getDefinitelyNotNull() == false) goto L40;
    L49:
        r121 = true;
        goto L51
    L40:
        if (r104.isEmpty() == false) goto L42;
    L41:
        boolean r122 = false;
    L48:
        if (r122 == false) goto L50;
    L42:
        Iterator<T> r123 = r104.iterator();
    L44:
        if (r123.hasNext() == false) goto L41;
        if (((JavaTypeQualifiers) r123.next()).getDefinitelyNotNull() == false) goto L44;
        r122 = true;
        goto L48
    L17:
        r113 = r108;
        goto L18
    }

    private static final <T> T select(Set<? extends T> r100, T r101, T r102, T r103, boolean r104) {
        if (r104 == true) goto L4;
        if (r103 == null) goto L24;
        Set<? extends T> r105 = CollectionsKt.toSet(SetsKt.plus(r100, r103));
        if (r105 == null) goto L24;
        r100 = r105;
    L24:
        return (T) CollectionsKt.singleOrNull(r100);
    L4:
        if (r100.contains(r101) == false) goto L7;
        T r106 = r101;
    L11:
        if (Intrinsics.areEqual(r106, r101) == true) goto L13;
    L15:
        if (r103 == null) goto L17;
        return r103;
    L17:
        return r106;
    L13:
        if (Intrinsics.areEqual(r103, r102) == false) goto L15;
        return null;
    L7:
        if (r100.contains(r102) == false) goto L9;
        r106 = r102;
        goto L11
    L9:
        r106 = null;
        goto L11
    }
}
