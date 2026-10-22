package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class m extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Editable f429276a;

    public m(TextView r100, InputConnection r101) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        Intrinsics.checkNotNullParameter(r101, "inputConnection");
        super(r101, false);
        this.f429276a = r100.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int r100, int r101) {
        h r102 = h.f429267a;
        if (h.a(this, this.f429276a, r100, r101, false) == false) goto L5;
    L6:
        return true;
    L5:
        if (super.deleteSurroundingText(r100, r101) == true) goto L6;
        return false;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int r100, int r101) {
        h r102 = h.f429267a;
        if (h.a(this, this.f429276a, r100, r101, true) == false) goto L5;
        return true;
    L5:
        if (super.deleteSurroundingTextInCodePoints(r100, r101) == true) goto L10;
        return false;
    L10:
        return true;
    }
}
