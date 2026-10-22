package si6;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ void a(b r100, String r101, boolean r102, int r103) {
        boolean r104 = true;
        if ((r103 & 2) == 0) goto L6;
        r102 = true;
    L6:
        if ((r103 & 4) != 0) goto L9;
        r104 = false;
    L9:
        r100.t(r101, r102, r104, null);
    }

    public static /* synthetic */ void b(b r100, boolean r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.b(r101, null, r102);
    }
}
