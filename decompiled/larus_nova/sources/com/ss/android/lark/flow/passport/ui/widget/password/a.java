package com.ss.android.lark.flow.passport.ui.widget.password;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.ss.android.lark.flow.passport.ui.widget.common.h;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.emm.design.edittext.SCEditText;
import uzb.l;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PasswordEditText f423905a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public a(PasswordEditText r100) {
        this.f423905a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        PasswordEditText r101 = this.f423905a;
        PasswordEditText.f r102 = r101.f423889d;
        if (r102 == null) goto L9;
        SCEditText r103 = r101.f423886a;
        if (r103 == null) goto L8;
        r103.setTextColor(r102.f423901e);
    L8:
        h r104 = r101.f423895j;
        int r105 = r101.f423889d.f423898b;
        r104.getClass();
        r104.b(l.a(LarkContext.getApplication(), 1.0f), r105);
    L9:
        ImageView r106 = this.f423905a.f423888c;
        if (TextUtils.isEmpty(r100) == false) goto L12;
        int r107 = 8;
    L13:
        r106.setVisibility(r107);
        PasswordEditText.g r108 = this.f423905a.f423892g;
        if (r108 == null) goto L20;
        if (r100 == null) goto L17;
        String r109 = r100.toString();
    L18:
        r108.h(r109);
        return;
    L17:
        r109 = "";
        goto L18
    L20:
        return;
    L12:
        r107 = 0;
        goto L13
    }
}
