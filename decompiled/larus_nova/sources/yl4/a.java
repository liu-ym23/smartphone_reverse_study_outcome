package yl4;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.dux.forms.DuxLineInputView;
import com.bytedance.dux.searchbar.DuxSearchBar;
import em4.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DuxSearchBar f568317a;

    public a(DuxSearchBar r100) {
        this.f568317a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        boolean r102 = true;
        if (r101 == false) goto L16;
        DuxSearchBar r103 = this.f568317a;
        if (r103.f205559h.f205577r == false) goto L14;
        String r104 = r103.getText();
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == false) goto L14;
    L15:
        DuxSearchBar r106 = this.f568317a;
        n.f(r106.f205554c);
        n.e(r106.f205555d);
        DuxSearchBar.b r107 = r106.f205559h;
        r107.f205560a = false;
        r107.f205563d = true;
        DuxSearchBar r108 = this.f568317a;
        Object r109 = r108.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r109).showSoftInput(r108, 0);
        return;
    L9:
        if (r104.length() == 0) goto L12;
        r105 = false;
    L14:
        DuxLineInputView r110 = this.f568317a.f205552a;
        n.f(r110.f205132n);
        r110.f205143y.f205147c = false;
        goto L15
    L16:
        String r111 = this.f568317a.getText();
        if (r111 != null) goto L19;
    L22:
        boolean r112 = true;
    L23:
        if (r112 == false) goto L25;
        DuxSearchBar r113 = this.f568317a;
        n.e(r113.f205554c);
        r113.f205559h.f205563d = false;
    L25:
        DuxSearchBar r114 = this.f568317a;
        DuxSearchBar.b r115 = r114.f205559h;
        if (r115.f205576q == false) goto L29;
        r114.f205552a.hideClear();
    L38:
        DuxSearchBar r116 = this.f568317a;
        Object r117 = r116.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r117).hideSoftInputFromWindow(r116.getWindowToken(), 0);
        return;
    L29:
        if (r115.f205577r == false) goto L38;
        String r118 = r114.getText();
        if (r118 != null) goto L33;
    L36:
        if (r102 == false) goto L38;
        this.f568317a.f205552a.hideClear();
        goto L38
    L33:
        if (r118.length() == 0) goto L36;
        r102 = false;
        goto L36
    L19:
        if (r111.length() == 0) goto L22;
        r112 = false;
        goto L23
    }
}
