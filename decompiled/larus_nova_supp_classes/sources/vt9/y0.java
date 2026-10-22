package vt9;

import com.larus.common.apphost.AppHost;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class y0 {
    public y0() {
    }

    public static x0 a() {
        if (AppHost.a.isOversea() == false) goto L6;
        return new x0(0);
    L6:
        return new x0(Boolean.TRUE, 2, Boolean.FALSE, CollectionsKt.emptyList());
    }
}
