package androidx.compose.material3;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "", HintConstants.AUTOFILL_HINT_NAME, "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "toString-impl", "equals", "", "other", "hashCode", "", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class ExposedDropdownMenuAnchorType {
    public static final Companion Companion = null;
    private static final String PrimaryEditable = null;
    private static final String PrimaryNotEditable = null;
    private static final String SecondaryEditable = null;
    private final String name;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuAnchorType$Companion;", "", "<init>", "()V", "PrimaryNotEditable", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "getPrimaryNotEditable-oYjWRB4", "()Ljava/lang/String;", "Ljava/lang/String;", "PrimaryEditable", "getPrimaryEditable-oYjWRB4", "SecondaryEditable", "getSecondaryEditable-oYjWRB4", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: getPrimaryEditable-oYjWRB4, reason: not valid java name */
        public final String m2675getPrimaryEditableoYjWRB4() {
            return ExposedDropdownMenuAnchorType.access$getPrimaryEditable$cp();
        }

        /* JADX INFO: renamed from: getPrimaryNotEditable-oYjWRB4, reason: not valid java name */
        public final String m2676getPrimaryNotEditableoYjWRB4() {
            return ExposedDropdownMenuAnchorType.access$getPrimaryNotEditable$cp();
        }

        /* JADX INFO: renamed from: getSecondaryEditable-oYjWRB4, reason: not valid java name */
        public final String m2677getSecondaryEditableoYjWRB4() {
            return ExposedDropdownMenuAnchorType.access$getSecondaryEditable$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ExposedDropdownMenuAnchorType m2668boximpl(String r1) {
        return new ExposedDropdownMenuAnchorType(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static String m2669constructorimpl(String r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2670equalsimpl(String r2, Object r3) {
        if ((r3 instanceof ExposedDropdownMenuAnchorType) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r2, ((ExposedDropdownMenuAnchorType) r3).m2674unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2671equalsimpl0(String r0, String r1) {
        return Intrinsics.areEqual(r0, r1);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2672hashCodeimpl(String r0) {
        return r0.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2673toStringimpl(String r0) {
        return r0;
    }

    public boolean equals(Object r2) {
        return m2670equalsimpl(this.name, r2);
    }

    public int hashCode() {
        return m2672hashCodeimpl(this.name);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m2674unboximpl() {
        return this.name;
    }

    static {
        Companion = new Companion(null);
        PrimaryNotEditable = m2669constructorimpl("PrimaryNotEditable");
        PrimaryEditable = m2669constructorimpl("PrimaryEditable");
        SecondaryEditable = m2669constructorimpl("SecondaryEditable");
    }

    public String toString() {
        return m2673toStringimpl(this.name);
    }

    public static final /* synthetic */ String access$getPrimaryEditable$cp() {
        return PrimaryEditable;
    }

    public static final /* synthetic */ String access$getPrimaryNotEditable$cp() {
        return PrimaryNotEditable;
    }

    public static final /* synthetic */ String access$getSecondaryEditable$cp() {
        return SecondaryEditable;
    }

    private /* synthetic */ ExposedDropdownMenuAnchorType(String r1) {
        this.name = r1;
    }
}
