package i17;

import com.bytedance.lynx.webview.glue.PrerenderManager;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.map.api.monitor.MapMonitorConst;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import l17.i;
import l17.k;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements PrerenderManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Method> f488002b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f488003a;

    static {
        f488002b = i.a(PrerenderManager.class, "com.bytedance.webview.chromium.PrerenderManagerImpl");
    }

    @Override // com.bytedance.lynx.webview.glue.PrerenderManager
    public final void clearQueuedPrefetchToMemory() {
        Method r100 = (Method) ((HashMap) f488002b).get("clearQueuedPrefetchToMemory");
        Object r101 = this.f488003a;
        if (r101 == null) goto L12;
        if (r100 != null) goto L10;
        return;
    L10:
        r100.invoke(r101, new Object[0]);     // Catch: Exception -> L8
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "PrerenderManager.clearQueuedPrefetchToMemory error"});
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.PrerenderManager
    public final void destroy() {
        Method r100 = (Method) ((HashMap) f488002b).get(MapMonitorConst.EVENT_DESTROY);
        Object r101 = this.f488003a;
        if (r101 == null) goto L12;
        if (r100 != null) goto L10;
        return;
    L10:
        r100.invoke(r101, new Object[0]);     // Catch: Exception -> L8
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "PrerenderManager.destroy error"});
        return;
    }

    public a() {
        this.f488003a = null;
        this.f488003a = TTWebContext.h().f265216b.f("com.bytedance.webview.chromium.PrerenderManagerImpl", false).newInstance();     // Catch: Exception -> L5
        return;
    L5:
        k.b(new String[]{"TT_WEBVIEW", "get PrerenderManager failure"});
    }

    @Override // com.bytedance.lynx.webview.glue.PrerenderManager
    public final void removePrefetchToMemory(String r100) {
        Method r101 = (Method) ((HashMap) f488002b).get("removePrefetchToMemory");
        Object r102 = this.f488003a;
        if (r102 == null) goto L12;
        if (r101 != null) goto L10;
        return;
    L10:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "PrerenderManager.removePrefetchToMemory error"});
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.PrerenderManager
    public final void setClient(Object r100) {
        Method r101 = (Method) ((HashMap) f488002b).get("setClient");
        Object r102 = this.f488003a;
        if (r102 == null) goto L12;
        if (r101 != null) goto L10;
        return;
    L10:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "PrerenderManager.setClient error"});
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.PrerenderManager
    public final void setClient(PrerenderManager.Client r100) {
        setClient(r100);
    }

    @Override // com.bytedance.lynx.webview.glue.PrerenderManager
    public final void prefetchToMemory(String r100, int r101) {
        Method r102 = (Method) ((HashMap) f488002b).get("prefetchToMemory");
        Object r103 = this.f488003a;
        if (r103 == null) goto L12;
        if (r102 != null) goto L10;
        return;
    L10:
        r102.invoke(r103, new Object[]{r100, Integer.valueOf(r101)});     // Catch: Exception -> L8
        return;
    L8:
        k.b(new String[]{"TT_WEBVIEW", "PrerenderManager.prefetchToMemory error"});
        return;
    }
}
