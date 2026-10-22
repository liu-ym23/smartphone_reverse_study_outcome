package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH ¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionMode;", "", "<init>", "(Ljava/lang/String;I)V", "Vertical", "Horizontal", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation_release", "(JLandroidx/compose/ui/geometry/Rect;)I", "isSelected", "", "start", "end", "isSelected-2x9bVx0$foundation_release", "(Landroidx/compose/ui/geometry/Rect;JJ)Z", "containsInclusive", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract enum SelectionMode extends Enum<SelectionMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SelectionMode[] $VALUES = null;
    public static final SelectionMode Horizontal = null;
    public static final SelectionMode Vertical = null;

    private static final /* synthetic */ SelectionMode[] $values() {
        return new SelectionMode[]{Vertical, Horizontal};
    }

    public /* synthetic */ SelectionMode(String r1, int r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public static EnumEntries<SelectionMode> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release, reason: not valid java name */
    public abstract int mo1882compare3MmeM6k$foundation_release(long r1, Rect r3);

    static {
        final String r1 = "Vertical";
        final int r2 = 0;
        Vertical = new Vertical(r1, r2);
        final String r3 = "Horizontal";
        final int r4 = 1;
        Horizontal = new Horizontal(r3, r4);
        SelectionMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static SelectionMode[] values() {
        return (SelectionMode[]) $VALUES.clone();
    }

    public static SelectionMode valueOf(String r1) {
        return (SelectionMode) r27.a.a(SelectionMode.class, r1);
    }

    private SelectionMode(String r1, int r2) {
        super(r1, r2);
    }

    /* JADX INFO: renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    private final boolean m1881containsInclusiveUv8p0NA(Rect r6, long r7) {
        float r0 = r6.getLeft();
        float r1 = r6.getRight();
        float r2 = Float.intBitsToFloat((int) (r7 >> 32));
        if (r0 <= r2) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L17;
        float r4 = r6.getTop();
        float r8 = r6.getBottom();
        float r9 = Float.intBitsToFloat((int) (r7 & 4294967295L));
        if (r4 <= r9) goto L12;
    L14:
        boolean r10 = false;
    L15:
        if (r10 == false) goto L17;
        return true;
    L12:
        if (r9 > r8) goto L14;
        r10 = true;
    L17:
        return false;
    L5:
        if (r2 > r1) goto L7;
        r3 = true;
        goto L8
    }

    /* JADX INFO: renamed from: isSelected-2x9bVx0$foundation_release, reason: not valid java name */
    public final boolean m1883isSelected2x9bVx0$foundation_release(Rect r3, long r4, long r6) {
        boolean r1 = true;
        if (m1881containsInclusiveUv8p0NA(r3, r4) == false) goto L5;
    L16:
        return true;
    L5:
        if (m1881containsInclusiveUv8p0NA(r3, r6) == true) goto L16;
        int r5 = mo1882compare3MmeM6k$foundation_release(r4, r3);
        int r7 = mo1882compare3MmeM6k$foundation_release(r6, r3);
        if (r5 <= 0) goto L10;
        boolean r8 = true;
    L11:
        if (r7 > 0) goto L15;
        r1 = false;
    L15:
        return r8 ^ r1;
    L10:
        r8 = false;
        goto L11
    }
}
