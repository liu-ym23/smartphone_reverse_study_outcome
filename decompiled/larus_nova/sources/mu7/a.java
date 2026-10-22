package mu7;

import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ju7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f515776a = null;

    static {
        f515776a = new a();
    }

    public a() {
    }

    @Override // ju7.a
    public final void onReport(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        JSONObject r102 = new JSONObject(r101);
        Lazy r103 = ku7.c.f506221a;
        ku7.c.a("onReport " + r100 + " ==== start");
        ku7.c.a(r102.toString(4));
        ku7.c.a("onReport " + r100 + " ==== end");
    }
}
