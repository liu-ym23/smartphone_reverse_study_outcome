package com.larus.im.internal.memory.cache;

import com.larus.im.internal.database.delegate.ConversationDaoSource;
import com.larus.im.internal.database.entity.ConversationEntity;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class ConversationCache extends MemoryCache<ConversationEntity> implements be9.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConversationDaoSource f348949j;

    public ConversationCache(int r100) {
        super(r100);
        be9.b.f18784b.getClass();
        this.f348949j = new ConversationDaoSource();
    }

    @Override // com.larus.im.internal.memory.cache.MemoryCache
    public final String M(ConversationEntity r100) {
        ConversationEntity r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.getConversationId();
    }

    public final Object X(Continuation<? super ConversationEntity> r100) {
        return W(new ConversationCache$getMainConversation$2(this, null), r100);
    }

    @Override // be9.b
    public final Object k(Continuation<? super List<ConversationEntity>> r100) {
        return W(new ConversationCache$getSortedConversations$2(this, null), r100);
    }

    @Override // com.larus.im.internal.memory.cache.MemoryCache
    public final Object N(String r100, Continuation<? super ConversationEntity> r101) {
        return be9.b.C0295b.a(this.f348949j, r100, 0, r101, 6);
    }

    @Override // be9.b
    public final Object e(ConversationEntity r100, Continuation<? super Long> r101) {
        return W(new ConversationCache$insertConversation$2(this, r100, null), r101);
    }

    @Override // be9.b
    public final Object m(int r100, Continuation<? super List<String>> r101) {
        return W(new ConversationCache$getLocalCvsIdsWithLimit$2(this, 100, null), r101);
    }

    @Override // be9.b
    public final Object q(List<String> r100, Continuation<? super Integer> r101) {
        return W(new ConversationCache$deleteConversations$2(this, r100, null), r101);
    }

    @Override // be9.b
    public final Object s(List<String> r100, Continuation<? super List<ConversationEntity>> r101) {
        return this.f348949j.s(r100, r101);
    }

    @Override // be9.b
    public final Object t(int r100, Continuation<? super List<ConversationEntity>> r101) {
        return W(new ConversationCache$getSortedConversationsWithLimit$2(this, r100, null), r101);
    }

    @Override // be9.b
    public final Object F(int r100, long r101, Continuation<? super List<ConversationEntity>> r110) {
        return W(new ConversationCache$getPinConversationWithLimit$2(this, r100, r101, null), r110);
    }

    @Override // be9.b
    public final Object G(int r100, long r101, Continuation<? super List<ConversationEntity>> r110) {
        return W(new ConversationCache$getNonPinConversationWithLimit$2(this, r100, r101, null), r110);
    }

    @Override // be9.b
    public final Object l(String r100, int r101, Continuation<? super List<ConversationEntity>> r102) {
        return W(new ConversationCache$getConversationByBotId$2(this, r100, r101, null), r102);
    }

    @Override // be9.b
    public final Object n(String r100, long r101, Continuation<? super Integer> r110) {
        return W(new ConversationCache$updateCursor$2(this, r100, r101, null), r110);
    }

    @Override // be9.b
    public final Object v(int r100, int r101, Continuation<? super List<ConversationEntity>> r102) {
        return W(new ConversationCache$getSortedConversationsWithLimitByArchiveStatus$2(this, r100, r101, null), r102);
    }

    @Override // be9.b
    public final Object E(int r100, long r110, int r111, Continuation<? super List<ConversationEntity>> r112) {
        return W(new ConversationCache$getNonPinConversationWithLimitByArchiveStatus$2(this, r100, r110, r111, null), r112);
    }

    @Override // be9.b
    public final Object p(int r100, long r110, int r111, Continuation<? super List<ConversationEntity>> r112) {
        return W(new ConversationCache$getPinConversationWithLimitByArchiveStatus$2(this, r100, r110, r111, null), r112);
    }

    @Override // be9.b
    public final Object u(String r100, int r101, boolean r110, Continuation<? super ConversationEntity> r111) {
        return W(new ConversationCache$getConversationById$2(this, r100, r110, r101, null), r111);
    }
}
