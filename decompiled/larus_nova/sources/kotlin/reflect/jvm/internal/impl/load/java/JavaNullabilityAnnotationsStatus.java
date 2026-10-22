package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class JavaNullabilityAnnotationsStatus {
    public static final Companion Companion = null;
    private static final JavaNullabilityAnnotationsStatus DEFAULT = null;
    private final ReportLevel reportLevelAfter;
    private final ReportLevel reportLevelBefore;
    private final KotlinVersion sinceVersion;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final JavaNullabilityAnnotationsStatus getDEFAULT() {
            return JavaNullabilityAnnotationsStatus.access$getDEFAULT$cp();
        }
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof JavaNullabilityAnnotationsStatus) == true) goto L8;
        return false;
    L8:
        JavaNullabilityAnnotationsStatus r101 = (JavaNullabilityAnnotationsStatus) r100;
        if (this.reportLevelBefore == r101.reportLevelBefore) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sinceVersion, r101.sinceVersion) == true) goto L15;
        return false;
    L15:
        if (this.reportLevelAfter == r101.reportLevelAfter) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.reportLevelBefore.hashCode() * 31;
        KotlinVersion r101 = this.sinceVersion;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.reportLevelAfter.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.reportLevelBefore + ", sinceVersion=" + this.sinceVersion + ", reportLevelAfter=" + this.reportLevelAfter + ')';
    }

    static {
        Companion = new Companion(null);
        DEFAULT = new JavaNullabilityAnnotationsStatus(ReportLevel.STRICT, null, null, 6, null);
    }

    public static final /* synthetic */ JavaNullabilityAnnotationsStatus access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final ReportLevel getReportLevelAfter() {
        return this.reportLevelAfter;
    }

    public final ReportLevel getReportLevelBefore() {
        return this.reportLevelBefore;
    }

    public final KotlinVersion getSinceVersion() {
        return this.sinceVersion;
    }

    public JavaNullabilityAnnotationsStatus(ReportLevel r100, KotlinVersion r101, ReportLevel r102) {
        Intrinsics.checkNotNullParameter(r100, "reportLevelBefore");
        Intrinsics.checkNotNullParameter(r102, "reportLevelAfter");
        this.reportLevelBefore = r100;
        this.sinceVersion = r101;
        this.reportLevelAfter = r102;
    }

    public /* synthetic */ JavaNullabilityAnnotationsStatus(ReportLevel r100, KotlinVersion r101, ReportLevel r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = new KotlinVersion(1, 0);
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = r100;
    L8:
        this(r100, r101, r102);
    }
}
