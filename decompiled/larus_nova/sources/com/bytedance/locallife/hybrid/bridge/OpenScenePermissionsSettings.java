package com.bytedance.locallife.hybrid.bridge;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.system.XOpenPermissionSettingsMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class OpenScenePermissionsSettings extends mt6.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f258993b;

    public static final class a implements IDLXBridgeMethod.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod.a f258994a;

        public a(IDLXBridgeMethod.a r100) {
            this.f258994a = r100;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.a
        public final void invoke(Map<String, ? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f258994a.invoke(r100);
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "openScenePermissionsSettings";
    }

    public OpenScenePermissionsSettings() {
        this.f258993b = LazyKt.lazy(OpenScenePermissionsSettings$xOpenPermissionSettingsMethod$2.INSTANCE);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        XOpenPermissionSettingsMethod r103 = (XOpenPermissionSettingsMethod) this.f258993b.getValue();
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("permission", "location");
        Unit r105 = Unit.INSTANCE;
        r103.realHandle(r100, r104, new a(r102));
    }
}
