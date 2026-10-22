package com.larus.bot.impl.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.bot.api.IUgcBotRepoService;
import com.larus.bot.impl.repository.UgcBotRepo;
import ic8.o0;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u0004\u0018\u00010\nH\u0096@¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/larus/bot/impl/service/UgcBotRepoServiceImpl;", "Lcom/larus/bot/api/IUgcBotRepoService;", "<init>", "()V", "botCreateEventLive", "Landroidx/lifecycle/MutableLiveData;", "", "getBotCreateEventLive", "()Landroidx/lifecycle/MutableLiveData;", "getRecommendBotFirstPageData", "Lcom/larus/bmhome/chat/bean/RecommendBotData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UgcBotRepoServiceImpl implements IUgcBotRepoService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<String> f319377a;

    public UgcBotRepoServiceImpl() {
        Lazy<UgcBotRepo> r100 = UgcBotRepo.f319353d;
        this.f319377a = UgcBotRepo.a.a().f319356c;
    }

    @Override // com.larus.bot.api.IUgcBotRepoService
    public final LiveData b() {
        return this.f319377a;
    }

    @Override // com.larus.bot.api.IUgcBotRepoService
    public final Object a(Continuation<? super o0> r100) {
        Lazy<UgcBotRepo> r101 = UgcBotRepo.f319353d;
        return UgcBotRepo.a.a().f319355b;
    }
}
