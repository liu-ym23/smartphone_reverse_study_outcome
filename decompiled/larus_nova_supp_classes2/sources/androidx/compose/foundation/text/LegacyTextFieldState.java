package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0007\u0010\u0087\u0001\u001a\u00020\u001dJx\u0010\u0088\u0001\u001a\u00020j2\u0006\u0010<\u001a\u00020=2\u0007\u0010\u0089\u0001\u001a\u00020=2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u001d2\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\b\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0012\u0010k\u001a\u000e\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u00020j0h2\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0006\u0010w\u001a\u00020x¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R+\u0010&\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020%8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010$\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010/\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010-8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010605X\u0082\u0004¢\u0006\u0002\n\u0000R(\u00107\u001a\u0004\u0018\u0001062\b\u0010.\u001a\u0004\u0018\u0001068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR+\u0010C\u001a\u00020B2\u0006\u0010\u001c\u001a\u00020B8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010$\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR+\u0010I\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010$\u001a\u0004\bJ\u0010 \"\u0004\bK\u0010\"R+\u0010M\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bP\u0010$\u001a\u0004\bN\u0010 \"\u0004\bO\u0010\"R+\u0010Q\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bT\u0010$\u001a\u0004\bR\u0010 \"\u0004\bS\u0010\"R+\u0010U\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bX\u0010$\u001a\u0004\bV\u0010 \"\u0004\bW\u0010\"R\u001e\u0010Y\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010 R+\u0010Z\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\\\u0010$\u001a\u0004\bZ\u0010 \"\u0004\b[\u0010\"R\u000e\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010_\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bb\u0010$\u001a\u0004\b`\u0010 \"\u0004\ba\u0010\"R+\u0010c\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bf\u0010$\u001a\u0004\bd\u0010 \"\u0004\be\u0010\"R\u001a\u0010g\u001a\u000e\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u00020j0hX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010k\u001a\u000e\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u00020j0h¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u001d\u0010n\u001a\u000e\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020j0h¢\u0006\b\n\u0000\u001a\u0004\bp\u0010mR\u001d\u0010q\u001a\u000e\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020\u001d0h¢\u0006\b\n\u0000\u001a\u0004\br\u0010mR\u0011\u0010s\u001a\u00020t¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u001c\u0010w\u001a\u00020xX\u0086\u000e¢\u0006\u0010\n\u0002\u0010}\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R.\u0010\u007f\u001a\u00020~2\u0006\u0010\u001c\u001a\u00020~8F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010$\u001a\u0005\b\u0080\u0001\u0010z\"\u0005\b\u0081\u0001\u0010|R/\u0010\u0083\u0001\u001a\u00020~2\u0006\u0010\u001c\u001a\u00020~8F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010$\u001a\u0005\b\u0084\u0001\u0010z\"\u0005\b\u0085\u0001\u0010|¨\u0006\u0097\u0001"}, d2 = {"Landroidx/compose/foundation/text/LegacyTextFieldState;", "", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "<init>", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/runtime/RecomposeScope;Landroidx/compose/ui/platform/SoftwareKeyboardController;)V", "getTextDelegate", "()Landroidx/compose/foundation/text/TextDelegate;", "setTextDelegate", "(Landroidx/compose/foundation/text/TextDelegate;)V", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "getKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "processor", "Landroidx/compose/ui/text/input/EditProcessor;", "getProcessor", "()Landroidx/compose/ui/text/input/EditProcessor;", "inputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "getInputSession", "()Landroidx/compose/ui/text/input/TextInputSession;", "setInputSession", "(Landroidx/compose/ui/text/input/TextInputSession;)V", "<set-?>", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField$delegate", "_layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "value", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "layoutResultState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "layoutResult", "getLayoutResult", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "setLayoutResult", "(Landroidx/compose/foundation/text/TextLayoutResultProxy;)V", "untransformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getUntransformedText", "()Landroidx/compose/ui/text/AnnotatedString;", "setUntransformedText", "(Landroidx/compose/ui/text/AnnotatedString;)V", "Landroidx/compose/foundation/text/HandleState;", "handleState", "getHandleState", "()Landroidx/compose/foundation/text/HandleState;", "setHandleState", "(Landroidx/compose/foundation/text/HandleState;)V", "handleState$delegate", "showFloatingToolbar", "getShowFloatingToolbar", "setShowFloatingToolbar", "showFloatingToolbar$delegate", "showSelectionHandleStart", "getShowSelectionHandleStart", "setShowSelectionHandleStart", "showSelectionHandleStart$delegate", "showSelectionHandleEnd", "getShowSelectionHandleEnd", "setShowSelectionHandleEnd", "showSelectionHandleEnd$delegate", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "isLayoutResultStale", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "keyboardActionRunner", "Landroidx/compose/foundation/text/KeyboardActionRunner;", "autofillHighlightOn", "getAutofillHighlightOn", "setAutofillHighlightOn", "autofillHighlightOn$delegate", "justAutofilled", "getJustAutofilled", "setJustAutofilled", "justAutofilled$delegate", "onValueChangeOriginal", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/TextFieldValue;", "", "onValueChange", "getOnValueChange", "()Lkotlin/jvm/functions/Function1;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "getOnImeActionPerformed", "onImeActionPerformedWithResult", "getOnImeActionPerformedWithResult", "highlightPaint", "Landroidx/compose/ui/graphics/Paint;", "getHighlightPaint", "()Landroidx/compose/ui/graphics/Paint;", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "getSelectionBackgroundColor-0d7_KjU", "()J", "setSelectionBackgroundColor-8_81llA", "(J)V", "J", "Landroidx/compose/ui/text/TextRange;", "selectionPreviewHighlightRange", "getSelectionPreviewHighlightRange-d9O1mEE", "setSelectionPreviewHighlightRange-5zc-tL8", "selectionPreviewHighlightRange$delegate", "deletionPreviewHighlightRange", "getDeletionPreviewHighlightRange-d9O1mEE", "setDeletionPreviewHighlightRange-5zc-tL8", "deletionPreviewHighlightRange$delegate", "hasHighlight", "update", "visualText", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "update-fnh65Uc", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/ui/focus/FocusManager;J)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LegacyTextFieldState {
    public static final int $stable = 8;
    private LayoutCoordinates _layoutCoordinates;
    private final MutableState autofillHighlightOn$delegate;
    private final MutableState deletionPreviewHighlightRange$delegate;
    private final MutableState handleState$delegate;
    private final MutableState hasFocus$delegate;
    private final Paint highlightPaint;
    private TextInputSession inputSession;
    private final MutableState isInTouchMode$delegate;
    private boolean isLayoutResultStale;
    private final MutableState justAutofilled$delegate;
    private final KeyboardActionRunner keyboardActionRunner;
    private final SoftwareKeyboardController keyboardController;
    private final MutableState<TextLayoutResultProxy> layoutResultState;
    private final MutableState minHeightForSingleLineField$delegate;
    private final Function1<ImeAction, Unit> onImeActionPerformed;
    private final Function1<ImeAction, Boolean> onImeActionPerformedWithResult;
    private final Function1<TextFieldValue, Unit> onValueChange;
    private Function1<? super TextFieldValue, Unit> onValueChangeOriginal;
    private final EditProcessor processor;
    private final RecomposeScope recomposeScope;
    private long selectionBackgroundColor;
    private final MutableState selectionPreviewHighlightRange$delegate;
    private final MutableState showCursorHandle$delegate;
    private final MutableState showFloatingToolbar$delegate;
    private final MutableState showSelectionHandleEnd$delegate;
    private final MutableState showSelectionHandleStart$delegate;
    private TextDelegate textDelegate;
    private AnnotatedString untransformedText;

    public static /* synthetic */ Unit a(LegacyTextFieldState r0, ImeAction r1) {
        return onImeActionPerformed$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit b(TextFieldValue r0) {
        return onValueChangeOriginal$lambda$1(r0);
    }

    public static /* synthetic */ Unit c(LegacyTextFieldState r0, TextFieldValue r1) {
        return onValueChange$lambda$2(r0, r1);
    }

    public static /* synthetic */ boolean d(LegacyTextFieldState r0, ImeAction r1) {
        return onImeActionPerformedWithResult$lambda$4(r0, r1);
    }

    public final boolean getAutofillHighlightOn() {
        return ((Boolean) this.autofillHighlightOn$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: getDeletionPreviewHighlightRange-d9O1mEE, reason: not valid java name */
    public final long m1388getDeletionPreviewHighlightRanged9O1mEE() {
        return ((TextRange) this.deletionPreviewHighlightRange$delegate.getValue()).unbox-impl();
    }

    public final HandleState getHandleState() {
        return (HandleState) this.handleState$delegate.getValue();
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    public final boolean getJustAutofilled() {
        return ((Boolean) this.justAutofilled$delegate.getValue()).booleanValue();
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates r0 = this._layoutCoordinates;
        if (r0 == null) goto L8;
        if (r0.isAttached() == false) goto L8;
        return r0;
    L8:
        return null;
    }

    public final TextLayoutResultProxy getLayoutResult() {
        return (TextLayoutResultProxy) this.layoutResultState.getValue();
    }

    /* JADX INFO: renamed from: getMinHeightForSingleLineField-D9Ej5fM, reason: not valid java name */
    public final float m1389getMinHeightForSingleLineFieldD9Ej5fM() {
        return ((Dp) this.minHeightForSingleLineField$delegate.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: getSelectionPreviewHighlightRange-d9O1mEE, reason: not valid java name */
    public final long m1391getSelectionPreviewHighlightRanged9O1mEE() {
        return ((TextRange) this.selectionPreviewHighlightRange$delegate.getValue()).unbox-impl();
    }

    public final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle$delegate.getValue()).booleanValue();
    }

    public final boolean getShowFloatingToolbar() {
        return ((Boolean) this.showFloatingToolbar$delegate.getValue()).booleanValue();
    }

    public final boolean getShowSelectionHandleEnd() {
        return ((Boolean) this.showSelectionHandleEnd$delegate.getValue()).booleanValue();
    }

    public final boolean getShowSelectionHandleStart() {
        return ((Boolean) this.showSelectionHandleStart$delegate.getValue()).booleanValue();
    }

    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode$delegate.getValue()).booleanValue();
    }

    public final boolean hasHighlight() {
        if (TextRange.getCollapsed-impl(m1391getSelectionPreviewHighlightRanged9O1mEE()) == true) goto L5;
    L8:
        return true;
    L5:
        if (TextRange.getCollapsed-impl(m1388getDeletionPreviewHighlightRanged9O1mEE()) == false) goto L8;
        return false;
    }

    public final Paint getHighlightPaint() {
        return this.highlightPaint;
    }

    public final TextInputSession getInputSession() {
        return this.inputSession;
    }

    public final SoftwareKeyboardController getKeyboardController() {
        return this.keyboardController;
    }

    public final Function1<ImeAction, Unit> getOnImeActionPerformed() {
        return this.onImeActionPerformed;
    }

    public final Function1<ImeAction, Boolean> getOnImeActionPerformedWithResult() {
        return this.onImeActionPerformedWithResult;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange() {
        return this.onValueChange;
    }

    public final EditProcessor getProcessor() {
        return this.processor;
    }

    public final RecomposeScope getRecomposeScope() {
        return this.recomposeScope;
    }

    /* JADX INFO: renamed from: getSelectionBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m1390getSelectionBackgroundColor0d7_KjU() {
        return this.selectionBackgroundColor;
    }

    public final TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public final AnnotatedString getUntransformedText() {
        return this.untransformedText;
    }

    public final boolean isLayoutResultStale() {
        return this.isLayoutResultStale;
    }

    private static final Unit onValueChangeOriginal$lambda$1(TextFieldValue r0) {
        return Unit.INSTANCE;
    }

    public final void setAutofillHighlightOn(boolean r2) {
        this.autofillHighlightOn$delegate.setValue(Boolean.valueOf(r2));
    }

    /* JADX INFO: renamed from: setDeletionPreviewHighlightRange-5zc-tL8, reason: not valid java name */
    public final void m1392setDeletionPreviewHighlightRange5zctL8(long r2) {
        this.deletionPreviewHighlightRange$delegate.setValue(TextRange.box-impl(r2));
    }

    public final void setHandleState(HandleState r2) {
        this.handleState$delegate.setValue(r2);
    }

    public final void setHasFocus(boolean r2) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setInTouchMode(boolean r2) {
        this.isInTouchMode$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setInputSession(TextInputSession r1) {
        this.inputSession = r1;
    }

    public final void setJustAutofilled(boolean r2) {
        this.justAutofilled$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setLayoutCoordinates(LayoutCoordinates r1) {
        this._layoutCoordinates = r1;
    }

    public final void setLayoutResult(TextLayoutResultProxy r2) {
        this.layoutResultState.setValue(r2);
        this.isLayoutResultStale = false;
    }

    /* JADX INFO: renamed from: setMinHeightForSingleLineField-0680j_4, reason: not valid java name */
    public final void m1393setMinHeightForSingleLineField0680j_4(float r2) {
        this.minHeightForSingleLineField$delegate.setValue(Dp.box-impl(r2));
    }

    /* JADX INFO: renamed from: setSelectionBackgroundColor-8_81llA, reason: not valid java name */
    public final void m1394setSelectionBackgroundColor8_81llA(long r1) {
        this.selectionBackgroundColor = r1;
    }

    /* JADX INFO: renamed from: setSelectionPreviewHighlightRange-5zc-tL8, reason: not valid java name */
    public final void m1395setSelectionPreviewHighlightRange5zctL8(long r2) {
        this.selectionPreviewHighlightRange$delegate.setValue(TextRange.box-impl(r2));
    }

    public final void setShowCursorHandle(boolean r2) {
        this.showCursorHandle$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setShowFloatingToolbar(boolean r2) {
        this.showFloatingToolbar$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setShowSelectionHandleEnd(boolean r2) {
        this.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setShowSelectionHandleStart(boolean r2) {
        this.showSelectionHandleStart$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setTextDelegate(TextDelegate r1) {
        this.textDelegate = r1;
    }

    public final void setUntransformedText(AnnotatedString r1) {
        this.untransformedText = r1;
    }

    private static final Unit onImeActionPerformed$lambda$3(LegacyTextFieldState r0, ImeAction r1) {
        r0.keyboardActionRunner.m1373runActionKlQnJC8(r1.unbox-impl());
        return Unit.INSTANCE;
    }

    private static final boolean onImeActionPerformedWithResult$lambda$4(LegacyTextFieldState r0, ImeAction r1) {
        return r0.keyboardActionRunner.m1373runActionKlQnJC8(r1.unbox-impl());
    }

    private static final Unit onValueChange$lambda$2(LegacyTextFieldState r3, TextFieldValue r4) {
        String r0 = r4.getText();
        AnnotatedString r1 = r3.untransformedText;
        if (r1 == null) goto L5;
        String r2 = r1.getText();
    L7:
        if (Intrinsics.areEqual(r0, r2) == true) goto L12;
        r3.setHandleState(HandleState.None);
        if (r3.getJustAutofilled() == false) goto L11;
        r3.setJustAutofilled(false);
        goto L12
    L11:
        r3.setAutofillHighlightOn(false);
    L12:
        TextRange.Companion r5 = TextRange.Companion;
        r3.m1395setSelectionPreviewHighlightRange5zctL8(r5.getZero-d9O1mEE());
        r3.m1392setDeletionPreviewHighlightRange5zctL8(r5.getZero-d9O1mEE());
        r3.onValueChangeOriginal.invoke(r4);
        r3.recomposeScope.invalidate();
        return Unit.INSTANCE;
    L5:
        r2 = null;
        goto L7
    }

    public LegacyTextFieldState(TextDelegate r4, RecomposeScope r5, SoftwareKeyboardController r6) {
        this.textDelegate = r4;
        this.recomposeScope = r5;
        this.keyboardController = r6;
        this.processor = new EditProcessor();
        Boolean r7 = Boolean.FALSE;
        this.hasFocus$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this.minHeightForSingleLineField$delegate = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(0)), null, 2, null);
        this.layoutResultState = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.handleState$delegate = SnapshotStateKt.mutableStateOf$default(HandleState.None, null, 2, null);
        this.showFloatingToolbar$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this.showSelectionHandleStart$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this.showSelectionHandleEnd$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this.showCursorHandle$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this.isLayoutResultStale = true;
        this.isInTouchMode$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.keyboardActionRunner = new KeyboardActionRunner(r6);
        this.autofillHighlightOn$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this.justAutofilled$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this.onValueChangeOriginal = new s2();
        this.onValueChange = new t2(this);
        this.onImeActionPerformed = new u2(this);
        this.onImeActionPerformedWithResult = new v2(this);
        this.highlightPaint = AndroidPaint_androidKt.Paint();
        this.selectionBackgroundColor = Color.Companion.getUnspecified-0d7_KjU();
        TextRange.Companion r8 = TextRange.Companion;
        this.selectionPreviewHighlightRange$delegate = SnapshotStateKt.mutableStateOf$default(TextRange.box-impl(r8.getZero-d9O1mEE()), null, 2, null);
        this.deletionPreviewHighlightRange$delegate = SnapshotStateKt.mutableStateOf$default(TextRange.box-impl(r8.getZero-d9O1mEE()), null, 2, null);
    }

    /* JADX INFO: renamed from: update-fnh65Uc, reason: not valid java name */
    public final void m1396updatefnh65Uc(AnnotatedString r14, AnnotatedString r15, TextStyle r16, boolean r17, Density r18, FontFamily.Resolver r19, Function1<? super TextFieldValue, Unit> r20, KeyboardActions r21, FocusManager r22, long r23) {
        this.onValueChangeOriginal = r20;
        this.selectionBackgroundColor = r23;
        KeyboardActionRunner r1 = this.keyboardActionRunner;
        r1.setKeyboardActions(r21);
        r1.setFocusManager(r22);
        this.untransformedText = r14;
        TextDelegate r2 = TextDelegateKt.m1448updateTextDelegaterm0N8CA$default(this.textDelegate, r15, r16, r18, r19, r17, 0, 0, 0, CollectionsKt.emptyList(), 448, null);
        if (this.textDelegate == r2) goto L5;
        this.isLayoutResultStale = true;
    L5:
        this.textDelegate = r2;
    }
}
