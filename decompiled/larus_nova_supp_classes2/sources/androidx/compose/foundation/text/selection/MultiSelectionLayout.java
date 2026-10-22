package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMap;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010+\u001a\u00020,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,0.H\u0016J\u0012\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0000H\u0002J\u0016\u00102\u001a\b\u0012\u0004\u0012\u00020\r032\u0006\u00104\u001a\u00020\rH\u0016J2\u00105\u001a\u00020,*\b\u0012\u0004\u0012\u00020\r062\u0006\u00104\u001a\u00020\r2\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0002J\b\u0010:\u001a\u00020;H\u0016J\u0018\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u000bH\u0002J\u0018\u0010?\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u000bH\u0002J\u0010\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020CH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0017R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\"R\u0014\u0010)\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\"¨\u0006D"}, d2 = {"Landroidx/compose/foundation/text/selection/MultiSelectionLayout;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "selectableIdToInfoListIndex", "Landroidx/collection/LongIntMap;", "infoList", "", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "startSlot", "", "endSlot", "isStartHandle", "", "previousSelection", "Landroidx/compose/foundation/text/selection/Selection;", "<init>", "(Landroidx/collection/LongIntMap;Ljava/util/List;IIZLandroidx/compose/foundation/text/selection/Selection;)V", "getSelectableIdToInfoListIndex", "()Landroidx/collection/LongIntMap;", "getInfoList", "()Ljava/util/List;", "getStartSlot", "()I", "getEndSlot", "()Z", "getPreviousSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "size", "getSize", "crossStatus", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "startInfo", "getStartInfo", "()Landroidx/compose/foundation/text/selection/SelectableInfo;", "endInfo", "getEndInfo", "currentInfo", "getCurrentInfo", "firstInfo", "getFirstInfo", "lastInfo", "getLastInfo", "forEachMiddleInfo", "", "block", "Lkotlin/Function1;", "shouldRecomputeSelection", "other", "shouldAnyInfoRecomputeSelection", "createSubSelections", "Landroidx/collection/LongObjectMap;", "selection", "createAndPutSubSelection", "Landroidx/collection/MutableLongObjectMap;", "info", "minOffset", "maxOffset", "toString", "", "startOrEndSlotToIndex", "slot", "isStartSlot", "slotToIndex", "isMinimumSlot", "getInfoListIndexBySelectableId", "id", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MultiSelectionLayout implements SelectionLayout {
    private final int endSlot;
    private final List<SelectableInfo> infoList;
    private final boolean isStartHandle;
    private final Selection previousSelection;
    private final LongIntMap selectableIdToInfoListIndex;
    private final int startSlot;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[CrossStatus.values().length];
            r0[CrossStatus.COLLAPSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CrossStatus.NOT_CROSSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CrossStatus.CROSSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ Unit a(MultiSelectionLayout r0, MutableLongObjectMap r1, Selection r2, SelectableInfo r3) {
        return createSubSelections$lambda$5$lambda$3(r0, r1, r2, r3);
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getEndInfo() {
        return (SelectableInfo) ListProtector.get(this.infoList, startOrEndSlotToIndex(getEndSlot(), false));
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getSize() {
        return this.infoList.size();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getStartInfo() {
        return (SelectableInfo) ListProtector.get(this.infoList, startOrEndSlotToIndex(getStartSlot(), true));
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("MultiSelectionLayout(isStartHandle=");
        r0.append(isStartHandle());
        r0.append(", startPosition=");
        boolean r2 = true;
        float r3 = 2;
        r0.append((getStartSlot() + 1) / r3);
        r0.append(", endPosition=");
        r0.append((getEndSlot() + 1) / r3);
        r0.append(", crossed=");
        r0.append(getCrossStatus());
        r0.append(", infos=");
        StringBuilder r1 = new StringBuilder("[\n\t");
        List<SelectableInfo> r4 = this.infoList;
        int r5 = r4.size();
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L9;
        SelectableInfo r7 = (SelectableInfo) ListProtector.get(r4, r6);
        if (r2 == false) goto L7;
        r2 = false;
    L8:
        StringBuilder r8 = new StringBuilder();
        r6 = r6 + 1;
        r8.append(r6);
        r8.append(" -> ");
        r8.append(r7);
        r1.append(r8.toString());
        goto L3
    L7:
        r1.append(",\n\t");
        goto L8
    L9:
        r1.append("\n]");
        r0.append(r1.toString());
        r0.append(')');
        return r0.toString();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public CrossStatus getCrossStatus() {
        if (getStartSlot() >= getEndSlot()) goto L6;
        return CrossStatus.NOT_CROSSED;
    L6:
        if (getStartSlot() <= getEndSlot()) goto L9;
        return CrossStatus.CROSSED;
    L9:
        return ((SelectableInfo) ListProtector.get(this.infoList, getStartSlot() / 2)).getRawCrossStatus();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getCurrentInfo() {
        if (isStartHandle() == false) goto L6;
        return getStartInfo();
    L6:
        return getEndInfo();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getFirstInfo() {
        if (getCrossStatus() != CrossStatus.CROSSED) goto L6;
        return getEndInfo();
    L6:
        return getStartInfo();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo getLastInfo() {
        if (getCrossStatus() != CrossStatus.CROSSED) goto L6;
        return getStartInfo();
    L6:
        return getEndInfo();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getEndSlot() {
        return this.endSlot;
    }

    public final List<SelectableInfo> getInfoList() {
        return this.infoList;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public Selection getPreviousSelection() {
        return this.previousSelection;
    }

    public final LongIntMap getSelectableIdToInfoListIndex() {
        return this.selectableIdToInfoListIndex;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getStartSlot() {
        return this.startSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean isStartHandle() {
        return this.isStartHandle;
    }

    private final int getInfoListIndexBySelectableId(long r5) {
        return this.selectableIdToInfoListIndex.get(r5);
    L4:
        e = move-exception;
        throw new IllegalStateException("Invalid selectableId: " + r5, e);
    }

    private final boolean shouldAnyInfoRecomputeSelection(MultiSelectionLayout r7) {
        if (getSize() == r7.getSize()) goto L5;
        return true;
    L5:
        int r0 = this.infoList.size();
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L11;
        if (((SelectableInfo) ListProtector.get(this.infoList, r3)).shouldRecomputeSelection((SelectableInfo) ListProtector.get(r7.infoList, r3)) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public LongObjectMap<Selection> createSubSelections(final Selection r8) {
        if (r8.getStart().getSelectableId() == r8.getEnd().getSelectableId()) goto L5;
        final MutableLongObjectMap<Selection> r6 = LongObjectMapKt.mutableLongObjectMapOf();
        if (r8.getHandlesCrossed() == false) goto L20;
        Selection.AnchorInfo r0 = r8.getEnd();
    L21:
        createAndPutSubSelection(r6, r8, getFirstInfo(), r0.getOffset(), getFirstInfo().getTextLength());
        forEachMiddleInfo(new i(this, r6, r8));
        if (r8.getHandlesCrossed() == false) goto L24;
        Selection.AnchorInfo r1 = r8.getStart();
    L25:
        createAndPutSubSelection(r6, r8, getLastInfo(), 0, r1.getOffset());
        return r6;
    L24:
        r1 = r8.getEnd();
        goto L25
    L20:
        r0 = r8.getStart();
        goto L21
    L5:
        if (r8.getHandlesCrossed() == false) goto L9;
        if (r8.getStart().getOffset() < r8.getEnd().getOffset()) goto L9;
    L12:
        boolean r2 = true;
    L14:
        if (r2 == true) goto L27;
        InlineClassHelperKt.throwIllegalStateException("unexpectedly miss-crossed selection: " + r8);
    L27:
        return LongObjectMapKt.longObjectMapOf(r8.getStart().getSelectableId(), r8);
    L9:
        if (r8.getHandlesCrossed() == false) goto L11;
    L13:
        r2 = false;
        goto L14
    L11:
        if (r8.getStart().getOffset() > r8.getEnd().getOffset()) goto L13;
        goto L12
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public void forEachMiddleInfo(Function1<? super SelectableInfo, Unit> r4) {
        int r0 = getInfoListIndexBySelectableId(getFirstInfo().getSelectableId());
        int r1 = getInfoListIndexBySelectableId(getLastInfo().getSelectableId());
        int r2 = r0 + 1;
        if (r2 < r1) goto L5;
        return;
    L5:
        if (r2 >= r1) goto L7;
        r4.invoke(ListProtector.get(this.infoList, r2));
        r2 = r2 + 1;
        goto L5
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean shouldRecomputeSelection(SelectionLayout r3) {
        if (getPreviousSelection() == null) goto L17;
        if (r3 == null) goto L17;
        if ((r3 instanceof MultiSelectionLayout) == false) goto L17;
        MultiSelectionLayout r4 = (MultiSelectionLayout) r3;
        if (isStartHandle() != r4.isStartHandle()) goto L17;
        if (getStartSlot() != r4.getStartSlot()) goto L17;
        if (getEndSlot() != r4.getEndSlot()) goto L17;
        if (shouldAnyInfoRecomputeSelection(r4) == true) goto L17;
        return false;
    L17:
        return true;
    }

    private final int slotToIndex(int r1, boolean r2) {
        return (r1 - (!r2 ? 1 : 0)) / 2;
    }

    private final int startOrEndSlotToIndex(int r4, boolean r5) {
        CrossStatus r0 = getCrossStatus();
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
    L13:
        r5 = true;
    L15:
        return slotToIndex(r4, r5);
    L5:
        if (r1 == 2) goto L15;
        if (r1 != 3) goto L12;
        if (r5 == false) goto L13;
        r5 = false;
        goto L15
    L12:
        throw new NoWhenBranchMatchedException();
    }

    private static final Unit createSubSelections$lambda$5$lambda$3(MultiSelectionLayout r6, MutableLongObjectMap r7, Selection r8, SelectableInfo r9) {
        r6.createAndPutSubSelection(r7, r8, r9, 0, r9.getTextLength());
        return Unit.INSTANCE;
    }

    private final void createAndPutSubSelection(MutableLongObjectMap<Selection> r1, Selection r2, SelectableInfo r3, int r4, int r5) {
        if (r2.getHandlesCrossed() == false) goto L5;
        Selection r6 = r3.makeSingleLayoutSelection(r5, r4);
    L6:
        if (r4 > r5) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == true) goto L11;
        InlineClassHelperKt.throwIllegalStateException("minOffset should be less than or equal to maxOffset: " + r6);
    L11:
        r1.put(r3.getSelectableId(), r6);
        return;
    L8:
        r7 = false;
        goto L9
    L5:
        r6 = r3.makeSingleLayoutSelection(r4, r5);
        goto L6
    }

    public MultiSelectionLayout(LongIntMap r1, List<SelectableInfo> r2, int r3, int r4, boolean r5, Selection r6) {
        this.selectableIdToInfoListIndex = r1;
        this.infoList = r2;
        this.startSlot = r3;
        this.endSlot = r4;
        this.isStartHandle = r5;
        this.previousSelection = r6;
        boolean r7 = true;
        if (r2.size() > 1) goto L6;
        r7 = false;
    L6:
        if (r7 == true) goto L9;
        InlineClassHelperKt.throwIllegalStateException("MultiSelectionLayout requires an infoList size greater than 1, was " + r2.size() + '.');
        return;
    }
}
