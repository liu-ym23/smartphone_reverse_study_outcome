package com.ss.android.lark.flow.passport.ui.widget.password;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CompoundButton;
import com.suite.lark.emm.design.edittext.SCEditText;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PasswordEditText f423910a;

    public f(PasswordEditText r100) {
        this.f423910a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        if (r101 == false) goto L4;
        this.f423910a.f423886a.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    L5:
        this.f423910a.f423886a.requestFocus();
        SCEditText r102 = this.f423910a.f423886a;
        r102.setSelection(r102.getText().length());
        return;
    L4:
        this.f423910a.f423886a.setTransformationMethod(PasswordTransformationMethod.getInstance());
        goto L5
    }
}
