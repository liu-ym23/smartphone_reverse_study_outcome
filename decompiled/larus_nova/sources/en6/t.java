package en6;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class t implements tp6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f473189a = null;

    static {
        f473189a = new t();
    }

    public t() {
    }

    public final JSONObject a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return HostServiceUtilsKt.f0().a(r100);
    }

    public final void b(String r100, HashMap<String, String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "caller");
        HostServiceUtilsKt.f0().d(r100, r101, r102);
    }

    public final boolean c(String r100, HashMap<String, String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "caller");
        return HostServiceUtilsKt.f0().f(r100, r101, r102);
    }
}
