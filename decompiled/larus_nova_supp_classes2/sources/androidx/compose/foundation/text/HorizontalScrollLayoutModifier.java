package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tHÆ\u0003J9\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Landroidx/compose/foundation/text/HorizontalScrollLayoutModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "cursorOffset", "", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "<init>", "(Landroidx/compose/foundation/text/TextFieldScrollerPosition;ILandroidx/compose/ui/text/input/TransformedText;Lkotlin/jvm/functions/Function0;)V", "getScrollerPosition", "()Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "getCursorOffset", "()I", "getTransformedText", "()Landroidx/compose/ui/text/input/TransformedText;", "getTextLayoutResultProvider", "()Lkotlin/jvm/functions/Function0;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class HorizontalScrollLayoutModifier implements LayoutModifier {
    private final int cursorOffset;
    private final TextFieldScrollerPosition scrollerPosition;
    private final Function0<TextLayoutResultProxy> textLayoutResultProvider;
    private final TransformedText transformedText;

    public static /* synthetic */ Unit a(HorizontalScrollLayoutModifier r0, MeasureScope r1, Placeable r2, int r3, Placeable.PlacementScope r4) {
        return measure_3p2s80s$lambda$0(r0, r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HorizontalScrollLayoutModifier copy$default(HorizontalScrollLayoutModifier r0, TextFieldScrollerPosition r1, int r2, TransformedText r3, Function0 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.scrollerPosition;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.cursorOffset;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.transformedText;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.textLayoutResultProvider;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final /* synthetic */ boolean all(Function1 r1) {
        return Modifier.Element.-CC.$default$all(this, r1);
    }

    public final /* synthetic */ boolean any(Function1 r1) {
        return Modifier.Element.-CC.$default$any(this, r1);
    }

    public final TextFieldScrollerPosition component1() {
        return this.scrollerPosition;
    }

    public final int component2() {
        return this.cursorOffset;
    }

    public final TransformedText component3() {
        return this.transformedText;
    }

    public final Function0<TextLayoutResultProxy> component4() {
        return this.textLayoutResultProvider;
    }

    public final HorizontalScrollLayoutModifier copy(TextFieldScrollerPosition r2, int r3, TransformedText r4, Function0<TextLayoutResultProxy> r5) {
        return new HorizontalScrollLayoutModifier(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HorizontalScrollLayoutModifier) == true) goto L8;
        return false;
    L8:
        HorizontalScrollLayoutModifier r6 = (HorizontalScrollLayoutModifier) r5;
        if (Intrinsics.areEqual(this.scrollerPosition, r6.scrollerPosition) == true) goto L12;
        return false;
    L12:
        if (this.cursorOffset == r6.cursorOffset) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.transformedText, r6.transformedText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textLayoutResultProvider, r6.textLayoutResultProvider) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final /* synthetic */ Object foldIn(Object r1, Function2 r2) {
        return Modifier.Element.-CC.$default$foldIn(this, r1, r2);
    }

    public final /* synthetic */ Object foldOut(Object r1, Function2 r2) {
        return Modifier.Element.-CC.$default$foldOut(this, r1, r2);
    }

    public int hashCode() {
        return (((((this.scrollerPosition.hashCode() * 31) + this.cursorOffset) * 31) + this.transformedText.hashCode()) * 31) + this.textLayoutResultProvider.hashCode();
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifier.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifier.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifier.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifier.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ Modifier then(Modifier r1) {
        return Modifier.-CC.$default$then(this, r1);
    }

    public String toString() {
        return "HorizontalScrollLayoutModifier(scrollerPosition=" + this.scrollerPosition + ", cursorOffset=" + this.cursorOffset + ", transformedText=" + this.transformedText + ", textLayoutResultProvider=" + this.textLayoutResultProvider + ')';
    }

    public final int getCursorOffset() {
        return this.cursorOffset;
    }

    public final TextFieldScrollerPosition getScrollerPosition() {
        return this.scrollerPosition;
    }

    public final Function0<TextLayoutResultProxy> getTextLayoutResultProvider() {
        return this.textLayoutResultProvider;
    }

    public final TransformedText getTransformedText() {
        return this.transformedText;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1368measure3p2s80s(final MeasureScope r11, Measurable r12, long r13) {
        if (r12.maxIntrinsicWidth(Constraints.getMaxHeight-impl(r13)) >= Constraints.getMaxWidth-impl(r13)) goto L5;
        long r0 = r13;
    L6:
        final Placeable r14 = r12.measure-BRTryo0(r0);
        final int r2 = Math.min(r14.getWidth(), Constraints.getMaxWidth-impl(r13));
        return MeasureScope.-CC.layout$default(r11, r2, r14.getHeight(), null, new r2(this, r11, r14, r2), 4, null);
    L5:
        r0 = Constraints.copy-Zbe2FdA$default(r13, 0, Integer.MAX_VALUE, 0, 0, 13, null);
        goto L6
    }

    public HorizontalScrollLayoutModifier(TextFieldScrollerPosition r1, int r2, TransformedText r3, Function0<TextLayoutResultProxy> r4) {
        this.scrollerPosition = r1;
        this.cursorOffset = r2;
        this.transformedText = r3;
        this.textLayoutResultProvider = r4;
    }

    private static final Unit measure_3p2s80s$lambda$0(HorizontalScrollLayoutModifier r7, MeasureScope r8, Placeable r9, int r10, Placeable.PlacementScope r11) {
        int r1 = r7.cursorOffset;
        TransformedText r2 = r7.transformedText;
        TextLayoutResultProxy r0 = (TextLayoutResultProxy) r7.textLayoutResultProvider.invoke();
        if (r0 == null) goto L5;
        TextLayoutResult r3 = r0.getValue();
    L6:
        TextLayoutResult r4 = r3;
        if (r8.getLayoutDirection() != LayoutDirection.Rtl) goto L9;
        boolean r5 = true;
    L10:
        Rect r12 = TextFieldScrollKt.access$getCursorRectInScroller(r11, r1, r2, r4, r5, r9.getWidth());
        r7.scrollerPosition.update(Orientation.Horizontal, r12, r10, r9.getWidth());
        Placeable.PlacementScope.placeRelative$default(r11, r9, Math.round(-r7.scrollerPosition.getOffset()), 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    L9:
        r5 = false;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
