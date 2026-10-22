package androidx.compose.material.internal;

import android.R;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010R\u001a\u00020\u0006J&\u0010L\u001a\u00020\u00062\u0006\u0010S\u001a\u00020T2\u0011\u0010I\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\bH¢\u0006\u0002\u0010UJ\r\u0010V\u001a\u00020\u0006H\u0017¢\u0006\u0002\u0010WJ\u0010\u0010X\u001a\u0002072\u0006\u0010Y\u001a\u00020ZH\u0016J&\u0010[\u001a\u00020\u00062\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\\\u001a\u00020!J\u0006\u0010]\u001a\u00020\u0006J\u0006\u0010^\u001a\u00020\u0006J\u0012\u0010_\u001a\u0002072\b\u0010Y\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020!H\u0002J\b\u0010d\u001a\u00020\u001aH\u0002J\f\u0010e\u001a\u00020'*\u00020@H\u0002J\b\u0010f\u001a\u00020\u0006H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R/\u0010(\u001a\u0004\u0018\u00010'2\b\u0010&\u001a\u0004\u0018\u00010'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R/\u00100\u001a\u0004\u0018\u00010/2\b\u0010&\u001a\u0004\u0018\u00010/8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010.\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u00106\u001a\u0002078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b8\u00109R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\"\u0010E\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010G\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u0002070FX\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010I\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\bH2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\bH8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bN\u0010.\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010P\u001a\u0002072\u0006\u0010O\u001a\u000207@RX\u0094\u000e¢\u0006\b\n\u0000\u001a\u0004\bQ\u00109¨\u0006g"}, d2 = {"Landroidx/compose/material/internal/PopupLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onDismissRequest", "Lkotlin/Function0;", "", "testTag", "", "composeView", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "initialPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "popupId", "Ljava/util/UUID;", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroid/view/View;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/window/PopupPositionProvider;Ljava/util/UUID;)V", "getTestTag", "()Ljava/lang/String;", "setTestTag", "(Ljava/lang/String;)V", "windowManager", "Landroid/view/WindowManager;", "params", "Landroid/view/WindowManager$LayoutParams;", "positionProvider", "getPositionProvider", "()Landroidx/compose/ui/window/PopupPositionProvider;", "setPositionProvider", "(Landroidx/compose/ui/window/PopupPositionProvider;)V", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setParentLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "<set-?>", "Landroidx/compose/ui/unit/IntRect;", "parentBounds", "getParentBounds", "()Landroidx/compose/ui/unit/IntRect;", "setParentBounds", "(Landroidx/compose/ui/unit/IntRect;)V", "parentBounds$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/IntSize;", "popupContentSize", "getPopupContentSize-bOM6tXw", "()Landroidx/compose/ui/unit/IntSize;", "setPopupContentSize-fhxjrPA", "(Landroidx/compose/ui/unit/IntSize;)V", "popupContentSize$delegate", "canCalculatePosition", "", "getCanCalculatePosition", "()Z", "canCalculatePosition$delegate", "Landroidx/compose/runtime/State;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "previousWindowVisibleFrame", "Landroid/graphics/Rect;", "tmpWindowVisibleFrame", "subCompositionView", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "dismissOnOutsideClick", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "value", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "show", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "Content", "(Landroidx/compose/runtime/Composer;I)V", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "updateParameters", "layoutDirection", "updatePosition", "dismiss", "onTouchEvent", "Landroid/view/MotionEvent;", "setLayoutDirection", "", "superSetLayoutDirection", "createLayoutParams", "toIntBounds", "onGlobalLayout", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PopupLayout extends AbstractComposeView implements ViewRootForInspector, ViewTreeObserver.OnGlobalLayoutListener {
    private final State canCalculatePosition$delegate;
    private final View composeView;
    private final MutableState content$delegate;
    private final Function2<Offset, IntRect, Boolean> dismissOnOutsideClick;
    private final float maxSupportedElevation;
    private Function0<Unit> onDismissRequest;
    private final WindowManager.LayoutParams params;
    private final MutableState parentBounds$delegate;
    private LayoutDirection parentLayoutDirection;
    private final MutableState popupContentSize$delegate;
    private PopupPositionProvider positionProvider;
    private final Rect previousWindowVisibleFrame;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private String testTag;
    private final Rect tmpWindowVisibleFrame;
    private final WindowManager windowManager;

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

    private static final Unit Content$lambda$3(PopupLayout r0, int r1, Composer r2, int r3) {
        r0.Content(r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ boolean b(Offset r0, IntRect r1) {
        return dismissOnOutsideClick$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit c(PopupLayout r0, int r1, Composer r2, int r3) {
        return Content$lambda$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean e(PopupLayout r0) {
        return canCalculatePosition_delegate$lambda$0(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        ViewTreeLifecycleOwner.set(this, null);
        this.composeView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.windowManager.removeViewImmediate(this);
    }

    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    public final /* synthetic */ View getViewRoot() {
        return ViewRootForInspector.-CC.$default$getViewRoot(this);
    }

    public void setLayoutDirection(int r1) {
    }

    private final WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();
        r0.gravity = 8388659;
        r0.flags = 393248;
        r0.softInputMode = 1;
        r0.type = 1000;
        r0.token = this.composeView.getApplicationWindowToken();
        r0.width = -2;
        r0.height = -2;
        r0.format = -3;
        r0.setTitle(this.composeView.getContext().getResources().getString(2131896084));
        return r0;
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        return (Function2) this.content$delegate.getValue();
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.canCalculatePosition$delegate.getValue()).booleanValue();
    }

    public final IntRect getParentBounds() {
        return (IntRect) this.parentBounds$delegate.getValue();
    }

    /* JADX INFO: renamed from: getPopupContentSize-bOM6tXw, reason: not valid java name */
    public final IntSize m2246getPopupContentSizebOM6tXw() {
        return (IntSize) this.popupContentSize$delegate.getValue();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.composeView.getWindowVisibleDisplayFrame(this.tmpWindowVisibleFrame);
        if (Intrinsics.areEqual(this.tmpWindowVisibleFrame, this.previousWindowVisibleFrame) == true) goto L6;
        updatePosition();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        INVOKEINTERFACE_androidx_compose_material_internal_PopupLayout_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(this.windowManager, this, this.params);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updatePosition() {
        IntRect r1 = getParentBounds();
        if (r1 != null) goto L5;
        return;
    L5:
        IntSize r0 = m2246getPopupContentSizebOM6tXw();
        if (r0 == null) goto L9;
        long r5 = r0.unbox-impl();
        Rect r2 = this.previousWindowVisibleFrame;
        this.composeView.getWindowVisibleDisplayFrame(r2);
        IntRect r3 = toIntBounds(r2);
        int r4 = r3.getWidth();
        long r6 = IntSize.constructor-impl((((long) r4) << 32) | (((long) r3.getHeight()) & 4294967295L));
        long r7 = this.positionProvider.calculatePosition-llwVHH4(r1, r6, this.parentLayoutDirection, r5);
        WindowManager.LayoutParams r8 = this.params;
        r8.x = IntOffset.getX-impl(r7);
        WindowManager.LayoutParams r9 = this.params;
        r9.y = IntOffset.getY-impl(r7);
        this.windowManager.updateViewLayout(this, this.params);
        return;
    }

    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    public final PopupPositionProvider getPositionProvider() {
        return this.positionProvider;
    }

    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final String getTestTag() {
        return this.testTag;
    }

    private static final boolean canCalculatePosition_delegate$lambda$0(PopupLayout r1) {
        if (r1.getParentBounds() != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.m2246getPopupContentSizebOM6tXw() == null) goto L7;
        return true;
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> r2) {
        this.content$delegate.setValue(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void superSetLayoutDirection(LayoutDirection r3) {
        int r4 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        int r0 = 1;
        if (r4 != 1) goto L5;
        r0 = 0;
    L10:
        super/*android.view.ViewGroup*/.setLayoutDirection(r0);
        return;
    L5:
        if (r4 == 2) goto L10;
        throw new NoWhenBranchMatchedException();
    }

    private final IntRect toIntBounds(Rect r5) {
        return new IntRect(r5.left, r5.top, r5.right, r5.bottom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchKeyEvent(KeyEvent r4) {
        if (r4.getKeyCode() != 4) goto L5;
    L6:
        KeyEvent.DispatcherState r0 = getKeyDispatcherState();
        if (r0 != null) goto L11;
        return super/*android.view.ViewGroup*/.dispatchKeyEvent(r4);
    L11:
        if (r4.getAction() != 0) goto L17;
        if (r4.getRepeatCount() != 0) goto L17;
        r0.startTracking(r4, this);
        return true;
    L17:
        if (r4.getAction() == 1) goto L19;
    L27:
        return super/*android.view.ViewGroup*/.dispatchKeyEvent(r4);
    L19:
        if (r0.isTracking(r4) == false) goto L27;
        if (r4.isCanceled() == true) goto L27;
        Function0<Unit> r5 = this.onDismissRequest;
        if (r5 == null) goto L25;
        r5.invoke();
    L25:
        return true;
    L5:
        if (r4.getKeyCode() != 111) goto L27;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r13) {
        if (r13 != null) goto L6;
        return super/*android.view.ViewGroup*/.onTouchEvent(r13);
    L6:
        if (r13.getAction() != 0) goto L16;
        if (r13.getX() >= MenuKt.ClosedAlphaTarget) goto L10;
    L17:
        IntRect r0 = getParentBounds();
        if (r0 == null) goto L33;
        Function2<Offset, IntRect, Boolean> r3 = this.dismissOnOutsideClick;
        boolean r5 = false;
        if (r13.getRawX() != MenuKt.ClosedAlphaTarget) goto L22;
        boolean r4 = true;
    L23:
        if (r4 == false) goto L25;
    L30:
        Offset r1 = null;
    L32:
        if (((Boolean) r3.invoke(r1, r0)).booleanValue() == true) goto L33;
    L34:
        if (r5 == false) goto L40;
        Function0<Unit> r14 = this.onDismissRequest;
        if (r14 == null) goto L38;
        r14.invoke();
    L38:
        return true;
    L40:
        return super/*android.view.ViewGroup*/.onTouchEvent(r13);
    L25:
        if (r13.getRawY() != MenuKt.ClosedAlphaTarget) goto L27;
        boolean r2 = true;
    L28:
        if (r2 == true) goto L30;
        float r6 = r13.getRawX();
        float r7 = r13.getRawY();
        r1 = Offset.box-impl(Offset.constructor-impl((Float.floatToRawIntBits(r6) << 32) | (((long) Float.floatToRawIntBits(r7)) & 4294967295L)));
        goto L32
    L27:
        r2 = false;
        goto L28
    L22:
        r4 = false;
    L33:
        r5 = true;
        goto L34
    L10:
        if (r13.getX() >= getWidth()) goto L17;
        if (r13.getY() < MenuKt.ClosedAlphaTarget) goto L17;
        if (r13.getY() >= getHeight()) goto L17;
    L16:
        if (r13.getAction() != 4) goto L40;
        goto L17
    }

    public final void setParentBounds(IntRect r2) {
        this.parentBounds$delegate.setValue(r2);
    }

    public final void setParentLayoutDirection(LayoutDirection r1) {
        this.parentLayoutDirection = r1;
    }

    /* JADX INFO: renamed from: setPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m2247setPopupContentSizefhxjrPA(IntSize r2) {
        this.popupContentSize$delegate.setValue(r2);
    }

    public final void setPositionProvider(PopupPositionProvider r1) {
        this.positionProvider = r1;
    }

    public final void setTestTag(String r1) {
        this.testTag = r1;
    }

    private static final boolean dismissOnOutsideClick$lambda$1(Offset r5, IntRect r6) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (Float.intBitsToFloat((int) (r5.unbox-impl() >> 32)) >= r6.getLeft()) goto L8;
    L13:
        return true;
    L8:
        if (Float.intBitsToFloat((int) (r5.unbox-impl() >> 32)) > r6.getRight()) goto L13;
        if (Float.intBitsToFloat((int) (r5.unbox-impl() & 4294967295L)) < r6.getTop()) goto L13;
        if (Float.intBitsToFloat((int) (r5.unbox-impl() & 4294967295L)) > r6.getBottom()) goto L13;
        return false;
    }

    public void Content(Composer r6, final int r7) {
        Composer r8 = r6.startRestartGroup(-864350873);
        if ((r7 & 6) == 0) goto L5;
        int r1 = r7;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r8.shouldExecute(r2, r1 & 1) == true) goto L17;
        r8.skipToGroupEnd();
    L23:
        ScopeUpdateScope r9 = r8.endRestartGroup();
        if (r9 == null) goto L27;
        r9.updateScope(new m(this, r7));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-864350873, r1, -1, "androidx.compose.material.internal.PopupLayout.Content (ExposedDropdownMenuPopup.android.kt:303)");
    L19:
        getContent().invoke(r8, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r2 = false;
        goto L15
    L5:
        if (r8.changedInstance(this) == false) goto L7;
        int r3 = 4;
    L8:
        r1 = r3 | r7;
        goto L11
    L7:
        r3 = 2;
        goto L8
    }

    public final void setContent(CompositionContext r1, Function2<? super Composer, ? super Integer, Unit> r2) {
        setParentCompositionContext(r1);
        setContent(r2);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    public static void INVOKEINTERFACE_androidx_compose_material_internal_PopupLayout_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(WindowManager r0, View r1, ViewGroup.LayoutParams r2) {
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r1, r2);
        r0.addView(r1, r2);
    }

    public final void updateParameters(Function0<Unit> r1, String r2, LayoutDirection r3) {
        this.onDismissRequest = r1;
        this.testTag = r2;
        superSetLayoutDirection(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PopupLayout(Function0<Unit> r7, String r8, View r9, Density r10, PopupPositionProvider r11, UUID r12) {
        super(r9.getContext(), null, 0, 6, null);
        this.onDismissRequest = r7;
        this.testTag = r8;
        this.composeView = r9;
        Object r13 = r9.getContext().getSystemService("window");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) r13;
        this.params = createLayoutParams();
        this.positionProvider = r11;
        this.parentLayoutDirection = LayoutDirection.Ltr;
        this.parentBounds$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.popupContentSize$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.canCalculatePosition$delegate = SnapshotStateKt.derivedStateOf(new k(this));
        float r14 = Dp.constructor-impl(8);
        this.maxSupportedElevation = r14;
        this.previousWindowVisibleFrame = new Rect();
        this.tmpWindowVisibleFrame = new Rect();
        this.dismissOnOutsideClick = new l();
        setId(R.id.content);
        ViewTreeLifecycleOwner.set(this, ViewTreeLifecycleOwner.get(r9));
        ViewTreeViewModelStoreOwner.set(this, ViewTreeViewModelStoreOwner.get(r9));
        ViewTreeSavedStateRegistryOwner.set(this, ViewTreeSavedStateRegistryOwner.get(r9));
        r9.getViewTreeObserver().addOnGlobalLayoutListener(this);
        setTag(2131367616, "Popup:" + r12);
        setClipChildren(false);
        setElevation(r10.toPx-0680j_4(r14));
        setOutlineProvider(new AnonymousClass2());
        this.content$delegate = SnapshotStateKt.mutableStateOf$default(ComposableSingletons$ExposedDropdownMenuPopup_androidKt.INSTANCE.m2241getLambda$1578637197$material(), null, 2, null);
    }
}
