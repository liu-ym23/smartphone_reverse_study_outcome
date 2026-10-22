package vub;

import android.content.Context;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@OfficeSDKUserScope
public final class b implements com.ss.android.lark.officesdk.minutes.api.hardware.a {
    @Inject
    public b() {
    }

    public final void a(Context r100, MmRecordingUILaunchMode r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uiLaunchMode");
    }

    @Override // com.ss.android.lark.officesdk.minutes.api.hardware.a
    public final void Kc(Context r100, MmRecordingUILaunchMode r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uiLaunchMode");
        a(r100, r101);
    }
}
