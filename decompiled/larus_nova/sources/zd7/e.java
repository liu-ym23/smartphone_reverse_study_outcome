package zd7;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.cancelDownloadFile")
public final class e extends yd7.a {
    public e() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        yd7.a.b r113 = (yd7.a.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        View r114 = r110.getEngineView();
        String r100 = null;
        if (r114 == null) goto L5;
        Context r115 = r114.getContext();
    L6:
        if (r115 != null) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L8:
        boolean r101 = true;
        if (r113.getUrl().length() != 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L30;
        String r103 = r113.getExtension();
        if (r103 != null) goto L16;
    L19:
        if (r101 == true) goto L30;
        File r104 = r115.getExternalCacheDir();
        if (r104 != null) goto L24;
        r104 = r115.getCacheDir();
    L24:
        if (r104 == null) goto L27;
        r100 = r104.getAbsolutePath();
    L27:
        if (r100 != null) goto L29;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "cacheDir is null", null, 4, null);
        return;
    L29:
        com.bytedance.sdk.xbridge.cn.utils.g.a().execute(new d(r115, r113, r100, r112));
        return;
    L16:
        if (r103.length() == 0) goto L19;
        r101 = false;
    L30:
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, null, null, 6, null);
        return;
    L11:
        r102 = false;
        goto L12
    L5:
        r115 = null;
        goto L6
    }
}
