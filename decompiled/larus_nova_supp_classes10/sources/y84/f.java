package y84;

import com.bytedance.bdnavigationsdk.navigation.NavigationTransport;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends a {
    public f() {
        NavigationTransport.TransportType r0 = NavigationTransport.TransportType.EBicycling;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        Object r1 = o.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("transportType");
        r0 = null;
    L6:
        i r2 = o.a(r0);
        Intrinsics.checkNotNull(r2);
        j(r2);
    }
}
