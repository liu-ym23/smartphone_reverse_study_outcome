package com.larus.xbridge.custom;

import android.view.View;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.btm.api.IBTMService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
@XBridgeMethod(name = "btm.createJumpSourceBtmToken")
public final class y0 extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f379804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "btm.createJumpSourceBtmToken", params = {"btm", "bcm", "options"})
    public final String f379805b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "bcm", required = false)
        Map<String, Object> getBcm();

        @XBridgeParamField(isGetter = true, keyPath = "btm", required = true)
        String getBtm();

        @XBridgeParamField(isGetter = true, keyPath = "options", required = false)
        Map<String, Object> getOptions();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "data", required = true)
        Map<String, Object> getData();

        @XBridgeParamField(isGetter = false, keyPath = "data", required = true)
        void setData(Map<String, ? extends Object> r100);
    }

    public y0() {
        this.f379804a = "BtmCreateJumpSourceBtmToken";
        this.f379805b = "btm.createJumpSourceBtmToken";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f379805b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        a r112 = (a) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        String r101 = r112.getBtm();
        if (StringsKt.isBlank(r101) == false) goto L5;
        FLogger.f375446a.e(this.f379804a, "[handle] invalid btm");
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "invalid btm", null, 4, null);
        return;
    L5:
        FLogger r102 = FLogger.f375446a;
        String r103 = this.f379804a;
        StringBuilder r104 = new StringBuilder("[handle] start, btm=");
        r104.append(r101);
        r104.append(", bcmKeys=");
        Map<String, Object> r105 = r112.getBcm();
        if (r105 == null) goto L8;
        Set<String> r106 = r105.keySet();
    L9:
        r104.append(r106);
        r104.append(", optionsKeys=");
        Map<String, Object> r107 = r112.getOptions();
        if (r107 == null) goto L12;
        Set<String> r108 = r107.keySet();
    L13:
        r104.append(r108);
        r102.i(r103, r104.toString());
        Map<String, ? extends Object> r109 = r112.getBcm();
        r112.getOptions();
        View r113 = r100.getEngineView();
        if (r113 == null) goto L18;
        IBTMService r114 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r114 == null) goto L18;
        String r115 = r114.d(r101, r109, r113);
    L19:
        if (r115 != null) goto L21;
    L24:
        boolean r116 = true;
    L25:
        if (r116 == false) goto L27;
        r102.e(this.f379804a, "[handle] create token failed, btm=" + r101);
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "create token failed", null, 4, null);
        return;
    L27:
        b r117 = (b) ne7.e.b(b.class);
        r117.setData(MapsKt.mapOf(TuplesKt.to(PhotoEnterModel.SOURCE_BTM_TOKEN, r115)));
        CompletionBlock.DefaultImpls.onSuccess$default(r111, r117, null, 2, null);
        r102.i(this.f379804a, "handle success " + r115);
        return;
    L21:
        if (StringsKt.isBlank(r115) == true) goto L24;
        r116 = false;
    L18:
        r115 = null;
        goto L19
    L12:
        r108 = null;
        goto L13
    L8:
        r106 = null;
        goto L9
    }
}
