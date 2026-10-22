package com.larus.extension.account_auth.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0096\u0001J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J'\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000b2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001aH\u0096\u0001J%\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u000bH\u0096\u0001¨\u0006!"}, d2 = {"Lcom/larus/extension/account_auth/api/FlowAccountAuthServiceDelegate;", "Lcom/larus/extension/account_auth/api/IFlowAccountAuthService;", "<init>", "()V", "accountStatusFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/extension/account_auth/api/model/AccountAuthStatus;", "getAccountAuthStatus", "getAuthStatusCode", "", "getAuthToken", "", "getOpenId", "getUserId", "goSaaSLogin", "", "tag", "currentPage", "hasFirstSilentAuthResult", "", "init", "platformDependency", "Lcom/larus/extension/account_auth/api/model/IPlatformDependency;", "startFlowAuth", "sceneTag", "resultCallback", "Lkotlin/Function1;", "Lcom/larus/extension/account_auth/api/model/PlatformAuthOpenInfoResult;", "tryHandleRisk", "path", "code", "", "msg", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowAccountAuthServiceDelegate implements IFlowAccountAuthService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FlowAccountAuthServiceDelegate f342480b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IFlowAccountAuthService f342481a;

    static {
        f342480b = new FlowAccountAuthServiceDelegate();
    }

    @Override // com.larus.extension.account_auth.api.IFlowAccountAuthService
    public final int a() {
        return this.f342481a.a();
    }

    @Override // com.larus.extension.account_auth.api.IFlowAccountAuthService
    public final void b() {
        this.f342481a.b();
    }

    private FlowAccountAuthServiceDelegate() {
        IFlowAccountAuthService r100 = (IFlowAccountAuthService) ServiceManager.get().getService(IFlowAccountAuthService.class);
        if (r100 != null) goto L5;
        r100 = new FlowAccountAuthServiceNoop();
    L5:
        this.f342481a = r100;
    }
}
