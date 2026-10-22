package pm3;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.android.uicomponent.input.view.SingleLineInputView;
import com.bytedance.android.uicomponent.search.SearchView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f529824a;

    public b(SearchView r100) {
        this.f529824a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SearchView r101 = this.f529824a;
        SingleLineInputView r102 = r101.f187739b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L5:
        r102.clearFocus();
        SingleLineInputView r103 = r101.f187739b;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L8:
        Context r104 = r103.getContext();
        if (r104 == null) goto L11;
        Object r105 = r104.getSystemService("input_method");
    L12:
        if (r105 == null) goto L19;
        InputMethodManager r106 = (InputMethodManager) r105;
        SingleLineInputView r107 = r101.f187739b;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
    L16:
        r106.hideSoftInputFromWindow(r107.getWindowToken(), 0);
        this.f529824a.getClass();
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L11:
        r105 = null;
        goto L12
    }
}
