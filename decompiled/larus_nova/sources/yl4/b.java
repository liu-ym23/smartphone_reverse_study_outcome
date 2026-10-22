package yl4;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.dux.forms.DuxLineInputView;
import com.bytedance.dux.searchbar.DuxSearchBar;
import em4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DuxSearchBar f568318a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public b(DuxSearchBar r100) {
        this.f568318a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L14;
        DuxSearchBar r103 = this.f568318a;
        if (r103.f205559h.f205568i == null) goto L13;
        r103.f205552a.U5();
        r103.f205559h.f205567h = true;
    L13:
        this.f568318a.f205552a.hideClear();
        return;
    L14:
        DuxSearchBar r104 = this.f568318a;
        DuxLineInputView r105 = r104.f205552a;
        if (r105.f205133o.getVisibility() == 0) goto L18;
        r101 = false;
    L18:
        if (r101 == false) goto L20;
        n.e(r105.f205133o);
    L20:
        r105.I = false;
        r104.f205559h.f205567h = false;
        DuxLineInputView r106 = this.f568318a.f205552a;
        n.f(r106.f205132n);
        r106.f205143y.f205147c = false;
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
