package androidx.compose.foundation.text.input;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.internal.ChangeTracker;
import androidx.compose.foundation.text.input.internal.OffsetMappingCalculator;
import androidx.compose.foundation.text.input.internal.PartialGapBuffer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0086\u0001B3\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010;\u001a\u00020'H\u0000¢\u0006\u0002\b<J\r\u0010=\u001a\u00020>H\u0000¢\u0006\u0002\b?J9\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u00152\u001a\b\u0002\u0010C\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020706j\u0002`E\u0018\u00010DH\u0000¢\u0006\u0002\bFJ'\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020H2\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0015H\u0000¢\u0006\u0004\bN\u0010OJ\r\u0010P\u001a\u00020>H\u0000¢\u0006\u0002\bQJ\u001e\u0010R\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\u0019J9\u0010R\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\u00192\b\b\u0002\u0010T\u001a\u00020\u00152\b\b\u0002\u0010U\u001a\u00020\u0015H\u0000¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020>2\u0006\u0010X\u001a\u00020\u0019H\u0000¢\u0006\u0002\bYJ\u0016\u0010Z\u001a\u00060\u0001j\u0002`\u00022\b\u0010S\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010Z\u001a\u00060\u0001j\u0002`\u00022\b\u0010S\u001a\u0004\u0018\u00010\u00192\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0015H\u0016J\u0014\u0010Z\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010[\u001a\u00020\\H\u0016J \u0010]\u001a\u00020>2\u0006\u0010^\u001a\u00020\u00152\u0006\u0010_\u001a\u00020\u00152\u0006\u0010`\u001a\u00020\u0015H\u0002J\u000e\u0010a\u001a\u00020\\2\u0006\u0010b\u001a\u00020\u0015J\b\u0010c\u001a\u00020dH\u0016J\u0006\u0010e\u001a\u00020\u0019J\b\u0010f\u001a\u00020>H\u0002J\u0006\u0010g\u001a\u00020>J\u000e\u0010h\u001a\u00020>2\u0006\u0010b\u001a\u00020\u0015J\u000e\u0010i\u001a\u00020>2\u0006\u0010b\u001a\u00020\u0015J]\u0010j\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u001d2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001d2\u001a\b\u0002\u00108\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020706j\u0002`E\u0018\u00010D2\u001a\b\u0002\u0010k\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020706j\u0002`E\u0018\u00010DH\u0000¢\u0006\u0004\bl\u0010mJ \u0010n\u001a\u00020>2\u0006\u0010b\u001a\u00020\u00152\u0006\u0010o\u001a\u00020'2\u0006\u0010p\u001a\u00020'H\u0002J\u0017\u0010q\u001a\u00020>2\u0006\u0010r\u001a\u00020\u001dH\u0002¢\u0006\u0004\bs\u0010/J&\u0010~\u001a\u00020>2\u0006\u0010\u007f\u001a\u0002072\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0015H\u0000¢\u0006\u0003\b\u0080\u0001J!\u0010\u0081\u0001\u001a\u00020>2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0015J!\u0010\u0081\u0001\u001a\u00020>2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0015R\u0014\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020'8G¢\u0006\u0006\u001a\u0004\b&\u0010(R\u0010\u0010)\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R$\u0010,\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010/R(\u00100\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010\u001d@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R:\u00108\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020706\u0018\u0001052\u0014\u0010+\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020706\u0018\u000105@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R:\u0010I\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u001d\u0018\u00010G2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u001d\u0018\u00010G@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u001a\u0010t\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010(\"\u0004\bv\u0010wR,\u0010x\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020706j\u0002`E\u0018\u00010yX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}¨\u0006\u0087\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "initialChanges", "Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "originalValue", "offsetMappingCalculator", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/ChangeTracker;Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "getOriginalValue$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "buffer", "Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "backingChangeTracker", "changeTracker", "getChangeTracker$foundation_release", "()Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "length", "", "getLength", "()I", "originalText", "", "getOriginalText", "()Ljava/lang/CharSequence;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "getOriginalSelection-d9O1mEE", "()J", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "getChanges$annotations", "()V", "getChanges", "()Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "hasSelection", "", "()Z", "selectionInChars", "J", "value", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "composition", "getComposition-MzsxiRA$foundation_release", "()Landroidx/compose/ui/text/TextRange;", "setComposition-OEnZFl4", "(Landroidx/compose/ui/text/TextRange;)V", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "composingAnnotations", "getComposingAnnotations$foundation_release", "()Landroidx/compose/runtime/collection/MutableVector;", "hasComposition", "hasComposition$foundation_release", "commitComposition", "", "commitComposition$foundation_release", "setComposition", "start", "end", "annotations", "", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "setComposition$foundation_release", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlight", "getHighlight$foundation_release", "()Lkotlin/Pair;", "setHighlight", "type", "setHighlight-K7f2yys$foundation_release", "(III)V", "clearHighlight", "clearHighlight$foundation_release", "replace", "text", "textStart", "textEnd", "replace$foundation_release", "setTextIfChanged", "newText", "setTextIfChanged$foundation_release", "append", "char", "", "onTextWillChange", "replaceStart", "replaceEnd", "newLength", "charAt", "index", "toString", "", "asCharSequence", "clearChangeList", "revertAllChanges", "placeCursorBeforeCharAt", "placeCursorAfterCharAt", "toTextFieldCharSequence", "outputAnnotations", "toTextFieldCharSequence-wFTz33Y$foundation_release", "(JLandroidx/compose/ui/text/TextRange;Ljava/util/List;Ljava/util/List;)Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "requireValidIndex", "startExclusive", "endExclusive", "requireValidRange", "range", "requireValidRange-5zc-tL8", "canCallAddStyle", "getCanCallAddStyle$foundation_release", "setCanCallAddStyle$foundation_release", "(Z)V", "outputTransformationAnnotations", "", "getOutputTransformationAnnotations$foundation_release", "()Ljava/util/List;", "setOutputTransformationAnnotations$foundation_release", "(Ljava/util/List;)V", "addAnnotation", "annotation", "addAnnotation$foundation_release", "addStyle", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "ChangeList", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldBuffer implements Appendable {
    public static final int $stable = 8;
    private ChangeTracker backingChangeTracker;
    private final PartialGapBuffer buffer;
    private boolean canCallAddStyle;
    private MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> composingAnnotations;
    private TextRange composition;
    private Pair<TextHighlightType, TextRange> highlight;
    private final OffsetMappingCalculator offsetMappingCalculator;
    private final TextFieldCharSequence originalValue;
    private List<AnnotatedString.Range<AnnotatedString.Annotation>> outputTransformationAnnotations;
    private long selectionInChars;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\f\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "", "changeCount", "", "getChangeCount", "()I", "getRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getRange--jx7JFs", "(I)J", "getOriginalRange", "getOriginalRange--jx7JFs", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ChangeList {
        int getChangeCount();

        /* JADX INFO: renamed from: getOriginalRange--jx7JFs, reason: not valid java name */
        long mo1531getOriginalRangejx7JFs(int r1);

        /* JADX INFO: renamed from: getRange--jx7JFs, reason: not valid java name */
        long mo1532getRangejx7JFs(int r1);
    }

    public static /* synthetic */ AnnotatedString.Range a(TextFieldCharSequence r0, int r1) {
        return composingAnnotations$lambda$2(r0, r1);
    }

    public static /* synthetic */ void getChanges$annotations() {
    }

    public final void clearHighlight$foundation_release() {
        this.highlight = null;
    }

    public final void commitComposition$foundation_release() {
        m1523setCompositionOEnZFl4(null);
    }

    public final ChangeTracker getChangeTracker$foundation_release() {
        ChangeTracker r0 = this.backingChangeTracker;
        if (r0 != null) goto L6;
        ChangeTracker r1 = new ChangeTracker(null, 1, null);
        this.backingChangeTracker = r1;
        return r1;
    L6:
        return r0;
    }

    public final int getLength() {
        return this.buffer.length();
    }

    /* JADX INFO: renamed from: getOriginalSelection-d9O1mEE, reason: not valid java name */
    public final long m1526getOriginalSelectiond9O1mEE() {
        return this.originalValue.m1535getSelectiond9O1mEE();
    }

    public final CharSequence getOriginalText() {
        return this.originalValue.getText();
    }

    public final boolean hasComposition$foundation_release() {
        if (this.composition == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return this.buffer.toString();
    }

    private final void clearChangeList() {
        getChangeTracker$foundation_release().clearChanges();
    }

    public final ChangeList getChanges() {
        return getChangeTracker$foundation_release();
    }

    public final boolean hasSelection() {
        return !TextRange.getCollapsed-impl(m1527getSelectiond9O1mEE());
    }

    public final void revertAllChanges() {
        replace(0, getLength(), this.originalValue.toString());
        m1529setSelection5zctL8(this.originalValue.m1535getSelectiond9O1mEE());
        clearChangeList();
    }

    public final CharSequence asCharSequence() {
        return this.buffer;
    }

    public final boolean getCanCallAddStyle$foundation_release() {
        return this.canCallAddStyle;
    }

    public final MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> getComposingAnnotations$foundation_release() {
        return this.composingAnnotations;
    }

    /* JADX INFO: renamed from: getComposition-MzsxiRA$foundation_release, reason: not valid java name */
    public final TextRange m1525getCompositionMzsxiRA$foundation_release() {
        return this.composition;
    }

    public final Pair<TextHighlightType, TextRange> getHighlight$foundation_release() {
        return this.highlight;
    }

    public final TextFieldCharSequence getOriginalValue$foundation_release() {
        return this.originalValue;
    }

    public final List<AnnotatedString.Range<AnnotatedString.Annotation>> getOutputTransformationAnnotations$foundation_release() {
        return this.outputTransformationAnnotations;
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m1527getSelectiond9O1mEE() {
        return this.selectionInChars;
    }

    /* JADX INFO: renamed from: requireValidRange-5zc-tL8, reason: not valid java name */
    private final void m1522requireValidRange5zctL8(long r5) {
        long r0 = TextRangeKt.TextRange(0, getLength());
        if (TextRange.contains-5zc-tL8(r0, r5) == true) goto L6;
        InlineClassHelperKt.throwIllegalArgumentException("Expected " + TextRange.toString-impl(r5) + " to be in " + TextRange.toString-impl(r0));
        return;
    }

    /* JADX INFO: renamed from: setComposition-OEnZFl4, reason: not valid java name */
    private final void m1523setCompositionOEnZFl4(TextRange r3) {
        if (r3 != null) goto L4;
    L7:
        this.composition = null;
        MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> r4 = this.composingAnnotations;
        if (r4 == null) goto L12;
        r4.clear();
        return;
    L12:
        return;
    L4:
        if (TextRange.getCollapsed-impl(r3.unbox-impl()) == true) goto L7;
        this.composition = r3;
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence r12) {
        if (r12 == null) goto L4;
        onTextWillChange(getLength(), getLength(), r12.length());
        PartialGapBuffer r3 = this.buffer;
        PartialGapBuffer.replace$default(r3, r3.length(), this.buffer.length(), r12, 0, 0, 24, null);
    L4:
        return this;
    }

    public final char charAt(int r2) {
        return this.buffer.charAt(r2);
    }

    public final void placeCursorAfterCharAt(int r3) {
        requireValidIndex(r3, false, true);
        this.selectionInChars = TextRangeKt.TextRange(RangesKt.coerceAtMost(r3 + 1, getLength()));
    }

    public final void placeCursorBeforeCharAt(int r3) {
        requireValidIndex(r3, true, false);
        this.selectionInChars = TextRangeKt.TextRange(r3);
    }

    public final void setCanCallAddStyle$foundation_release(boolean r1) {
        this.canCallAddStyle = r1;
    }

    public final void setOutputTransformationAnnotations$foundation_release(List<AnnotatedString.Range<AnnotatedString.Annotation>> r1) {
        this.outputTransformationAnnotations = r1;
    }

    /* JADX INFO: renamed from: setSelection-5zc-tL8, reason: not valid java name */
    public final void m1529setSelection5zctL8(long r1) {
        m1522requireValidRange5zctL8(r1);
        this.selectionInChars = r1;
        this.highlight = null;
    }

    public final void setTextIfChanged$foundation_release(CharSequence r15) {
        PartialGapBuffer r0 = this.buffer;
        int r1 = r0.length();
        int r2 = r15.length();
        boolean r5 = false;
        if (r0.length() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L8;
    L28:
        int r10 = r1;
        int r13 = r2;
        int r9 = 0;
        int r12 = 0;
    L29:
        if (r9 < r10) goto L32;
        if (r12 < r13) goto L32;
        return;
    L32:
        replace$foundation_release(r9, r10, r15, r12, r13);
        return;
    L8:
        if (r15.length() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L28;
        int r6 = 0;
        int r7 = 0;
        boolean r8 = false;
    L13:
        if (r5 == false) goto L15;
    L18:
        if (r8 == false) goto L20;
    L23:
        if (r6 >= r1) goto L27;
        if (r7 >= r2) goto L27;
        if (r5 == false) goto L13;
        if (r8 == false) goto L13;
    L27:
        r10 = r1;
        r13 = r2;
        r9 = r6;
        r12 = r7;
        goto L29
    L20:
        if (r0.charAt(r1 - 1) != r15.charAt(r2 - 1)) goto L22;
        r1 = r1 - 1;
        r2 = r2 - 1;
        goto L23
    L22:
        r8 = true;
        goto L23
    L15:
        if (r0.charAt(r6) != r15.charAt(r7)) goto L17;
        r6 = r6 + 1;
        r7 = r7 + 1;
        goto L18
    L17:
        r5 = true;
        goto L18
    L10:
        r4 = false;
        goto L11
    L5:
        r3 = false;
        goto L6
    }

    @Override // java.lang.Appendable
    public Appendable append(char r12) {
        onTextWillChange(getLength(), getLength(), 1);
        PartialGapBuffer r3 = this.buffer;
        PartialGapBuffer.replace$default(r3, r3.length(), this.buffer.length(), String.valueOf(r12), 0, 0, 24, null);
        return this;
    }

    private static final AnnotatedString.Range composingAnnotations$lambda$2(TextFieldCharSequence r0, int r1) {
        return (AnnotatedString.Range) ListProtector.get(r0.getComposingAnnotations(), r1);
    }

    private final void onTextWillChange(int r3, int r4, int r5) {
        getChangeTracker$foundation_release().trackChange(r3, r4, r5);
        OffsetMappingCalculator r0 = this.offsetMappingCalculator;
        if (r0 == null) goto L5;
        r0.recordEditOperation(r3, r4, r5);
    L5:
        this.selectionInChars = TextFieldBufferKt.m1533adjustTextRangevJH6DeI(m1527getSelectiond9O1mEE(), r3, r4, r5);
    }

    private final void requireValidIndex(int r3, boolean r4, boolean r5) {
        boolean r0 = false;
        if (r4 == false) goto L5;
        int r6 = 0;
    L7:
        if (r5 == false) goto L9;
        int r7 = getLength();
    L10:
        if (r6 > r3) goto L13;
        if (r3 >= r7) goto L13;
        r0 = true;
    L13:
        if (r0 == true) goto L16;
        InlineClassHelperKt.throwIllegalArgumentException("Expected " + r3 + " to be in [" + r6 + ", " + r7 + ')');
        return;
    L16:
        return;
    L9:
        r7 = getLength() + 1;
        goto L10
    L5:
        r6 = -1;
        goto L7
    }

    public final void addAnnotation$foundation_release(AnnotatedString.Annotation r3, int r4, int r5) {
        if (this.canCallAddStyle == true) goto L6;
        InlineClassHelperKt.throwIllegalStateException("You can add styling to a [TextFieldBuffer] only from an [OutputTransformation].");
    L6:
        if (this.outputTransformationAnnotations != null) goto L8;
        this.outputTransformationAnnotations = new ArrayList();
    L8:
        List<AnnotatedString.Range<AnnotatedString.Annotation>> r0 = this.outputTransformationAnnotations;
        if (r0 == null) goto L12;
        r0.add(new AnnotatedString.Range(r3, r4, r5));
        return;
    }

    public final void addStyle(ParagraphStyle r1, int r2, int r3) {
        addAnnotation$foundation_release(r1, r2, r3);
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence r12, int r13, int r14) {
        if (r12 == null) goto L4;
        onTextWillChange(getLength(), getLength(), r14 - r13);
        PartialGapBuffer r3 = this.buffer;
        PartialGapBuffer.replace$default(r3, r3.length(), this.buffer.length(), r12.subSequence(r13, r14), 0, 0, 24, null);
    L4:
        return this;
    }

    public final void replace(int r7, int r8, CharSequence r9) {
        replace$foundation_release(r7, r8, r9, 0, r9.length());
    }

    public final void setComposition$foundation_release(int r10, int r11, List<AnnotatedString.Range<AnnotatedString.Annotation>> r12) {
        if (r10 < 0) goto L36;
        if (r10 > this.buffer.length()) goto L36;
        if (r11 < 0) goto L34;
        if (r11 > this.buffer.length()) goto L34;
        if (r10 >= r11) goto L32;
        m1523setCompositionOEnZFl4(TextRange.box-impl(TextRangeKt.TextRange(r10, r11)));
        MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> r13 = this.composingAnnotations;
        if (r13 == null) goto L13;
        r13.clear();
    L13:
        List<AnnotatedString.Range<AnnotatedString.Annotation>> r14 = r12;
        int r0 = 0;
        if (r14 != null) goto L16;
    L19:
        boolean r1 = true;
    L20:
        if (r1 == false) goto L22;
        return;
    L22:
        if (this.composingAnnotations != null) goto L24;
        this.composingAnnotations = new MutableVector(new AnnotatedString.Range[16], 0);
    L24:
        int r15 = r14.size();
    L25:
        if (r0 >= r15) goto L40;
        AnnotatedString.Range r2 = (AnnotatedString.Range) ListProtector.get(r12, r0);
        MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> r3 = this.composingAnnotations;
        if (r3 == null) goto L29;
        r3.add(AnnotatedString.Range.copy$default(r2, null, r2.getStart() + r10, r2.getEnd() + r10, null, 9, null));
    L29:
        r0 = r0 + 1;
        goto L25
    L40:
        return;
    L16:
        if (r14.isEmpty() == true) goto L19;
        r1 = false;
        goto L20
    L32:
        throw new IllegalArgumentException("Do not set reversed or empty range: " + r10 + " > " + r11);
    L34:
        throw new IndexOutOfBoundsException("end (" + r11 + ") offset is outside of text region " + this.buffer.length());
    L36:
        throw new IndexOutOfBoundsException("start (" + r10 + ") offset is outside of text region " + this.buffer.length());
    }

    /* JADX INFO: renamed from: setHighlight-K7f2yys$foundation_release, reason: not valid java name */
    public final void m1528setHighlightK7f2yys$foundation_release(int r3, int r4, int r5) {
        if (r4 >= r5) goto L6;
        this.highlight = new Pair(TextHighlightType.m1542boximpl(r3), TextRange.box-impl(TextRangeKt.TextRange(RangesKt.coerceIn(r4, 0, getLength()), RangesKt.coerceIn(r5, 0, getLength()))));
        return;
    L6:
        throw new IllegalArgumentException("Do not set reversed or empty range: " + r4 + " > " + r5);
    }

    public final void addStyle(SpanStyle r1, int r2, int r3) {
        addAnnotation$foundation_release(r1, r2, r3);
    }

    public TextFieldBuffer(TextFieldCharSequence r4, ChangeTracker r5, TextFieldCharSequence r6, OffsetMappingCalculator r7) {
        this.originalValue = r6;
        this.offsetMappingCalculator = r7;
        this.buffer = new PartialGapBuffer(r4);
        MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> r8 = null;
        if (r5 == null) goto L5;
        ChangeTracker r9 = new ChangeTracker(r5);
    L6:
        this.backingChangeTracker = r9;
        this.selectionInChars = r4.m1535getSelectiond9O1mEE();
        this.composition = r4.m1534getCompositionMzsxiRA();
        List<AnnotatedString.Range<AnnotatedString.Annotation>> r10 = r4.getComposingAnnotations();
        boolean r11 = true;
        if (r10 != null) goto L9;
    L12:
        boolean r12 = true;
    L13:
        if (r12 == true) goto L18;
        int r13 = r4.getComposingAnnotations().size();
        AnnotatedString.Range[] r14 = new AnnotatedString.Range[r13];
        int r1 = 0;
    L15:
        if (r1 >= r13) goto L17;
        r14[r1] = a(r4, Integer.valueOf(r1).intValue());
        r1 = r1 + 1;
        goto L15
    L17:
        r8 = new MutableVector(r14, r13);
    L18:
        this.composingAnnotations = r8;
        if (this.offsetMappingCalculator != null) goto L22;
        r11 = false;
    L22:
        this.canCallAddStyle = r11;
        return;
    L9:
        if (r10.isEmpty() == true) goto L12;
        r12 = false;
        goto L13
    L5:
        r9 = null;
        goto L6
    }

    /* JADX INFO: renamed from: toTextFieldCharSequence-wFTz33Y$foundation_release, reason: not valid java name */
    public final TextFieldCharSequence m1530toTextFieldCharSequencewFTz33Y$foundation_release(long r13, TextRange r15, List<AnnotatedString.Range<AnnotatedString.Annotation>> r16, List<AnnotatedString.Range<AnnotatedString.Annotation>> r17) {
        return new TextFieldCharSequence(this.buffer.toString(), r13, r15, null, r16, r17, 8, null);
    }

    public final void replace$foundation_release(int r8, int r9, CharSequence r10, int r11, int r12) {
        boolean r0 = true;
        if (r8 > r9) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("Expected start=" + r8 + " <= end=" + r9);
    L8:
        if (r11 <= r12) goto L11;
        r0 = false;
    L11:
        if (r0 == true) goto L13;
        InlineClassHelperKt.throwIllegalArgumentException("Expected textStart=" + r11 + " <= textEnd=" + r12);
    L13:
        onTextWillChange(r8, r9, r12 - r11);
        this.buffer.replace(r8, r9, r10, r11, r12);
        commitComposition$foundation_release();
        clearHighlight$foundation_release();
        return;
    L5:
        r2 = false;
        goto L6
    }

    public /* synthetic */ TextFieldBuffer(TextFieldCharSequence r2, ChangeTracker r3, TextFieldCharSequence r4, OffsetMappingCalculator r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = r2;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setComposition$foundation_release$default(TextFieldBuffer r0, int r1, int r2, List r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.setComposition$foundation_release(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: toTextFieldCharSequence-wFTz33Y$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ TextFieldCharSequence m1524toTextFieldCharSequencewFTz33Y$foundation_release$default(TextFieldBuffer r6, long r7, TextRange r9, List r10, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.m1527getSelectiond9O1mEE();
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.composition;
    L8:
        TextRange r3 = r9;
        if ((r12 & 4) == 0) goto L18;
        MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> r8 = r6.composingAnnotations;
        if (r8 == null) goto L17;
        List r14 = r8.asMutableList();
        if (r14 == null) goto L17;
        if ((!r14.isEmpty()) == false) goto L17;
        r10 = r14;
    L17:
        r10 = null;
    L18:
        List r4 = r10;
        if ((r12 & 8) == 0) goto L21;
        List r5 = null;
    L23:
        return r6.m1530toTextFieldCharSequencewFTz33Y$foundation_release(r1, r3, r4, r5);
    L21:
        r5 = r11;
        goto L23
    }

    public static /* synthetic */ void replace$foundation_release$default(TextFieldBuffer r6, int r7, int r8, CharSequence r9, int r10, int r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r12 & 16) == 0) goto L9;
        r11 = r9.length();
    L9:
        r6.replace$foundation_release(r7, r8, r9, r4, r11);
        return;
    L5:
        r4 = r10;
        goto L7
    }
}
