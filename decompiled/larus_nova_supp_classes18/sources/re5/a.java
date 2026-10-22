package re5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends s66.a {
    public final String c;

    public a() {
        this.c = "ccm.getStorageInfo";
    }

    public final String getName() {
        return this.c;
    }

    public final void e(com.bytedance.ies.xbridge.model.params.b r2, s66.a.a r3, XBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        r3.a("android is not support");
    }
}
