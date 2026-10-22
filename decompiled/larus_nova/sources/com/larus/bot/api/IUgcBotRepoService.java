package com.larus.bot.api;

import androidx.lifecycle.LiveData;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ic8.o0;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0002\u0010\tR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/larus/bot/api/IUgcBotRepoService;", "", "botCreateEventLive", "Landroidx/lifecycle/LiveData;", "", "getBotCreateEventLive", "()Landroidx/lifecycle/LiveData;", "getRecommendBotFirstPageData", "Lcom/larus/bmhome/chat/bean/RecommendBotData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Impl", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IUgcBotRepoService {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096A¢\u0006\u0002\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bot/api/IUgcBotRepoService$Impl;", "Lcom/larus/bot/api/IUgcBotRepoService;", "<init>", "()V", "getRecommendBotFirstPageData", "Lcom/larus/bmhome/chat/bean/RecommendBotData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "botCreateEventLive", "Landroidx/lifecycle/LiveData;", "", "getBotCreateEventLive", "()Landroidx/lifecycle/LiveData;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Impl implements IUgcBotRepoService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Impl f317653b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IUgcBotRepoService f317654a;

        static {
            f317653b = new Impl();
        }

        @Override // com.larus.bot.api.IUgcBotRepoService
        public final Object a(Continuation<? super o0> r100) {
            return this.f317654a.a(r100);
        }

        @Override // com.larus.bot.api.IUgcBotRepoService
        public final LiveData<String> b() {
            return this.f317654a.b();
        }

        private Impl() {
            this.f317654a = (IUgcBotRepoService) ServiceManager.get().getService(IUgcBotRepoService.class);
        }
    }

    Object a(Continuation<? super o0> r100);

    LiveData<String> b();
}
