package sz8;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f544049a = 0;

    static {
    }

    public a() {
    }

    public static void a(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("type", r100);     // Catch: JSONException -> L5
        r101.put("current_page", "credit_invite_new_user");     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("credit_share_link");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("CommerceCreditEventHelper", "error in CommerceCreditEventHelper mobCreditShareLink " + e.getLocalizedMessage());
        goto L7
    }
}
