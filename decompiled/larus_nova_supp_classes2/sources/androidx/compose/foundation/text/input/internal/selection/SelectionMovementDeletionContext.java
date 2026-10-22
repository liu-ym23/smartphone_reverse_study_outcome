package androidx.compose.foundation.text.input.internal.selection;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\b\u0001\u0018\u0000 Y2\u00020\u0001:\u0001YB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ,\u0010%\u001a\u00020\u00002\b\b\u0002\u0010&\u001a\u00020\u00072\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020)0(¢\u0006\u0002\b*H\u0082\bJ\u0006\u0010+\u001a\u00020\u0000J\u0006\u0010,\u001a\u00020\u0000J\u0006\u0010-\u001a\u00020\u0000J\u0006\u0010.\u001a\u00020\u0000J\u001f\u0010/\u001a\u00020\u00002\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020)0(¢\u0006\u0002\b*J\u001f\u00101\u001a\u00020\u00002\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020)0(¢\u0006\u0002\b*J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000203J!\u00105\u001a\u00020\u00002\b\b\u0002\u0010&\u001a\u00020\u00072\f\u00106\u001a\b\u0012\u0004\u0012\u00020307H\u0082\bJ\u0006\u00108\u001a\u00020\u0000J\u0006\u00109\u001a\u00020\u0000J\u0006\u0010:\u001a\u00020\u0000J\u0006\u0010;\u001a\u00020\u0000J\u0006\u0010<\u001a\u00020\u0000J\u0006\u0010=\u001a\u00020\u0000J\u0006\u0010>\u001a\u00020\u0000J\u0006\u0010?\u001a\u00020\u0000J\u0006\u0010@\u001a\u00020\u0000J\u0006\u0010A\u001a\u00020\u0000J\u0006\u0010B\u001a\u00020\u0000J\u0006\u0010C\u001a\u00020\u0000J\u0006\u0010D\u001a\u00020\u0000J\u0006\u0010E\u001a\u00020\u0000J\u0006\u0010F\u001a\u00020\u0000J\u0006\u0010G\u001a\u00020\u0000J\u0006\u0010H\u001a\u00020\u0000J\u0006\u0010I\u001a\u00020\u0000J\u0006\u0010J\u001a\u00020\u0000J\u0006\u0010K\u001a\u00020\u0000J\u0006\u0010L\u001a\u00020\u0000J\b\u0010M\u001a\u00020\u0007H\u0002J\u0017\u0010N\u001a\u000203*\u00020\u00052\b\b\u0002\u0010O\u001a\u000203H\u0082\u0010J\u0017\u0010P\u001a\u000203*\u00020\u00052\b\b\u0002\u0010O\u001a\u000203H\u0082\u0010J\u0016\u0010Q\u001a\u000203*\u00020\u00052\b\b\u0002\u0010O\u001a\u000203H\u0002J\u0016\u0010R\u001a\u000203*\u00020\u00052\b\b\u0002\u0010O\u001a\u000203H\u0002J\u0014\u0010S\u001a\u000203*\u00020\u00052\u0006\u0010T\u001a\u000203H\u0002J\u0010\u0010U\u001a\u0002032\u0006\u0010V\u001a\u000203H\u0002J\u0010\u0010W\u001a\u0002032\u0006\u0010X\u001a\u000203H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/SelectionMovementDeletionContext;", "", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "isFromSoftKeyboard", "", "visibleTextLayoutHeight", "", "textPreparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextLayoutResult;ZFLandroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;)V", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getInitialValue", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "initialWedgeAffinity", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "getInitialWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "selection", "Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE", "()J", "setSelection-5zc-tL8", "(J)V", "J", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "getWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "setWedgeAffinity", "(Landroidx/compose/foundation/text/input/internal/WedgeAffinity;)V", "text", "", "applyIfNotEmpty", "resetCachedX", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "selectAll", "deselect", "moveCursorLeftByChar", "moveCursorRightByChar", "collapseLeftOr", "or", "collapseRightOr", "getPrecedingCharacterIndex", "", "getNextCharacterIndex", "moveCursorTo", "proposedCursorMovement", "Lkotlin/Function0;", "moveCursorPrevByCodePointOrEmoji", "moveCursorPrevByChar", "moveCursorNextByChar", "moveCursorToHome", "moveCursorToEnd", "moveCursorLeftByWord", "moveCursorRightByWord", "moveCursorNextByWord", "moveCursorPrevByWord", "moveCursorPrevByParagraph", "moveCursorNextByParagraph", "moveCursorUpByLine", "moveCursorDownByLine", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "moveCursorToLineStart", "moveCursorToLineEnd", "moveCursorUpByPage", "moveCursorDownByPage", "selectMovement", "deleteMovement", "isLtr", "getNextWordOffsetForLayout", "currentOffset", "getPrevWordOffsetForLayout", "getLineStartByOffsetForLayout", "getLineEndByOffsetForLayout", "jumpByLinesOffset", "linesAmount", "jumpByPagesOffset", "pagesAmount", "charOffset", "offset", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectionMovementDeletionContext {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int NoCharacterFound = -1;
    private final TextFieldCharSequence initialValue;
    private final SelectionWedgeAffinity initialWedgeAffinity;
    private final boolean isFromSoftKeyboard;
    private long selection;
    private final TransformedTextFieldState state;
    private final String text;
    private final TextLayoutResult textLayoutResult;
    private final TextFieldPreparedSelectionState textPreparedSelectionState;
    private final float visibleTextLayoutHeight;
    private WedgeAffinity wedgeAffinity;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/SelectionMovementDeletionContext$Companion;", "", "<init>", "()V", "NoCharacterFound", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    private final boolean isLtr() {
        TextLayoutResult r0 = this.textLayoutResult;
        if (r0 == null) goto L12;
        ResolvedTextDirection r1 = r0.getParagraphDirection(TextRange.getEnd-impl(this.selection));
        if (r1 != null) goto L8;
        return true;
    L8:
        if (r1 == ResolvedTextDirection.Ltr) goto L14;
        return false;
    L14:
        return true;
    L12:
        return true;
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.text, TextRange.getEnd-impl(this.selection));
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.text, TextRange.getEnd-impl(this.selection));
    }

    public final SelectionMovementDeletionContext moveCursorDownByLine() {
        TextLayoutResult r0 = this.textLayoutResult;
        boolean r2 = true;
        if (r0 == null) goto L5;
        int r1 = jumpByLinesOffset(r0, 1);
    L7:
        if (r1 != Integer.MAX_VALUE) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        access$getTextPreparedSelectionState$p(this).resetCachedX();
    L13:
        if (access$getText$p(this).length() > 0) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L24;
        int r4 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        long r5 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(RangesKt.coerceAtMost(r1, this.text.length()), r4, access$getState$p(this));
        int r6 = CursorAndWedgeAffinity.m1687component1impl(r5);
        WedgeAffinity r7 = CursorAndWedgeAffinity.m1688component2impl(r5);
        if (r6 == r4) goto L20;
    L21:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r6));
    L22:
        if (r7 == null) goto L24;
        setWedgeAffinity(r7);
        goto L24
    L20:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L22;
    L24:
        return this;
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = Integer.MAX_VALUE;
        goto L7
    }

    public final SelectionMovementDeletionContext moveCursorUpByLine() {
        TextLayoutResult r0 = this.textLayoutResult;
        if (r0 == null) goto L5;
        int r1 = jumpByLinesOffset(r0, -1);
    L6:
        boolean r2 = true;
        if (r1 != Integer.MIN_VALUE) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        access$getTextPreparedSelectionState$p(this).resetCachedX();
    L13:
        if (access$getText$p(this).length() > 0) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L24;
        int r4 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        long r5 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(RangesKt.coerceAtLeast(r1, 0), r4, access$getState$p(this));
        int r6 = CursorAndWedgeAffinity.m1687component1impl(r5);
        WedgeAffinity r7 = CursorAndWedgeAffinity.m1688component2impl(r5);
        if (r6 == r4) goto L20;
    L21:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r6));
    L22:
        if (r7 == null) goto L24;
        setWedgeAffinity(r7);
        goto L24
    L20:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L22;
    L24:
        return this;
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = RtlSpacingHelper.UNDEFINED;
        goto L6
    }

    public final SelectionMovementDeletionContext deleteMovement() {
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L12:
        return this;
    L8:
        if (TextRange.getCollapsed-impl(this.initialValue.m1535getSelectiond9O1mEE()) == true) goto L10;
        this.state.deleteSelectedText();
    L11:
        this.selection = this.state.getVisualText().m1535getSelectiond9O1mEE();
        this.wedgeAffinity = WedgeAffinity.Start;
        goto L12
    L10:
        TransformedTextFieldState.m1672replaceTextM8tDOmk$default(this.state, "", TextRangeKt.TextRange(TextRange.getStart-impl(this.initialValue.m1535getSelectiond9O1mEE()), TextRange.getEnd-impl(this.selection)), null, !this.isFromSoftKeyboard, 4, null);
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext deselect() {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.selection = TextRangeKt.TextRange(TextRange.getEnd-impl(this.selection));
    L8:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext moveCursorDownByPage() {
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        int r1 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        long r2 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(jumpByPagesOffset(1), r1, access$getState$p(this));
        int r3 = CursorAndWedgeAffinity.m1687component1impl(r2);
        WedgeAffinity r4 = CursorAndWedgeAffinity.m1688component2impl(r2);
        if (r3 == r1) goto L10;
    L11:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r3));
    L12:
        if (r4 == null) goto L14;
        setWedgeAffinity(r4);
        goto L14
    L10:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L12;
    L14:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext moveCursorLeftByChar() {
        if (isLtr() == false) goto L6;
        return moveCursorPrevByChar();
    L6:
        return moveCursorNextByChar();
    }

    public final SelectionMovementDeletionContext moveCursorLeftByWord() {
        if (isLtr() == false) goto L6;
        return moveCursorPrevByWord();
    L6:
        return moveCursorNextByWord();
    }

    public final SelectionMovementDeletionContext moveCursorNextByChar() {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        int r1 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        long r2 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(StringHelpers_androidKt.findFollowingBreak(this.text, TextRange.getEnd-impl(this.selection)), r1, access$getState$p(this));
        int r3 = CursorAndWedgeAffinity.m1687component1impl(r2);
        WedgeAffinity r4 = CursorAndWedgeAffinity.m1688component2impl(r2);
        if (r3 == r1) goto L10;
    L11:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r3));
    L12:
        if (r4 == null) goto L14;
        setWedgeAffinity(r4);
        goto L14
    L10:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L12;
    L14:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext moveCursorNextByParagraph() {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        int r1 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        int r2 = StringHelpersKt.findParagraphEnd(this.text, TextRange.getMax-impl(this.selection));
        if (r2 == TextRange.getMax-impl(this.selection)) goto L10;
    L12:
        long r3 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(r2, r1, access$getState$p(this));
        int r4 = CursorAndWedgeAffinity.m1687component1impl(r3);
        WedgeAffinity r5 = CursorAndWedgeAffinity.m1688component2impl(r3);
        if (r4 == r1) goto L15;
    L16:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r4));
    L17:
        if (r5 == null) goto L19;
        setWedgeAffinity(r5);
        goto L19
    L15:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L17;
    L10:
        if (r2 == this.text.length()) goto L12;
        r2 = StringHelpersKt.findParagraphEnd(this.text, r2 + 1);
    L19:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext moveCursorNextByWord() {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        int r1 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        TextLayoutResult r3 = this.textLayoutResult;
        if (r3 == null) goto L10;
        int r2 = getNextWordOffsetForLayout$default(this, r3, 0, 1, null);
    L11:
        long r4 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(r2, r1, access$getState$p(this));
        int r5 = CursorAndWedgeAffinity.m1687component1impl(r4);
        WedgeAffinity r6 = CursorAndWedgeAffinity.m1688component2impl(r4);
        if (r5 == r1) goto L14;
    L15:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r5));
    L16:
        if (r6 == null) goto L18;
        setWedgeAffinity(r6);
        goto L18
    L14:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L16;
    L10:
        r2 = this.text.length();
    L18:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext moveCursorPrevByChar() {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        int r1 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        long r2 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(StringHelpers_androidKt.findPrecedingBreak(this.text, TextRange.getEnd-impl(this.selection)), r1, access$getState$p(this));
        int r3 = CursorAndWedgeAffinity.m1687component1impl(r2);
        WedgeAffinity r4 = CursorAndWedgeAffinity.m1688component2impl(r2);
        if (r3 == r1) goto L10;
    L11:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r3));
    L12:
        if (r4 == null) goto L14;
        setWedgeAffinity(r4);
        goto L14
    L10:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L12;
    L14:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext moveCursorPrevByCodePointOrEmoji() {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        int r1 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        long r2 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(StringHelpers_androidKt.findCodePointOrEmojiStartBefore(this.text, TextRange.getEnd-impl(this.selection), -1), r1, access$getState$p(this));
        int r3 = CursorAndWedgeAffinity.m1687component1impl(r2);
        WedgeAffinity r4 = CursorAndWedgeAffinity.m1688component2impl(r2);
        if (r3 == r1) goto L10;
    L11:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r3));
    L12:
        if (r4 == null) goto L14;
        setWedgeAffinity(r4);
        goto L14
    L10:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L12;
    L14:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext moveCursorPrevByParagraph() {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        int r1 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        int r2 = StringHelpersKt.findParagraphStart(this.text, TextRange.getMin-impl(this.selection));
        if (r2 != TextRange.getMin-impl(this.selection)) goto L11;
        if (r2 == 0) goto L11;
        r2 = StringHelpersKt.findParagraphStart(this.text, r2 - 1);
    L11:
        long r3 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(r2, r1, access$getState$p(this));
        int r4 = CursorAndWedgeAffinity.m1687component1impl(r3);
        WedgeAffinity r5 = CursorAndWedgeAffinity.m1688component2impl(r3);
        if (r4 == r1) goto L14;
    L15:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r4));
    L16:
        if (r5 == null) goto L18;
        setWedgeAffinity(r5);
        goto L18
    L14:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L16;
    L18:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext moveCursorPrevByWord() {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        int r2 = 0;
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        int r1 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        TextLayoutResult r3 = this.textLayoutResult;
        if (r3 == null) goto L10;
        r2 = getPrevWordOffsetForLayout$default(this, r3, 0, 1, null);
    L10:
        long r4 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(r2, r1, access$getState$p(this));
        int r5 = CursorAndWedgeAffinity.m1687component1impl(r4);
        WedgeAffinity r6 = CursorAndWedgeAffinity.m1688component2impl(r4);
        if (r5 == r1) goto L13;
    L14:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r5));
    L15:
        if (r6 == null) goto L17;
        setWedgeAffinity(r6);
        goto L17
    L13:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L15;
    L17:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext moveCursorRightByChar() {
        if (isLtr() == false) goto L6;
        return moveCursorNextByChar();
    L6:
        return moveCursorPrevByChar();
    }

    public final SelectionMovementDeletionContext moveCursorRightByWord() {
        if (isLtr() == false) goto L6;
        return moveCursorNextByWord();
    L6:
        return moveCursorPrevByWord();
    }

    public final SelectionMovementDeletionContext moveCursorToEnd() {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        int r1 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        long r2 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(this.text.length(), r1, access$getState$p(this));
        int r3 = CursorAndWedgeAffinity.m1687component1impl(r2);
        WedgeAffinity r4 = CursorAndWedgeAffinity.m1688component2impl(r2);
        if (r3 == r1) goto L10;
    L11:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r3));
    L12:
        if (r4 == null) goto L14;
        setWedgeAffinity(r4);
        goto L14
    L10:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L12;
    L14:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext moveCursorToHome() {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        int r1 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        long r2 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(0, r1, access$getState$p(this));
        int r3 = CursorAndWedgeAffinity.m1687component1impl(r2);
        WedgeAffinity r4 = CursorAndWedgeAffinity.m1688component2impl(r2);
        if (r3 == r1) goto L10;
    L11:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r3));
    L12:
        if (r4 == null) goto L14;
        setWedgeAffinity(r4);
        goto L14
    L10:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L12;
    L14:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext moveCursorToLineEnd() {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        int r1 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        TextLayoutResult r3 = this.textLayoutResult;
        if (r3 == null) goto L10;
        int r2 = getLineEndByOffsetForLayout$default(this, r3, 0, 1, null);
    L11:
        long r4 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(r2, r1, access$getState$p(this));
        int r5 = CursorAndWedgeAffinity.m1687component1impl(r4);
        WedgeAffinity r6 = CursorAndWedgeAffinity.m1688component2impl(r4);
        if (r5 == r1) goto L14;
    L15:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r5));
    L16:
        if (r6 == null) goto L18;
        setWedgeAffinity(r6);
        goto L18
    L14:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L16;
    L10:
        r2 = this.text.length();
    L18:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext moveCursorToLineLeftSide() {
        if (isLtr() == false) goto L6;
        return moveCursorToLineStart();
    L6:
        return moveCursorToLineEnd();
    }

    public final SelectionMovementDeletionContext moveCursorToLineRightSide() {
        if (isLtr() == false) goto L6;
        return moveCursorToLineEnd();
    L6:
        return moveCursorToLineStart();
    }

    public final SelectionMovementDeletionContext moveCursorToLineStart() {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        int r2 = 0;
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        int r1 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        TextLayoutResult r3 = this.textLayoutResult;
        if (r3 == null) goto L10;
        r2 = getLineStartByOffsetForLayout$default(this, r3, 0, 1, null);
    L10:
        long r4 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(r2, r1, access$getState$p(this));
        int r5 = CursorAndWedgeAffinity.m1687component1impl(r4);
        WedgeAffinity r6 = CursorAndWedgeAffinity.m1688component2impl(r4);
        if (r5 == r1) goto L13;
    L14:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r5));
    L15:
        if (r6 == null) goto L17;
        setWedgeAffinity(r6);
        goto L17
    L13:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L15;
    L17:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext moveCursorUpByPage() {
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        int r1 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        long r2 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(jumpByPagesOffset(-1), r1, access$getState$p(this));
        int r3 = CursorAndWedgeAffinity.m1687component1impl(r2);
        WedgeAffinity r4 = CursorAndWedgeAffinity.m1688component2impl(r2);
        if (r3 == r1) goto L10;
    L11:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r3));
    L12:
        if (r4 == null) goto L14;
        setWedgeAffinity(r4);
        goto L14
    L10:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L12;
    L14:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext selectAll() {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.selection = TextRangeKt.TextRange(0, this.text.length());
    L8:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext selectMovement() {
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.selection = TextRangeKt.TextRange(TextRange.getStart-impl(this.initialValue.m1535getSelectiond9O1mEE()), TextRange.getEnd-impl(this.selection));
    L8:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final TextFieldCharSequence getInitialValue() {
        return this.initialValue;
    }

    public final SelectionWedgeAffinity getInitialWedgeAffinity() {
        return this.initialWedgeAffinity;
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m1699getSelectiond9O1mEE() {
        return this.selection;
    }

    public final WedgeAffinity getWedgeAffinity() {
        return this.wedgeAffinity;
    }

    public static final /* synthetic */ TransformedTextFieldState access$getState$p(SelectionMovementDeletionContext r0) {
        return r0.state;
    }

    public static final /* synthetic */ String access$getText$p(SelectionMovementDeletionContext r0) {
        return r0.text;
    }

    public static final /* synthetic */ TextFieldPreparedSelectionState access$getTextPreparedSelectionState$p(SelectionMovementDeletionContext r0) {
        return r0.textPreparedSelectionState;
    }

    private final int charOffset(int r2) {
        return RangesKt.coerceAtMost(r2, this.text.length() - 1);
    }

    private final int jumpByPagesOffset(int r4) {
        int r0 = TextRange.getEnd-impl(this.initialValue.m1535getSelectiond9O1mEE());
        if (this.textLayoutResult != null) goto L5;
    L12:
        return r0;
    L5:
        if (Float.isNaN(this.visibleTextLayoutHeight) == true) goto L12;
        Rect r5 = this.textLayoutResult.getCursorRect(r0).translate(MenuKt.ClosedAlphaTarget, this.visibleTextLayoutHeight * r4);
        float r1 = this.textLayoutResult.getLineBottom(this.textLayoutResult.getLineForVerticalPosition(r5.getTop()));
        if (Math.abs(r5.getTop() - r1) <= Math.abs(r5.getBottom() - r1)) goto L11;
        return this.textLayoutResult.getOffsetForPosition-k-4lQ0M(r5.getTopLeft-F1C5BW0());
    L11:
        return this.textLayoutResult.getOffsetForPosition-k-4lQ0M(r5.getBottomLeft-F1C5BW0());
    }

    public final SelectionMovementDeletionContext collapseLeftOr(Function1<? super SelectionMovementDeletionContext, Unit> r3) {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L14:
        return this;
    L8:
        if (TextRange.getCollapsed-impl(this.selection) == false) goto L11;
        r3.invoke(this);
        goto L14
    L11:
        if (isLtr() == false) goto L13;
        this.selection = TextRangeKt.TextRange(TextRange.getMin-impl(this.selection));
        goto L14
    L13:
        this.selection = TextRangeKt.TextRange(TextRange.getMax-impl(this.selection));
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    public final SelectionMovementDeletionContext collapseRightOr(Function1<? super SelectionMovementDeletionContext, Unit> r3) {
        access$getTextPreparedSelectionState$p(this).resetCachedX();
        if (access$getText$p(this).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L14:
        return this;
    L8:
        if (TextRange.getCollapsed-impl(this.selection) == false) goto L11;
        r3.invoke(this);
        goto L14
    L11:
        if (isLtr() == false) goto L13;
        this.selection = TextRangeKt.TextRange(TextRange.getMax-impl(this.selection));
        goto L14
    L13:
        this.selection = TextRangeKt.TextRange(TextRange.getMin-impl(this.selection));
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: setSelection-5zc-tL8, reason: not valid java name */
    public final void m1700setSelection5zctL8(long r1) {
        this.selection = r1;
    }

    public final void setWedgeAffinity(WedgeAffinity r1) {
        this.wedgeAffinity = r1;
    }

    private final SelectionMovementDeletionContext applyIfNotEmpty(boolean r1, Function1<? super SelectionMovementDeletionContext, Unit> r2) {
        if (r1 == false) goto L5;
        access$getTextPreparedSelectionState$p(this).resetCachedX();
    L5:
        if (access$getText$p(this).length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        r2.invoke(this);
    L10:
        return this;
    L7:
        r3 = false;
        goto L8
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult r2, int r3) {
        return r2.getLineEnd(r2.getLineForOffset(r3), true);
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult r1, int r2) {
        return r1.getLineStart(r1.getLineForOffset(r2));
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult r4, int r5) {
    L3:
        if (r5 >= this.initialValue.length()) goto L5;
        long r0 = r4.getWordBoundary--jx7JFs(charOffset(r5));
        if (TextRange.getEnd-impl(r0) > r5) goto L10;
        r5 = r5 + 1;
        goto L3
    L10:
        return TextRange.getEnd-impl(r0);
    L5:
        return this.initialValue.length();
    }

    private final int getPrevWordOffsetForLayout(TextLayoutResult r4, int r5) {
    L2:
        if (r5 <= 0) goto L3;
        long r0 = r4.getWordBoundary--jx7JFs(charOffset(r5));
        if (TextRange.getStart-impl(r0) < r5) goto L9;
        r5 = r5 - 1;
        goto L2
    L9:
        return TextRange.getStart-impl(r0);
    L3:
        return 0;
    }

    private final int jumpByLinesOffset(TextLayoutResult r7, int r8) {
        int r0 = TextRange.getEnd-impl(this.selection);
        if (Float.isNaN(this.textPreparedSelectionState.getCachedX()) == false) goto L5;
        this.textPreparedSelectionState.setCachedX(r7.getCursorRect(r0).getLeft());
    L5:
        int r1 = r7.getLineForOffset(r0) + r8;
        if (r1 >= 0) goto L10;
        return RtlSpacingHelper.UNDEFINED;
    L10:
        if (r1 < r7.getLineCount()) goto L13;
        return Integer.MAX_VALUE;
    L13:
        float r9 = r7.getLineBottom(r1) - 1;
        float r2 = this.textPreparedSelectionState.getCachedX();
        if (isLtr() == false) goto L18;
        if (r2 < r7.getLineRight(r1)) goto L18;
    L22:
        return r7.getLineEnd(r1, true);
    L18:
        if (isLtr() == true) goto L24;
        if (r2 <= r7.getLineLeft(r1)) goto L22;
    L24:
        return r7.getOffsetForPosition-k-4lQ0M(Offset.constructor-impl((Float.floatToRawIntBits(r2) << 32) | (((long) Float.floatToRawIntBits(r9)) & 4294967295L)));
    }

    private final SelectionMovementDeletionContext moveCursorTo(boolean r4, Function0<Integer> r5) {
        if (r4 == false) goto L5;
        access$getTextPreparedSelectionState$p(this).resetCachedX();
    L5:
        if (access$getText$p(this).length() <= 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L16;
        int r7 = TextRange.getEnd-impl(m1699getSelectiond9O1mEE());
        long r0 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(((Number) r5.invoke()).intValue(), r7, access$getState$p(this));
        int r8 = CursorAndWedgeAffinity.m1687component1impl(r0);
        WedgeAffinity r1 = CursorAndWedgeAffinity.m1688component2impl(r0);
        if (r8 == r7) goto L12;
    L13:
        m1700setSelection5zctL8(TextRangeKt.TextRange(r8));
    L14:
        if (r1 == null) goto L16;
        setWedgeAffinity(r1);
        goto L16
    L12:
        if (TextRange.getCollapsed-impl(m1699getSelectiond9O1mEE()) == true) goto L14;
    L16:
        return this;
    L7:
        r6 = false;
        goto L8
    }

    public SelectionMovementDeletionContext(TransformedTextFieldState r2, TextLayoutResult r3, boolean r4, float r5, TextFieldPreparedSelectionState r6) {
        this.state = r2;
        this.textLayoutResult = r3;
        this.isFromSoftKeyboard = r4;
        this.visibleTextLayoutHeight = r5;
        this.textPreparedSelectionState = r6;
        Snapshot.Companion r7 = Snapshot.Companion;
        Snapshot r8 = r7.getCurrentThreadSnapshot();
        if (r8 == null) goto L5;
        Function1 r9 = r8.getReadObserver();
    L6:
        Snapshot r10 = r7.makeCurrentNonObservable(r8);
        TextFieldCharSequence r0 = r2.getVisualText();     // Catch: Throwable -> L10
        this.initialValue = r0;     // Catch: Throwable -> L10
        this.initialWedgeAffinity = r2.getSelectionWedgeAffinity();     // Catch: Throwable -> L10
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r7.restoreNonObservable(r8, r10, r9);
        this.selection = r0.m1535getSelectiond9O1mEE();
        this.text = r0.getText().toString();
        return;
    L10:
        th = move-exception;
        r7.restoreNonObservable(r8, r10, r9);
        throw th;
    L5:
        r9 = null;
        goto L6
    }

    public static /* synthetic */ SelectionMovementDeletionContext applyIfNotEmpty$default(SelectionMovementDeletionContext r0, boolean r1, Function1 r2, int r3, Object r4) {
        boolean r5 = true;
        if ((r3 & 1) == 0) goto L5;
        r1 = true;
    L5:
        if (r1 == false) goto L8;
        access$getTextPreparedSelectionState$p(r0).resetCachedX();
    L8:
        if (access$getText$p(r0).length() > 0) goto L11;
        r5 = false;
    L11:
        if (r5 == false) goto L13;
        r2.invoke(r0);
    L13:
        return r0;
    }

    public static /* synthetic */ int getLineEndByOffsetForLayout$default(SelectionMovementDeletionContext r0, TextLayoutResult r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = TextRange.getMax-impl(r0.selection);
    L6:
        return r0.getLineEndByOffsetForLayout(r1, r2);
    }

    public static /* synthetic */ int getLineStartByOffsetForLayout$default(SelectionMovementDeletionContext r0, TextLayoutResult r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = TextRange.getMin-impl(r0.selection);
    L6:
        return r0.getLineStartByOffsetForLayout(r1, r2);
    }

    public static /* synthetic */ int getNextWordOffsetForLayout$default(SelectionMovementDeletionContext r0, TextLayoutResult r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = TextRange.getEnd-impl(r0.selection);
    L6:
        return r0.getNextWordOffsetForLayout(r1, r2);
    }

    public static /* synthetic */ int getPrevWordOffsetForLayout$default(SelectionMovementDeletionContext r0, TextLayoutResult r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = TextRange.getEnd-impl(r0.selection);
    L6:
        return r0.getPrevWordOffsetForLayout(r1, r2);
    }

    public static /* synthetic */ SelectionMovementDeletionContext moveCursorTo$default(SelectionMovementDeletionContext r2, boolean r3, Function0 r4, int r5, Object r6) {
        boolean r7 = true;
        if ((r5 & 1) == 0) goto L5;
        r3 = true;
    L5:
        if (r3 == false) goto L8;
        access$getTextPreparedSelectionState$p(r2).resetCachedX();
    L8:
        if (access$getText$p(r2).length() > 0) goto L11;
        r7 = false;
    L11:
        if (r7 == false) goto L19;
        int r8 = TextRange.getEnd-impl(r2.m1699getSelectiond9O1mEE());
        long r9 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(((Number) r4.invoke()).intValue(), r8, access$getState$p(r2));
        int r10 = CursorAndWedgeAffinity.m1687component1impl(r9);
        WedgeAffinity r11 = CursorAndWedgeAffinity.m1688component2impl(r9);
        if (r10 == r8) goto L15;
    L16:
        r2.m1700setSelection5zctL8(TextRangeKt.TextRange(r10));
    L17:
        if (r11 == null) goto L19;
        r2.setWedgeAffinity(r11);
        goto L19
    L15:
        if (TextRange.getCollapsed-impl(r2.m1699getSelectiond9O1mEE()) == true) goto L17;
    L19:
        return r2;
    }
}
