package com.larus.im.internal.database.delegate;

import android.os.SystemClock;
import com.larus.im.internal.database.dao.BotDao;
import com.larus.im.internal.database.entity.BotEntity;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BotDaoSource implements be9.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f347922e = 0;

    public static final class a {
        public static final BotDao a() {
            int r100 = BotDaoSource.f347922e;
            com.larus.im.internal.database.b.f347916a.getClass();
            return com.larus.im.internal.database.b.a.b().botDao();
        }

        public a() {
        }

        public static final Object b(Function1 r100, Continuation r101) {
            int r102 = BotDaoSource.f347922e;
            com.larus.im.internal.database.b.f347916a.getClass();
            com.larus.im.internal.database.b.a.b();
            return com.larus.im.internal.database.d.a(r100, r101);
        }
    }

    static {
        new a();
    }

    public BotDaoSource() {
    }

    public final Object a(String r100, Continuation<? super Integer> r101) {
        return a.b(new BotDaoSource$deleteBotById$2(r100, null), r101);
    }

    public final Object b(String r100, Continuation<? super List<BotEntity>> r101) {
        return a.b(new BotDaoSource$getBotByConversationId$2(r100, null), r101);
    }

    @Override // be9.a
    public final Object d(BotEntity r100, Continuation<? super Unit> r101) {
        Object r102 = a.b(new BotDaoSource$insertBot$2(r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // be9.a
    public final Object g(List<String> r100, Continuation<? super List<BotEntity>> r101) {
        return a.b(new BotDaoSource$getBotsByIds$2(r100, null), r101);
    }

    @Override // be9.a
    public final Object j(String r100, Continuation<? super BotEntity> r101) {
        return a.b(new BotDaoSource$getBotById$2(r100, null), r101);
    }

    public final Object c(BotEntity r110, BotEntity r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof BotDaoSource$tryUpdateNew$1) == false) goto L7;
        BotDaoSource$tryUpdateNew$1 r100 = (BotDaoSource$tryUpdateNew$1) r112;
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
        com.larus.im.internal.delegate.a.f348188b.i("BotDaoSource", "tryUpdateBotNew(" + r104 + "): end, costTime:" + r105);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (Intrinsics.areEqual(r111, r110) == true) goto L17;
        String r115 = r110.getBotId();
        long r106 = SystemClock.elapsedRealtime();
        com.larus.im.internal.delegate.a.f348188b.i("BotDaoSource", "tryUpdateBotNew(" + r115 + "): begin");
        BotDaoSource$tryUpdateNew$2 r107 = new BotDaoSource$tryUpdateNew$2(r111, r110, null);
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
        r100 = new BotDaoSource$tryUpdateNew$1(this, r112);
        goto L8
    }

    public final Object e(BotEntity r100, BotEntity r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof BotDaoSource$updateBot$1) == false) goto L7;
        BotDaoSource$updateBot$1 r103 = (BotDaoSource$updateBot$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        int r109 = r103.I$0;
        ResultKt.throwOnFailure(r105);
    L25:
        if (r109 != 0) goto L29;
        r108 = false;
    L29:
        return Boxing.boxBoolean(r108);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        wt7.c r110 = wt7.a.f561230a;
        juc.d<BotEntity> r111 = BotEntity.Companion.serializer();
        r110.getClass();
        String r112 = wt7.c.b(r100, r111);
        if (r112 != null) goto L18;
        r112 = "";
    L18:
        if (r112.length() <= 2097152) goto L21;
        com.larus.im.internal.delegate.a.f348188b.e("BotDaoSource", "bot size over 2mb");
        return Boxing.boxBoolean(false);
    L21:
        BotEntity r113 = com.larus.im.internal.database.utils.g.a(r101, r100);
        int r114 = !Intrinsics.areEqual(r113, r101) ? 1 : 0;
        r103.I$0 = r114;
        r103.label = 1;
        if (c(r101, r113, r103) != r106) goto L24;
        return r106;
    L24:
        r109 = r114;
    L7:
        r103 = new BotDaoSource$updateBot$1(this, r102);
        goto L8
    }
}
