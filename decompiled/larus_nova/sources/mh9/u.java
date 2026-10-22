package mh9;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public final class u {
    public static final void a(String r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        by7.a r102 = new by7.a(r100);
        TrackParams r103 = new TrackParams().merge(new JSONObject(r101.toString()));
        r102.f21463a.merge(r103);
        r102.b();
    }
}
