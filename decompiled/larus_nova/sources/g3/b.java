package g3;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.core.adapter.XBridge3ToAIBridgeAdapter;
import com.ivy.ivykit.api.bridge.IBridgeMethodService;
import f3.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements l {
    public b() {
    }

    @Override // f3.l
    public final AIBridgeMethod a(String r100, ContainerType r101) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "aiContainerType");
        bx7.b r102 = IBridgeMethodService.f278290a.a(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return new XBridge3ToAIBridgeAdapter(r102);
    }
}
