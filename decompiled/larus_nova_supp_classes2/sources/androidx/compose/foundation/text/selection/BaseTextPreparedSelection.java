package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b3\b!\u0018\u0000 c*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0001cB1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ;\u0010&\u001a\u00028\u0000\"\u0004\b\u0001\u0010'*\u0002H'2\b\b\u0002\u0010(\u001a\u00020)2\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020,0+¢\u0006\u0002\b-H\u0084\b¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0004J\u0018\u00102\u001a\u00020,2\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0004J\u000b\u00105\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u00107\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u00108\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u00109\u001a\u00028\u0000¢\u0006\u0002\u00106J$\u0010:\u001a\u00028\u00002\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020,0+¢\u0006\u0002\b-¢\u0006\u0002\u0010<J$\u0010=\u001a\u00028\u00002\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020,0+¢\u0006\u0002\b-¢\u0006\u0002\u0010<J\u0006\u0010>\u001a\u000201J\u0006\u0010?\u001a\u000201J\u0006\u0010@\u001a\u000201J\r\u0010A\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\r\u0010B\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\u000b\u0010C\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010E\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010F\u001a\u00028\u0000¢\u0006\u0002\u00106J\r\u0010G\u001a\u0004\u0018\u000101¢\u0006\u0002\u0010HJ\r\u0010I\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\r\u0010J\u001a\u0004\u0018\u000101¢\u0006\u0002\u0010HJ\r\u0010K\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\u000b\u0010L\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010M\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010N\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010O\u001a\u00028\u0000¢\u0006\u0002\u00106J\r\u0010P\u001a\u0004\u0018\u000101¢\u0006\u0002\u0010HJ\u000b\u0010Q\u001a\u00028\u0000¢\u0006\u0002\u00106J\r\u0010R\u001a\u0004\u0018\u000101¢\u0006\u0002\u0010HJ\u000b\u0010S\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010T\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010U\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010V\u001a\u00028\u0000¢\u0006\u0002\u00106J\b\u0010W\u001a\u00020)H\u0002J\u0017\u0010X\u001a\u000201*\u00020\b2\b\b\u0002\u0010Y\u001a\u000201H\u0082\u0010J\u0017\u0010Z\u001a\u000201*\u00020\b2\b\b\u0002\u0010Y\u001a\u000201H\u0082\u0010J\u0016\u0010[\u001a\u000201*\u00020\b2\b\b\u0002\u0010Y\u001a\u000201H\u0002J\u0016\u0010\\\u001a\u000201*\u00020\b2\b\b\u0002\u0010Y\u001a\u000201H\u0002J\u0014\u0010]\u001a\u000201*\u00020\b2\u0006\u0010^\u001a\u000201H\u0002J\b\u0010_\u001a\u000201H\u0002J\b\u0010`\u001a\u000201H\u0002J\b\u0010a\u001a\u000201H\u0002J\u0010\u0010b\u001a\u0002012\u0006\u00100\u001a\u000201H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006d"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "T", "", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOriginalText", "()Landroidx/compose/ui/text/AnnotatedString;", "getOriginalSelection-d9O1mEE", "()J", "J", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "annotatedString", "getAnnotatedString", "setAnnotatedString", "(Landroidx/compose/ui/text/AnnotatedString;)V", "text", "", "getText$foundation_release", "()Ljava/lang/String;", "apply", "U", "resetCachedX", "", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "setCursor", "offset", "", "setSelection", "start", "end", "selectAll", "()Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "deselect", "moveCursorLeft", "moveCursorRight", "collapseLeftOr", "or", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "collapseRightOr", "getPrecedingCodePointOrEmojiStartIndex", "getPrecedingCharacterIndex", "getNextCharacterIndex", "moveCursorPrev", "moveCursorNext", "moveCursorToHome", "moveCursorToEnd", "moveCursorLeftByWord", "moveCursorRightByWord", "getNextWordOffset", "()Ljava/lang/Integer;", "moveCursorNextByWord", "getPreviousWordOffset", "moveCursorPrevByWord", "moveCursorPrevByParagraph", "moveCursorNextByParagraph", "moveCursorUpByLine", "moveCursorDownByLine", "getLineStartByOffset", "moveCursorToLineStart", "getLineEndByOffset", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "selectMovement", "isLtr", "getNextWordOffsetForLayout", "currentOffset", "getPrevWordOffset", "getLineStartByOffsetForLayout", "getLineEndByOffsetForLayout", "jumpByLinesOffset", "linesAmount", "transformedEndOffset", "transformedMinOffset", "transformedMaxOffset", "charOffset", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BaseTextPreparedSelection<T extends BaseTextPreparedSelection<T>> {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int NoCharacterFound = -1;
    private AnnotatedString annotatedString;
    private final TextLayoutResult layoutResult;
    private final OffsetMapping offsetMapping;
    private final long originalSelection;
    private final AnnotatedString originalText;
    private long selection;
    private final TextPreparedSelectionState state;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection$Companion;", "", "<init>", "()V", "NoCharacterFound", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public /* synthetic */ BaseTextPreparedSelection(AnnotatedString r1, long r2, TextLayoutResult r4, OffsetMapping r5, TextPreparedSelectionState r6, DefaultConstructorMarker r7) {
        this(r1, r2, r4, r5, r6);
    }

    private final boolean isLtr() {
        TextLayoutResult r0 = this.layoutResult;
        if (r0 == null) goto L5;
        ResolvedTextDirection r1 = r0.getParagraphDirection(transformedEndOffset());
    L7:
        if (r1 == ResolvedTextDirection.Rtl) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    private final int transformedEndOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.getEnd-impl(this.selection));
    }

    private final int transformedMaxOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.getMax-impl(this.selection));
    }

    private final int transformedMinOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.getMin-impl(this.selection));
    }

    public final Integer getLineEndByOffset() {
        TextLayoutResult r0 = this.layoutResult;
        if (r0 != null) goto L5;
        return null;
    L5:
        return Integer.valueOf(getLineEndByOffsetForLayout$default(this, r0, 0, 1, null));
    }

    public final Integer getLineStartByOffset() {
        TextLayoutResult r0 = this.layoutResult;
        if (r0 != null) goto L5;
        return null;
    L5:
        return Integer.valueOf(getLineStartByOffsetForLayout$default(this, r0, 0, 1, null));
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.annotatedString.getText(), TextRange.getEnd-impl(this.selection));
    }

    public final Integer getNextWordOffset() {
        TextLayoutResult r0 = this.layoutResult;
        if (r0 != null) goto L5;
        return null;
    L5:
        return Integer.valueOf(getNextWordOffsetForLayout$default(this, r0, 0, 1, null));
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.annotatedString.getText(), TextRange.getEnd-impl(this.selection));
    }

    public final int getPrecedingCodePointOrEmojiStartIndex() {
        return StringHelpers_androidKt.findCodePointOrEmojiStartBefore(this.annotatedString.getText(), TextRange.getEnd-impl(this.selection), -1);
    }

    public final Integer getPreviousWordOffset() {
        TextLayoutResult r0 = this.layoutResult;
        if (r0 != null) goto L5;
        return null;
    L5:
        return Integer.valueOf(getPrevWordOffset$default(this, r0, 0, 1, null));
    }

    public final String getText$foundation_release() {
        return this.annotatedString.getText();
    }

    private final T moveCursorNext() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        int r1 = getNextCharacterIndex();
        if (r1 == (-1)) goto L10;
        setCursor(r1);
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    private final T moveCursorNextByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        Integer r1 = getNextWordOffset();
        if (r1 == null) goto L10;
        setCursor(r1.intValue());
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    private final T moveCursorPrev() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        int r1 = getPrecedingCharacterIndex();
        if (r1 == (-1)) goto L10;
        setCursor(r1);
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    private final T moveCursorPrevByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        Integer r1 = getPreviousWordOffset();
        if (r1 == null) goto L10;
        setCursor(r1.intValue());
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final T deselect() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        setCursor(TextRange.getEnd-impl(this.selection));
    L8:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorDownByLine() {
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        TextLayoutResult r1 = this.layoutResult;
        if (r1 == null) goto L10;
        setCursor(jumpByLinesOffset(r1, 1));
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorLeft() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L11:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L8:
        if (isLtr() == false) goto L10;
        moveCursorPrev();
        goto L11
    L10:
        moveCursorNext();
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorLeftByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L11:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L8:
        if (isLtr() == false) goto L10;
        moveCursorPrevByWord();
        goto L11
    L10:
        moveCursorNextByWord();
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorNextByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        int r1 = StringHelpersKt.findParagraphEnd(getText$foundation_release(), TextRange.getMax-impl(this.selection));
        if (r1 == TextRange.getMax-impl(this.selection)) goto L10;
    L12:
        setCursor(r1);
        goto L13
    L10:
        if (r1 == getText$foundation_release().length()) goto L12;
        r1 = StringHelpersKt.findParagraphEnd(getText$foundation_release(), r1 + 1);
    L13:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorPrevByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        int r1 = StringHelpersKt.findParagraphStart(getText$foundation_release(), TextRange.getMin-impl(this.selection));
        if (r1 != TextRange.getMin-impl(this.selection)) goto L11;
        if (r1 == 0) goto L11;
        r1 = StringHelpersKt.findParagraphStart(getText$foundation_release(), r1 - 1);
    L11:
        setCursor(r1);
    L12:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorRight() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L11:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L8:
        if (isLtr() == false) goto L10;
        moveCursorNext();
        goto L11
    L10:
        moveCursorPrev();
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorRightByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L11:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L8:
        if (isLtr() == false) goto L10;
        moveCursorNextByWord();
        goto L11
    L10:
        moveCursorPrevByWord();
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorToEnd() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        setCursor(getText$foundation_release().length());
    L8:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorToHome() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        setCursor(0);
    L8:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorToLineEnd() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        Integer r1 = getLineEndByOffset();
        if (r1 == null) goto L10;
        setCursor(r1.intValue());
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorToLineLeftSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L11:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L8:
        if (isLtr() == false) goto L10;
        moveCursorToLineStart();
        goto L11
    L10:
        moveCursorToLineEnd();
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorToLineRightSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L11:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L8:
        if (isLtr() == false) goto L10;
        moveCursorToLineEnd();
        goto L11
    L10:
        moveCursorToLineStart();
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorToLineStart() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        Integer r1 = getLineStartByOffset();
        if (r1 == null) goto L10;
        setCursor(r1.intValue());
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final T moveCursorUpByLine() {
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        TextLayoutResult r1 = this.layoutResult;
        if (r1 == null) goto L10;
        setCursor(jumpByLinesOffset(r1, -1));
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final T selectAll() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        setSelection(0, getText$foundation_release().length());
    L8:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final T selectMovement() {
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.selection = TextRangeKt.TextRange(TextRange.getStart-impl(this.originalSelection), TextRange.getEnd-impl(this.selection));
    L8:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    /* JADX INFO: renamed from: getOriginalSelection-d9O1mEE, reason: not valid java name */
    public final long m1825getOriginalSelectiond9O1mEE() {
        return this.originalSelection;
    }

    public final AnnotatedString getOriginalText() {
        return this.originalText;
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m1826getSelectiond9O1mEE() {
        return this.selection;
    }

    public final TextPreparedSelectionState getState() {
        return this.state;
    }

    private final int charOffset(int r2) {
        return RangesKt.coerceAtMost(r2, getText$foundation_release().length() - 1);
    }

    public final T collapseLeftOr(Function1<? super T, Unit> r5) {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
    L15:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L9:
        if (TextRange.getCollapsed-impl(this.selection) == false) goto L12;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        r5.invoke(this);
        goto L15
    L12:
        if (isLtr() == false) goto L14;
        setCursor(TextRange.getMin-impl(this.selection));
        goto L15
    L14:
        setCursor(TextRange.getMax-impl(this.selection));
        goto L15
    L5:
        r0 = false;
        goto L7
    }

    public final T collapseRightOr(Function1<? super T, Unit> r5) {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
    L15:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L9:
        if (TextRange.getCollapsed-impl(this.selection) == false) goto L12;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        r5.invoke(this);
        goto L15
    L12:
        if (isLtr() == false) goto L14;
        setCursor(TextRange.getMax-impl(this.selection));
        goto L15
    L14:
        setCursor(TextRange.getMin-impl(this.selection));
        goto L15
    L5:
        r0 = false;
        goto L7
    }

    public final void setAnnotatedString(AnnotatedString r1) {
        this.annotatedString = r1;
    }

    public final void setCursor(int r1) {
        setSelection(r1, r1);
    }

    /* JADX INFO: renamed from: setSelection-5zc-tL8, reason: not valid java name */
    public final void m1827setSelection5zctL8(long r1) {
        this.selection = r1;
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult r3, int r4) {
        int r5 = r3.getLineForOffset(r4);
        return this.offsetMapping.transformedToOriginal(r3.getLineEnd(r5, true));
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult r2, int r3) {
        int r4 = r2.getLineForOffset(r3);
        return this.offsetMapping.transformedToOriginal(r2.getLineStart(r4));
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult r4, int r5) {
    L3:
        if (r5 >= this.originalText.length()) goto L5;
        long r0 = r4.getWordBoundary--jx7JFs(charOffset(r5));
        if (TextRange.getEnd-impl(r0) > r5) goto L10;
        r5 = r5 + 1;
        goto L3
    L10:
        return this.offsetMapping.transformedToOriginal(TextRange.getEnd-impl(r0));
    L5:
        return this.originalText.length();
    }

    private final int getPrevWordOffset(TextLayoutResult r4, int r5) {
    L2:
        if (r5 <= 0) goto L3;
        long r0 = r4.getWordBoundary--jx7JFs(charOffset(r5));
        if (TextRange.getStart-impl(r0) < r5) goto L9;
        r5 = r5 - 1;
        goto L2
    L9:
        return this.offsetMapping.transformedToOriginal(TextRange.getStart-impl(r0));
    L3:
        return 0;
    }

    private final int jumpByLinesOffset(TextLayoutResult r7, int r8) {
        int r0 = transformedEndOffset();
        if (this.state.getCachedX() != null) goto L5;
        this.state.setCachedX(Float.valueOf(r7.getCursorRect(r0).getLeft()));
    L5:
        int r1 = r7.getLineForOffset(r0) + r8;
        if (r1 >= 0) goto L10;
        return 0;
    L10:
        if (r1 >= r7.getLineCount()) goto L12;
        float r9 = r7.getLineBottom(r1) - 1;
        Float r2 = this.state.getCachedX();
        Intrinsics.checkNotNull(r2);
        float r3 = r2.floatValue();
        if (isLtr() == false) goto L18;
        if (r3 < r7.getLineRight(r1)) goto L18;
    L22:
        return r7.getLineEnd(r1, true);
    L18:
        if (isLtr() == true) goto L24;
        if (r3 <= r7.getLineLeft(r1)) goto L22;
    L24:
        return this.offsetMapping.transformedToOriginal(r7.getOffsetForPosition-k-4lQ0M(Offset.constructor-impl((Float.floatToRawIntBits(r2.floatValue()) << 32) | (((long) Float.floatToRawIntBits(r9)) & 4294967295L))));
    L12:
        return getText$foundation_release().length();
    }

    public final void setSelection(int r1, int r2) {
        this.selection = TextRangeKt.TextRange(r1, r2);
    }

    public final <U> T apply(U r1, boolean r2, Function1<? super U, Unit> r3) {
        if (r2 == false) goto L5;
        getState().resetCachedX();
    L5:
        if (getText$foundation_release().length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
        r3.invoke(r1);
    L10:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (T) r1;
    L7:
        r4 = false;
        goto L8
    }

    private BaseTextPreparedSelection(AnnotatedString r1, long r2, TextLayoutResult r4, OffsetMapping r5, TextPreparedSelectionState r6) {
        this.originalText = r1;
        this.originalSelection = r2;
        this.layoutResult = r4;
        this.offsetMapping = r5;
        this.state = r6;
        this.selection = r2;
        this.annotatedString = r1;
    }

    public static /* synthetic */ int getLineEndByOffsetForLayout$default(BaseTextPreparedSelection r0, TextLayoutResult r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = r0.transformedMaxOffset();
    L7:
        return r0.getLineEndByOffsetForLayout(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffsetForLayout");
    }

    public static /* synthetic */ int getLineStartByOffsetForLayout$default(BaseTextPreparedSelection r0, TextLayoutResult r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = r0.transformedMinOffset();
    L7:
        return r0.getLineStartByOffsetForLayout(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffsetForLayout");
    }

    public static /* synthetic */ int getNextWordOffsetForLayout$default(BaseTextPreparedSelection r0, TextLayoutResult r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = r0.transformedEndOffset();
    L7:
        return r0.getNextWordOffsetForLayout(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffsetForLayout");
    }

    public static /* synthetic */ int getPrevWordOffset$default(BaseTextPreparedSelection r0, TextLayoutResult r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = r0.transformedEndOffset();
    L7:
        return r0.getPrevWordOffset(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
    }

    public static /* synthetic */ BaseTextPreparedSelection apply$default(BaseTextPreparedSelection r0, Object r1, boolean r2, Function1 r3, int r4, Object r5) {
        if (r5 != null) goto L17;
        boolean r6 = true;
        if ((r4 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if (r2 == false) goto L9;
        r0.getState().resetCachedX();
    L9:
        if (r0.getText$foundation_release().length() > 0) goto L12;
        r6 = false;
    L12:
        if (r6 == false) goto L14;
        r3.invoke(r1);
    L14:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection) r1;
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: apply");
    }
}
