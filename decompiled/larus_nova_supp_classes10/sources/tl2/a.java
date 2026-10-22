package tl2;

import com.bytedance.android.live.browser.jsbridge.newmethods.n6;
import com.bytedance.android.live.browser.jsbridge.newmethods.y5;
import com.bytedance.android.live.browser.jsbridge.newmethods.y6;
import com.bytedance.android.livesdk.livehybrid.middleware.api.LiveHybridMethodLiveHybridMiddlewareProvider;
import com.bytedance.ies.web.jsbridge2.f;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class a extends LiveHybridMethodLiveHybridMiddlewareProvider {
    public a() {
    }

    @Override // sl2.b
    public void provideStatefulMethods(Map<String, f.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        r3.put("live.shortTouchFeatureUpdate", createProvider(y6.class));
        r3.put("live.CEPEventUpdate", createProvider(y5.class));
        r3.put("live.highlightTranscoding", createProvider(n6.class));
    }
}
