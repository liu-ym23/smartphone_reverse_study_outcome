package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000\u001a8\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f\u0018\u00010\fH\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002\u001a$\u0010\u001b\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u001dH\u0001\u001a\u001c\u0010\u001e\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0001¨\u0006\u001f"}, d2 = {"commitText", "", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "text", "", "newCursorPosition", "", "setComposingRegion", "start", "end", "setComposingText", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "deleteSurroundingText", "lengthBeforeCursor", "lengthAfterCursor", "deleteSurroundingTextInCodePoints", "finishComposingText", "setSelection", "isSurrogatePair", "", "high", "", "low", "imeReplace", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "", "imeDelete", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ImeEditCommand_androidKt {
    public static /* synthetic */ Unit a(int r0, int r1, TextFieldBuffer r2) {
        return setComposingRegion$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(int r0, int r1, TextFieldBuffer r2) {
        return deleteSurroundingTextInCodePoints$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ Unit c(TextFieldBuffer r0) {
        return finishComposingText$lambda$9(r0);
    }

    public static /* synthetic */ Unit d(String r0, int r1, TextFieldBuffer r2) {
        return commitText$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit e(int r0, int r1, TextFieldBuffer r2) {
        return deleteSurroundingText$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ Unit f(String r0, List r1, int r2, TextFieldBuffer r3) {
        return setComposingText$lambda$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit g(ImeEditCommandScope r0, int r1, int r2, TextFieldBuffer r3) {
        return setSelection$lambda$10(r0, r1, r2, r3);
    }

    public static final void finishComposingText(ImeEditCommandScope r1) {
        r1.edit(new g0());
    }

    private static final Unit finishComposingText$lambda$9(TextFieldBuffer r0) {
        r0.commitComposition$foundation_release();
        return Unit.INSTANCE;
    }

    private static final boolean isSurrogatePair(char r0, char r1) {
        if (Character.isHighSurrogate(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (Character.isLowSurrogate(r1) == false) goto L7;
        return true;
    }

    public static final void commitText(ImeEditCommandScope r1, final String r2, final int r3) {
        r1.edit(new e0(r2, r3));
    }

    private static final Unit commitText$lambda$0(String r4, int r5, TextFieldBuffer r6) {
        TextRange r0 = r6.m1525getCompositionMzsxiRA$foundation_release();
        if (r0 == null) goto L5;
        imeReplace(r6, TextRange.getStart-impl(r0.unbox-impl()), TextRange.getEnd-impl(r0.unbox-impl()), r4);
    L6:
        int r1 = TextRange.getStart-impl(r6.m1527getSelectiond9O1mEE());
        if (r5 <= 0) goto L9;
        int r2 = (r1 + r5) - 1;
    L10:
        r6.m1529setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(r2, 0, r6.getLength())));
        return Unit.INSTANCE;
    L9:
        r2 = (r1 + r5) - r4.length();
        goto L10
    L5:
        imeReplace(r6, TextRange.getStart-impl(r6.m1527getSelectiond9O1mEE()), TextRange.getEnd-impl(r6.m1527getSelectiond9O1mEE()), r4);
        goto L6
    }

    public static final void deleteSurroundingText(ImeEditCommandScope r1, final int r2, final int r3) {
        r1.edit(new h0(r2, r3));
    }

    private static final Unit deleteSurroundingText$lambda$6(int r5, int r6, TextFieldBuffer r7) {
        if (r5 < 0) goto L6;
        if (r6 < 0) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + r5 + " and " + r6 + " respectively.");
    L9:
        int r2 = TextRange.getEnd-impl(r7.m1527getSelectiond9O1mEE());
        int r3 = r2 + r6;
        if (((r6 ^ r3) & (r2 ^ r3)) >= 0) goto L12;
        r3 = r7.getLength();
    L12:
        imeDelete(r7, TextRange.getEnd-impl(r7.m1527getSelectiond9O1mEE()), Math.min(r3, r7.getLength()));
        int r8 = TextRange.getStart-impl(r7.m1527getSelectiond9O1mEE());
        int r4 = r8 - r5;
        if (((r5 ^ r8) & (r8 ^ r4)) >= 0) goto L15;
        r4 = 0;
    L15:
        imeDelete(r7, Math.max(0, r4), TextRange.getStart-impl(r7.m1527getSelectiond9O1mEE()));
        return Unit.INSTANCE;
    L6:
        r1 = false;
        goto L7
    }

    public static final void deleteSurroundingTextInCodePoints(ImeEditCommandScope r1, final int r2, final int r3) {
        r1.edit(new b0(r2, r3));
    }

    private static final Unit deleteSurroundingTextInCodePoints$lambda$8(int r8, int r9, TextFieldBuffer r10) {
        int r0 = 0;
        if (r8 < 0) goto L6;
        if (r9 < 0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + r8 + " and " + r9 + " respectively.");
    L9:
        int r3 = 0;
        int r4 = 0;
    L10:
        if (r3 >= r8) goto L18;
        r4 = r4 + 1;
        if (TextRange.getStart-impl(r10.m1527getSelectiond9O1mEE()) <= r4) goto L17;
        if (isSurrogatePair(r10.asCharSequence().charAt((TextRange.getStart-impl(r10.m1527getSelectiond9O1mEE()) - r4) - 1), r10.asCharSequence().charAt(TextRange.getStart-impl(r10.m1527getSelectiond9O1mEE()) - r4)) == false) goto L16;
        r4 = r4 + 1;
    L16:
        r3 = r3 + 1;
        goto L10
    L17:
        r4 = TextRange.getStart-impl(r10.m1527getSelectiond9O1mEE());
    L18:
        int r11 = 0;
    L19:
        if (r0 >= r9) goto L27;
        r11 = r11 + 1;
        if ((TextRange.getEnd-impl(r10.m1527getSelectiond9O1mEE()) + r11) >= r10.getLength()) goto L26;
        if (isSurrogatePair(r10.asCharSequence().charAt((TextRange.getEnd-impl(r10.m1527getSelectiond9O1mEE()) + r11) - 1), r10.asCharSequence().charAt(TextRange.getEnd-impl(r10.m1527getSelectiond9O1mEE()) + r11)) == false) goto L25;
        r11 = r11 + 1;
    L25:
        r0 = r0 + 1;
        goto L19
    L26:
        r11 = r10.getLength() - TextRange.getEnd-impl(r10.m1527getSelectiond9O1mEE());
    L27:
        imeDelete(r10, TextRange.getEnd-impl(r10.m1527getSelectiond9O1mEE()), TextRange.getEnd-impl(r10.m1527getSelectiond9O1mEE()) + r11);
        imeDelete(r10, TextRange.getStart-impl(r10.m1527getSelectiond9O1mEE()) - r4, TextRange.getStart-impl(r10.m1527getSelectiond9O1mEE()));
        return Unit.INSTANCE;
    L6:
        r2 = false;
        goto L7
    }

    public static final void imeDelete(TextFieldBuffer r7, int r8, int r9) {
        TextRange r0 = r7.m1525getCompositionMzsxiRA$foundation_release();
        int r1 = Math.min(r8, r9);
        int r10 = Math.max(r8, r9);
        TextFieldBufferKt.delete(r7, r1, r10);
        if (r0 == null) goto L9;
        r0.unbox-impl();
        long r11 = TextFieldBufferKt.m1533adjustTextRangevJH6DeI(r0.unbox-impl(), r1, r10, 0);
        if (TextRange.getCollapsed-impl(r11) == false) goto L7;
        r7.commitComposition$foundation_release();
        return;
    L7:
        TextFieldBuffer.setComposition$foundation_release$default(r7, TextRange.getMin-impl(r11), TextRange.getMax-impl(r11), null, 4, null);
        return;
    }

    public static final void setComposingRegion(ImeEditCommandScope r1, final int r2, final int r3) {
        r1.edit(new d0(r2, r3));
    }

    private static final Unit setComposingRegion$lambda$1(int r8, int r9, TextFieldBuffer r10) {
        if (r10.hasComposition$foundation_release() == false) goto L5;
        r10.commitComposition$foundation_release();
    L5:
        int r4 = RangesKt.coerceIn(r8, 0, r10.getLength());
        int r11 = RangesKt.coerceIn(r9, 0, r10.getLength());
        if (r4 == r11) goto L11;
        if (r4 >= r11) goto L9;
        TextFieldBuffer.setComposition$foundation_release$default(r10, r4, r11, null, 4, null);
        goto L11
    L9:
        TextFieldBuffer.setComposition$foundation_release$default(r10, r11, r4, null, 4, null);
    L11:
        return Unit.INSTANCE;
    }

    public static final void setSelection(final ImeEditCommandScope r1, final int r2, final int r3) {
        r1.edit(new c0(r1, r2, r3));
    }

    public static final void imeReplace(TextFieldBuffer r6, int r7, int r8, CharSequence r9) {
        int r0 = Math.min(r7, r8);
        int r10 = Math.max(r7, r8);
        int r11 = 0;
        int r1 = r0;
    L3:
        if (r1 >= r10) goto L9;
        if (r11 >= r9.length()) goto L9;
        if (r9.charAt(r11) != r6.asCharSequence().charAt(r1)) goto L9;
        r11 = r11 + 1;
        r1 = r1 + 1;
    L9:
        int r2 = r9.length();
    L10:
        if (r10 <= r1) goto L15;
        if (r2 <= r11) goto L15;
        if (r9.charAt(r2 - 1) != r6.asCharSequence().charAt(r10 - 1)) goto L15;
        r2 = r2 - 1;
        r10 = r10 - 1;
    L15:
        if (r1 != r10) goto L19;
        if (r11 != r2) goto L19;
        r6.commitComposition$foundation_release();
        r6.clearHighlight$foundation_release();
    L20:
        r6.m1529setSelection5zctL8(TextRangeKt.TextRange(r0 + r9.length()));
        return;
    L19:
        r6.replace(r1, r10, r9.subSequence(r11, r2));
        goto L20
    }

    public static final void setComposingText(ImeEditCommandScope r1, final String r2, final int r3, final List<AnnotatedString.Range<AnnotatedString.Annotation>> r4) {
        r1.edit(new f0(r2, r4, r3));
    }

    private static final Unit setComposingText$lambda$2(String r6, List r7, int r8, TextFieldBuffer r9) {
        TextRange r0 = r9.m1525getCompositionMzsxiRA$foundation_release();
        if (r0 == null) goto L10;
        imeReplace(r9, TextRange.getStart-impl(r0.unbox-impl()), TextRange.getEnd-impl(r0.unbox-impl()), r6);
        if (r6.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L16;
        r9.setComposition$foundation_release(TextRange.getStart-impl(r0.unbox-impl()), TextRange.getStart-impl(r0.unbox-impl()) + r6.length(), r7);
    L16:
        int r10 = TextRange.getStart-impl(r9.m1527getSelectiond9O1mEE());
        if (r8 <= 0) goto L19;
        int r11 = (r10 + r8) - 1;
    L20:
        r9.m1529setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(r11, 0, r9.getLength())));
        return Unit.INSTANCE;
    L19:
        r11 = (r10 + r8) - r6.length();
        goto L20
    L7:
        r3 = false;
        goto L8
    L10:
        int r1 = TextRange.getStart-impl(r9.m1527getSelectiond9O1mEE());
        imeReplace(r9, r1, TextRange.getEnd-impl(r9.m1527getSelectiond9O1mEE()), r6);
        if (r6.length() <= 0) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L16;
        r9.setComposition$foundation_release(r1, r6.length() + r1, r7);
        goto L16
    L13:
        r4 = false;
        goto L14
    }

    private static final Unit setSelection$lambda$10(ImeEditCommandScope r4, int r5, int r6, TextFieldBuffer r7) {
        long r0 = r4.mo1567mapToTransformedGEjPoXI(TextRangeKt.TextRange(0, r7.getLength()));
        int r2 = TextRange.getMin-impl(r0);
        int r3 = TextRange.getMax-impl(r0);
        if (r5 >= r2) goto L5;
        r5 = r2;
    L5:
        if (r5 > r3) goto L8;
        r3 = r5;
    L8:
        int r8 = TextRange.getMin-impl(r0);
        int r1 = TextRange.getMax-impl(r0);
        if (r6 >= r8) goto L11;
        r6 = r8;
    L11:
        if (r6 > r1) goto L14;
        r1 = r6;
    L14:
        r7.m1529setSelection5zctL8(r4.mo1566mapFromTransformedGEjPoXI(TextRangeKt.TextRange(r3, r1)));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void setComposingText$default(ImeEditCommandScope r0, String r1, int r2, List r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        setComposingText(r0, r1, r2, r3);
    }
}
