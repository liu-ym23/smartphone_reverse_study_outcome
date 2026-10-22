package h1a;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f483561a = null;

    static {
        f483561a = new Gson();
    }

    public static void a(d r100, com.larus.ugc.perf.impl.e r101, by7.e r102) {
        Intrinsics.checkNotNullParameter(r100, "mobData");
        Gson r103 = f483561a;
        String r104 = GsonProtectorUtils.toJson(r103, r100);
        TrackParams r105 = new TrackParams().merge(new JSONObject(r104));
        if (r101 == null) goto L5;
        r105 = r105.merge(GsonProtectorUtils.toJson(r103, r101));
    L5:
        String r106 = r100.a();
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        by7.a r107 = new by7.a(r106);
        if (r102 == null) goto L11;
        r107.f21464b = r102;
    L11:
        r107.f21463a.merge(r105);
        r107.b();
    }
}
