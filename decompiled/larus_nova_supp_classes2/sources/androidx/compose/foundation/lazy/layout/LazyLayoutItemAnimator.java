package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003KLMB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0082\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\t\u001a\u00020\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0006\u0010-\u001a\u00020\u0019J\b\u0010.\u001a\u00020\u0019H\u0002J1\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00020\f2\u0012\b\u0002\u00102\u001a\f0\bR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0002\u00103J\u001f\u00104\u001a\u00020\u00192\u0006\u00100\u001a\u00028\u00002\b\b\u0002\u00105\u001a\u00020!H\u0002¢\u0006\u0002\u00106J\u0018\u00107\u001a\u0004\u0018\u00010\u00152\u0006\u0010,\u001a\u00020\u00032\u0006\u00108\u001a\u00020\fJ\u0019\u00109\u001a\u00020\f*\u00020:2\u0006\u00100\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010;R$\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f0\bR\b\u0012\u0004\u0012\u00028\u00000\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010<\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0018\u0010D\u001a\u00020!*\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0018\u00101\u001a\u00020\f*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0018\u0010I\u001a\u00020\f*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010H¨\u0006N"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "T", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "<init>", "()V", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "firstVisibleIndex", "", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingInFromStartBound", "", "movingInFromEndBound", "movingAwayToStartBound", "movingAwayToEndBound", "disappearingItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "displayingNode", "Landroidx/compose/ui/node/DrawModifierNode;", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "isVertical", "", "isLookingAhead", "laneCount", "hasLookaheadOccurred", "layoutMinOffset", "layoutMaxOffset", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "removeInfoForKey", "key", "reset", "releaseAnimations", "initializeAnimation", "item", "mainAxisOffset", "itemInfo", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;ILandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;)V", "startPlacementAnimationsIfNeeded", "isMovingAway", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Z)V", "getAnimation", "placeableIndex", "updateAndReturnOffsetFor", "", "([ILandroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "minSizeToFitDisappearingItems", "Landroidx/compose/ui/unit/IntSize;", "getMinSizeToFitDisappearingItems-YbymL2g", "()J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "hasAnimations", "getHasAnimations", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)Z", "getMainAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "crossAxisOffset", "getCrossAxisOffset", "ItemInfo", "DisplayingDisappearingItemsElement", "DisplayingDisappearingItemsNode", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutItemAnimator<T extends LazyLayoutMeasuredItem> {
    public static final int $stable = 8;
    private final List<LazyLayoutItemAnimation> disappearingItems;
    private DrawModifierNode displayingNode;
    private int firstVisibleIndex;
    private LazyLayoutKeyIndexMap keyIndexMap;
    private final MutableScatterMap<Object, LazyLayoutItemAnimator<T>.ItemInfo> keyToItemInfoMap;
    private final Modifier modifier;
    private final MutableScatterSet<Object> movingAwayKeys;
    private final List<T> movingAwayToEndBound;
    private final List<T> movingAwayToStartBound;
    private final List<T> movingInFromEndBound;
    private final List<T> movingInFromStartBound;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\f\u0010\u000b\u001a\u00020\t*\u00020\fH\u0016J\r\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DisplayingDisappearingItemsElement extends ModifierNodeElement<DisplayingDisappearingItemsNode> {
        private final LazyLayoutItemAnimator<?> animator;

        private final LazyLayoutItemAnimator<?> component1() {
            return this.animator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DisplayingDisappearingItemsElement copy$default(DisplayingDisappearingItemsElement r0, LazyLayoutItemAnimator r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.animator;
        L6:
            return r0.copy(r1);
        }

        public final DisplayingDisappearingItemsElement copy(LazyLayoutItemAnimator<?> r2) {
            return new DisplayingDisappearingItemsElement(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof DisplayingDisappearingItemsElement) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsElement) r4).animator) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        public String toString() {
            return "DisplayingDisappearingItemsElement(animator=" + this.animator + ')';
        }

        public DisplayingDisappearingItemsNode create() {
            return new DisplayingDisappearingItemsNode(this.animator);
        }

        /* JADX INFO: renamed from: create, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Modifier.Node m1153create() {
            return create();
        }

        public DisplayingDisappearingItemsElement(LazyLayoutItemAnimator<?> r1) {
            this.animator = r1;
        }

        public void inspectableProperties(InspectorInfo r2) {
            r2.setName("DisplayingDisappearingItemsElement");
        }

        public void update(DisplayingDisappearingItemsNode r2) {
            r2.setAnimator(this.animator);
        }

        public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
            update((DisplayingDisappearingItemsNode) r1);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\b2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004J\r\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onAttach", "onDetach", "setAnimator", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DisplayingDisappearingItemsNode extends Modifier.Node implements DrawModifierNode {
        private LazyLayoutItemAnimator<?> animator;

        private final LazyLayoutItemAnimator<?> component1() {
            return this.animator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DisplayingDisappearingItemsNode copy$default(DisplayingDisappearingItemsNode r0, LazyLayoutItemAnimator r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.animator;
        L6:
            return r0.copy(r1);
        }

        public final DisplayingDisappearingItemsNode copy(LazyLayoutItemAnimator<?> r2) {
            return new DisplayingDisappearingItemsNode(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof DisplayingDisappearingItemsNode) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsNode) r4).animator) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        public final /* synthetic */ void onMeasureResultChanged() {
            DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
        }

        public String toString() {
            return "DisplayingDisappearingItemsNode(animator=" + this.animator + ')';
        }

        public void onAttach() {
            LazyLayoutItemAnimator.access$setDisplayingNode$p(this.animator, this);
        }

        public void onDetach() {
            this.animator.reset();
        }

        public DisplayingDisappearingItemsNode(LazyLayoutItemAnimator<?> r1) {
            this.animator = r1;
        }

        public void draw(ContentDrawScope r9) {
            List r0 = LazyLayoutItemAnimator.access$getDisappearingItems$p(this.animator);
            int r1 = r0.size();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L14;
            LazyLayoutItemAnimation r3 = (LazyLayoutItemAnimation) ListProtector.get(r0, r2);
            GraphicsLayer r4 = r3.getLayer();
            if (r4 == null) goto L10;
            float r5 = IntOffset.getX-impl(r3.m1144getFinalOffsetnOccac());
            float r6 = IntOffset.getY-impl(r3.m1144getFinalOffsetnOccac());
            float r7 = r5 - IntOffset.getX-impl(r4.getTopLeft-nOcc-ac());
            float r8 = r6 - IntOffset.getY-impl(r4.getTopLeft-nOcc-ac());
            r9.getDrawContext().getTransform().translate(r7, r8);
            GraphicsLayerKt.drawLayer(r9, r4);     // Catch: Throwable -> L11
            r9.getDrawContext().getTransform().translate(-r7, -r8);
        L11:
            th = move-exception;
            r9.getDrawContext().getTransform().translate(-r7, -r8);
            throw th;
        L10:
            r2 = r2 + 1;
            goto L3
        L14:
            r9.drawContent();
        }

        public final void setAnimator(LazyLayoutItemAnimator<?> r2) {
            if (Intrinsics.areEqual(this.animator, r2) == false) goto L5;
            return;
        L5:
            if (getNode().isAttached() == false) goto L9;
            this.animator.reset();
            LazyLayoutItemAnimator.access$setDisplayingNode$p(r2, this);
            this.animator = r2;
            return;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010+R0\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u001e\u0010 \u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u001e\u0010\"\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014¨\u0006,"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "value", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "animations", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "setConstraints-_Sx5XlM", "(Landroidx/compose/ui/unit/Constraints;)V", "crossAxisOffset", "", "getCrossAxisOffset", "()I", "setCrossAxisOffset", "(I)V", "lane", "getLane", "setLane", "span", "getSpan", "setSpan", "isRunningPlacement", "", "()Z", "layoutMinOffset", "getLayoutMinOffset", "layoutMaxOffset", "getLayoutMaxOffset", "updateAnimation", "", "positionedItem", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;III)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class ItemInfo {
        private LazyLayoutItemAnimation[] animations;
        private Constraints constraints;
        private int crossAxisOffset;
        private int lane;
        private int layoutMaxOffset;
        private int layoutMinOffset;
        private int span;
        final /* synthetic */ LazyLayoutItemAnimator<T> this$0;

        public static /* synthetic */ Unit a(LazyLayoutItemAnimator r0) {
            return updateAnimation$lambda$3$lambda$1(r0);
        }

        private final boolean isRunningPlacement() {
            LazyLayoutItemAnimation[] r0 = this.animations;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L16;
            LazyLayoutItemAnimation r4 = r0[r3];
            if (r4 != null) goto L7;
        L9:
            boolean r5 = false;
        L10:
            if (r5 == true) goto L11;
            r3 = r3 + 1;
            goto L3
        L11:
            return true;
        L7:
            if (r4.isRunningMovingAwayAnimation() != true) goto L9;
            r5 = true;
            goto L10
        L16:
            return false;
        }

        public final LazyLayoutItemAnimation[] getAnimations() {
            return this.animations;
        }

        /* JADX INFO: renamed from: getConstraints-DWUhwKw, reason: not valid java name */
        public final Constraints m1154getConstraintsDWUhwKw() {
            return this.constraints;
        }

        public final int getCrossAxisOffset() {
            return this.crossAxisOffset;
        }

        public final int getLane() {
            return this.lane;
        }

        public final int getLayoutMaxOffset() {
            return this.layoutMaxOffset;
        }

        public final int getLayoutMinOffset() {
            return this.layoutMinOffset;
        }

        public final int getSpan() {
            return this.span;
        }

        public ItemInfo(LazyLayoutItemAnimator r1) {
            this.this$0 = r1;
            this.animations = LazyLayoutItemAnimatorKt.access$getEmptyArray$p();
            this.span = 1;
        }

        private static final Unit updateAnimation$lambda$3$lambda$1(LazyLayoutItemAnimator r0) {
            DrawModifierNode r1 = LazyLayoutItemAnimator.access$getDisplayingNode$p(r0);
            if (r1 == null) goto L6;
            DrawModifierNodeKt.invalidateDraw(r1);
        L6:
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: setConstraints-_Sx5XlM, reason: not valid java name */
        public final void m1155setConstraints_Sx5XlM(Constraints r1) {
            this.constraints = r1;
        }

        public final void setCrossAxisOffset(int r1) {
            this.crossAxisOffset = r1;
        }

        public final void setLane(int r1) {
            this.lane = r1;
        }

        public final void setSpan(int r1) {
            this.span = r1;
        }

        public final void updateAnimation(T r4, CoroutineScope r5, GraphicsContext r6, int r7, int r8, int r9) {
            if (isRunningPlacement() == true) goto L5;
            this.layoutMinOffset = r7;
            this.layoutMaxOffset = r8;
        L5:
            int r10 = r4.getPlaceablesCount();
            int r11 = this.animations.length;
        L6:
            if (r10 >= r11) goto L12;
            LazyLayoutItemAnimation r0 = this.animations[r10];
            if (r0 == null) goto L10;
            r0.release();
        L10:
            r10 = r10 + 1;
            goto L6
        L12:
            if (this.animations.length == r4.getPlaceablesCount()) goto L14;
            this.animations = (LazyLayoutItemAnimation[]) Arrays.copyOf(this.animations, r4.getPlaceablesCount());
        L14:
            this.constraints = Constraints.box-impl(r4.mo1092getConstraintsmsEJaDk());
            this.crossAxisOffset = r9;
            this.lane = r4.getLane();
            this.span = r4.getSpan();
            int r12 = r4.getPlaceablesCount();
            final LazyLayoutItemAnimator<T> r13 = this.this$0;
            int r14 = 0;
        L15:
            if (r14 >= r12) goto L27;
            LazyLayoutAnimationSpecsNode r1 = LazyLayoutItemAnimatorKt.access$getSpecs(r4.getParentData(r14));
            if (r1 != null) goto L22;
            LazyLayoutItemAnimation r2 = this.animations[r14];
            if (r2 == null) goto L21;
            r2.release();
        L21:
            this.animations[r14] = null;
        L26:
            r14 = r14 + 1;
            goto L15
        L22:
            LazyLayoutItemAnimation r3 = this.animations[r14];
            if (r3 != null) goto L25;
            r3 = new LazyLayoutItemAnimation(r5, r6, new i(r13));
            this.animations[r14] = r3;
        L25:
            r3.setFadeInSpec(r1.getFadeInSpec());
            r3.setPlacementSpec(r1.getPlacementSpec());
            r3.setFadeOutSpec(r1.getFadeOutSpec());
            goto L26
        }

        public static /* synthetic */ void updateAnimation$default(ItemInfo r7, LazyLayoutMeasuredItem r8, CoroutineScope r9, GraphicsContext r10, int r11, int r12, int r13, int r14, Object r15) {
            if ((r14 & 32) == 0) goto L5;
            r13 = LazyLayoutItemAnimator.access$getCrossAxisOffset(r7.this$0, r8);
        L5:
            r7.updateAnimation(r8, r9, r10, r11, r12, r13);
        }
    }

    private final void releaseAnimations() {
        if (this.keyToItemInfoMap.isNotEmpty() == false) goto L35;
        MutableScatterMap<Object, LazyLayoutItemAnimator<T>.ItemInfo> r0 = this.keyToItemInfoMap;
        Object[] r1 = r0.values;
        long[] r2 = r0.metadata;
        int r3 = r2.length - 2;
        if (r3 < 0) goto L26;
        int r4 = 0;
    L7:
        long r5 = r2[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L24;
        int r7 = 8 - ((~(r4 - r3)) >>> 31);
        int r9 = 0;
    L10:
        if (r9 >= r7) goto L23;
        if ((255 & r5) >= 128) goto L14;
        boolean r10 = true;
    L15:
        if (r10 == false) goto L22;
        LazyLayoutItemAnimation[] r11 = ((ItemInfo) r1[(r4 << 3) + r9]).getAnimations();
        int r12 = r11.length;
        int r13 = 0;
    L17:
        if (r13 >= r12) goto L22;
        LazyLayoutItemAnimation r14 = r11[r13];
        if (r14 == null) goto L21;
        r14.release();
    L21:
        r13 = r13 + 1;
    L22:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L10
    L14:
        r10 = false;
        goto L15
    L23:
        if (r7 != 8) goto L26;
    L24:
        if (r4 == r3) goto L26;
        r4 = r4 + 1;
    L26:
        this.keyToItemInfoMap.clear();
        return;
    }

    /* JADX INFO: renamed from: getMinSizeToFitDisappearingItems-YbymL2g, reason: not valid java name */
    public final long m1152getMinSizeToFitDisappearingItemsYbymL2g() {
        long r0 = IntSize.Companion.getZero-YbymL2g();
        List<LazyLayoutItemAnimation> r2 = this.disappearingItems;
        int r3 = r2.size();
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L8;
        LazyLayoutItemAnimation r5 = (LazyLayoutItemAnimation) ListProtector.get(r2, r4);
        GraphicsLayer r6 = r5.getLayer();
        if (r6 == null) goto L7;
        int r8 = Math.max((int) (r0 >> 32), IntOffset.getX-impl(r5.m1147getRawOffsetnOccac()) + ((int) (r6.getSize-YbymL2g() >> 32)));
        int r1 = Math.max((int) (r0 & 4294967295L), IntOffset.getY-impl(r5.m1147getRawOffsetnOccac()) + ((int) (r6.getSize-YbymL2g() & 4294967295L)));
        long r7 = ((long) r1) & 4294967295L;
        r0 = IntSize.constructor-impl(r7 | (((long) r8) << 32));
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r0;
    }

    public LazyLayoutItemAnimator() {
        this.keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
        this.movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
        this.movingInFromStartBound = new ArrayList();
        this.movingInFromEndBound = new ArrayList();
        this.movingAwayToStartBound = new ArrayList();
        this.movingAwayToEndBound = new ArrayList();
        this.disappearingItems = new ArrayList();
        this.modifier = new DisplayingDisappearingItemsElement(this);
    }

    public final void reset() {
        releaseAnimations();
        this.keyIndexMap = null;
        this.firstVisibleIndex = -1;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public static final /* synthetic */ List access$getDisappearingItems$p(LazyLayoutItemAnimator r0) {
        return r0.disappearingItems;
    }

    public static final /* synthetic */ DrawModifierNode access$getDisplayingNode$p(LazyLayoutItemAnimator r0) {
        return r0.displayingNode;
    }

    private final int getCrossAxisOffset(LazyLayoutMeasuredItem r3) {
        long r0 = r3.mo1093getOffsetBjo55l4(0);
        if (r3.isVertical() == true) goto L6;
        return IntOffset.getY-impl(r0);
    L6:
        return IntOffset.getX-impl(r0);
    }

    private final boolean getHasAnimations(T r5) {
        int r0 = r5.getPlaceablesCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (LazyLayoutItemAnimatorKt.access$getSpecs(r5.getParentData(r2)) != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private final int getMainAxisOffset(LazyLayoutMeasuredItem r3) {
        long r0 = r3.mo1093getOffsetBjo55l4(0);
        if (r3.isVertical() == false) goto L6;
        return IntOffset.getY-impl(r0);
    L6:
        return IntOffset.getX-impl(r0);
    }

    private final void removeInfoForKey(Object r4) {
        LazyLayoutItemAnimator<T>.ItemInfo r5 = this.keyToItemInfoMap.remove(r4);
        if (r5 == null) goto L12;
        LazyLayoutItemAnimation[] r6 = r5.getAnimations();
        if (r6 == null) goto L16;
        int r0 = r6.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L17;
        LazyLayoutItemAnimation r2 = r6[r1];
        if (r2 == null) goto L11;
        r2.release();
    L11:
        r1 = r1 + 1;
        goto L7
    L17:
        return;
    L16:
        return;
    }

    public static final /* synthetic */ int access$getCrossAxisOffset(LazyLayoutItemAnimator r0, LazyLayoutMeasuredItem r1) {
        return r0.getCrossAxisOffset(r1);
    }

    public static final /* synthetic */ void access$setDisplayingNode$p(LazyLayoutItemAnimator r0, DrawModifierNode r1) {
        r0.displayingNode = r1;
    }

    private final void startPlacementAnimationsIfNeeded(T r13, boolean r14) {
        LazyLayoutItemAnimator<T>.ItemInfo r0 = this.keyToItemInfoMap.get(r13.getKey());
        Intrinsics.checkNotNull(r0);
        LazyLayoutItemAnimation[] r1 = r0.getAnimations();
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L13;
        LazyLayoutItemAnimation r5 = r1[r3];
        int r6 = r4 + 1;
        if (r5 == null) goto L12;
        long r7 = r13.mo1093getOffsetBjo55l4(r4);
        long r8 = r5.m1147getRawOffsetnOccac();
        if (IntOffset.equals-impl0(r8, LazyLayoutItemAnimation.Companion.m1151getNotInitializednOccac()) == false) goto L9;
    L11:
        r5.m1150setRawOffsetgyyYBs(r7);
        goto L12
    L9:
        if (IntOffset.equals-impl0(r8, r7) == true) goto L11;
        r5.m1143animatePlacementDeltaar5cAso(IntOffset.minus-qkQi6aY(r7, r8), r14);
    L12:
        r3 = r3 + 1;
        r4 = r6;
        goto L3
    }

    private final int updateAndReturnOffsetFor(int[] r6, T r7) {
        int r0 = r7.getLane();
        int r1 = r7.getSpan() + r0;
        int r2 = 0;
    L3:
        if (r0 >= r1) goto L5;
        int r3 = r6[r0] + r7.getMainAxisSizeWithSpacings();
        r6[r0] = r3;
        r2 = Math.max(r2, r3);
        r0 = r0 + 1;
        goto L3
    L5:
        return r2;
    }

    public final LazyLayoutItemAnimation getAnimation(Object r2, int r3) {
        LazyLayoutItemAnimator<T>.ItemInfo r4 = this.keyToItemInfoMap.get(r2);
        if (r4 == null) goto L7;
        LazyLayoutItemAnimation[] r5 = r4.getAnimations();
        if (r5 == null) goto L7;
        return r5[r3];
    L7:
        return null;
    }

    private final void initializeAnimation(T r12, int r13, LazyLayoutItemAnimator<T>.ItemInfo r14) {
        int r0 = 0;
        long r7 = r12.mo1093getOffsetBjo55l4(0);
        if (r12.isVertical() == false) goto L5;
        long r1 = IntOffset.copy-iSbpLlY$default(r7, 0, r13, 1, null);
    L6:
        LazyLayoutItemAnimation[] r15 = r14.getAnimations();
        int r16 = r15.length;
        int r3 = 0;
    L7:
        if (r0 >= r16) goto L12;
        LazyLayoutItemAnimation r4 = r15[r0];
        int r5 = r3 + 1;
        if (r4 == null) goto L11;
        r4.m1150setRawOffsetgyyYBs(IntOffset.plus-qkQi6aY(r1, IntOffset.minus-qkQi6aY(r12.mo1093getOffsetBjo55l4(r3), r7)));
    L11:
        r0 = r0 + 1;
        r3 = r5;
        goto L7
    L12:
        return;
    L5:
        r1 = IntOffset.copy-iSbpLlY$default(r7, r13, 0, 2, null);
        goto L6
    }

    public static /* synthetic */ void startPlacementAnimationsIfNeeded$default(LazyLayoutItemAnimator r0, LazyLayoutMeasuredItem r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.startPlacementAnimationsIfNeeded(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initializeAnimation$default(LazyLayoutItemAnimator r0, LazyLayoutMeasuredItem r1, int r2, LazyLayoutItemAnimator<T>.ItemInfo r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        LazyLayoutItemAnimator<T>.ItemInfo r6 = r0.keyToItemInfoMap.get(r1.getKey());
        Intrinsics.checkNotNull(r6);
        r3 = r6;
    L5:
        r0.initializeAnimation(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v3, types: [androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo] */
    /* JADX WARN: Type inference failed for: r15v9, types: [androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo] */
    /* JADX WARN: Type inference failed for: r23v10 */
    /* JADX WARN: Type inference failed for: r23v11 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r23v6, types: [androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo] */
    /* JADX WARN: Type inference failed for: r23v8 */
    /* JADX WARN: Type inference failed for: r23v9 */
    public final void onMeasured(int r34, int r35, int r36, List<T> r37, LazyLayoutKeyIndexMap r38, LazyLayoutMeasuredItemProvider<T> r39, boolean r40, boolean r41, int r42, boolean r43, int r44, int r45, CoroutineScope r46, GraphicsContext r47) {
        List<T> r9 = r37;
        final LazyLayoutKeyIndexMap r12 = this.keyIndexMap;
        this.keyIndexMap = r38;
        List<T> r1 = r9;
        int r2 = r1.size();
        int r13 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        if (getHasAnimations((LazyLayoutMeasuredItem) ListProtector.get(r9, r3)) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
    L14:
        int r5 = this.firstVisibleIndex;
        LazyLayoutMeasuredItem r6 = (LazyLayoutMeasuredItem) CollectionsKt.firstOrNull(r37);
        if (r6 == null) goto L17;
        int r7 = r6.getIndex();
    L18:
        this.firstVisibleIndex = r7;
        if (r40 == false) goto L21;
        long r8 = IntOffset.constructor-impl((4294967295L & ((long) r34)) | (((long) 0) << 32));
    L22:
        if (r41 == true) goto L26;
        if (r43 == false) goto L26;
        boolean r10 = false;
    L27:
        MutableScatterMap<Object, LazyLayoutItemAnimator<T>.ItemInfo> r0 = this.keyToItemInfoMap;
        Object[] r11 = r0.keys;
        long[] r14 = r0.metadata;
        int r15 = r14.length - 2;
        char r16 = 7;
        int r17 = 8;
        if (r15 < 0) goto L43;
    L29:
        long r18 = r14[r13];
        long r22 = r8;
        if (((((~r18) << r16) & r18) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L41;
        int r19 = 8 - ((~(r13 - r15)) >>> 31);
        int r20 = 0;
    L32:
        if (r20 >= r19) goto L40;
        if ((r18 & 255) >= 128) goto L36;
        boolean r24 = true;
    L37:
        if (r24 == false) goto L39;
        this.movingAwayKeys.add(r11[(r13 << 3) + r20]);
        r17 = 8;
    L39:
        r18 = r18 >> r17;
        r20 = r20 + 1;
        goto L32
    L36:
        r24 = false;
        goto L37
    L40:
        if (r19 == r17) goto L41;
    L44:
        int r21 = r1.size();
        int r23 = 0;
    L46:
        if (r23 >= r21) goto L107;
        LazyLayoutMeasuredItem r25 = (LazyLayoutMeasuredItem) ListProtector.get(r9, r23);
        this.movingAwayKeys.remove(r25.getKey());
        if (getHasAnimations(r25) == false) goto L105;
        LazyLayoutItemAnimator<T>.ItemInfo r26 = this.keyToItemInfoMap.get(r25.getKey());
        if (r12 == null) goto L52;
        int r27 = r12.getIndex(r25.getKey());
    L53:
        if (r27 != (-1)) goto L56;
        if (r12 == null) goto L56;
        boolean r110 = true;
    L57:
        if (r26 != null) goto L78;
        LazyLayoutItemAnimator<T>.ItemInfo r28 = new ItemInfo(this);
        ItemInfo.updateAnimation$default(r28, r25, r46, r47, r44, r45, 0, 32, null);
        this.keyToItemInfoMap.set(r25.getKey(), r28);
        if (r25.getIndex() == r27) goto L64;
        if (r27 == (-1)) goto L64;
        if (r27 >= r5) goto L63;
        this.movingInFromStartBound.add((T) r25);
    L77:
        long r111 = r22;
    L106:
        r23 = r23 + 1;
        r9 = r37;
        r22 = r111;
        goto L46
    L63:
        this.movingInFromEndBound.add((T) r25);
    L64:
        long r112 = r25.mo1093getOffsetBjo55l4(0);
        if (r25.isVertical() == false) goto L67;
        int r29 = IntOffset.getY-impl(r112);
    L68:
        initializeAnimation(r25, r29, r28);
        if (r110 == false) goto L76;
        LazyLayoutItemAnimation[] r30 = r28.getAnimations();
        int r31 = r30.length;
        int r32 = 0;
    L71:
        if (r32 >= r31) goto L76;
        LazyLayoutItemAnimation r33 = r30[r32];
        if (r33 == null) goto L75;
        r33.animateAppearance();
        Unit r48 = Unit.INSTANCE;
    L75:
        r32 = r32 + 1;
    L76:
        Unit r49 = Unit.INSTANCE;
        goto L77
    L67:
        r29 = IntOffset.getX-impl(r112);
        goto L68
    L78:
        if (r10 == false) goto L103;
        ItemInfo.updateAnimation$default(r26, r25, r46, r47, r44, r45, 0, 32, null);
        LazyLayoutItemAnimation[] r50 = r26.getAnimations();
        int r51 = r50.length;
        int r113 = 0;
    L80:
        if (r113 >= r51) goto L89;
        LazyLayoutItemAnimation r114 = r50[r113];
        if (r114 == null) goto L86;
        boolean r210 = r110;
        int r211 = r51;
        if (IntOffset.equals-impl0(r114.m1147getRawOffsetnOccac(), LazyLayoutItemAnimation.Companion.m1151getNotInitializednOccac()) == true) goto L87;
        long r115 = r22;
        r114.m1150setRawOffsetgyyYBs(IntOffset.plus-qkQi6aY(r114.m1147getRawOffsetnOccac(), r115));
    L88:
        r113 = r113 + 1;
        r22 = r115;
        r110 = r210;
        r51 = r211;
    L87:
        r115 = r22;
        goto L88
    L86:
        r211 = r51;
        r210 = r110;
        goto L87
    L89:
        r111 = r22;
        if (r110 == false) goto L102;
        LazyLayoutItemAnimation[] r52 = r26.getAnimations();
        int r53 = r52.length;
        int r54 = 0;
    L92:
        if (r54 >= r53) goto L102;
        LazyLayoutItemAnimation r55 = r52[r54];
        if (r55 == null) goto L101;
        if (r55.isDisappearanceAnimationInProgress() == false) goto L100;
        this.disappearingItems.remove(r55);
        DrawModifierNode r116 = this.displayingNode;
        if (r116 == null) goto L100;
        DrawModifierNodeKt.invalidateDraw(r116);
        Unit r117 = Unit.INSTANCE;
    L100:
        r55.animateAppearance();
    L101:
        r54 = r54 + 1;
    L102:
        startPlacementAnimationsIfNeeded$default(this, r25, false, 2, null);
    L104:
        Unit r56 = Unit.INSTANCE;
        goto L106
    L103:
        r111 = r22;
    L56:
        r110 = false;
        goto L57
    L52:
        r27 = -1;
        goto L53
    L105:
        r111 = r22;
        removeInfoForKey(r25.getKey());
        Unit r57 = Unit.INSTANCE;
        goto L106
    L107:
        int r58 = r42;
        int[] r118 = new int[r58];
        if (r10 == false) goto L128;
        if (r12 == null) goto L128;
        if ((!this.movingInFromStartBound.isEmpty()) == false) goto L120;
        List<T> r59 = this.movingInFromStartBound;
        if (r59.size() <= 1) goto L115;
        CollectionsKt.sortWith(r59, new LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$1(r12));
    L115:
        List<T> r119 = this.movingInFromStartBound;
        int r120 = r119.size();
        int r121 = 0;
    L116:
        if (r121 >= r120) goto L118;
        LazyLayoutMeasuredItem r60 = (LazyLayoutMeasuredItem) ListProtector.get(r119, r121);
        initializeAnimation$default(this, r60, r44 - updateAndReturnOffsetFor(r118, r60), null, 4, null);
        startPlacementAnimationsIfNeeded$default(this, r60, false, 2, null);
        r121 = r121 + 1;
        goto L116
    L118:
        ArraysKt.fill$default(r118, 0, 0, 0, 6, null);
    L120:
        if ((!this.movingInFromEndBound.isEmpty()) == false) goto L128;
        List<T> r61 = this.movingInFromEndBound;
        if (r61.size() <= 1) goto L124;
        CollectionsKt.sortWith(r61, new LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1(r12));
    L124:
        List<T> r122 = this.movingInFromEndBound;
        int r123 = r122.size();
        int r124 = 0;
    L125:
        if (r124 >= r123) goto L127;
        LazyLayoutMeasuredItem r62 = (LazyLayoutMeasuredItem) ListProtector.get(r122, r124);
        initializeAnimation$default(this, r62, (r45 + updateAndReturnOffsetFor(r118, r62)) - r62.getMainAxisSizeWithSpacings(), null, 4, null);
        startPlacementAnimationsIfNeeded$default(this, r62, false, 2, null);
        r124 = r124 + 1;
        goto L125
    L127:
        ArraysKt.fill$default(r118, 0, 0, 0, 6, null);
    L128:
        MutableScatterSet<Object> r63 = this.movingAwayKeys;
        Object[] r64 = r63.elements;
        long[] r65 = r63.metadata;
        int r66 = r65.length - 2;
        if (r66 < 0) goto L209;
        int r67 = 0;
    L131:
        long r68 = r65[r67];
        if (((((~r68) << 7) & r68) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L206;
        int r125 = 8 - ((~(r67 - r66)) >>> 31);
        int r126 = 0;
    L134:
        if (r126 >= r125) goto L203;
        if ((r68 & 255) >= 128) goto L138;
        boolean r212 = true;
    L139:
        if (r212 == false) goto L200;
        Object r127 = r64[(r67 << 3) + r126];
        LazyLayoutItemAnimator<T>.ItemInfo r128 = this.keyToItemInfoMap.get(r127);
        if (r128 != 0) goto L143;
        long[] r310 = r65;
        Object[] r311 = r64;
    L201:
        boolean r312 = r10;
    L202:
        r68 = r68 >> 8;
        r126 = r126 + 1;
        r58 = r42;
        r65 = r310;
        r64 = r311;
        r10 = r312;
        goto L134
    L143:
        r310 = r65;
        int r69 = r38.getIndex(r127);
        r311 = r64;
        r128.setSpan(Math.min(r58, r128.getSpan()));
        r128.setLane(Math.min(r58 - r128.getSpan(), r128.getLane()));
        if (r69 != (-1)) goto L175;
        LazyLayoutItemAnimation[] r70 = r128.getAnimations();
        int r71 = r70.length;
        int r72 = 0;
        int r213 = 0;
        boolean r214 = false;
        ?? r129 = r128;
    L146:
        if (r72 >= r71) goto L172;
        int r215 = r71;
        LazyLayoutItemAnimation r73 = r70[r72];
        int r216 = r213 + 1;
        if (r73 != null) goto L150;
        ?? r217 = r129;
    L170:
        r72 = r72 + 1;
        r129 = r217;
        r71 = r215;
        r213 = r216;
        goto L146
    L150:
        if (r73.isDisappearanceAnimationInProgress() == false) goto L153;
        Unit r74 = Unit.INSTANCE;
        r217 = r129;
        r214 = true;
        goto L170
    L153:
        if (r73.isDisappearanceAnimationFinished() == false) goto L157;
        r73.release();
        r129.getAnimations()[r213] = null;
        ?? r218 = r129;
        this.disappearingItems.remove(r73);
        DrawModifierNode r75 = this.displayingNode;
        r217 = r218;
        if (r75 == null) goto L170;
        DrawModifierNodeKt.invalidateDraw(r75);
        Unit r76 = Unit.INSTANCE;
        r217 = r218;
        goto L170
    L157:
        r217 = r129;
        if (r73.getLayer() == null) goto L161;
        r73.animateDisappearance();
    L161:
        if (r73.isDisappearanceAnimationInProgress() == false) goto L166;
        this.disappearingItems.add(r73);
        DrawModifierNode r77 = this.displayingNode;
        if (r77 == null) goto L165;
        DrawModifierNodeKt.invalidateDraw(r77);
        Unit r78 = Unit.INSTANCE;
    L165:
        r214 = true;
    L167:
        Unit r79 = Unit.INSTANCE;
        goto L170
    L166:
        r73.release();
        r217.getAnimations()[r213] = null;
        goto L167
    L172:
        if (r214 == true) goto L174;
        removeInfoForKey(r127);
    L174:
        Unit r80 = Unit.INSTANCE;
        goto L201
    L175:
        Constraints r81 = r128.m1154getConstraintsDWUhwKw();
        Intrinsics.checkNotNull(r81);
        LazyLayoutMeasuredItem r82 = r39.mo1095getAndMeasurehBUhpc(r69, r128.getLane(), r128.getSpan(), r81.unbox-impl());
        r82.setNonScrollableItem(true);
        LazyLayoutItemAnimation[] r130 = r128.getAnimations();
        int r83 = r130.length;
        r312 = r10;
        int r84 = 0;
    L176:
        if (r84 >= r83) goto L187;
        LazyLayoutItemAnimation r219 = r130[r84];
        int r220 = r83;
        if (r219 == null) goto L182;
        boolean r85 = r219.isPlacementAnimationInProgress();
        LazyLayoutItemAnimation[] r221 = r130;
        if (r85 != true) goto L183;
        boolean r86 = true;
    L184:
        if (r86 == true) goto L185;
        r84 = r84 + 1;
        r130 = r221;
        r83 = r220;
        goto L176
    L185:
        boolean r87 = true;
    L188:
        if (r87 == true) goto L196;
        if (r12 != null) goto L191;
    L193:
        boolean r88 = false;
    L194:
        if (r88 == false) goto L196;
        removeInfoForKey(r127);
        Unit r89 = Unit.INSTANCE;
        goto L202
    L191:
        if (r69 != r12.getIndex(r127)) goto L193;
        r88 = true;
    L196:
        r128.updateAnimation(r82, r46, r47, r44, r45, r128.getCrossAxisOffset());
        if (r69 >= this.firstVisibleIndex) goto L199;
        this.movingAwayToStartBound.add((T) r82);
        goto L202
    L199:
        this.movingAwayToEndBound.add((T) r82);
    L183:
        r86 = false;
        goto L184
    L182:
        r221 = r130;
        goto L183
    L187:
        r87 = false;
        goto L188
    L200:
        r310 = r65;
        r311 = r64;
        goto L201
    L138:
        r212 = false;
        goto L139
    L203:
        final LazyLayoutKeyIndexMap r90 = r38;
        long[] r313 = r65;
        Object[] r314 = r64;
        boolean r315 = r10;
        if (r125 != 8) goto L211;
    L207:
        if (r67 == r66) goto L211;
        r67 = r67 + 1;
        r58 = r42;
        r65 = r313;
        r64 = r314;
        r10 = r315;
    L211:
        if ((!this.movingAwayToStartBound.isEmpty()) == false) goto L228;
        List<T> r91 = this.movingAwayToStartBound;
        if (r91.size() <= 1) goto L215;
        CollectionsKt.sortWith(r91, new LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$2(r90));
    L215:
        List<T> r92 = this.movingAwayToStartBound;
        int r93 = r92.size();
        int r94 = 0;
    L216:
        if (r94 >= r93) goto L225;
        LazyLayoutMeasuredItem r95 = (LazyLayoutMeasuredItem) ListProtector.get(r92, r94);
        LazyLayoutItemAnimator<T>.ItemInfo r96 = this.keyToItemInfoMap.get(r95.getKey());
        Intrinsics.checkNotNull(r96);
        LazyLayoutItemAnimator<T>.ItemInfo r97 = r96;
        int r98 = updateAndReturnOffsetFor(r118, r95);
        if (r41 == false) goto L220;
        int r99 = getMainAxisOffset((LazyLayoutMeasuredItem) CollectionsKt.first(r37));
    L221:
        r95.position(r99 - r98, r97.getCrossAxisOffset(), r35, r36);
        if (r315 == false) goto L224;
        startPlacementAnimationsIfNeeded(r95, true);
    L224:
        r94 = r94 + 1;
        goto L216
    L220:
        r99 = r97.getLayoutMinOffset();
        goto L221
    L225:
        ArraysKt.fill$default(r118, 0, 0, 0, 6, null);
    L228:
        if ((!this.movingAwayToEndBound.isEmpty()) == false) goto L242;
        List<T> r100 = this.movingAwayToEndBound;
        if (r100.size() <= 1) goto L232;
        CollectionsKt.sortWith(r100, new LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$2(r90));
    L232:
        List<T> r101 = this.movingAwayToEndBound;
        int r102 = r101.size();
        int r103 = 0;
    L233:
        if (r103 >= r102) goto L242;
        LazyLayoutMeasuredItem r104 = (LazyLayoutMeasuredItem) ListProtector.get(r101, r103);
        LazyLayoutItemAnimator<T>.ItemInfo r105 = this.keyToItemInfoMap.get(r104.getKey());
        Intrinsics.checkNotNull(r105);
        LazyLayoutItemAnimator<T>.ItemInfo r106 = r105;
        int r107 = updateAndReturnOffsetFor(r118, r104);
        if (r41 == false) goto L237;
        LazyLayoutMeasuredItem r108 = (LazyLayoutMeasuredItem) CollectionsKt.last(r37);
        int r131 = getMainAxisOffset(r108) + r108.getMainAxisSizeWithSpacings();
    L238:
        r104.position((r131 - r104.getMainAxisSizeWithSpacings()) + r107, r106.getCrossAxisOffset(), r35, r36);
        if (r315 == false) goto L241;
        startPlacementAnimationsIfNeeded(r104, true);
    L241:
        r103 = r103 + 1;
        goto L233
    L237:
        r131 = r106.getLayoutMaxOffset();
    L242:
        List<T> r109 = this.movingAwayToStartBound;
        CollectionsKt.reverse(r109);
        Unit r132 = Unit.INSTANCE;
        r37.addAll(0, r109);
        r37.addAll(this.movingAwayToEndBound);
        this.movingInFromStartBound.clear();
        this.movingInFromEndBound.clear();
        this.movingAwayToStartBound.clear();
        this.movingAwayToEndBound.clear();
        this.movingAwayKeys.clear();
        return;
    L206:
        r90 = r38;
        r313 = r65;
        r314 = r64;
        r315 = r10;
        goto L207
    L209:
        r90 = r38;
        r315 = r10;
    L41:
        if (r13 == r15) goto L44;
        r13 = r13 + 1;
        r8 = r22;
        r17 = 8;
        r16 = 7;
        goto L29
    L43:
        r22 = r8;
    L26:
        r10 = true;
        goto L27
    L21:
        r8 = IntOffset.constructor-impl((4294967295L & ((long) 0)) | (((long) r34) << 32));
        goto L22
    L17:
        r7 = 0;
        goto L18
    L11:
        if (this.keyToItemInfoMap.isEmpty() == false) goto L14;
        releaseAnimations();
        return;
    L8:
        r4 = false;
        goto L9
    }
}
