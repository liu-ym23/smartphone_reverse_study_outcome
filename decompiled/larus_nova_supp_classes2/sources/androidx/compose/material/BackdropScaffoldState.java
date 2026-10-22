package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 12\u00020\u0001:\u00011BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H\u0007J\b\u0010,\u001a\u00020'H\u0002R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020.X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Landroidx/compose/material/BackdropScaffoldState;", "", "initialValue", "Landroidx/compose/material/BackdropValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "<init>", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;)V", "getConfirmValueChange", "()Lkotlin/jvm/functions/Function1;", "getSnackbarHostState", "()Landroidx/compose/material/SnackbarHostState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/BackdropValue;", "targetValue", "getTargetValue", "requireOffset", "isRevealed", "()Z", "isConcealed", "reveal", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conceal", "progress", "from", "to", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material", "()Landroidx/compose/material/AnchoredDraggableState;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$material", "()Landroidx/compose/ui/unit/Density;", "setDensity$material", "(Landroidx/compose/ui/unit/Density;)V", "requireDensity", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection$material", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BackdropScaffoldState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final AnchoredDraggableState<BackdropValue> anchoredDraggableState;
    private final Function1<BackdropValue, Boolean> confirmValueChange;
    private Density density;
    private final NestedScrollConnection nestedScrollConnection;
    private final SnackbarHostState snackbarHostState;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/BackdropScaffoldState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BackdropScaffoldState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Landroidx/compose/material/BackdropValue;", "", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "density", "Landroidx/compose/ui/unit/Density;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ BackdropValue a(SaverScope r0, BackdropScaffoldState r1) {
            return Saver$lambda$0(r0, r1);
        }

        public static /* synthetic */ BackdropScaffoldState b(Density r0, AnimationSpec r1, Function1 r2, SnackbarHostState r3, BackdropValue r4) {
            return Saver$lambda$1(r0, r1, r2, r3, r4);
        }

        private static final BackdropValue Saver$lambda$0(SaverScope r0, BackdropScaffoldState r1) {
            return r1.getAnchoredDraggableState$material().getCurrentValue();
        }

        public final Saver<BackdropScaffoldState, ?> Saver(final AnimationSpec<Float> r3, final Function1<? super BackdropValue, Boolean> r4, final SnackbarHostState r5, final Density r6) {
            return SaverKt.Saver(new g1(), new h1(r6, r3, r4, r5));
        }

        private static final BackdropScaffoldState Saver$lambda$1(Density r0, AnimationSpec r1, Function1 r2, SnackbarHostState r3, BackdropValue r4) {
            return BackdropScaffoldKt.BackdropScaffoldState(r4, r0, r1, r2, r3);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final boolean _init_$lambda$0(BackdropValue r0) {
        return true;
    }

    public static /* synthetic */ float a(BackdropScaffoldState r0) {
        return anchoredDraggableState$lambda$4(r0);
    }

    public static /* synthetic */ float b(BackdropScaffoldState r0, float r1) {
        return anchoredDraggableState$lambda$2(r0, r1);
    }

    public static /* synthetic */ boolean c(BackdropValue r0) {
        return _init_$lambda$0(r0);
    }

    private final Density requireDensity() {
        Density r0 = this.density;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException(("The density on BackdropScaffoldState (" + this + ") was not set. Did you use BackdropScaffoldState with the BackdropScaffold composable?").toString());
    }

    public final BackdropValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final BackdropValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isConcealed() {
        if (this.anchoredDraggableState.getCurrentValue() != BackdropValue.Concealed) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRevealed() {
        if (this.anchoredDraggableState.getCurrentValue() != BackdropValue.Revealed) goto L5;
        return true;
    L5:
        return false;
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final AnchoredDraggableState<BackdropValue> getAnchoredDraggableState$material() {
        return this.anchoredDraggableState;
    }

    public final Function1<BackdropValue, Boolean> getConfirmValueChange() {
        return this.confirmValueChange;
    }

    public final Density getDensity$material() {
        return this.density;
    }

    public final NestedScrollConnection getNestedScrollConnection$material() {
        return this.nestedScrollConnection;
    }

    public final SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }

    private static final float anchoredDraggableState$lambda$4(BackdropScaffoldState r1) {
        return r1.requireDensity().toPx-0680j_4(BackdropScaffoldKt.access$getVelocityThreshold$p());
    }

    public final Object conceal(Continuation<? super Unit> r7) {
        Object r8 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BackdropValue.Concealed, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r7, 2, null);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    public final Object reveal(Continuation<? super Unit> r7) {
        Object r8 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BackdropValue.Revealed, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r7, 2, null);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    public final void setDensity$material(Density r1) {
        this.density = r1;
    }

    private static final float anchoredDraggableState$lambda$2(BackdropScaffoldState r0, float r1) {
        return r0.requireDensity().toPx-0680j_4(BackdropScaffoldKt.access$getPositionalThreshold$p());
    }

    public final float progress(BackdropValue r4, BackdropValue r5) {
        float r6 = this.anchoredDraggableState.getAnchors().positionOf(r4);
        float r7 = this.anchoredDraggableState.getAnchors().positionOf(r5);
        float r0 = (RangesKt.coerceIn(this.anchoredDraggableState.getOffset(), Math.min(r6, r7), Math.max(r6, r7)) - r6) / (r7 - r6);
        if (Float.isNaN(r0) == false) goto L6;
        return 1.0f;
    L6:
        return Math.abs(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "This constructor is deprecated. Density must be provided by the component. Please use the constructor that provides a [Density].", replaceWith = @ReplaceWith(expression = "\n            BackdropScaffoldState(\n                initialValue = initialValue,\n                density = LocalDensity.current,\n                animationSpec = animationSpec,\n                confirmValueChange = confirmValueChange\n            )\n            ", imports = {}))
    public BackdropScaffoldState(BackdropValue r7, AnimationSpec<Float> r8, Function1<? super BackdropValue, Boolean> r9, SnackbarHostState r10) {
        this.confirmValueChange = r9;
        this.snackbarHostState = r10;
        AnchoredDraggableState<BackdropValue> r11 = new AnchoredDraggableState(r7, new d1(this), new e1(this), r8, r9);
        this.anchoredDraggableState = r11;
        this.nestedScrollConnection = BackdropScaffoldKt.ConsumeSwipeNestedScrollConnection(r11, Orientation.Vertical);
    }

    public /* synthetic */ BackdropScaffoldState(BackdropValue r1, AnimationSpec r2, Function1 r3, SnackbarHostState r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = BackdropScaffoldDefaults.INSTANCE.getAnimationSpec();
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = new f1();
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = new SnackbarHostState();
    L11:
        this(r1, r2, r3, r4);
    }
}
