package je5;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import ie5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends p66.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.lynx.impl.route.c f498824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f498825c;

    @Override // p66.a, com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f498825c;
    }

    public b(com.bytedance.ee.bear.lynx.impl.route.c r100) {
        Intrinsics.checkNotNullParameter(r100, "routerAbilityProvider");
        this.f498824b = r100;
        this.f498825c = "ccm.closePage";
    }

    @Override // p66.a
    public final void e(q66.a r100, p66.a.C7156a r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        if (((Context) provideContext(Context.class)) != null) goto L6;
        r101.a();
        return;
    L6:
        int r103 = j.f489486a;
        com.bytedance.ee.bear.lynx.impl.route.c r104 = this.f498824b;
        Intrinsics.checkNotNullParameter(r104, "routerAbilityProvider");
        r104.close();
        r101.b(new i66.b(), "");
    }
}
