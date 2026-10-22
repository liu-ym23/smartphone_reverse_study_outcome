package re5;

import android.content.Context;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class b extends s66.b {
    public final String c;

    public b() {
        this.c = "ccm.getStorageItem";
    }

    public String getName() {
        return this.c;
    }

    public final void e(u66.b r2, s66.b.a r3, XBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        if (((Context) provideContext(Context.class)) != null) goto L6;
        r3.a();
        return;
    L6:
        String r5 = r2.a;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("key");
        r5 = null;
    L10:
        Object r6 = c.a.d(r5);
        u66.c r7 = new u66.c();
        r7.a = r6;
        r3.b(r7, "");
    }
}
