package tx9;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class r {
    public static void b(String r100, String r101, String r102, by7.e r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "clickFrom");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.put("click_from", r100);     // Catch: JSONException -> L8
        r104.put("current_page", r101);     // Catch: JSONException -> L8
        if (r102 == null) goto L6;
        r104.put("disk_operation_id", r102);     // Catch: JSONException -> L8
    L6:
        r104.put("disk_schema_version", 2);     // Catch: JSONException -> L8
    L10:
        by7.a r105 = new by7.a("click_clear_cache");
        if (r103 == null) goto L13;
        r105.f21464b = r103;
    L13:
        TrackParams r106 = new TrackParams().merge(r104);
        r105.f21463a.merge(r106);
        r105.b();
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("CacheCleanEventHelper", "build click clear cache event failed", e);
        goto L10
    }

    public static void a(String r110, long r111, String r112, String r113, String r114, String r115, String r116, String r210, Long r211, Long r212, Long r213) {
        JSONObject r100 = new JSONObject();
        Intrinsics.checkNotNullParameter(r110, "status");
        Intrinsics.checkNotNullParameter(r112, "operationId");
        Intrinsics.checkNotNullParameter(r113, "errorCode");
        Intrinsics.checkNotNullParameter(r114, HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON);
        Intrinsics.checkNotNullParameter(r115, "failureStage");
        Intrinsics.checkNotNullParameter(r116, "failureOwner");
        Intrinsics.checkNotNullParameter(r210, "currentPage");
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.put("disk_clean_status", r110);     // Catch: JSONException -> L21
        if (r211 != null) goto L6;
    L8:
        if (r212 != null) goto L10;
    L12:
        if (r213 != null) goto L14;
    L16:
        r100.put("disk_clean_duration_ms", RangesKt.coerceAtLeast(r111, 0));     // Catch: JSONException -> L21
        if ((!StringsKt.isBlank(r112)) == false) goto L19;
        r100.put("disk_operation_id", r112);     // Catch: JSONException -> L21
    L19:
        r100.put("disk_error_code", r113);     // Catch: JSONException -> L21
        r100.put("disk_error_reason", r114);     // Catch: JSONException -> L21
        r100.put("disk_failure_stage", r115);     // Catch: JSONException -> L21
        r100.put("disk_failure_owner", r116);     // Catch: JSONException -> L21
        r100.put("current_page", r210);     // Catch: JSONException -> L21
        r100.put("disk_schema_version", 2);     // Catch: JSONException -> L21
    L23:
        by7.a r101 = new by7.a("clear_cache_result");
        r101.f21463a.merge(new TrackParams().merge(r100));
        r101.b();
        return;
    L14:
        if (r213.longValue() < 0) goto L16;
        r100.put("reclaimed_bytes", r213.longValue());     // Catch: JSONException -> L21
        goto L16
    L10:
        if (r212.longValue() < 0) goto L12;
        r100.put("remaining_bytes", r212.longValue());     // Catch: JSONException -> L21
        goto L12
    L6:
        if (r211.longValue() < 0) goto L8;
        r100.put("before_bytes", r211.longValue());     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        FLogger.f375446a.e("CacheCleanEventHelper", "build clear cache result event failed", e);
        goto L23
    }
}
