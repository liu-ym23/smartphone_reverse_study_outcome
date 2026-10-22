package com.bytedance.ee.bear.middleground.permission.apply;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u0 implements TextWatcher {
    public final /* synthetic */ OfficeBitableApplyPermissionFragment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public u0(OfficeBitableApplyPermissionFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        OfficeBitableApplyPermissionFragment r0 = this.a;
        int r1 = 0;
        if (r5 == null) goto L5;
        int r6 = r5.length();
    L6:
        int r2 = OfficeBitableApplyPermissionFragment.r;
        r0.getClass();
        if (r6 <= 300) goto L9;
        boolean r7 = true;
    L10:
        TextView r3 = r0.l;
        if (r3 == null) goto L18;
        if (r7 == true) goto L15;
        r1 = 8;
    L15:
        r3.setVisibility(r1);
        if (r7 == false) goto L18;
        r3.setText(2131886162);
    L18:
        TextView r4 = r0.m;
        if (r4 == null) goto L22;
        r4.setEnabled(!r7);
        return;
    L22:
        return;
    L9:
        r7 = false;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }
}
