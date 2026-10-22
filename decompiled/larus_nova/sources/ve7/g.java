package ve7;

import android.app.Activity;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostExternalStorageDepend;
import com.huawei.hms.api.FailedBinderCallBack;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.removeStorageItem")
public final class g extends c {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public g() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        c.b r100 = (c.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r101 = r110.getOwnerActivity();
        com.bytedance.ies.bullet.base.utils.logger.a r102 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r102.a("session_id", r110.getContainerID());
        r102.a(FailedBinderCallBack.CALLER_ID, r110.getCallId());
        if (r101 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L5:
        String r103 = r100.getKey();
        String r104 = r100.getBiz();
        HybridLogger r105 = HybridLogger.f246343a;
        HybridLogger.k("BridgeParam", "x.removeStorageItem param", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", r103), TuplesKt.to("biz", r104)}), r102);
        if (r103 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "", null, 4, null);
        return;
    L14:
        if (r104 != null) goto L16;
    L19:
        boolean r107 = true;
    L21:
        if (r107 == false) goto L27;
        IHostExternalStorageDepend r108 = com.bytedance.sdk.xbridge.cn.utils.g.b();
        if (r108 == null) goto L25;
        Boolean r109 = Boolean.valueOf(r108.removeStorageValue(r103));
    L26:
        HybridLogger.k("BridgeResult", "x.removeStorageItem removeHostDepend data", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", r103), TuplesKt.to("result", r109)}), r102);
        goto L27
    L25:
        r109 = null;
    L27:
        com.bytedance.sdk.xbridge.cn.storage.utils.b r113 = com.bytedance.sdk.xbridge.cn.storage.utils.d.a(r101);
        Intrinsics.checkNotNullParameter(r113, "<this>");
        if (r104 != null) goto L30;
    L33:
        boolean r114 = true;
    L34:
        if (r114 == false) goto L36;
    L38:
        boolean r115 = r113.a(r103);
    L39:
        HybridLogger.k("BridgeResult", "x.removeStorageItem data", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", r103), TuplesKt.to("result", Boolean.valueOf(r115))}), r102);
        if (r115 == false) goto L42;
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(c.InterfaceC7994c.class), null, 2, null);
        return;
    L42:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 2, "Key is not found in certain storage", null, 4, null);
        return;
    L36:
        if ((r113 instanceof com.bytedance.sdk.xbridge.cn.storage.utils.a) == false) goto L38;
        Intrinsics.checkNotNull(r104);
        r115 = ((com.bytedance.sdk.xbridge.cn.storage.utils.a) r113).b(r104, r103);
        goto L39
    L30:
        if (r104.length() == 0) goto L33;
        r114 = false;
        goto L34
    L16:
        if (r104.length() == 0) goto L19;
        r107 = false;
        goto L21
    L8:
        if (r103.length() == 0) goto L11;
        r106 = false;
        goto L12
    }
}
