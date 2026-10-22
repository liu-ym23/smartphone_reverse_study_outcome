package pfc;

import java.util.Iterator;

/* JADX INFO: loaded from: classes38.dex */
public final class u implements k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f529098a;

    public u(v r100) {
        this.f529098a = r100;
    }

    public final void a(Class r100) {
        Iterator<o> r101 = this.f529098a.f529102d.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        o r102 = r101.next();
        if (r102.f529088a.getName().equals(r100.getName()) == false) goto L4;
        v r103 = this.f529098a;
        r103.getClass();
        new t(r103, r102).onClick(r102.f529091d);
        goto L4
    }
}
