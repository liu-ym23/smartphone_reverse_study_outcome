package pv9;

import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public b() {
    }

    public static a a() {
        if (AppHost.a.isOversea() == false) goto L6;
        return new a(false);
    L6:
        return new a(true);
    }
}
