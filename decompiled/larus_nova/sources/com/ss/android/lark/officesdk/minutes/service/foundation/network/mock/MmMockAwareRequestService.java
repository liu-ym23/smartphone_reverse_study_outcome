package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.squareup.wire.Message;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler;
import com.ss.android.lark.pb.improto.Command;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmMockAwareRequestService implements com.ss.android.lark.officesdk.minutes.service.foundation.network.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.network.b f433937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f433938b;

    public MmMockAwareRequestService(MmNetRequestHandler r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "real");
        Intrinsics.checkNotNullParameter(r101, "mockEngine");
        this.f433937a = r100;
        this.f433938b = r101;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.b
    public final <R> Object c(Class<R> r110, gvb.a r210, Continuation<? super Result<? extends R>> r211) {
        if ((r211 instanceof MmMockAwareRequestService$sendHttpRequest$1) == false) goto L7;
        MmMockAwareRequestService$sendHttpRequest$1 r100 = (MmMockAwareRequestService$sendHttpRequest$1) r211;
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
        return ((Result) r102).m9458unboximpl();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        gvb.a r105 = (gvb.a) r100.L$1;
        Class<R> r106 = (Class) r100.L$0;
        ResultKt.throwOnFailure(r102);
        gvb.a r111 = r105;
        Class<R> r107 = r106;
    L19:
        e r108 = (e) r102;
        if ((r108 instanceof e.a) == false) goto L24;
        return ((e.a) r108).f433951a;
    L24:
        if (Intrinsics.areEqual(r108, e.b.f433952a) == false) goto L30;
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r109 = this.f433937a;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 2;
        Object r112 = r109.c(r107, r111, r100);
        if (r112 != r103) goto L31;
        return r103;
    L31:
        return r112;
    L30:
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r102);
        g r113 = this.f433938b;
        r107 = r110;
        r100.L$0 = r107;
        r111 = r210;
        r100.L$1 = r111;
        r100.label = 1;
        r113.getClass();
        r102 = r113.b(new d("http", r210.getClass().getName(), new c(r210, r210.getPath(), r210.getMethod(), r210.a(), r210.f(), r210.c()), null, 8), r100);
        if (r102 != r103) goto L19;
        return r103;
    L7:
        r100 = new MmMockAwareRequestService$sendHttpRequest$1(this, r211);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.b
    public final <R> Object a(Command r110, Class<R> r111, Message<?, ?> r112, Continuation<? super Result<? extends R>> r113) {
        if ((r113 instanceof MmMockAwareRequestService$sendServerPbRequest$1) == false) goto L7;
        MmMockAwareRequestService$sendServerPbRequest$1 r100 = (MmMockAwareRequestService$sendServerPbRequest$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r114);
        return ((Result) r114).m9458unboximpl();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r112 = (Message) r100.L$2;
        r111 = (Class) r100.L$1;
        r110 = (Command) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L19:
        e r115 = (e) r114;
        if ((r115 instanceof e.a) == false) goto L24;
        return ((e.a) r115).f433951a;
    L24:
        if (Intrinsics.areEqual(r115, e.b.f433952a) == false) goto L30;
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r116 = this.f433937a;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 2;
        Object r117 = r116.a(r110, r111, r112, r100);
        if (r117 != r102) goto L31;
        return r102;
    L31:
        return r117;
    L30:
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r114);
        g r118 = this.f433938b;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.L$2 = r112;
        r100.label = 1;
        r118.getClass();
        r114 = r118.b(new d("server_pb", r110.getName(), null, r112, 4), r100);
        if (r114 != r102) goto L19;
        return r102;
    L7:
        r100 = new MmMockAwareRequestService$sendServerPbRequest$1(this, r113);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.b
    public final <R> Object b(com.bytedance.lark.pb.basic.v1.Command r110, Class<R> r111, Message<?, ?> r112, Continuation<? super Result<? extends R>> r113) {
        if ((r113 instanceof MmMockAwareRequestService$sendPbRequest$1) == false) goto L7;
        MmMockAwareRequestService$sendPbRequest$1 r100 = (MmMockAwareRequestService$sendPbRequest$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r114);
        return ((Result) r114).m9458unboximpl();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r112 = (Message) r100.L$2;
        r111 = (Class) r100.L$1;
        r110 = (com.bytedance.lark.pb.basic.v1.Command) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L19:
        e r115 = (e) r114;
        if ((r115 instanceof e.a) == false) goto L24;
        return ((e.a) r115).f433951a;
    L24:
        if (Intrinsics.areEqual(r115, e.b.f433952a) == false) goto L30;
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r116 = this.f433937a;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 2;
        Object r117 = r116.b(r110, r111, r112, r100);
        if (r117 != r102) goto L31;
        return r102;
    L31:
        return r117;
    L30:
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r114);
        g r118 = this.f433938b;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.L$2 = r112;
        r100.label = 1;
        r118.getClass();
        r114 = r118.b(new d("client_pb", r110.getName(), null, r112, 4), r100);
        if (r114 != r102) goto L19;
        return r102;
    L7:
        r100 = new MmMockAwareRequestService$sendPbRequest$1(this, r113);
        goto L8
    }
}
