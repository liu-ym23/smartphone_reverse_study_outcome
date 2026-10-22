package jm3;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.android.uicomponent.input.view.InputView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements TextWatcher {
    public final /* synthetic */ InputView a;

    public a(InputView r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r2) {
        this.a.a(r2);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r2, int r3, int r4, int r5) {
        TextWatcher r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.beforeTextChanged(r2, r3, r4, r5);
        return;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
        InputView r0 = this.a;
        TextWatcher r1 = r0.a;
        if (r1 == null) goto L5;
        r1.onTextChanged(r3, r4, r5, r6);
    L5:
        r0.f();
    }
}
