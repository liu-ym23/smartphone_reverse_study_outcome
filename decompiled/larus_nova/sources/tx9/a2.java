package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class a2 {
    public static void a(int r100, String r101, Long r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "mediaType");
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.putOpt("is_success", Integer.valueOf(r100));     // Catch: JSONException -> L5
        r103.putOpt(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, r101);     // Catch: JSONException -> L5
        r103.putOpt("data_type", null);     // Catch: JSONException -> L5
        r103.putOpt("duration", r102);     // Catch: JSONException -> L5
    L7:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("anchor_meta_data_save");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("MetaDataTrack", "error in MetaDataTrack anchor meta data save " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(int r100, long r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "mediaType");
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.putOpt("is_success", Integer.valueOf(r100));     // Catch: JSONException -> L5
        r103.putOpt("duration", Long.valueOf(r101));     // Catch: JSONException -> L5
        r103.putOpt(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, r102);     // Catch: JSONException -> L5
    L7:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("save_media_duration");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("MetaDataTrack", "error in MetaDataTrack save media duration " + e.getLocalizedMessage());
        goto L7
    }
}
