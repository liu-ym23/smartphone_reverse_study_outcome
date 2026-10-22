package ji6;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class b {
    public static /* synthetic */ void a(c r100, String r110, Object r111, int r112, boolean r113, int r114) {
        if ((r114 & 8) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r114 & 16) == 0) goto L9;
        boolean r102 = true;
    L10:
        r100.q(r110, r111, r112, r101, r102, 0);
        return;
    L9:
        r102 = r113;
        goto L10
    L5:
        r101 = false;
        goto L7
    }
}
