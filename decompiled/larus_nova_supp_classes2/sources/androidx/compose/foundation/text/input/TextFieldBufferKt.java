package androidx.compose.foundation.text.input;

import androidx.autofill.HintConstants;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001a\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e\u001a\u001a\u0010\u000f\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004\u001a\n\u0010\u0012\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\u0013\u001a\u00020\n*\u00020\u000b\u001aE\u0010\u0014\u001a\u00020\n*\u00020\u001526\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\n0\u0017H\u0087\b\u001aE\u0010\u001b\u001a\u00020\n*\u00020\u001526\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\n0\u0017H\u0087\b\u001a{\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2`\u0010 \u001a\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\n0!H\u0080\b\u001a\u001e\u0010&\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0000¨\u0006'"}, d2 = {"adjustTextRange", "Landroidx/compose/ui/text/TextRange;", "originalRange", "replaceStart", "", "replaceEnd", "insertedTextLength", "adjustTextRange-vJH6DeI", "(JIII)J", "insert", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "index", "text", "", "delete", "start", "end", "placeCursorAtEnd", "selectAll", "forEachChange", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "range", "forEachChangeReversed", "findCommonPrefixAndSuffix", "a", "", "b", "onFound", "Lkotlin/Function4;", "aPrefixStart", "aSuffixStart", "bPrefixStart", "bSuffixStart", "setSelectionCoerced", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldBufferKt {
    public static final void placeCursorAtEnd(TextFieldBuffer r1) {
        r1.placeCursorBeforeCharAt(r1.getLength());
    }

    public static final void selectAll(TextFieldBuffer r2) {
        r2.m1529setSelection5zctL8(TextRangeKt.TextRange(0, r2.getLength()));
    }

    public static final void forEachChange(TextFieldBuffer.ChangeList r4, Function2<? super TextRange, ? super TextRange, Unit> r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.getChangeCount()) goto L6;
        r5.invoke(TextRange.box-impl(r4.mo1532getRangejx7JFs(r0)), TextRange.box-impl(r4.mo1531getOriginalRangejx7JFs(r0)));
        r0 = r0 + 1;
        goto L4
    }

    public static final void forEachChangeReversed(TextFieldBuffer.ChangeList r4, Function2<? super TextRange, ? super TextRange, Unit> r5) {
        int r0 = r4.getChangeCount() - 1;
    L3:
        if (r0 < 0) goto L5;
        r5.invoke(TextRange.box-impl(r4.mo1532getRangejx7JFs(r0)), TextRange.box-impl(r4.mo1531getOriginalRangejx7JFs(r0)));
        r0 = r0 - 1;
        goto L3
    }

    public static final void delete(TextFieldBuffer r1, int r2, int r3) {
        r1.replace(r2, r3, "");
    }

    public static final void findCommonPrefixAndSuffix(CharSequence r9, CharSequence r10, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r11) {
        int r0 = r9.length();
        int r1 = r10.length();
        int r4 = 0;
        if (r9.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
    L28:
        int r5 = 0;
    L29:
        if (r4 < r0) goto L32;
        if (r5 < r1) goto L32;
        return;
    L32:
        r11.invoke(Integer.valueOf(r4), Integer.valueOf(r0), Integer.valueOf(r5), Integer.valueOf(r1));
        return;
    L8:
        if (r10.length() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L28;
        int r6 = 0;
        r5 = 0;
        boolean r7 = false;
    L13:
        if (r4 == 0) goto L15;
    L18:
        if (r7 == false) goto L20;
    L23:
        if (r6 >= r0) goto L27;
        if (r5 >= r1) goto L27;
        if (r4 == 0) goto L13;
        if (r7 == false) goto L13;
    L27:
        r4 = r6;
        goto L29
    L20:
        if (r9.charAt(r0 - 1) != r10.charAt(r1 - 1)) goto L22;
        r0 = r0 - 1;
        r1 = r1 - 1;
        goto L23
    L22:
        r7 = true;
        goto L23
    L15:
        if (r9.charAt(r6) != r10.charAt(r5)) goto L17;
        r6 = r6 + 1;
        r5 = r5 + 1;
        goto L18
    L17:
        r4 = 1;
        goto L18
    L10:
        r3 = false;
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    public static final void insert(TextFieldBuffer r0, int r1, String r2) {
        r0.replace(r1, r1, r2);
    }

    public static final void setSelectionCoerced(TextFieldBuffer r2, int r3, int r4) {
        r2.m1529setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(r3, 0, r2.getLength()), RangesKt.coerceIn(r4, 0, r2.getLength())));
    }

    /* JADX INFO: renamed from: adjustTextRange-vJH6DeI, reason: not valid java name */
    public static final long m1533adjustTextRangevJH6DeI(long r2, int r4, int r5, int r6) {
        int r0 = TextRange.getMin-impl(r2);
        int r1 = TextRange.getMax-impl(r2);
        if (r1 >= r4) goto L5;
        return r2;
    L5:
        if (r0 > r4) goto L10;
        if (r5 > r1) goto L10;
        int r7 = r6 - (r5 - r4);
        if (r0 == r1) goto L15;
    L16:
        r4 = r1 + r7;
    L20:
        return TextRangeKt.TextRange(r0, r4);
    L15:
        r0 = r0 + r7;
    L10:
        if (r0 <= r4) goto L13;
        if (r1 >= r5) goto L13;
        r4 = r4 + r6;
        r0 = r4;
    L13:
        if (r0 < r5) goto L17;
        r7 = r6 - (r5 - r4);
        goto L15
    L17:
        if (r4 >= r0) goto L20;
        r0 = r4 + r6;
        r7 = r6 - (r5 - r4);
        goto L16
    }

    public static /* synthetic */ void setSelectionCoerced$default(TextFieldBuffer r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = r1;
    L5:
        setSelectionCoerced(r0, r1, r2);
    }
}
