package com.bytedance.android.shopping.store.search.presenter;

import android.widget.EditText;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c0<T> implements Observer {
    public final /* synthetic */ ShopSearchTitlePresenter a;

    public c0(ShopSearchTitlePresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        String r3 = (String) r2;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L20;
        EditText r1 = this.a.f;
        if (r1 == null) goto L15;
        r1.setText(r3);
    L15:
        EditText r4 = this.a.f;
        if (r4 == null) goto L21;
        r4.setSelection(r3.length());
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r0 = false;
        goto L8
    }
}
