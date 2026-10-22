package com.ivy.ivykit.plugin.impl.jsb.auth;

import com.bytedance.sdk.bridge.BridgeConfig;
import com.bytedance.sdk.bridge.api.BridgeService;
import com.bytedance.sdk.bridge.auth.AbsBridgeAuthenticator;
import com.bytedance.sdk.bridge.js.JsBridgeManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mx7.c;
import rx7.f;
import rx7.h;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/ivy/ivykit/plugin/impl/jsb/auth/LegacyBridgeService;", "Lcom/bytedance/sdk/bridge/api/BridgeService;", "Lcom/bytedance/sdk/bridge/BridgeConfig;", "initBridgeConfig", "", "initBridgeSDK", "Lcom/bytedance/sdk/bridge/c;", "initBridgeLazyConfig", "", "tag", "msg", "reportErrorInfo", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ivy_plugin_impl_bullet_release"}, k = 1, mv = {1, 7, 1})
public final class LegacyBridgeService implements BridgeService {
    private static final a Companion = null;
    private static final Lazy<AbsBridgeAuthenticator<String>> authenticator$delegate = null;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        authenticator$delegate = LazyKt.lazy(LegacyBridgeService$Companion$authenticator$2.INSTANCE);
    }

    @Override // com.bytedance.sdk.bridge.api.BridgeService
    public BridgeConfig initBridgeConfig() {
        return new BridgeConfig.Builder().setApplication(c.b()).setSchema("nativeapp").build();
    }

    @Override // com.bytedance.sdk.bridge.api.BridgeService
    public com.bytedance.sdk.bridge.c initBridgeLazyConfig() {
        int r100 = c.f516267c;
        String r101 = c.f516268d;
        String r102 = c.f516274j;
        String r103 = ((f) CollectionsKt.first(mx7.a.a().a())).a(h.a());
        com.bytedance.sdk.bridge.c.a r104 = new com.bytedance.sdk.bridge.c.a();
        r104.f269580d = r103;
        r104.f269577a = r100;
        r104.f269578b = r101;
        r104.f269579c = r102;
        r104.f269581e = true;
        return new com.bytedance.sdk.bridge.c(r104);
    }

    @Override // com.bytedance.sdk.bridge.api.BridgeService
    public void initBridgeSDK() {
        monitor-enter(LegacyBridgeService.class);
        boolean r100 = zc7.b.f571274a;     // Catch: Throwable -> L10
        zc7.b.f571274a = true;     // Catch: Throwable -> L10
        List<zc7.c> r101 = zc7.b.f571275b;     // Catch: Throwable -> L10
        xc7.b r102 = xc7.b.f563220a;     // Catch: Throwable -> L10
        ArrayList r103 = (ArrayList) r101;     // Catch: Throwable -> L10
        if (r103.contains(r102) == true) goto L7;
        r103.add(r102);     // Catch: Throwable -> L10
    L7:
        JsBridgeManager r104 = JsBridgeManager.INSTANCE;     // Catch: Throwable -> L10
        Companion.getClass();     // Catch: Throwable -> L10
        r104.setJsBridgeAuthenticator((AbsBridgeAuthenticator) access$getAuthenticator$delegate$cp().getValue());     // Catch: Throwable -> L10
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(LegacyBridgeService.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public LegacyBridgeService() {
    }

    public static final /* synthetic */ Lazy access$getAuthenticator$delegate$cp() {
        return authenticator$delegate;
    }

    @Override // com.bytedance.sdk.bridge.api.BridgeService
    public void reportErrorInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Map<Class<?>, ox7.a> r102 = ox7.b.f527091a;
        ox7.b.b(r100, r101, null);
    }
}
