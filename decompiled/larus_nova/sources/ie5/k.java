package ie5;

import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.i0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f489487a = 0;

    public static final class a {
        public static Object a(Class r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            if (Intrinsics.areEqual(b0.class, r100) == false) goto L7;
            Object r101 = org.koin.java.a.c(b0.class, null, null, 6);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type T of com.bytedance.ee.bear.lynx.impl.utli.ServiceDependence.Companion.getService");
            return r101;
        L7:
            if (Intrinsics.areEqual(com.bytedance.ee.bear.contract.d.class, r100) == false) goto L11;
            Object r102 = org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type T of com.bytedance.ee.bear.lynx.impl.utli.ServiceDependence.Companion.getService");
            return r102;
        L11:
            if (Intrinsics.areEqual(NetService.class, r100) == false) goto L15;
            Object r103 = org.koin.java.a.c(NetService.class, null, null, 6);
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type T of com.bytedance.ee.bear.lynx.impl.utli.ServiceDependence.Companion.getService");
            return r103;
        L15:
            if (Intrinsics.areEqual(ConnectionService.class, r100) == false) goto L19;
            com.bytedance.ee.bear.contract.j r104 = com.bytedance.ee.bear.contract.j.a.f217090a;
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type T of com.bytedance.ee.bear.lynx.impl.utli.ServiceDependence.Companion.getService");
            return r104;
        L19:
            if (Intrinsics.areEqual(com.bytedance.ee.bear.lark.dependency.k.class, r100) == false) goto L23;
            Object r105 = org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.k.class, null, null, 6);
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type T of com.bytedance.ee.bear.lynx.impl.utli.ServiceDependence.Companion.getService");
            return r105;
        L23:
            if (Intrinsics.areEqual(i0.class, r100) == false) goto L27;
            Object r106 = org.koin.java.a.c(i0.class, null, null, 6);
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type T of com.bytedance.ee.bear.lynx.impl.utli.ServiceDependence.Companion.getService");
            return r106;
        L27:
            if (eu5.c.a() == true) goto L31;
            tt5.a.k("ccm-lynx: ServiceDependence", r100.getSimpleName().concat(" unknown"));
            return org.koin.java.a.c(r100, null, null, 6);
        L31:
            throw new IllegalArgumentException(r100.getSimpleName().concat(" unknown"));
        }
    }

    static {
    }
}
