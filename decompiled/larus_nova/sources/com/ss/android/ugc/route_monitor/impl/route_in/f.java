package com.ss.android.ugc.route_monitor.impl.route_in;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public final class f implements com.ss.android.ugc.route_monitor.utils.n {
    public f() {
    }

    @Override // com.ss.android.ugc.route_monitor.utils.n
    public final void enterForeground() {
        Iterator r100 = ((ArrayList) t.c()).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        u r101 = (u) r100.next();
        if (r101.f454574n == true) goto L4;
        r101.f454581u.c(false);
        goto L4
    }
}
