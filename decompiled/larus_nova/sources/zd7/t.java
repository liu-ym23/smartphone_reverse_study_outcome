package zd7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getAbsolutePath")
public final class t extends yd7.f {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public t() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        yd7.f.b r102 = (yd7.f.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (r100.getOwnerActivity() != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "invalid bridgeContext， owner activity is null", null, 4, null);
        return;
    L5:
        String r103 = r102.getRelativePath();
        ae7.a r104 = ae7.a.f3109a;
        Activity r105 = r100.getOwnerActivity();
        Intrinsics.checkNotNull(r105);
        r104.getClass();
        String r106 = ae7.a.a(r105, r103);
        boolean r107 = false;
        if (r106 != null) goto L8;
    L11:
        boolean r108 = true;
    L12:
        if (r108 == true) goto L14;
        Activity r109 = r100.getOwnerActivity();
        Intrinsics.checkNotNull(r109);
        r107 = ae7.a.e(r109, r106);
    L14:
        XBaseModel r111 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.f.c.class));
        yd7.f.c r112 = (yd7.f.c) r111;
        r112.setFileExist(Boolean.valueOf(r107));
        r112.setAbsolutePath(r106);
        CompletionBlock.DefaultImpls.onSuccess$default(r110, (XBaseResultModel) r111, null, 2, null);
        return;
    L8:
        if (r106.length() == 0) goto L11;
        r108 = false;
        goto L12
    }
}
