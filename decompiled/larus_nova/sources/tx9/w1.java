package tx9;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class w1 {
    public static void a(String r100, String r101, String r102, Boolean r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
        if (r100 != null) goto L20;
    L7:
        if (r101 == null) goto L9;
        r104.put("schema", r101);     // Catch: JSONException -> L5
    L9:
        r104.put(SoloKtvContext.SOLO_PAGE_ENTRANCE, r102);     // Catch: JSONException -> L5
        if (r103 != null) goto L12;
    L18:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("lynx_page_schema_handled");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L12:
        if (r103.booleanValue() == false) goto L14;
        int r107 = 1;
    L15:
        r104.put("is_ai_sdk", r107);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("LynxPageSchemaEventHelper", "error in LynxPageSchemaEventHelper mobLynxPageSchemaHandled " + e.getLocalizedMessage());
        goto L18
    L14:
        r107 = 0;
        goto L15
    L20:
        r104.put(PickerReporterConstants.KEY.TARGET, r100);     // Catch: JSONException -> L5
        goto L7
    }
}
