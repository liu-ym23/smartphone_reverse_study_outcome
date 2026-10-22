package com.ss.android.lark.flow.passport.ui.widget.password;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PasswordEditText f423908a;

    public d(PasswordEditText r100) {
        this.f423908a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 6) goto L9;
        PasswordEditText.c r103 = this.f423908a.f423893h;
        if (r103 == null) goto L10;
        r103.a(r100.getText().toString());
        return false;
    L10:
        return false;
    L9:
        return false;
    }
}
