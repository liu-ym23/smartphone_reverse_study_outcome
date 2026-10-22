package re5;

import android.content.Context;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class d extends s66.c {
    public final String c;

    public d() {
        this.c = "ccm.removeStorageItem";
    }

    public String getName() {
        return this.c;
    }

    public final void e(u66.d r2, s66.c.a r3, XBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        if (((Context) provideContext(Context.class)) != null) goto L6;
        r3.a(0, "Context not provided in host");
        return;
    L6:
        String r5 = r2.a;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("key");
        r5 = null;
    L10:
        c.a.a(r5);
        r3.b(new i66.b(), "");
    }
}
