package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.MinutesForegroundService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService;
import com.ss.android.lark.utils.UIHelper;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes37.dex */
public final class MmSoftwareHistoryRecordingStateHandler extends f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f434558h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f434561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f434562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f434563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f434564g;

    public static final class Companion {
        public Companion() {
        }

        public final Object a(Function1<? super Continuation<? super String>, ? extends Object> r100, Function1<? super Throwable, Unit> r101, Continuation<? super String> r102) {
            if ((r102 instanceof MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1) == false) goto L7;
            MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1 r103 = (MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1) r102;
            int r104 = r103.label;
            if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
            r103.label = r104 - Integer.MIN_VALUE;
        L8:
            Object r105 = r103.result;
            Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r107 = r103.label;
            if (r107 == 0) goto L16;
            if (r107 != 1) goto L15;
            r101 = (Function1) r103.L$0;
            ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L22
        L20:
            return (String) r105;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r105);
            r103.L$0 = r101;     // Catch: Throwable -> L22
            r103.label = 1;     // Catch: Throwable -> L22
            r105 = r100.invoke(r103);     // Catch: Throwable -> L22
            if (r105 != r106) goto L20;
            return r106;
        L22:
            th = move-exception;
            if ((th instanceof CancellationException) == true) goto L27;
            r101.invoke(th);
            return null;
        L27:
            throw th;
        L7:
            r103 = new MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1(this, r102);
            goto L8
        }
    }

    static {
        f434558h = new Companion();
    }

    public final MmRecordingStatesSyncService d() {
        return (MmRecordingStatesSyncService) this.f434562e.getValue();
    }

    public MmSoftwareHistoryRecordingStateHandler(final MmRecordingSession r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingSession");
        super(r100);
        this.f434559b = "MmHistoryRecordingHandler";
        this.f434560c = r100.f434098b;
        this.f434561d = LazyKt.lazy(new MmSoftwareHistoryRecordingStateHandler$networkService$2(this));
        this.f434562e = LazyKt.lazy(new MmSoftwareHistoryRecordingStateHandler$syncService$2(r100));
        this.f434563f = LazyKt.lazy(new MmSoftwareHistoryRecordingStateHandler$uploadService$2(r100));
        this.f434564g = LazyKt.lazy(new MmSoftwareHistoryRecordingStateHandler$historyUploadResumeTracker$2(r100));
    }

    public static final Object c(MmSoftwareHistoryRecordingStateHandler r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof MmSoftwareHistoryRecordingStateHandler$buildHistoryForegroundNotificationAction$1) == false) goto L7;
        MmSoftwareHistoryRecordingStateHandler$buildHistoryForegroundNotificationAction$1 r102 = (MmSoftwareHistoryRecordingStateHandler$buildHistoryForegroundNotificationAction$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        String r108 = ((ovb.b) r104).f526982a;
        if (StringsKt.isBlank(r108) == false) goto L22;
        r108 = r100.f434594a.f434101e;
        if (r108 != null) goto L22;
        r108 = "";
    L22:
        MmRecordingSource r109 = r100.d().q(r108);
        if (r109 != null) goto L25;
    L27:
        r107 = false;
    L28:
        if (r107 == false) goto L35;
        if (r109 != MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION) goto L32;
        int r110 = R.string.LarkVC_Recording_AiTransRecordGen_Button;
    L36:
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.d(UIHelper.getString(r110), "", MinutesForegroundService.ForegroundServiceType.DATA_SYNC);
    L32:
        r110 = R.string.MMWeb_AIInterpret_AITransRecordGen_Text;
        goto L36
    L35:
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.d(UIHelper.getString(R.string.LarkCCM_DoubaoVC_RecordingSummary_Tab), UIHelper.getString(R.string.MMWeb_DoubaoVC_GeneratingMinutes_Desc), MinutesForegroundService.ForegroundServiceType.DATA_SYNC);
    L25:
        if (r109.isStandaloneAIInterpretationSource() != true) goto L27;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        MmRecordingSession r111 = r100.f434594a;
        r102.label = 1;
        r104 = r111.r(r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new MmSoftwareHistoryRecordingStateHandler$buildHistoryForegroundNotificationAction$1(r100, r101);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f
    public final void a(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r110) {
        Intrinsics.checkNotNullParameter(r100, "oldState");
        Intrinsics.checkNotNullParameter(r110, "newState");
        lvb.a.e(this.f434559b, "onStateChanged: " + r100 + " -> " + r110);
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C5181c.f434646c) == false) goto L6;
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmSoftwareHistoryRecordingStateHandler$onStateChanged$1(this, null), 3, null);
        return;
    L6:
        if ((r110 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L9;
        d().F(r110);
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmSoftwareHistoryRecordingStateHandler$onStateChanged$2(this, null), 3, null);
        return;
    L9:
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.f434652c) == false) goto L12;
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmSoftwareHistoryRecordingStateHandler$onStateChanged$3(this, null), 3, null);
        return;
    L12:
        if (Intrinsics.areEqual(r110, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.f434657c) == false) goto L14;
        ((MmRecordingUploadService) this.f434563f.getValue()).k();
        String r101 = this.f434594a.f434119w.f526982a;
        MmRecordingStatesSyncService r111 = d();
        r111.getClass();
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        String r102 = r111.l().t(r101);
        lvb.a.e(r111.f434433c, "[sourceSessionKey] get result, meetingId:" + r101 + ", sessionKey:" + r102);
        lvb.a.e(this.f434559b, "[historyUploadCleanup] uploaded, meetingId=" + r101 + ", sourceSessionKey=" + r102);
        BuildersKt.launch$default(this.f434594a.f434117u, null, null, new MmSoftwareHistoryRecordingStateHandler$onStateChanged$4(this, r101, r102, null), 3, null);
        return;
    L14:
        Unit r103 = Unit.INSTANCE;
    }
}
