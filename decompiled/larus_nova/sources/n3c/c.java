package n3c;

import com.bytedance.apm.ApmAgent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements ne6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f517016a = null;

    static {
        f517016a = new c();
    }

    public c() {
    }

    @Override // ne6.b
    public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        String r104 = u4c.a.f548750a;
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        ApmAgent.monitorStatusAndEvent(r100, 0, r101, r102, r103);
    }
}
