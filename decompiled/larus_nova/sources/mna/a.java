package mna;

import android.content.Context;
import android.os.BatteryManager;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    static {
    }

    public static float a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("batterymanager");
        if ((r101 instanceof BatteryManager) == false) goto L5;
        BatteryManager r102 = (BatteryManager) r101;
    L6:
        if (r102 != null) goto L9;
        return 0.0f;
    L9:
        float r103 = r102.getLongProperty(2) / 1000;
        ILogDepend.f384986a.d("PowerMonitor", "CurrentMonitor getGalvanicNow: " + r103 + "mA");
        return r103;
    L5:
        r102 = null;
        goto L6
    }
}
