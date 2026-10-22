package tx9;

import com.ixigua.lib.track.TrackParams;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class q0 {
    public static void a(String r100, String r101, String r102, String r103, Integer r104, Boolean r105, String r106, boolean r107, int r110) {
        JSONObject r108 = null;
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r110 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r110 & 32) == 0) goto L15;
        r105 = null;
    L15:
        if ((r110 & 128) == 0) goto L18;
        r107 = false;
    L18:
        if ((r110 & 256) == 0) goto L20;
        r108 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 == null) goto L23;
        r108.put("answer_mode", r100);
    L23:
        if (r101 == null) goto L25;
        r108.put(PickerReporterConstants.KEY.TYPE, r101);
    L25:
        if (r102 == null) goto L27;
        r108.put("menu_id", r102);
        r108.put("model_item_key", r102);
        r108.put("model_key", r102);
    L27:
        if (r103 == null) goto L29;
        r108.put("mode_id", r103);
    L29:
        if (r104 == null) goto L31;
        r108.put("agent_mode", r104.intValue());
    L31:
        if (r105 == null) goto L33;
        r108.put("is_custom_model", r105.booleanValue());
    L33:
        r108.put("provider_id", r106);
        r108.put("is_folded", r107);
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r111 = new by7.a("click_default_answer_mode_switch");
        r111.f21463a.merge(r109);
        r111.b();
    }
}
