package androidx.compose.foundation.text.input.internal;

import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J]\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/input/internal/AndroidTextFieldKeyEventHandler;", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "<init>", "()V", "onPreKeyEvent", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "onKeyEvent", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "onKeyEvent-8zsqlwg", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/platform/SoftwareKeyboardController;ZZLkotlin/jvm/functions/Function0;)Z", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidTextFieldKeyEventHandler extends TextFieldKeyEventHandler {
    public static final int $stable = 8;

    public AndroidTextFieldKeyEventHandler() {
    }

    @Override // androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler
    /* JADX INFO: renamed from: onPreKeyEvent-MyFupTE, reason: not valid java name */
    public boolean mo1565onPreKeyEventMyFupTE(KeyEvent r3, TransformedTextFieldState r4, TextFieldSelectionState r5, FocusManager r6, SoftwareKeyboardController r7) {
        boolean r8 = super.mo1565onPreKeyEventMyFupTE(r3, r4, r5, r6, r7);
        if (ComposeFoundationFlags.isTextFieldDpadNavigationEnabled == false) goto L6;
        return r8;
    L6:
        if (r8 == false) goto L8;
        return true;
    L8:
        InputDevice r9 = r3.getDevice();
        if (r9 != null) goto L12;
    L10:
        return false;
    L12:
        if (r9.supportsSource(513) == false) goto L10;
        if (r9.isVirtual() == true) goto L10;
        if (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(r3), KeyEventType.Companion.getKeyDown-CS__XNY()) == false) goto L10;
        if (r3.getSource() == 257) goto L10;
        if (TextFieldKeyEventHandler_androidKt.m1647access$isKeyCodeYhN2O0w(r3, 19) == false) goto L27;
        return r6.moveFocus-3ESFkO8(FocusDirection.Companion.getUp-dhqQ-8s());
    L27:
        if (TextFieldKeyEventHandler_androidKt.m1647access$isKeyCodeYhN2O0w(r3, 20) == false) goto L30;
        return r6.moveFocus-3ESFkO8(FocusDirection.Companion.getDown-dhqQ-8s());
    L30:
        if (TextFieldKeyEventHandler_androidKt.m1647access$isKeyCodeYhN2O0w(r3, 21) == false) goto L33;
        return r6.moveFocus-3ESFkO8(FocusDirection.Companion.getLeft-dhqQ-8s());
    L33:
        if (TextFieldKeyEventHandler_androidKt.m1647access$isKeyCodeYhN2O0w(r3, 22) == false) goto L36;
        return r6.moveFocus-3ESFkO8(FocusDirection.Companion.getRight-dhqQ-8s());
    L36:
        if (TextFieldKeyEventHandler_androidKt.m1647access$isKeyCodeYhN2O0w(r3, 23) == false) goto L10;
        r7.show();
        return true;
    }

    @Override // androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler
    /* JADX INFO: renamed from: onKeyEvent-8zsqlwg, reason: not valid java name */
    public boolean mo1564onKeyEvent8zsqlwg(KeyEvent r3, TransformedTextFieldState r4, TextLayoutState r5, TextFieldSelectionState r6, Function1<? super KeyCommand, ? extends Unit> r7, SoftwareKeyboardController r8, boolean r9, boolean r10, Function0<Boolean> r11) {
        if (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(r3), KeyEventType.Companion.getKeyDown-CS__XNY()) == false) goto L10;
        if (r3.isFromSource(257) == false) goto L10;
        if (TextFieldKeyEventHandler_androidKt.m1648isFromSoftKeyboardZmokQxo(r3) == true) goto L10;
        r6.setInTouchMode(false);
    L10:
        return super.mo1564onKeyEvent8zsqlwg(r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }
}
