package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes32.dex */
public abstract class s0 extends bx7.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f379788b;

    public static final class a {
    }

    static {
    }

    public abstract Map<String, Object> f(cx7.d r100);

    public s0() {
        Intrinsics.checkNotNullParameter("biz.util.getAuthHeader", "name");
        this.f379788b = "biz.util.getAuthHeader";
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return this.f379788b;
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        FLogger.f375446a.i("BizUtilAuthorization", "handle request, method=" + this.f379788b + ", platform=" + r102);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BizUtilAuthorizationMethod$handle$1(this, r101, r100, null), 3, null);
    }
}
