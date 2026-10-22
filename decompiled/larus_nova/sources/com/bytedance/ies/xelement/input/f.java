package com.bytedance.ies.xelement.input;

import android.text.Spannable;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f250089a;

    public interface a {
        boolean a();
    }

    public f() {
        super(null, true);
    }

    public static boolean a(Spannable r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        int r101 = BaseInputConnection.getComposingSpanStart(r100);
        int r102 = BaseInputConnection.getComposingSpanEnd(r100);
        if (r101 == (-1)) goto L6;
        if (r102 == (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getKeyCode() != 67) goto L13;
        if (r100.getAction() != 0) goto L13;
        a r101 = this.f250089a;
        if (r101 == null) goto L13;
        Intrinsics.checkNotNull(r101);
        if (r101.a() == false) goto L13;
        return true;
    L13:
        return super.sendKeyEvent(r100);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence r100, int r101) {
        return super.commitText(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int r100, int r101) {
        if (r100 != 1) goto L11;
        if (r101 != 0) goto L11;
        a r102 = this.f250089a;
        if (r102 == null) goto L11;
        Intrinsics.checkNotNull(r102);
        if (r102.a() == false) goto L11;
        return true;
    L11:
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
