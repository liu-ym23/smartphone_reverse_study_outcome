package y8;

import a9.j;
import com.bytedance.android.annie.service.appruntime.DegradeStatus;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f566654a = 0;

    static {
    }

    public d() {
    }

    public static void b(DegradeStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "degradeStatus");
        j.f2216a.sendEventToAllJsBridges("onDegradeRecovered", c(r100, 0));
    }

    public static JSONObject c(DegradeStatus r100, int r101) {
        JSONObject r102 = new JSONObject();
        r102.put("status", r100.getStatus());
        if (r100 != DegradeStatus.liveDegrade) goto L6;
        if (r101 <= 0) goto L6;
        r102.put("level", r101);
    L6:
        return r102;
    }

    public static void a(DegradeStatus r100, int r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = 1;
    L5:
        Intrinsics.checkNotNullParameter(r100, "degradeStatus");
        j.f2216a.sendEventToAllJsBridges("onDegradeHappened", c(r100, r101));
    }
}
