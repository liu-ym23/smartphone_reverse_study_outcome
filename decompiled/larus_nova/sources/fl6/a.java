package fl6;

import com.ss.alog.middleware.ALogService;

/* JADX INFO: loaded from: classes20.dex */
public final class a {
    public static void a(int r100, String r101, String r102) {
        if (r100 != 2) goto L5;
        ALogService.vSafely(r101, r102);
        return;
    L5:
        if (r100 != 3) goto L7;
        ALogService.dSafely(r101, r102);
        return;
    L7:
        if (r100 != 4) goto L9;
        ALogService.iSafely(r101, r102);
        return;
    L9:
        if (r100 != 5) goto L11;
        ALogService.wSafely(r101, r102);
        return;
    L11:
        if (r100 != 6) goto L23;
        ALogService.eSafely(r101, r102);
        return;
    }
}
