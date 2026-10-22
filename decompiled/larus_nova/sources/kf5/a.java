package kf5;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ void a(b r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = true;
    L8:
        r100.d(r101, r102);
    }

    public static /* synthetic */ void b(b r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r102 = false;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r103 = true;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r104 = false;
    L15:
        if ((r106 & 16) == 0) goto L17;
        r105 = false;
    L17:
        r100.h(r101, r102, r103, r104, r105);
    }
}
