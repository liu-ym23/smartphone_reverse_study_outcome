package yr;

import android.text.TextUtils;
import com.ss.alog.middleware.ALogService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    public static void a(String r100, Throwable r101) {
        d(r100, null, r101);
    }

    public static void b(int r100, String r101, String r102) {
        int r103 = a.f568905a;
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "info");
        cs.a.a();
        c(r100, r101, r102);
    }

    public static void c(int r100, String r101, String r102) {
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

    public static void d(String r100, String r101, Throwable r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        ALogService.eSafely(r100, r102);
        return;
    L5:
        ALogService.eSafely(r100, r101, r102);
    }
}
