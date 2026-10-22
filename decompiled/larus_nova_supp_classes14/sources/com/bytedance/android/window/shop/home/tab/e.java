package com.bytedance.android.window.shop.home.tab;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.LinkedHashMap;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ WindowLynxTabPresenter a;

    public e(WindowLynxTabPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        WindowLynxTabPresenter r5 = this.a;
        KProperty[] r0 = WindowLynxTabPresenter.q;
        ECLynxCard r6 = r5.G();
        if (r6 == null) goto L6;
        r6.p("ecom.window.show_bubble_event", new LinkedHashMap());
        return;
    }
}
