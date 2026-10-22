package tx9;

import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class t2 {
    public static void a(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("click_module", r102);     // Catch: JSONException -> L9
        if (r100 == null) goto L6;
        r103.put(MusicAppletPage.KEY_MESSAGE_ID, r100);     // Catch: JSONException -> L9
    L6:
        if (r101 == null) goto L11;
        r103.put(IGoogleService.ResponseKey.PHONE_NUMBER, r101);     // Catch: JSONException -> L9
    L11:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("phone_number_panel");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e("PhoneNumberEventHelper", "error in PhoneNumberEventHelper phone_number_panel " + e.getLocalizedMessage());
        goto L11
    }
}
