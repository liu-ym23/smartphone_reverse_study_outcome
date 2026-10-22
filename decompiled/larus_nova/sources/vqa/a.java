package vqa;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f556785a = null;

    static {
        ArrayList r100 = new ArrayList();
        f556785a = r100;
        r100.add("SswoActivity");
    }

    public static int a(Context r100) {
        PowerManager r101 = (PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Throwable -> L19
        if (r101 != null) goto L7;
        return 0;
    L7:
        if (r101.isInteractive() == true) goto L10;
        return 1;
    L10:
        KeyguardManager r102 = (KeyguardManager) r100.getSystemService("keyguard");     // Catch: Throwable -> L19
        if (r102 != null) goto L13;
        return 0;
    L13:
        if (r102.inKeyguardRestrictedInputMode() == false) goto L17;
        return 2;
    L17:
        return 3;
    L19:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }
}
