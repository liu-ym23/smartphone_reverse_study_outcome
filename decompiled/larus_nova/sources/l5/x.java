package l5;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class x implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f507427a;

    public x(JSONObject r100) {
        this.f507427a = r100;
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        JSONObject r101 = this.f507427a.optJSONObject("category");
        if (r101 == null) goto L5;
        r100.f37148i = r101;
    L5:
        JSONObject r102 = this.f507427a.optJSONObject("metric");
        if (r102 == null) goto L9;
        r100.f37149j = r102;
        return;
    }
}
