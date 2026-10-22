package com.larus.livetutor.impl.rtc;

import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.larus.livetutor.impl.rtc.api.RTCAction;
import com.larus.livetutor.impl.rtc.api.RTCException;
import com.larus.livetutor.impl.rtc.api.RpcException;
import com.larus.livetutor.impl.rtc.handler.RTCMonitor;
import com.larus.media.LossFocusType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.livetutor.impl.rtc.TutorRTCServiceImpl$connect2RTCService$1$2", f = "TutorRTCServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TutorRTCServiceImpl$connect2RTCService$1$2 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TutorRTCServiceImpl this$0;

    public TutorRTCServiceImpl$connect2RTCService$1$2(TutorRTCServiceImpl r100, Continuation<? super TutorRTCServiceImpl$connect2RTCService$1$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        TutorRTCServiceImpl$connect2RTCService$1$2 r102 = new TutorRTCServiceImpl$connect2RTCService$1$2(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Throwable r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Throwable r100, Continuation<? super Unit> r101) {
        return ((TutorRTCServiceImpl$connect2RTCService$1$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r100);
        Throwable r101 = (Throwable) this.L$0;
        TutorRTCServiceImpl r102 = this.this$0;
        int r103 = TutorRTCServiceImpl.D;
        r102.getClass();
        if ((r101 instanceof RpcException) == false) goto L8;
        r102.f().b(false, RTCMonitor.Companion.ErrorType.REALTIME_START_API_ERROR, r101.getMessage());
        com.larus.livetutor.impl.rtc.handler.m r104 = r102.e();
        StringBuilder r105 = new StringBuilder("接口请求失败 ");
        RpcException r106 = (RpcException) r101;
        r105.append(r106.getCode());
        r105.append(' ');
        r105.append(r101.getMessage());
        r104.a("TutorRTCServiceImpl", r105.toString());
        r102.h().b(new RTCAction.ConnectFail(RTCMonitor.Companion.BusinessErrorType.RTC_START_CALL_ERROR.getValue(), r106.getCode(), r101.getMessage()));
    L22:
        return Unit.INSTANCE;
    L8:
        if ((r101 instanceof NetworkNotAvailabeException) == false) goto L11;
        r102.f().b(false, RTCMonitor.Companion.ErrorType.REALTIME_START_API_ERROR, r101.getMessage());
        r102.e().a("TutorRTCServiceImpl", "网络异常 " + fm9.a.b(r101) + ' ' + r101.getMessage());
        r102.h().b(new RTCAction.ConnectFail(RTCMonitor.Companion.BusinessErrorType.RTC_START_CALL_ERROR.getValue(), fm9.a.b(r101), r101.getMessage()));
        goto L22
    L11:
        if ((r101 instanceof RTCException) == false) goto L20;
        int r107 = TutorRTCServiceImpl.b.f356262a[((RTCException) r101).getErrorCode().ordinal()];
        if (r107 != 1) goto L15;
        RTCMonitor.Companion.ErrorType r108 = RTCMonitor.Companion.ErrorType.CREATE_ENGINE_FAIL;
    L19:
        r102.f().b(false, r108, r101.getMessage());
        com.larus.livetutor.impl.rtc.handler.m r109 = r102.e();
        StringBuilder r110 = new StringBuilder("RTC内部错误 ");
        RTCException r111 = (RTCException) r101;
        r110.append(r111.getErrorCode());
        r110.append(' ');
        r110.append(r101.getMessage());
        r109.a("TutorRTCServiceImpl", r110.toString());
        r102.h().b(new RTCAction.ConnectFail(RTCMonitor.Companion.BusinessErrorType.RTC_OTHER_ERROR.getValue(), r111.getErrorCode().getCode(), r101.getMessage()));
        goto L22
    L15:
        if (r107 == 2) goto L17;
        r108 = RTCMonitor.Companion.ErrorType.UNKNOWN;
        goto L19
    L17:
        r108 = RTCMonitor.Companion.ErrorType.RTC_JOIN_ROOM_ERROR;
        goto L19
    L20:
        r102.h().b(new RTCAction.ConnectFail(RTCMonitor.Companion.BusinessErrorType.RTC_OTHER_ERROR.getValue(), LossFocusType.UNKNOWN_FOCUS_CHANGE, r101.getMessage()));
        goto L22
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
