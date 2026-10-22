package com.larus.bot.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import q97.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/larus/bot/api/IBotRouteInterceptorService;", "", "createBotCreateRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createBotUpdateRouterInterceptor", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBotRouteInterceptorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f317650a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0007"}, d2 = {"Lcom/larus/bot/api/IBotRouteInterceptorService$Companion;", "Lcom/larus/bot/api/IBotRouteInterceptorService;", "<init>", "()V", "createBotCreateRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createBotUpdateRouterInterceptor", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IBotRouteInterceptorService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f317651c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBotRouteInterceptorService f317652b;

        static {
            f317651c = new Companion();
        }

        @Override // com.larus.bot.api.IBotRouteInterceptorService
        public final a a() {
            return this.f317652b.a();
        }

        @Override // com.larus.bot.api.IBotRouteInterceptorService
        public final a b() {
            return this.f317652b.b();
        }

        private Companion() {
            this.f317652b = (IBotRouteInterceptorService) ServiceManager.get().getService(IBotRouteInterceptorService.class);
        }
    }

    static {
        f317650a = Companion.f317651c;
    }

    a a();

    a b();
}
