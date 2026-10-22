package com.larus.im.internal.database.delegate;

import com.larus.im.internal.database.dao.ParticipantDao;
import com.larus.im.internal.database.entity.ParticipantEntity;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
public final class ParticipantDaoSource implements be9.e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f347926e = 0;

    public static final class a {
        public static final ParticipantDao a() {
            int r100 = ParticipantDaoSource.f347926e;
            com.larus.im.internal.database.b.f347916a.getClass();
            return com.larus.im.internal.database.b.a.b().participantDao();
        }

        public a() {
        }

        public static final Object b(Function1 r100, Continuation r101) {
            int r102 = ParticipantDaoSource.f347926e;
            com.larus.im.internal.database.b.f347916a.getClass();
            com.larus.im.internal.database.b.a.b();
            return com.larus.im.internal.database.d.a(r100, r101);
        }
    }

    static {
        new a();
    }

    public ParticipantDaoSource() {
    }

    public final Object a(ParticipantEntity r100, Continuation<? super Unit> r101) {
        Object r102 = a.b(new ParticipantDaoSource$insertParticipant$2(r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // be9.e
    public final Object c(String r100, Continuation<? super List<ParticipantEntity>> r101) {
        return a.b(new ParticipantDaoSource$getAllParticipantByConversationId$2(r100, null), r101);
    }

    @Override // be9.e
    public final Object f(List<ParticipantEntity> r100, Continuation<? super Unit> r101) {
        return a.b(new ParticipantDaoSource$insertAllParticipant$2(r100, null), r101);
    }

    @Override // be9.e
    public final Object w(List<String> r100, Continuation<? super Integer> r101) {
        return a.b(new ParticipantDaoSource$deleteParticipantsByCvsIds$2(r100, null), r101);
    }

    @Override // be9.e
    public final Object y(String r100, Continuation<? super Integer> r101) {
        return a.b(new ParticipantDaoSource$deleteParticipantsByConversationId$2(r100, null), r101);
    }

    @Override // be9.e
    public final Object B(String r100, String r101, Continuation<? super ParticipantEntity> r102) {
        return a.b(new ParticipantDaoSource$getParticipantById$2(r100, r101, null), r102);
    }

    public final Object b(String r100, int r101, Continuation<? super Integer> r102) {
        return a.b(new ParticipantDaoSource$queryParticipantCountByConversationId$2(r100, r101, null), r102);
    }
}
