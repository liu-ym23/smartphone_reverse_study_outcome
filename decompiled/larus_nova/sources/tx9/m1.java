package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class m1 {
    public static void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("click_option", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("hyperlink_selection_popup_window_click");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("HyperLinkSelectionEventHelper", "error in HyperLinkSelectionEventHelper mobHyperlinkSelectionPopupWindowClick " + e.getLocalizedMessage());
        goto L7
    }
}
