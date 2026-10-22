package ve7;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostExternalStorageDepend;
import com.huawei.hms.api.FailedBinderCallBack;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.setStorageItem")
public final class h extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f554417d;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public h() {
        this.f554417d = "x.setStorageItem";
    }

    public final void a(IBDXBridgeContext r210, d.b r211, CompletionBlock<d.c> r212) {
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r211, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        View r100 = r210.getEngineView();
        if (r100 == null) goto L6;
        Context r101 = r100.getContext();
        if (r101 == null) goto L6;
    L7:
        String r110 = r211.getKey();
        Object r111 = r211.getData();
        String r112 = r211.getBiz();
        com.bytedance.ies.bullet.base.utils.logger.a r113 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r113.a("session_id", r210.getContainerID());
        r113.a(FailedBinderCallBack.CALLER_ID, r210.getCallId());
        HybridLogger r102 = HybridLogger.f246343a;
        boolean r114 = false;
        String r103 = "data";
        HybridLogger.k("BridgeParam", this.f554417d + " param", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", r110), TuplesKt.to("data", r111), TuplesKt.to("biz", r112), TuplesKt.to(PerfLog.PARAM_KEY_CONTEXT_ID, String.valueOf(r101))}), r113);
        if (r101 != null) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r212, 0, "Context not provided in host", null, 4, null);
        return;
    L12:
        if (r110.length() != 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L18;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "The key should not be empty.", null, 4, null);
        return;
    L18:
        String r115 = r210.getContainerID();
        com.bytedance.sdk.xbridge.cn.storage.utils.b r105 = com.bytedance.sdk.xbridge.cn.storage.utils.d.a(r101);
        String r106 = this.f554417d;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        if (r112 != null) goto L21;
    L24:
        boolean r107 = true;
    L25:
        if (r107 == false) goto L27;
    L29:
        boolean r108 = r105.g(r110, r111, null, r106, r115);
    L30:
        HybridLogger.k("BridgeResult", this.f554417d + " save storageValue", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", r110), TuplesKt.to(r103, r111), TuplesKt.to("biz", r112), TuplesKt.to("success", Boolean.valueOf(r108))}), r113);
        if (r112 != null) goto L33;
    L36:
        boolean r109 = true;
    L37:
        if (r109 == true) goto L39;
    L49:
        if (r108 == false) goto L51;
        CompletionBlock.DefaultImpls.onSuccess$default(r212, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(d.c.class), null, 2, null);
        return;
    L51:
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "Illegal value type", null, 4, null);
        return;
    L39:
        if ((r111 instanceof String) == false) goto L49;
        IHostExternalStorageDepend r116 = com.bytedance.sdk.xbridge.cn.utils.g.b();
        if (r116 == null) goto L43;
        boolean r117 = r116.setStorageValue(r110, r111);
    L44:
        HybridLogger.k("BridgeResult", this.f554417d + " save hostDepend storageValue", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", r110), TuplesKt.to(r103, r111), TuplesKt.to("biz", r112), TuplesKt.to("localSuccess", Boolean.valueOf(r117))}), r113);
        if (r117 == true) goto L47;
        if (r108 == true) goto L47;
    L48:
        r108 = r114;
    L47:
        r114 = true;
        goto L48
    L43:
        r117 = false;
        goto L44
    L33:
        if (r112.length() == 0) goto L36;
        r109 = false;
        goto L37
    L27:
        if ((r105 instanceof com.bytedance.sdk.xbridge.cn.storage.utils.a) == false) goto L29;
        Intrinsics.checkNotNull(r112);
        r108 = ((com.bytedance.sdk.xbridge.cn.storage.utils.a) r105).f(r112, r110, r111, null, r106, r115);
        r103 = "data";
        goto L30
    L21:
        if (r112.length() == 0) goto L24;
        r107 = false;
        goto L25
    L14:
        r104 = false;
    L6:
        r101 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;
        goto L7
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final /* bridge */ /* synthetic */ void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a(r100, (d.b) r101, r102);
    }
}
