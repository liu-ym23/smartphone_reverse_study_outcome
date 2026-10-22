package po9;

import com.larus.bmhome.utils.ReferenceMessage;
import com.larus.office.OfficeInputParam;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f530141a = 0;

    static {
    }

    public static void a(Map r100, OfficeInputParam r101, String r110, Integer r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "ext");
        Intrinsics.checkNotNullParameter(r101, "params");
        boolean r102 = true;
        if (r101.getSlidesToken().length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        JSONObject r104 = new JSONObject();
        r104.put("presentation_id", r101.getSlidesToken());
        r104.put("artifact_version_id", r110);
        if (r111 == null) goto L11;
        int r105 = r111.intValue();
    L12:
        r104.put("structure_version", r105);
        if (r112 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == false) goto L71;
    L68:
        r100.put("office_ref_block_info", new JSONObject().put("action", 0).put(PerfLog.PARAM_KEY_CONTEXT_ID, r104).toString());
        return;
    L71:
        JSONObject r107 = new JSONObject(r112);     // Catch: JSONException -> L70
        String r114 = r107.optString("text");     // Catch: JSONException -> L70
        Intrinsics.checkNotNull(r114);     // Catch: JSONException -> L70
        if (r114.length() <= 0) goto L23;
        boolean r115 = true;
    L24:
        Integer r108 = null;
        if (r115 == true) goto L28;
        r114 = null;
    L28:
        if (r114 == null) goto L30;
        r100.put(ReferenceMessage.KEY_REFERENCE_TEXT, r114);     // Catch: JSONException -> L70
    L30:
        Long r116 = Long.valueOf(r107.optLong("structureVersion", -1));     // Catch: JSONException -> L70
        if (r116.longValue() <= 0) goto L33;
        boolean r117 = true;
    L34:
        if (r117 == true) goto L37;
        r116 = null;
    L37:
        if (r116 == null) goto L39;
        r104.put("structure_version", r116.longValue());     // Catch: JSONException -> L70
    L39:
        JSONObject r118 = new JSONObject();     // Catch: JSONException -> L70
        r118.put("slide_block_id", r107.optString("slideBlockId"));     // Catch: JSONException -> L70
        r118.put("element_block_id", r107.optString("elementBlockId"));     // Catch: JSONException -> L70
        String r119 = r107.optString("pageId");     // Catch: JSONException -> L70
        Intrinsics.checkNotNull(r119);     // Catch: JSONException -> L70
        if (r119.length() <= 0) goto L42;
        boolean r120 = true;
    L43:
        if (r120 == true) goto L46;
        r119 = null;
    L46:
        if (r119 == null) goto L48;
        r118.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, r119);     // Catch: JSONException -> L70
    L48:
        Integer r121 = Integer.valueOf(r107.optInt("startOffset", -1));     // Catch: JSONException -> L70
        if (r121.intValue() < 0) goto L51;
        boolean r109 = true;
    L52:
        if (r109 == true) goto L55;
        r121 = null;
    L55:
        if (r121 == null) goto L57;
        r118.put(DbJsonConstants.DBJSON_KEY_START_OFFSET, r121.intValue());     // Catch: JSONException -> L70
    L57:
        Integer r122 = Integer.valueOf(r107.optInt("endOffset", -1));     // Catch: JSONException -> L70
        if (r122.intValue() >= 0) goto L61;
        r102 = false;
    L61:
        if (r102 == false) goto L63;
        r108 = r122;
    L63:
        if (r108 == null) goto L65;
        r118.put(DbJsonConstants.DBJSON_KEY_END_OFFSET, r108.intValue());     // Catch: JSONException -> L70
    L65:
        JSONArray r123 = new JSONArray().put(r118);     // Catch: JSONException -> L70
        r104.put("select_positions", r123);     // Catch: JSONException -> L70
        if (r113 == false) goto L68;
        r104.put("ref_positions", r123);     // Catch: JSONException -> L70
        goto L68
    L51:
        r109 = false;
        goto L52
    L42:
        r120 = false;
        goto L43
    L33:
        r117 = false;
        goto L34
    L23:
        r115 = false;
        goto L24
    L15:
        if (r112.length() == 0) goto L18;
        r106 = false;
        goto L19
    L11:
        r105 = r101.getResourceVersion();
        goto L12
    L5:
        r103 = false;
        goto L6
    }
}
