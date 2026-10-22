package l26;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import h16.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(name = "bullet.preloadResource", owner = "liushaocong")
public final class d extends b {
    public d() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        b.a r103 = (b.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getBid();     // Catch: Exception -> L32
        boolean r105 = true;
        if (r104 != null) goto L6;
    L9:
        boolean r106 = true;
    L10:
        if (r106 == false) goto L19;
        Map<String, m16.b> r107 = c36.a.f22277a;     // Catch: Exception -> L32
        e r108 = (e) c36.a.a(r100.getContainerID()).c(e.class);     // Catch: Exception -> L32
        if (r108 == null) goto L17;
        BulletContext r109 = r108.getBulletContext();     // Catch: Exception -> L32
        if (r109 == null) goto L17;
        String r110 = r109.f246438f;     // Catch: Exception -> L32
        if (r110 == null) goto L17;
    L18:
        r104 = r110;
    L17:
        r110 = "default_bid";
    L19:
        String r111 = r103.getSchema();     // Catch: Exception -> L32
        if (r111 != null) goto L22;
    L25:
        if (r105 == true) goto L27;
        boolean r112 = PreloadV2.f247628a;     // Catch: Exception -> L32
        Intrinsics.checkNotNullParameter(r111, "schema");     // Catch: Exception -> L32
        Intrinsics.checkNotNullParameter(r104, "targetBid");     // Catch: Exception -> L32
        PreloadV2.g(r111, r104, false, false);     // Catch: Exception -> L32
    L30:
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(b.InterfaceC6643b.class)), null, 2, null);     // Catch: Exception -> L32
        return;
    L27:
        Map<String, Object> r113 = r103.getConfig();     // Catch: Exception -> L32
        if (r113 == null) goto L30;
        boolean r114 = PreloadV2.f247628a;     // Catch: Exception -> L32
        PreloadV2.f(new com.bytedance.ies.bullet.preloadv2.a(new JSONObject(r113)), r104);     // Catch: Exception -> L32
        goto L30
    L22:
        if (r111.length() == 0) goto L25;
        r105 = false;
        goto L25
    L6:
        if (r104.length() == 0) goto L9;
        r106 = false;
    L32:
        e = move-exception;
        CompletionBlock.DefaultImpls.onFailure$default(r102, -1, e.toString(), null, 4, null);
    }
}
