package n5a;

import android.content.Context;
import com.lynx.clay.embedding.engine.plugins.platformview.InternalPlatformViewRegistry;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformMethodCallbackResult;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformViewPlugin;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f518055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f518056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> f518057c;

    public b(Context r100) {
        this.f518057c = new HashMap();
        this.f518055a = r100;
    }

    public final void a(int r100, String r101, j r102) {
        InternalPlatformViewRegistry r103 = InternalPlatformViewRegistry.f380842e;
        Context r104 = this.f518055a;
        monitor-enter(r103);
        r103.a();     // Catch: Throwable -> L17
        c r105 = (c) ((LinkedHashMap) r103.f380843a).get(r101);     // Catch: Throwable -> L17
        if (r105 != null) goto L7;
        r105 = (c) ((LinkedHashMap) r103.f380844b).get(r101);     // Catch: Throwable -> L17
    L7:
        if (r105 != null) goto L10;
        monitor-exit(r103);
        com.lynx.clay.embedding.engine.plugins.platformview.a r106 = null;
    L13:
        if ((r106 instanceof o5a.f) == false) goto L15;
        Context r107 = this.f518056b;
        ((o5a.f) r106).f522135h = r107;
    L15:
        r106.o(r102);
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r108 = this.f518057c;
        HashMap r109 = (HashMap) r108;
        r109.put(Integer.valueOf(r100), r106);
        return;
    L10:
        r106 = r105.a(r104, r100, r101);     // Catch: Throwable -> L17
        monitor-exit(r103);
    L17:
        th = move-exception;
        throw th;
    }

    public final void b(int r100, String r101, JSONObject r102, PlatformViewPlugin.b r103) {
        a r104 = new a(r103);
        com.lynx.clay.embedding.engine.plugins.platformview.a r105 = (com.lynx.clay.embedding.engine.plugins.platformview.a) ((HashMap) this.f518057c).get(Integer.valueOf(r100));
        if (r105 != null) goto L5;
        HashMap r106 = new HashMap();
        r106.put("message", r100 + " node not found");
        r104.b(PlatformMethodCallbackResult.NODE_NOT_FOUND, r106);
        return;
    L5:
        if (r105.d(r101, r102, r104) == true) goto L9;
        HashMap r107 = new HashMap();
        r107.put("message", r101 + " method not found");
        r104.b(PlatformMethodCallbackResult.METHOD_NOT_FOUND, r107);
        return;
    }
}
