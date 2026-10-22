package com.larus.im.internal.network.channel;

import android.os.SystemClock;
import com.larus.im.bean.bot.BotCreateParam;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IMError;
import com.larus.im.internal.FlowIMSdkImpl;
import com.larus.im.internal.protocol.model.BotBody;
import com.larus.im.internal.protocol.model.CommonResponse;
import com.larus.im.internal.tracking.FlowImTracingProxy;
import com.larus.im.internal.tracking.m;
import gd9.t;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import ouc.e0;
import ouc.j;
import uc9.s;

/* JADX INFO: loaded from: classes30.dex */
public final class BotApiChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BotApiChannel f349043a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f349044b = null;

    public BotApiChannel() {
    }

    static {
        f349043a = new BotApiChannel();
        f349044b = "BotApiChannel";
    }

    public static final t a(BotApiChannel r100) {
        r100.getClass();
        FlowIMSdkImpl.Companion.getClass();
        return FlowIMSdkImpl.access$getInstance$cp().getFlowIMHttpApi$core_release();
    }

    public static final com.larus.im.internal.network.e c(BotApiChannel r110, gd9.e r111) {
        r110.getClass();
        if (r111.c() == false) goto L20;
        String r100 = r111.f480968d;
        wt7.c r101 = wt7.a.f561230a;
        juc.d<com.larus.im.internal.protocol.model.a> r102 = com.larus.im.internal.protocol.model.a.Companion.serializer();
        r101.getClass();
        com.larus.im.internal.protocol.model.a r103 = (com.larus.im.internal.protocol.model.a) wt7.c.a(r100, r102);
        if (r103 == null) goto L21;
        int r112 = r103.f349787a;
        if (r112 != 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L17;
        List<BotBody> r105 = r103.a();
        if (r105 != null) goto L16;
        r105 = CollectionsKt.emptyList();
    L16:
        com.larus.im.internal.network.e r106 = new com.larus.im.internal.network.e.f(r105, null, 6);
    L19:
        return r106;
    L17:
        r106 = new com.larus.im.internal.network.e.d(new IMError(r112, r103.f349788b, null, null, 12, null), null, 6);
        goto L19
    L11:
        r104 = false;
        goto L12
    L21:
        return new com.larus.im.internal.network.e.d(new IMError(-1, "json parse error", null, null, 12, null), null, 6);
    L20:
        return new com.larus.im.internal.network.e.b(new IMError(r111.f480966b, r111.f480969e, null, null, 12, null), "");
    }

    public static Object e(BotCreateParam r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotApiChannel$requireCreateBot$2(r100, null), r101);
    }

    public static Object f(BotModel r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotApiChannel$requireDeleteBot$2(r100, null), r101);
    }

    public static Object h(s r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotApiChannel$requireUpdateBot$2(r100, null), r101);
    }

    public static com.larus.im.internal.network.e i(gd9.e r110, juc.d r111) {
        if (r110.c() == false) goto L5;
        String r112 = r110.f480968d;
        wt7.c r100 = wt7.a.f561230a;
        juc.d r113 = CommonResponse.Companion.serializer(r111);
        r100.getClass();
        CommonResponse r114 = (CommonResponse) wt7.c.a(r112, r113);
        if (r114 != null) goto L11;
        return new com.larus.im.internal.network.e.d(new IMError(-1, "json parse error", null, null, 12, null), null, 6);
    L11:
        if (r114.getCode() != 0) goto L13;
        boolean r101 = true;
    L14:
        if (r101 == false) goto L17;
        return new com.larus.im.internal.network.e.f(r114.getData(), null, 6);
    L17:
        return new com.larus.im.internal.network.e.d(new IMError(r114.getCode(), r114.getMsg(), null, null, 12, null), null, 6);
    L13:
        r101 = false;
        goto L14
    L5:
        return new com.larus.im.internal.network.e.b(new IMError(r110.f480966b, r110.f480969e, null, null, 12, null), "");
    }

    public static Object g(List r100, String r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BotApiChannel$requireGetBotList$2(r100, r101, null), r102);
    }

    public final Object d(String r100, String r101, Continuation<? super com.larus.im.internal.network.e<BotBody>> r102) {
        if ((r102 instanceof BotApiChannel$requireBot$1) == false) goto L7;
        BotApiChannel$requireBot$1 r103 = (BotApiChannel$requireBot$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L18:
        return com.larus.im.internal.network.stragery.f.b((com.larus.im.internal.network.e) r105, new a());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        List r108 = CollectionsKt.listOf(r100);
        r103.label = 1;
        r105 = g(r108, r101, r103);
        if (r105 != r106) goto L18;
        return r106;
    L7:
        r103 = new BotApiChannel$requireBot$1(this, r102);
        goto L8
    }

    public static final com.larus.im.internal.network.e b(BotApiChannel r100, String r110, juc.d r111, Function0 r112) {
        r100.getClass();
        long r101 = SystemClock.elapsedRealtime();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(i((gd9.e) r112.invoke(), r111));     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L11;
        com.larus.im.internal.delegate.a.f348188b.e(f349044b, r110 + " error: " + r104.getMessage());
        r103 = new com.larus.im.internal.network.e.d(new IMError(-1, r104.getMessage(), r104, null, 8, null), null, 6);
    L11:
        com.larus.im.internal.network.e r105 = (com.larus.im.internal.network.e) r103;
        FlowImTracingProxy r106 = FlowImTracingProxy.f350219a;
        long r107 = com.larus.im.internal.network.stragery.a.a(r101);
        int r108 = m.a(r105);
        int r109 = r105.a().getCode();
        e0 r113 = new e0();
        j.c(r113, "msg", r105.a().getTips());
        Unit r114 = Unit.INSTANCE;
        r106.A(r110, r107, r108, r109, r113.a());
        return r105;
    L5:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
