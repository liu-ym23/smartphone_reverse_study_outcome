package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.helper;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryStatus;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import lvb.a;

/* JADX INFO: loaded from: classes37.dex */
public final class MmSummaryNetReconnectHelper extends MmBaseNetReconnectHelper {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MmRecordingSummaryRepo f435355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f435356h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f435357i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f435358j;

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final void f() {
        a.e(this.f435356h, "onNetworkStatusChanged, net unAvailable");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final long c() {
        return this.f435358j;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final long d() {
        return this.f435357i;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final String e() {
        return this.f435356h;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper
    public final Object b(Continuation<? super Unit> r100) {
        if ((r100 instanceof MmSummaryNetReconnectHelper$doFetch$1) == false) goto L7;
        MmSummaryNetReconnectHelper$doFetch$1 r101 = (MmSummaryNetReconnectHelper$doFetch$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L19:
        this.f435355g.l().x("NetworkReconnect");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (this.f435355g.l().m().f435343e != MmSummaryStatus.MeetingAISummaryOpenError) goto L19;
        a.e(this.f435356h, "doFetch, status is Error, retry meetingAISwitch first");
        this.f435355g.l().P0();
        r101.label = 1;
        if (DelayKt.delay(1000, r101) != r104) goto L19;
        return r104;
    L7:
        r101 = new MmSummaryNetReconnectHelper$doFetch$1(this, r100);
        goto L8
    }

    public MmSummaryNetReconnectHelper(MmRecordingRepo r100, MmRecordingSummaryRepo r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingRepo");
        Intrinsics.checkNotNullParameter(r101, "summaryRepo");
        CoroutineScope r102 = r101.d();
        Intrinsics.checkNotNullParameter(r100, "recordingRepo");
        Intrinsics.checkNotNullParameter(r102, "scope");
        super(r100.n().f434973c, r102);
        this.f435355g = r101;
        this.f435356h = "MmSummaryNetReconnectHelper";
        this.f435357i = 2000;
        this.f435358j = 1500;
    }
}
