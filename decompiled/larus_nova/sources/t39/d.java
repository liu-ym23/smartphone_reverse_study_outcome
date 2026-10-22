package t39;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f544461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f544462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f544463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f544464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f544465f;

    public d() {
        this(null, null, null, null, null, null, null, 127);
    }

    public d(String r100, String r101, Integer r102, Integer r103, String r104, String r105) {
        this.f544460a = r100;
        this.f544461b = r101;
        this.f544462c = r102;
        this.f544463d = r103;
        this.f544464e = r104;
        this.f544465f = r105;
    }

    public /* synthetic */ d(String r100, String r101, Integer r102, Integer r110, String r111, String r112, String r113, int r114) {
        String r103 = null;
        if ((r114 & 1) == 0) goto L5;
        String r104 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Integer r106 = 1;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Integer r107 = 1;
    L19:
        if ((r114 & 16) != 0) goto L23;
        r103 = r111;
    L23:
        if ((r114 & 64) == 0) goto L25;
        String r108 = "";
    L26:
        this(r104, r105, r106, r107, r103, r108);
        return;
    L25:
        r108 = r113;
        goto L26
    L17:
        r107 = r110;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r104 = r100;
        goto L7
    }
}
