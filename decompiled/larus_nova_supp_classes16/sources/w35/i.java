package w35;

import com.bytedance.ee.bear.document.ssrrender.RenderHtmlCachePlugin;
import com.bytedance.ee.bear.document.statistics.SendEventData;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements a.c {
    public final /* synthetic */ a.c a;

    @Override // w35.a.c
    public final void a() {
        j r0 = h.c;
        if (r0 == null) goto L5;
        r0.d.run();
    L5:
        this.a.a();
    }

    public i(RenderHtmlCachePlugin.f r1) {
        this.a = r1;
    }

    @Override // w35.a.c
    public final void b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonObject");
        this.a.b(r2);
    }

    @Override // w35.a.c
    public final void c(SendEventData r2) {
        this.a.c(r2);
    }
}
