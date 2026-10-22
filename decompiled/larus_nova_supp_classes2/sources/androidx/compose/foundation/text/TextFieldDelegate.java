package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/text/TextFieldDelegate;", "", "<init>", "()V", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDelegate {
    public static final int $stable = 0;
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u000f\u0010\u0010JO\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0004\b!\u0010\"J7\u0010#\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001eH\u0002¢\u0006\u0004\b&\u0010'JE\u0010(\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b/J-\u00100\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,2\u0006\u00101\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u000202H\u0001¢\u0006\u0002\b3JA\u00104\u001a\u00020\u00122\f\u00105\u001a\b\u0012\u0004\u0012\u000207062\u0006\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;2\b\u0010<\u001a\u0004\u0018\u00010,H\u0001¢\u0006\u0002\b=JC\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@2\u0006\u0010\u001c\u001a\u0002022\u0006\u00108\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;H\u0001¢\u0006\u0004\bA\u0010BJU\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020E2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00108\u001a\u0002092\u0006\u0010F\u001a\u00020G2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00120;H\u0001¢\u0006\u0002\bJJU\u0010K\u001a\u00020,2\u0006\u0010D\u001a\u00020E2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00108\u001a\u0002092\u0006\u0010F\u001a\u00020G2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00120;H\u0001¢\u0006\u0002\bLJ1\u0010M\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,2\u0006\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;H\u0001¢\u0006\u0002\bNJ\u001d\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00182\u0006\u0010R\u001a\u00020P¢\u0006\u0004\bS\u0010T¨\u0006U"}, d2 = {"Landroidx/compose/foundation/text/TextFieldDelegate$Companion;", "", "<init>", "()V", "layout", "Lkotlin/Triple;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "prevResultText", "layout-_EkL_-Y$foundation_release", "(Landroidx/compose/foundation/text/TextDelegate;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextLayoutResult;)Lkotlin/Triple;", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "selectionPreviewHighlightRange", "Landroidx/compose/ui/text/TextRange;", "deletionPreviewHighlightRange", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "highlightPaint", "Landroidx/compose/ui/graphics/Paint;", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "draw-Q1vqE60$foundation_release", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/text/input/TextFieldValue;JJLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Paint;J)V", "drawHighlight", "range", "paint", "drawHighlight-Le-punE", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Paint;)V", "notifyFocusedRect", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "hasFocus", "", "notifyFocusedRect$foundation_release", "updateTextLayoutResult", "textFieldValue", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "updateTextLayoutResult$foundation_release", "onEditCommand", "ops", "", "Landroidx/compose/ui/text/input/EditCommand;", "editProcessor", "Landroidx/compose/ui/text/input/EditProcessor;", "onValueChange", "Lkotlin/Function1;", "session", "onEditCommand$foundation_release", "setCursorOffset", "position", "Landroidx/compose/ui/geometry/Offset;", "setCursorOffset-ULxng0E$foundation_release", "(JLandroidx/compose/foundation/text/TextLayoutResultProxy;Landroidx/compose/ui/text/input/EditProcessor;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/jvm/functions/Function1;)V", "restartInput", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "restartInput$foundation_release", "onFocus", "onFocus$foundation_release", "onBlur", "onBlur$foundation_release", "applyCompositionDecoration", "Landroidx/compose/ui/text/input/TransformedText;", "compositionRange", "transformed", "applyCompositionDecoration-72CqOWE", "(JLandroidx/compose/ui/text/input/TransformedText;)Landroidx/compose/ui/text/input/TransformedText;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ Unit a(EditProcessor r0, Function1 r1, Ref.ObjectRef r2, List r3) {
            return restartInput$lambda$4(r0, r1, r2, r3);
        }

        public static /* synthetic */ IntSize b(TextDelegate r0) {
            return notifyFocusedRect$lambda$1(r0);
        }

        private static final IntSize notifyFocusedRect$lambda$1(TextDelegate r7) {
            return IntSize.box-impl(TextFieldDelegateKt.computeSizeForDefaultText$default(r7.getStyle(), r7.getDensity(), r7.getFontFamilyResolver(), null, 0, 24, null));
        }

        /* JADX INFO: renamed from: applyCompositionDecoration-72CqOWE, reason: not valid java name */
        public final TransformedText m1457applyCompositionDecoration72CqOWE(long r28, TransformedText r30) {
            int r0 = r30.getOffsetMapping().originalToTransformed(TextRange.getStart-impl(r28));
            int r1 = r30.getOffsetMapping().originalToTransformed(TextRange.getEnd-impl(r28));
            int r2 = Math.min(r0, r1);
            int r3 = Math.max(r0, r1);
            AnnotatedString.Builder r4 = new AnnotatedString.Builder(r30.getText());
            r4.addStyle(new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, TextDecoration.Companion.getUnderline(), null, null, null, 61439, null), r2, r3);
            return new TransformedText(r4.toAnnotatedString(), r30.getOffsetMapping());
        }

        @JvmStatic
        public final void onBlur$foundation_release(TextInputSession r8, EditProcessor r9, Function1<? super TextFieldValue, Unit> r10) {
            r10.invoke(TextFieldValue.copy-3r_uNRQ$default(r9.toTextFieldValue(), null, 0, null, 3, null));
            r8.dispose();
        }

        private static final Unit restartInput$lambda$4(EditProcessor r1, Function1 r2, Ref.ObjectRef r3, List r4) {
            TextFieldDelegate.Companion.onEditCommand$foundation_release(r4, r1, r2, (TextInputSession) r3.element);
            return Unit.INSTANCE;
        }

        @JvmStatic
        /* JADX INFO: renamed from: layout-_EkL_-Y$foundation_release, reason: not valid java name */
        public final Triple<Integer, Integer, TextLayoutResult> m1459layout_EkL_Y$foundation_release(TextDelegate r3, long r4, LayoutDirection r6, TextLayoutResult r7) {
            TextLayoutResult r5 = r3.m1446layoutNN6EwU(r4, r6, r7);
            return new Triple(Integer.valueOf((int) (r5.getSize-YbymL2g() >> 32)), Integer.valueOf((int) (r5.getSize-YbymL2g() & 4294967295L)), r5);
        }

        @JvmStatic
        public final void onEditCommand$foundation_release(List<? extends EditCommand> r1, EditProcessor r2, Function1<? super TextFieldValue, Unit> r3, TextInputSession r4) {
            TextFieldValue r5 = r2.apply(r1);
            if (r4 == null) goto L5;
            r4.updateState(null, r5);
        L5:
            r3.invoke(r5);
        }

        @JvmStatic
        public final void updateTextLayoutResult$foundation_release(TextInputSession r10, TextFieldValue r11, OffsetMapping r12, TextLayoutResultProxy r13) {
            final LayoutCoordinates r0 = r13.getInnerTextFieldCoordinates();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isAttached() == true) goto L7;
            return;
        L7:
            LayoutCoordinates r1 = r13.getDecorationBoxCoordinates();
            if (r1 == null) goto L12;
            r10.updateTextLayoutResult(r11, r12, r13.getValue(), new TextFieldDelegate$Companion$updateTextLayoutResult$1$1$1(r0), SelectionManagerKt.visibleBounds(r0), r0.localBoundingBoxOf(r1, false));
            return;
        }

        /* JADX INFO: renamed from: drawHighlight-Le-punE, reason: not valid java name */
        private final void m1455drawHighlightLepunE(Canvas r2, long r3, OffsetMapping r5, TextLayoutResult r6, Paint r7) {
            int r0 = r5.originalToTransformed(TextRange.getMin-impl(r3));
            int r4 = r5.originalToTransformed(TextRange.getMax-impl(r3));
            if (r0 == r4) goto L6;
            r2.drawPath(r6.getPathForRange(r0, r4), r7);
            return;
        }

        @JvmStatic
        /* JADX INFO: renamed from: setCursorOffset-ULxng0E$foundation_release, reason: not valid java name */
        public final void m1460setCursorOffsetULxng0E$foundation_release(long r8, TextLayoutResultProxy r10, EditProcessor r11, OffsetMapping r12, Function1<? super TextFieldValue, Unit> r13) {
            int r9 = r12.transformedToOriginal(TextLayoutResultProxy.m1480getOffsetForPosition3MmeM6k$default(r10, r8, false, 2, null));
            r13.invoke(TextFieldValue.copy-3r_uNRQ$default(r11.toTextFieldValue(), null, TextRangeKt.TextRange(r9), null, 5, null));
        }

        @JvmStatic
        public final TextInputSession onFocus$foundation_release(TextInputService r1, TextFieldValue r2, EditProcessor r3, ImeOptions r4, Function1<? super TextFieldValue, Unit> r5, Function1<? super ImeAction, Unit> r6) {
            return restartInput$foundation_release(r1, r2, r3, r4, r5, r6);
        }

        @JvmStatic
        public final TextInputSession restartInput$foundation_release(TextInputService r3, TextFieldValue r4, final EditProcessor r5, ImeOptions r6, final Function1<? super TextFieldValue, Unit> r7, Function1<? super ImeAction, Unit> r8) {
            final Ref.ObjectRef r0 = new Ref.ObjectRef();
            TextInputSession r9 = r3.startInput(r4, r6, new k3(r5, r7, r0), r8);
            r0.element = r9;
            return r9;
        }

        /* JADX INFO: renamed from: layout-_EkL_-Y$foundation_release$default, reason: not valid java name */
        public static /* synthetic */ Triple m1456layout_EkL_Y$foundation_release$default(Companion r6, TextDelegate r7, long r8, LayoutDirection r10, TextLayoutResult r11, int r12, Object r13) {
            if ((r12 & 8) == 0) goto L6;
            r11 = null;
        L6:
            return r6.m1459layout_EkL_Y$foundation_release(r7, r8, r10, r11);
        }

        @JvmStatic
        public final void notifyFocusedRect$foundation_release(TextFieldValue r3, final TextDelegate r4, TextLayoutResult r5, LayoutCoordinates r6, TextInputSession r7, boolean r8, OffsetMapping r9) {
            if (r8 == true) goto L4;
            return;
        L4:
            r7.notifyFocusedRect(TextFieldDelegateKt.focusedRectInRoot(r5, r6, r9.originalToTransformed(TextRange.getMax-impl(r3.getSelection-d9O1mEE())), new j3(r4)));
        }

        @JvmStatic
        /* JADX INFO: renamed from: draw-Q1vqE60$foundation_release, reason: not valid java name */
        public final void m1458drawQ1vqE60$foundation_release(Canvas r11, TextFieldValue r12, long r13, long r15, OffsetMapping r17, TextLayoutResult r18, Paint r19, long r20) {
            if (TextRange.getCollapsed-impl(r13) == true) goto L6;
            r19.setColor-8_81llA(r20);
            m1455drawHighlightLepunE(r11, r13, r17, r18, r19);
        L21:
            TextPainter.INSTANCE.paint(r11, r18);
            return;
        L6:
            if (TextRange.getCollapsed-impl(r15) == true) goto L19;
            Color r0 = Color.box-impl(r18.getLayoutInput().getStyle().getColor-0d7_KjU());
            if (r0.unbox-impl() != 16) goto L10;
            boolean r1 = true;
        L11:
            if (r1 == false) goto L14;
            r0 = null;
        L14:
            if (r0 == null) goto L16;
            long r2 = r0.unbox-impl();
        L17:
            long r3 = r2;
            r19.setColor-8_81llA(Color.copy-wmQWz5c$default(r3, Color.getAlpha-impl(r3) * 0.2f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null));
            m1455drawHighlightLepunE(r11, r15, r17, r18, r19);
            goto L21
        L16:
            r2 = Color.Companion.getBlack-0d7_KjU();
            goto L17
        L10:
            r1 = false;
            goto L11
        L19:
            if (TextRange.getCollapsed-impl(r12.getSelection-d9O1mEE()) == true) goto L21;
            r19.setColor-8_81llA(r20);
            m1455drawHighlightLepunE(r11, r12.getSelection-d9O1mEE(), r17, r18, r19);
            goto L21
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TextFieldDelegate() {
    }

    @JvmStatic
    /* JADX INFO: renamed from: draw-Q1vqE60$foundation_release, reason: not valid java name */
    public static final void m1452drawQ1vqE60$foundation_release(Canvas r12, TextFieldValue r13, long r14, long r16, OffsetMapping r18, TextLayoutResult r19, Paint r20, long r21) {
        Companion.m1458drawQ1vqE60$foundation_release(r12, r13, r14, r16, r18, r19, r20, r21);
    }

    @JvmStatic
    /* JADX INFO: renamed from: layout-_EkL_-Y$foundation_release, reason: not valid java name */
    public static final Triple<Integer, Integer, TextLayoutResult> m1453layout_EkL_Y$foundation_release(TextDelegate r6, long r7, LayoutDirection r9, TextLayoutResult r10) {
        return Companion.m1459layout_EkL_Y$foundation_release(r6, r7, r9, r10);
    }

    @JvmStatic
    public static final void notifyFocusedRect$foundation_release(TextFieldValue r8, TextDelegate r9, TextLayoutResult r10, LayoutCoordinates r11, TextInputSession r12, boolean r13, OffsetMapping r14) {
        Companion.notifyFocusedRect$foundation_release(r8, r9, r10, r11, r12, r13, r14);
    }

    @JvmStatic
    public static final void onBlur$foundation_release(TextInputSession r1, EditProcessor r2, Function1<? super TextFieldValue, Unit> r3) {
        Companion.onBlur$foundation_release(r1, r2, r3);
    }

    @JvmStatic
    public static final void onEditCommand$foundation_release(List<? extends EditCommand> r1, EditProcessor r2, Function1<? super TextFieldValue, Unit> r3, TextInputSession r4) {
        Companion.onEditCommand$foundation_release(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final TextInputSession onFocus$foundation_release(TextInputService r7, TextFieldValue r8, EditProcessor r9, ImeOptions r10, Function1<? super TextFieldValue, Unit> r11, Function1<? super ImeAction, Unit> r12) {
        return Companion.onFocus$foundation_release(r7, r8, r9, r10, r11, r12);
    }

    @JvmStatic
    public static final TextInputSession restartInput$foundation_release(TextInputService r7, TextFieldValue r8, EditProcessor r9, ImeOptions r10, Function1<? super TextFieldValue, Unit> r11, Function1<? super ImeAction, Unit> r12) {
        return Companion.restartInput$foundation_release(r7, r8, r9, r10, r11, r12);
    }

    @JvmStatic
    /* JADX INFO: renamed from: setCursorOffset-ULxng0E$foundation_release, reason: not valid java name */
    public static final void m1454setCursorOffsetULxng0E$foundation_release(long r7, TextLayoutResultProxy r9, EditProcessor r10, OffsetMapping r11, Function1<? super TextFieldValue, Unit> r12) {
        Companion.m1460setCursorOffsetULxng0E$foundation_release(r7, r9, r10, r11, r12);
    }

    @JvmStatic
    public static final void updateTextLayoutResult$foundation_release(TextInputSession r1, TextFieldValue r2, OffsetMapping r3, TextLayoutResultProxy r4) {
        Companion.updateTextLayoutResult$foundation_release(r1, r2, r3, r4);
    }
}
