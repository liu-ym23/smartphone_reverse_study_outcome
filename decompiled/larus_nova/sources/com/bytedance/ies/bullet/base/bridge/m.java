package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class m implements IDLXBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.bullet.service.base.bridge.b f246295a;

    public static final class a implements com.bytedance.ies.bullet.service.base.bridge.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod.a f246296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f246297b;

        @Override // com.bytedance.ies.bullet.service.base.bridge.b.a
        public final void a(JSONObject r110) {
            if (r110 == null) goto L15;
            IBDXBridgeContext r100 = this.f246297b;
            IDLXBridgeMethod.a r101 = this.f246296a;
            if (com.bytedance.ies.bullet.service.base.h.n() == false) goto L12;
            le7.a<?> r102 = r100.getBridgeCall();
            if (r110.remove("ignoreJSB2Error") == null) goto L9;
            boolean r103 = true;
        L10:
            r102.I = r103;
            goto L12
        L9:
            r103 = false;
        L12:
            if (r100.getPlatformType() != PlatformType.LYNX) goto L14;
            Object r104 = r110.remove("code");
            r110.remove("__data");
            JSONObject r105 = new JSONObject();
            r105.put("data", r110);
            r105.put("__msg_type", "callback");
            r105.put(com.heytap.mcssdk.constant.b.f276361k, CastLongProtector.parseLong(r110.optString("__callback_id", "0")));
            r105.put("__callback_id", "0");
            r105.put("code", r104);
            LinkedHashMap r106 = new LinkedHashMap();
            r106.put("__jsb2__data__", r105);
            r101.invoke(r106);
            goto L15
        L14:
            LinkedHashMap r107 = new LinkedHashMap();
            r107.put("__jsb2__data__", r110);
            r101.invoke(r107);
        L15:
            if (r110 != null) goto L18;
            IDLXBridgeMethod.a r111 = this.f246296a;
            LinkedHashMap r108 = new LinkedHashMap();
            r108.put("__jsb2__data__", new JSONObject());
            r111.invoke(r108);
            return;
        }

        public a(IDLXBridgeMethod.a r100, IBDXBridgeContext r101) {
            this.f246296a = r100;
            this.f246297b = r101;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        com.bytedance.ies.bullet.service.base.bridge.b r100 = this.f246295a;
        if ((r100 instanceof com.bytedance.ies.bullet.core.kit.bridge.j) == false) goto L5;
        ((com.bytedance.ies.bullet.core.kit.bridge.j) r100).getClass();
    L5:
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        IDLXBridgeMethod.Access r100 = j.a(this.f246295a.getAccess());
        if (r100 == null) goto L5;
        return r100;
    L5:
        return IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f246295a.getName();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return IDLXBridgeMethod.Compatibility.Compatible;
    }

    public m(com.bytedance.ies.bullet.service.base.bridge.b r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        this.f246295a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (com.bytedance.ies.bullet.base.settings.c.a().f() != 1) goto L6;
        this.f246295a.C50(ConvertUtils.mapToJSON$default(ConvertUtils.INSTANCE, r101, 0, 2, null), new n(new WeakReference(r100), r102));     // Catch: Exception -> L8
    L9:
        return;
    L6:
        this.f246295a.C50(ConvertUtils.mapToJSON$default(ConvertUtils.INSTANCE, r101, 0, 2, null), new a(r102, r100));     // Catch: Exception -> L8
    }
}
