package com.bytedance.ee.bear.bitable.superagent;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements TextWatcher {
    public boolean a;
    public final /* synthetic */ BitableSuperAgentPanel b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public l(BitableSuperAgentPanel r1) {
        this.b = r1;
        this.a = true;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r5 = true;
    L9:
        if (this.a == r5) goto L12;
        tt5.a.h(this.b.t, "onInputEmptyChanged: isEmpty=" + r5);
        this.a = r5;
        this.b.ka0();
        return;
    L12:
        return;
    L4:
        if (r4.length() == 0) goto L7;
        r5 = false;
        goto L9
    }
}
