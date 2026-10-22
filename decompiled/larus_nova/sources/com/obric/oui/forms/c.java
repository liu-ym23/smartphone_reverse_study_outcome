package com.obric.oui.forms;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OBoxInputView f401012a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "s");
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "s");
    }

    public c(OBoxInputView r100) {
        this.f401012a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        AppCompatEditText r101 = this.f401012a.getEditText();
        final OBoxInputView r102 = this.f401012a;
        r101.post(new b(r102));
    }
}
