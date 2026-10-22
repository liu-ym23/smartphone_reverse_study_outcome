package uu6;

import com.bytedance.ies.xbridge.event.depend.IHostEventDepend;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements IHostEventDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHostEventDepend f551766a;

    public a(IHostEventDepend r100) {
        this.f551766a = r100;
    }

    @Override // com.bytedance.ies.xbridge.event.depend.IHostEventDepend
    public final void broadcastEvent(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "eventParams");
        IHostEventDepend r102 = this.f551766a;
        if (r102 == null) goto L5;
        r102.broadcastEvent(r100, r101);
    L5:
        JSONObject r103 = new JSONObject();
        r103.put("eventName", r100);     // Catch: Exception -> L9
        r103.put("data", new JSONObject(r101));     // Catch: Exception -> L9
    L7:
        vn6.b.a(new ln6.a("notification", r103));
    }
}
