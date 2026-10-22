package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import iub.j;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes37.dex */
public final class MmHardwareLiveRecordingCapacityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hub.a f433667a;

    public static final class a implements iub.a<j, MmRecordingError> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<Result<j>> f433668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<j, Unit> f433669b;

        @Override // iub.a
        public final void a(MmRecordingError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            if (this.f433668a.isActive() == false) goto L6;
            i<Result<j>> r101 = this.f433668a;
            Result.Companion r102 = Result.Companion;
            r101.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r100.getErrorCode() + ':' + r100.getErrorMsg()))))));
            return;
        }

        @Override // iub.a
        public final void onSuccess(j r100) {
            final j r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            i<Result<j>> r102 = this.f433668a;
            Result<j> r103 = Result.m9448boximpl(Result.m9449constructorimpl(r101));
            final Function1<j, Unit> r104 = this.f433669b;
            r102.h(r103, new MmHardwareLiveRecordingCapacityDelegate$awaitResult$2$1$onSuccess$1(r104, r101));
        }

        public a(kotlinx.coroutines.j r100, Function1 r101) {
            this.f433668a = r100;
            this.f433669b = r101;
        }
    }

    public MmHardwareLiveRecordingCapacityDelegate(hub.a r100) {
        Intrinsics.checkNotNullParameter(r100, "capacity");
        this.f433667a = r100;
    }

    public final Object a(Function1<? super j, Unit> r100, Function1<? super iub.a<j, ? super MmRecordingError>, Unit> r101, Continuation<? super Result<j>> r102) {
        if ((r102 instanceof MmHardwareLiveRecordingCapacityDelegate$awaitResult$1) == false) goto L7;
        MmHardwareLiveRecordingCapacityDelegate$awaitResult$1 r103 = (MmHardwareLiveRecordingCapacityDelegate$awaitResult$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        Function1 r108 = (Function1) r103.L$1;
        Function1 r109 = (Function1) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L20:
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        kotlinx.coroutines.j r110 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r103), 1);
        r110.C();
        r101.invoke(new a(r110, r100));
        r105 = r110.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L17:
        if (r105 != r106) goto L20;
        return r106;
    L7:
        r103 = new MmHardwareLiveRecordingCapacityDelegate$awaitResult$1(this, r102);
        goto L8
    }
}
