package com.bytedance.android.shopping.store.search.presenter;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h0 implements TextWatcher {
    public final /* synthetic */ ShopSearchTitlePresenter a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public h0(ShopSearchTitlePresenter r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
        if (TextUtils.isEmpty(r2) == true) goto L12;
        ImageView r6 = this.a.g;
        if (r6 == null) goto L12;
        if (r6.getVisibility() != 8) goto L12;
        ImageView r7 = this.a.g;
        if (r7 == null) goto L21;
        r7.setVisibility(0);
    L21:
        if ((!Intrinsics.areEqual(String.valueOf(r2), (String) this.a.E().getSearchContent().a())) == false) goto L23;
        ShopSearchTitlePresenter r8 = this.a;
        r8.j = true;
        r8.E().getSearchContent().g(String.valueOf(r2));
    L23:
        this.a.E().getSugRequestParam().a = r3 + r5;
        return;
    L12:
        if (TextUtils.isEmpty(r2) == false) goto L21;
        ImageView r9 = this.a.g;
        if (r9 == null) goto L21;
        if (r9.getVisibility() != 0) goto L21;
        ImageView r10 = this.a.g;
        if (r10 == null) goto L21;
        r10.setVisibility(8);
        goto L21
    }
}
