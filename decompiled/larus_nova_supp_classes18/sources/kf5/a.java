package kf5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ void a(b r1, boolean r2, boolean r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = true;
    L8:
        r1.d(r2, r3);
    }

    public static /* synthetic */ void b(b r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = true;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r6 = false;
    L15:
        if ((r8 & 16) == 0) goto L17;
        r7 = false;
    L17:
        r2.h(r3, r4, r5, r6, r7);
    }
}
