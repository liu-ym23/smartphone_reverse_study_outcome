package com.bytedance.ee.bear.bitable.card.view.cell.url;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UrlCellViewHolder f208301a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public d(UrlCellViewHolder r100) {
        this.f208301a = r100;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        UrlCellViewHolder r104 = this.f208301a;
        int r105 = UrlCellViewHolder.S;
        r104.Y4();
    }
}
