package com.bytedance.android.shopping.store.search.presenter;

import android.text.Editable;
import android.widget.EditText;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a0<T> implements Observer {
    public final /* synthetic */ ShopSearchTitlePresenter a;

    public a0(ShopSearchTitlePresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        String r6 = (String) r5;
        if (r6 == null) goto L24;
        EditText r1 = this.a.f;
        if (r1 == null) goto L7;
        Editable r2 = r1.getText();
    L8:
        boolean r3 = true;
        if ((!Intrinsics.areEqual(r6, String.valueOf(r2))) == true) goto L11;
    L13:
        r3 = false;
    L14:
        if (r3 == true) goto L17;
        r6 = null;
    L17:
        if (r6 == null) goto L24;
        EditText r4 = this.a.f;
        if (r4 == null) goto L21;
        r4.setText(r6);
    L21:
        EditText r7 = this.a.f;
        if (r7 == null) goto L24;
        r7.setSelection(r6.length());
        goto L24
    L11:
        if (this.a.j == true) goto L13;
    L7:
        r2 = null;
    L24:
        this.a.j = false;
    }
}
