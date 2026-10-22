package androidx.compose.material.ripple;

import android.view.ViewGroup;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Deprecated(message = "Replaced by the new RippleNode implementation")
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\f\u0010+\u001a\u00020**\u00020,H\u0016J\u0018\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00103\u001a\u00020*H\u0016J\b\u00104\u001a\u00020*H\u0016J\b\u00105\u001a\u00020*H\u0016J\b\u00106\u001a\u00020*H\u0002J\b\u00107\u001a\u00020*H\u0016J\b\u00108\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00158B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR+\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Landroidx/compose/material/ripple/AndroidRippleIndicationInstance;", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/runtime/RememberObserver;", "Landroidx/compose/material/ripple/RippleHostKey;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "view", "Landroid/view/ViewGroup;", "<init>", "(ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroid/view/ViewGroup;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "rippleContainer", "Landroidx/compose/material/ripple/RippleContainer;", "<set-?>", "Landroidx/compose/material/ripple/RippleHostView;", "rippleHostView", "getRippleHostView", "()Landroidx/compose/material/ripple/RippleHostView;", "setRippleHostView", "(Landroidx/compose/material/ripple/RippleHostView;)V", "rippleHostView$delegate", "Landroidx/compose/runtime/MutableState;", "invalidateTick", "getInvalidateTick", "()Z", "setInvalidateTick", "(Z)V", "invalidateTick$delegate", "rippleSize", "Landroidx/compose/ui/geometry/Size;", "J", "rippleRadius", "", "onInvalidateRipple", "Lkotlin/Function0;", "", "drawIndication", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "removeRipple", "onRemembered", "onForgotten", "onAbandoned", "dispose", "onResetRippleHostView", "getOrCreateRippleContainer", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver, RippleHostKey {
    public static final int $stable = 8;
    private final boolean bounded;
    private final State<Color> color;
    private final MutableState invalidateTick$delegate;
    private final Function0<Unit> onInvalidateRipple;
    private final float radius;
    private final State<RippleAlpha> rippleAlpha;
    private RippleContainer rippleContainer;
    private final MutableState rippleHostView$delegate;
    private int rippleRadius;
    private long rippleSize;
    private final ViewGroup view;

    public /* synthetic */ AndroidRippleIndicationInstance(boolean r1, float r2, State r3, State r4, ViewGroup r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit b(AndroidRippleIndicationInstance r0) {
        return onInvalidateRipple$lambda$0(r0);
    }

    public void onRemembered() {
    }

    @Override // androidx.compose.material.ripple.RippleHostKey
    public void onResetRippleHostView() {
        setRippleHostView(null);
    }

    private final void dispose() {
        RippleContainer r0 = this.rippleContainer;
        if (r0 == null) goto L6;
        r0.disposeRippleIfNeeded(this);
        return;
    }

    private final boolean getInvalidateTick() {
        return ((Boolean) this.invalidateTick$delegate.getValue()).booleanValue();
    }

    private final RippleContainer getOrCreateRippleContainer() {
        RippleContainer r0 = this.rippleContainer;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        RippleContainer r1 = Ripple_androidKt.access$createAndAttachRippleContainerIfNeeded(this.view);
        this.rippleContainer = r1;
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    private final RippleHostView getRippleHostView() {
        return (RippleHostView) this.rippleHostView$delegate.getValue();
    }

    public void onAbandoned() {
        dispose();
    }

    public void onForgotten() {
        dispose();
    }

    private static final Unit onInvalidateRipple$lambda$0(AndroidRippleIndicationInstance r1) {
        r1.setInvalidateTick(!r1.getInvalidateTick());
        return Unit.INSTANCE;
    }

    private final void setInvalidateTick(boolean r2) {
        this.invalidateTick$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void setRippleHostView(RippleHostView r2) {
        this.rippleHostView$delegate.setValue(r2);
    }

    @Override // androidx.compose.foundation.IndicationInstance
    public void drawIndication(ContentDrawScope r10) {
        this.rippleSize = r10.getSize-NH-jbRc();
        if (Float.isNaN(this.radius) == false) goto L5;
        int r0 = MathKt.roundToInt(RippleAnimationKt.m2264getRippleEndRadiuscSwnlzA(r10, this.bounded, r10.getSize-NH-jbRc()));
    L6:
        this.rippleRadius = r0;
        long r5 = ((Color) this.color.getValue()).unbox-impl();
        float r7 = ((RippleAlpha) this.rippleAlpha.getValue()).getPressedAlpha();
        r10.drawContent();
        m2268drawStateLayerH2RKhps(r10, this.radius, r5);
        Canvas r1 = r10.getDrawContext().getCanvas();
        getInvalidateTick();
        RippleHostView r8 = getRippleHostView();
        if (r8 == null) goto L10;
        r8.m2267setRipplePropertiesbiQXAtU(r10.getSize-NH-jbRc(), this.rippleRadius, r5, r7);
        r8.draw(AndroidCanvas_androidKt.getNativeCanvas(r1));
        return;
    L10:
        return;
    L5:
        r0 = r10.roundToPx-0680j_4(this.radius);
        goto L6
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void removeRipple(PressInteraction.Press r1) {
        RippleHostView r2 = getRippleHostView();
        if (r2 == null) goto L6;
        r2.removeRipple();
        return;
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void addRipple(PressInteraction.Press r11, CoroutineScope r12) {
        RippleHostView r13 = getOrCreateRippleContainer().getRippleHostView(this);
        r13.m2266addRippleKOepWvA(r11, this.bounded, this.rippleSize, this.rippleRadius, ((Color) this.color.getValue()).unbox-impl(), ((RippleAlpha) this.rippleAlpha.getValue()).getPressedAlpha(), this.onInvalidateRipple);
        setRippleHostView(r13);
    }

    private AndroidRippleIndicationInstance(boolean r1, float r2, State<Color> r3, State<RippleAlpha> r4, ViewGroup r5) {
        super(r1, r4);
        this.bounded = r1;
        this.radius = r2;
        this.color = r3;
        this.rippleAlpha = r4;
        this.view = r5;
        this.rippleHostView$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.invalidateTick$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.rippleSize = Size.Companion.getZero-NH-jbRc();
        this.rippleRadius = -1;
        this.onInvalidateRipple = new a(this);
    }
}
