package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import androidx.lifecycle.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class m<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n.a f241952a;

    public m(n.a r100) {
        this.f241952a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        String r102 = this.f241952a.a();
        StringBuilder r103 = new StringBuilder("cacheObjTokens changed. size: ");
        if (r101 == null) goto L5;
        Integer r104 = Integer.valueOf(r101.size());
    L6:
        r103.append(r104);
        tt5.a.h(r102, r103.toString());
        this.f241952a.f241961c.clear();
        if (r101 == null) goto L9;
        this.f241952a.f241961c.addAll(r101);
    L9:
        n.a r105 = this.f241952a;
        Boolean r106 = r105.f241960b.getValue();
        if (r106 == null) goto L12;
        boolean r107 = r106.booleanValue();
    L13:
        if (r107 == true) goto L16;
        r105.f241960b.setValue(Boolean.TRUE);
        return;
    L16:
        return;
    L12:
        r107 = false;
        goto L13
    L5:
        r104 = null;
        goto L6
    }
}
