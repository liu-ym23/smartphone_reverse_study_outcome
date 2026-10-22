package ve7;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostExternalStorageDepend;
import com.huawei.hms.api.FailedBinderCallBack;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getStorageItem")
public final class f extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f554415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.ies.bullet.base.utils.logger.a f554416e;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public f() {
        this.f554415d = "x.getStorageItem";
    }

    public final void a(IBDXBridgeContext r110, b.InterfaceC7993b r111, CompletionBlock<b.c> r112) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r100 = r111.getKey();
        String r101 = r111.getBiz();
        View r102 = r110.getEngineView();
        if (r102 == null) goto L6;
        Context r103 = r102.getContext();
        if (r103 == null) goto L6;
    L7:
        com.bytedance.ies.bullet.base.utils.logger.a r104 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r104.a("session_id", r110.getContainerID());
        r104.a(FailedBinderCallBack.CALLER_ID, r110.getCallId());
        this.f554416e = r104;
        HybridLogger r105 = HybridLogger.f246343a;
        HybridLogger.k("BridgeParam", "x.getStorageItem param", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", r100), TuplesKt.to("biz", r101), TuplesKt.to(PerfLog.PARAM_KEY_CONTEXT_ID, r103)}), this.f554416e);
        if (r103 != null) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L12:
        if (r100.length() != 0) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L18;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "", null, 4, null);
        return;
    L18:
        if (r101 != null) goto L20;
    L23:
        boolean r107 = true;
    L25:
        if (r107 == true) goto L39;
        Intrinsics.checkNotNull(r101);
        String r108 = r110.getContainerID();
        com.bytedance.sdk.xbridge.cn.storage.utils.b r109 = com.bytedance.sdk.xbridge.cn.storage.utils.d.a(r103);
        String r113 = this.f554415d;
        Intrinsics.checkNotNullParameter(r109, "<this>");
        if (r101 != null) goto L29;
    L32:
        boolean r114 = true;
    L33:
        if (r114 == false) goto L35;
    L37:
        Object r115 = r109.e(r100, r113, r108);
    L38:
        HybridLogger.k("BridgeProcessing", "x.getStorageItem biz StorageValue", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", r100), TuplesKt.to("biz", r101), TuplesKt.to("result", r115)}), this.f554416e);
    L46:
        HybridLogger.k("BridgeResult", "x.getStorageItem storageValue", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", r100), TuplesKt.to("storageValue", r115)}), this.f554416e);
        if (r115 != null) goto L49;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Key not found in certain storage", null, 4, null);
        return;
    L49:
        XBaseModel r116 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        ((b.c) r116).setData(ne7.e.a(r115));
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r116, null, 2, null);
        return;
    L35:
        if ((r109 instanceof com.bytedance.sdk.xbridge.cn.storage.utils.a) == false) goto L37;
        Intrinsics.checkNotNull(r101);
        r115 = ((com.bytedance.sdk.xbridge.cn.storage.utils.a) r109).d(r101, r100, r113, r108);
        goto L38
    L29:
        if (r101.length() == 0) goto L32;
        r114 = false;
        goto L33
    L39:
        r115 = com.bytedance.sdk.xbridge.cn.storage.utils.d.a(r103).e(r100, this.f554415d, r110.getContainerID());
        HybridLogger.k("BridgeProcessing", "x.getStorageItem StorageValue", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", r100), TuplesKt.to("result", r115)}), this.f554416e);
        if (r115 != null) goto L46;
        IHostExternalStorageDepend r117 = com.bytedance.sdk.xbridge.cn.utils.g.b();
        if (r117 == null) goto L44;
        r115 = r117.readStorageValue(r100);
    L45:
        HybridLogger.k("BridgeProcessing", "x.getStorageItem hostDepend StorageValue", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", r100), TuplesKt.to("result", r115)}), this.f554416e);
        goto L46
    L44:
        r115 = null;
        goto L45
    L20:
        if (r101.length() == 0) goto L23;
        r107 = false;
        goto L25
    L14:
        r106 = false;
    L6:
        r103 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;
        goto L7
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final /* bridge */ /* synthetic */ void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a(r100, (b.InterfaceC7993b) r101, r102);
    }
}
