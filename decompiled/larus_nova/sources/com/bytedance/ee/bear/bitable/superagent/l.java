package com.bytedance.ee.bear.bitable.superagent;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes16.dex */
public final class l implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f215909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableSuperAgentPanel f215910b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public l(BitableSuperAgentPanel r100) {
        this.f215910b = r100;
        this.f215909a = true;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (this.f215909a == r101) goto L12;
        tt5.a.h(this.f215910b.f215757t, "onInputEmptyChanged: isEmpty=" + r101);
        this.f215909a = r101;
        this.f215910b.ka0();
        return;
    L12:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L9
    }
}
