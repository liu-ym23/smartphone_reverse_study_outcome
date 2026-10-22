package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.banner.BannerItemViewHolder;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f547883a = 0;

    static {
    }

    public m() {
    }

    public static void a(String r100, Integer r101, String r102, String r103, String r104, BannerItemViewHolder r105) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 == null) goto L5;
        r106.put("banner_id", r100);
    L5:
        if (r101 == null) goto L7;
        r106.put(ObricActionBarTrackType.KEY_SHOW_POSITION, r101.intValue());
    L7:
        r106.put("show_way", r102);
        if (r103 == null) goto L10;
        r106.put("uri", r103);
    L10:
        if (r104 == null) goto L12;
        r106.put("video_id", r104);
    L12:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("banner_show");
        if (r105 == null) goto L15;
        r108.f21464b = r105;
    L15:
        r108.f21463a.merge(r107);
        r108.b();
    }
}
