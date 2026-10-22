package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.ToCharArray_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r\u0018\u00010\n\u0012\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015H\u0096\u0002J\u0018\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0001J&\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u0015J\u0006\u00103\u001a\u00020*J\u0013\u00104\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u000105H\u0096\u0002J\b\u00106\u001a\u00020\u0015H\u0016R#\u0010\t\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u000e\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0003\u001a\u00020\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00067"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "", "text", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "composingAnnotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "outputAnnotations", "<init>", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Lkotlin/Pair;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getComposingAnnotations", "()Ljava/util/List;", "getOutputAnnotations", "length", "", "getLength", "()I", "getText", "()Ljava/lang/CharSequence;", "getSelection-d9O1mEE", "()J", "J", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "getHighlight", "()Lkotlin/Pair;", "get", "", "index", "subSequence", "startIndex", "endIndex", "toString", "", "contentEquals", "", "other", "toCharArray", "", "destination", "", "destinationOffset", "sourceStartIndex", "sourceEndIndex", "shouldShowSelection", "equals", "", "hashCode", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldCharSequence implements CharSequence {
    public static final int $stable = 8;
    private final List<AnnotatedString.Range<AnnotatedString.Annotation>> composingAnnotations;
    private final TextRange composition;
    private final Pair<TextHighlightType, TextRange> highlight;
    private final List<AnnotatedString.Range<AnnotatedString.Annotation>> outputAnnotations;
    private final long selection;
    private final CharSequence text;

    public /* synthetic */ TextFieldCharSequence(CharSequence r1, long r2, TextRange r4, Pair r5, List r6, List r7, DefaultConstructorMarker r8) {
        this(r1, r2, r4, r5, r6, r7);
    }

    public int getLength() {
        return this.text.length();
    }

    public int hashCode() {
        int r0 = ((this.text.hashCode() * 31) + TextRange.hashCode-impl(this.selection)) * 31;
        TextRange r1 = this.composition;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = TextRange.hashCode-impl(r1.unbox-impl());
    L6:
        int r4 = (r0 + r3) * 31;
        Pair<TextHighlightType, TextRange> r5 = this.highlight;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        List<AnnotatedString.Range<AnnotatedString.Annotation>> r8 = this.composingAnnotations;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final boolean shouldShowSelection() {
        if (this.highlight != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.text.toString();
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public final List<AnnotatedString.Range<AnnotatedString.Annotation>> getComposingAnnotations() {
        return this.composingAnnotations;
    }

    /* JADX INFO: renamed from: getComposition-MzsxiRA, reason: not valid java name */
    public final TextRange m1534getCompositionMzsxiRA() {
        return this.composition;
    }

    public final Pair<TextHighlightType, TextRange> getHighlight() {
        return this.highlight;
    }

    public final List<AnnotatedString.Range<AnnotatedString.Annotation>> getOutputAnnotations() {
        return this.outputAnnotations;
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m1535getSelectiond9O1mEE() {
        return this.selection;
    }

    public final CharSequence getText() {
        return this.text;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int r1) {
        return get(r1);
    }

    public final boolean contentEquals(CharSequence r2) {
        return StringsKt.contentEquals(this.text, r2);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L9;
        return false;
    L9:
        if (TextFieldCharSequence.class == r7.getClass()) goto L11;
        return false;
    L11:
        TextFieldCharSequence r8 = (TextFieldCharSequence) r7;
        if (TextRange.equals-impl0(this.selection, r8.selection) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.composition, r8.composition) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.highlight, r8.highlight) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.composingAnnotations, r8.composingAnnotations) == true) goto L24;
        return false;
    L24:
        if (contentEquals(r8.text) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public char get(int r2) {
        return this.text.charAt(r2);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r2, int r3) {
        return this.text.subSequence(r2, r3);
    }

    public final void toCharArray(char[] r2, int r3, int r4, int r5) {
        ToCharArray_androidKt.toCharArray(this.text, r2, r3, r4, r5);
    }

    private TextFieldCharSequence(CharSequence r1, long r2, TextRange r4, Pair<TextHighlightType, TextRange> r5, List<AnnotatedString.Range<AnnotatedString.Annotation>> r6, List<AnnotatedString.Range<AnnotatedString.Annotation>> r7) {
        this.composingAnnotations = r6;
        this.outputAnnotations = r7;
        if ((r1 instanceof TextFieldCharSequence) == false) goto L5;
        CharSequence r8 = ((TextFieldCharSequence) r1).text;
    L6:
        this.text = r8;
        this.selection = TextRangeKt.coerceIn-8ffj60Q(r2, 0, r1.length());
        Pair<TextHighlightType, TextRange> r3 = null;
        if (r4 == null) goto L9;
        TextRange r9 = TextRange.box-impl(TextRangeKt.coerceIn-8ffj60Q(r4.unbox-impl(), 0, r1.length()));
    L10:
        this.composition = r9;
        if (r5 == null) goto L13;
        r3 = Pair.copy$default(r5, null, TextRange.box-impl(TextRangeKt.coerceIn-8ffj60Q(((TextRange) r5.getSecond()).unbox-impl(), 0, r1.length())), 1, null);
    L13:
        this.highlight = r3;
        return;
    L9:
        r9 = null;
        goto L10
    L5:
        r8 = r1;
        goto L6
    }

    public /* synthetic */ TextFieldCharSequence(CharSequence r9, long r10, TextRange r12, Pair r13, List r14, List r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 1) == 0) goto L5;
        CharSequence r0 = "";
    L7:
        if ((r16 & 2) == 0) goto L9;
        long r1 = TextRange.Companion.getZero-d9O1mEE();
    L10:
        List r4 = null;
        if ((r16 & 4) == 0) goto L13;
        TextRange r3 = null;
    L15:
        if ((r16 & 8) == 0) goto L17;
        Pair r5 = null;
    L19:
        if ((r16 & 16) == 0) goto L21;
        List r6 = null;
    L23:
        if ((r16 & 32) != 0) goto L26;
        r4 = r15;
    L26:
        this(r0, r1, r3, r5, r6, r4, null);
        return;
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r1 = r10;
        goto L10
    L5:
        r0 = r9;
        goto L7
    }
}
