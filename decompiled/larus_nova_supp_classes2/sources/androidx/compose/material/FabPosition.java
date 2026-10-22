package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/FabPosition;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class FabPosition {
    private static final int Center = 0;
    public static final Companion Companion = null;
    private static final int End = 0;
    private static final int Start = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/material/FabPosition$Companion;", "", "<init>", "()V", "Start", "Landroidx/compose/material/FabPosition;", "getStart-5ygKITE", "()I", "I", "Center", "getCenter-5ygKITE", "End", "getEnd-5ygKITE", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: getCenter-5ygKITE, reason: not valid java name */
        public final int m2068getCenter5ygKITE() {
            return FabPosition.access$getCenter$cp();
        }

        /* JADX INFO: renamed from: getEnd-5ygKITE, reason: not valid java name */
        public final int m2069getEnd5ygKITE() {
            return FabPosition.access$getEnd$cp();
        }

        /* JADX INFO: renamed from: getStart-5ygKITE, reason: not valid java name */
        public final int m2070getStart5ygKITE() {
            return FabPosition.access$getStart$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FabPosition m2061boximpl(int r1) {
        return new FabPosition(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2062constructorimpl(int r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2063equalsimpl(int r2, Object r3) {
        if ((r3 instanceof FabPosition) == true) goto L6;
        return false;
    L6:
        if (r2 == ((FabPosition) r3).m2067unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2064equalsimpl0(int r0, int r1) {
        if (r0 != r1) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2065hashCodeimpl(int r0) {
        return r0;
    }

    public boolean equals(Object r2) {
        return m2063equalsimpl(this.value, r2);
    }

    public int hashCode() {
        return m2065hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2067unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Start = m2062constructorimpl(0);
        Center = m2062constructorimpl(1);
        End = m2062constructorimpl(2);
    }

    public String toString() {
        return m2066toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getCenter$cp() {
        return Center;
    }

    public static final /* synthetic */ int access$getEnd$cp() {
        return End;
    }

    public static final /* synthetic */ int access$getStart$cp() {
        return Start;
    }

    private /* synthetic */ FabPosition(int r1) {
        this.value = r1;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2066toStringimpl(int r1) {
        if (m2064equalsimpl0(r1, Start) == false) goto L6;
        return "FabPosition.Start";
    L6:
        if (m2064equalsimpl0(r1, Center) == false) goto L8;
        return "FabPosition.Center";
    L8:
        return "FabPosition.End";
    }
}
