package zo0;

import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h {
    public static final f b(PerformanceScene r100) {
        Intrinsics.checkNotNullParameter(g.f573096c, "$this$of");
        Intrinsics.checkNotNullParameter(r100, "scene");
        String r101 = r100.getValue();
        monitor-enter(g.class);
        Intrinsics.checkNotNullParameter(r101, "scene");     // Catch: Throwable -> L17
        HashMap<String, f> r102 = g.f573094a;     // Catch: Throwable -> L17
        f r103 = r102.get(r101);     // Catch: Throwable -> L17
        if (r103 == null) goto L8;
        monitor-exit(g.class);
    L14:
        return r103;
    L8:
        g.b r104 = g.f573095b.get(r101);     // Catch: Throwable -> L17
        if (r104 != null) goto L11;
        r104 = g.a.f573097a;     // Catch: Throwable -> L17
    L11:
        r103 = r104.a(r101);     // Catch: Throwable -> L17
        r102.put(r101, r103);     // Catch: Throwable -> L17
        if (r103 == null) goto L16;
        monitor-exit(g.class);
        goto L14
    L16:
        throw new NullPointerException("null cannot be cast to non-null type T");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static final void a(f r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$clickSource");
        Intrinsics.checkNotNullParameter(r101, "source");
        monitor-enter(r100);
        Intrinsics.checkNotNullParameter("click_source", "key");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r101, "value");     // Catch: Throwable -> L7
        r100.f573092b.putString("click_source", r101);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
