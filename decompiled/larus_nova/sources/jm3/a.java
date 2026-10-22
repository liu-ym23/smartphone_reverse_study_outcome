package jm3;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.android.uicomponent.input.view.InputView;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputView f499633a;

    public a(InputView r100) {
        this.f499633a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        this.f499633a.a(r100);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        TextWatcher r104 = this.f499633a.f187669a;
        if (r104 == null) goto L6;
        r104.beforeTextChanged(r100, r101, r102, r103);
        return;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        InputView r104 = this.f499633a;
        TextWatcher r105 = r104.f187669a;
        if (r105 == null) goto L5;
        r105.onTextChanged(r100, r101, r102, r103);
    L5:
        r104.f();
    }
}
