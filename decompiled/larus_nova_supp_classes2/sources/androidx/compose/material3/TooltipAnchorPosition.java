package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/TooltipAnchorPosition;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TooltipAnchorPosition {
    private static final int Above = 0;
    private static final int Below = 0;
    public static final Companion Companion = null;
    private static final int End = 0;
    private static final int Left = 0;
    private static final int Right = 0;
    private static final int Start = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/TooltipAnchorPosition$Companion;", "", "<init>", "()V", "Above", "Landroidx/compose/material3/TooltipAnchorPosition;", "getAbove-lOKsHw4", "()I", "I", "Below", "getBelow-lOKsHw4", "Left", "getLeft-lOKsHw4", "Right", "getRight-lOKsHw4", "Start", "getStart-lOKsHw4", "End", "getEnd-lOKsHw4", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: getAbove-lOKsHw4, reason: not valid java name */
        public final int m3535getAbovelOKsHw4() {
            return TooltipAnchorPosition.access$getAbove$cp();
        }

        /* JADX INFO: renamed from: getBelow-lOKsHw4, reason: not valid java name */
        public final int m3536getBelowlOKsHw4() {
            return TooltipAnchorPosition.access$getBelow$cp();
        }

        /* JADX INFO: renamed from: getEnd-lOKsHw4, reason: not valid java name */
        public final int m3537getEndlOKsHw4() {
            return TooltipAnchorPosition.access$getEnd$cp();
        }

        /* JADX INFO: renamed from: getLeft-lOKsHw4, reason: not valid java name */
        public final int m3538getLeftlOKsHw4() {
            return TooltipAnchorPosition.access$getLeft$cp();
        }

        /* JADX INFO: renamed from: getRight-lOKsHw4, reason: not valid java name */
        public final int m3539getRightlOKsHw4() {
            return TooltipAnchorPosition.access$getRight$cp();
        }

        /* JADX INFO: renamed from: getStart-lOKsHw4, reason: not valid java name */
        public final int m3540getStartlOKsHw4() {
            return TooltipAnchorPosition.access$getStart$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TooltipAnchorPosition m3528boximpl(int r1) {
        return new TooltipAnchorPosition(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m3529constructorimpl(int r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3530equalsimpl(int r2, Object r3) {
        if ((r3 instanceof TooltipAnchorPosition) == true) goto L6;
        return false;
    L6:
        if (r2 == ((TooltipAnchorPosition) r3).m3534unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3531equalsimpl0(int r0, int r1) {
        if (r0 != r1) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3532hashCodeimpl(int r0) {
        return r0;
    }

    public boolean equals(Object r2) {
        return m3530equalsimpl(this.value, r2);
    }

    public int hashCode() {
        return m3532hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3534unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Above = m3529constructorimpl(1);
        Below = m3529constructorimpl(2);
        Left = m3529constructorimpl(3);
        Right = m3529constructorimpl(4);
        Start = m3529constructorimpl(5);
        End = m3529constructorimpl(6);
    }

    public String toString() {
        return m3533toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getAbove$cp() {
        return Above;
    }

    public static final /* synthetic */ int access$getBelow$cp() {
        return Below;
    }

    public static final /* synthetic */ int access$getEnd$cp() {
        return End;
    }

    public static final /* synthetic */ int access$getLeft$cp() {
        return Left;
    }

    public static final /* synthetic */ int access$getRight$cp() {
        return Right;
    }

    public static final /* synthetic */ int access$getStart$cp() {
        return Start;
    }

    private /* synthetic */ TooltipAnchorPosition(int r1) {
        this.value = r1;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3533toStringimpl(int r1) {
        if (m3531equalsimpl0(r1, Above) == false) goto L6;
        return "Above";
    L6:
        if (m3531equalsimpl0(r1, Below) == false) goto L9;
        return "Below";
    L9:
        if (m3531equalsimpl0(r1, Left) == false) goto L12;
        return "Left";
    L12:
        if (m3531equalsimpl0(r1, Right) == false) goto L15;
        return "Right";
    L15:
        if (m3531equalsimpl0(r1, Start) == false) goto L18;
        return "Start";
    L18:
        if (m3531equalsimpl0(r1, End) == false) goto L20;
        return "End";
    L20:
        return "Invalid";
    }
}
