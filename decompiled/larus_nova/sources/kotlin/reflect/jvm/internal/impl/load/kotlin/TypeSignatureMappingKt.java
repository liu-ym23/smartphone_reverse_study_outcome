package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;

/* JADX INFO: loaded from: classes42.dex */
public final class TypeSignatureMappingKt {
    public static final <T> T boxTypeIfNeeded(JvmTypeFactory<T> r100, T r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "possiblyPrimitiveType");
        if (r102 == true) goto L5;
        return r101;
    L5:
        return r100.boxType(r101);
    }

    public static final <T> T mapBuiltInType(TypeSystemCommonBackendContext r100, KotlinTypeMarker r101, JvmTypeFactory<T> r102, TypeMappingMode r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "typeFactory");
        Intrinsics.checkNotNullParameter(r103, "mode");
        TypeConstructorMarker r104 = r100.typeConstructor(r101);
        if (r100.isClassTypeConstructor(r104) == true) goto L5;
        return null;
    L5:
        PrimitiveType r105 = r100.getPrimitiveType(r104);
        boolean r106 = true;
        if (r105 == null) goto L15;
        T r107 = r102.createPrimitiveType(r105);
        if (r100.isNullableType(r101) == true) goto L14;
        if (TypeEnhancementUtilsKt.hasEnhancedNullability(r100, r101) == true) goto L14;
        r106 = false;
    L14:
        return (T) boxTypeIfNeeded(r102, r107, r106);
    L15:
        PrimitiveType r108 = r100.getPrimitiveArrayType(r104);
        if (r108 == null) goto L20;
        return r102.createFromString("[" + JvmPrimitiveType.get(r108).getDesc());
    L20:
        if (r100.isUnderKotlinPackage(r104) == false) goto L42;
        FqNameUnsafe r109 = r100.getClassFqNameUnsafe(r104);
        if (r109 == null) goto L24;
        ClassId r110 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r109);
    L25:
        if (r110 == null) goto L42;
        if (r103.getKotlinCollectionsToJavaCollections() == true) goto L41;
        List<JavaToKotlinClassMap.PlatformMutabilityMapping> r111 = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
        if ((r111 instanceof Collection) == true) goto L31;
    L33:
        Iterator<T> r112 = r111.iterator();
    L35:
        if (r112.hasNext() == false) goto L32;
        if (Intrinsics.areEqual(((JavaToKotlinClassMap.PlatformMutabilityMapping) r112.next()).getJavaClass(), r110) == false) goto L35;
    L38:
        if (r106 == false) goto L41;
        return null;
    L32:
        r106 = false;
        goto L38
    L31:
        if (r111.isEmpty() == false) goto L33;
    L41:
        return r102.createObjectType(JvmClassName.internalNameByClassId(r110));
    L24:
        r110 = null;
    L42:
        return null;
    }
}
