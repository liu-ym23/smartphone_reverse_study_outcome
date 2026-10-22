package fe5;

import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntime;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntimeFactory;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeProtocolBuilderContext;
import com.ss.android.lark.lynxkit.xbridge.XBridgeLynxKitRuntime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements ILarkLynxBridgeRuntimeFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f476592a = null;

    static {
        f476592a = new d();
    }

    public d() {
    }

    @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntimeFactory
    public final ILarkLynxBridgeRuntime create(LarkLynxBridgeProtocolBuilderContext r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return new XBridgeLynxKitRuntime("ccm-bridge");
    }
}
