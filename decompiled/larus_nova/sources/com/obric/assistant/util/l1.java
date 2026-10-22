package com.obric.assistant.util;

import android.text.Editable;
import android.text.TextWatcher;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes33.dex */
public final class l1 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f393762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeepScreenOnDelegate f393763b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        FLogger.f375446a.i("KeepScreenOnDelegate", this.f393762a + " afterTextChanged");
        KeepScreenOnDelegate r101 = this.f393763b;
        KeepScreenOnDelegate.KeepScreenOnReason r102 = KeepScreenOnDelegate.KeepScreenOnReason.InputTextTail;
        r101.getClass();
        r101.h(new i1(r101, r102));
    }

    public l1(String r100, KeepScreenOnDelegate r101) {
        this.f393762a = r100;
        this.f393763b = r101;
    }
}
