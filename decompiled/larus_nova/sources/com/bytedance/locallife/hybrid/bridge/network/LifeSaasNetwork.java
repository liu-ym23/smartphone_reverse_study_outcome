package com.bytedance.locallife.hybrid.bridge.network;

import android.net.Uri;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ou6.l;

/* JADX INFO: loaded from: classes21.dex */
public final class LifeSaasNetwork {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f259036a = null;

    static {
        f259036a = LazyKt.lazy(LifeSaasNetwork$lifeSaasNetworkConfig$2.INSTANCE);
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestUrl");
        if (StringsKt.contains$default(r100, "life-service-open.scsjsd.com", false, 2, null) != true) goto L6;
        return true;
    L6:
        return false;
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestUrl");
        Lazy r101 = f259036a;     // Catch: Throwable -> L15
        List<String> r102 = ((a) r101.getValue()).a();     // Catch: Throwable -> L15
        if (r102 != null) goto L6;
        r102 = new ArrayList();     // Catch: Throwable -> L15
    L6:
        Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L15
        String r104 = r103.getHost();     // Catch: Throwable -> L15
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        if (r102.contains(r104) == true) goto L12;
        com.bytedance.locallife.biz.common.utils.c.a("XBridgeAPIRequestUtils", "originUri: " + r103.getHost() + ", replaceHost: " + r100 + ", interceptHosts: " + ((a) r101.getValue()).a());     // Catch: Throwable -> L15
    L17:
        return r100;
    L12:
        return l.b(r103, "life-service-open.scsjsd.com").toString();
    L15:
        th = move-exception;
        HostServiceUtilsKt.k().e("LifeSaasNetwork", th.getMessage());
        goto L17
    }
}
