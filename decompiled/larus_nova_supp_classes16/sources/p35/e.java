package p35;

import com.bytedance.ee.util.ui.m;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static boolean a;
    public static boolean b;
    public static boolean c;
    public static boolean d;
    public static int e;
    public static int f;
    public static int g;
    public static boolean h;
    public static boolean i;
    public static final List<f> j = null;

    static {
        j = new CopyOnWriteArrayList();
    }

    public static void a(f r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        List<f> r0 = j;
        if (((CopyOnWriteArrayList) r0).contains(r2) == true) goto L8;
        ((CopyOnWriteArrayList) r0).add(r2);
        return;
    }

    public static void d(boolean r0) {
        h = r0;
        i = false;
    }

    public static void e(boolean r2) {
        a = r2;
        tt5.a.h("RenderGoneHelper", "setkillRenderProcess:" + r2);
    }

    public static void b(final boolean r2, final int r3) {
        tt5.a.h("RenderGoneHelper", "notifyRenderGone didCrash: " + r2 + "--rendererPriority: " + r3);
        m.a(new b(r2, r3));
    }

    public static void c(boolean r3, int r4) {
        b = false;
        tt5.a.h("RenderGoneHelper", "reloadWebView====== didCrash = " + r3 + ", rendererPriority = " + r4);
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.a(com.bytedance.ee.bear.contract.m.class)).c(false).subscribe(new c(), new d());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.d("RenderGoneHelper", "reLoadWebView()... e = " + th);
    }
}
