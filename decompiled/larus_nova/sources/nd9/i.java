package nd9;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class i extends ue9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f518825a;

    public i(g r100) {
        this.f518825a = r100;
    }

    @Override // ue9.d
    public final void a(ue9.b r110) {
        Intrinsics.checkNotNullParameter(r110, "state");
        fe9.c r100 = fe9.c.f476624a;
        r100.e("SessionConnectionManager", "onConnectionStateChanged state:" + r110 + " sessionStarted " + this.f518825a.f518819f.get());
        if ((r110 instanceof ue9.b.a) == false) goto L18;
        if (this.f518825a.f518819f.get() == true) goto L13;
        ue9.b.a r101 = (ue9.b.a) r110;
        if (r101.f549837c == true) goto L13;
        if (this.f518825a.f518820g.get() == true) goto L12;
        this.f518825a.c(jd9.c.b.f498755c);
        return;
    L12:
        r100.e("SessionConnectionManager", "ignore connected state when pseudo connected, from " + r101.f549835a);
        return;
    L13:
        ue9.b.a r111 = (ue9.b.a) r110;
        if (r111.f549837c == false) goto L16;
        this.f518825a.f518820g.set(true);
    L16:
        this.f518825a.c(new jd9.c.a(r111.f549837c));
        return;
    L18:
        if ((r110 instanceof ue9.b.C7871b) == false) goto L21;
        this.f518825a.c(jd9.c.b.f498755c);
        return;
    L21:
        if ((r110 instanceof ue9.b.c) == false) goto L40;
        StringBuilder r102 = new StringBuilder("errorCode:");
        ue9.b.c r112 = (ue9.b.c) r110;
        r102.append(r112.f549839a.f549843a);
        r102.append(", reason:");
        r102.append(r112.f549839a.f549844b);
        r102.append(", subCode:");
        r102.append(r112.f549841c);
        r100.e("SessionConnectionManager", r102.toString());
        jd9.c.d r103 = jd9.b.a(r112.f549839a);
        ue9.c r104 = r112.f549839a;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        int r105 = r104.f549843a;
        ue9.c.n r106 = ue9.c.n.f549858c;
        if (r105 != 20003) goto L25;
        int r107 = 3;
    L38:
        this.f518825a.c(jd9.c.d.a(r103, 0, r107, null, r112.f549840b, r112.f549841c, 5));
        return;
    L25:
        ue9.c.r r108 = ue9.c.r.f549861c;
        if (r105 != 20005) goto L28;
        r107 = 1;
        goto L38
    L28:
        ue9.c.t r109 = ue9.c.t.f549863c;
        if (r105 != 20004) goto L31;
        r107 = 4;
        goto L38
    L31:
        ue9.c.s r113 = ue9.c.s.f549862c;
        if (r105 != 20002) goto L34;
        r107 = 5;
        goto L38
    L34:
        ue9.c.w r114 = ue9.c.w.f549866c;
        if (r105 != 20006) goto L37;
        r107 = 2;
        goto L38
    L37:
        r107 = 0;
        goto L38
    L40:
        if (Intrinsics.areEqual(r110, ue9.b.d.f549842a) == false) goto L44;
        this.f518825a.c(jd9.c.f.f498762c);
        return;
    L44:
        throw new NoWhenBranchMatchedException();
    }
}
