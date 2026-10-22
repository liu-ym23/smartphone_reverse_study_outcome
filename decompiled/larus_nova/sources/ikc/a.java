package ikc;

import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final /* synthetic */ class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(b r100, String r101, Map r110, Map r111, int r112, int r113) {
        if ((r113 & 2) == 0) goto L5;
        Map r102 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        Map r103 = null;
    L11:
        if ((r113 & 16) == 0) goto L13;
        int r104 = 0;
    L14:
        r100.a(r101, r102, r103, null, r104);
        return;
    L13:
        r104 = r112;
        goto L14
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }
}
