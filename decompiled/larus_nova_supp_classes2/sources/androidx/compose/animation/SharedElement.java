package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSizeKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\"\u001a\u0004\u0018\u00010#J\b\u0010:\u001a\u00020\u000eH\u0002J\n\u0010;\u001a\u0004\u0018\u00010#H\u0002J\u0016\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\b\u0010F\u001a\u00020\fH\u0002J\u0006\u0010G\u001a\u00020\u000eJ\u0006\u0010H\u001a\u00020\u000eJ\u000e\u0010L\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020AJ\u000e\u0010N\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020AR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR+\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u00188@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u00188B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0016\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR/\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u000f\u001a\u0004\u0018\u00010#8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\u0016\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u0017\u001a\u0004\u0018\u00010*@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R(\u0010.\u001a\u0004\u0018\u00010*2\b\u0010\u0017\u001a\u0004\u0018\u00010*@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010-\"\u0004\b0\u00101R+\u00103\u001a\u0002022\u0006\u0010\u000f\u001a\u0002028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\u0016\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00109\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020A0C¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000e0KX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Landroidx/compose/animation/SharedElement;", "", "key", "scope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "getKey", "()Ljava/lang/Object;", "getScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "isAnimating", "", "updateMatch", "", "<set-?>", "foundMatch", "getFoundMatch", "()Z", "setFoundMatch", "(Z)V", "foundMatch$delegate", "Landroidx/compose/runtime/MutableState;", "value", "Landroidx/compose/animation/TargetData;", "targetData", "getTargetData$animation", "()Landroidx/compose/animation/TargetData;", "setTargetData$animation", "(Landroidx/compose/animation/TargetData;)V", "_targetData", "get_targetData", "set_targetData", "_targetData$delegate", "tryInitializingCurrentBounds", "Landroidx/compose/ui/geometry/Rect;", "currentBoundsWhenMatched", "getCurrentBoundsWhenMatched", "()Landroidx/compose/ui/geometry/Rect;", "setCurrentBoundsWhenMatched", "(Landroidx/compose/ui/geometry/Rect;)V", "currentBoundsWhenMatched$delegate", "Landroidx/compose/animation/BoundsProvider;", "lastTargetBoundsProvider", "getLastTargetBoundsProvider$animation", "()Landroidx/compose/animation/BoundsProvider;", "targetBoundsProvider", "getTargetBoundsProvider$animation", "setTargetBoundsProvider", "(Landroidx/compose/animation/BoundsProvider;)V", "", "targetBoundsProviderUpdateRequestId", "getTargetBoundsProviderUpdateRequestId", "()I", "setTargetBoundsProviderUpdateRequestId", "(I)V", "targetBoundsProviderUpdateRequestId$delegate", "lastHandledTargetProviderUpdateRequestId", "updateTargetBoundsProvider", "obtainBoundsFromLastTarget", "targetBoundsProviderChanged", "onLookaheadPlaced", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "state", "Landroidx/compose/animation/SharedElementInternalState;", "states", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "getStates", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "hasVisibleContent", "invalidateTargetBoundsProvider", "onSharedTransitionFinished", "Lkotlin/Function1;", "observingVisibilityChange", "Lkotlin/Function0;", "addState", "sharedElementState", "removeState", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SharedElement {
    public static final int $stable = 8;
    private final MutableState _targetData$delegate;
    private final MutableState currentBoundsWhenMatched$delegate;
    private final MutableState foundMatch$delegate;
    private final Object key;
    private int lastHandledTargetProviderUpdateRequestId;
    private BoundsProvider lastTargetBoundsProvider;
    private final Function0<Unit> observingVisibilityChange;
    private final SharedTransitionScopeImpl scope;
    private final SnapshotStateList<SharedElementInternalState> states;
    private BoundsProvider targetBoundsProvider;
    private boolean targetBoundsProviderChanged;
    private final MutableState targetBoundsProviderUpdateRequestId$delegate;
    private final Function1<SharedElement, Unit> updateMatch;

    private final int getTargetBoundsProviderUpdateRequestId() {
        return ((Number) this.targetBoundsProviderUpdateRequestId$delegate.getValue()).intValue();
    }

    private final TargetData get_targetData() {
        return (TargetData) this._targetData$delegate.getValue();
    }

    private final boolean hasVisibleContent() {
        SnapshotStateList<SharedElementInternalState> r0 = this.states;
        int r1 = r0.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        if (((SharedElementInternalState) ListProtector.get(r0, r3)).getBoundsAnimation().getTarget() == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    private final Rect obtainBoundsFromLastTarget() {
        if (this.lastTargetBoundsProvider == null) goto L17;
        SnapshotStateList<SharedElementInternalState> r0 = this.states;
        int r2 = r0.size();
        boolean r3 = false;
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L10;
        if (Intrinsics.areEqual(((SharedElementInternalState) ListProtector.get(r0, r4)).getBoundsProvider(), this.lastTargetBoundsProvider) == true) goto L8;
        r4 = r4 + 1;
        goto L5
    L8:
        r3 = true;
    L10:
        if (r3 == false) goto L18;
        BoundsProvider r1 = this.lastTargetBoundsProvider;
        if (r1 != null) goto L14;
        return null;
    L14:
        return r1.getLastBoundsInSharedTransitionScope();
    L18:
        return null;
    L17:
        return null;
    }

    public final Rect getCurrentBoundsWhenMatched() {
        return (Rect) this.currentBoundsWhenMatched$delegate.getValue();
    }

    public final boolean getFoundMatch() {
        return ((Boolean) this.foundMatch$delegate.getValue()).booleanValue();
    }

    public final void invalidateTargetBoundsProvider() {
        Iterator r0 = this.states.iterator();
    L3:
        BoundsProvider r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((SharedElementInternalState) r1).getTarget() == false) goto L3;
    L9:
        SharedElementInternalState r3 = (SharedElementInternalState) r1;
        if (r3 == null) goto L12;
    L14:
        if (r3 == null) goto L17;
        r2 = r3.getBoundsProvider();
    L17:
        if (Intrinsics.areEqual(r2, this.targetBoundsProvider) == false) goto L19;
        return;
    L19:
        setTargetBoundsProviderUpdateRequestId(this.lastHandledTargetProviderUpdateRequestId + 1);
        return;
    L12:
        if (this.targetBoundsProvider != null) goto L14;
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final boolean isAnimating() {
        SnapshotStateList<SharedElementInternalState> r0 = this.states;
        int r1 = r0.size();
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L9;
        if (((SharedElementInternalState) ListProtector.get(r0, r3)).getBoundsAnimation().isRunning() == true) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L12;
        return false;
    L12:
        if (getFoundMatch() == false) goto L18;
        return true;
    L18:
        return false;
    L9:
        r2 = false;
        goto L10
    }

    public final void onSharedTransitionFinished() {
        boolean r1 = true;
        if (this.states.size() > 1) goto L5;
    L7:
        r1 = false;
    L8:
        setFoundMatch(r1);
        this.lastTargetBoundsProvider = null;
        set_targetData(null);
        return;
    L5:
        if (hasVisibleContent() == false) goto L7;
        goto L7
    }

    private final void updateTargetBoundsProvider() {
        if (getTargetBoundsProviderUpdateRequestId() == this.lastHandledTargetProviderUpdateRequestId) goto L27;
        SnapshotStateList<SharedElementInternalState> r0 = this.states;
        int r1 = r0.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        Object r4 = ListProtector.get(r0, r2);
        if (((SharedElementInternalState) r4).getTarget() == true) goto L12;
        r2 = r2 + 1;
    L12:
        SharedElementInternalState r5 = (SharedElementInternalState) r4;
        if (r5 != null) goto L15;
        r5 = (SharedElementInternalState) CollectionsKt.firstOrNull(this.states);
    L15:
        if (r5 == null) goto L17;
        BoundsProvider r3 = r5.getBoundsProvider();
    L19:
        if (Intrinsics.areEqual(r3, this.targetBoundsProvider) == true) goto L21;
        this.lastTargetBoundsProvider = this.targetBoundsProvider;
        setTargetBoundsProvider(r3);
        this.targetBoundsProviderChanged = true;
    L21:
        if (r3 != null) goto L23;
        setTargetBoundsProvider(null);
    L23:
        this.lastHandledTargetProviderUpdateRequestId = getTargetBoundsProviderUpdateRequestId();
        return;
    L17:
        r3 = null;
        goto L19
    L11:
        r4 = null;
        goto L12
    }

    public final TargetData getTargetData$animation() {
        if (getFoundMatch() == true) goto L7;
        return null;
    L7:
        return get_targetData();
    }

    public final Rect tryInitializingCurrentBounds() {
        if (getFoundMatch() == true) goto L6;
        return null;
    L6:
        updateTargetBoundsProvider();
        if (getCurrentBoundsWhenMatched() != null) goto L10;
        setCurrentBoundsWhenMatched(obtainBoundsFromLastTarget());
    L10:
        return getCurrentBoundsWhenMatched();
    }

    public final void updateMatch() {
        boolean r0 = hasVisibleContent();
        if (this.states.size() <= 1) goto L7;
        if (r0 == false) goto L7;
        setFoundMatch(true);
    L12:
        if ((!this.states.isEmpty()) == false) goto L14;
        this.scope.observeReads$animation(this, this.updateMatch, this.observingVisibilityChange);
    L14:
        invalidateTargetBoundsProvider();
        return;
    L7:
        if (this.scope.isTransitionActive() == false) goto L10;
        if (r0 == true) goto L12;
        setFoundMatch(false);
        goto L12
    L10:
        setFoundMatch(false);
        goto L12
    }

    public final Object getKey() {
        return this.key;
    }

    public final BoundsProvider getLastTargetBoundsProvider$animation() {
        return this.lastTargetBoundsProvider;
    }

    public final SharedTransitionScopeImpl getScope() {
        return this.scope;
    }

    public final SnapshotStateList<SharedElementInternalState> getStates() {
        return this.states;
    }

    public final BoundsProvider getTargetBoundsProvider$animation() {
        return this.targetBoundsProvider;
    }

    public static final /* synthetic */ boolean access$hasVisibleContent(SharedElement r0) {
        return r0.hasVisibleContent();
    }

    private final void setFoundMatch(boolean r2) {
        this.foundMatch$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void setTargetBoundsProvider(BoundsProvider r2) {
        if (Intrinsics.areEqual(this.targetBoundsProvider, r2) == true) goto L5;
        this.lastTargetBoundsProvider = this.targetBoundsProvider;
    L5:
        this.targetBoundsProvider = r2;
    }

    private final void setTargetBoundsProviderUpdateRequestId(int r2) {
        this.targetBoundsProviderUpdateRequestId$delegate.setValue(Integer.valueOf(r2));
    }

    private final void set_targetData(TargetData r2) {
        this._targetData$delegate.setValue(r2);
    }

    public final void addState(SharedElementInternalState r3) {
        this.states.add(r3);
        this.scope.observeReads$animation(this, this.updateMatch, this.observingVisibilityChange);
    }

    public final void removeState(SharedElementInternalState r3) {
        this.states.remove(r3);
        if (this.states.isEmpty() == false) goto L5;
        updateMatch();
        this.scope.clearObservation$animation(this);
        return;
    L5:
        this.scope.observeReads$animation(this, this.updateMatch, this.observingVisibilityChange);
    }

    public final void setCurrentBoundsWhenMatched(Rect r2) {
        this.currentBoundsWhenMatched$delegate.setValue(r2);
    }

    public final void setTargetData$animation(TargetData r2) {
        if (getFoundMatch() == false) goto L6;
        set_targetData(r2);
        return;
    }

    public SharedElement(Object r2, SharedTransitionScopeImpl r3) {
        this.key = r2;
        this.scope = r3;
        this.foundMatch$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this._targetData$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentBoundsWhenMatched$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.targetBoundsProviderUpdateRequestId$delegate = SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.states = SnapshotStateKt.mutableStateListOf();
        this.updateMatch = new AnonymousClass1(this);
        this.observingVisibilityChange = new SharedElement$observingVisibilityChange$1(this);
    }

    public final void onLookaheadPlaced(Placeable.PlacementScope r17, SharedElementInternalState r18) {
        updateTargetBoundsProvider();
        if (getFoundMatch() == true) goto L5;
        return;
    L5:
        if (r18.getBoundsAnimation().getTarget() == false) goto L29;
        LayoutCoordinates r1 = r17.getCoordinates();
        if (r1 == null) goto L30;
        long r12 = IntSizeKt.toSize-ozmzZPI(r1.getSize-YbymL2g());
        long r14 = LookaheadScope.-CC.localLookaheadPositionOf-au-aQtc$default(r18.getSharedElement().scope, r18.getSharedElement().scope.getLookaheadRoot$animation(), r1, 0, false, 6, null);
        SharedTransitionScopeImpl r2 = r18.getSharedElement().scope;
        long r3 = LayoutCoordinates.-CC.localPositionOf-S_NoaFU$default(r18.getSharedElement().scope.getLookaheadRoot$animation(), r1, 0, false, 2, null);
        TargetData r4 = getTargetData$animation();
        if (r4 != null) goto L12;
        r4 = new TargetData(r12, Offset.minus-MK-Hz9U(r14, r3), r3, null);
    L12:
        if (Offset.equals-impl0(r4.m230getTargetStructuralOffsetF1C5BW0(), r3) == true) goto L14;
    L17:
        r4.m233setSizeuvyYCjk(r12);
        r4.m234setTargetStructuralOffsetk4lQ0M(r3);
        if (this.targetBoundsProviderChanged == false) goto L21;
        r4.m232setInitialMfrOffsetk4lQ0M(Offset.minus-MK-Hz9U(Offset.minus-MK-Hz9U(r14, r3), Offset.minus-MK-Hz9U(r4.m227getCurrentMfrOffsetF1C5BW0(), r4.m228getInitialMfrOffsetF1C5BW0())));
    L21:
        if (getCurrentBoundsWhenMatched() != null) goto L26;
        Rect r5 = obtainBoundsFromLastTarget();
        if (r5 != null) goto L25;
        r5 = RectKt.Rect-tz77jQw(r14, r12);
    L25:
        setCurrentBoundsWhenMatched(r5);
    L26:
        r4.m231setCurrentMfrOffsetk4lQ0M(Offset.minus-MK-Hz9U(r14, r3));
        setTargetData$animation(r4);
        this.targetBoundsProviderChanged = false;
        return;
    L14:
        if (Size.equals-impl0(r4.m229getSizeNHjbRc(), r12) == false) goto L17;
        if (this.targetBoundsProviderChanged == false) goto L26;
    L30:
        return;
    }
}
