package yl9;

import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.jvm.internal.Intrinsics;
import ul9.i;

/* JADX INFO: loaded from: classes30.dex */
public class c implements tl9.a {
    public c() {
    }

    @Override // tl9.a
    public void a(int r100, String r101, String r102, String r103, String r104, ul9.e r105) {
        Intrinsics.checkNotNullParameter(r101, "oldSessionId");
        Intrinsics.checkNotNullParameter(r102, "oldRouteId");
        Intrinsics.checkNotNullParameter(r103, "sessionId");
        Intrinsics.checkNotNullParameter(r104, "routeId");
        Intrinsics.checkNotNullParameter(r105, CloudControlInf.ROUTE);
    }

    @Override // tl9.a
    public void b(i r100) {
        Intrinsics.checkNotNullParameter(r100, "update");
    }

    @Override // tl9.a
    public void d(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "routeId");
    }
}
