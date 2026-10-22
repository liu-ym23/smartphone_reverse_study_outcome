package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusContainerType;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class u extends m<v> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f245782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AuthBridgeAccess f245783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArgusContainerType f245784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f245785e;

    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public final com.bytedance.ies.argus.strategy.a f() {
        return new v(AuthBridgeAccess.UNKNOWN);
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject c(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return (JSONObject) this.f245785e.getValue();
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return (JSONObject) this.f245785e.getValue();
    }

    public u(String r100, AuthBridgeAccess r101, r r102, ArgusContainerType r103) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "methodAuthType");
        Intrinsics.checkNotNullParameter(r103, "containerType");
        this.f245782b = r100;
        this.f245783c = r101;
        this.f245784d = r103;
        this.f245785e = LazyKt.lazy(new JSBCallParams$printObj$2(this));
    }
}
