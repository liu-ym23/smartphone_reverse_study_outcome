package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087@\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0013\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides;", "", "value", "", "constructor-impl", "(I)I", "plus", "sides", "plus-gK_yJZ4", "(II)I", "hasAny", "", "hasAny-bkgdKaI$foundation_layout", "(II)Z", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "valueToString", "valueToString-impl", "equals", "other", "hashCode", "Companion", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class WindowInsetsSides {
    private static final int AllowLeftInLtr = 0;
    private static final int AllowLeftInRtl = 0;
    private static final int AllowRightInLtr = 0;
    private static final int AllowRightInRtl = 0;
    private static final int Bottom = 0;
    public static final Companion Companion = null;
    private static final int End = 0;
    private static final int Horizontal = 0;
    private static final int Left = 0;
    private static final int Right = 0;
    private static final int Start = 0;
    private static final int Top = 0;
    private static final int Vertical = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides$Companion;", "", "<init>", "()V", "AllowLeftInLtr", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "getAllowLeftInLtr-JoeWqyM$foundation_layout", "()I", "I", "AllowRightInLtr", "getAllowRightInLtr-JoeWqyM$foundation_layout", "AllowLeftInRtl", "getAllowLeftInRtl-JoeWqyM$foundation_layout", "AllowRightInRtl", "getAllowRightInRtl-JoeWqyM$foundation_layout", "Start", "getStart-JoeWqyM", "End", "getEnd-JoeWqyM", "Top", "getTop-JoeWqyM", "Bottom", "getBottom-JoeWqyM", "Left", "getLeft-JoeWqyM", "Right", "getRight-JoeWqyM", "Horizontal", "getHorizontal-JoeWqyM", "Vertical", "getVertical-JoeWqyM", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: getAllowLeftInLtr-JoeWqyM$foundation_layout, reason: not valid java name */
        public final int m1064getAllowLeftInLtrJoeWqyM$foundation_layout() {
            return WindowInsetsSides.access$getAllowLeftInLtr$cp();
        }

        /* JADX INFO: renamed from: getAllowLeftInRtl-JoeWqyM$foundation_layout, reason: not valid java name */
        public final int m1065getAllowLeftInRtlJoeWqyM$foundation_layout() {
            return WindowInsetsSides.access$getAllowLeftInRtl$cp();
        }

        /* JADX INFO: renamed from: getAllowRightInLtr-JoeWqyM$foundation_layout, reason: not valid java name */
        public final int m1066getAllowRightInLtrJoeWqyM$foundation_layout() {
            return WindowInsetsSides.access$getAllowRightInLtr$cp();
        }

        /* JADX INFO: renamed from: getAllowRightInRtl-JoeWqyM$foundation_layout, reason: not valid java name */
        public final int m1067getAllowRightInRtlJoeWqyM$foundation_layout() {
            return WindowInsetsSides.access$getAllowRightInRtl$cp();
        }

        /* JADX INFO: renamed from: getBottom-JoeWqyM, reason: not valid java name */
        public final int m1068getBottomJoeWqyM() {
            return WindowInsetsSides.access$getBottom$cp();
        }

        /* JADX INFO: renamed from: getEnd-JoeWqyM, reason: not valid java name */
        public final int m1069getEndJoeWqyM() {
            return WindowInsetsSides.access$getEnd$cp();
        }

        /* JADX INFO: renamed from: getHorizontal-JoeWqyM, reason: not valid java name */
        public final int m1070getHorizontalJoeWqyM() {
            return WindowInsetsSides.access$getHorizontal$cp();
        }

        /* JADX INFO: renamed from: getLeft-JoeWqyM, reason: not valid java name */
        public final int m1071getLeftJoeWqyM() {
            return WindowInsetsSides.access$getLeft$cp();
        }

        /* JADX INFO: renamed from: getRight-JoeWqyM, reason: not valid java name */
        public final int m1072getRightJoeWqyM() {
            return WindowInsetsSides.access$getRight$cp();
        }

        /* JADX INFO: renamed from: getStart-JoeWqyM, reason: not valid java name */
        public final int m1073getStartJoeWqyM() {
            return WindowInsetsSides.access$getStart$cp();
        }

        /* JADX INFO: renamed from: getTop-JoeWqyM, reason: not valid java name */
        public final int m1074getTopJoeWqyM() {
            return WindowInsetsSides.access$getTop$cp();
        }

        /* JADX INFO: renamed from: getVertical-JoeWqyM, reason: not valid java name */
        public final int m1075getVerticalJoeWqyM() {
            return WindowInsetsSides.access$getVertical$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ WindowInsetsSides m1054boximpl(int r1) {
        return new WindowInsetsSides(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m1055constructorimpl(int r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1056equalsimpl(int r2, Object r3) {
        if ((r3 instanceof WindowInsetsSides) == true) goto L6;
        return false;
    L6:
        if (r2 == ((WindowInsetsSides) r3).m1063unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1057equalsimpl0(int r0, int r1) {
        if (r0 != r1) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hasAny-bkgdKaI$foundation_layout, reason: not valid java name */
    public static final boolean m1058hasAnybkgdKaI$foundation_layout(int r0, int r1) {
        if ((r0 & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1059hashCodeimpl(int r0) {
        return r0;
    }

    public boolean equals(Object r2) {
        return m1056equalsimpl(this.value, r2);
    }

    public int hashCode() {
        return m1059hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1063unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        int r0 = m1055constructorimpl(8);
        AllowLeftInLtr = r0;
        int r1 = m1055constructorimpl(4);
        AllowRightInLtr = r1;
        int r2 = m1055constructorimpl(2);
        AllowLeftInRtl = r2;
        int r3 = m1055constructorimpl(1);
        AllowRightInRtl = r3;
        Start = m1060plusgK_yJZ4(r0, r3);
        End = m1060plusgK_yJZ4(r1, r2);
        int r4 = m1055constructorimpl(16);
        Top = r4;
        int r5 = m1055constructorimpl(32);
        Bottom = r5;
        int r6 = m1060plusgK_yJZ4(r0, r2);
        Left = r6;
        int r7 = m1060plusgK_yJZ4(r1, r3);
        Right = r7;
        Horizontal = m1060plusgK_yJZ4(r6, r7);
        Vertical = m1060plusgK_yJZ4(r4, r5);
    }

    public String toString() {
        return m1061toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getAllowLeftInLtr$cp() {
        return AllowLeftInLtr;
    }

    public static final /* synthetic */ int access$getAllowLeftInRtl$cp() {
        return AllowLeftInRtl;
    }

    public static final /* synthetic */ int access$getAllowRightInLtr$cp() {
        return AllowRightInLtr;
    }

    public static final /* synthetic */ int access$getAllowRightInRtl$cp() {
        return AllowRightInRtl;
    }

    public static final /* synthetic */ int access$getBottom$cp() {
        return Bottom;
    }

    public static final /* synthetic */ int access$getEnd$cp() {
        return End;
    }

    public static final /* synthetic */ int access$getHorizontal$cp() {
        return Horizontal;
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

    public static final /* synthetic */ int access$getTop$cp() {
        return Top;
    }

    public static final /* synthetic */ int access$getVertical$cp() {
        return Vertical;
    }

    private /* synthetic */ WindowInsetsSides(int r1) {
        this.value = r1;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1061toStringimpl(int r2) {
        return "WindowInsetsSides(" + m1062valueToStringimpl(r2) + ')';
    }

    /* JADX INFO: renamed from: valueToString-impl, reason: not valid java name */
    private static final String m1062valueToStringimpl(int r3) {
        StringBuilder r0 = new StringBuilder();
        int r1 = Start;
        if ((r3 & r1) != r1) goto L5;
        valueToString_impl$lambda$0$appendPlus(r0, "Start");
    L5:
        int r2 = Left;
        if ((r3 & r2) != r2) goto L8;
        valueToString_impl$lambda$0$appendPlus(r0, "Left");
    L8:
        int r4 = Top;
        if ((r3 & r4) != r4) goto L11;
        valueToString_impl$lambda$0$appendPlus(r0, "Top");
    L11:
        int r5 = End;
        if ((r3 & r5) != r5) goto L14;
        valueToString_impl$lambda$0$appendPlus(r0, "End");
    L14:
        int r6 = Right;
        if ((r3 & r6) != r6) goto L17;
        valueToString_impl$lambda$0$appendPlus(r0, "Right");
    L17:
        int r7 = Bottom;
        if ((r3 & r7) != r7) goto L21;
        valueToString_impl$lambda$0$appendPlus(r0, "Bottom");
    L21:
        return r0.toString();
    }

    /* JADX INFO: renamed from: plus-gK_yJZ4, reason: not valid java name */
    public static final int m1060plusgK_yJZ4(int r0, int r1) {
        return m1055constructorimpl(r0 | r1);
    }

    private static final void valueToString_impl$lambda$0$appendPlus(StringBuilder r1, String r2) {
        if (r1.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r1.append('+');
    L8:
        r1.append(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
