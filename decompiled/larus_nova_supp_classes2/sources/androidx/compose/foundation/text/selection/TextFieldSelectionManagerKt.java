package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u001f\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"TextFieldSelectionHandle", "", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(ZLandroidx/compose/ui/text/style/ResolvedTextDirection;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "isSelectionHandleInVisibleBound", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;J)J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldSelectionManagerKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Handle.values().length];
            r0[Handle.Cursor.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Handle.SelectionStart.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Handle.SelectionEnd.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private static final Unit TextFieldSelectionHandle$lambda$3(boolean r0, ResolvedTextDirection r1, TextFieldSelectionManager r2, int r3, Composer r4, int r5) {
        TextFieldSelectionHandle(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(boolean r0, ResolvedTextDirection r1, TextFieldSelectionManager r2, int r3, Composer r4, int r5) {
        return TextFieldSelectionHandle$lambda$3(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m1909calculateSelectionMagnifierCenterAndroidO0kMr_c(TextFieldSelectionManager r8, long r9) {
        Offset r0 = r8.m1901getCurrentDragPosition_m7T9E();
        if (r0 == null) goto L57;
        long r1 = r0.unbox-impl();
        AnnotatedString r2 = r8.getTransformedText$foundation_release();
        if (r2 != null) goto L7;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L15;
        Handle r4 = r8.getDraggingHandle();
        if (r4 != null) goto L19;
        int r5 = -1;
    L20:
        if (r5 == (-1)) goto L55;
        if (r5 == 1) goto L29;
        if (r5 == 2) goto L29;
        if (r5 != 3) goto L28;
        int r6 = TextRange.getEnd-impl(r8.getValue$foundation_release().getSelection-d9O1mEE());
    L30:
        LegacyTextFieldState r7 = r8.getState$foundation_release();
        if (r7 == null) goto L53;
        TextLayoutResultProxy r10 = r7.getLayoutResult();
        if (r10 == null) goto L53;
        LegacyTextFieldState r11 = r8.getState$foundation_release();
        if (r11 == null) goto L51;
        TextDelegate r12 = r11.getTextDelegate();
        if (r12 == null) goto L51;
        AnnotatedString r13 = r12.getText();
        if (r13 == null) goto L51;
        int r14 = RangesKt.coerceIn(r8.getOffsetMapping$foundation_release().originalToTransformed(r6), 0, r13.length());
        float r15 = Float.intBitsToFloat((int) (r10.m1483translateDecorationToInnerCoordinatesMKHz9U$foundation_release(r1) >> 32));
        TextLayoutResult r16 = r10.getValue();
        int r17 = r16.getLineForOffset(r14);
        float r18 = r16.getLineLeft(r17);
        float r19 = r16.getLineRight(r17);
        float r20 = RangesKt.coerceIn(r15, Math.min(r18, r19), Math.max(r18, r19));
        if (IntSize.equals-impl0(r9, IntSize.Companion.getZero-YbymL2g()) == false) goto L45;
    L48:
        float r21 = r16.getLineTop(r17);
        float r22 = ((r16.getLineBottom(r17) - r21) / 2) + r21;
        return Offset.constructor-impl((Float.floatToRawIntBits(r20) << 32) | (Float.floatToRawIntBits(r22) & 4294967295L));
    L45:
        if (Math.abs(r15 - r20) <= (((int) (r9 >> 32)) / 2)) goto L48;
        return Offset.Companion.getUnspecified-F1C5BW0();
    L51:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L53:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L28:
        throw new NoWhenBranchMatchedException();
    L29:
        r6 = TextRange.getStart-impl(r8.getValue$foundation_release().getSelection-d9O1mEE());
        goto L30
    L55:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L19:
        r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        goto L20
    L15:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L7:
        if (r2.length() != 0) goto L9;
        boolean r23 = true;
    L10:
        if (r23 == true) goto L12;
        r3 = true;
        goto L13
    L9:
        r23 = false;
        goto L10
    L57:
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    public static final boolean isSelectionHandleInVisibleBound(TextFieldSelectionManager r1, boolean r2) {
        LegacyTextFieldState r0 = r1.getState$foundation_release();
        if (r0 == null) goto L9;
        LayoutCoordinates r3 = r0.getLayoutCoordinates();
        if (r3 == null) goto L9;
        Rect r4 = SelectionManagerKt.visibleBounds(r3);
        if (r4 == null) goto L9;
        return SelectionManagerKt.m1878containsInclusiveUv8p0NA(r4, r1.m1903getHandlePositiontuRUvjQ$foundation_release(r2));
    L9:
        return false;
    }

    public static final void TextFieldSelectionHandle(final boolean r15, final ResolvedTextDirection r16, final TextFieldSelectionManager r17, Composer r18, final int r19) {
        Composer r14 = r18.startRestartGroup(-1344558920);
        if ((r19 & 6) == 0) goto L5;
        int r1 = r19;
    L11:
        if ((r19 & 48) != 0) goto L18;
        if (r14.changed(r16.ordinal()) == false) goto L15;
        int r3 = 32;
    L16:
        r1 = r1 | r3;
        goto L18
    L15:
        r3 = 16;
    L18:
        if ((r19 & 384) == 0) goto L20;
    L24:
        boolean r5 = false;
        if ((r1 & 147) == 146) goto L27;
        boolean r4 = true;
    L29:
        if (r14.shouldExecute(r4, r1 & 1) == true) goto L31;
        r14.skipToGroupEnd();
    L59:
        ScopeUpdateScope r0 = r14.endRestartGroup();
        if (r0 == null) goto L63;
        r0.updateScope(new e2(r15, r16, r17, r19));
        return;
    L63:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-1344558920, r1, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:1249)");
    L33:
        int r2 = r1 & 14;
        if (r2 != 4) goto L36;
        boolean r6 = true;
    L37:
        boolean r7 = r6 | r14.changed(r17);
        Object r8 = r14.rememberedValue();
        if (r7 == false) goto L40;
    L41:
        r8 = r17.handleDragObserver$foundation_release(r15);
        r14.updateRememberedValue(r8);
    L42:
        final TextDragObserver r9 = (TextDragObserver) r8;
        boolean r10 = r14.changedInstance(r17);
        if (r2 != 4) goto L45;
        r5 = true;
    L45:
        boolean r11 = r10 | r5;
        Object r12 = r14.rememberedValue();
        if (r11 == false) goto L48;
    L49:
        r12 = new TextFieldSelectionManagerKt$TextFieldSelectionHandle$1$1(r17, r15);
        r14.updateRememberedValue(r12);
    L50:
        OffsetProvider r13 = (OffsetProvider) r12;
        boolean r20 = TextRange.getReversed-impl(r17.getValue$foundation_release().getSelection-d9O1mEE());
        float r21 = r17.getHandleLineHeight$foundation_release(r15);
        Modifier.Companion r22 = Modifier.Companion;
        boolean r23 = r14.changedInstance(r9);
        Object r24 = r14.rememberedValue();
        if (r23 == false) goto L53;
    L54:
        r24 = new TextFieldSelectionManagerKt$TextFieldSelectionHandle$2$1(r9);
        r14.updateRememberedValue(r24);
    L55:
        int r25 = r1 << 3;
        AndroidSelectionHandles_androidKt.m1824SelectionHandlewLIcFTc(r13, r15, r16, r20, 0, r21, SuspendingPointerInputFilterKt.pointerInput(r22, r9, (PointerInputEventHandler) r24), r14, (r25 & 112) | (r25 & 896), 16);
        if (ComposerKt.isTraceInProgress() == false) goto L59;
        ComposerKt.traceEventEnd();
        goto L59
    L53:
        if (r24 != Composer.Companion.getEmpty()) goto L55;
    L48:
        if (r12 != Composer.Companion.getEmpty()) goto L50;
    L40:
        if (r8 != Composer.Companion.getEmpty()) goto L42;
    L36:
        r6 = false;
        goto L37
    L27:
        r4 = false;
        goto L29
    L20:
        if (r14.changedInstance(r17) == false) goto L22;
        int r26 = 256;
    L23:
        r1 = r1 | r26;
        goto L24
    L22:
        r26 = 128;
        goto L23
    L5:
        if (r14.changed(r15) == false) goto L7;
        int r27 = 4;
    L8:
        r1 = r27 | r19;
        goto L11
    L7:
        r27 = 2;
        goto L8
    }
}
