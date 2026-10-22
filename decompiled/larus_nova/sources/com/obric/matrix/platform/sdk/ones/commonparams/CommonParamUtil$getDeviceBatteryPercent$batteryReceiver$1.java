package com.obric.matrix.platform.sdk.ones.commonparams;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/matrix/platform/sdk/ones/commonparams/CommonParamUtil$getDeviceBatteryPercent$batteryReceiver$1", "Landroid/content/BroadcastReceiver;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final class CommonParamUtil$getDeviceBatteryPercent$batteryReceiver$1 extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "intent");
        r101.getIntExtra("level", -1);
        r101.getIntExtra("scale", -1);
        throw null;
    }
}
