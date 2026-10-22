package ge7;

import android.app.Activity;
import android.content.ClipData;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.depend.d;
import com.bytedance.sdk.xbridge.cn.runtime.depend.g;
import id7.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.copy")
public final class a extends fe7.a {

    /* JADX INFO: renamed from: ge7.a$a, reason: collision with other inner class name */
    public static final class C6016a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        fe7.a.b r113 = (fe7.a.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        boolean r100 = false;
        if (r113.getContent().length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "The content parameter should not be empty.", null, 4, null);
        return;
    L8:
        String r102 = r113.getContent();
        Activity r103 = r110.getOwnerActivity();     // Catch: Exception -> L28
        if (r103 != null) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "context is null", null, 4, null);     // Catch: Exception -> L28
        return;
    L12:
        XBaseRuntime r104 = XBaseRuntime.f270095a;     // Catch: Exception -> L28
        r104.getClass();     // Catch: Exception -> L28
        g r105 = XBaseRuntime.f270111q;     // Catch: Exception -> L28
        if (r105 == null) goto L15;
        r105.e(r103, r110, this.f476615a, ClipData.newPlainText(r102, r102));     // Catch: Exception -> L28
    L15:
        if (r105 != null) goto L17;
    L19:
        if (r100 == true) goto L21;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "no permission to copy", null, 4, null);     // Catch: Exception -> L28
        return;
    L21:
        r112.onSuccess((XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(fe7.a.c.class), "success");     // Catch: Exception -> L28
        Boolean r114 = r113.isCached();     // Catch: Exception -> L28
        if (Intrinsics.areEqual(r114, Boolean.TRUE) == false) goto L35;
        int r106 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;     // Catch: Exception -> L28
        r104.getClass();     // Catch: Exception -> L28
        d r107 = XBaseRuntime.f270115u;     // Catch: Exception -> L28
        if (r107 != null) goto L26;
        c.b("cacheDepend is null", r110.getContainerID());     // Catch: Exception -> L28
        return;
    L26:
        r114.booleanValue();     // Catch: Exception -> L28
        r107.a();     // Catch: Exception -> L28
        c.b("trigger cacheDepend.onSaveText with isCached=" + r114 + ", content=" + r102, r110.getContainerID());     // Catch: Exception -> L28
        return;
    L35:
        return;
    L17:
        if (r105.a(r103, r110, this.f476615a) != true) goto L19;
        r100 = true;
    L28:
        e = move-exception;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, String.valueOf(e.getMessage()), null, 4, null);
        return;
    L5:
        r101 = false;
        goto L6
    }
}
