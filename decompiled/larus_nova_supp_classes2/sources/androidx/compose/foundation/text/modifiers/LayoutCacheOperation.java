package androidx.compose.foundation.text.modifiers;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation;", "", "flag", "", "constructor-impl", "(J)J", "getFlag", "()J", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class LayoutCacheOperation {
    public static final Companion Companion = null;
    private static final long LayoutWithConstraints = 0;
    private static final long MarkDirtyDensity = 0;
    private static final long MarkDirtyNode = 0;
    private static final long MarkDirtyStyle = 0;
    private final long flag;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation$Companion;", "", "<init>", "()V", "MarkDirtyStyle", "Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation;", "getMarkDirtyStyle-DEKiAbY", "()J", "J", "MarkDirtyDensity", "getMarkDirtyDensity-DEKiAbY", "MarkDirtyNode", "getMarkDirtyNode-DEKiAbY", "LayoutWithConstraints", "getLayoutWithConstraints-DEKiAbY", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: getLayoutWithConstraints-DEKiAbY, reason: not valid java name */
        public final long m1758getLayoutWithConstraintsDEKiAbY() {
            return LayoutCacheOperation.access$getLayoutWithConstraints$cp();
        }

        /* JADX INFO: renamed from: getMarkDirtyDensity-DEKiAbY, reason: not valid java name */
        public final long m1759getMarkDirtyDensityDEKiAbY() {
            return LayoutCacheOperation.access$getMarkDirtyDensity$cp();
        }

        /* JADX INFO: renamed from: getMarkDirtyNode-DEKiAbY, reason: not valid java name */
        public final long m1760getMarkDirtyNodeDEKiAbY() {
            return LayoutCacheOperation.access$getMarkDirtyNode$cp();
        }

        /* JADX INFO: renamed from: getMarkDirtyStyle-DEKiAbY, reason: not valid java name */
        public final long m1761getMarkDirtyStyleDEKiAbY() {
            return LayoutCacheOperation.access$getMarkDirtyStyle$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LayoutCacheOperation m1751boximpl(long r1) {
        return new LayoutCacheOperation(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m1752constructorimpl(long r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1753equalsimpl(long r4, Object r6) {
        if ((r6 instanceof LayoutCacheOperation) == true) goto L6;
        return false;
    L6:
        if (r4 == ((LayoutCacheOperation) r6).m1757unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1754equalsimpl0(long r1, long r3) {
        if (r1 != r3) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1755hashCodeimpl(long r2) {
        return (int) (r2 ^ (r2 >>> 32));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1756toStringimpl(long r2) {
        return "LayoutCacheOperation(flag=" + r2 + ')';
    }

    public boolean equals(Object r3) {
        return m1753equalsimpl(this.flag, r3);
    }

    public int hashCode() {
        return m1755hashCodeimpl(this.flag);
    }

    public String toString() {
        return m1756toStringimpl(this.flag);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1757unboximpl() {
        return this.flag;
    }

    static {
        Companion = new Companion(null);
        MarkDirtyStyle = m1752constructorimpl(0);
        MarkDirtyDensity = m1752constructorimpl(1);
        MarkDirtyNode = m1752constructorimpl(2);
        LayoutWithConstraints = m1752constructorimpl(3);
    }

    public static final /* synthetic */ long access$getLayoutWithConstraints$cp() {
        return LayoutWithConstraints;
    }

    public static final /* synthetic */ long access$getMarkDirtyDensity$cp() {
        return MarkDirtyDensity;
    }

    public static final /* synthetic */ long access$getMarkDirtyNode$cp() {
        return MarkDirtyNode;
    }

    public static final /* synthetic */ long access$getMarkDirtyStyle$cp() {
        return MarkDirtyStyle;
    }

    public final long getFlag() {
        return this.flag;
    }

    private /* synthetic */ LayoutCacheOperation(long r1) {
        this.flag = r1;
    }
}
