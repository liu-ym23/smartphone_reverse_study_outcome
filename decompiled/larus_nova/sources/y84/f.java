package y84;

import com.bytedance.bdnavigationsdk.navigation.NavigationTransport;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f extends a {
    public f() {
        NavigationTransport.TransportType r100 = NavigationTransport.TransportType.EBicycling;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        Object r101 = o.f566906a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("transportType");
        r100 = null;
    L6:
        i r102 = o.a(r100);
        Intrinsics.checkNotNull(r102);
        j(r102);
    }
}
