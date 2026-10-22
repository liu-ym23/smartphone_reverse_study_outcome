package rfa;

import android.content.pm.PackageInfo;
import androidx.core.content.pm.PackageInfoCompat;
import com.larus.common.apphost.AppHost;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, c> f537648a = null;

    static {
        f537648a = new ConcurrentHashMap();
    }

    public static c a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pkgName");
        c r101 = f537648a.get(r100);
        if (r101 == null) goto L18;
        return r101;
    L18:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        PackageInfo r103 = AppHost.f326268a.getApplication().getPackageManager().getPackageInfo(r100, 0);     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(new c(PackageInfoCompat.getLongVersionCode(r103), r103.lastUpdateTime));     // Catch: Throwable -> L8
    L11:
        if (Result.m9456isSuccessimpl(r104) == false) goto L13;
        ConcurrentHashMap<String, c> r105 = f537648a;
        r105.put(r100, (c) r104);
    L13:
        c r106 = new c(0);
        if (Result.m9455isFailureimpl(r104) == false) goto L17;
        r104 = r106;
    L17:
        return (c) r104;
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
