package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ4\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\f\u0010 \u001a\u00020\u001f*\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "", "reverseScrolling", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZ)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "isVertical", "collectionInfo", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "()Landroidx/compose/ui/semantics/CollectionInfo;", "scrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "indexForKeyMapping", "Lkotlin/Function1;", "", "", "scrollToIndexAction", "update", "", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "updateCachedSemanticsValues", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LazyLayoutSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {
    private final Function1<Object, Integer> indexForKeyMapping;
    private Function0<? extends LazyLayoutItemProvider> itemProviderLambda;
    private Orientation orientation;
    private boolean reverseScrolling;
    private ScrollAxisRange scrollAxisRange;
    private Function1<? super Integer, Boolean> scrollToIndexAction;
    private LazyLayoutSemanticState state;
    private boolean userScrollEnabled;

    public static /* synthetic */ boolean a(LazyLayoutSemanticsModifierNode r0, int r1) {
        return updateCachedSemanticsValues$lambda$6(r0, r1);
    }

    public static /* synthetic */ float b(LazyLayoutSemanticsModifierNode r0) {
        return updateCachedSemanticsValues$lambda$4(r0);
    }

    public static /* synthetic */ Float c(LazyLayoutSemanticsModifierNode r0) {
        return applySemantics$lambda$2(r0);
    }

    public static /* synthetic */ float d(LazyLayoutSemanticsModifierNode r0) {
        return updateCachedSemanticsValues$lambda$3(r0);
    }

    public static /* synthetic */ int e(LazyLayoutSemanticsModifierNode r0, Object r1) {
        return indexForKeyMapping$lambda$0(r0, r1);
    }

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldClearDescendantSemantics(this);
    }

    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public final /* synthetic */ boolean isImportantForBounds() {
        return SemanticsModifierNode.-CC.$default$isImportantForBounds(this);
    }

    private final CollectionInfo getCollectionInfo() {
        return this.state.collectionInfo();
    }

    private final boolean isVertical() {
        if (this.orientation != Orientation.Vertical) goto L5;
        return true;
    L5:
        return false;
    }

    private final void updateCachedSemanticsValues() {
        this.scrollAxisRange = new ScrollAxisRange(new a0(this), new b0(this), this.reverseScrolling);
        if (this.userScrollEnabled == false) goto L5;
        Function1<? super Integer, Boolean> r0 = new c0(this);
    L6:
        this.scrollToIndexAction = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static final /* synthetic */ LazyLayoutSemanticState access$getState$p(LazyLayoutSemanticsModifierNode r0) {
        return r0.state;
    }

    private static final Float applySemantics$lambda$2(LazyLayoutSemanticsModifierNode r1) {
        return Float.valueOf(r1.state.getViewport() - r1.state.getContentPadding());
    }

    private static final float updateCachedSemanticsValues$lambda$3(LazyLayoutSemanticsModifierNode r0) {
        return r0.state.getScrollOffset();
    }

    private static final float updateCachedSemanticsValues$lambda$4(LazyLayoutSemanticsModifierNode r0) {
        return r0.state.getMaxScrollOffset();
    }

    public void applySemantics(SemanticsPropertyReceiver r5) {
        SemanticsPropertiesKt.setTraversalGroup(r5, true);
        SemanticsPropertiesKt.indexForKey(r5, this.indexForKeyMapping);
        if (isVertical() == false) goto L8;
        ScrollAxisRange r1 = this.scrollAxisRange;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("scrollAxisRange");
        r1 = null;
    L7:
        SemanticsPropertiesKt.setVerticalScrollAxisRange(r5, r1);
    L12:
        Function1<? super Integer, Boolean> r2 = this.scrollToIndexAction;
        if (r2 == null) goto L15;
        SemanticsPropertiesKt.scrollToIndex$default(r5, null, r2, 1, null);
    L15:
        SemanticsPropertiesKt.getScrollViewportLength$default(r5, null, new y(this), 1, null);
        SemanticsPropertiesKt.setCollectionInfo(r5, getCollectionInfo());
        return;
    L8:
        ScrollAxisRange r3 = this.scrollAxisRange;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("scrollAxisRange");
        r3 = null;
    L11:
        SemanticsPropertiesKt.setHorizontalScrollAxisRange(r5, r3);
        goto L12
    }

    private static final int indexForKeyMapping$lambda$0(LazyLayoutSemanticsModifierNode r3, Object r4) {
        LazyLayoutItemProvider r5 = (LazyLayoutItemProvider) r3.itemProviderLambda.invoke();
        int r0 = r5.getItemCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (Intrinsics.areEqual(r5.getKey(r1), r4) == true) goto L12;
        r1 = r1 + 1;
        goto L3
    L12:
        return r1;
    L8:
        return -1;
    }

    private static final boolean updateCachedSemanticsValues$lambda$6(LazyLayoutSemanticsModifierNode r8, int r9) {
        LazyLayoutItemProvider r0 = (LazyLayoutItemProvider) r8.itemProviderLambda.invoke();
        if (r9 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("Can't scroll to index " + r9 + ", it is out of bounds [0, " + r0.getItemCount() + ')');
    L10:
        BuildersKt.launch$default(r8.getCoroutineScope(), null, null, new LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2(r8, r9, null), 3, null);
        return true;
    L5:
        if (r9 >= r0.getItemCount()) goto L7;
        r2 = true;
        goto L8
    }

    public LazyLayoutSemanticsModifierNode(Function0<? extends LazyLayoutItemProvider> r1, LazyLayoutSemanticState r2, Orientation r3, boolean r4, boolean r5) {
        this.itemProviderLambda = r1;
        this.state = r2;
        this.orientation = r3;
        this.userScrollEnabled = r4;
        this.reverseScrolling = r5;
        this.indexForKeyMapping = new z(this);
        updateCachedSemanticsValues();
    }

    public final void update(Function0<? extends LazyLayoutItemProvider> r1, LazyLayoutSemanticState r2, Orientation r3, boolean r4, boolean r5) {
        this.itemProviderLambda = r1;
        this.state = r2;
        if (this.orientation == r3) goto L6;
        this.orientation = r3;
        SemanticsModifierNodeKt.invalidateSemantics(this);
    L6:
        if (this.userScrollEnabled == r4) goto L8;
    L9:
        this.userScrollEnabled = r4;
        this.reverseScrolling = r5;
        updateCachedSemanticsValues();
        SemanticsModifierNodeKt.invalidateSemantics(this);
        return;
    L8:
        if (this.reverseScrolling != r5) goto L9;
    }
}
