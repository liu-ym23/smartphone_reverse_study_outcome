package zd7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.removeInternalFile")
public final class u extends yd7.g {

    public static final class a {
    }

    static {
    }

    public u() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        yd7.g.b r113 = (yd7.g.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r114 = r113.getAbsolutePath();
        Activity r115 = r110.getOwnerActivity();
        if (r115 != null) goto L6;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -10, "context is invalid", null, 4, null);
        return;
    L6:
        if (r114.length() != 0) goto L8;
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "absolutePath can not be empty", null, 4, null);
        return;
    L11:
        String[] r101 = new String[2];
        r101[0] = r115.getCacheDir().getAbsolutePath();
        File r116 = r115.getExternalCacheDir();
        if (r116 == null) goto L14;
        String r117 = r116.getAbsolutePath();
    L15:
        if (r117 != null) goto L17;
        r117 = "INVALID_PATH";
    L17:
        r101[1] = r117;
        Iterator r118 = CollectionsKt.listOf(r101).iterator();
        boolean r102 = false;
    L19:
        if (r118.hasNext() == false) goto L23;
        if (StringsKt.startsWith$default(r114, (String) r118.next(), false, 2, null) == false) goto L19;
        r102 = true;
        goto L19
    L23:
        if (r102 == true) goto L25;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 14, "non internal file is not support", null, 4, null);
        return;
    L25:
        PolarisFileWrapper r119 = new PolarisFileWrapper(r114);
        if (r119.exists() == true) goto L29;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 11, "file not exist", null, 4, null);
        return;
    L29:
        if (r119.isDirectory() == false) goto L32;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 12, "directory is not support", null, 4, null);
        return;
    L32:
        if (r119.delete() == true) goto L34;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 13, "delete file fail", null, 4, null);
        return;
    L34:
        r112.onSuccess((XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.g.c.class)), "success");
        return;
    L14:
        r117 = null;
        goto L15
    L8:
        r100 = false;
        goto L9
    }
}
