package it2;

import com.bytedance.android.livesdk.livehybrid.middleware.api.LiveHybridMethodSoloKtvProvider;
import com.bytedance.ies.web.jsbridge2.f;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class a extends LiveHybridMethodSoloKtvProvider {
    public a() {
    }

    @Override // sl2.b
    public void provideStatefulMethods(Map<String, f.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        r100.put("lynxReportResponse", createProvider(za1.a.class));
    }
}
