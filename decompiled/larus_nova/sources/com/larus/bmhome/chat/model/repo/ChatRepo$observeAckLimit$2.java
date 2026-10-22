package com.larus.bmhome.chat.model.repo;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.bmhome.chat.component.list.p7;
import com.larus.bmhome.chat.component.list.q7;
import com.larus.im.bean.IMMsgExt;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes25.dex */
public final class ChatRepo$observeAckLimit$2<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<wi8.a, Unit> f307649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChatRepo f307650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<wi8.a> f307651c;

    public ChatRepo$observeAckLimit$2(q7 r100, ChatRepo r101, p7 r102) {
        this.f307649a = r100;
        this.f307650b = r101;
        this.f307651c = r102;
    }

    public final Object a(IIMError r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof ChatRepo$observeAckLimit$2$emit$1) == false) goto L7;
        ChatRepo$observeAckLimit$2$emit$1 r100 = (ChatRepo$observeAckLimit$2$emit$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
    L43:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
    L39:
        ChatRepo r105 = this.f307650b;
        Function0<wi8.a> r106 = this.f307651c;
        Function1<wi8.a, Unit> r107 = this.f307649a;
        r100.label = 2;
        int r108 = ChatRepo.f307628f;
        if (r105.a(r106, r107, r100) != r103) goto L43;
        return r103;
    L16:
        ResultKt.throwOnFailure(r102);
        if (r110 != null) goto L21;
        return Unit.INSTANCE;
    L21:
        if (r110.getCode() != IMMsgExt.ERR_LIMIT) goto L45;
        Map<String, String> r109 = r110.getExt();
        if (r109 == null) goto L27;
        String r112 = r109.get("limit_time");
        if (r112 == null) goto L27;
        long r113 = CastLongProtector.parseLong(r112);
    L29:
        if (r113 <= 0) goto L45;
        FLogger.f375446a.i("ChatRepo", "Limit after ACK for " + r113);
        Function1<wi8.a, Unit> r114 = this.f307649a;
        Map<String, String> r115 = r110.getExt();
        if (r115 == null) goto L33;
        String r116 = r115.get("limit_tips");
    L34:
        if (r116 != null) goto L36;
        r116 = "";
    L36:
        r114.invoke(new wi8.a(r116, SystemClock.elapsedRealtime(), r113));
        r100.label = 1;
        if (DelayKt.delay(r113, r100) != r103) goto L39;
        return r103;
    L33:
        r116 = null;
    L27:
        r113 = 0;
    L45:
        return Unit.INSTANCE;
    L7:
        r100 = new ChatRepo$observeAckLimit$2$emit$1(this, r111);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
        return a((IIMError) r100, r101);
    }
}
