package com.bytedance.ee.bear.document.editionmanager.moreitem;

import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements com.bytedance.ee.bear.more.protocol3.m {
    public final /* synthetic */ g a;

    public final boolean isVisible() {
        oj5.c r0 = this.a.c();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.m() == false) goto L7;
        return false;
    L7:
        if (z05.i.b(r0.i()) == false) goto L30;
        String r1 = r0.getToken();
        Map<String, z05.g> r2 = z05.f.a;
        ArrayList r3 = new ArrayList();
        Iterator r4 = ((ConcurrentHashMap) z05.f.a).values().iterator();
    L11:
        if (r4.hasNext() == false) goto L16;
        z05.g r5 = (z05.g) r4.next();
        if (r1.equals(r5.g) == false) goto L11;
        r3.add(r5);
        goto L11
    L16:
        if (Build.VERSION.SDK_INT < 24) goto L19;
        r3.sort(new z05.e());
    L19:
        if (r3.size() <= 0) goto L29;
        return true;
    L29:
        return false;
    L30:
        return false;
    }

    public i(g r1) {
        this.a = r1;
    }
}
