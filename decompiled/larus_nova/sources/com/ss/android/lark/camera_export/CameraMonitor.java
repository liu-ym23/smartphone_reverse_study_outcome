package com.ss.android.lark.camera_export;

import android.os.Build;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u001c\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/camera_export/CameraMonitor;", "", "<init>", "()V", "TAG", "", "EVENT_KEY_CAMERA_SUPPORT_PREVIEW_SIZES", "EVENT_KEY_CAMERA_RESULT", "deviceModel", "reportCameraSupportPreviewSizes", "", "sizes", "", "Lkotlin/Pair;", "", "reportCameraResult", "result", "Lcom/ss/android/lark/camera_export/CameraMonitor$CameraResult;", "is16V9", "", "pair", "CameraResult", "lark-camera-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraMonitor {
    private static final String EVENT_KEY_CAMERA_RESULT = "camera_result_dev";
    private static final String EVENT_KEY_CAMERA_SUPPORT_PREVIEW_SIZES = "camera_support_preview_sizes_dev";
    public static final CameraMonitor INSTANCE = null;
    private static final String TAG = "CameraMonitor";
    private static final String deviceModel = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/camera_export/CameraMonitor$CameraResult;", "", "camera", "", DBDefinition.MIME_TYPE, "resolution", "size", "", "duration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getCamera", "()Ljava/lang/String;", "getMimeType", "getResolution", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDuration", "toString", "lark-camera-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CameraResult {
        private final String camera;
        private final Long duration;
        private final String mimeType;
        private final String resolution;
        private final Long size;

        public String toString() {
            return "camera:" + this.camera + ",mimeType:" + this.mimeType + ",resolution:" + this.resolution + ",size:" + this.size + ",duration:" + this.duration + ",deviceModel:" + CameraMonitor.access$getDeviceModel$p();
        }

        public final String getCamera() {
            return this.camera;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public final String getResolution() {
            return this.resolution;
        }

        public final Long getSize() {
            return this.size;
        }

        public CameraResult(String r100, String r101, String r102, Long r103, Long r104) {
            this.camera = r100;
            this.mimeType = r101;
            this.resolution = r102;
            this.size = r103;
            this.duration = r104;
        }
    }

    private CameraMonitor() {
    }

    static {
        INSTANCE = new CameraMonitor();
        deviceModel = Build.MODEL.toLowerCase(Locale.ROOT);
    }

    public static final /* synthetic */ String access$getDeviceModel$p() {
        return deviceModel;
    }

    private final boolean is16V9(Pair<Integer, Integer> r100) {
        int r101 = RangesKt.coerceAtMost(r100.getFirst().intValue(), r100.getSecond().intValue());
        if ((r101 * 16) != (RangesKt.coerceAtLeast(r100.getFirst().intValue(), r100.getSecond().intValue()) * 9)) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final void reportCameraResult(CameraResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Log.i(TAG, "reportCameraResult, " + r100);
        Statistics.sendEvent(EVENT_KEY_CAMERA_RESULT, new JSONObject().put("camera", r100.getCamera()).put("mime_type", r100.getMimeType()).put("resolution", r100.getResolution()).put("size", r100.getSize()).put("duration", r100.getDuration()).put("device_model", deviceModel));
    }

    @JvmStatic
    public static final void reportCameraSupportPreviewSizes(List<Pair<Integer, Integer>> r100) {
        Intrinsics.checkNotNullParameter(r100, "sizes");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (INSTANCE.is16V9((Pair) r103) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
        String r105 = null;
        String r106 = "";
        String r107 = "";
    L10:
        if (r104.hasNext() == false) goto L25;
        Pair r108 = (Pair) r104.next();
        if (r105 != null) goto L14;
    L17:
        boolean r109 = true;
    L18:
        if (r109 == false) goto L20;
        String r110 = "";
    L21:
        StringBuilder r111 = new StringBuilder();
        r111.append(((Number) r108.getSecond()).intValue());
        r111.append('*');
        r111.append(((Number) r108.getFirst()).intValue());
        String r112 = r111.toString();
        if ((((Number) r108.getSecond()).intValue() * ((Number) r108.getFirst()).intValue()) <= 2073600) goto L24;
        r107 = r112;
    L24:
        r105 = r110 + r112;
        goto L10
    L20:
        r110 = r105 + ',';
        goto L21
    L14:
        if (r105.length() == 0) goto L17;
        r109 = false;
        goto L18
    L25:
        DevicePerfUtils.DevicePerfLevel r113 = DevicePerfUtils.d();
        if (r113 == null) goto L31;
        String r114 = r113.getValue();
        if (r114 == null) goto L31;
        r106 = r114;
    L31:
        if (r105 == null) goto L33;
        Statistics.sendEvent(EVENT_KEY_CAMERA_SUPPORT_PREVIEW_SIZES, new JSONObject().put("resolutions", r105).put("min_hd_resolution", r107).put("device_model", deviceModel).put(IPerformanceStrategyManager.KEY_INT_DEVICE_LEVEL, r106));
    L33:
        Log.i(TAG, "reportCameraSupportPreviewSizes, resolutions:" + r105 + ", minHDResolution:" + r107 + ", deviceModel:" + deviceModel + ", deviceLevel:" + r106);
    }
}
