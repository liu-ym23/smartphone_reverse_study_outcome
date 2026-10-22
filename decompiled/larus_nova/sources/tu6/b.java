package tu6;

import com.bytedance.locallife.hybrid.xbridge.depend.runtime3.BDXHostStyleUIDependImpl;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPureNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.depend.f;
import kotlin.jvm.internal.Intrinsics;
import vu6.c;
import vu6.d;
import vu6.e;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    static {
    }

    public static void a() {
        XBaseRuntime.f270095a.getClass();
        IHostRouterDepend r100 = XBaseRuntime.f270102h;
        if (r100 != null) goto L5;
    L8:
        IHostStyleUIDepend r101 = XBaseRuntime.f270101g;
        if (r101 != null) goto L11;
    L14:
        IHostNetworkDepend r102 = XBaseRuntime.f270104j;
        if (r102 != null) goto L17;
    L20:
        IHostPureNetworkDepend r103 = XBaseRuntime.f270106l;
        if (r103 != null) goto L23;
    L26:
        f r104 = XBaseRuntime.f270105k;
        if (r104 != null) goto L29;
        return;
    L29:
        if (Intrinsics.areEqual(r104.getClass(), vu6.b.class) == true) goto L34;
        vu6.b r105 = new vu6.b(r104);
        Intrinsics.checkNotNullParameter(r105, "hostNetworkDependV2");
        XBaseRuntime.f270105k = r105;
        return;
    L34:
        return;
    L23:
        if (Intrinsics.areEqual(r103.getClass(), c.class) == true) goto L26;
        c r106 = new c(r103);
        Intrinsics.checkNotNullParameter(r106, "hostPureNetworkDepend");
        XBaseRuntime.f270106l = r106;
        goto L26
    L17:
        if (Intrinsics.areEqual(r102.getClass(), vu6.a.class) == true) goto L20;
        vu6.a r107 = new vu6.a(r102);
        Intrinsics.checkNotNullParameter(r107, "hostNetworkDepend");
        XBaseRuntime.f270104j = r107;
        goto L20
    L11:
        if (Intrinsics.areEqual(r101.getClass(), e.class) == true) goto L14;
        e r108 = new e(r101, new BDXHostStyleUIDependImpl());
        Intrinsics.checkNotNullParameter(r108, "hostStyleUIDepend");
        XBaseRuntime.f270101g = r108;
        goto L14
    L5:
        if (Intrinsics.areEqual(r100.getClass(), d.class) == true) goto L8;
        d r109 = new d(r100);
        Intrinsics.checkNotNullParameter(r109, "hostRouterDepend");
        XBaseRuntime.f270102h = r109;
        goto L8
    }
}
