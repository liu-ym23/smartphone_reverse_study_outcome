package ge7;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.depend.g;
import id7.e;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getClipboardData")
public final class b extends fe7.b {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return false;
    L6:
        return true;
    }

    public b() {
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, id7.b> r100 = e.f489350a;
        e.a(b.class, new id7.b(fe7.b.InterfaceC5889b.class, fe7.b.c.class));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((fe7.b.InterfaceC5889b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Activity r103 = r100.getOwnerActivity();     // Catch: Exception -> L34
        if (r103 != null) goto L6;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "context is null", null, 4, null);     // Catch: Exception -> L34
        return;
    L6:
        XBaseRuntime.f270095a.getClass();     // Catch: Exception -> L34
        g r104 = XBaseRuntime.f270111q;     // Catch: Exception -> L34
        String r105 = null;
        if (r104 == null) goto L9;
        ClipData r106 = r104.b(r103, r100, this.f476618a);     // Catch: Exception -> L34
    L10:
        if (r106 == null) goto L13;
        Integer r107 = Integer.valueOf(r106.getItemCount());     // Catch: Exception -> L34
    L15:
        if (r107 != null) goto L18;
    L20:
        if (r106 == null) goto L22;
        ClipData.Item r108 = r106.getItemAt(0);     // Catch: Exception -> L34
    L23:
        if (r108 == null) goto L25;
        CharSequence r109 = r108.getText();     // Catch: Exception -> L34
    L27:
        if (Intrinsics.areEqual("", r109) == false) goto L29;
        r109 = null;
    L29:
        XBaseModel r110 = ne7.e.b(fe7.b.c.class);     // Catch: Exception -> L34
        fe7.b.c r111 = (fe7.b.c) r110;     // Catch: Exception -> L34
        if (r109 == null) goto L32;
        r105 = r109.toString();     // Catch: Exception -> L34
    L32:
        r111.setText(r105);     // Catch: Exception -> L34
        r102.onSuccess((XBaseResultModel) r110, "success");     // Catch: Exception -> L34
        return;
    L25:
        r109 = null;
        goto L27
    L22:
        r108 = null;
        goto L23
    L18:
        if (r107.intValue() != 0) goto L20;
        r102.onSuccess((XBaseResultModel) ne7.e.b(fe7.b.c.class), "success");     // Catch: Exception -> L34
        goto L20
    L13:
        r107 = null;
        goto L15
    L9:
        r106 = null;
    L34:
        e = move-exception;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, String.valueOf(e.getMessage()), null, 4, null);
    }
}
