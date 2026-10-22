package wd7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.reportALog")
public final class g extends b {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public g() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        b.c r100 = (b.c) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r101 = r100.getLevel();     // Catch: NullPointerException -> L29
        if (r101 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L27;
        String r103 = r100.getMessage();     // Catch: NullPointerException -> L29
        if (r103 != null) goto L14;
    L17:
        boolean r104 = true;
    L18:
        if (r104 == true) goto L27;
        String r105 = r100.getTag();     // Catch: NullPointerException -> L29
        if (r105 != null) goto L22;
    L25:
        boolean r106 = true;
    L26:
        if (r106 == true) goto L27;
    L30:
        String r113 = r100.getMessage();
        String r114 = r100.getTag();
        String r115 = r100.getLevel();
        b.InterfaceC8095b r107 = r100.getCodePosition();
        if (r107 == null) goto L33;
        int r108 = r107.getLine().intValue();
        String r109 = r107.getFunction();
        String r116 = r107.getFile();
        String r117 = r109;
        int r118 = r108;
    L39:
        xd7.a.a(r113, r114, r115, r116, r117, r118);     // Catch: IllegalArgumentException -> L36
        XBaseModel r119 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.d.class));     // Catch: IllegalArgumentException -> L36
        b.d r120 = (b.d) r119;     // Catch: IllegalArgumentException -> L36
        r120.setCode(1);     // Catch: IllegalArgumentException -> L36
        r120.setMsg("");     // Catch: IllegalArgumentException -> L36
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r119, null, 2, null);     // Catch: IllegalArgumentException -> L36
        return;
    L36:
        e = move-exception;
        id7.c.a(String.valueOf(e.getMessage()));
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "Level is illegal!", null, 4, null);
        return;
    L33:
        r116 = "";
        r117 = r116;
        r118 = 0;
        goto L39
    L22:
        if (r105.length() == 0) goto L25;
        r106 = false;
        goto L26
    L14:
        if (r103.length() == 0) goto L17;
        r104 = false;
    L27:
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, null, null, 6, null);     // Catch: NullPointerException -> L29
        goto L30
    L6:
        if (r101.length() == 0) goto L9;
        r102 = false;
    L29:
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, null, null, 6, null);
        goto L30
    }
}
