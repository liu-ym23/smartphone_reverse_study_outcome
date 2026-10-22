package ska;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.platform.api.IVKService;
import com.obric.assistant.cocreationreview.s3;
import com.obric.memorydata.sdk.proactive.ProactiveAllPageSnapshot;
import com.obric.memorydata.sdk.proactive.ProactiveDayHeaderDto;
import com.obric.memorydata.sdk.proactive.ProactiveDayPageResult;
import com.obric.memorydata.sdk.proactive.ProactiveLabelingFeedbackConfigDto;
import com.obric.memorydata.sdk.proactive.ProactiveRecommendationDto;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f542436a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Context f542437b;

    static {
        f542436a = new b();
    }

    public b() {
    }

    public static ProactiveLabelingFeedbackConfigDto b(b r100) {
        r100.getClass();
        String r101 = a("getAiProactiveLabelingFeedbackConfig", "requestJson", SliceInitService.DEFAULT_SWITCH);
        if (r101 == null) goto L9;
        JSONObject r102 = new JSONObject(r101);
        List r103 = h(r102.optJSONArray("positiveReasons"));
        List r104 = h(r102.optJSONArray("negativeReasons"));
        String r105 = r102.optString("feedbackPlaceholder");
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        return new ProactiveLabelingFeedbackConfigDto(r103, r104, r105);
    L9:
        return new ProactiveLabelingFeedbackConfigDto(CollectionsKt.listOf(new String[]{"提醒很及时", "内容有帮助", "理解我的需求"}), CollectionsKt.listOf(new String[]{"提醒不合时宜", "内容不准确", "打扰到我了"}), "建议写清：触发信号、建议内容、实际用户场景、期望的提醒时机或执行方式。");
    }

    public static ProactiveAllPageSnapshot e(String r110) {
        JSONObject r100 = new JSONObject(r110);
        long r101 = r100.optLong("batchId");
        JSONArray r102 = r100.optJSONArray("dayHeaders");
        if (r102 != null) goto L6;
        List r103 = CollectionsKt.emptyList();
    L5:
        List r104 = r103;
        return new ProactiveAllPageSnapshot(r101, r104, g(r100.optJSONArray("todayFirstPage")), r100.optBoolean("todayHasNext", false));
    L6:
        List r105 = CollectionsKt.createListBuilder();
        int r106 = r102.length();
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L16;
        JSONObject r108 = r102.optJSONObject(r107);
        if (r108 == null) goto L15;
        String r111 = r108.optString("dayKey");
        if (r111 != null) goto L14;
        r111 = "";
    L14:
        r105.add(new ProactiveDayHeaderDto(r111, r108.optLong("dayStartMillis"), r108.optInt("count")));
    L15:
        r107 = r107 + 1;
        goto L7
    L16:
        r103 = CollectionsKt.build(r105);
        goto L5
    }

    public static ProactiveDayPageResult f(String r100) {
        JSONObject r101 = new JSONObject(r100);
        long r102 = r101.optLong("batchId");
        String r103 = r101.optString("dayKey");
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        return new ProactiveDayPageResult(r102, r103, r101.optBoolean("hasNext", false), g(r101.optJSONArray("list")));
    }

    public static List g(JSONArray r310) {
        JSONArray r100 = r310;
        if (r100 == null) goto L5;
        List r101 = CollectionsKt.createListBuilder();
        int r102 = r310.length();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L56;
        JSONObject r104 = r100.optJSONObject(r103);
        if (r104 == null) goto L54;
        f542436a.getClass();
        String r105 = r104.optString("recommendId");
        if (r105 != null) goto L13;
        String r106 = "";
    L14:
        String r107 = r104.optString(DBDefinition.TASK_ID);
        if (r107 != null) goto L17;
        String r108 = "";
    L18:
        String r109 = r104.optString("subscriptionId");
        if (r109 != null) goto L21;
        String r110 = "";
    L22:
        String r111 = r104.optString("recommendText");
        if (r111 != null) goto L25;
        String r112 = "";
    L26:
        String r113 = r104.optString("emoji");
        if (r113 != null) goto L29;
        String r114 = "";
    L30:
        String r115 = d(r104, "actionCondition");
        String r116 = d(r104, "actionExecuteInstruction");
        String r117 = d(r104, "actionContext");
        List r118 = h(r104.optJSONArray("sourcePackages"));
        long r119 = r104.optLong(IVKService.ResponseConstants.CREATED);
        double r120 = r104.optDouble(com.bytedance.android.ec.core.event.a.KEY_SCORE);
        String r121 = r104.optString("reason");
        if (r121 != null) goto L33;
        String r210 = "";
    L34:
        String r211 = d(r104, "evidence");
        int r122 = r104.optInt("recommendStatus", 1);
        String r123 = r104.optString("status");
        if (r123 != null) goto L37;
        String r212 = "";
    L38:
        String r124 = r104.optString("type");
        if (r124 != null) goto L41;
        String r213 = "";
    L43:
        if (r104.has("expireAtMs") == true) goto L45;
    L48:
        Long r125 = null;
    L49:
        Long r214 = r125;
        String r126 = r104.optString("inspirationId");
        if (r126 != null) goto L52;
        String r215 = "";
    L53:
        String r127 = r106;
        String r128 = r108;
        String r129 = r110;
        String r130 = r112;
        String r131 = r114;
        String r216 = r210;
        r101.add(new ProactiveRecommendationDto(r127, r128, r129, r130, r131, r115, r116, r117, r118, r119, r120, r216, r211, r122, r212, r213, r214, r215, d(r104, "inspirationFeedbackAction"), d(r104, "inspirationUserFeedback"), r104.optLong("inspirationUpdated"), r104.optLong("inspirationTimestamp")));
        goto L54
    L52:
        r215 = r126;
        goto L53
    L45:
        if (r104.isNull("expireAtMs") == true) goto L48;
        r125 = Long.valueOf(r104.optLong("expireAtMs"));
        goto L49
    L41:
        r213 = r124;
        goto L43
    L37:
        r212 = r123;
        goto L38
    L33:
        r210 = r121;
        goto L34
    L29:
        r114 = r113;
        goto L30
    L25:
        r112 = r111;
        goto L26
    L21:
        r110 = r109;
        goto L22
    L17:
        r108 = r107;
        goto L18
    L13:
        r106 = r105;
    L54:
        r103 = r103 + 1;
        r100 = r310;
        goto L7
    L56:
        return CollectionsKt.build(r101);
    L5:
        return CollectionsKt.emptyList();
    }

    public static List h(JSONArray r100) {
        if (r100 == null) goto L4;
        List r101 = CollectionsKt.createListBuilder();
        int r102 = r100.length();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L15;
        String r104 = r100.optString(r103);
        Intrinsics.checkNotNull(r104);
        if ((!StringsKt.isBlank(r104)) == true) goto L11;
        r104 = null;
    L11:
        if (r104 == null) goto L13;
        r101.add(r104);
    L13:
        r103 = r103 + 1;
        goto L6
    L15:
        return CollectionsKt.build(r101);
    L4:
        return CollectionsKt.emptyList();
    }

    public static String d(JSONObject r100, String r101) {
        if (r100.has(r101) == true) goto L5;
    L10:
        return null;
    L5:
        if (r100.isNull(r101) == true) goto L10;
        String r102 = r100.optString(r101);
        Intrinsics.checkNotNull(r102);
        if ((!StringsKt.isBlank(r102)) == false) goto L10;
        return r102;
    }

    public final boolean bindService(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "targetPackage");
        Context r102 = r100.getApplicationContext();
        f542437b = r102;
        a r103 = a.f542434a;
        Intrinsics.checkNotNull(r102);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        a.f542435b = r102.getApplicationContext();
        int r104 = s3.f387719a;
        s3.b("proactive.compat", "provider bridge initialized targetPackage=" + r101);
        return true;
    }

    public static String a(String r100, String r101, String r102) {
        Context r103 = f542437b;
        Object r104 = null;
        if (r103 != null) goto L22;
        return null;
    L22:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L11
        ContentResolver r106 = r103.getContentResolver();     // Catch: Throwable -> L11
        Uri r107 = UriProtector.parse("content://com.obric.memorydata.memory.provider");     // Catch: Throwable -> L11
        Bundle r108 = new Bundle();     // Catch: Throwable -> L11
        r108.putString(r101, r102);     // Catch: Throwable -> L11
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L11
        Bundle r110 = r106.call(r107, r100, null, r108);     // Catch: Throwable -> L11
        if (r110 == null) goto L8;
        String r111 = r110.getString("resultJson");     // Catch: Throwable -> L11
    L9:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L11
    L13:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L17;
        int r114 = s3.f387719a;
        s3.c("proactive.compat", "provider call failed method=" + r100 + " type=" + r113.getClass().getSimpleName() + " message=" + r113.getMessage());
    L17:
        if (Result.m9455isFailureimpl(r112) == true) goto L21;
        r104 = r112;
    L21:
        return (String) r104;
    L8:
        r111 = null;
    L11:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static ProactiveDayPageResult c(b r100, long r101, String r102, int r110) {
        r100.getClass();
        String r103 = a("loadAiProactiveDayRecommendationsPage", "requestJson", new JSONObject().put("batchId", r101).put("dayKey", r102).put("offset", r110).put(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, 50).toString());
        if (r103 == null) goto L6;
        return f(r103);
    L6:
        return new ProactiveDayPageResult(r101, r102, false, CollectionsKt.emptyList());
    }
}
