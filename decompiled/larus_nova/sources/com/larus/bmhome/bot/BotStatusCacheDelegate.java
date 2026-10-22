package com.larus.bmhome.bot;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¢\u0006\u0002\u0010\nJ\u0019\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0001¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/bot/BotStatusCacheDelegate;", "Lcom/larus/bmhome/bot/IBotStatusCacheService;", "<init>", "()V", "clear", "", "getChatOnly", "", "botId", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getStatus", "setChatOnly", "chatOnly", "setStatus", "status", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotStatusCacheDelegate implements IBotStatusCacheService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BotStatusCacheDelegate f296446b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBotStatusCacheService f296447a;

    static {
        f296446b = new BotStatusCacheDelegate();
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final void a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.f296447a.a(r100, r101);
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final Boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        return this.f296447a.b(r100);
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final Boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        return this.f296447a.c(r100);
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final void clear() {
        this.f296447a.clear();
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final void d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.f296447a.d(r100, r101);
    }

    private BotStatusCacheDelegate() {
        IBotStatusCacheService r100 = (IBotStatusCacheService) ServiceManager.get().getService(IBotStatusCacheService.class);
        if (r100 != null) goto L5;
        r100 = new BotStatusCacheServiceNoop();
    L5:
        this.f296447a = r100;
    }
}
