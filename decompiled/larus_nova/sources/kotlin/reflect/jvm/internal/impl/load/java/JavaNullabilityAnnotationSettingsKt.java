package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public final class JavaNullabilityAnnotationSettingsKt {
    private static final FqName CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE = null;
    private static final FqName JSPECIFY_ANNOTATIONS_PACKAGE = null;
    private static final FqName JSPECIFY_OLD_ANNOTATIONS_PACKAGE = null;
    private static final JavaNullabilityAnnotationsStatus JSR_305_DEFAULT_SETTINGS = null;
    private static final NullabilityAnnotationStates<JavaNullabilityAnnotationsStatus> NULLABILITY_ANNOTATION_SETTINGS = null;
    private static final FqName[] RXJAVA3_ANNOTATIONS = null;
    private static final FqName RXJAVA3_ANNOTATIONS_PACKAGE = null;
    private static final String RXJAVA3_ANNOTATIONS_PACKAGE_NAME = null;

    static {
        FqName r100 = new FqName("org.jspecify.nullness");
        JSPECIFY_OLD_ANNOTATIONS_PACKAGE = r100;
        FqName r101 = new FqName("org.jspecify.annotations");
        JSPECIFY_ANNOTATIONS_PACKAGE = r101;
        FqName r102 = new FqName("io.reactivex.rxjava3.annotations");
        RXJAVA3_ANNOTATIONS_PACKAGE = r102;
        FqName r103 = new FqName("org.checkerframework.checker.nullness.compatqual");
        CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE = r103;
        String r104 = r102.asString();
        RXJAVA3_ANNOTATIONS_PACKAGE_NAME = r104;
        RXJAVA3_ANNOTATIONS = new FqName[]{new FqName(r104 + ".Nullable"), new FqName(r104 + ".NonNull")};
        FqName r105 = new FqName("org.jetbrains.annotations");
        JavaNullabilityAnnotationsStatus.Companion r110 = JavaNullabilityAnnotationsStatus.Companion;
        FqName r106 = new FqName("androidx.annotation.RecentlyNullable");
        ReportLevel r111 = ReportLevel.WARN;
        KotlinVersion r107 = new KotlinVersion(2, 1);
        ReportLevel r112 = ReportLevel.STRICT;
        NULLABILITY_ANNOTATION_SETTINGS = new NullabilityAnnotationStatesImpl(MapsKt.mapOf(new Pair[]{TuplesKt.to(r105, r110.getDEFAULT()), TuplesKt.to(new FqName("androidx.annotation"), r110.getDEFAULT()), TuplesKt.to(new FqName("android.support.annotation"), r110.getDEFAULT()), TuplesKt.to(new FqName("android.annotation"), r110.getDEFAULT()), TuplesKt.to(new FqName("com.android.annotations"), r110.getDEFAULT()), TuplesKt.to(new FqName("org.eclipse.jdt.annotation"), r110.getDEFAULT()), TuplesKt.to(new FqName("org.checkerframework.checker.nullness.qual"), r110.getDEFAULT()), TuplesKt.to(r103, r110.getDEFAULT()), TuplesKt.to(new FqName("javax.annotation"), r110.getDEFAULT()), TuplesKt.to(new FqName("edu.umd.cs.findbugs.annotations"), r110.getDEFAULT()), TuplesKt.to(new FqName("io.reactivex.annotations"), r110.getDEFAULT()), TuplesKt.to(r106, new JavaNullabilityAnnotationsStatus(r111, null, null, 4, null)), TuplesKt.to(new FqName("androidx.annotation.RecentlyNonNull"), new JavaNullabilityAnnotationsStatus(r111, null, null, 4, null)), TuplesKt.to(new FqName("lombok"), r110.getDEFAULT()), TuplesKt.to(r100, new JavaNullabilityAnnotationsStatus(r111, r107, r112)), TuplesKt.to(r101, new JavaNullabilityAnnotationsStatus(r111, new KotlinVersion(2, 1), r112)), TuplesKt.to(r102, new JavaNullabilityAnnotationsStatus(r111, new KotlinVersion(1, 8), r112))}));
        JSR_305_DEFAULT_SETTINGS = new JavaNullabilityAnnotationsStatus(r111, null, null, 4, null);
    }

    public static final FqName getJSPECIFY_ANNOTATIONS_PACKAGE() {
        return JSPECIFY_ANNOTATIONS_PACKAGE;
    }

    public static final FqName[] getRXJAVA3_ANNOTATIONS() {
        return RXJAVA3_ANNOTATIONS;
    }

    public static final Jsr305Settings getDefaultJsr305Settings(KotlinVersion r100) {
        Intrinsics.checkNotNullParameter(r100, "configuredKotlinVersion");
        JavaNullabilityAnnotationsStatus r101 = JSR_305_DEFAULT_SETTINGS;
        if (r101.getSinceVersion() != null) goto L5;
    L7:
        ReportLevel r102 = r101.getReportLevelBefore();
    L8:
        ReportLevel r103 = r102;
        return new Jsr305Settings(r103, getDefaultMigrationJsr305ReportLevelForGivenGlobal(r103), null, 4, null);
    L5:
        if (r101.getSinceVersion().compareTo2(r100) > 0) goto L7;
        r102 = r101.getReportLevelAfter();
        goto L8
    }

    public static final ReportLevel getDefaultMigrationJsr305ReportLevelForGivenGlobal(ReportLevel r100) {
        Intrinsics.checkNotNullParameter(r100, "globalReportLevel");
        if (r100 != ReportLevel.WARN) goto L6;
        return null;
    L6:
        return r100;
    }

    public static final ReportLevel getDefaultReportLevelForAnnotation(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "annotationFqName");
        return getReportLevelForAnnotation$default(r100, NullabilityAnnotationStates.Companion.getEMPTY(), null, 4, null);
    }

    public static /* synthetic */ Jsr305Settings getDefaultJsr305Settings$default(KotlinVersion r100, int r101, Object r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = KotlinVersion.CURRENT;
    L6:
        return getDefaultJsr305Settings(r100);
    }

    public static final ReportLevel getReportLevelForAnnotation(FqName r100, NullabilityAnnotationStates<? extends ReportLevel> r101, KotlinVersion r102) {
        Intrinsics.checkNotNullParameter(r100, "annotation");
        Intrinsics.checkNotNullParameter(r101, "configuredReportLevels");
        Intrinsics.checkNotNullParameter(r102, "configuredKotlinVersion");
        ReportLevel r103 = r101.get(r100);
        if (r103 == null) goto L5;
        return r103;
    L5:
        JavaNullabilityAnnotationsStatus r104 = NULLABILITY_ANNOTATION_SETTINGS.get(r100);
        if (r104 != null) goto L10;
        return ReportLevel.IGNORE;
    L10:
        if (r104.getSinceVersion() == null) goto L15;
        if (r104.getSinceVersion().compareTo2(r102) > 0) goto L15;
        return r104.getReportLevelAfter();
    L15:
        return r104.getReportLevelBefore();
    }

    public static /* synthetic */ ReportLevel getReportLevelForAnnotation$default(FqName r100, NullabilityAnnotationStates r101, KotlinVersion r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = new KotlinVersion(1, 7, 20);
    L6:
        return getReportLevelForAnnotation(r100, r101, r102);
    }
}
