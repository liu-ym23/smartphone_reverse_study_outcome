package com.bytedance.ee.bear.document.at;

import com.bytedance.ee.bear.atfinder.MentionModel;
import com.bytedance.ee.bear.utils.AtUtils;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class q implements com.bytedance.ee.bear.atfinder.e {
    public final ArrayList<ln4.m> a;

    public abstract void c(ArrayList<ln4.m> r1);

    public q() {
        ArrayList<ln4.m> r0 = new ArrayList();
        this.a = r0;
        c(r0);
    }

    public List<Disposable> b(MentionModel r8) {
        ArrayList r0 = new ArrayList();
        Iterator<ln4.m> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        ln4.m r2 = r1.next();
        com.bytedance.ee.bear.atfinder.g r3 = r2.g;
        if (r3 != null) goto L8;
        int r4 = -1;
    L9:
        r0.add(r2.f.a(r8, AtUtils.b(r2.c), new ln4.l(r2, r4)));
        goto L4
    L8:
        r4 = System.identityHashCode(r3);
        goto L9
    L10:
        return r0;
    }
}
