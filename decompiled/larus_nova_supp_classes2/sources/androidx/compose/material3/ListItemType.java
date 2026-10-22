package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0083@\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/ListItemType;", "", "lines", "", "constructor-impl", "(I)I", "compareTo", "other", "compareTo-yh95HIg", "(II)I", "equals", "", "", "hashCode", "toString", "", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
final class ListItemType implements Comparable<ListItemType> {
    public static final Companion Companion = null;
    private static final int OneLine = 0;
    private static final int ThreeLine = 0;
    private static final int TwoLine = 0;
    private final int lines;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0080\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/ListItemType$Companion;", "", "<init>", "()V", "OneLine", "Landroidx/compose/material3/ListItemType;", "getOneLine-AlXitO8", "()I", "I", "TwoLine", "getTwoLine-AlXitO8", "ThreeLine", "getThreeLine-AlXitO8", "invoke", "hasOverline", "", "hasSupporting", "isSupportingMultiline", "invoke-Z-LSjz4$material3", "(ZZZ)I", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: getOneLine-AlXitO8, reason: not valid java name */
        public final int m2847getOneLineAlXitO8() {
            return ListItemType.access$getOneLine$cp();
        }

        /* JADX INFO: renamed from: getThreeLine-AlXitO8, reason: not valid java name */
        public final int m2848getThreeLineAlXitO8() {
            return ListItemType.access$getThreeLine$cp();
        }

        /* JADX INFO: renamed from: getTwoLine-AlXitO8, reason: not valid java name */
        public final int m2849getTwoLineAlXitO8() {
            return ListItemType.access$getTwoLine$cp();
        }

        /* JADX INFO: renamed from: invoke-Z-LSjz4$material3, reason: not valid java name */
        public final int m2850invokeZLSjz4$material3(boolean r1, boolean r2, boolean r3) {
            if (r1 == false) goto L4;
            if (r2 == false) goto L4;
        L12:
            return m2848getThreeLineAlXitO8();
        L4:
            if (r3 == true) goto L12;
            if (r1 == true) goto L11;
            if (r2 == true) goto L11;
            return m2847getOneLineAlXitO8();
        L11:
            return m2849getTwoLineAlXitO8();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ListItemType m2838boximpl(int r1) {
        return new ListItemType(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2840constructorimpl(int r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2841equalsimpl(int r2, Object r3) {
        if ((r3 instanceof ListItemType) == true) goto L6;
        return false;
    L6:
        if (r2 == ((ListItemType) r3).m2846unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2842equalsimpl0(int r0, int r1) {
        if (r0 != r1) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2843hashCodeimpl(int r0) {
        return r0;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2844toStringimpl(int r2) {
        return "ListItemType(lines=" + r2 + ')';
    }

    public boolean equals(Object r2) {
        return m2841equalsimpl(this.lines, r2);
    }

    public int hashCode() {
        return m2843hashCodeimpl(this.lines);
    }

    public String toString() {
        return m2844toStringimpl(this.lines);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2846unboximpl() {
        return this.lines;
    }

    static {
        Companion = new Companion(null);
        OneLine = m2840constructorimpl(1);
        TwoLine = m2840constructorimpl(2);
        ThreeLine = m2840constructorimpl(3);
    }

    public static final /* synthetic */ int access$getOneLine$cp() {
        return OneLine;
    }

    public static final /* synthetic */ int access$getThreeLine$cp() {
        return ThreeLine;
    }

    public static final /* synthetic */ int access$getTwoLine$cp() {
        return TwoLine;
    }

    private /* synthetic */ ListItemType(int r1) {
        this.lines = r1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ListItemType r1) {
        return m2845compareToyh95HIg(r1.m2846unboximpl());
    }

    /* JADX INFO: renamed from: compareTo-yh95HIg, reason: not valid java name */
    public int m2845compareToyh95HIg(int r2) {
        return m2839compareToyh95HIg(this.lines, r2);
    }

    /* JADX INFO: renamed from: compareTo-yh95HIg, reason: not valid java name */
    public static int m2839compareToyh95HIg(int r0, int r1) {
        return Intrinsics.compare(r0, r1);
    }
}
