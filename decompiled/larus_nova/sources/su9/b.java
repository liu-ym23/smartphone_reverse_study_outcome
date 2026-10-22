package su9;

import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    static {
    }

    public static a a() {
        if (AppHost.f326268a.isOversea() == false) goto L6;
        return new a(1289, "3fc6ca748b6839a54d5c1922169fea56", "wss://wss-normal.doubao.com/ws/v2", 134217731, 134217760);
    L6:
        return new a(1289, "3fc6ca748b6839a54d5c1922169fea56", "wss://wss-normal.doubao.com/ws/v2", 33554597, 33554695);
    }
}
