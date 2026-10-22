package com.optimize.statistics;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class ExceedTheLimitBitmapMonitor {
    private static final int BIG_REASON_FILE_TOO_LARGE = 1;
    private static final int BIG_REASON_RAM_TOO_LARGE = 3;
    private static final int BIG_REASON_RESOLUTION_TOO_LARGE = 2;
    private static final int DEFAULT_LIMIT_BITMAP_CONTRAST = 2;
    private static final long DEFAULT_LIMIT_FILE_SIZE = 20971520;
    private static final long DEFAULT_LIMIT_RAM_SIZE = 0;
    private static CustomExceedLimit mCustomExceedLimit;
    private static boolean sExceedTheLimitBitmapMonitorEnabled;
    private static int sLimitBitmapContrast;
    private static long sLimitFileSize;
    private static long sLimitRamSize;

    /* JADX INFO: loaded from: classes34.dex */
    public interface CustomExceedLimit {
        Pair<Integer, String> isBigImg(String r100, int r101, int r102, int r103);
    }

    public ExceedTheLimitBitmapMonitor() {
    }

    static {
        long r100 = getScreenPixelMemory();
        DEFAULT_LIMIT_RAM_SIZE = r100;
        sLimitBitmapContrast = 2;
        sLimitFileSize = DEFAULT_LIMIT_FILE_SIZE;
        sLimitRamSize = r100;
        sExceedTheLimitBitmapMonitorEnabled = false;
    }

    private static long getScreenPixelMemory() {
        DisplayMetrics r100 = INVOKEVIRTUAL_com_optimize_statistics_ExceedTheLimitBitmapMonitor_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem());
        return (r100.heightPixels * r100.widthPixels) * 4;
    }

    public static boolean isExceedTheLimitBitmapMonitorEnabled() {
        return sExceedTheLimitBitmapMonitorEnabled;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_optimize_statistics_ExceedTheLimitBitmapMonitor_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private static Pair<String, String> dealBigReason2(int r100) {
        if (r100 != 1) goto L5;
        String r101 = "1";
        String r102 = "1_filesize";
    L25:
        return new Pair(r101, r102);
    L5:
        if (r100 != 10) goto L7;
        r101 = "2";
        r102 = "2_resolution";
        goto L25
    L7:
        if (r100 != 11) goto L9;
        r101 = "1,2";
        r102 = "1_filesize,2_resolution";
        goto L25
    L9:
        if (r100 != 100) goto L11;
        r101 = "3";
        r102 = "3_ramsize";
        goto L25
    L11:
        if (r100 != 101) goto L13;
        r101 = "1,3";
        r102 = "1_filesize,3_ramsize";
        goto L25
    L13:
        if (r100 != 110) goto L15;
        r101 = "2,3";
        r102 = "2_resolution,3_ramsize";
        goto L25
    L15:
        if (r100 == 111) goto L17;
        r101 = "";
        r102 = "";
        goto L25
    L17:
        r101 = "1,2,3";
        r102 = "1_filesize,2_resolution,3_ramsize";
        goto L25
    }

    private static Pair<Integer, Integer> segmentAndCheckSize(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        String[] r101 = r100.split("x");
        if (r101.length == 2) goto L13;
        return null;
    L13:
        int r102 = CastIntegerProtector.parseInt(r101[0]);     // Catch: NumberFormatException -> L12
        int r103 = CastIntegerProtector.parseInt(r101[1]);     // Catch: NumberFormatException -> L12
        return new Pair(Integer.valueOf(r102), Integer.valueOf(r103));
    L15:
        return null;
    }

    public static void setCustomExceedLimit(CustomExceedLimit r100) {
        mCustomExceedLimit = r100;
    }

    public static void setExceedTheLimitBitmapMonitorEnabled(boolean r100) {
        sExceedTheLimitBitmapMonitorEnabled = r100;
    }

    public static void setBitmapMonitorLimit(long r100, int r101, long r102) {
        sLimitBitmapContrast = r101;
        sLimitFileSize = r100;
        sLimitRamSize = r102;
        PipelineDraweeController.setLimit(r101, r100, r102);
    }

    private static int computerContrast(int r100, int r101, int r102, int r103) {
        return Math.min((r102 * 1000) / r100, (r103 * 1000) / r101);
    }

    private static int checkLimit(int r100, int r101, int r102, int r103, long r104, long r105) {
        if (r104 < sLimitFileSize) goto L5;
        int r106 = 1;
    L6:
        if (r100 <= 0) goto L14;
        if (r101 <= 0) goto L14;
        if (r102 <= 0) goto L14;
        if (r103 <= 0) goto L14;
        if ((r102 * r103) <= ((r100 * r101) * sLimitBitmapContrast)) goto L14;
        r106 = r106 | 10;
    L14:
        if (r105 >= sLimitRamSize) goto L16;
        return r106;
    L16:
        return r106 | 100;
    L5:
        r106 = 0;
        goto L6
    }

    public static void checkAndReport(ImageRequest r210, String r211, int r212, String r213, String r214, String r215, String r216, long r217, String r310) {
        SizeDeterminer r100 = r210.getSizeDeterminer();
        int r101 = -1;
        if (r100 == null) goto L7;
        Pair<Integer, Integer> r102 = r100.getSize();
        if (r102 == null) goto L7;
        int r103 = ((Integer) r102.first).intValue();
        int r110 = ((Integer) r102.second).intValue();
        int r111 = r103;
    L8:
        Pair<Integer, Integer> r104 = segmentAndCheckSize(r216);
        if (r104 == null) goto L11;
        r101 = ((Integer) r104.first).intValue();
        int r105 = ((Integer) r104.second).intValue();
    L13:
        if (TextUtils.isEmpty(r310) == false) goto L15;
        long r106 = 0;
    L16:
        long r112 = r106;
        int r107 = checkLimit(r111, r110, r101, r105, r217, r112);
        boolean r108 = true;
        if (r107 <= 0) goto L19;
        boolean r109 = true;
    L20:
        Pair<String, String> r113 = dealBigReason2(r107);
        String r114 = (String) r113.first;
        String r115 = (String) r113.second;
        CustomExceedLimit r116 = mCustomExceedLimit;
        if (r116 == null) goto L41;
        Pair<Integer, String> r117 = r116.isBigImg(r211, r212, r101, r105);
        if (r117 != null) goto L26;
        r108 = false;
    L26:
        r109 = r109 | r108;
        if (r117 == null) goto L41;
        if (TextUtils.isEmpty(r114) == false) goto L31;
        String r118 = String.valueOf(((Integer) r117.first).intValue() + 10000);
    L32:
        Object r119 = r117.second;
        if (r119 != null) goto L35;
        String r120 = "";
    L37:
        if (TextUtils.isEmpty(r115) == false) goto L39;
        String r121 = (((Integer) r117.first).intValue() + 10000) + "_" + r120;
    L40:
        String r122 = r121;
        r114 = r118;
    L42:
        if (r109 == false) goto L49;
        String r123 = r210.getSourceUri().toString();
        if (r100 == null) goto L46;
        String r124 = ViewUtils.getViewInfo(r100.getView());
    L47:
        doReport(r123, r211, r212, r114, r122, r213, r214, r215, r217, r111, r110, r101, r105, r112, r124);
        return;
    L46:
        r124 = null;
        goto L47
    L49:
        return;
    L39:
        r121 = r115 + "," + (((Integer) r117.first).intValue() + 10000) + "_" + r120;
        goto L40
    L35:
        r120 = ((String) r119).replace(",", "，");
        goto L37
    L31:
        r118 = r114 + "," + (((Integer) r117.first).intValue() + 10000);
    L41:
        r122 = r115;
        goto L42
    L19:
        r109 = false;
        goto L20
    L15:
        r106 = CastLongProtector.parseLong(r310);
        goto L16
    L11:
        r105 = -1;
    L7:
        r111 = -1;
        r110 = -1;
        goto L8
    }

    private static void doReport(String r100, String r101, int r102, String r103, String r110, String r111, String r112, String r113, long r114, int r115, int r116, int r117, int r118, long r210, String r211) {
        if (FrescoCacheMonitorUtil.isOptMonitorSample() == false) goto L5;
    L6:
        int r104 = computerContrast(r115, r116, r117, r118);
        JSONObject r105 = new JSONObject();
        r105.put("url", r100);     // Catch: JSONException -> L10
        r105.put("image_type", r101);     // Catch: JSONException -> L10
        r105.put(FrescoMonitorConst.IMAGE_COUNT, r102);     // Catch: JSONException -> L10
        r105.put("bigimage_reason", r103);     // Catch: JSONException -> L10
        r105.put("description", r110);     // Catch: JSONException -> L10
        r105.put("biz_tag", r111);     // Catch: JSONException -> L10
        r105.put(FrescoMonitorConst.SCENE_TAG, r112);     // Catch: JSONException -> L10
        r105.put(FrescoMonitorConst.PAGE_TAG, r113);     // Catch: JSONException -> L10
        r105.put("file_size", r114);     // Catch: JSONException -> L10
        r105.put("view_width", r115);     // Catch: JSONException -> L10
        r105.put("view_height", r116);     // Catch: JSONException -> L10
        r105.put("image_width", r117);     // Catch: JSONException -> L10
        r105.put("image_height", r118);     // Catch: JSONException -> L10
        r105.put(HardwareInfo.KEY_HW_RAM_SIZE, r210);     // Catch: JSONException -> L10
        r105.put("contrast", r104);     // Catch: JSONException -> L10
        r105.put("view_info", r211);     // Catch: JSONException -> L10
        r105.put(FrescoMonitorConst.IMAGE_SDK_VERSION, "1.41.6");     // Catch: JSONException -> L10
    L8:
        MonitorUtils.monitorCommonLog(FrescoMonitorConst.MONITOR_IMAGE_Exceed_Limit_V2, r105);
        FrescoMonitor.onExceedLimitCallback(r105);
        return;
    L5:
        if (FrescoMonitor.getLogTypeSwitch(FrescoMonitorConst.MONITOR_IMAGE_Exceed_Limit_V2) == true) goto L6;
    }
}
