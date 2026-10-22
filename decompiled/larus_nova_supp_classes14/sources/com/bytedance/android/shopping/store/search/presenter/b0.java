package com.bytedance.android.shopping.store.search.presenter;

import android.widget.EditText;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0<T> implements Observer {
    public final /* synthetic */ ShopSearchTitlePresenter a;

    public b0(ShopSearchTitlePresenter r1) {
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
        if (r3 == null) goto L17;
        EditText r1 = this.a.f;
        if (r1 == null) goto L18;
        r1.setHint(r3);
        return;
    L18:
        return;
    L17:
        return;
    L7:
        r0 = false;
        goto L8
    }
}
