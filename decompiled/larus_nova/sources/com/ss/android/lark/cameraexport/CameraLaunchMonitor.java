package com.ss.android.lark.cameraexport;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\u0011\u001a\u00020\u0010H\u0007J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/cameraexport/CameraLaunchMonitor;", "", "<init>", "()V", "TAG", "", "EVENT_KEY_CAMERA_START", "MAX_DURATION", "", "isFirstOpen", "", "cpuUsage", "", "pageStartTime", "cameraStartTime", "onOpenPageStart", "", "onOpenCameraStart", "onOpenCameraEnd", "type", "lark-camera-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraLaunchMonitor {
    private static final String EVENT_KEY_CAMERA_START = "camera_start_dev";
    public static final CameraLaunchMonitor INSTANCE = null;
    private static final long MAX_DURATION = 3000;
    private static final String TAG = "CameraLaunchMonitor";
    private static long cameraStartTime;
    private static double cpuUsage;
    private static boolean isFirstOpen;
    private static long pageStartTime;

    private CameraLaunchMonitor() {
    }

    static {
        INSTANCE = new CameraLaunchMonitor();
        isFirstOpen = true;
    }

    @JvmStatic
    public static final void onOpenCameraStart() {
        cameraStartTime = System.currentTimeMillis();
    }

    @JvmStatic
    public static final void onOpenCameraEnd(String r110) {
        Intrinsics.checkNotNullParameter(r110, "type");
        long r100 = cameraStartTime - pageStartTime;
        long r101 = System.currentTimeMillis() - cameraStartTime;
        int r102 = 1;
        if (1 <= r100) goto L5;
    L7:
        boolean r111 = false;
    L8:
        if (r111 == true) goto L10;
        return;
    L10:
        if (1 <= r101) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L30;
        JSONObject r104 = new JSONObject();
        JSONObject r112 = r104.put("type", r110);     // Catch: Exception -> L23
        if (isFirstOpen == true) goto L21;
        r102 = 0;
    L21:
        r112.put("is_first_open", r102).put("cpu_usage", cpuUsage).put("open_page_duration", r100).put("open_camera_duration", r101);     // Catch: Exception -> L23
    L25:
        Log.i(TAG, "report camera start json:" + r104);
        Statistics.sendEvent(EVENT_KEY_CAMERA_START, r104);
        isFirstOpen = false;
        return;
    L23:
        e = move-exception;
        Log.e(TAG, e.toString());
        goto L25
    L30:
        return;
    L12:
        if (r101 >= 3000) goto L14;
        r103 = true;
        goto L15
    L5:
        if (r100 >= 3000) goto L7;
        r111 = true;
        goto L8
    }

    @JvmStatic
    public static final void onOpenPageStart(double r100) {
        cpuUsage = r100;
        pageStartTime = System.currentTimeMillis();
    }
}
