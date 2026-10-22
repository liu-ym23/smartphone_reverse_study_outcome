package wv9;

import com.larus.common.apphost.AppHost;
import lq9.w;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public e() {
    }

    public static w a() {
        if (AppHost.f326268a.isOversea() == false) goto L6;
        return new w(0);
    L6:
        return new w(true, false, true, false, true);
    }
}
