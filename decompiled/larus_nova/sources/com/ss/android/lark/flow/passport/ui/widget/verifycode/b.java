package com.ss.android.lark.flow.passport.ui.widget.verifycode;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerifyCodeEditText f423922a;

    public b(VerifyCodeEditText r100) {
        this.f423922a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 6) goto L7;
        VerifyCodeEditText r103 = this.f423922a;
        int r104 = VerifyCodeEditText.f423912h;
        r103.getClass();
        return false;
    L7:
        return false;
    }
}
