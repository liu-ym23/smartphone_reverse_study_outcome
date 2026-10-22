package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ e a;
    public final /* synthetic */ Function0 b;

    public g(e r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        PopupWindow r2 = this.a.a;
        if (r2 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
    L5:
        this.b.invoke();
    }
}
