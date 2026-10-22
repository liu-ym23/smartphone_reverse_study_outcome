package com.ss.android.lark.flow.passport.ui.widget.verifycode;

import android.view.View;
import com.ss.android.lark.flow.passport.ui.widget.common.CodeView;
import uzb.f;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerifyCodeEditText f423924a;

    public d(VerifyCodeEditText r100) {
        this.f423924a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        VerifyCodeEditText r102 = this.f423924a;
        int r103 = VerifyCodeEditText.f423912h;
        r102.getClass();
        VerifyCodeEditText r104 = this.f423924a;
        if (r101 == false) goto L5;
        r104.a(r104.f423913a.getText());
    L11:
        if (r101 == true) goto L15;
        f.b(this.f423924a.getContext());
        return;
    L15:
        return;
    L5:
        CodeView[] r105 = r104.f423916d;
        if (r105 == null) goto L11;
        int r106 = r105.length;
        int r107 = 0;
    L9:
        if (r107 >= r106) goto L11;
        r105[r107].b();
        r107 = r107 + 1;
        goto L9
    }
}
