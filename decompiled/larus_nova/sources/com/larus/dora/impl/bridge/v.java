package com.larus.dora.impl.bridge;

import android.net.Uri;
import com.bytedance.dora.device.DoraDevice;
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
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.util.UriUtil;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.util.DoraImageType;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@XBridgeMethod(name = "dora.resource.getImageURL")
public final class v extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "dora.resource.getImageURL")
    public final String f332117a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "resourceKey", required = true)
        String getResourceKey();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "resourceKey", required = false)
        String getResourceKey();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = false)
        String getUrl();

        @XBridgeParamField(isGetter = false, keyPath = "resourceKey", required = false)
        void setResourceKey(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "url", required = false)
        void setUrl(String r100);
    }

    static {
    }

    public v() {
        this.f332117a = "dora.resource.getImageURL";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f332117a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        b r112 = (b) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        String r101 = r112.getResourceKey();
        boolean r113 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r111, -3, "resourceKey is required", null, 4, null);
        return;
    L12:
        if (Intrinsics.areEqual(r101, "dora_device_gesture_setting") == false) goto L23;
        DoraDevice r103 = DoraAdapterExtKt.h(kj4.a.g());
        DoraSKU.a r104 = DoraSKU.Companion;
        if (r103 == null) goto L16;
        Integer r105 = Integer.valueOf(r103.sku);
    L17:
        String r106 = DoraImageType.IMAGE_ONBOARDING_POPUP_HEADPHONE_GESTURE.fileName(DoraSKU.a.b(r104, r105));
        DoraResourceUtil r107 = DoraResourceUtil.f338111a;
        String r108 = DoraResourceUtil.d(r106);
        if ((!StringsKt.isBlank(r108)) == true) goto L20;
    L22:
        String r109 = new Uri.Builder().scheme(UriUtil.QUALIFIED_RESOURCE_SCHEME).authority(AppHost.f326268a.getApplication().getPackageName()).appendPath(String.valueOf(R.drawable.larus_image_onboarding_popup_headphone_gesture_silver)).build().toString();
    L24:
        if (r109 != null) goto L26;
    L27:
        r113 = true;
    L28:
        if (r113 == false) goto L30;
        FLogger.f375446a.w("DoraResourceGetImageURLMethod", "dora.resource.getImageURL image not found resourceKey=" + r101);
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "image resource not found", null, 4, null);
        return;
    L30:
        c r114 = (c) ne7.e.b(c.class);
        r114.setResourceKey(r101);
        r114.setUrl(r109);
        CompletionBlock.DefaultImpls.onSuccess$default(r111, r114, null, 2, null);
        return;
    L26:
        if (StringsKt.isBlank(r109) == false) goto L28;
    L20:
        if (new PolarisFileWrapper(r108).exists() == false) goto L22;
        r109 = Uri.fromFile(new PolarisFileWrapper(r108)).toString();
        goto L24
    L16:
        r105 = null;
        goto L17
    L23:
        r109 = null;
        goto L24
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }
}
