package i60;

import android.os.SystemClock;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingKey<Boolean> f488351a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SettingKey<Boolean> f488352b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SettingKey<Boolean> f488353c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f488354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f488355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f488356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f488357g;

    static {
        new SettingKey("live_mt_enable_instant_cpu_rate", "mt是否使用采取瞬时获取cpurate的方法，1为是", 1, 1);
        Boolean r100 = Boolean.FALSE;
        f488351a = new SettingKey("live_mt_enable_use_proc_file_cpu_rate", "mt是否在8.0以下使用proc计算CPU使用率", r100, r100);
        Boolean r101 = Boolean.TRUE;
        f488352b = new SettingKey("live_mt_enable_cpu_rate", "mt是否使用CPU利用率（proc/stat 或者 adb top）", r101, r101);
        f488353c = new SettingKey("live_mt_enable_cpu_speed_rate", "mt是否使用Jiffies计算CPU使用速率", r100, r100);
        f488354d = -1;
        f488355e = "";
        f488356f = -1;
        f488357g = "";
    }

    public static String a() {
        if (f488353c.getValue().booleanValue() == false) goto L11;
        if ((SystemClock.elapsedRealtime() - f488356f) <= 5000) goto L11;
        if (a.f488347b != null) goto L9;
        a.f488347b = new j60.a();
    L9:
        a.f488347b.a();
        Logger.d("CommonMonitorUtil", "cpu Rate: " + a.f488347b.f497480b + ", cpu speed" + a.f488347b.f497484f);
        f488357g = String.valueOf(a.f488347b.f497484f);
        f488356f = SystemClock.elapsedRealtime();
    L11:
        return f488357g;
    }

    public static String b() {
        if (f488352b.getValue().booleanValue() == false) goto L14;
        if ((SystemClock.elapsedRealtime() - f488354d) <= 5000) goto L14;
        if (a.c() == true) goto L9;
    L11:
        double r100 = a.d();
    L12:
        f488355e = String.valueOf(r100);
        f488354d = SystemClock.elapsedRealtime();
        goto L14
    L9:
        if (f488351a.getValue().booleanValue() == false) goto L11;
        r100 = a.b();
    L14:
        return f488355e;
    }
}
