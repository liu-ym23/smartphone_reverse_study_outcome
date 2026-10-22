package com.ss.android.lark.flow.passport.ui.widget.password;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PasswordEditText f423909a;

    public e(PasswordEditText r100) {
        this.f423909a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f423909a.f423886a.setText("");
        this.f423909a.f423886a.requestFocus();
        this.f423909a.f423888c.setVisibility(8);
    }
}
