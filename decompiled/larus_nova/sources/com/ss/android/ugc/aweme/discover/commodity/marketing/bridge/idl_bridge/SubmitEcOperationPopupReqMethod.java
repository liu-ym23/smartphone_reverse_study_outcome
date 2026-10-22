package com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.idl_bridge;

import android.os.SystemClock;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.idl.AbsEcSubmitEcOperationPopupReqMethodIDL;
import com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.popup.PopupArbiter;
import com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.popup.PopupCandidate;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import ne7.e;

/* JADX INFO: loaded from: classes40.dex */
@XBridgeMethod(name = "ec.submitEcOperationPopupReq")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl_bridge/SubmitEcOperationPopupReqMethod;", "Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/idl/AbsEcSubmitEcOperationPopupReqMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/protocol/h;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SubmitEcOperationPopupReqMethod extends AbsEcSubmitEcOperationPopupReqMethodIDL implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f450309c;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public SubmitEcOperationPopupReqMethod() {
        this.f450309c = "ec.submitEcOperationPopupReq";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f450309c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r210, XBaseParamModel r211, final CompletionBlock r212) {
        AbsEcSubmitEcOperationPopupReqMethodIDL.EcSubmitEcOperationPopupReqParamModel r100 = (AbsEcSubmitEcOperationPopupReqMethodIDL.EcSubmitEcOperationPopupReqParamModel) r211;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        long r110 = SystemClock.elapsedRealtime();
        Logger.d("PopupArbiter", "[t=" + r110 + "] jsb: " + this.f450309c + " 收到前端调用: searchId=" + r100.getSearchId() + ", scene=" + r100.getScene() + ", bizId=" + r100.getBizId() + ", priority=" + r100.getPriority() + ", isLastPopup=" + r100.isLastPopup() + ", timestamp=" + r100.getTimestamp());     // Catch: Exception -> L24
        String r111 = r100.getSearchId();     // Catch: Exception -> L24
        String r112 = r100.getScene();     // Catch: Exception -> L24
        String r101 = r100.getBizId();     // Catch: Exception -> L24
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        String r113 = r101;
        int r114 = r100.getPriority().intValue();     // Catch: Exception -> L24
        Number r102 = r100.isLastPopup();     // Catch: Exception -> L24
        if (r102 == null) goto L11;
        boolean r103 = true;
        if (r102.intValue() != 1) goto L11;
    L12:
        Number r104 = r100.getTimestamp();     // Catch: Exception -> L24
        if (r104 == null) goto L15;
        long r115 = r104.longValue();     // Catch: Exception -> L24
    L17:
        if (StringsKt.isBlank(r111) == false) goto L19;
    L22:
        Logger.b("PopupArbiter", "jsb: " + this.f450309c + " 参数非法 invalid_params, searchId=" + r111 + ", scene=" + r112);     // Catch: Exception -> L24
        XBaseModel r105 = e.c(Reflection.getOrCreateKotlinClass(AbsEcSubmitEcOperationPopupReqMethodIDL.EcSubmitEcOperationPopupReqResultModel.class));     // Catch: Exception -> L24
        AbsEcSubmitEcOperationPopupReqMethodIDL.EcSubmitEcOperationPopupReqResultModel r106 = (AbsEcSubmitEcOperationPopupReqMethodIDL.EcSubmitEcOperationPopupReqResultModel) r105;     // Catch: Exception -> L24
        r106.setShowPopup(0);     // Catch: Exception -> L24
        r106.setReason("invalid_params");     // Catch: Exception -> L24
        Unit r107 = Unit.INSTANCE;     // Catch: Exception -> L24
        CompletionBlock.DefaultImpls.onSuccess$default(r212, (XBaseResultModel) r105, null, 2, null);     // Catch: Exception -> L24
        return;
    L19:
        if (StringsKt.isBlank(r112) == true) goto L22;
        PopupArbiter r108 = PopupArbiter.f450321d;     // Catch: Exception -> L24
        PopupCandidate r109 = new PopupCandidate(r111, r112, r113, r114, r103, r115, r110, new AnonymousClass2(this, r212));     // Catch: Exception -> L24
        r108.getClass();     // Catch: Exception -> L24
        PopupArbiter.d(r109);     // Catch: Exception -> L24
        return;
    L15:
        r115 = System.currentTimeMillis();     // Catch: Exception -> L24
    L11:
        r103 = false;
    L24:
        e = move-exception;
        Logger.c("PopupArbiter", this.f450309c + " 执行异常", e);
        CompletionBlock.DefaultImpls.onFailure$default(r212, 0, String.valueOf(e.getMessage()), null, 4, null);
    }
}
