package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class h {
    public static final void a(String r100, JSONObject r101, by7.e r102, Function1<? super JSONObject, Unit> r103) {
        r103.invoke(r101);     // Catch: JSONException -> L4
    L6:
        TrackParams r104 = new TrackParams().merge(r101);
        by7.a r105 = new by7.a(r100);
        if (r102 == null) goto L9;
        r105.f21464b = r102;
    L9:
        r105.f21463a.merge(r104);
        r105.b();
        com.larus.platform.service.g.f365738a.monitorEventForSlardar(r100, r101, null, null);
        return;
    L4:
        e = move-exception;
        FLogger.f375446a.e("AigcMetadataWriteEventHelper", "error in AigcMetadataWriteEventHelper " + r100 + ' ' + e.getLocalizedMessage());
        goto L6
    }

    public static void b(final boolean r110, final String r111, final long r112, final boolean r113, final String r114, final int r115) {
        JSONObject r100 = new JSONObject();
        Intrinsics.checkNotNullParameter(r114, "produceIdType");
        Intrinsics.checkNotNullParameter(r100, "params");
        a("aigc_metadata_write_result", r100, null, new g(r110, r111, r112, r113, r114, r115));
    }
}
