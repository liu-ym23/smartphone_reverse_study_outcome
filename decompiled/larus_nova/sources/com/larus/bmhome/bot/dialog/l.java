package com.larus.bmhome.bot.dialog;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes25.dex */
public final class l implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BotNickNameEditDialog f296582a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public l(BotNickNameEditDialog r100) {
        this.f296582a = r100;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        BotNickNameEditDialog r104 = this.f296582a;
        int r105 = BotNickNameEditDialog.f296558n;
        r104.T90(r100);
    }
}
