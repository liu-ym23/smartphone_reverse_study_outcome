package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes42.dex */
public final class JvmAnnotationNamesKt {
    private static final FqName ANDROIDX_RECENTLY_NON_NULL_ANNOTATION = null;
    private static final FqName ANDROIDX_RECENTLY_NULLABLE_ANNOTATION = null;
    private static final FqName COMPATQUAL_NONNULL_ANNOTATION = null;
    private static final FqName COMPATQUAL_NULLABLE_ANNOTATION = null;
    private static final FqName JAVAX_CHECKFORNULL_ANNOTATION = null;
    private static final FqName JAVAX_NONNULL_ANNOTATION = null;
    private static final FqName JSPECIFY_NON_NULL = null;
    private static final FqName JSPECIFY_NULLABLE = null;
    private static final FqName JSPECIFY_NULLNESS_UNKNOWN = null;
    private static final FqName JSPECIFY_NULL_MARKED = null;
    private static final FqName JSPECIFY_OLD_NULLABLE = null;
    private static final FqName JSPECIFY_OLD_NULLNESS_UNKNOWN = null;
    private static final FqName JSPECIFY_OLD_NULL_MARKED = null;
    private static final Set<FqName> MUTABLE_ANNOTATIONS = null;
    private static final List<FqName> NOT_NULL_ANNOTATIONS = null;
    private static final Set<FqName> NULLABILITY_ANNOTATIONS = null;
    private static final List<FqName> NULLABLE_ANNOTATIONS = null;
    private static final Set<FqName> READ_ONLY_ANNOTATIONS = null;
    private static final Map<FqName, FqName> javaToKotlinNameMap = null;

    static {
        FqName r100 = new FqName("org.jspecify.nullness.Nullable");
        JSPECIFY_OLD_NULLABLE = r100;
        JSPECIFY_OLD_NULLNESS_UNKNOWN = new FqName("org.jspecify.nullness.NullnessUnspecified");
        FqName r101 = new FqName("org.jspecify.nullness.NullMarked");
        JSPECIFY_OLD_NULL_MARKED = r101;
        FqName r102 = new FqName("org.jspecify.annotations.Nullable");
        JSPECIFY_NULLABLE = r102;
        JSPECIFY_NULLNESS_UNKNOWN = new FqName("org.jspecify.annotations.NullnessUnspecified");
        FqName r103 = new FqName("org.jspecify.annotations.NullMarked");
        JSPECIFY_NULL_MARKED = r103;
        JSPECIFY_NON_NULL = new FqName("org.jspecify.annotations.NonNull");
        List<FqName> r104 = CollectionsKt.listOf(new FqName[]{JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, new FqName("androidx.annotation.Nullable"), new FqName("androidx.annotation.Nullable"), new FqName("android.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("javax.annotation.Nullable"), new FqName("javax.annotation.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("io.reactivex.annotations.Nullable"), new FqName("io.reactivex.rxjava3.annotations.Nullable")});
        NULLABLE_ANNOTATIONS = r104;
        FqName r105 = new FqName("javax.annotation.Nonnull");
        JAVAX_NONNULL_ANNOTATION = r105;
        JAVAX_CHECKFORNULL_ANNOTATION = new FqName("javax.annotation.CheckForNull");
        List<FqName> r110 = CollectionsKt.listOf(new FqName[]{JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("android.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("lombok.NonNull"), new FqName("io.reactivex.annotations.NonNull"), new FqName("io.reactivex.rxjava3.annotations.NonNull")});
        NOT_NULL_ANNOTATIONS = r110;
        FqName r111 = new FqName("org.checkerframework.checker.nullness.compatqual.NullableDecl");
        COMPATQUAL_NULLABLE_ANNOTATION = r111;
        FqName r112 = new FqName("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
        COMPATQUAL_NONNULL_ANNOTATION = r112;
        FqName r113 = new FqName("androidx.annotation.RecentlyNullable");
        ANDROIDX_RECENTLY_NULLABLE_ANNOTATION = r113;
        FqName r114 = new FqName("androidx.annotation.RecentlyNonNull");
        ANDROIDX_RECENTLY_NON_NULL_ANNOTATION = r114;
        NULLABILITY_ANNOTATIONS = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(new LinkedHashSet(), r104), r105), r110), r111), r112), r113), r114), r100), r101), r102), r103);
        READ_ONLY_ANNOTATIONS = SetsKt.setOf(new FqName[]{JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION, JvmAnnotationNames.READONLY_ANNOTATION});
        MUTABLE_ANNOTATIONS = SetsKt.setOf(new FqName[]{JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION, JvmAnnotationNames.MUTABLE_ANNOTATION});
        javaToKotlinNameMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(JvmAnnotationNames.TARGET_ANNOTATION, StandardNames.FqNames.target), TuplesKt.to(JvmAnnotationNames.RETENTION_ANNOTATION, StandardNames.FqNames.retention), TuplesKt.to(JvmAnnotationNames.DEPRECATED_ANNOTATION, StandardNames.FqNames.deprecated), TuplesKt.to(JvmAnnotationNames.DOCUMENTED_ANNOTATION, StandardNames.FqNames.mustBeDocumented)});
    }

    public static final FqName getANDROIDX_RECENTLY_NON_NULL_ANNOTATION() {
        return ANDROIDX_RECENTLY_NON_NULL_ANNOTATION;
    }

    public static final FqName getANDROIDX_RECENTLY_NULLABLE_ANNOTATION() {
        return ANDROIDX_RECENTLY_NULLABLE_ANNOTATION;
    }

    public static final FqName getCOMPATQUAL_NONNULL_ANNOTATION() {
        return COMPATQUAL_NONNULL_ANNOTATION;
    }

    public static final FqName getCOMPATQUAL_NULLABLE_ANNOTATION() {
        return COMPATQUAL_NULLABLE_ANNOTATION;
    }

    public static final FqName getJAVAX_CHECKFORNULL_ANNOTATION() {
        return JAVAX_CHECKFORNULL_ANNOTATION;
    }

    public static final FqName getJAVAX_NONNULL_ANNOTATION() {
        return JAVAX_NONNULL_ANNOTATION;
    }

    public static final FqName getJSPECIFY_NON_NULL() {
        return JSPECIFY_NON_NULL;
    }

    public static final FqName getJSPECIFY_NULLABLE() {
        return JSPECIFY_NULLABLE;
    }

    public static final FqName getJSPECIFY_NULLNESS_UNKNOWN() {
        return JSPECIFY_NULLNESS_UNKNOWN;
    }

    public static final FqName getJSPECIFY_NULL_MARKED() {
        return JSPECIFY_NULL_MARKED;
    }

    public static final FqName getJSPECIFY_OLD_NULLABLE() {
        return JSPECIFY_OLD_NULLABLE;
    }

    public static final FqName getJSPECIFY_OLD_NULLNESS_UNKNOWN() {
        return JSPECIFY_OLD_NULLNESS_UNKNOWN;
    }

    public static final FqName getJSPECIFY_OLD_NULL_MARKED() {
        return JSPECIFY_OLD_NULL_MARKED;
    }

    public static final Set<FqName> getMUTABLE_ANNOTATIONS() {
        return MUTABLE_ANNOTATIONS;
    }

    public static final List<FqName> getNOT_NULL_ANNOTATIONS() {
        return NOT_NULL_ANNOTATIONS;
    }

    public static final List<FqName> getNULLABLE_ANNOTATIONS() {
        return NULLABLE_ANNOTATIONS;
    }

    public static final Set<FqName> getREAD_ONLY_ANNOTATIONS() {
        return READ_ONLY_ANNOTATIONS;
    }
}
