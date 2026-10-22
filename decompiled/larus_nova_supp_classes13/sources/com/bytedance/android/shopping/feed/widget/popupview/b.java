package com.bytedance.android.shopping.feed.widget.popupview;

import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        if (((Boolean) r1).booleanValue() == false) goto L6;
        a r2 = this.a;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
        return;
    }
}
