package com.larus.bot.impl.service;

import com.larus.bot.api.IBotRouteInterceptorService;
import com.larus.bot.impl.interceptor.b;
import kotlin.Metadata;
import q97.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/bot/impl/service/BotRouteInterceptorServiceImpl;", "Lcom/larus/bot/api/IBotRouteInterceptorService;", "<init>", "()V", "createBotCreateRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createBotUpdateRouterInterceptor", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotRouteInterceptorServiceImpl implements IBotRouteInterceptorService {
    public BotRouteInterceptorServiceImpl() {
    }

    @Override // com.larus.bot.api.IBotRouteInterceptorService
    public final a a() {
        return new com.larus.bot.impl.interceptor.a();
    }

    @Override // com.larus.bot.api.IBotRouteInterceptorService
    public final a b() {
        return new b();
    }
}
