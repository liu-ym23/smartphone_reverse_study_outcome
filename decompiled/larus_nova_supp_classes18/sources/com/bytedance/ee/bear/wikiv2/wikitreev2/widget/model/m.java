package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import androidx.lifecycle.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ n.a a;

    public m(n.a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        List r5 = (List) r4;
        String r0 = this.a.a();
        StringBuilder r1 = new StringBuilder("cacheObjTokens changed. size: ");
        if (r5 == null) goto L5;
        Integer r2 = Integer.valueOf(r5.size());
    L6:
        r1.append(r2);
        tt5.a.h(r0, r1.toString());
        this.a.c.clear();
        if (r5 == null) goto L9;
        this.a.c.addAll(r5);
    L9:
        n.a r6 = this.a;
        Boolean r3 = (Boolean) r6.b.getValue();
        if (r3 == null) goto L12;
        boolean r7 = r3.booleanValue();
    L13:
        if (r7 == true) goto L16;
        r6.b.setValue(Boolean.TRUE);
        return;
    L16:
        return;
    L12:
        r7 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }
}
