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
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@XBridgeMethod(name = "app.addAccount")
public final class d extends XCoreIDLBridgeMethod<a, g0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "app.addAccount", params = {"trackInfo"})
    public final String f379721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f379722b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "trackInfo", required = false)
        Map<String, Object> getTrackInfo();
    }

    public static final class b {
    }

    static {
    }

    public d() {
        this.f379721a = "app.addAccount";
        this.f379722b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f379722b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f379721a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, final CompletionBlock r102) {
        final a r103 = (a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Activity r104 = r100.getOwnerActivity();
        if (r104 != null) goto L6;
        gd9.i r105 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r105);
        r104 = r105.a().e();
    L6:
        if ((r104 instanceof FragmentActivity) == false) goto L8;
        final FragmentActivity r106 = (FragmentActivity) r104;
    L9:
        if (r106 != null) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "host activity is unavailable", null, 4, null);
        return;
    L11:
        r106.runOnUiThread(new c(r102, r106, r103));
        return;
    L8:
        r106 = null;
        goto L9
    }
}
