package pg9;

import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f529219a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f529220b;

    static {
        Keva r100 = Keva.getRepo("plugin_store", 0);
        f529219a = r100;
        f529220b = r100.getString("key_domain", "https%3A%2F%2Flf-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source");
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "templateUrl");
        if (StringsKt.contains$default(r100, "${%s}", false, 2, null) == true) goto L5;
        return r100;
    L5:
        if (AppHost.f326268a.isTestChannel() == false) goto L23;
        Object r101 = "https%3A%2F%2Flf-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source";
        String r102 = "https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal";
        if (Intrinsics.areEqual(f529220b, "https%3A%2F%2Flf-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source") == false) goto L9;
    L24:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        if (rx7.h.a() != GeckoGlobalConfig.ENVType.PROD) goto L13;
        r102 = "https%3A%2F%2Flf-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source";
    L13:
        Object r104 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r104) == true) goto L21;
        r101 = r104;
    L21:
        String r105 = (String) r101;
        Intrinsics.checkNotNullParameter(r105, "value");
        f529219a.storeString("key_domain", r105);
        f529220b = r105;
    L15:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L9:
        if (Intrinsics.areEqual(f529220b, "https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal") == true) goto L24;
    L23:
        return StringsKt.replace$default(r100, "${%s}", f529220b, false, 4, null);
    }
}
