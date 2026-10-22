package ska;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f542434a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Context f542435b;

    static {
        f542434a = new a();
    }

    public a() {
    }

    public static boolean a() {
        Context r100 = f542435b;
        if (r100 != null) goto L22;
        return false;
    L22:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0);     // Catch: Throwable -> L11
        if (Build.VERSION.SDK_INT < 28) goto L8;
        long r103 = r102.getLongVersionCode();     // Catch: Throwable -> L11
    L9:
        Object r104 = Result.m9449constructorimpl(Long.valueOf(r103));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r104) == false) goto L16;
        r104 = null;
    L16:
        Long r105 = (Long) r104;
        if (r105 != null) goto L19;
        return false;
    L19:
        if (r105.longValue() < 1130200201) goto L25;
        return true;
    L25:
        return false;
    L8:
        r103 = r102.versionCode;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
