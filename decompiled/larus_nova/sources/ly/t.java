package ly;

import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.anchormodelink.handlers.d f511284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.anchormodelink.handlers.a f511285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f511286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ih0.c f511287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f511288e;

    public final void a() {
        ih0.c r100 = this.f511287d;
        if (r100 == null) goto L5;
        r100.J();
    L5:
        ih0.c r101 = this.f511287d;
        if (r101 == null) goto L8;
        r101.release();
    L8:
        com.bytedance.android.live.anchormodelink.handlers.d r102 = this.f511284a;
        if (r102 == null) goto L12;
        r102.f58669j = null;
        ((LinkedHashMap) r102.f58660a).clear();
        r102.f58665f = null;
        r102.f58662c = null;
        r102.f58667h = false;
        r102.f58664e.clear();
        r102.f58663d = 0;
        r102.f58661b.clear();
        r102.f58661b.dispose();
        return;
    }

    public t(com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r100, int r101) {
        this.f511287d = r100;
        this.f511288e = r101;
        boolean r102 = ky.a.f506618a;
        List<String> r103 = vm2.d.c0().getSeiCacheKeys();
        if (r103 != null) goto L5;
        r103 = CollectionsKt.listOf(new String[]{"app_data", "source"});
    L5:
        this.f511284a = new com.bytedance.android.live.anchormodelink.handlers.d(r103);
        this.f511285b = new com.bytedance.android.live.anchormodelink.handlers.a();
    }
}
