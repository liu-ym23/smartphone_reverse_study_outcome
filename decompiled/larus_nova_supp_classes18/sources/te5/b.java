package te5;

import android.webkit.ValueCallback;
import com.bytedance.ee.bear.lynx.api.g;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends XCoreBridgeMethod {
    public final String a;

    public static final class a<T> implements ValueCallback {
        public final /* synthetic */ b a;
        public final /* synthetic */ XBridgeMethod.Callback b;

        public a(b r1, XBridgeMethod.Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r7) {
            XCoreBridgeMethod.onSuccess$default(this.a, this.b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(WikiFolderPushPlugin.DATA, (String) r7)}), null, 4, null);
        }
    }

    public b() {
        this.a = "ccm.callJSMethod";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r3, XBridgeMethod.Callback r4, XBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TYPE);
        g r6 = (g) provideContext(g.class);
        if (r6 == null) goto L6;
        r6.b(r3.getString("method"), r3.getString("params"), new a(this, r4));
        return;
    }
}
