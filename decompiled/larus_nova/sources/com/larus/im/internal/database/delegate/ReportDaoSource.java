package com.larus.im.internal.database.delegate;

import com.larus.im.internal.database.dao.MessageDao;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final class ReportDaoSource implements be9.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReportDaoSource f347927b = null;

    static {
        f347927b = new ReportDaoSource();
    }

    public ReportDaoSource() {
    }

    public static final MessageDao a() {
        com.larus.im.internal.database.b.f347916a.getClass();
        return com.larus.im.internal.database.b.a.b().messageDao();
    }

    public final Object b(Continuation<? super Long> r100) {
        return j(new ReportDaoSource$getAllBotCount$2(null), r100);
    }

    public final Object c(Continuation<? super Long> r100) {
        return j(new ReportDaoSource$getAllCvsCount$2(null), r100);
    }

    public final Object d(ContinuationImpl r100) {
        return j(new ReportDaoSource$getAllMsgCount$2(null), r100);
    }

    public final Object e(Continuation<? super Long> r100) {
        return j(new ReportDaoSource$getAllParticipantCount$2(null), r100);
    }

    public final Object f(Continuation<? super Long> r100) {
        return j(new ReportDaoSource$getMainCvsMsgCount$2(null), r100);
    }

    public final Object g(Continuation<? super Long> r100) {
        return j(new ReportDaoSource$getNewBlockCount$2(null), r100);
    }

    public final Object h(Continuation<? super Long> r100) {
        if ((r100 instanceof ReportDaoSource$getOtherMsgCount$1) == false) goto L7;
        ReportDaoSource$getOtherMsgCount$1 r101 = (ReportDaoSource$getOtherMsgCount$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        long r106 = r101.J$0;
        ResultKt.throwOnFailure(r103);
    L23:
        long r107 = r106 - ((Number) r103).longValue();
        com.larus.im.internal.delegate.a.f348188b.i("ReportDaoSource", "getOtherMsgCount, result:" + r107);
        return Boxing.boxLong(r107);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
    L19:
        long r108 = ((Number) r103).longValue();
        r101.J$0 = r108;
        r101.label = 2;
        r103 = f(r101);
        if (r103 != r104) goto L22;
        return r104;
    L22:
        r106 = r108;
        goto L23
    L16:
        ResultKt.throwOnFailure(r103);
        r101.label = 1;
        r103 = d(r101);
        if (r103 != r104) goto L19;
        return r104;
    L7:
        r101 = new ReportDaoSource$getOtherMsgCount$1(this, r100);
        goto L8
    }

    public final Object i(Continuation<? super Long> r100) {
        return j(new ReportDaoSource$getTotalBlockCount$2(null), r100);
    }

    public static Object j(Function1 r100, Continuation r101) {
        com.larus.im.internal.database.b.f347916a.getClass();
        com.larus.im.internal.database.b.a.b();
        return com.larus.im.internal.database.d.a(r100, r101);
    }
}
