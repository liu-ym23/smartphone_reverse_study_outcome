package uj7;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes22.dex */
public final class k implements TextWatcher {
    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public k() {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        com.bytedance.ug.sdk.luckycat.impl.utils.u.a().g("add_schema_params", r100.toString());
    }
}
