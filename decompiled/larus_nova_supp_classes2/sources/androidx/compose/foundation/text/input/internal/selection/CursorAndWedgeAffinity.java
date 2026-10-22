package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/CursorAndWedgeAffinity;", "", "value", "", "constructor-impl", "(J)J", "cursor", "", "(I)J", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "(ILandroidx/compose/foundation/text/input/internal/WedgeAffinity;)J", "getCursor-impl", "(J)I", "getWedgeAffinity-impl", "(J)Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "component1", "component1-impl", "component2", "component2-impl", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class CursorAndWedgeAffinity {
    private final long value;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[WedgeAffinity.values().length];
            r0[WedgeAffinity.Start.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[WedgeAffinity.End.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CursorAndWedgeAffinity m1686boximpl(long r1) {
        return new CursorAndWedgeAffinity(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1691constructorimpl(long r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1692equalsimpl(long r4, Object r6) {
        if ((r6 instanceof CursorAndWedgeAffinity) == true) goto L6;
        return false;
    L6:
        if (r4 == ((CursorAndWedgeAffinity) r6).m1698unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1693equalsimpl0(long r1, long r3) {
        if (r1 != r3) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getCursor-impl, reason: not valid java name */
    public static final int m1694getCursorimpl(long r1) {
        return (int) (r1 >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1696hashCodeimpl(long r2) {
        return (int) (r2 ^ (r2 >>> 32));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1697toStringimpl(long r2) {
        return "CursorAndWedgeAffinity(value=" + r2 + ')';
    }

    public boolean equals(Object r3) {
        return m1692equalsimpl(this.value, r3);
    }

    public int hashCode() {
        return m1696hashCodeimpl(this.value);
    }

    public String toString() {
        return m1697toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1698unboximpl() {
        return this.value;
    }

    private /* synthetic */ CursorAndWedgeAffinity(long r1) {
        this.value = r1;
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m1687component1impl(long r0) {
        return m1694getCursorimpl(r0);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final WedgeAffinity m1688component2impl(long r0) {
        return m1695getWedgeAffinityimpl(r0);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1689constructorimpl(int r6) {
        return m1691constructorimpl((((long) r6) << 32) | (((long) (-1)) & 4294967295L));
    }

    /* JADX INFO: renamed from: getWedgeAffinity-impl, reason: not valid java name */
    public static final WedgeAffinity m1695getWedgeAffinityimpl(long r2) {
        int r3 = (int) (r2 & 4294967295L);
        if (r3 >= 0) goto L5;
        return null;
    L5:
        if (r3 != 0) goto L8;
        return WedgeAffinity.Start;
    L8:
        return WedgeAffinity.End;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1690constructorimpl(int r4, WedgeAffinity r5) {
        int r0 = -1;
        if (r5 != null) goto L5;
        int r6 = -1;
    L6:
        if (r6 == (-1)) goto L16;
        r0 = 1;
        if (r6 != 1) goto L10;
        r0 = 0;
        goto L16
    L10:
        if (r6 == 2) goto L16;
        throw new NoWhenBranchMatchedException();
    L16:
        return m1691constructorimpl((((long) r4) << 32) | (((long) r0) & 4294967295L));
    L5:
        r6 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        goto L6
    }
}
