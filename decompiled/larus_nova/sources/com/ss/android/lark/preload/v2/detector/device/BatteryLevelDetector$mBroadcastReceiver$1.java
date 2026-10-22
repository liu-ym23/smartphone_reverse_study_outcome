package com.ss.android.lark.preload.v2.detector.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import m1c.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/ss/android/lark/preload/v2/detector/device/BatteryLevelDetector$mBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "preload-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BatteryLevelDetector$mBroadcastReceiver$1 extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        r101.getIntExtra("level", 0);
        int r102 = a.f511630d;
        throw null;
    }
}
