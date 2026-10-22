package zb6;

import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571150a = null;

    static {
        int[] r100 = new int[LinkMonitor.LogLevel.values().length];
        f571150a = r100;
        r100[LinkMonitor.LogLevel.ERROR.ordinal()] = 1;
        r100[LinkMonitor.LogLevel.INFO.ordinal()] = 2;
        r100[LinkMonitor.LogLevel.WARN.ordinal()] = 3;
        r100[LinkMonitor.LogLevel.DEBUG.ordinal()] = 4;
    }
}
