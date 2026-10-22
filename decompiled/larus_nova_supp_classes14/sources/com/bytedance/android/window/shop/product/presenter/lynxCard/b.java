package com.bytedance.android.window.shop.product.presenter.lynxCard;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.LinkedHashMap;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ ECLynxCardPresenter a;

    public b(ECLynxCardPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        ECLynxCardPresenter r5 = this.a;
        KProperty[] r0 = ECLynxCardPresenter.t;
        ECLynxCard r6 = r5.G();
        if (r6 == null) goto L6;
        r6.p("ecom.window.show_bubble_event", new LinkedHashMap());
        return;
    }
}
