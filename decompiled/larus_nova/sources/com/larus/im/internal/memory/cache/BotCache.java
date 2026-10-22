package com.larus.im.internal.memory.cache;

import com.larus.im.internal.database.delegate.BotDaoSource;
import com.larus.im.internal.database.entity.BotEntity;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class BotCache extends MemoryCache<BotEntity> implements be9.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BotDaoSource f348948j;

    public BotCache(int r100) {
        super(r100);
        be9.a.f18782a.getClass();
        this.f348948j = new BotDaoSource();
    }

    @Override // com.larus.im.internal.memory.cache.MemoryCache
    public final String M(BotEntity r100) {
        BotEntity r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.getBotId();
    }

    @Override // com.larus.im.internal.memory.cache.MemoryCache
    public final Object N(String r100, Continuation<? super BotEntity> r101) {
        return this.f348948j.j(r100, r101);
    }

    @Override // be9.a
    public final Object d(BotEntity r100, Continuation<? super Unit> r101) {
        P(r100);
        Object r102 = U(new BotCache$insertBot$2(this, r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // be9.a
    public final Object g(List<String> r100, Continuation<? super List<BotEntity>> r101) {
        return W(new BotCache$getBotsByIds$2(this, r100, null), r101);
    }

    @Override // be9.a
    public final Object j(String r100, Continuation<? super BotEntity> r101) {
        return W(new BotCache$getBotById$2(this, r100, null), r101);
    }
}
