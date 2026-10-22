package com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.idl_bridge;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import defpackage.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ne7.e;

/* JADX INFO: loaded from: classes40.dex */
@XBridgeMethod(name = "ecom.reportContextStateLog")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl_bridge/EcomReportContextStateLogMethod;", "Lc;", "Lcom/bytedance/sdk/xbridge/cn/protocol/h;", "<init>", "()V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EcomReportContextStateLogMethod extends c implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f450305c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl_bridge/EcomReportContextStateLogMethod$Companion;", "", "()V", "CODE_INVALID_PARAMS", "", "CODE_REPORT_FAILED", "TAG", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public EcomReportContextStateLogMethod() {
        this.f450305c = "ecom.reportContextStateLog";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f450305c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        c.b r112 = (c.b) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        IECAIHostService.Companion.getClass();     // Catch: Exception -> L40
        IECAIHostService r101 = IECAIHostService.a.a();     // Catch: Exception -> L40
        Map<String, Object> r113 = r112.getStateLog();     // Catch: Exception -> L40
        Object r102 = r113.get("app_key");     // Catch: Exception -> L40
        if ((r102 instanceof String) == true) goto L6;
        r102 = null;
    L6:
        String r103 = (String) r102;     // Catch: Exception -> L40
        if (r103 != null) goto L10;
        String r104 = "";
    L11:
        Object r105 = r113.get("biz_task_id");     // Catch: Exception -> L40
        if ((r105 instanceof String) == true) goto L14;
        r105 = null;
    L14:
        String r106 = (String) r105;     // Catch: Exception -> L40
        if (r106 != null) goto L17;
        String r107 = "";
    L18:
        Object r108 = r113.get("content");     // Catch: Exception -> L40
        if ((r108 instanceof String) == true) goto L21;
        r108 = null;
    L21:
        String r109 = (String) r108;     // Catch: Exception -> L40
        if (r109 != null) goto L24;
        String r114 = "";
    L25:
        Object r115 = r113.get("source");     // Catch: Exception -> L40
        if ((r115 instanceof String) == true) goto L28;
        r115 = null;
    L28:
        String r116 = (String) r115;     // Catch: Exception -> L40
        if (r116 != null) goto L31;
        String r117 = "";
    L32:
        Object r118 = r113.get(a.KEY_PAGE_ID);     // Catch: Exception -> L40
        if ((r118 instanceof String) == true) goto L35;
        r118 = null;
    L35:
        String r119 = (String) r118;     // Catch: Exception -> L40
        if (r119 != null) goto L38;
        r119 = "";
    L38:
        r101.reportLog(new AIStateLogRequest(r104, r107, r114, r117, r119));     // Catch: Exception -> L40
        CompletionBlock.DefaultImpls.onSuccess$default(r111, (XBaseResultModel) e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC0384c.class)), null, 2, null);     // Catch: Exception -> L40
        return;
    L31:
        r117 = r116;
        goto L32
    L24:
        r114 = r109;
        goto L25
    L17:
        r107 = r106;
        goto L18
    L10:
        r104 = r103;
    L40:
        e = move-exception;
        Logger.c("EcomReportContextStateLog", this.f450305c + " reportLog failed", e);
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, String.valueOf(e.getMessage()), null, 4, null);
    }
}
