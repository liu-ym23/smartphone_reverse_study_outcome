package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010%\u001a\u0004\u0018\u00010&JN\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\"2\u0006\u00101\u001a\u000202J \u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020+H\u0002R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "", "currentPosition", "Landroidx/compose/ui/geometry/Offset;", "previousHandlePosition", "containerCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "isStartHandle", "", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "selectableIdOrderingComparator", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "<init>", "(JJLandroidx/compose/ui/layout/LayoutCoordinates;ZLandroidx/compose/foundation/text/selection/Selection;Ljava/util/Comparator;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCurrentPosition-F1C5BW0", "()J", "J", "getPreviousHandlePosition-F1C5BW0", "getContainerCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "()Z", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "getSelectableIdOrderingComparator", "()Ljava/util/Comparator;", "selectableIdToInfoListIndex", "Landroidx/collection/MutableLongIntMap;", "infoList", "", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "startSlot", "", "endSlot", "currentSlot", "build", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "appendInfo", "selectableId", "rawStartHandleOffset", "startXHandleDirection", "Landroidx/compose/foundation/text/selection/Direction;", "startYHandleDirection", "rawEndHandleOffset", "endXHandleDirection", "endYHandleDirection", "rawPreviousHandleOffset", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "updateSlot", "slot", "xPositionDirection", "yPositionDirection", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectionLayoutBuilder {
    public static final int $stable = 8;
    private final LayoutCoordinates containerCoordinates;
    private final long currentPosition;
    private int currentSlot;
    private int endSlot;
    private final List<SelectableInfo> infoList;
    private final boolean isStartHandle;
    private final long previousHandlePosition;
    private final Selection previousSelection;
    private final Comparator<Long> selectableIdOrderingComparator;
    private final MutableLongIntMap selectableIdToInfoListIndex;
    private int startSlot;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Direction.values().length];
            r0[Direction.BEFORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Direction.ON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Direction.AFTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public /* synthetic */ SelectionLayoutBuilder(long r1, long r3, LayoutCoordinates r5, boolean r6, Selection r7, Comparator r8, DefaultConstructorMarker r9) {
        this(r1, r3, r5, r6, r7, r8);
    }

    public final SelectionLayout build() {
        int r0 = this.currentSlot + 1;
        int r2 = this.infoList.size();
        if (r2 != 0) goto L5;
        return null;
    L5:
        if (r2 == 1) goto L15;
        MutableLongIntMap r5 = this.selectableIdToInfoListIndex;
        List<SelectableInfo> r6 = this.infoList;
        int r3 = this.startSlot;
        if (r3 != (-1)) goto L9;
        int r7 = r0;
    L10:
        int r4 = this.endSlot;
        if (r4 != (-1)) goto L13;
        int r8 = r0;
    L27:
        return new MultiSelectionLayout(r5, r6, r7, r8, this.isStartHandle, this.previousSelection);
    L13:
        r8 = r4;
        goto L27
    L9:
        r7 = r3;
        goto L10
    L15:
        SelectableInfo r9 = (SelectableInfo) CollectionsKt.single(this.infoList);
        int r1 = this.startSlot;
        if (r1 != (-1)) goto L18;
        int r10 = r0;
    L19:
        int r11 = this.endSlot;
        if (r11 != (-1)) goto L22;
        int r12 = r0;
    L23:
        Selection r13 = this.previousSelection;
        return new SingleSelectionLayout(this.isStartHandle, r10, r12, r13, r9);
    L22:
        r12 = r11;
        goto L23
    L18:
        r10 = r1;
        goto L19
    }

    public final LayoutCoordinates getContainerCoordinates() {
        return this.containerCoordinates;
    }

    /* JADX INFO: renamed from: getCurrentPosition-F1C5BW0, reason: not valid java name */
    public final long m1851getCurrentPositionF1C5BW0() {
        return this.currentPosition;
    }

    /* JADX INFO: renamed from: getPreviousHandlePosition-F1C5BW0, reason: not valid java name */
    public final long m1852getPreviousHandlePositionF1C5BW0() {
        return this.previousHandlePosition;
    }

    public final Selection getPreviousSelection() {
        return this.previousSelection;
    }

    public final Comparator<Long> getSelectableIdOrderingComparator() {
        return this.selectableIdOrderingComparator;
    }

    public final boolean isStartHandle() {
        return this.isStartHandle;
    }

    private final int updateSlot(int r2, Direction r3, Direction r4) {
        if (r2 == (-1)) goto L5;
        return r2;
    L5:
        Direction r5 = SelectionLayoutKt.resolve2dDirection(r3, r4);
        int r6 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r6 == 1) goto L16;
        if (r6 == 2) goto L17;
        if (r6 != 3) goto L13;
        return r2;
    L13:
        throw new NoWhenBranchMatchedException();
    L17:
        return this.currentSlot;
    L16:
        return this.currentSlot - 1;
    }

    private SelectionLayoutBuilder(long r1, long r3, LayoutCoordinates r5, boolean r6, Selection r7, Comparator<Long> r8) {
        this.currentPosition = r1;
        this.previousHandlePosition = r3;
        this.containerCoordinates = r5;
        this.isStartHandle = r6;
        this.previousSelection = r7;
        this.selectableIdOrderingComparator = r8;
        this.selectableIdToInfoListIndex = LongIntMapKt.mutableLongIntMapOf();
        this.infoList = new ArrayList();
        this.startSlot = -1;
        this.endSlot = -1;
        this.currentSlot = -1;
    }

    public final SelectableInfo appendInfo(long r11, int r13, Direction r14, Direction r15, int r16, Direction r17, Direction r18, int r19, TextLayoutResult r20) {
        this.currentSlot += 2;
        SelectableInfo r1 = new SelectableInfo(r11, this.currentSlot, r13, r16, r19, r20);
        this.startSlot = updateSlot(this.startSlot, r14, r15);
        this.endSlot = updateSlot(this.endSlot, r17, r18);
        this.selectableIdToInfoListIndex.set(r11, this.infoList.size());
        this.infoList.add(r1);
        return r1;
    }
}
