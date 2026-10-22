package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingNotificationRepo$opt$1 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmRecordingNotificationRepo f435045a;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c
    public final i1<a> b() {
        return this.f435045a.g();
    }

    @Override // fvb.a
    public final void onDestroy() {
        this.f435045a.i();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c
    public final Object m() {
        return (a) c.a.a(this);
    }

    public MmRecordingNotificationRepo$opt$1(MmRecordingNotificationRepo r100) {
        this.f435045a = r100;
    }

    public final Object T0(b r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1) == false) goto L7;
        MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1 r100 = (MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r112);
    L35:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (b) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L19:
        a r104 = (a) m();
        if ((r110 instanceof b.d) == false) goto L23;
        a r113 = a.a(r104, ((b.d) r110).f435053a, false, false, false, 14);
    L31:
        MmRecordingNotificationRepo r114 = this.f435045a;
        r100.L$0 = null;
        r100.label = 2;
        if (r114.b(r113, r100) != r102) goto L35;
        return r102;
    L23:
        if ((r110 instanceof b.a) == false) goto L26;
        r113 = a.a(r104, false, true, false, false, 13);
        goto L31
    L26:
        if ((r110 instanceof b.c) == false) goto L29;
        r113 = a.a(r104, false, false, ((b.c) r110).f435052a, false, 11);
        goto L31
    L29:
        if ((r110 instanceof b.C5188b) == false) goto L37;
        r113 = a.a(r104, false, false, false, ((b.C5188b) r110).f435051a, 7);
        goto L31
    L37:
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r112);
        MmRecordingNotificationRepo r115 = this.f435045a;
        r100.L$0 = r110;
        r100.label = 1;
        if (r115.k(r110, r100) != r102) goto L19;
        return r102;
    L7:
        r100 = new MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1(this, r111);
        goto L8
    }
}
