package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 82\u00020\u0001:\u00018BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0007J\u000e\u0010&\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020'H\u0080@¢\u0006\u0004\b*\u0010(J\u000e\u0010+\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u0010\u0010,\u001a\u00020'H\u0080@¢\u0006\u0004\b-\u0010(J\"\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b1\u00102J\u0018\u00103\u001a\u00020'2\u0006\u0010/\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u000bH\u0000¢\u0006\u0002\b7R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\f\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0011\u0010#\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b#\u0010\u0012R\u0014\u0010$\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0012¨\u00069"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState;", "", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "Lkotlin/Function1;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "isSkipHalfExpanded", "<init>", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Z)V", "getAnimationSpec$material", "()Landroidx/compose/animation/core/AnimationSpec;", "isSkipHalfExpanded$material", "()Z", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material", "()Landroidx/compose/material/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/ModalBottomSheetValue;", "targetValue", "getTargetValue", "progress", "getProgress$annotations", "()V", "getProgress", "()F", "from", "to", "isVisible", "hasHalfExpandedState", "getHasHalfExpandedState$material", "show", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "halfExpand", "halfExpand$material", "hide", "expand", "expand$material", "animateTo", "target", "velocity", "animateTo$material", "(Landroidx/compose/material/ModalBottomSheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "snapTo$material", "(Landroidx/compose/material/ModalBottomSheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireOffset", "requireOffset$material", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final AnchoredDraggableState<ModalBottomSheetValue> anchoredDraggableState;
    private final AnimationSpec<Float> animationSpec;
    private final boolean isSkipHalfExpanded;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/ModalBottomSheetState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Landroidx/compose/material/ModalBottomSheetValue;", "", "skipHalfExpanded", "density", "Landroidx/compose/ui/unit/Density;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ ModalBottomSheetState a(Density r0, Function1 r1, AnimationSpec r2, boolean r3, ModalBottomSheetValue r4) {
            return Saver$lambda$1(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ ModalBottomSheetValue b(SaverScope r0, ModalBottomSheetState r1) {
            return Saver$lambda$0(r0, r1);
        }

        private static final ModalBottomSheetValue Saver$lambda$0(SaverScope r0, ModalBottomSheetState r1) {
            return r1.getCurrentValue();
        }

        public final Saver<ModalBottomSheetState, ?> Saver(final AnimationSpec<Float> r3, final Function1<? super ModalBottomSheetValue, Boolean> r4, final boolean r5, final Density r6) {
            return SaverKt.Saver(new w6(), new x6(r6, r4, r3, r5));
        }

        private static final ModalBottomSheetState Saver$lambda$1(Density r7, Function1 r8, AnimationSpec r9, boolean r10, ModalBottomSheetValue r11) {
            return new ModalBottomSheetState(r11, r7, r8, r9, r10);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ModalBottomSheetValue.values().length];
            r0[ModalBottomSheetValue.Hidden.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    private static final boolean _init_$lambda$0(ModalBottomSheetValue r0) {
        return true;
    }

    public static /* synthetic */ float a(Density r0) {
        return anchoredDraggableState$lambda$4(r0);
    }

    public static /* synthetic */ boolean b(ModalBottomSheetValue r0) {
        return _init_$lambda$0(r0);
    }

    public static /* synthetic */ float c(Density r0, float r1) {
        return anchoredDraggableState$lambda$2(r0, r1);
    }

    @Deprecated(message = "Please use the progress function to query progress explicitly between targets.", replaceWith = @ReplaceWith(expression = "progress(from = , to = )", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    public final ModalBottomSheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final boolean getHasHalfExpandedState$material() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(ModalBottomSheetValue.HalfExpanded);
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final ModalBottomSheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isVisible() {
        if (this.anchoredDraggableState.getCurrentValue() == ModalBottomSheetValue.Hidden) goto L5;
        return true;
    L5:
        return false;
    }

    public final float requireOffset$material() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final AnchoredDraggableState<ModalBottomSheetValue> getAnchoredDraggableState$material() {
        return this.anchoredDraggableState;
    }

    public final AnimationSpec<Float> getAnimationSpec$material() {
        return this.animationSpec;
    }

    public final boolean isSkipHalfExpanded$material() {
        return this.isSkipHalfExpanded;
    }

    private static final float anchoredDraggableState$lambda$4(Density r1) {
        return r1.toPx-0680j_4(ModalBottomSheetKt.access$getModalBottomSheetVelocityThreshold$p());
    }

    public final Object expand$material(Continuation<? super Unit> r8) {
        DraggableAnchors<ModalBottomSheetValue> r0 = this.anchoredDraggableState.getAnchors();
        ModalBottomSheetValue r2 = ModalBottomSheetValue.Expanded;
        if (r0.hasAnchorFor(r2) == false) goto L5;
        Object r9 = animateTo$material$default(this, r2, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r8, 2, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r9;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public final Object halfExpand$material(Continuation<? super Unit> r7) {
        if (getHasHalfExpandedState$material() == false) goto L5;
        Object r8 = animateTo$material$default(this, ModalBottomSheetValue.HalfExpanded, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r7, 2, null);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r8;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public final Object hide(Continuation<? super Unit> r7) {
        Object r8 = animateTo$material$default(this, ModalBottomSheetValue.Hidden, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r7, 2, null);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    public final Object show(Continuation<? super Unit> r9) {
        DraggableAnchors<ModalBottomSheetValue> r0 = this.anchoredDraggableState.getAnchors();
        ModalBottomSheetValue r1 = ModalBottomSheetValue.Expanded;
        boolean r2 = r0.hasAnchorFor(r1);
        ModalBottomSheetValue r3 = getCurrentValue();
        if (WhenMappings.$EnumSwitchMapping$0[r3.ordinal()] == 1) goto L5;
        if (r2 == true) goto L10;
        r1 = ModalBottomSheetValue.Hidden;
    L10:
        Object r10 = animateTo$material$default(this, r1, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r9, 2, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        return r10;
    L14:
        return Unit.INSTANCE;
    L5:
        if (getHasHalfExpandedState$material() == false) goto L10;
        r1 = ModalBottomSheetValue.HalfExpanded;
        goto L10
    }

    private static final float anchoredDraggableState$lambda$2(Density r0, float r1) {
        return r0.toPx-0680j_4(ModalBottomSheetKt.access$getModalBottomSheetPositionalThreshold$p());
    }

    public final float progress(ModalBottomSheetValue r4, ModalBottomSheetValue r5) {
        float r6 = this.anchoredDraggableState.getAnchors().positionOf(r4);
        float r7 = this.anchoredDraggableState.getAnchors().positionOf(r5);
        float r0 = (RangesKt.coerceIn(this.anchoredDraggableState.getOffset(), Math.min(r6, r7), Math.max(r6, r7)) - r6) / (r7 - r6);
        if (Float.isNaN(r0) == false) goto L6;
        return 1.0f;
    L6:
        return Math.abs(r0);
    }

    public final Object snapTo$material(ModalBottomSheetValue r2, Continuation<? super Unit> r3) {
        Object r4 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public final Object animateTo$material(ModalBottomSheetValue r2, float r3, Continuation<? super Unit> r4) {
        Object r5 = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, r2, r3, r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public ModalBottomSheetState(ModalBottomSheetValue r8, final Density r9, Function1<? super ModalBottomSheetValue, Boolean> r10, AnimationSpec<Float> r11, boolean r12) {
        this.animationSpec = r11;
        this.isSkipHalfExpanded = r12;
        this.anchoredDraggableState = new AnchoredDraggableState(r8, new t6(r9), new u6(r9), r11, r10);
        if (r12 == true) goto L5;
        return;
    L5:
        if (r8 == ModalBottomSheetValue.HalfExpanded) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == false) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("The initial value must not be set to HalfExpanded if skipHalfExpanded is set to true.".toString());
    L7:
        r13 = false;
        goto L8
    }

    public static /* synthetic */ Object animateTo$material$default(ModalBottomSheetState r0, ModalBottomSheetValue r1, float r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = r0.anchoredDraggableState.getLastVelocity();
    L6:
        return r0.animateTo$material(r1, r2, r3);
    }

    public /* synthetic */ ModalBottomSheetState(ModalBottomSheetValue r7, Density r8, Function1 r9, AnimationSpec r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = new v6();
    L5:
        Function1 r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        r10 = ModalBottomSheetDefaults.INSTANCE.getAnimationSpec();
    L8:
        AnimationSpec r4 = r10;
        if ((r12 & 16) == 0) goto L11;
        boolean r5 = false;
    L12:
        this(r7, r8, r3, r4, r5);
        return;
    L11:
        r5 = r11;
        goto L12
    }
}
