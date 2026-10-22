package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/modifiers/SelectionController;", "Landroidx/compose/runtime/RememberObserver;", "selectableId", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "backgroundSelectionColor", "Landroidx/compose/ui/graphics/Color;", "params", "Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "<init>", "(JLandroidx/compose/foundation/text/selection/SelectionRegistrar;JLandroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "onRemembered", "", "onForgotten", "onAbandoned", "updateTextLayout", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "updateGlobalPosition", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "draw", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectionController implements RememberObserver {
    public static final int $stable = 8;
    private final long backgroundSelectionColor;
    private final Modifier modifier;
    private StaticTextSelectionParams params;
    private Selectable selectable;
    private final long selectableId;
    private final SelectionRegistrar selectionRegistrar;

    public /* synthetic */ SelectionController(long r1, SelectionRegistrar r3, long r4, StaticTextSelectionParams r6, DefaultConstructorMarker r7) {
        this(r1, r3, r4, r6);
    }

    public static /* synthetic */ TextLayoutResult a(SelectionController r0) {
        return onRemembered$lambda$2(r0);
    }

    public static /* synthetic */ LayoutCoordinates b(SelectionController r0) {
        return modifier$lambda$0(r0);
    }

    public static /* synthetic */ LayoutCoordinates c(SelectionController r0) {
        return onRemembered$lambda$1(r0);
    }

    public void onAbandoned() {
        Selectable r0 = this.selectable;
        if (r0 == null) goto L6;
        this.selectionRegistrar.unsubscribe(r0);
        this.selectable = null;
        return;
    }

    public void onForgotten() {
        Selectable r0 = this.selectable;
        if (r0 == null) goto L6;
        this.selectionRegistrar.unsubscribe(r0);
        this.selectable = null;
        return;
    }

    public void onRemembered() {
        this.selectable = this.selectionRegistrar.subscribe(new MultiWidgetSelectionDelegate(this.selectableId, new a(this), new b(this)));
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    private static final LayoutCoordinates modifier$lambda$0(SelectionController r0) {
        return r0.params.getLayoutCoordinates();
    }

    private static final LayoutCoordinates onRemembered$lambda$1(SelectionController r0) {
        return r0.params.getLayoutCoordinates();
    }

    private static final TextLayoutResult onRemembered$lambda$2(SelectionController r0) {
        return r0.params.getTextLayoutResult();
    }

    public final void draw(DrawScope r14) {
        Selection r0 = this.selectionRegistrar.getSubselections().get(this.selectableId);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getHandlesCrossed() == true) goto L8;
        int r1 = r0.getStart().getOffset();
    L10:
        if (r0.getHandlesCrossed() == true) goto L12;
        int r2 = r0.getEnd().getOffset();
    L13:
        if (r1 != r2) goto L15;
        return;
    L15:
        Selectable r3 = this.selectable;
        if (r3 == null) goto L18;
        int r4 = r3.getLastVisibleOffset();
    L19:
        int r5 = RangesKt.coerceAtMost(r1, r4);
        int r6 = RangesKt.coerceAtMost(r2, r4);
        Path r7 = this.params.getPathForRange(r5, r6);
        if (r7 != null) goto L23;
        return;
    L23:
        if (this.params.getShouldClip() == false) goto L30;
        float r8 = Float.intBitsToFloat((int) (r14.getSize-NH-jbRc() >> 32));
        float r9 = Float.intBitsToFloat((int) (r14.getSize-NH-jbRc() & 4294967295L));
        int r10 = ClipOp.Companion.getIntersect-rtfAjoo();
        DrawContext r11 = r14.getDrawContext();
        long r12 = r11.getSize-NH-jbRc();
        r11.getCanvas().save();
        r11.getTransform().clipRect-N_I0leg(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r8, r9, r10);     // Catch: Throwable -> L27
        DrawScope.-CC.drawPath-LG529CI$default(r14, r7, this.backgroundSelectionColor, MenuKt.ClosedAlphaTarget, null, null, 0, 60, null);     // Catch: Throwable -> L27
        r11.getCanvas().restore();
        r11.setSize-uvyYCjk(r12);
        return;
    L27:
        th = move-exception;
        r11.getCanvas().restore();
        r11.setSize-uvyYCjk(r12);
        throw th;
    L30:
        DrawScope.-CC.drawPath-LG529CI$default(r14, r7, this.backgroundSelectionColor, MenuKt.ClosedAlphaTarget, null, null, 0, 60, null);
        return;
    L18:
        r4 = 0;
        goto L19
    L12:
        r2 = r0.getStart().getOffset();
        goto L13
    L8:
        r1 = r0.getEnd().getOffset();
        goto L10
    }

    public final void updateGlobalPosition(LayoutCoordinates r4) {
        this.params = StaticTextSelectionParams.copy$default(this.params, r4, null, 2, null);
        this.selectionRegistrar.notifyPositionChange(this.selectableId);
    }

    public final void updateTextLayout(TextLayoutResult r4) {
        TextLayoutResult r0 = this.params.getTextLayoutResult();
        if (r0 != null) goto L5;
    L7:
        this.params = StaticTextSelectionParams.copy$default(this.params, null, r4, 1, null);
        return;
    L5:
        if (Intrinsics.areEqual(r0.getLayoutInput().getText(), r4.getLayoutInput().getText()) == true) goto L7;
        this.selectionRegistrar.notifySelectableChange(this.selectableId);
        goto L7
    }

    private SelectionController(long r1, SelectionRegistrar r3, long r4, StaticTextSelectionParams r6) {
        this.selectableId = r1;
        this.selectionRegistrar = r3;
        this.backgroundSelectionColor = r4;
        this.params = r6;
        this.modifier = PointerIconKt.pointerHoverIcon$default(SelectionControllerKt.access$makeSelectionModifier(r3, r1, new c(this)), PointerIcon.Companion.getText(), false, 2, null);
    }

    public /* synthetic */ SelectionController(long r10, SelectionRegistrar r12, long r13, StaticTextSelectionParams r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 8) == 0) goto L5;
        StaticTextSelectionParams r7 = StaticTextSelectionParams.Companion.getEmpty();
    L6:
        this(r10, r12, r13, r7, null);
        return;
    L5:
        r7 = r15;
        goto L6
    }
}
