package com.larus.bmhome.bot;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0017\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u0012\u001a\u00020\nH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/bot/BotStatusCacheServiceNoop;", "Lcom/larus/bmhome/bot/IBotStatusCacheService;", "<init>", "()V", "statusCache", "", "", "", "chatOnlyCache", "setStatus", "", "botId", "status", "getStatus", "(Ljava/lang/String;)Ljava/lang/Boolean;", "setChatOnly", "chatOnly", "getChatOnly", "clear", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotStatusCacheServiceNoop implements IBotStatusCacheService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Boolean> f296448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Boolean> f296449b;

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final void clear() {
        ((LinkedHashMap) this.f296448a).clear();
        ((LinkedHashMap) this.f296449b).clear();
    }

    public BotStatusCacheServiceNoop() {
        this.f296448a = new LinkedHashMap();
        this.f296449b = new LinkedHashMap();
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final Boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        return (Boolean) ((LinkedHashMap) this.f296449b).get(r100);
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final Boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        return (Boolean) ((LinkedHashMap) this.f296448a).get(r100);
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final void a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Boolean r102 = Boolean.valueOf(r101);
        this.f296448a.put(r100, r102);
    }

    @Override // com.larus.bmhome.bot.IBotStatusCacheService
    public final void d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Boolean r102 = Boolean.valueOf(r101);
        this.f296449b.put(r100, r102);
    }
}
