package pm3;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.android.uicomponent.input.view.SingleLineInputView;
import com.bytedance.android.uicomponent.search.SearchView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ SearchView a;

    public b(SearchView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        SearchView r5 = this.a;
        SingleLineInputView r0 = r5.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L5:
        r0.clearFocus();
        SingleLineInputView r1 = r5.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L8:
        Context r2 = r1.getContext();
        if (r2 == null) goto L11;
        Object r3 = r2.getSystemService("input_method");
    L12:
        if (r3 == null) goto L19;
        InputMethodManager r6 = (InputMethodManager) r3;
        SingleLineInputView r7 = r5.b;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L16:
        r6.hideSoftInputFromWindow(r7.getWindowToken(), 0);
        this.a.getClass();
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L11:
        r3 = null;
        goto L12
    }
}
