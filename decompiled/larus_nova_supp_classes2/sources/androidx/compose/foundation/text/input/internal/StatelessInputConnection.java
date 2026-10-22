package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.core.view.inputmethod.InputConnectionCompat;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0015\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\u001a\u0010 \u001a\u00020\u001b2\b\u0010\n\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\tH\u0016J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0016J\u001a\u0010&\u001a\u00020\u001b2\b\u0010\n\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\tH\u0016J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0016J\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0016J\u0018\u0010+\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0016J\b\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\tH\u0016J\u0018\u00103\u001a\u00020!2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\tH\u0016J\u0012\u00104\u001a\u0004\u0018\u00010!2\u0006\u00102\u001a\u00020\tH\u0016J\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\tH\u0016J$\u00107\u001a\u00020\u00122\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010>\u001a\u00020\u001b2\u0006\u00108\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u00102\u001a\u00020\tH\u0016J\u0010\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tH\u0016J\u0010\u0010H\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020\tH\u0016J\u0010\u0010J\u001a\u00020\u00122\u0006\u0010K\u001a\u00020\tH\u0002J\u0010\u0010L\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020\tH\u0016J\u0012\u0010N\u001a\u00020\u001b2\b\u0010\n\u001a\u0004\u0018\u00010OH\u0016J\u0012\u0010P\u001a\u00020\u001b2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\n\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0010\u0010U\u001a\u00020\u001b2\u0006\u0010V\u001a\u00020\tH\u0016J\u0010\u0010W\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020\u001bH\u0016J\u001c\u0010Y\u001a\u00020\u001b2\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\"\u0010^\u001a\u00020\u001b2\u0006\u0010_\u001a\u00020`2\u0006\u00102\u001a\u00020\t2\b\u0010a\u001a\u0004\u0018\u00010]H\u0016J\u0010\u0010b\u001a\u00020\u00122\u0006\u0010c\u001a\u00020[H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR%\u0010\u000e\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u00130\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019¨\u0006d"}, d2 = {"Landroidx/compose/foundation/text/input/internal/StatelessInputConnection;", "Landroid/view/inputmethod/InputConnection;", "session", "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TextInputSession;Landroid/view/inputmethod/EditorInfo;)V", "batchDepth", "", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "editCommands", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "", "Lkotlin/ExtensionFunctionType;", "terminalInputConnection", "androidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1", "Landroidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1;", "commitContentDelegateInputConnection", "getCommitContentDelegateInputConnection$annotations", "()V", "beginBatchEdit", "", "beginBatchEditInternal", "endBatchEdit", "endBatchEditInternal", "closeConnection", "commitText", "", "newCursorPosition", "setComposingRegion", "start", "end", "setComposingText", "deleteSurroundingTextInCodePoints", "beforeLength", "afterLength", "deleteSurroundingText", "setSelection", "finishComposingText", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "getTextBeforeCursor", "maxChars", "flags", "getTextAfterCursor", "getSelectedText", "requestCursorUpdates", "cursorUpdateMode", "performHandwritingGesture", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Ljava/util/function/IntConsumer;", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "getCursorCapsMode", "reqModes", "performContextMenuAction", "id", "sendSynthesizedKeyEvent", "code", "performEditorAction", "editorAction", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "getHandler", "Landroid/os/Handler;", "clearMetaKeyStates", "states", "reportFullscreenMode", "enabled", "performPrivateCommand", "action", "", "data", "Landroid/os/Bundle;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "opts", "logDebug", "message", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StatelessInputConnection implements InputConnection {
    public static final int $stable = 8;
    private int batchDepth;
    private final InputConnection commitContentDelegateInputConnection;
    private final MutableVector<Function1<ImeEditCommandScope, Unit>> editCommands;
    private final TextInputSession session;
    private final StatelessInputConnection$terminalInputConnection$1 terminalInputConnection;

    private static /* synthetic */ void getCommitContentDelegateInputConnection$annotations() {
    }

    private final void logDebug(String r1) {
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo r1) {
        return true;
    }

    private final boolean beginBatchEditInternal() {
        return this.session.beginBatchEdit();
    }

    private final boolean endBatchEditInternal() {
        return this.session.endBatchEdit();
    }

    private final TextFieldCharSequence getText() {
        return this.session.getText();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        logDebug("beginBatchEdit()");
        return beginBatchEditInternal();
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        logDebug("closeConnection()");
        this.editCommands.clear();
        this.batchDepth = 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        logDebug("endBatchEdit()");
        return endBatchEditInternal();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        logDebug("finishComposingText()");
        ImeEditCommand_androidKt.finishComposingText(this.session);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        logDebug("getHandler()");
        return null;
    }

    public static final /* synthetic */ TextInputSession access$getSession$p(StatelessInputConnection r0) {
        return r0.session;
    }

    private final void sendSynthesizedKeyEvent(int r3) {
        sendKeyEvent(new KeyEvent(0, r3));
        sendKeyEvent(new KeyEvent(1, r3));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int r3) {
        logDebug("clearMetaKeyStates(" + r3 + ')');
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo r3) {
        StringBuilder r0 = new StringBuilder("commitCompletion(");
        if (r3 == null) goto L5;
        CharSequence r4 = r3.getText();
    L6:
        r0.append(r4);
        r0.append(')');
        logDebug(r0.toString());
        return false;
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int r4) {
        logDebug("getCursorCapsMode(" + r4 + ')');
        return TextUtils.getCapsMode(getText(), TextRange.getMin-impl(getText().m1535getSelectiond9O1mEE()), r4);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int r4) {
        if (TextRange.getCollapsed-impl(getText().m1535getSelectiond9O1mEE()) == false) goto L5;
        String r0 = null;
    L6:
        logDebug("getSelectedText(" + r4 + "): " + r0);
        return r0;
    L5:
        r0 = TextFieldCharSequenceKt.getSelectedText(getText()).toString();
        goto L6
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int r3) {
        logDebug("performContextMenuAction(" + r3 + ')');
        switch(r3) {
            case 16908319: goto L8;
            case 16908320: goto L7;
            case 16908321: goto L6;
            case 16908322: goto L5;
            default: goto L9;
        };
    L5:
        sendSynthesizedKeyEvent(279);
        goto L9
    L6:
        sendSynthesizedKeyEvent(278);
        goto L9
    L7:
        sendSynthesizedKeyEvent(277);
        goto L9
    L8:
        ImeEditCommand_androidKt.setSelection(this.session, 0, getText().length());
    L9:
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int r3) {
        logDebug("performEditorAction(" + r3 + ')');
        if (r3 == 0) goto L12;
        switch(r3) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L5:
        logDebug("IME sent an unrecognized editor action: " + r3);
        int r4 = ImeAction.Companion.getDefault-eUduSuo();
    L13:
        this.session.mo1568onImeActionKlQnJC8(r4);
        return true;
    L6:
        r4 = ImeAction.Companion.getPrevious-eUduSuo();
        goto L13
    L7:
        r4 = ImeAction.Companion.getDone-eUduSuo();
        goto L13
    L8:
        r4 = ImeAction.Companion.getNext-eUduSuo();
        goto L13
    L9:
        r4 = ImeAction.Companion.getSend-eUduSuo();
        goto L13
    L10:
        r4 = ImeAction.Companion.getSearch-eUduSuo();
        goto L13
    L11:
        r4 = ImeAction.Companion.getGo-eUduSuo();
        goto L13
    L12:
        r4 = ImeAction.Companion.getDefault-eUduSuo();
        goto L13
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean r3) {
        logDebug("reportFullscreenMode(" + r3 + ')');
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int r3) {
        logDebug("requestCursorUpdates(" + r3 + ')');
        this.session.requestCursorUpdates(r3);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent r3) {
        logDebug("sendKeyEvent(" + r3 + ')');
        this.session.sendKeyEvent(r3);
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [android.view.inputmethod.InputConnection, androidx.compose.foundation.text.input.internal.StatelessInputConnection$terminalInputConnection$1] */
    public StatelessInputConnection(TextInputSession r3, EditorInfo r4) {
        this.session = r3;
        this.editCommands = new MutableVector(new Function1[16], 0);
        ?? r5 = new StatelessInputConnection$terminalInputConnection$1(this);
        this.terminalInputConnection = r5;
        this.commitContentDelegateInputConnection = InputConnectionCompat.createWrapper(r5, r4, new StatelessInputConnection$commitContentDelegateInputConnection$1(this));
    }

    public static final /* synthetic */ void access$logDebug(StatelessInputConnection r0, String r1) {
        r0.logDebug(r1);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence r3, int r4) {
        logDebug("commitText(\"" + r3 + "\", " + r4 + ')');
        if (r3 != null) goto L5;
        return true;
    L5:
        ImeEditCommand_androidKt.commitText(this.session, r3.toString(), r4);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int r3, int r4) {
        logDebug("deleteSurroundingText(" + r3 + ", " + r4 + ')');
        ImeEditCommand_androidKt.deleteSurroundingText(this.session, r3, r4);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int r3, int r4) {
        logDebug("deleteSurroundingTextInCodePoints(" + r3 + ", " + r4 + ')');
        ImeEditCommand_androidKt.deleteSurroundingTextInCodePoints(this.session, r3, r4);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest r3, int r4) {
        logDebug("getExtractedText(" + r3 + ", " + r4 + ')');
        return StatelessInputConnection_androidKt.access$toExtractedText(getText());
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int r4, int r5) {
        String r0 = TextFieldCharSequenceKt.getTextAfterSelection(getText(), r4).toString();
        logDebug("getTextAfterCursor(" + r4 + ", " + r5 + "): " + r0);
        return r0;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int r4, int r5) {
        String r0 = TextFieldCharSequenceKt.getTextBeforeSelection(getText(), r4).toString();
        logDebug("getTextBeforeCursor(" + r4 + ", " + r5 + "): " + r0);
        return r0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String r3, Bundle r4) {
        logDebug("performPrivateCommand(" + r3 + ", " + r4 + ')');
        return this.commitContentDelegateInputConnection.performPrivateCommand(r3, r4);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean previewHandwritingGesture(PreviewableHandwritingGesture r3, CancellationSignal r4) {
        logDebug("previewHandwritingGesture(" + r3 + ", " + r4 + ')');
        if (Build.VERSION.SDK_INT >= 34) goto L7;
        return false;
    L7:
        return Api34PerformHandwritingGestureImpl.INSTANCE.previewHandwritingGesture(this.session, r3, r4);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int r3, int r4) {
        logDebug("setComposingRegion(" + r3 + ", " + r4 + ')');
        ImeEditCommand_androidKt.setComposingRegion(this.session, r3, r4);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence r6, int r7) {
        logDebug("setComposingText(\"" + r6 + "\", " + r7 + ')');
        if (r6 != null) goto L5;
        return true;
    L5:
        TextInputSession r1 = this.session;
        String r2 = r6.toString();
        List<AnnotatedString.Range<AnnotatedString.Annotation>> r4 = null;
        if ((r6 instanceof Spanned) == false) goto L8;
        Spanned r8 = (Spanned) r6;
    L9:
        if (r8 == null) goto L11;
        r4 = StatelessInputConnection_androidKt.toAnnotationList(r8);
    L11:
        ImeEditCommand_androidKt.setComposingText(r1, r2, r7, r4);
        return true;
    L8:
        r8 = null;
        goto L9
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int r3, int r4) {
        logDebug("setSelection(" + r3 + ", " + r4 + ')');
        ImeEditCommand_androidKt.setSelection(this.session, r3, r4);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo r3, int r4, Bundle r5) {
        logDebug("commitContent(" + r3 + ", " + r4 + ", " + r5 + ')');
        if (Build.VERSION.SDK_INT >= 25) goto L7;
        return false;
    L7:
        return Api25CommitContentImpl.INSTANCE.commitContent(this.commitContentDelegateInputConnection, r3, r4, r5);
    }

    @Override // android.view.inputmethod.InputConnection
    public void performHandwritingGesture(HandwritingGesture r3, Executor r4, IntConsumer r5) {
        logDebug("performHandwritingGesture(" + r3 + ", " + r4 + ", " + r5 + ')');
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return;
    L5:
        Api34PerformHandwritingGestureImpl.INSTANCE.performHandwritingGesture(this.session, r3, r4, r5);
    }
}
