package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes27.dex */
public final class s implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricEarbudsAddSpecialContactSheet f339935a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public s(DoraObricEarbudsAddSpecialContactSheet r100) {
        this.f339935a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        DoraObricEarbudsAddSpecialContactSheet r101 = this.f339935a;
        int r102 = DoraObricEarbudsAddSpecialContactSheet.f339732h;
        r101.U90();
    }
}
