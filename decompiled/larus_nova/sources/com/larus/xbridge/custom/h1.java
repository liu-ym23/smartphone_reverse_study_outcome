package com.larus.xbridge.custom;

import android.app.Activity;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.google.gson.Gson;
import com.larus.caijing_pay.api.ICJPayService;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@XBridgeMethod(name = "flow.openMembershipCJPay", owner = "river.li")
public final class h1 extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "flow.openMembershipCJPay")
    public final String f379767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f379768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f379769c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "productID", required = true)
        String getProductID();

        @XBridgeParamField(isGetter = true, keyPath = "sdkParams", required = true)
        String getSdkParams();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "resultCode", required = true)
        String getResultCode();

        @XBridgeParamField(isGetter = true, keyPath = "resultMessage", required = true)
        String getResultMessage();

        @XBridgeParamField(isGetter = false, keyPath = "resultCode", required = true)
        void setResultCode(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "resultMessage", required = true)
        void setResultMessage(String r100);
    }

    static {
    }

    public h1() {
        this.f379767a = "flow.openMembershipCJPay";
        this.f379768b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f379768b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f379767a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, final CompletionBlock r112) {
        b r100 = (b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        final String r101 = r100.getSdkParams();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        FLogger.f375446a.e("FlowOpenMembershipCJPayMethod", "sdkParams is empty");
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "fail, sdkParams is empty", null, 4, null);
        return;
    L12:
        Activity r113 = r110.getOwnerActivity();
        if (r113 != null) goto L15;
        FLogger.f375446a.e("FlowOpenMembershipCJPayMethod", "activity is null");
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "fail, activity is null", null, 4, null);
        return;
    L15:
        String r104 = r100.getProductID();
        int r105 = StringsKt.indexOf$default(r104, '_', 0, false, 6, null);
        if (r105 <= 0) goto L18;
        String r106 = r104.substring(0, r105);
    L19:
        Object r107 = null;
        Integer r108 = null;
        if (r105 <= 0) goto L26;
        String r109 = r104.substring(r105 + 1);
        if (r109.length() <= 0) goto L24;
        r102 = true;
    L24:
        if (r102 == false) goto L26;
        final String r114 = r109;
    L27:
        FLogger r115 = FLogger.f375446a;
        r115.i("FlowOpenMembershipCJPayMethod", "[handle] pay productId=" + r104 + " orderId=" + r106 + " subscriptionId=" + r114 + " activity=" + r113.getLocalClassName());
        StringBuilder r116 = new StringBuilder("[handle] pay sdkParams=");
        r116.append(r101);
        r115.d("FlowOpenMembershipCJPayMethod", r116.toString());
        r1 r117 = new r1("1");
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L40
        JSONObject r119 = new JSONObject(r101);     // Catch: Throwable -> L40
        if (r119.has("service") == false) goto L47;
        Object r120 = r119.opt("service");     // Catch: Throwable -> L40
        if ((r120 instanceof Number) == false) goto L35;
        Integer r121 = Integer.valueOf(((Number) r120).intValue());     // Catch: Throwable -> L40
    L38:
        Object r122 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L40
    L43:
        if (Result.m9455isFailureimpl(r122) == true) goto L46;
        r107 = r122;
    L46:
        r108 = (Integer) r107;
        goto L47
    L35:
        if ((r120 instanceof String) == false) goto L37;
        r121 = StringsKt.toIntOrNull((String) r120);     // Catch: Throwable -> L40
        goto L38
    L37:
        r121 = null;
    L47:
        if (r108 == null) goto L49;
        int r123 = r108.intValue();
    L50:
        ICommerceMembershipService r124 = (ICommerceMembershipService) ServiceManager.get().getService(ICommerceMembershipService.class);
        if (r124 == null) goto L53;
        r124.B(r106, r114, String.valueOf(r123), r101, "cj_pay_jsb");
    L53:
        ICJPayService r125 = (ICJPayService) ServiceManager.get().getService(ICJPayService.class);
        if (r125 == null) goto L61;
        final String r126 = r106;
        final int r127 = r123;
        r125.e(r113, r123, r101, GsonProtectorUtils.toJson(new Gson(), r117), new g1(r126, r114, r127, r101, r112, this));
        return;
    L61:
        return;
    L49:
        r123 = 20;
    L40:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L26:
        r114 = null;
        goto L27
    L18:
        r106 = r104;
        goto L19
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L10
    }
}
