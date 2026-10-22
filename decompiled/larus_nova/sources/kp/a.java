package kp;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public static String a() {
        Lazy r100 = ECAppInfoService.f48110a;
        if (we.a.f559330a == false) goto L5;
        String r101 = "isaas.ecombdapi.com";
    L7:
        return "https://".concat(r101);
    L5:
        r101 = "lianmengapi.snssdk.com";
        goto L7
    }

    static {
    }
}
