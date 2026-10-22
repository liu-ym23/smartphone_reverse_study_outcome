package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextInCodePointsCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.SetComposingRegionCommand;
import androidx.compose.ui.text.input.SetComposingTextCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010(\u001a\u00020\u00072\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0082\bJ\u0016\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u00020\u0007H\u0016J\b\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\u0007H\u0016J\b\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020+H\u0016J\u001a\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u001bH\u0016J\u0018\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001bH\u0016J\u001a\u0010>\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u001bH\u0016J\u0018\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u001bH\u0016J\u0018\u0010B\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u001bH\u0016J\u0018\u0010C\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001bH\u0016J\b\u0010D\u001a\u00020\u0007H\u0016J\u0010\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020GH\u0016J\u0018\u0010H\u001a\u0002092\u0006\u0010I\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020\u001bH\u0016J\u0018\u0010K\u001a\u0002092\u0006\u0010I\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020\u001bH\u0016J\u0012\u0010L\u001a\u0004\u0018\u0001092\u0006\u0010J\u001a\u00020\u001bH\u0016J\u0010\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u001bH\u0016J\u001a\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010J\u001a\u00020\u001bH\u0016J\u0010\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u001bH\u0016J\u0010\u0010U\u001a\u00020+2\u0006\u0010V\u001a\u00020\u001bH\u0002J\u0010\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u001bH\u0016J$\u0010Y\u001a\u00020+2\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u001a\u0010`\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u0012\u0010d\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010eH\u0016J\u0012\u0010f\u001a\u00020\u00072\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\n\u0010i\u001a\u0004\u0018\u00010jH\u0016J\u0010\u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020\u001bH\u0016J\u0010\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u0007H\u0016J\u0010\u0010o\u001a\u00020\u001b2\u0006\u0010p\u001a\u00020\u001bH\u0016J\u001c\u0010q\u001a\u00020\u00072\b\u0010r\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\"\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020x2\u0006\u0010J\u001a\u00020\u001b2\b\u0010y\u001a\u0004\u0018\u00010uH\u0016J\u0010\u0010z\u001a\u00020+2\u0006\u0010{\u001a\u00020sH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006|"}, d2 = {"Landroidx/compose/foundation/text/input/internal/RecordingInputConnection;", "Landroid/view/inputmethod/InputConnection;", "initState", "Landroidx/compose/ui/text/input/TextFieldValue;", "eventCallback", "Landroidx/compose/foundation/text/input/internal/InputEventCallback2;", "autoCorrect", "", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "<init>", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/input/internal/InputEventCallback2;ZLandroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/platform/ViewConfiguration;)V", "getEventCallback", "()Landroidx/compose/foundation/text/input/internal/InputEventCallback2;", "getAutoCorrect", "()Z", "getLegacyTextFieldState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "getTextFieldSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "batchDepth", "", "value", "textFieldValue", "getTextFieldValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setTextFieldValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "currentExtractedTextRequestToken", "extractedTextMonitorMode", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "isActive", "ensureActive", "block", "Lkotlin/Function0;", "", "updateInputState", "state", "inputMethodManager", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "addEditCommandWithBatch", "editCommand", "beginBatchEdit", "beginBatchEditInternal", "endBatchEdit", "endBatchEditInternal", "closeConnection", "commitText", "text", "", "newCursorPosition", "setComposingRegion", "start", "end", "setComposingText", "deleteSurroundingTextInCodePoints", "beforeLength", "afterLength", "deleteSurroundingText", "setSelection", "finishComposingText", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "getTextBeforeCursor", "maxChars", "flags", "getTextAfterCursor", "getSelectedText", "requestCursorUpdates", "cursorUpdateMode", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "performContextMenuAction", "id", "sendSynthesizedKeyEvent", "code", "performEditorAction", "editorAction", "performHandwritingGesture", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Ljava/util/function/IntConsumer;", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "getHandler", "Landroid/os/Handler;", "clearMetaKeyStates", "states", "reportFullscreenMode", "enabled", "getCursorCapsMode", "reqModes", "performPrivateCommand", "action", "", "data", "Landroid/os/Bundle;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "opts", "logDebug", "message", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecordingInputConnection implements InputConnection {
    public static final int $stable = 8;
    private final boolean autoCorrect;
    private int batchDepth;
    private int currentExtractedTextRequestToken;
    private final List<EditCommand> editCommands;
    private final InputEventCallback2 eventCallback;
    private boolean extractedTextMonitorMode;
    private boolean isActive;
    private final LegacyTextFieldState legacyTextFieldState;
    private final TextFieldSelectionManager textFieldSelectionManager;
    private TextFieldValue textFieldValue;
    private final ViewConfiguration viewConfiguration;

    public static /* synthetic */ Unit a(RecordingInputConnection r0, EditCommand r1) {
        return performHandwritingGesture$lambda$14(r0, r1);
    }

    private final void logDebug(String r1) {
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean r1) {
        return false;
    }

    private final boolean beginBatchEditInternal() {
        this.batchDepth++;
        return true;
    }

    private final boolean endBatchEditInternal() {
        int r0 = this.batchDepth - 1;
        this.batchDepth = r0;
        if (r0 != 0) goto L8;
        if ((!this.editCommands.isEmpty()) == false) goto L8;
        this.eventCallback.onEditCommands(CollectionsKt.toMutableList(this.editCommands));
        this.editCommands.clear();
    L8:
        if (this.batchDepth > 0) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        boolean r0 = this.isActive;
        if (r0 == true) goto L5;
        return r0;
    L5:
        return beginBatchEditInternal();
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.editCommands.clear();
        this.batchDepth = 0;
        this.isActive = false;
        this.eventCallback.onConnectionClosed(this);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        boolean r0 = this.isActive;
        if (r0 == false) goto L6;
        addEditCommandWithBatch(new FinishComposingTextCommand());
        return true;
    L6:
        return r0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return endBatchEditInternal();
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    public final InputEventCallback2 getEventCallback() {
        return this.eventCallback;
    }

    public final LegacyTextFieldState getLegacyTextFieldState() {
        return this.legacyTextFieldState;
    }

    public final TextFieldSelectionManager getTextFieldSelectionManager() {
        return this.textFieldSelectionManager;
    }

    public final TextFieldValue getTextFieldValue$foundation_release() {
        return this.textFieldValue;
    }

    public final ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    private final void addEditCommandWithBatch(EditCommand r2) {
        beginBatchEditInternal();
        this.editCommands.add(r2);     // Catch: Throwable -> L6
        endBatchEditInternal();
        return;
    L6:
        th = move-exception;
        endBatchEditInternal();
        throw th;
    }

    private final boolean ensureActive(Function0<Unit> r2) {
        boolean r0 = this.isActive;
        if (r0 == false) goto L5;
        r2.invoke();
    L5:
        return r0;
    }

    private final void sendSynthesizedKeyEvent(int r3) {
        sendKeyEvent(new KeyEvent(0, r3));
        sendKeyEvent(new KeyEvent(1, r3));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int r1) {
        boolean r2 = this.isActive;
        if (r2 == false) goto L6;
        return false;
    L6:
        return r2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo r1) {
        boolean r2 = this.isActive;
        if (r2 == false) goto L6;
        return false;
    L6:
        return r2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo r1) {
        boolean r2 = this.isActive;
        if (r2 == true) goto L5;
        return r2;
    L5:
        return this.autoCorrect;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int r4) {
        return TextUtils.getCapsMode(this.textFieldValue.getText(), TextRange.getMin-impl(this.textFieldValue.getSelection-d9O1mEE()), r4);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int r3) {
        if (TextRange.getCollapsed-impl(this.textFieldValue.getSelection-d9O1mEE()) == false) goto L6;
        return null;
    L6:
        return TextFieldValueKt.getSelectedText(this.textFieldValue).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int r3) {
        boolean r0 = this.isActive;
        if (r0 == false) goto L11;
        r0 = false;
        switch(r3) {
            case 16908319: goto L10;
            case 16908320: goto L9;
            case 16908321: goto L8;
            case 16908322: goto L7;
            default: goto L11;
        };
    L7:
        sendSynthesizedKeyEvent(279);
        goto L11
    L8:
        sendSynthesizedKeyEvent(278);
        goto L11
    L9:
        sendSynthesizedKeyEvent(277);
        goto L11
    L10:
        addEditCommandWithBatch(new SetSelectionCommand(0, this.textFieldValue.getText().length()));
    L11:
        return r0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int r2) {
        boolean r0 = this.isActive;
        if (r0 == false) goto L16;
        if (r2 == 0) goto L13;
        switch(r2) {
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L6:
        int r3 = ImeAction.Companion.getDefault-eUduSuo();
    L14:
        this.eventCallback.mo1606onImeActionKlQnJC8(r3);
        return true;
    L7:
        r3 = ImeAction.Companion.getPrevious-eUduSuo();
        goto L14
    L8:
        r3 = ImeAction.Companion.getDone-eUduSuo();
        goto L14
    L9:
        r3 = ImeAction.Companion.getNext-eUduSuo();
        goto L14
    L10:
        r3 = ImeAction.Companion.getSend-eUduSuo();
        goto L14
    L11:
        r3 = ImeAction.Companion.getSearch-eUduSuo();
        goto L14
    L12:
        r3 = ImeAction.Companion.getGo-eUduSuo();
        goto L14
    L13:
        r3 = ImeAction.Companion.getDefault-eUduSuo();
        goto L14
    L16:
        return r0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int r11) {
        boolean r0 = this.isActive;
        if (r0 == false) goto L42;
        boolean r1 = false;
        if ((r11 & 1) == 0) goto L7;
        boolean r4 = true;
    L9:
        if ((r11 & 2) == 0) goto L11;
        boolean r5 = true;
    L12:
        int r2 = Build.VERSION.SDK_INT;
        if (r2 >= 33) goto L15;
        boolean r6 = true;
        boolean r7 = true;
        boolean r8 = false;
        boolean r9 = false;
    L40:
        this.eventCallback.onRequestCursorAnchorInfo(r4, r5, r6, r7, r8, r9);
        return true;
    L15:
        if ((r11 & 16) == 0) goto L17;
        boolean r3 = true;
    L19:
        if ((r11 & 8) == 0) goto L21;
        boolean r10 = true;
    L23:
        if ((r11 & 4) == 0) goto L25;
        boolean r12 = true;
    L27:
        if (r2 >= 34) goto L29;
    L31:
        if (r3 == true) goto L38;
        if (r10 == true) goto L38;
        if (r12 == true) goto L38;
        if (r1 == true) goto L38;
        if (r2 < 34) goto L37;
        r6 = true;
        r7 = true;
        r8 = true;
        r9 = true;
        goto L40
    L37:
        r9 = r1;
        r6 = true;
        r7 = true;
        r8 = true;
    L38:
        r9 = r1;
        r8 = r12;
        r7 = r10;
        r6 = r3;
        goto L40
    L29:
        if ((r11 & 32) == 0) goto L31;
        r1 = true;
        goto L31
    L25:
        r12 = false;
        goto L27
    L21:
        r10 = false;
        goto L23
    L17:
        r3 = false;
        goto L19
    L11:
        r5 = false;
        goto L12
    L7:
        r4 = false;
        goto L9
    L42:
        return r0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent r2) {
        boolean r0 = this.isActive;
        if (r0 == false) goto L6;
        this.eventCallback.onKeyEvent(r2);
        return true;
    L6:
        return r0;
    }

    public final void setTextFieldValue$foundation_release(TextFieldValue r1) {
        this.textFieldValue = r1;
    }

    private static final Unit performHandwritingGesture$lambda$14(RecordingInputConnection r0, EditCommand r1) {
        r0.addEditCommandWithBatch(r1);
        return Unit.INSTANCE;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence r3, int r4) {
        boolean r0 = this.isActive;
        if (r0 == false) goto L5;
        addEditCommandWithBatch(new CommitTextCommand(String.valueOf(r3), r4));
    L5:
        return r0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int r2, int r3) {
        boolean r0 = this.isActive;
        if (r0 == false) goto L6;
        addEditCommandWithBatch(new DeleteSurroundingTextCommand(r2, r3));
        return true;
    L6:
        return r0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int r2, int r3) {
        boolean r0 = this.isActive;
        if (r0 == false) goto L6;
        addEditCommandWithBatch(new DeleteSurroundingTextInCodePointsCommand(r2, r3));
        return true;
    L6:
        return r0;
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest r3, int r4) {
        boolean r0 = true;
        int r1 = 0;
        if ((r4 & 1) != 0) goto L6;
        r0 = false;
    L6:
        this.extractedTextMonitorMode = r0;
        if (r0 == false) goto L12;
        if (r3 == null) goto L10;
        r1 = r3.token;
    L10:
        this.currentExtractedTextRequestToken = r1;
    L12:
        return RecordingInputConnection_androidKt.access$toExtractedText(this.textFieldValue);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int r1, int r2) {
        return TextFieldValueKt.getTextAfterSelection(this.textFieldValue, r1).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int r1, int r2) {
        return TextFieldValueKt.getTextBeforeSelection(this.textFieldValue, r1).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String r1, Bundle r2) {
        boolean r3 = this.isActive;
        if (r3 == false) goto L6;
        return true;
    L6:
        return r3;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean previewHandwritingGesture(PreviewableHandwritingGesture r4, CancellationSignal r5) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return false;
    L5:
        return Api34LegacyPerformHandwritingGestureImpl.INSTANCE.previewHandwritingGesture(this.legacyTextFieldState, this.textFieldSelectionManager, r4, r5);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int r3, int r4) {
        boolean r0 = this.isActive;
        if (r0 == false) goto L5;
        addEditCommandWithBatch(new SetComposingRegionCommand(r3, r4));
    L5:
        return r0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence r3, int r4) {
        boolean r0 = this.isActive;
        if (r0 == false) goto L5;
        addEditCommandWithBatch(new SetComposingTextCommand(String.valueOf(r3), r4));
    L5:
        return r0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int r2, int r3) {
        boolean r0 = this.isActive;
        if (r0 == false) goto L6;
        addEditCommandWithBatch(new SetSelectionCommand(r2, r3));
        return true;
    L6:
        return r0;
    }

    public final void updateInputState(TextFieldValue r6, InputMethodManager r7) {
        if (this.isActive == true) goto L5;
        return;
    L5:
        setTextFieldValue$foundation_release(r6);
        if (this.extractedTextMonitorMode == false) goto L8;
        r7.updateExtractedText(this.currentExtractedTextRequestToken, RecordingInputConnection_androidKt.access$toExtractedText(r6));
    L8:
        TextRange r0 = r6.getComposition-MzsxiRA();
        int r1 = -1;
        if (r0 == null) goto L11;
        int r2 = TextRange.getMin-impl(r0.unbox-impl());
    L12:
        TextRange r3 = r6.getComposition-MzsxiRA();
        if (r3 == null) goto L15;
        r1 = TextRange.getMax-impl(r3.unbox-impl());
    L15:
        r7.updateSelection(TextRange.getMin-impl(r6.getSelection-d9O1mEE()), TextRange.getMax-impl(r6.getSelection-d9O1mEE()), r2, r1);
        return;
    L11:
        r2 = -1;
        goto L12
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo r1, int r2, Bundle r3) {
        boolean r4 = this.isActive;
        if (r4 == false) goto L6;
        return false;
    L6:
        return r4;
    }

    @Override // android.view.inputmethod.InputConnection
    public void performHandwritingGesture(HandwritingGesture r11, Executor r12, IntConsumer r13) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34LegacyPerformHandwritingGestureImpl.INSTANCE.performHandwritingGesture(this.legacyTextFieldState, this.textFieldSelectionManager, r11, this.viewConfiguration, r12, r13, new m0(this));
        return;
    }

    public RecordingInputConnection(TextFieldValue r1, InputEventCallback2 r2, boolean r3, LegacyTextFieldState r4, TextFieldSelectionManager r5, ViewConfiguration r6) {
        this.eventCallback = r2;
        this.autoCorrect = r3;
        this.legacyTextFieldState = r4;
        this.textFieldSelectionManager = r5;
        this.viewConfiguration = r6;
        this.textFieldValue = r1;
        this.editCommands = new ArrayList();
        this.isActive = true;
    }

    public /* synthetic */ RecordingInputConnection(TextFieldValue r10, InputEventCallback2 r11, boolean r12, LegacyTextFieldState r13, TextFieldSelectionManager r14, ViewConfiguration r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 8) == 0) goto L5;
        LegacyTextFieldState r6 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        TextFieldSelectionManager r7 = null;
    L11:
        if ((r16 & 32) == 0) goto L13;
        ViewConfiguration r8 = null;
    L14:
        this(r10, r11, r12, r6, r7, r8);
        return;
    L13:
        r8 = r15;
        goto L14
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }
}
