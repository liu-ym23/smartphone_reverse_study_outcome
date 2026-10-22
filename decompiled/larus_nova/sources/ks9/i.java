package ks9;

import android.text.Editable;
import android.text.TextWatcher;
import com.larus.profile.impl.relaxedit.input.LynxUIInputLit;

/* JADX INFO: loaded from: classes31.dex */
public final class i implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxUIInputLit f505952a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public i(LynxUIInputLit r100) {
        this.f505952a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        LynxUIInputLit r101 = this.f505952a;
        if (r101.f366839a == false) goto L5;
        return;
    L5:
        LynxUIInputLit.M(r101, r100);
    }
}
