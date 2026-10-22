package com.larus.avlink.env.event;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes25.dex */
public final class u implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraEnvObservePersonalMemoryEditDialog f292303a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public u(DoraEnvObservePersonalMemoryEditDialog r100) {
        this.f292303a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        DoraEnvObservePersonalMemoryEditDialog r101 = this.f292303a;
        if (r100 == null) goto L5;
        int r102 = r100.length();
    L6:
        int r103 = DoraEnvObservePersonalMemoryEditDialog.f292212k;
        r101.U90(r102);
        this.f292303a.V90(r100);
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
