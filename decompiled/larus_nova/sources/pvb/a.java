package pvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingCreateMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.utils.statistics.PerfLog;
import iub.j;
import iub.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f530821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f530822b;

    public a(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentContext");
        this.f530821a = r100;
        this.f530822b = "MmRecordingPreChecker";
    }

    public final boolean a(k r100, iub.a<j, ? super MmRecordingError> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r100.f495851f != MmRecordingCreateMode.OFFLINE_LOCAL) goto L7;
        lvb.a.e(this.f530822b, "[preCheck] skip rtcService check in offline mode");
        return true;
    L7:
        if (this.f530821a.P() != null) goto L10;
        lvb.a.b(this.f530822b, "[preCheck] rtcService is null");
        qvb.a r102 = qvb.a.f534934a;
        MmRecordingError.RtcServiceNotAvailable r103 = MmRecordingError.RtcServiceNotAvailable.INSTANCE;
        r102.d(Integer.valueOf(r103.getErrorCode()), "rtc_service_not_available", r103.getErrorMsg(), "error");
        r101.a(r103);
        return false;
    L10:
        return true;
    }
}
