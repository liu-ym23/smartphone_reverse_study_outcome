package qt9;

import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes.dex */
public final class z0 {
    public z0() {
    }

    public static hq9.g1 a() {
        if (AppHost.f326268a.isOversea() == false) goto L6;
        return new hq9.g1(0, false);
    L6:
        return new hq9.g1(0, true);
    }
}
