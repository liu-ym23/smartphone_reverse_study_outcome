package com.bytedance.ee.bear.document.at;

import com.bytedance.ee.bear.atfinder.MentionModel;
import com.bytedance.ee.bear.utils.AtUtils;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public abstract class q implements com.bytedance.ee.bear.atfinder.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<ln4.m> f219117a;

    public abstract void c(ArrayList<ln4.m> r100);

    public q() {
        ArrayList<ln4.m> r100 = new ArrayList();
        this.f219117a = r100;
        c(r100);
    }

    @Override // com.bytedance.ee.bear.atfinder.e
    public List<Disposable> b(MentionModel r100) {
        ArrayList r101 = new ArrayList();
        Iterator<ln4.m> r102 = this.f219117a.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        ln4.m r103 = r102.next();
        com.bytedance.ee.bear.atfinder.g r104 = r103.f510029g;
        if (r104 != null) goto L8;
        int r105 = -1;
    L9:
        r101.add(r103.f510028f.a(r100, AtUtils.b(r103.f510025c), new ln4.l(r103, r105)));
        goto L4
    L8:
        r105 = System.identityHashCode(r104);
        goto L9
    L10:
        return r101;
    }
}
