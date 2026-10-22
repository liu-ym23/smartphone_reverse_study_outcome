package ez8;

import android.os.SystemClock;
import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.larus.chat.job.impl.page.g0;
import com.larus.chat.job.impl.page.i;
import com.larus.im.bean.job.AIJob;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.texturerender.TextureRenderKeys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f474904a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f474905b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Long> f474906c = null;

    public a() {
    }

    static {
        f474904a = new a();
        f474905b = new LinkedHashSet();
        f474906c = new LinkedHashMap();
    }

    public static String c(AIJob r100) {
        JSONObject r101 = g(r100.getContent());
        if (r101 == null) goto L13;
        JSONObject r102 = r101.optJSONObject("recommend_job");
        if (r102 == null) goto L13;
        String r103 = r102.optString(Ext.KEY_JOB_ID);
        if (StringsKt.isBlank(r103) == false) goto L10;
        r103 = r100.getJobId();
    L10:
        Intrinsics.checkNotNull(r103);
        if ((!StringsKt.isBlank(r103)) == false) goto L13;
        return r103;
    L13:
        return null;
    }

    public static String e(AIJob r100) {
        JSONObject r101 = g(r100.getContent());
        if (r101 == null) goto L5;
        JSONObject r102 = r101.optJSONObject("cron_job");
    L6:
        String r103 = r100.getContent();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        Object r105 = Result.m9449constructorimpl(new JSONTokener(r103).nextValue());     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == false) goto L15;
        r105 = null;
    L15:
        if ((r105 instanceof JSONArray) == false) goto L17;
        JSONArray r106 = (JSONArray) r105;
    L19:
        if (r106 == null) goto L38;
        int r107 = r106.length();
        int r108 = 0;
    L22:
        if (r108 >= r107) goto L38;
        JSONObject r109 = r106.optJSONObject(r108);
        if (r109 == null) goto L37;
        JSONObject r110 = r109.optJSONObject("content");
        if (r110 == null) goto L37;
        JSONObject r111 = r110.optJSONObject("lynx_block");
        if (r111 == null) goto L37;
        String r112 = r111.optString("lynx_data");
        if (r112 == null) goto L37;
        if ((!StringsKt.isBlank(r112)) == true) goto L35;
        r112 = null;
    L35:
        if (r112 == null) goto L37;
    L39:
        if (r112 == null) goto L41;
        JSONObject r113 = g(r112);
    L43:
        if (r113 == null) goto L46;
        JSONObject r114 = r113.optJSONObject("schedule_config");
        if (r114 == null) goto L46;
    L74:
        JSONObject r115 = r114;
    L75:
        if (r115 != null) goto L77;
    L81:
        Integer r116 = null;
    L82:
        if (r116 != null) goto L85;
    L87:
        if (r116 != null) goto L90;
    L92:
        if (r116 != null) goto L95;
    L97:
        if (r116 != null) goto L100;
    L102:
        if (r116 != null) goto L105;
        return null;
    L105:
        if (r116.intValue() != 5) goto L121;
        return "custom";
    L121:
        return null;
    L100:
        if (r116.intValue() != 4) goto L102;
        return "weekly";
    L95:
        if (r116.intValue() != 3) goto L97;
        return "daily";
    L90:
        if (r116.intValue() != 2) goto L92;
        return "hourly";
    L85:
        if (r116.intValue() != 1) goto L87;
        return "never";
    L77:
        if (r115.has(TextureRenderKeys.KEY_IS_TEXTURE_REPEAT_TYPE) == false) goto L81;
        if (r115.isNull(TextureRenderKeys.KEY_IS_TEXTURE_REPEAT_TYPE) == true) goto L81;
        r116 = Integer.valueOf(r115.optInt(TextureRenderKeys.KEY_IS_TEXTURE_REPEAT_TYPE));
    L46:
        if (r102 == null) goto L48;
        r114 = r102.optJSONObject("schedule_config");
    L49:
        if (r114 != null) goto L74;
        if (r102 == null) goto L53;
        JSONObject r117 = r102.optJSONObject(MonitorConstants.SCHEDULE);
    L54:
        if (r117 != null) goto L73;
        if (r101 == null) goto L57;
        r117 = r101.optJSONObject("schedule_config");
    L58:
        if (r117 != null) goto L73;
        if (r101 == null) goto L61;
        JSONObject r118 = r101.optJSONObject(MonitorConstants.SCHEDULE);
    L62:
        if (r118 != null) goto L72;
        JSONObject r119 = g(r100.getExt());
        if (r119 == null) goto L66;
        r118 = r119.optJSONObject("schedule_config");
    L67:
        if (r118 != null) goto L72;
        JSONObject r120 = g(r100.getExt());
        if (r120 == null) goto L71;
        r115 = r120.optJSONObject(MonitorConstants.SCHEDULE);
        goto L75
    L71:
        r115 = null;
        goto L75
    L66:
        r118 = null;
    L72:
        r115 = r118;
        goto L75
    L61:
        r118 = null;
        goto L62
    L57:
        r117 = null;
    L73:
        r115 = r117;
        goto L75
    L53:
        r117 = null;
        goto L54
    L48:
        r114 = null;
        goto L49
    L41:
        r113 = null;
    L37:
        r108 = r108 + 1;
    L38:
        r112 = null;
        goto L39
    L17:
        r106 = null;
    L9:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public static JSONObject g(String r100) {
        Object r101 = null;
        if (StringsKt.isBlank(r100) == true) goto L21;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Object r103 = new JSONTokener(r100).nextValue();     // Catch: Throwable -> L11
        if ((r103 instanceof JSONObject) == false) goto L8;
        JSONObject r104 = (JSONObject) r103;     // Catch: Throwable -> L11
    L9:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r105) == true) goto L18;
        r101 = r105;
    L18:
        return (JSONObject) r101;
    L8:
        r104 = null;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L21:
        return null;
    }

    public static String l(AIJob r100) {
        JSONObject r101 = g(r100.getContent());
        String r102 = null;
        if (r101 == null) goto L11;
        int r103 = g0.f325370a;
        JSONObject r104 = r101.optJSONObject(g0.a(r100.getJobType()));
        if (r104 == null) goto L11;
        if (r104.has("last_run_status") == false) goto L11;
        if (r104.isNull("last_run_status") == true) goto L11;
        Integer r105 = Integer.valueOf(r104.optInt("last_run_status"));
    L13:
        if (r105 != null) goto L16;
    L18:
        int r106 = r100.getStatus();
        if (r106 != (-1)) goto L21;
    L28:
        r102 = "ongoing";
    L30:
        return r102;
    L21:
        if (r106 == 1) goto L28;
        if (r106 != 2) goto L24;
        r102 = "paused";
        goto L30
    L24:
        if (r106 != 3) goto L30;
        r102 = CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED;
        goto L30
    L16:
        if (r105.intValue() != 2) goto L18;
        return "failed";
    L11:
        r105 = null;
        goto L13
    }

    public static Pair b(List r100, String r101) {
        Iterator r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L14;
        i r104 = (i) r102.next();
        if ((r104 instanceof i.a) == false) goto L4;
        i.a r105 = (i.a) r104;
        if (r105.f325376b == false) goto L13;
        a r106 = f474904a;
        AIJob r107 = r105.f325375a;
        r106.getClass();
        if (Intrinsics.areEqual(c(r107), r101) == false) goto L13;
        return TuplesKt.to(r105.f325375a, Integer.valueOf(r103));
    L13:
        r103 = r103 + 1;
        goto L4
    L14:
        return null;
    }

    public static void f(String r100, JSONObject r101) {
        FLogger r102 = FLogger.f375446a;
        if (r102.isDebug() == false) goto L5;
        r102.i("ChatJobTracker", "track event=" + r100 + " params=" + r101);
    L6:
        o.f365780a.reportEvent(r100, r101);
        return;
    L5:
        r102.i("ChatJobTracker", "track event=" + r100 + " keys=" + SequencesKt.toList(SequencesKt.asSequence(r101.keys())));
        goto L6
    }

    public static void i(AIJob r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "job");
        if (StringsKt.isBlank(r100.getJobId()) == false) goto L5;
        return;
    L5:
        String r101 = r100.getJobId();
        long r102 = SystemClock.elapsedRealtime();
        Map<String, Long> r103 = f474906c;
        Long r104 = (Long) ((LinkedHashMap) r103).get(r101);
        if (r104 != null) goto L8;
    L10:
        r103.put(r101, Long.valueOf(r102));
        boolean r105 = true;
    L11:
        if (r105 == true) goto L13;
        return;
    L13:
        JSONObject r111 = new JSONObject().put(Ext.KEY_JOB_ID, r100.getJobId()).put("index", r110);
        f474904a.getClass();
        String r106 = l(r100);
        if (r106 == null) goto L16;
        r111.put("job_status", r106);
    L16:
        f("cron_job_click", r111);
        return;
    L8:
        if ((r102 - r104.longValue()) > 500) goto L10;
        r105 = false;
        goto L11
    }

    public static void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "jobId");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject().put(Ext.KEY_JOB_ID, r100);
        if (r101 == false) goto L8;
        String r103 = "confirm";
    L9:
        f("cron_job_remove_confirm_click", r102.put("click_from", r103));
        return;
    L8:
        r103 = "cancel";
        goto L9
    }

    public static void a(String r100, String r101, boolean r102) {
        f474905b.clear();
        ((LinkedHashMap) f474906c).clear();
        if (r102 == true) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject().put("current_page", "cron_job_manage");
        if (r100 != null) goto L8;
    L13:
        if (r101 != null) goto L15;
    L20:
        Unit r104 = Unit.INSTANCE;
        f(CheckPointType.ENTER_PAGE, r103);
        return;
    L15:
        if ((!StringsKt.isBlank(r101)) == true) goto L18;
        r101 = null;
    L18:
        if (r101 == null) goto L20;
        r103.put("enter_method", r101);
        goto L20
    L8:
        if ((!StringsKt.isBlank(r100)) == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L13;
        r103.put("previous_page", r100);
        goto L13
    }

    public static JSONObject d(AIJob r100, String r101, int r102) {
        JSONObject r103 = new JSONObject().put("template_source", "onboarding").put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r101).put("index", r102);
        f474904a.getClass();
        JSONObject r104 = g(r100.getContent());
        if (r104 == null) goto L16;
        JSONObject r105 = r104.optJSONObject("recommend_job");
        if (r105 == null) goto L16;
        String r106 = r105.optString("title");
        if (r106 == null) goto L16;
        String r107 = StringsKt.trim(r106).toString();
        if (r107 == null) goto L16;
        if (r107.length() <= 0) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == false) goto L16;
    L17:
        if (r107 == null) goto L19;
        r103.put("job_title", r107);
    L19:
        return r103;
    L13:
        r108 = false;
    L16:
        r107 = null;
        goto L17
    }

    public static void j(String r100, String r101, String r102) {
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r102) == true) goto L13;
        JSONObject r103 = new JSONObject().put(Ext.KEY_JOB_ID, r100).put("click_from", r102);
        if (r101 == null) goto L10;
        r103.put("job_status", r101);
    L10:
        f("cron_job_operate", r103);
        return;
    }

    public static void h(String r100, List r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "jobId");
        Intrinsics.checkNotNullParameter(r110, "editFields");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        if (r110.isEmpty() == true) goto L10;
        f("edit_cron_job_status", new JSONObject().put(Ext.KEY_JOB_ID, r100).put("edit_field", CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, null, 62, null)).put(TextureRenderKeys.KEY_IS_TEXTURE_REPEAT_TYPE, r111).put("is_success", r112));
        return;
    }
}
