package rta;

import java.lang.ref.WeakReference;
import vta.g;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<qta.d> f539200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<qta.b> f539201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f539202c;

    public b(qta.d r100, qta.b r101) {
        this.f539200a = new WeakReference(r100);
        this.f539201b = new WeakReference(r101);
    }

    public final void b() {
        WeakReference<qta.d> r100 = this.f539200a;
        if (r100 == null) goto L18;
        qta.d r101 = r100.get();
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.d() != true) goto L22;
        a r102 = this.f539202c;
        if (r102 == null) goto L12;
        r102.cancel();
    L12:
        WeakReference<qta.d> r103 = this.f539200a;
        if (r103 == null) goto L20;
        qta.d r104 = r103.get();
        if (r104 == null) goto L21;
        r104.a();
        return;
    L21:
        return;
    L20:
        return;
    L22:
        return;
    }

    public final long a() {
        WeakReference<qta.b> r100 = this.f539201b;
        if (r100 == null) goto L19;
        qta.b r101 = r100.get();
        if (r101 == null) goto L19;
        vta.b r102 = r101.c();
        if (r102 == null) goto L19;
        g r103 = r102.f557254g;
        if (r103 == null) goto L19;
        Long r104 = Long.valueOf(r103.f557268a);
        if (r104.longValue() <= 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L17;
        r104 = null;
    L17:
        if (r104 == null) goto L19;
        return r104.longValue() * ((long) 1000);
    L13:
        r105 = false;
    L19:
        return 30000;
    }

    public final void c() {
        WeakReference<qta.d> r100 = this.f539200a;
        if (r100 == null) goto L9;
        qta.d r101 = r100.get();
        if (r101 == null) goto L9;
        if (r101.d() != true) goto L9;
        return;
    L9:
        WeakReference<qta.b> r102 = this.f539201b;
        String r103 = null;
        if (r102 == null) goto L14;
        qta.b r104 = r102.get();
        if (r104 == null) goto L14;
        vta.b r105 = r104.c();
    L15:
        WeakReference<qta.d> r106 = this.f539200a;
        if (r106 == null) goto L40;
        qta.d r107 = r106.get();
        if (r107 == null) goto L41;
        if (r105 == null) goto L23;
        g r108 = r105.f557254g;
        if (r108 == null) goto L23;
        String r109 = r108.f557271d;
    L24:
        if (r105 == null) goto L28;
        g r110 = r105.f557254g;
        if (r110 == null) goto L28;
        String r111 = r110.f557272e;
    L29:
        if (r105 == null) goto L33;
        g r112 = r105.f557254g;
        if (r112 == null) goto L33;
        String r113 = r112.f557269b;
    L34:
        if (r105 == null) goto L38;
        g r114 = r105.f557254g;
        if (r114 == null) goto L38;
        r103 = r114.f557270c;
    L38:
        r107.a(r109, r111, r113, r103);
        return;
    L33:
        r113 = null;
    L28:
        r111 = null;
    L23:
        r109 = null;
        goto L24
    L41:
        return;
    L40:
        return;
    L14:
        r105 = null;
        goto L15
    }
}
