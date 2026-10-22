package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class b implements IDLXBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBridgeMethod f246280a;

    public static final class a implements IBridgeMethod.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod.a f246281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f246282b;

        @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod.a
        public final void onComplete(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Map<String, ? extends Object> r101 = ConvertUtils.INSTANCE.jsonToMap(r100);
            this.f246281a.invoke(r101);
        }

        public a(IDLXBridgeMethod.a r100, b r101) {
            this.f246281a = r100;
            this.f246282b = r101;
        }

        @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod.a
        public final void onError(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "data");
            HashMap r102 = new HashMap();
            b r103 = this.f246282b;
            r102.put("code", 4);
            r102.put("message", r100);
            r102.put("func", r103.f246280a.getName());
            r102.put("data", r101);
            this.f246281a.invoke(r102);
        }

        @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod.a
        public final void onError(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "message");
            HashMap r102 = new HashMap();
            b r103 = this.f246282b;
            r102.put("code", Integer.valueOf(r100));
            r102.put("message", r101);
            r102.put("func", r103.f246280a.getName());
            this.f246281a.invoke(r102);
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        IBridgeMethod r100 = this.f246280a;
        if ((r100 instanceof com.bytedance.ies.bullet.core.kit.bridge.c) == true) goto L5;
        return false;
    L5:
        return ((com.bytedance.ies.bullet.core.kit.bridge.c) r100).a();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        IDLXBridgeMethod.Access r100 = j.a(this.f246280a.getAccess());
        if (r100 == null) goto L5;
        return r100;
    L5:
        return IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f246280a.getName();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return IDLXBridgeMethod.Compatibility.Compatible;
    }

    public b(IBridgeMethod r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        this.f246280a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f246280a.b70(ConvertUtils.mapToJSON$default(ConvertUtils.INSTANCE, r101, 0, 2, null), new a(r102, this));     // Catch: Exception -> L5
        return;
    }
}
