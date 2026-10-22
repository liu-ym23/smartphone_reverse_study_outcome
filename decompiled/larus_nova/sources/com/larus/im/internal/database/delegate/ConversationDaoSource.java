package com.larus.im.internal.database.delegate;

import android.os.SystemClock;
import com.larus.im.internal.database.dao.ConversationDao;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.database.entity.simple.ConversationSimpleEntity;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ConversationDaoSource implements be9.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f347923e = 0;

    public static final class a {
        public static final ConversationDao a() {
            int r100 = ConversationDaoSource.f347923e;
            com.larus.im.internal.database.b.f347916a.getClass();
            return com.larus.im.internal.database.b.a.b().conversationDao();
        }

        public a() {
        }

        public static final Object b(Function1 r100, Continuation r101) {
            int r102 = ConversationDaoSource.f347923e;
            com.larus.im.internal.database.b.f347916a.getClass();
            com.larus.im.internal.database.b.a.b();
            return com.larus.im.internal.database.d.a(r100, r101);
        }
    }

    static {
        new a();
    }

    public ConversationDaoSource() {
    }

    public final Object b(Continuation<? super List<ConversationEntity>> r100) {
        return a.b(new ConversationDaoSource$getAllConversation$2(null), r100);
    }

    public final Object c(Continuation<? super List<String>> r100) {
        return a.b(new ConversationDaoSource$getAllConversationIds$2(null), r100);
    }

    public final Object d(Continuation<? super List<ConversationEntity>> r100) {
        return a.b(new ConversationDaoSource$getAllSubConversation$2(null), r100);
    }

    public final Object f(Continuation<? super List<ConversationSimpleEntity>> r100) {
        return a.b(new ConversationDaoSource$getAllSubSimpleCvsList$2(null), r100);
    }

    public final Object g(Continuation<? super List<String>> r100) {
        return a.b(new ConversationDaoSource$getAllVisibleBotCvsIds$2(null), r100);
    }

    public final Object j(Continuation<? super ConversationEntity> r100) {
        com.larus.im.internal.delegate.a.f348188b.i("ConversationDaoSource", "getMainConversation");
        return a.b(new ConversationDaoSource$getMainConversation$2(null), r100);
    }

    @Override // be9.b
    public final Object k(Continuation<? super List<ConversationEntity>> r100) {
        return a.b(new ConversationDaoSource$getSortedConversations$2(null), r100);
    }

    public final Object o(Continuation<? super List<ConversationEntity>> r100) {
        return a.b(new ConversationDaoSource$getMainConversationV2$2(null), r100);
    }

    public final Object a(String r100, Continuation<? super Integer> r101) {
        return a.b(new ConversationDaoSource$deleteConversation$2(r100, null), r101);
    }

    @Override // be9.b
    public final Object e(ConversationEntity r100, Continuation<? super Long> r101) {
        return a.b(new ConversationDaoSource$insertConversation$2(r100, null), r101);
    }

    public final Object h(List<String> r100, Continuation<? super List<ConversationEntity>> r101) {
        if ((r101 instanceof ConversationDaoSource$getConversationsByConversationIds$1) == false) goto L7;
        ConversationDaoSource$getConversationsByConversationIds$1 r102 = (ConversationDaoSource$getConversationsByConversationIds$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        List r107 = (List) r104;
        if (r107 == null) goto L20;
        return r107;
    L20:
        return CollectionsKt.emptyList();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        ConversationDaoSource$getConversationsByConversationIds$2 r108 = new ConversationDaoSource$getConversationsByConversationIds$2(r100, null);
        r102.label = 1;
        r104 = a.b(r108, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new ConversationDaoSource$getConversationsByConversationIds$1(this, r101);
        goto L8
    }

    public final Object i(String r100, Continuation<? super Long> r101) {
        return a.b(new ConversationDaoSource$getCursor$2(r100, null), r101);
    }

    @Override // be9.b
    public final Object m(int r100, Continuation<? super List<String>> r101) {
        if (r100 > 0) goto L6;
        return CollectionsKt.emptyList();
    L6:
        return a.b(new ConversationDaoSource$getLocalCvsIdsWithLimit$2(r100, null), r101);
    }

    @Override // be9.b
    public final Object q(List<String> r100, Continuation<? super Integer> r101) {
        return a.b(new ConversationDaoSource$deleteConversations$2(r100, null), r101);
    }

    public final Object r(int r100, Continuation<? super List<ConversationSimpleEntity>> r101) {
        return a.b(new ConversationDaoSource$getSimpleCvsListWithLimit$2(r100, null), r101);
    }

    @Override // be9.b
    public final Object s(List<String> r100, Continuation<? super List<ConversationEntity>> r101) {
        if ((r101 instanceof ConversationDaoSource$getConversationListByIdsWithAuth$1) == false) goto L7;
        ConversationDaoSource$getConversationListByIdsWithAuth$1 r102 = (ConversationDaoSource$getConversationListByIdsWithAuth$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        List r107 = (List) r104;
        if (r107 == null) goto L20;
        return r107;
    L20:
        return CollectionsKt.emptyList();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        ConversationDaoSource$getConversationListByIdsWithAuth$2 r108 = new ConversationDaoSource$getConversationListByIdsWithAuth$2(r100, null);
        r102.label = 1;
        r104 = a.b(r108, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new ConversationDaoSource$getConversationListByIdsWithAuth$1(this, r101);
        goto L8
    }

    @Override // be9.b
    public final Object t(int r100, Continuation<? super List<ConversationEntity>> r101) {
        return a.b(new ConversationDaoSource$getSortedConversationsWithLimit$2(r100, null), r101);
    }

    public final Object A(String r100, String r101, Continuation<? super Integer> r102) {
        return a.b(new ConversationDaoSource$updateBriefMsgLocalId$2(r100, r101, null), r102);
    }

    public final Object B(ConversationEntity r100, ConversationEntity r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof ConversationDaoSource$updateConversation$1) == false) goto L7;
        ConversationDaoSource$updateConversation$1 r103 = (ConversationDaoSource$updateConversation$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = false;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        int r109 = r103.I$0;
        ConversationEntity r110 = (ConversationEntity) r103.L$1;
        ConversationEntity r111 = (ConversationEntity) r103.L$0;
        ResultKt.throwOnFailure(r105);
        int r112 = r109;
        r100 = r111;
    L24:
        com.larus.im.internal.delegate.a r113 = com.larus.im.internal.delegate.a.f348188b;
        StringBuilder r114 = new StringBuilder("old version(");
        r114.append(r100.getVersion());
        r114.append("), new version(");
        r114.append(r110.getVersion());
        r114.append("), updated = ");
        if (r112 == 0) goto L27;
        boolean r115 = true;
    L28:
        r114.append(r115);
        r113.i("ConversationDaoSource", r114.toString());
        if (r112 == 0) goto L32;
        r108 = true;
    L32:
        return Boxing.boxBoolean(r108);
    L27:
        r115 = false;
        goto L28
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        String r116 = r101.getConversationId();
        String r117 = r100.getConversationId();
        if (StringsKt.isBlank(r116) == true) goto L34;
        if (StringsKt.isBlank(r117) == true) goto L34;
        if (Intrinsics.areEqual(r116, r117) == false) goto L34;
        r110 = com.larus.im.internal.database.utils.g.b(r100, r101);
        r112 = !Intrinsics.areEqual(r110, r100) ? 1 : 0;
        r103.L$0 = r100;
        r103.L$1 = r110;
        r103.I$0 = r112;
        r103.label = 1;
        if (y(r100, r110, r103) != r106) goto L24;
        return r106;
    L34:
        return Boxing.boxBoolean(false);
    L7:
        r103 = new ConversationDaoSource$updateConversation$1(this, r102);
        goto L8
    }

    public final Object C(String r100, long r101, Continuation<? super Integer> r102) {
        return a.b(new ConversationDaoSource$updateLatestMessageIndex$2(r100, r101, null), r102);
    }

    public final Object D(String r100, String r101, Continuation<? super Integer> r102) {
        return a.b(new ConversationDaoSource$updateName$2(r100, r101, null), r102);
    }

    @Override // be9.b
    public final Object F(int r100, long r101, Continuation<? super List<ConversationEntity>> r102) {
        return a.b(new ConversationDaoSource$getPinConversationWithLimit$2(r100, r101, null), r102);
    }

    @Override // be9.b
    public final Object G(int r100, long r101, Continuation<? super List<ConversationEntity>> r102) {
        return a.b(new ConversationDaoSource$getNonPinConversationWithLimit$2(r100, r101, null), r102);
    }

    public final Object H(String r100, boolean r101, Continuation<? super Integer> r102) {
        return a.b(new ConversationDaoSource$updateTtsEnable$2(r100, r101, null), r102);
    }

    @Override // be9.b
    public final Object l(String r100, int r101, Continuation<? super List<ConversationEntity>> r102) {
        return a.b(new ConversationDaoSource$getConversationByBotId$2(r101, r100, null), r102);
    }

    @Override // be9.b
    public final Object n(String r100, long r101, Continuation<? super Integer> r102) {
        return a.b(new ConversationDaoSource$updateCursor$2(r100, r101, null), r102);
    }

    @Override // be9.b
    public final Object v(int r100, int r101, Continuation<? super List<ConversationEntity>> r102) {
        return a.b(new ConversationDaoSource$getSortedConversationsWithLimitByArchiveStatus$2(r100, r101, null), r102);
    }

    public final Object y(ConversationEntity r110, ConversationEntity r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof ConversationDaoSource$tryUpdateNew$1) == false) goto L7;
        ConversationDaoSource$tryUpdateNew$1 r100 = (ConversationDaoSource$tryUpdateNew$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        long r114 = r100.J$0;
        String r104 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L22:
        long r105 = SystemClock.elapsedRealtime() - r114;
        com.larus.im.internal.delegate.a.f348188b.i("ConversationDaoSource", "tryUpdateConversationNew(" + r104 + "): end, costTime:" + r105);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (Intrinsics.areEqual(r111, r110) == true) goto L17;
        String r115 = r110.getConversationId();
        long r106 = SystemClock.elapsedRealtime();
        com.larus.im.internal.delegate.a.f348188b.i("ConversationDaoSource", "tryUpdateConversationNew(" + r115 + "): begin");
        ConversationDaoSource$tryUpdateNew$2 r107 = new ConversationDaoSource$tryUpdateNew$2(r111, r110, null);
        r100.L$0 = r115;
        r100.J$0 = r106;
        r100.label = 1;
        if (a.b(r107, r100) != r102) goto L21;
        return r102;
    L21:
        r104 = r115;
        r114 = r106;
        goto L22
    L17:
        return Unit.INSTANCE;
    L7:
        r100 = new ConversationDaoSource$tryUpdateNew$1(this, r112);
        goto L8
    }

    public final Object z(String r100, int r101, Continuation<? super Integer> r102) {
        return a.b(new ConversationDaoSource$updateBadgeCount$2(this, r100, r101, null), r102);
    }

    @Override // be9.b
    public final Object E(int r100, long r101, int r110, Continuation<? super List<ConversationEntity>> r111) {
        return a.b(new ConversationDaoSource$getNonPinConversationWithLimitByArchiveStatus$2(r100, r101, r110, null), r111);
    }

    @Override // be9.b
    public final Object p(int r100, long r101, int r110, Continuation<? super List<ConversationEntity>> r111) {
        return a.b(new ConversationDaoSource$getPinConversationWithLimitByArchiveStatus$2(r100, r101, r110, null), r111);
    }

    @Override // be9.b
    public final Object u(String r100, int r101, boolean r102, Continuation<? super ConversationEntity> r103) {
        return a.b(new ConversationDaoSource$getConversationById$2(r101, r100, null), r103);
    }

    public final Object w(String r100, int r110, long r111, List<String> r112, Continuation<? super List<ConversationEntity>> r113) {
        return a.b(new ConversationDaoSource$searchConversationByFts$2(r100, r110, r111, r112, null), r113);
    }

    public final Object x(String r100, int r110, long r111, List<String> r112, Continuation<? super List<ConversationEntity>> r113) {
        return a.b(new ConversationDaoSource$searchConversationByLike$2(r100, r110, r111, r112, null), r113);
    }
}
