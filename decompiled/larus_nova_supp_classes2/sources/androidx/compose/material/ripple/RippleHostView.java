package androidx.compose.material.ripple;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0001\u0018\u0000 82\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0014J0\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0014J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0016JK\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!¢\u0006\u0004\b/\u00100J\u0006\u00101\u001a\u00020\u0007J-\u00102\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.¢\u0006\u0004\b3\u00104J\u0006\u00105\u001a\u00020\u0007J\u0010\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\rH\u0002R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Landroidx/compose/material/ripple/RippleHostView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "onLayout", "changed", "", "l", "t", "r", "b", "draw", "canvas", "Landroid/graphics/Canvas;", "refreshDrawableState", "ripple", "Landroidx/compose/material/ripple/UnprojectedRipple;", "bounded", "Ljava/lang/Boolean;", "lastRippleStateChangeTimeMillis", "", "Ljava/lang/Long;", "resetRippleRunnable", "Ljava/lang/Runnable;", "createRipple", "onInvalidateRipple", "Lkotlin/Function0;", "invalidateDrawable", "who", "Landroid/graphics/drawable/Drawable;", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "size", "Landroidx/compose/ui/geometry/Size;", "radius", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "addRipple-KOepWvA", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;ZJIJFLkotlin/jvm/functions/Function0;)V", "removeRipple", "setRippleProperties", "setRippleProperties-biQXAtU", "(JIJF)V", "disposeRipple", "setRippleState", "pressed", "Companion", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RippleHostView extends View {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final long MinimumRippleStateChangeTime = 5;
    private static final int[] PressedState = null;
    private static final long ResetRippleDelayDuration = 50;
    private static final int[] RestingState = null;
    private Boolean bounded;
    private Long lastRippleStateChangeTimeMillis;
    private Function0<Unit> onInvalidateRipple;
    private Runnable resetRippleRunnable;
    private UnprojectedRipple ripple;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/material/ripple/RippleHostView$Companion;", "", "<init>", "()V", "MinimumRippleStateChangeTime", "", "ResetRippleDelayDuration", "PressedState", "", "RestingState", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    public static /* synthetic */ void a(RippleHostView r0) {
        setRippleState$lambda$2(r0);
    }

    public final void disposeRipple() {
        this.onInvalidateRipple = null;
        Runnable r0 = this.resetRippleRunnable;
        if (r0 == null) goto L5;
        removeCallbacks(r0);
        Runnable r1 = this.resetRippleRunnable;
        Intrinsics.checkNotNull(r1);
        r1.run();
    L8:
        UnprojectedRipple r2 = this.ripple;
        if (r2 != null) goto L11;
        return;
    L11:
        r2.setVisible(false, false);
        unscheduleDrawable(r2);
        return;
    L5:
        UnprojectedRipple r3 = this.ripple;
        if (r3 == null) goto L8;
        r3.setState(RestingState);
        goto L8
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    @Override // android.view.View
    public void refreshDrawableState() {
    }

    public final void removeRipple() {
        setRippleState(false);
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        PressedState = new int[]{R.attr.state_pressed, R.attr.state_enabled};
        RestingState = new int[0];
    }

    public RippleHostView(Context r1) {
        super(r1);
    }

    private final void createRipple(boolean r2) {
        UnprojectedRipple r0 = new UnprojectedRipple(r2);
        setBackground(r0);
        this.ripple = r0;
    }

    private final void setRippleState(boolean r8) {
        long r0 = AnimationUtils.currentAnimationTimeMillis();
        Runnable r2 = this.resetRippleRunnable;
        if (r2 == null) goto L5;
        removeCallbacks(r2);
        r2.run();
    L5:
        Long r3 = this.lastRippleStateChangeTimeMillis;
        if (r3 == null) goto L8;
        long r4 = r3.longValue();
    L9:
        long r5 = r0 - r4;
        if (r8 == false) goto L12;
    L14:
        if (r8 == false) goto L16;
        int[] r9 = PressedState;
    L17:
        UnprojectedRipple r6 = this.ripple;
        if (r6 == null) goto L20;
        r6.setState(r9);
    L20:
        this.lastRippleStateChangeTimeMillis = Long.valueOf(r0);
        return;
    L16:
        r9 = RestingState;
        goto L17
    L12:
        if (r5 >= 5) goto L14;
        Runnable r10 = new c(this);
        this.resetRippleRunnable = r10;
        postDelayed(r10, ResetRippleDelayDuration);
        goto L20
    L8:
        r4 = 0;
        goto L9
    }

    private static final void setRippleState$lambda$2(RippleHostView r2) {
        UnprojectedRipple r0 = r2.ripple;
        if (r0 == null) goto L5;
        r0.setState(RestingState);
    L5:
        r2.resetRippleRunnable = null;
    }

    @Override // android.view.View
    public void draw(Canvas r2) {
        if (isAttachedToWindow() == true) goto L6;
        disposeRipple();
        return;
    L6:
        super.draw(r2);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r1) {
        Function0<Unit> r2 = this.onInvalidateRipple;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        setMeasuredDimension(0, 0);
    }

    /* JADX INFO: renamed from: setRippleProperties-biQXAtU, reason: not valid java name */
    public final void m2267setRipplePropertiesbiQXAtU(long r2, int r4, long r5, float r7) {
        UnprojectedRipple r0 = this.ripple;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.trySetRadius(r4);
        r0.m2279setColorDxMtmZc(r5, r7);
        Rect r6 = new Rect(0, 0, MathKt.roundToInt(Size.getWidth-impl(r2)), MathKt.roundToInt(Size.getHeight-impl(r2)));
        setLeft(r6.left);
        setTop(r6.top);
        setRight(r6.right);
        setBottom(r6.bottom);
        r0.setBounds(r6);
    }

    /* JADX INFO: renamed from: addRipple-KOepWvA, reason: not valid java name */
    public final void m2266addRippleKOepWvA(PressInteraction.Press r11, boolean r12, long r13, int r15, long r16, float r18, Function0<Unit> r19) {
        if (this.ripple != null) goto L5;
    L6:
        createRipple(r12);
        this.bounded = Boolean.valueOf(r12);
    L7:
        UnprojectedRipple r9 = this.ripple;
        Intrinsics.checkNotNull(r9);
        this.onInvalidateRipple = r19;
        m2267setRipplePropertiesbiQXAtU(r13, r15, r16, r18);
        if (r12 == false) goto L10;
        r9.setHotspot(Offset.getX-impl(r11.m743getPressPositionF1C5BW0()), Offset.getY-impl(r11.m743getPressPositionF1C5BW0()));
    L11:
        setRippleState(true);
        return;
    L10:
        r9.setHotspot(r9.getBounds().centerX(), r9.getBounds().centerY());
        goto L11
    L5:
        if (Intrinsics.areEqual(Boolean.valueOf(r12), this.bounded) == true) goto L7;
        goto L6
    }
}
