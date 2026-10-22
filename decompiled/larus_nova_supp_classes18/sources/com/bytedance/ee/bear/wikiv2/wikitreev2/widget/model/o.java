package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o<T> implements Observer {
    public final /* synthetic */ n a;
    public final /* synthetic */ WeakReference<WikiTreeCtrlView> b;

    public o(n r1, WeakReference<WikiTreeCtrlView> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        n r6 = this.a;
        WeakReference<WikiTreeCtrlView> r0 = this.b;
        if (r6.b == true) goto L26;
        Iterator<n.a> r1 = r6.c.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        Boolean r2 = (Boolean) r1.next().b.getValue();
        if (r2 == null) goto L10;
        boolean r3 = r2.booleanValue();
    L11:
        if (r3 == true) goto L6;
        return;
    L10:
        r3 = false;
        goto L11
    L13:
        r6.b = true;
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L27;
        tt5.a.h("WikiOfflineEnableChecker", "WikiOfflineEnableChecker.prepare");
        WikiTreeCtrlView r7 = r0.get();
        if (r7 != null) goto L18;
        return;
    L18:
        if (r7.f == null) goto L29;
        r7.getViewModel().refresh();
        return;
    L29:
        return;
    L27:
        return;
    }
}
