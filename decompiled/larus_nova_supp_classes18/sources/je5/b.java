package je5;

import android.content.Context;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import ie5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends p66.a {
    public final com.bytedance.ee.bear.lynx.impl.route.c b;
    public final String c;

    public final String getName() {
        return this.c;
    }

    public b(com.bytedance.ee.bear.lynx.impl.route.c r2) {
        Intrinsics.checkNotNullParameter(r2, "routerAbilityProvider");
        this.b = r2;
        this.c = "ccm.closePage";
    }

    public final void e(q66.a r2, p66.a.a r3, XBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        if (((Context) provideContext(Context.class)) != null) goto L6;
        r3.a();
        return;
    L6:
        int r5 = j.a;
        com.bytedance.ee.bear.lynx.impl.route.c r6 = this.b;
        Intrinsics.checkNotNullParameter(r6, "routerAbilityProvider");
        r6.close();
        r3.b(new i66.b(), "");
    }
}
