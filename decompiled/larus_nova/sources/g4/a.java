package g4;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    static {
    }

    public static boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 33) goto L12;
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L12;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_COARSE_LOCATION") == (-1)) goto L9;
    L15:
        return true;
    L9:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_FINE_LOCATION") != (-1)) goto L15;
    L16:
        return false;
    L12:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_COARSE_LOCATION") == (-1)) goto L16;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_FINE_LOCATION") == (-1)) goto L16;
        goto L15
    }

    public static boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 28) goto L17;
        Object r101 = r100.getSystemService("location");
        if ((r101 instanceof LocationManager) == false) goto L7;
        LocationManager r102 = (LocationManager) r101;
    L8:
        if (r102 != null) goto L20;
        return false;
    L20:
        return r102.isLocationEnabled();
    L7:
        r102 = null;
        goto L8
    L17:
        if (Settings.Secure.getInt(r100.getContentResolver(), LocationMonitorConst.LOCATION_MODE) == 0) goto L21;
        return true;
    L21:
        return false;
    L14:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
