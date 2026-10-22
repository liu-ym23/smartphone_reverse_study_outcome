package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.MmRecordingHistoryUploadAgeInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.l;
import iub.k;
import java.io.File;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingHistoryUploadResumeTracker {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f434470c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingSession f434471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434472b;

    public static final class a {
    }

    static {
    }

    public MmRecordingHistoryUploadResumeTracker(MmRecordingSession r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingSession");
        this.f434471a = r100;
        this.f434472b = r100.f434098b;
    }

    public final Object b(String r210, Continuation<? super Unit> r211) {
        String r100 = r210;
        if ((r211 instanceof MmRecordingHistoryUploadResumeTracker$track$1) == false) goto L7;
        MmRecordingHistoryUploadResumeTracker$track$1 r101 = (MmRecordingHistoryUploadResumeTracker$track$1) r211;
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
        List<? extends File> r106 = (List) r101.L$2;
        MmRecordingCommonParam r107 = (MmRecordingCommonParam) r101.L$1;
        String r108 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r110 = r108;
        MmRecordingCommonParam r109 = r107;
    L23:
        MmRecordingHistoryUploadAgeInfo r111 = (MmRecordingHistoryUploadAgeInfo) r103;
        k r112 = this.f434471a.f434102f;
        if (r112 == null) goto L29;
        MmRecordingSource r113 = r112.f495846a;
        if (r113 == null) goto L29;
        String r114 = r113.name();
        if (r114 == null) goto L29;
    L30:
        lvb.a.e("MmHistoryUploadResumeTracker", "[track] send resume event, meetingId=" + r110 + ", traceId=" + this.f434471a.f434099c + ", source=" + r114 + ", ageInfo=" + r111 + ", pendingSegmentCount=" + r106.size());
        d r115 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.f434675c;
        String r116 = this.f434471a.f434099c;
        MmRecordingSource r117 = r109.getSource();
        if (r117 != null) goto L36;
        k r118 = this.f434471a.f434102f;
        if (r118 == null) goto L35;
        r117 = r118.f495846a;
        goto L36
    L35:
        r117 = null;
    L36:
        MmRecordingCommonParam r119 = MmRecordingCommonParam.copy$default(r109, null, r110, false, null, r110, null, r116, r117, null, null, null, 1837, null);
        int r120 = r106.size();
        r115.getClass();
        Intrinsics.checkNotNullParameter(r119, "commonParam");
        Intrinsics.checkNotNullParameter(r114, "source");
        Intrinsics.checkNotNullParameter(r111, "ageInfo");
        lvb.a.e("MmRecordingUploadMetrics", "[trackHistoryUploadResume] recordId=" + r119.getTrackerRecordId() + ", traceId=" + r119.getRecordingTraceId() + ", source=" + r114 + ", ageInfo=" + r111 + ", pendingSegmentCount=" + r120);
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r121 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r121.e("source", r114);
        r121.c("age_ms", r111.f434659a);
        r121.e("age_bucket", r111.f434660b);
        r121.b("is_over_24h", r111.f434661c ? 1 : 0);
        r121.b("pending_segment_count", r120);
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a("recording_history_upload_resume", r119, r121.a());
        if (r111.f434661c == false) goto L40;
        l.i(this.f434471a.b(), "upload", Boxing.boxInt(-10024), "expired_over_24h", null, null, null, null, null, 4080);
    L40:
        return Unit.INSTANCE;
    L29:
        r114 = "history_recording";
        goto L30
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        MmRecordingCommonParam r122 = (MmRecordingCommonParam) r101.L$1;
        String r123 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        MmRecordingCommonParam r124 = r122;
        r100 = r123;
    L19:
        List<? extends File> r125 = (List) r103;
        r101.L$0 = r100;
        r101.L$1 = r124;
        r101.L$2 = r125;
        r101.label = 2;
        Object r126 = a(r100, r125, r101);
        if (r126 != r104) goto L22;
        return r104;
    L22:
        r110 = r100;
        r106 = r125;
        r103 = r126;
        r109 = r124;
        goto L23
    L16:
        ResultKt.throwOnFailure(r103);
        lvb.a.e("MmHistoryUploadResumeTracker", "[track] start, meetingId=" + r100);
        String r127 = this.f434472b.getCurrentUserId();
        r124 = this.f434471a.j();
        r101.L$0 = r100;
        r101.L$1 = r124;
        r101.label = 1;
        r103 = BuildersKt.withContext(MMCoroutines.a(), new MmRecordingHistoryUploadResumeTracker$getHistorySegmentFiles$2(r127, r100, null), r101);
        if (r103 != r104) goto L19;
        return r104;
    L7:
        r101 = new MmRecordingHistoryUploadResumeTracker$track$1(this, r211);
        goto L8
    }

    public final Object a(String r110, List<? extends File> r111, Continuation<? super MmRecordingHistoryUploadAgeInfo> r112) {
        if ((r112 instanceof MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$1) == false) goto L7;
        MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$1 r100 = (MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L17:
        Long r114 = (Long) r113;
        if (r114 == null) goto L41;
        lvb.a.e("MmHistoryUploadResumeTracker", "[resolveHistoryUploadAgeInfo] use latest segment file mtime, meetingId=" + r110 + ", latestSegmentFileMtime=" + r114);
        int r115 = MmRecordingHistoryUploadAgeInfo.f434658d;
        long r105 = System.currentTimeMillis();
        if (r114.longValue() <= 0) goto L43;
        long r106 = Math.max(0, r105 - r114.longValue());
        if (r106 >= 0) goto L26;
        String r116 = MmRecordingHistoryUploadAgeInfo.AgeBucket.UNKNOWN.getValue();
    L36:
        if (r106 >= 86400000) goto L40;
        r104 = false;
    L40:
        return new MmRecordingHistoryUploadAgeInfo(r106, r116, r104);
    L26:
        if (r106 >= 3600000) goto L29;
        r116 = MmRecordingHistoryUploadAgeInfo.AgeBucket.WITHIN_1H.getValue();
        goto L36
    L29:
        if (r106 >= 21600000) goto L32;
        r116 = MmRecordingHistoryUploadAgeInfo.AgeBucket.BETWEEN_1H_6H.getValue();
        goto L36
    L32:
        if (r106 >= 86400000) goto L34;
        r116 = MmRecordingHistoryUploadAgeInfo.AgeBucket.BETWEEN_6H_24H.getValue();
        goto L36
    L34:
        r116 = MmRecordingHistoryUploadAgeInfo.AgeBucket.EXPIRED_24H.getValue();
        goto L36
    L43:
        return new MmRecordingHistoryUploadAgeInfo(-1, MmRecordingHistoryUploadAgeInfo.AgeBucket.UNKNOWN.getValue(), false);
    L41:
        lvb.a.h("MmHistoryUploadResumeTracker", "[resolveHistoryUploadAgeInfo] age unknown, meetingId=" + r110);
        return new MmRecordingHistoryUploadAgeInfo(-1, MmRecordingHistoryUploadAgeInfo.AgeBucket.UNKNOWN.getValue(), false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        ExecutorCoroutineDispatcher r117 = MMCoroutines.a();
        MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1 r107 = new MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1(r111, null);
        r100.L$0 = r110;
        r100.label = 1;
        r113 = BuildersKt.withContext(r117, r107, r100);
        if (r113 != r102) goto L17;
        return r102;
    L7:
        r100 = new MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$1(this, r112);
        goto L8
    }
}
