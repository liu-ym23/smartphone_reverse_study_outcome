package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/ShortNavigationBarArrangement;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class ShortNavigationBarArrangement {
    private static final int Centered = 0;
    public static final Companion Companion = null;
    private static final int EqualWeight = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/ShortNavigationBarArrangement$Companion;", "", "<init>", "()V", "EqualWeight", "Landroidx/compose/material3/ShortNavigationBarArrangement;", "getEqualWeight-LnnQw40", "()I", "I", "Centered", "getCentered-LnnQw40", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: getCentered-LnnQw40, reason: not valid java name */
        public final int m3126getCenteredLnnQw40() {
            return ShortNavigationBarArrangement.access$getCentered$cp();
        }

        /* JADX INFO: renamed from: getEqualWeight-LnnQw40, reason: not valid java name */
        public final int m3127getEqualWeightLnnQw40() {
            return ShortNavigationBarArrangement.access$getEqualWeight$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ShortNavigationBarArrangement m3119boximpl(int r1) {
        return new ShortNavigationBarArrangement(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m3120constructorimpl(int r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3121equalsimpl(int r2, Object r3) {
        if ((r3 instanceof ShortNavigationBarArrangement) == true) goto L6;
        return false;
    L6:
        if (r2 == ((ShortNavigationBarArrangement) r3).m3125unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3122equalsimpl0(int r0, int r1) {
        if (r0 != r1) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3123hashCodeimpl(int r0) {
        return r0;
    }

    public boolean equals(Object r2) {
        return m3121equalsimpl(this.value, r2);
    }

    public int hashCode() {
        return m3123hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3125unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        EqualWeight = m3120constructorimpl(0);
        Centered = m3120constructorimpl(1);
    }

    public String toString() {
        return m3124toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getCentered$cp() {
        return Centered;
    }

    public static final /* synthetic */ int access$getEqualWeight$cp() {
        return EqualWeight;
    }

    private /* synthetic */ ShortNavigationBarArrangement(int r1) {
        this.value = r1;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3124toStringimpl(int r1) {
        if (m3122equalsimpl0(r1, EqualWeight) == false) goto L6;
        return "EqualWeight";
    L6:
        if (m3122equalsimpl0(r1, Centered) == false) goto L8;
        return "Centered";
    L8:
        return "Unknown";
    }
}
