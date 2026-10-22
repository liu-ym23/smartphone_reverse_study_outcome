package lob;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;

/* JADX INFO: loaded from: classes36.dex */
public interface a extends TextWatcher {
    @Override // android.text.TextWatcher
    void afterTextChanged(Editable r100);

    @Override // android.text.TextWatcher
    void beforeTextChanged(CharSequence r100, int r101, int r102, int r103);

    void j(EditText r100);

    @Override // android.text.TextWatcher
    void onTextChanged(CharSequence r100, int r101, int r102, int r103);

    void r(Editable r100, int r101, int r102);

    boolean z(int r100, KeyEvent r101);
}
