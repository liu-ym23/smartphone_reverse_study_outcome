package tl2;

import com.bytedance.android.live.browser.jsbridge.newmethods.n6;
import com.bytedance.android.live.browser.jsbridge.newmethods.y5;
import com.bytedance.android.live.browser.jsbridge.newmethods.y6;
import com.bytedance.android.livesdk.livehybrid.middleware.api.LiveHybridMethodLiveHybridMiddlewareProvider;
import com.bytedance.ies.web.jsbridge2.f;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class a extends LiveHybridMethodLiveHybridMiddlewareProvider {
    public a() {
    }

    @Override // sl2.b
    public void provideStatefulMethods(Map<String, f.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        r100.put("live.shortTouchFeatureUpdate", createProvider(y6.class));
        r100.put("live.CEPEventUpdate", createProvider(y5.class));
        r100.put("live.highlightTranscoding", createProvider(n6.class));
    }
}
