package dmc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f469265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.b f469266b;

    public static final class a {
    }

    static {
    }

    public d(int r100) {
        this.f469265a = -1;
        this.f469266b = null;
    }

    public final List<tlc.d> a(List<? extends tlc.d> r100) {
        if (r100 == null) goto L22;
        LinkedList r101 = new LinkedList();
        Iterator<T> r102 = r100.iterator();
    L5:
        if (r102.hasNext() == false) goto L12;
        tlc.d r103 = (tlc.d) r102.next();
        vlc.b r104 = this.f469266b;
        if (r104 == null) goto L10;
        if (r104.onMessage(r103) == true) goto L5;
    L10:
        r101.addLast(r103);
        goto L5
    L12:
        if (this.f469265a <= 0) goto L21;
        int r105 = r101.size() - this.f469265a;
        if (r105 <= 0) goto L21;
        int r106 = 0;
    L16:
        if (r106 >= r105) goto L21;
        if ((!r101.isEmpty()) == false) goto L20;
        r101.removeFirst();
    L20:
        r106 = r106 + 1;
    L21:
        return r101;
    L22:
        return null;
    }
}
