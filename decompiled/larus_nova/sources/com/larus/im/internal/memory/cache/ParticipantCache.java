package com.larus.im.internal.memory.cache;

import com.larus.im.internal.database.delegate.ParticipantDaoSource;
import com.larus.im.internal.database.entity.ParticipantEntity;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class ParticipantCache extends MemoryCache<ParticipantEntity> implements be9.e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ParticipantDaoSource f348959j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f348960k;

    public ParticipantCache(int r100) {
        super(r100);
        be9.e.f18791d.getClass();
        this.f348959j = new ParticipantDaoSource();
        this.f348960k = "#cache#";
    }

    @Override // com.larus.im.internal.memory.cache.MemoryCache
    public final String M(ParticipantEntity r100) {
        ParticipantEntity r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.getConversationId() + this.f348960k + r101.getParticipantId();
    }

    @Override // com.larus.im.internal.memory.cache.MemoryCache
    public final Object N(String r100, Continuation<? super ParticipantEntity> r101) {
        return W(new ParticipantCache$loadFromDB$2(r100, this, null), r101);
    }

    @Override // be9.e
    public final Object c(String r100, Continuation<? super List<ParticipantEntity>> r101) {
        return W(new ParticipantCache$getAllParticipantByConversationId$2(this, r100, null), r101);
    }

    @Override // be9.e
    public final Object f(List<ParticipantEntity> r100, Continuation<? super Unit> r101) {
        Object r102 = W(new ParticipantCache$insertAllParticipant$2(this, r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // be9.e
    public final Object w(List<String> r100, Continuation<? super Integer> r101) {
        return W(new ParticipantCache$deleteParticipantsByCvsIds$2(this, r100, null), r101);
    }

    @Override // be9.e
    public final Object y(String r100, Continuation<? super Integer> r101) {
        return W(new ParticipantCache$deleteParticipantsByConversationId$2(this, r100, null), r101);
    }

    @Override // be9.e
    public final Object B(String r100, String r101, Continuation<? super ParticipantEntity> r102) {
        return W(new ParticipantCache$getParticipantById$2(this, r101, r100, null), r102);
    }
}
