package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0019\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0016¢\u0006\u0002\b\u0017J\u0006\u0010\u0018\u001a\u00020\u0000J\u0006\u0010\u0019\u001a\u00020\u0000J\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\r¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "currentValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "layoutResultProxy", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "<init>", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/TextLayoutResultProxy;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;)V", "getCurrentValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getLayoutResultProxy", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "value", "getValue", "deleteIfSelectedOr", "", "Landroidx/compose/ui/text/input/EditCommand;", "or", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "moveCursorUpByPage", "moveCursorDownByPage", "jumpByPagesOffset", "", "pagesAmount", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldPreparedSelection extends BaseTextPreparedSelection<TextFieldPreparedSelection> {
    public static final int $stable = 8;
    private final TextFieldValue currentValue;
    private final TextLayoutResultProxy layoutResultProxy;

    public final TextFieldValue getValue() {
        return TextFieldValue.copy-3r_uNRQ$default(this.currentValue, getAnnotatedString(), m1826getSelectiond9O1mEE(), null, 4, null);
    }

    public final TextFieldPreparedSelection moveCursorDownByPage() {
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        TextLayoutResultProxy r1 = this.layoutResultProxy;
        if (r1 == null) goto L10;
        setCursor(jumpByPagesOffset(r1, 1));
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final TextFieldPreparedSelection moveCursorUpByPage() {
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        TextLayoutResultProxy r1 = this.layoutResultProxy;
        if (r1 == null) goto L10;
        setCursor(jumpByPagesOffset(r1, -1));
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final TextFieldValue getCurrentValue() {
        return this.currentValue;
    }

    public final TextLayoutResultProxy getLayoutResultProxy() {
        return this.layoutResultProxy;
    }

    public final List<EditCommand> deleteIfSelectedOr(Function1<? super TextFieldPreparedSelection, ? extends EditCommand> r5) {
        if (TextRange.getCollapsed-impl(m1826getSelectiond9O1mEE()) == false) goto L9;
        EditCommand r6 = (EditCommand) r5.invoke(this);
        if (r6 != null) goto L10;
        return null;
    L10:
        return CollectionsKt.listOf(r6);
    L9:
        return CollectionsKt.listOf(new EditCommand[]{new CommitTextCommand("", 0), new SetSelectionCommand(TextRange.getMin-impl(m1826getSelectiond9O1mEE()), TextRange.getMin-impl(m1826getSelectiond9O1mEE()))});
    }

    private final int jumpByPagesOffset(TextLayoutResultProxy r9, int r10) {
        LayoutCoordinates r0 = r9.getInnerTextFieldCoordinates();
        if (r0 == null) goto L8;
        LayoutCoordinates r1 = r9.getDecorationBoxCoordinates();
        Rect r2 = null;
        if (r1 == null) goto L7;
        r2 = LayoutCoordinates.-CC.localBoundingBoxOf$default(r1, r0, false, 2, null);
    L7:
        if (r2 == null) goto L8;
    L9:
        Rect r3 = r9.getValue().getCursorRect(getOffsetMapping().originalToTransformed(TextRange.getEnd-impl(this.currentValue.getSelection-d9O1mEE())));
        float r4 = r3.getLeft();
        float r5 = r3.getTop() + (Float.intBitsToFloat((int) (r2.getSize-NH-jbRc() & 4294967295L)) * r10);
        return getOffsetMapping().transformedToOriginal(r9.getValue().getOffsetForPosition-k-4lQ0M(Offset.constructor-impl((Float.floatToRawIntBits(r4) << 32) | (Float.floatToRawIntBits(r5) & 4294967295L))));
    L8:
        r2 = Rect.Companion.getZero();
        goto L9
    }

    public TextFieldPreparedSelection(TextFieldValue r9, OffsetMapping r10, TextLayoutResultProxy r11, TextPreparedSelectionState r12) {
        AnnotatedString r1 = r9.getAnnotatedString();
        long r2 = r9.getSelection-d9O1mEE();
        if (r11 == null) goto L5;
        TextLayoutResult r0 = r11.getValue();
    L6:
        super(r1, r2, r0, r10, r12, null);
        this.currentValue = r9;
        this.layoutResultProxy = r11;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public /* synthetic */ TextFieldPreparedSelection(TextFieldValue r1, OffsetMapping r2, TextLayoutResultProxy r3, TextPreparedSelectionState r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = OffsetMapping.Companion.getIdentity();
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = new TextPreparedSelectionState();
    L8:
        this(r1, r2, r3, r4);
    }
}
