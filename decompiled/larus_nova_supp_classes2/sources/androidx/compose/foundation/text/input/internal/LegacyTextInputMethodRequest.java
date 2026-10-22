package androidx.compose.foundation.text.input.internal;

import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJN\u00102\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010\u001e\u001a\u00020\u001f2\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u0005J\u0010\u00105\u001a\u00020#2\u0006\u00106\u001a\u000207H\u0016J\u0018\u00108\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u00010\u001a2\u0006\u0010:\u001a\u00020\u001aJ\u000e\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020=J.\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020=2\u0006\u0010E\u001a\u00020=J\b\u0010F\u001a\u00020\u0007H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "view", "Landroid/view/View;", "localToScreen", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "", "inputMethodManager", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/InputMethodManager;)V", "getView", "()Landroid/view/View;", "onEditCommand", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState", "()Landroidx/compose/ui/text/input/TextFieldValue;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "ics", "", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/foundation/text/input/internal/RecordingInputConnection;", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "focusedRect", "Landroid/graphics/Rect;", "getFocusedRect$foundation_release", "()Landroid/graphics/Rect;", "setFocusedRect$foundation_release", "(Landroid/graphics/Rect;)V", "cursorAnchorInfoController", "Landroidx/compose/foundation/text/input/internal/LegacyCursorAnchorInfoController;", "startInput", "textInputNode", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter$LegacyPlatformTextInputNode;", "createInputConnection", "outAttributes", "Landroid/view/inputmethod/EditorInfo;", "updateState", "oldValue", "newValue", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "decorationBoxBounds", "restartInputImmediately", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LegacyTextInputMethodRequest implements PlatformTextInputMethodRequest {
    public static final int $stable = 8;
    private final Lazy baseInputConnection$delegate;
    private final LegacyCursorAnchorInfoController cursorAnchorInfoController;
    private Rect focusedRect;
    private List<WeakReference<RecordingInputConnection>> ics;
    private ImeOptions imeOptions;
    private final InputMethodManager inputMethodManager;
    private LegacyTextFieldState legacyTextFieldState;
    private Function1<? super List<? extends EditCommand>, Unit> onEditCommand;
    private Function1<? super ImeAction, Unit> onImeActionPerformed;
    private TextFieldValue state;
    private TextFieldSelectionManager textFieldSelectionManager;
    private final View view;
    private ViewConfiguration viewConfiguration;

    public static /* synthetic */ Unit a(ImeAction r0) {
        return onImeActionPerformed$lambda$1(r0);
    }

    public static /* synthetic */ Unit b(List r0) {
        return onEditCommand$lambda$0(r0);
    }

    public static /* synthetic */ BaseInputConnection c(LegacyTextInputMethodRequest r0) {
        return baseInputConnection_delegate$lambda$2(r0);
    }

    private final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection$delegate.getValue();
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }

    public final Rect getFocusedRect$foundation_release() {
        return this.focusedRect;
    }

    public final TextFieldValue getState() {
        return this.state;
    }

    public final View getView() {
        return this.view;
    }

    public static final /* synthetic */ BaseInputConnection access$getBaseInputConnection(LegacyTextInputMethodRequest r0) {
        return r0.getBaseInputConnection();
    }

    public static final /* synthetic */ LegacyCursorAnchorInfoController access$getCursorAnchorInfoController$p(LegacyTextInputMethodRequest r0) {
        return r0.cursorAnchorInfoController;
    }

    public static final /* synthetic */ List access$getIcs$p(LegacyTextInputMethodRequest r0) {
        return r0.ics;
    }

    public static final /* synthetic */ Function1 access$getOnEditCommand$p(LegacyTextInputMethodRequest r0) {
        return r0.onEditCommand;
    }

    public static final /* synthetic */ Function1 access$getOnImeActionPerformed$p(LegacyTextInputMethodRequest r0) {
        return r0.onImeActionPerformed;
    }

    private static final BaseInputConnection baseInputConnection_delegate$lambda$2(LegacyTextInputMethodRequest r2) {
        return new BaseInputConnection(r2.view, false);
    }

    private static final Unit onEditCommand$lambda$0(List r0) {
        return Unit.INSTANCE;
    }

    private static final Unit onImeActionPerformed$lambda$1(ImeAction r0) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: createInputConnection, reason: collision with other method in class */
    public RecordingInputConnection m1608createInputConnection(EditorInfo r18) {
        EditorInfo_androidKt.m1580updatepLxbY9I$default(r18, this.state.getText(), this.state.getSelection-d9O1mEE(), this.imeOptions, null, 8, null);
        LegacyPlatformTextInputServiceAdapter_androidKt.access$updateWithEmojiCompat(r18);
        TextFieldValue r11 = this.state;
        boolean r13 = this.imeOptions.getAutoCorrect();
        RecordingInputConnection r2 = new RecordingInputConnection(r11, new AnonymousClass1(this), r13, this.legacyTextFieldState, this.textFieldSelectionManager, this.viewConfiguration);
        this.ics.add(new WeakReference(r2));
        return r2;
    }

    public final void notifyFocusedRect(androidx.compose.ui.geometry.Rect r5) {
        this.focusedRect = new Rect(MathKt.roundToInt(r5.getLeft()), MathKt.roundToInt(r5.getTop()), MathKt.roundToInt(r5.getRight()), MathKt.roundToInt(r5.getBottom()));
        if (this.ics.isEmpty() == false) goto L8;
        Rect r6 = this.focusedRect;
        if (r6 == null) goto L9;
        this.view.requestRectangleOnScreen(new Rect(r6));
        return;
    L9:
        return;
    }

    public final void setFocusedRect$foundation_release(Rect r1) {
        this.focusedRect = r1;
    }

    public /* bridge */ /* synthetic */ InputConnection createInputConnection(EditorInfo r1) {
        return m1608createInputConnection(r1);
    }

    public final void updateState(TextFieldValue r8, TextFieldValue r9) {
        boolean r1 = true;
        int r2 = 0;
        if (TextRange.equals-impl0(this.state.getSelection-d9O1mEE(), r9.getSelection-d9O1mEE()) == true) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.state = r9;
        int r3 = this.ics.size();
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L15;
        RecordingInputConnection r5 = (RecordingInputConnection) ((WeakReference) ListProtector.get(this.ics, r4)).get();
        if (r5 == null) goto L14;
        r5.setTextFieldValue$foundation_release(r9);
    L14:
        r4 = r4 + 1;
        goto L10
    L15:
        this.cursorAnchorInfoController.invalidate();
        if (Intrinsics.areEqual(r8, r9) == false) goto L27;
        if (r0 == false) goto L51;
        InputMethodManager r10 = this.inputMethodManager;
        int r6 = TextRange.getMin-impl(r9.getSelection-d9O1mEE());
        int r11 = TextRange.getMax-impl(r9.getSelection-d9O1mEE());
        TextRange r7 = this.state.getComposition-MzsxiRA();
        int r12 = -1;
        if (r7 == null) goto L21;
        int r13 = TextRange.getMin-impl(r7.unbox-impl());
    L22:
        TextRange r14 = this.state.getComposition-MzsxiRA();
        if (r14 == null) goto L25;
        r12 = TextRange.getMax-impl(r14.unbox-impl());
    L25:
        r10.updateSelection(r6, r11, r13, r12);
        return;
    L21:
        r13 = -1;
        goto L22
    L51:
        return;
    L27:
        if (r8 != null) goto L29;
    L35:
        r1 = false;
    L36:
        if (r1 == false) goto L38;
        restartInputImmediately();
        return;
    L38:
        int r15 = this.ics.size();
    L39:
        if (r2 >= r15) goto L52;
        RecordingInputConnection r16 = (RecordingInputConnection) ((WeakReference) ListProtector.get(this.ics, r2)).get();
        if (r16 == null) goto L43;
        r16.updateInputState(this.state, this.inputMethodManager);
    L43:
        r2 = r2 + 1;
        goto L39
    L52:
        return;
    L29:
        if (Intrinsics.areEqual(r8.getText(), r9.getText()) == false) goto L36;
        if (TextRange.equals-impl0(r8.getSelection-d9O1mEE(), r9.getSelection-d9O1mEE()) == false) goto L35;
        if (Intrinsics.areEqual(r8.getComposition-MzsxiRA(), r9.getComposition-MzsxiRA()) == true) goto L35;
    L5:
        if (Intrinsics.areEqual(this.state.getComposition-MzsxiRA(), r9.getComposition-MzsxiRA()) == false) goto L8;
        r0 = false;
        goto L9
    }

    public LegacyTextInputMethodRequest(View r8, Function1<? super Matrix, Unit> r9, InputMethodManager r10) {
        this.view = r8;
        this.inputMethodManager = r10;
        this.onEditCommand = new j0();
        this.onImeActionPerformed = new k0();
        this.state = new TextFieldValue("", TextRange.Companion.getZero-d9O1mEE(), null, 4, null);
        this.imeOptions = ImeOptions.Companion.getDefault();
        this.ics = new ArrayList();
        this.baseInputConnection$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new l0(this));
        this.cursorAnchorInfoController = new LegacyCursorAnchorInfoController(r9, r10);
    }

    public final void startInput(TextFieldValue r1, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode r2, ImeOptions r3, Function1<? super List<? extends EditCommand>, Unit> r4, Function1<? super ImeAction, Unit> r5) {
        this.state = r1;
        this.imeOptions = r3;
        this.onEditCommand = r4;
        this.onImeActionPerformed = r5;
        ViewConfiguration r6 = null;
        if (r2 == null) goto L5;
        LegacyTextFieldState r7 = r2.getLegacyTextFieldState();
    L6:
        this.legacyTextFieldState = r7;
        if (r2 == null) goto L9;
        TextFieldSelectionManager r8 = r2.getTextFieldSelectionManager();
    L10:
        this.textFieldSelectionManager = r8;
        if (r2 == null) goto L13;
        r6 = r2.getViewConfiguration();
    L13:
        this.viewConfiguration = r6;
        return;
    L9:
        r8 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }

    public final void updateTextLayoutResult(TextFieldValue r7, OffsetMapping r8, TextLayoutResult r9, androidx.compose.ui.geometry.Rect r10, androidx.compose.ui.geometry.Rect r11) {
        this.cursorAnchorInfoController.updateTextLayoutResult(r7, r8, r9, r10, r11);
    }
}
