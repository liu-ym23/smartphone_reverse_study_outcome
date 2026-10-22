package com.larus.disk.impl;

import androidx.camera.video.AudioStats;
import com.larus.applog.api.IApplog;
import com.larus.disk.api.ManualCacheCleanError;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f330729a = 0;

    static {
    }

    public static double g(long r100) {
        return RangesKt.coerceAtLeast(r100, 0) / 1048576.0d;
    }

    @JvmStatic
    public static final void d(List<m0> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bizFileInfoList");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (((m0) r104).f330762g <= LynxResourceModule.DEFAULT_MEDIA_SIZE) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        r105 = false;
        goto L9
    L11:
        Iterator r106 = r102.iterator();
    L13:
        if (r106.hasNext() == false) goto L19;
        m0 r107 = (m0) r106.next();
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L17
        r108.putOpt("path", r107.f330756a);     // Catch: Exception -> L17
        r108.putOpt("biz", r107.f330758c);     // Catch: Exception -> L17
        r108.putOpt("business", r107.f330759d);     // Catch: Exception -> L17
        r108.putOpt("is_internal", Boolean.valueOf(r107.f330760e));     // Catch: Exception -> L17
        r108.putOpt("is_directory", Boolean.valueOf(r107.f330761f));     // Catch: Exception -> L17
        r108.putOpt("biz_file_threshold", Long.valueOf(r107.f330765j));     // Catch: Exception -> L17
        r108.putOpt("is_over_threshold", Boolean.valueOf(r107.f330766k));     // Catch: Exception -> L17
        r108.putOpt("clean_type", Integer.valueOf(r101));     // Catch: Exception -> L17
        JSONObject r109 = new JSONObject();     // Catch: Exception -> L17
        r109.putOpt("file_size", Long.valueOf(r107.f330762g));     // Catch: Exception -> L17
        r109.putOpt("report_file_size", Double.valueOf(r107.f330763h));     // Catch: Exception -> L17
        r109.putOpt("child_file_count", Integer.valueOf(r107.f330764i));     // Catch: Exception -> L17
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("app_disk_scan_biz_file", r108, r109, null);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        FLogger.f375446a.e("AppDiskLogger", "report Slardar event failed event=app_disk_scan_biz_file", e);
        goto L13
    }

    public static void e(String r100, Function0 r101) {
        IApplog.f287053a.reportEvent(r100, (JSONObject) r101.invoke());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        FLogger.f375446a.e("AppDiskLogger", "report TEA event failed event=".concat(r100), e);
    }

    public static double f(long r100, long r110) {
        if (r110 > 0) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return RangesKt.coerceIn(r100, 0, r110) / r110;
    }

    public static /* synthetic */ void b(int r110, String r111, long r112, long r210, boolean r211, boolean r212, Boolean r213, String r214, ManualCacheCleanError r215, int r216) {
        if ((r216 & 8) == 0) goto L5;
        long r100 = -1;
    L7:
        if ((r216 & 16) == 0) goto L9;
        long r101 = -1;
    L11:
        if ((r216 & 32) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r216 & 64) == 0) goto L17;
        boolean r113 = false;
    L19:
        if ((r216 & 128) == 0) goto L21;
        Boolean r114 = null;
    L23:
        if ((r216 & 256) == 0) goto L25;
        String r115 = null;
    L27:
        if ((r216 & 512) == 0) goto L29;
        ManualCacheCleanError r116 = ManualCacheCleanError.NONE;
    L30:
        a(null, r110, r111, r100, r101, r102, r113, r114, r115, r116, false, false, false);
        return;
    L29:
        r116 = r215;
        goto L30
    L25:
        r115 = r214;
        goto L27
    L21:
        r114 = r213;
        goto L23
    L17:
        r113 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }

    @JvmStatic
    public static final void a(final a r110, final int r111, final String r112, final long r210, final long r211, final boolean r212, final boolean r213, final Boolean r214, final String r215, final ManualCacheCleanError r216, final boolean r217, final boolean r310, final boolean r311) {
        Intrinsics.checkNotNullParameter(r112, "status");
        Intrinsics.checkNotNullParameter(r216, "error");
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L24
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L24
        if (r110 == null) goto L7;
        r100.putOpt("before_total_data_size", Double.valueOf(r110.f330603a));     // Catch: Exception -> L24
        r100.putOpt("before_total_cache_size", Double.valueOf(r110.f330604b));     // Catch: Exception -> L24
        r100.putOpt("after_total_data_size", Double.valueOf(r110.f330605c));     // Catch: Exception -> L24
        r100.putOpt("after_total_cache_size", Double.valueOf(r110.f330606d));     // Catch: Exception -> L24
        r100.putOpt("clean_total_handler_size", Double.valueOf(r110.f330607e));     // Catch: Exception -> L24
        r100.putOpt("clean_total_size", Double.valueOf(r110.f330608f));     // Catch: Exception -> L24
        r100.putOpt("time_cost", Long.valueOf(r110.f330612j));     // Catch: Exception -> L24
    L7:
        if (r210 < 0) goto L10;
        r100.putOpt("before_cleanable_bytes", Long.valueOf(r210));     // Catch: Exception -> L24
    L10:
        if (r211 < 0) goto L12;
        r100.putOpt("remaining_cleanable_bytes", Long.valueOf(r211));     // Catch: Exception -> L24
    L12:
        r101.putOpt("status", r112);     // Catch: Exception -> L24
        r101.putOpt("is_manual", Boolean.valueOf(r212));     // Catch: Exception -> L24
        r101.putOpt("is_custom_biz_clean", Boolean.valueOf(r213));     // Catch: Exception -> L24
        if (r110 == null) goto L15;
        Boolean r102 = Boolean.valueOf(r110.f330609g);     // Catch: Exception -> L24
    L16:
        if (r102 == null) goto L18;
        r101.putOpt("is_low_disk", Boolean.valueOf(r102.booleanValue()));     // Catch: Exception -> L24
    L18:
        r101.putOpt("clean_type", Integer.valueOf(r111));     // Catch: Exception -> L24
        r101.putOpt("task_id", r215);     // Catch: Exception -> L22
        r101.putOpt("error_code", r216.getCode());     // Catch: Exception -> L22
        r101.putOpt("error_reason", r216.getReason());     // Catch: Exception -> L22
        r101.putOpt(FlowNetworkIDLStub.OMNI_UPLOAD_FAILURE_STAGE_KEY, r216.getStage());     // Catch: Exception -> L22
        r101.putOpt("root_cache_failed", Boolean.valueOf(r217));     // Catch: Exception -> L22
        r101.putOpt("configured_path_failed", Boolean.valueOf(r310));     // Catch: Exception -> L22
        r101.putOpt("business_handler_failed", Boolean.valueOf(r311));     // Catch: Exception -> L22
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("app_disk_clean", r101, r100, null);     // Catch: Exception -> L22
    L27:
        e("app_disk_clean_result", new f(r111, r112, r212, r213, r215, r216, r217, r310, r311, r110, r214, r210, r211));
        return;
    L22:
        e = e;
    L26:
        FLogger.f375446a.e("AppDiskLogger", "report Slardar event failed event=app_disk_clean", e);
        goto L27
    L15:
        r102 = r214;
    L24:
        e = e;
        goto L26
    }

    @JvmStatic
    public static final void c(String r100, int r101, String r110, String r111, String r112, long r113, long r114, long r115, long r116, long r210, boolean r211, boolean r212, String r213) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r110, "business");
        Intrinsics.checkNotNullParameter(r111, "bizTag");
        Intrinsics.checkNotNullParameter(r112, "status");
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L14
        r102.putOpt("task_id", r100);     // Catch: Exception -> L14
        r102.putOpt("clean_type", Integer.valueOf(r101));     // Catch: Exception -> L14
        r102.putOpt("business", r110);     // Catch: Exception -> L14
        r102.putOpt("biz", r111);     // Catch: Exception -> L14
        r102.putOpt("status", r112);     // Catch: Exception -> L14
        r102.putOpt("is_manual", Boolean.valueOf(r211));     // Catch: Exception -> L14
        r102.putOpt("is_low_disk", Boolean.valueOf(r212));     // Catch: Exception -> L14
        r102.putOpt("error_type", r213);     // Catch: Exception -> L14
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L14
        if (r113 < 0) goto L7;
        r103.putOpt("before_total_bytes", Long.valueOf(r113));     // Catch: Exception -> L14
    L7:
        if (r114 < 0) goto L9;
        r103.putOpt("before_cleanable_bytes", Long.valueOf(r114));     // Catch: Exception -> L14
    L9:
        r103.putOpt("cleaned_bytes", Long.valueOf(RangesKt.coerceAtLeast(r115, 0)));     // Catch: Exception -> L14
        if (r116 < 0) goto L12;
        r103.putOpt("remaining_cleanable_bytes", Long.valueOf(r116));     // Catch: Exception -> L14
    L12:
        r103.putOpt("duration_ms", Long.valueOf(RangesKt.coerceAtLeast(r210, 0)));     // Catch: Exception -> L14
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("app_disk_handler_clean", r102, r103, null);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        FLogger.f375446a.e("AppDiskLogger", "report Slardar event failed event=app_disk_handler_clean", e);
    }
}
