package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class s3 {
    public static void a(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("scene", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("spring_client_downgrade_toast");
        r103.f21463a.merge(r102);
        r103.b();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("spring_client_downgrade_toast", r101, null, null);     // Catch: Throwable -> L10
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L21;
        FLogger.f375446a.e("SpringClientEvent", "slardar report error, mobSpringClientDowngradeToast " + r106.getLocalizedMessage());
        return;
    L21:
        return;
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        e = move-exception;
        FLogger.f375446a.e("SpringClientEvent", "error in SpringClientEvent mobSpringClientDowngradeToast " + e.getLocalizedMessage());
        goto L7
    }
}
