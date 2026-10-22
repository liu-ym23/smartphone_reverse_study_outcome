package ie5;

import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.i0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static Object a(Class r4) {
            Intrinsics.checkNotNullParameter(r4, "service");
            if (Intrinsics.areEqual(b0.class, r4) == false) goto L7;
            Object r5 = org.koin.java.a.c(b0.class, null, null, 6);
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type T of com.bytedance.ee.bear.lynx.impl.utli.ServiceDependence.Companion.getService");
            return r5;
        L7:
            if (Intrinsics.areEqual(com.bytedance.ee.bear.contract.d.class, r4) == false) goto L11;
            Object r6 = org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type T of com.bytedance.ee.bear.lynx.impl.utli.ServiceDependence.Companion.getService");
            return r6;
        L11:
            if (Intrinsics.areEqual(NetService.class, r4) == false) goto L15;
            Object r7 = org.koin.java.a.c(NetService.class, null, null, 6);
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type T of com.bytedance.ee.bear.lynx.impl.utli.ServiceDependence.Companion.getService");
            return r7;
        L15:
            if (Intrinsics.areEqual(ConnectionService.class, r4) == false) goto L19;
            com.bytedance.ee.bear.contract.j r8 = com.bytedance.ee.bear.contract.j.a.a;
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type T of com.bytedance.ee.bear.lynx.impl.utli.ServiceDependence.Companion.getService");
            return r8;
        L19:
            if (Intrinsics.areEqual(com.bytedance.ee.bear.lark.dependency.k.class, r4) == false) goto L23;
            Object r9 = org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.k.class, null, null, 6);
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type T of com.bytedance.ee.bear.lynx.impl.utli.ServiceDependence.Companion.getService");
            return r9;
        L23:
            if (Intrinsics.areEqual(i0.class, r4) == false) goto L27;
            Object r10 = org.koin.java.a.c(i0.class, null, null, 6);
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type T of com.bytedance.ee.bear.lynx.impl.utli.ServiceDependence.Companion.getService");
            return r10;
        L27:
            if (eu5.c.a() == true) goto L31;
            tt5.a.k("ccm-lynx: ServiceDependence", r4.getSimpleName().concat(" unknown"));
            return org.koin.java.a.c(r4, null, null, 6);
        L31:
            throw new IllegalArgumentException(r4.getSimpleName().concat(" unknown"));
        }
    }

    static {
    }
}
