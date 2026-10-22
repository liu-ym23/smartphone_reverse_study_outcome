package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 52\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00015B'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J:\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0019\u0010 \u001a\u0015\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u0001H\u001d0!¢\u0006\u0002\b#H\u0016¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\n*\u00020\u001fH\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\n*\u00020*2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002¢\u0006\u0004\b/\u00100J\u0013\u00101\u001a\u00020\n*\u00020\u001fH\u0002¢\u0006\u0004\b2\u0010(J&\u00103\u001a\u0002042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u00066"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "Landroidx/compose/ui/node/LayoutModifierNode;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/foundation/gestures/Orientation;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "layout", "T", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "isForward", "isForward-4vf7U8o", "(I)Z", "addNextInterval", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "currentInterval", "addNextInterval-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "hasMoreContent", "hasMoreContent-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Z", "isOppositeToOrientation", "isOppositeToOrientation-4vf7U8o", "update", "", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutBeyondBoundsModifierNode extends Modifier.Node implements ModifierLocalModifierNode, BeyondBoundsLayout, LayoutModifierNode {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final LazyLayoutBeyondBoundsModifierNode$Companion$emptyBeyondBoundsScope$1 emptyBeyondBoundsScope = null;
    private LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private Orientation orientation;
    private boolean reverseLayout;
    private LazyLayoutBeyondBoundsState state;

    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierNode$Companion;", "", "<init>", "()V", "emptyBeyondBoundsScope", "androidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierNode$Companion$emptyBeyondBoundsScope$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierNode$Companion$emptyBeyondBoundsScope$1;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LayoutDirection.values().length];
            r0[LayoutDirection.Ltr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LayoutDirection.Rtl.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ Unit a(Placeable r0, Placeable.PlacementScope r1) {
        return measure_3p2s80s$lambda$0(r0, r1);
    }

    public final /* synthetic */ Object getCurrent(ModifierLocal r1) {
        return ModifierLocalModifierNode.-CC.$default$getCurrent(this, r1);
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ void provide(ModifierLocal r1, Object r2) {
        ModifierLocalModifierNode.-CC.$default$provide(this, r1, r2);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierNode$Companion$emptyBeyondBoundsScope$1] */
    static {
        Companion = new Companion(null);
        $stable = 8;
        emptyBeyondBoundsScope = new LazyLayoutBeyondBoundsModifierNode$Companion$emptyBeyondBoundsScope$1();
    }

    public ModifierLocalMap getProvidedValues() {
        return ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout(), this));
    }

    /* JADX INFO: renamed from: isForward-4vf7U8o, reason: not valid java name */
    private final boolean m1135isForward4vf7U8o(int r6) {
        BeyondBoundsLayout.LayoutDirection.Companion r0 = BeyondBoundsLayout.LayoutDirection.Companion;
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0(r6, r0.getBefore-hoxUOeE()) == false) goto L6;
        return false;
    L6:
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0(r6, r0.getAfter-hoxUOeE()) == false) goto L9;
    L7:
        return true;
    L9:
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0(r6, r0.getAbove-hoxUOeE()) == false) goto L12;
        return this.reverseLayout;
    L12:
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0(r6, r0.getBelow-hoxUOeE()) == false) goto L17;
        if (this.reverseLayout == false) goto L7;
        return false;
    L17:
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0(r6, r0.getLeft-hoxUOeE()) == false) goto L28;
        LayoutDirection r7 = DelegatableNodeKt.requireLayoutDirection(this);
        int r8 = WhenMappings.$EnumSwitchMapping$0[r7.ordinal()];
        if (r8 == 1) goto L44;
        if (r8 != 2) goto L25;
        if (this.reverseLayout == false) goto L7;
        return false;
    L25:
        throw new NoWhenBranchMatchedException();
    L44:
        return this.reverseLayout;
    L28:
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0(r6, r0.getRight-hoxUOeE()) == false) goto L39;
        LayoutDirection r9 = DelegatableNodeKt.requireLayoutDirection(this);
        int r10 = WhenMappings.$EnumSwitchMapping$0[r9.ordinal()];
        if (r10 == 1) goto L36;
        if (r10 != 2) goto L34;
        return this.reverseLayout;
    L34:
        throw new NoWhenBranchMatchedException();
    L36:
        if (this.reverseLayout == false) goto L7;
        return false;
    L39:
        LazyLayoutBeyondBoundsModifierLocalKt.access$unsupportedDirection();
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: isOppositeToOrientation-4vf7U8o, reason: not valid java name */
    private final boolean m1136isOppositeToOrientation4vf7U8o(int r5) {
        BeyondBoundsLayout.LayoutDirection.Companion r0 = BeyondBoundsLayout.LayoutDirection.Companion;
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0(r5, r0.getAbove-hoxUOeE()) == true) goto L23;
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0(r5, r0.getBelow-hoxUOeE()) == true) goto L23;
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0(r5, r0.getLeft-hoxUOeE()) == true) goto L20;
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0(r5, r0.getRight-hoxUOeE()) == true) goto L20;
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0(r5, r0.getBefore-hoxUOeE()) == false) goto L15;
    L25:
        return false;
    L15:
        if (BeyondBoundsLayout.LayoutDirection.equals-impl0(r5, r0.getAfter-hoxUOeE()) == true) goto L25;
        LazyLayoutBeyondBoundsModifierLocalKt.access$unsupportedDirection();
        throw new KotlinNothingValueException();
    L20:
        if (this.orientation != Orientation.Vertical) goto L25;
        return true;
    L23:
        if (this.orientation != Orientation.Horizontal) goto L25;
        return true;
    }

    /* JADX INFO: renamed from: addNextInterval-FR3nfPY, reason: not valid java name */
    private final LazyLayoutBeyondBoundsInfo.Interval m1133addNextIntervalFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval r2, int r3) {
        int r0 = r2.getStart();
        int r4 = r2.getEnd();
        if (m1135isForward4vf7U8o(r3) == false) goto L5;
        r4 = r4 + 1;
    L7:
        return this.beyondBoundsInfo.addInterval(r0, r4);
    L5:
        r0 = r0 - 1;
        goto L7
    }

    /* JADX INFO: renamed from: hasMoreContent-FR3nfPY, reason: not valid java name */
    private final boolean m1134hasMoreContentFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval r3, int r4) {
        if (m1136isOppositeToOrientation4vf7U8o(r4) == false) goto L6;
        return false;
    L6:
        if (m1135isForward4vf7U8o(r4) == false) goto L11;
        if (r3.getEnd() >= (this.state.getItemCount() - 1)) goto L14;
    L12:
        return true;
    L14:
        return false;
    L11:
        if (r3.getStart() > 0) goto L12;
        return false;
    }

    private static final Unit measure_3p2s80s$lambda$0(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.place$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: layout-o7g1Pn8, reason: not valid java name */
    public <T> T m1137layouto7g1Pn8(final int r7, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> r8) {
        if (this.state.getItemCount() <= 0) goto L22;
        if (this.state.getHasVisibleItems() == false) goto L22;
        if (isAttached() == false) goto L22;
        if (m1135isForward4vf7U8o(r7) == false) goto L12;
        int r0 = this.state.getLastPlacedIndex();
    L13:
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = this.beyondBoundsInfo.addInterval(r0, r0);
        int r2 = RangesKt.coerceAtMost(this.state.itemsPerViewport() * 2, this.state.getItemCount());
        T r3 = null;
        int r4 = 0;
    L14:
        if (r3 != null) goto L19;
        if (m1134hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) r1.element, r7) == false) goto L19;
        if (r4 >= r2) goto L19;
        LazyLayoutBeyondBoundsInfo.Interval r5 = m1133addNextIntervalFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) r1.element, r7);
        this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) r1.element);
        r1.element = r5;
        r4 = r4 + 1;
        LayoutModifierNodeKt.remeasureSync(this);
        r3 = (T) r8.invoke(new LazyLayoutBeyondBoundsModifierNode$layout$2(this, r1, r7));
    L19:
        this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) r1.element);
        LayoutModifierNodeKt.remeasureSync(this);
        return r3;
    L12:
        r0 = this.state.getFirstPlacedIndex();
    L22:
        return (T) r8.invoke(emptyBeyondBoundsScope);
    }

    /* JADX INFO: renamed from: access$hasMoreContent-FR3nfPY, reason: not valid java name */
    public static final /* synthetic */ boolean m1132access$hasMoreContentFR3nfPY(LazyLayoutBeyondBoundsModifierNode r0, LazyLayoutBeyondBoundsInfo.Interval r1, int r2) {
        return r0.m1134hasMoreContentFR3nfPY(r1, r2);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1138measure3p2s80s(MeasureScope r8, Measurable r9, long r10) {
        final Placeable r11 = r9.measure-BRTryo0(r10);
        return MeasureScope.-CC.layout$default(r8, r11.getWidth(), r11.getHeight(), null, new d(r11), 4, null);
    }

    public LazyLayoutBeyondBoundsModifierNode(LazyLayoutBeyondBoundsState r1, LazyLayoutBeyondBoundsInfo r2, boolean r3, Orientation r4) {
        this.state = r1;
        this.beyondBoundsInfo = r2;
        this.reverseLayout = r3;
        this.orientation = r4;
    }

    public final void update(LazyLayoutBeyondBoundsState r1, LazyLayoutBeyondBoundsInfo r2, boolean r3, Orientation r4) {
        this.state = r1;
        this.beyondBoundsInfo = r2;
        this.reverseLayout = r3;
        this.orientation = r4;
    }
}
