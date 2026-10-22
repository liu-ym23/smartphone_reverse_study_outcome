package ilb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f490353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f490354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f490355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f490356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f490357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f490358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f490359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f490360h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f490361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f490362j;

    public b() {
        this(0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1023);
    }

    public b(int r100, float r101, float r102, float r103, float r104, float r105, float r106, float r110, float r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = 0.0f;
    L9:
        if ((r112 & 4) == 0) goto L12;
        r102 = 0.0f;
    L12:
        if ((r112 & 8) == 0) goto L15;
        r103 = 0.0f;
    L15:
        if ((r112 & 16) == 0) goto L18;
        r104 = 0.0f;
    L18:
        if ((r112 & 32) == 0) goto L21;
        r105 = 0.0f;
    L21:
        if ((r112 & 64) == 0) goto L24;
        r106 = 0.0f;
    L24:
        if ((r112 & 128) == 0) goto L27;
        r110 = 0.0f;
    L27:
        if ((r112 & 256) == 0) goto L30;
        r111 = 0.0f;
    L30:
        if ((r112 & 512) == 0) goto L32;
        a r113 = new a(0);
    L33:
        Intrinsics.checkNotNullParameter(r113, "state");
        this.f490353a = r100;
        this.f490354b = r101;
        this.f490355c = r102;
        this.f490356d = r103;
        this.f490357e = r104;
        this.f490358f = r105;
        this.f490359g = r106;
        this.f490360h = r110;
        this.f490361i = r111;
        this.f490362j = r113;
        return;
    L32:
        r113 = null;
        goto L33
    }
}
