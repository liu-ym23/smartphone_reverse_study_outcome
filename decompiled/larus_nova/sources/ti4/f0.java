package ti4;

/* JADX INFO: loaded from: classes15.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f546083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f546084b;

    public f0(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r101 & 2) == 0) goto L9;
        r100 = false;
    L9:
        this.f546083a = r102;
        this.f546084b = r100;
        return;
    L5:
        r102 = false;
        goto L7
    }
}
