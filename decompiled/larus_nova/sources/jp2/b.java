package jp2;

import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class b implements ry.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f499940a;

    public /* synthetic */ b(c r100) {
        this.f499940a = r100;
    }

    @Override // ry.c
    public final void onEvent(ry.c.a r100) {
        Iterator<ry.c> r101 = this.f499940a.f499942a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        ry.c r102 = r101.next();
        if (r102 == null) goto L4;
        r102.onEvent(r100);
        goto L4
    }
}
