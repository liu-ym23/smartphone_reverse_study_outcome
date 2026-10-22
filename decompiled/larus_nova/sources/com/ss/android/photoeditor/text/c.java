package com.ss.android.photoeditor.text;

import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import pfc.k;
import pfc.u;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements TextInputView.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextEditorView f449532a;

    public c(TextEditorView r100) {
        this.f449532a = r100;
    }

    public final void a(String r100, int r101) {
        k.a r102 = this.f449532a.f449494d;
        if (r102 == null) goto L6;
        ((u) r102).f529098a.f529106h.setVisibility(0);
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L13;
        sfc.a.f541747a.getClass();
        sfc.a.f541750d = true;
        TextEditorDrawView.f r103 = (TextEditorDrawView.f) this.f449532a.f449491a.getTextStickerController();
        wfc.e r104 = r103.f449455a.f449440q;
        if (r104 == null) goto L10;
        r104.update(r100, r101);
    L10:
        r103.b();
        TextEditorView.a r105 = this.f449532a.f449495e;
        if (r105 == null) goto L13;
        g r106 = (g) r105;
        r106.f449538b.f449514b.setOnColorChangedListener(null);
        r106.f449538b.f449514b.a(r101);
        r106.f449538b.f449514b.setOnColorChangedListener(r106.f449537a);
    L13:
        TextInputView r107 = this.f449532a.f449493c;
        if (r107.f449505h == null) goto L19;
        InputMethodManager r108 = (InputMethodManager) r107.f449503f.getContext().getSystemService("input_method");
        if (r108 == null) goto L19;
        r108.hideSoftInputFromWindow(r107.f449503f.getWindowToken(), 0);
    L19:
        this.f449532a.f449493c.setVisibility(8);
        this.f449532a.f449496f.setVisibility(0);
        this.f449532a.f449497g = true;
    }
}
