package tl4;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.dux.forms.DuxBoxInputView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DuxBoxInputView f546621a;

    public a(DuxBoxInputView r100) {
        this.f546621a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L5;
        DuxBoxInputView r102 = this.f546621a;
        int r103 = DuxBoxInputView.f205098s;
        Object r104 = r102.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r104).showSoftInput(r102, 0);
        return;
    L5:
        DuxBoxInputView r105 = this.f546621a;
        int r106 = DuxBoxInputView.f205098s;
        Object r107 = r105.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r107).hideSoftInputFromWindow(r105.getWindowToken(), 0);
    }
}
