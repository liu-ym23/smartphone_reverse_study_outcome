package y50;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f566216a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f566217b = null;

    static {
        int[] r100 = new int[LiveTracingMonitorKt.EventModule.values().length];
        f566216a = r100;
        r100[LiveTracingMonitorKt.EventModule.PK.ordinal()] = 1;
        r100[LiveTracingMonitorKt.EventModule.MULTI_LINKER.ordinal()] = 2;
        r100[LiveTracingMonitorKt.EventModule.MEDIA_MULTI_LINKER.ordinal()] = 3;
        r100[LiveTracingMonitorKt.EventModule.SCREEN_LINKER.ordinal()] = 4;
        int[] r101 = new int[LiveTracingMonitorKt.EventType.values().length];
        f566217b = r101;
        r101[LiveTracingMonitorKt.EventType.BUSSINESS_API_CALL.ordinal()] = 1;
        r101[LiveTracingMonitorKt.EventType.SERVER_API_CALL.ordinal()] = 2;
        r101[LiveTracingMonitorKt.EventType.MESSAGE_RECEIVED.ordinal()] = 3;
        r101[LiveTracingMonitorKt.EventType.SDK_INTERFACE_CALL.ordinal()] = 4;
        r101[LiveTracingMonitorKt.EventType.SDK_CALLBACK.ordinal()] = 5;
    }
}
