package u35;

import com.bytedance.ee.bear.document.render.node.perf.SendEventData;
import com.bytedance.ee.bear.document.ssr.plugin.RenderHtmlCachePlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements v35.a.c {
    public final /* synthetic */ a.InterfaceC0304a a;

    @Override // v35.a.c
    public final void a() {
        c r0 = a.c;
        if (r0 == null) goto L5;
        r0.c.run();
    L5:
        this.a.a();
    }

    public b(RenderHtmlCachePlugin.g r1) {
        this.a = r1;
    }

    @Override // v35.a.c
    public final void b(SendEventData r2) {
        this.a.b(r2);
    }
}
