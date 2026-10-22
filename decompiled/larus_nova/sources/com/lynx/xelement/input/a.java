package com.lynx.xelement.input;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnectionWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f384172a = 0;

    /* JADX INFO: renamed from: com.lynx.xelement.input.a$a, reason: collision with other inner class name */
    public interface InterfaceC4581a {
    }

    public a() {
        super(null, true);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getKeyCode() != 67) goto L6;
        r100.getAction();
    L6:
        return super.sendKeyEvent(r100);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence r100, int r101) {
        return super.commitText(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int r100, int r101) {
        return super.deleteSurroundingText(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean setComposingRegion(int r100, int r101) {
        return super.setComposingRegion(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence r100, int r101) {
        return super.setComposingText(r100, r101);
    }
}
