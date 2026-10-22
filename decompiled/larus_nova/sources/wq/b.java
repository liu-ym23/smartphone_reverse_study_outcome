package wq;

import android.graphics.RenderNode;
import android.os.Build;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f560681a;

    public b() {
    }

    public static xq.a a(String r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 29) goto L17;
        xq.a r102 = new xq.a();
        if (r100 == null) goto L18;
        r102.f560680a = r100;
    L18:
        String r103 = r102.f560680a;     // Catch: Exception -> L13
        if (r103 != null) goto L11;
        r103 = "SliceRenderNode";
    L11:
        r102.f564791b = new RenderNode(r103);     // Catch: Exception -> L13
        return r102;
    L13:
        e = move-exception;
        throw new RuntimeException("Failed to initialize RenderNode via renderNodeCompat", e);
    L17:
        throw new RuntimeException("RenderNode is not supported on API " + r101 + ". Minimum required API is 21");
    }
}
