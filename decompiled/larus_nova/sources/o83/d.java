package o83;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f522369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f522370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f522371c;

    public d() {
        this(null, 7);
    }

    public d(Boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = Boolean.FALSE;
    L5:
        Boolean r102 = null;
        if ((r101 & 2) == 0) goto L8;
        Boolean r103 = Boolean.FALSE;
    L10:
        if ((r101 & 4) == 0) goto L12;
        r102 = Boolean.FALSE;
    L12:
        this.f522369a = r100;
        this.f522370b = r103;
        this.f522371c = r102;
        return;
    L8:
        r103 = null;
        goto L10
    }
}
