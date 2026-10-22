package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class d1 {
    public static void a() {
        JSONObject r100 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.put("content_type", "soda");     // Catch: JSONException -> L5
    L7:
        TrackParams r101 = new TrackParams().merge(r100);
        by7.a r102 = new by7.a("vip_gift_banner_click");
        r102.f21463a.merge(r101);
        r102.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("FirstPartyEventHelper", "error in FirstPartyEventHelper mobVipGiftBannerClick " + e.getLocalizedMessage());
        goto L7
    }
}
