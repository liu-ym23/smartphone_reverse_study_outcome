package com.larus.xbridge.custom;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
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
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
@XBridgeMethod(name = "app.switchAccount")
public final class g0 extends XCoreIDLBridgeMethod<c, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "app.switchAccount", params = {"secUid", "trackInfo"})
    public final String f379750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f379751b;

    @XBridgeResultModel
    public interface a extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "success", required = true)
        boolean getSuccess();

        @XBridgeParamField(isGetter = false, keyPath = "success", required = true)
        void setSuccess(boolean r100);
    }

    public static final class b {
    }

    @XBridgeParamModel
    public interface c extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "secUid", required = true)
        String getSecUid();

        @XBridgeParamField(isGetter = true, keyPath = "trackInfo", required = false)
        Map<String, Object> getTrackInfo();
    }

    static {
    }

    public g0() {
        this.f379750a = "app.switchAccount";
        this.f379751b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f379751b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f379750a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(final IBDXBridgeContext r110, XBaseParamModel r111, final CompletionBlock r112) {
        final c r100 = (c) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r113 = r100.getSecUid();
        FragmentActivity r101 = null;
        if ((!StringsKt.isBlank(r113)) == false) goto L5;
        final String r102 = r113;
    L6:
        if (r102 != null) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "secUid is required", null, 4, null);
        return;
    L8:
        Activity r114 = r110.getOwnerActivity();
        if (r114 != null) goto L12;
        gd9.i r115 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r115);
        r114 = r115.a().e();
    L12:
        if ((r114 instanceof FragmentActivity) == false) goto L14;
        r101 = (FragmentActivity) r114;
    L14:
        final FragmentActivity r116 = r101;
        if (r116 != null) goto L17;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "host activity is unavailable", null, 4, null);
        return;
    L17:
        r116.runOnUiThread(new e0(r110, r116, r112, r102, r100));
        return;
    L5:
        r102 = null;
        goto L6
    }
}
