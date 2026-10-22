package qt9;

import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes.dex */
public final class v4 {
    public v4() {
    }

    public static hq9.d5 a() {
        if (AppHost.f326268a.isOversea() == false) goto L6;
        return new hq9.d5(false, false, false);
    L6:
        return new hq9.d5(true, true, true);
    }
}
