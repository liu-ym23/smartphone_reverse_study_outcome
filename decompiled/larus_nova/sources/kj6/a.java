package kj6;

import kotlin.jvm.internal.Intrinsics;
import qi6.e;
import yi6.c;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f503713f;

    /* JADX INFO: renamed from: kj6.a$a, reason: collision with other inner class name */
    public static final class C6562a {
    }

    static {
    }

    @Override // qi6.f
    public final String getName() {
        return this.f503713f;
    }

    @Override // yi6.c, qi6.f
    public final void i() {
        e.f(this);
    }

    @Override // yi6.c, qi6.f
    public final void init() {
        e.a(this);
    }

    @Override // yi6.c, qi6.f
    public final void pause() {
        e.b(this);
    }

    @Override // yi6.c, qi6.f
    public final void release() {
        e.d(this);
    }

    @Override // yi6.c, qi6.f
    public final void resume() {
        e.e(this);
    }

    @Override // yi6.c, qi6.f
    public final void stop() {
        e.g(this);
    }

    public a(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkService");
        super(r100);
        this.f503713f = "VideoPublishProcessNode";
    }

    @Override // yi6.c, qi6.f
    public final void m(qi6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        if (r100.f533151a == true) goto L40;
        Object r101 = null;
        if (r100.f533157g.containsKey("extra_datas") == false) goto L14;
        Object r102 = r100.f533157g.get("extra_datas");
        if ((r102 instanceof Object[]) == true) goto L9;
        r102 = null;
    L9:
        Object[] r103 = (Object[]) r102;
        if (r103 == null) goto L12;
        int r104 = r103.length;
    L13:
        if (r104 == 0) goto L14;
    L15:
        Object r105 = r100.f533157g.get("extra_datas");
        if ((r105 instanceof Object[]) == true) goto L18;
        r105 = null;
    L18:
        Object[] r106 = (Object[]) r105;
        if (r106 == null) goto L21;
        int r107 = r106.length;
    L22:
        if (r107 < 1) goto L40;
        Object r108 = r100.f533157g.get("extra_datas");
        if ((r108 instanceof Object[]) == true) goto L26;
        r108 = null;
    L26:
        Object[] r109 = (Object[]) r108;
        if (r109 == null) goto L29;
        Object r110 = r109[0];
    L30:
        if (r110 != null) goto L40;
        Object r111 = r100.f533157g.get("extra_datas");
        if ((r111 instanceof Object[]) == true) goto L34;
        r111 = null;
    L34:
        Object[] r112 = (Object[]) r111;
        if (r112 == null) goto L40;
        vi6.a r113 = this.f567964e.v();
        if (r113 == null) goto L39;
        r101 = r113.a();
    L39:
        r112[0] = r101;
        goto L40
    L29:
        r110 = null;
        goto L30
    L21:
        r107 = 0;
        goto L22
    L12:
        r104 = 0;
    L14:
        r100.f533157g.put("extra_datas", new Object[1]);
    L40:
        e.c(this, r100);
    }
}
