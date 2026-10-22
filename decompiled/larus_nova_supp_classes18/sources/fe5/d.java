package fe5;

import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntime;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntimeFactory;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeProtocolBuilderContext;
import com.ss.android.lark.lynxkit.xbridge.XBridgeLynxKitRuntime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements ILarkLynxBridgeRuntimeFactory {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final ILarkLynxBridgeRuntime create(LarkLynxBridgeProtocolBuilderContext r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return new XBridgeLynxKitRuntime("ccm-bridge");
    }
}
