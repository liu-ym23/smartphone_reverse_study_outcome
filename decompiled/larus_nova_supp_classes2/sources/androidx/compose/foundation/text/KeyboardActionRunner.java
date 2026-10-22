package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/text/KeyboardActionRunner;", "Landroidx/compose/foundation/text/KeyboardActionScope;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "<init>", "(Landroidx/compose/ui/platform/SoftwareKeyboardController;)V", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "getKeyboardActions", "()Landroidx/compose/foundation/text/KeyboardActions;", "setKeyboardActions", "(Landroidx/compose/foundation/text/KeyboardActions;)V", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "setFocusManager", "(Landroidx/compose/ui/focus/FocusManager;)V", "runAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "runAction-KlQnJC8", "(I)Z", "defaultKeyboardActionWithResult", "defaultKeyboardActionWithResult-KlQnJC8", "defaultKeyboardAction", "", "defaultKeyboardAction-KlQnJC8", "(I)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KeyboardActionRunner implements KeyboardActionScope {
    public static final int $stable = 8;
    public FocusManager focusManager;
    public KeyboardActions keyboardActions;
    private final SoftwareKeyboardController keyboardController;

    public final FocusManager getFocusManager() {
        FocusManager r0 = this.focusManager;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        return null;
    }

    public final KeyboardActions getKeyboardActions() {
        KeyboardActions r0 = this.keyboardActions;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        return null;
    }

    public KeyboardActionRunner(SoftwareKeyboardController r1) {
        this.keyboardController = r1;
    }

    /* JADX INFO: renamed from: defaultKeyboardActionWithResult-KlQnJC8, reason: not valid java name */
    private final boolean m1371defaultKeyboardActionWithResultKlQnJC8(int r4) {
        ImeAction.Companion r0 = ImeAction.Companion;
        if (ImeAction.equals-impl0(r4, r0.getNext-eUduSuo()) == false) goto L6;
        getFocusManager().moveFocus-3ESFkO8(FocusDirection.Companion.getNext-dhqQ-8s());
        return true;
    L6:
        if (ImeAction.equals-impl0(r4, r0.getPrevious-eUduSuo()) == false) goto L9;
        getFocusManager().moveFocus-3ESFkO8(FocusDirection.Companion.getPrevious-dhqQ-8s());
        return true;
    L9:
        if (ImeAction.equals-impl0(r4, r0.getDone-eUduSuo()) == false) goto L13;
        SoftwareKeyboardController r5 = this.keyboardController;
        if (r5 == null) goto L13;
        r5.hide();
        return true;
    L13:
        return false;
    }

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    /* JADX INFO: renamed from: defaultKeyboardAction-KlQnJC8, reason: not valid java name */
    public void mo1372defaultKeyboardActionKlQnJC8(int r1) {
        m1371defaultKeyboardActionWithResultKlQnJC8(r1);
    }

    /* JADX INFO: renamed from: runAction-KlQnJC8, reason: not valid java name */
    public final boolean m1373runActionKlQnJC8(int r3) {
        ImeAction.Companion r0 = ImeAction.Companion;
        if (ImeAction.equals-impl0(r3, r0.getDone-eUduSuo()) == false) goto L6;
        Function1<KeyboardActionScope, Unit> r1 = getKeyboardActions().getOnDone();
    L28:
        if (r1 == null) goto L32;
        r1.invoke(this);
        return true;
    L32:
        return m1371defaultKeyboardActionWithResultKlQnJC8(r3);
    L6:
        if (ImeAction.equals-impl0(r3, r0.getGo-eUduSuo()) == false) goto L9;
        r1 = getKeyboardActions().getOnGo();
        goto L28
    L9:
        if (ImeAction.equals-impl0(r3, r0.getNext-eUduSuo()) == false) goto L12;
        r1 = getKeyboardActions().getOnNext();
        goto L28
    L12:
        if (ImeAction.equals-impl0(r3, r0.getPrevious-eUduSuo()) == false) goto L15;
        r1 = getKeyboardActions().getOnPrevious();
        goto L28
    L15:
        if (ImeAction.equals-impl0(r3, r0.getSearch-eUduSuo()) == false) goto L18;
        r1 = getKeyboardActions().getOnSearch();
        goto L28
    L18:
        if (ImeAction.equals-impl0(r3, r0.getSend-eUduSuo()) == false) goto L21;
        r1 = getKeyboardActions().getOnSend();
        goto L28
    L21:
        if (ImeAction.equals-impl0(r3, r0.getDefault-eUduSuo()) == false) goto L23;
    L27:
        r1 = null;
        goto L28
    L23:
        if (ImeAction.equals-impl0(r3, r0.getNone-eUduSuo()) == true) goto L27;
        throw new IllegalStateException("invalid ImeAction".toString());
    }

    public final void setFocusManager(FocusManager r1) {
        this.focusManager = r1;
    }

    public final void setKeyboardActions(KeyboardActions r1) {
        this.keyboardActions = r1;
    }
}
