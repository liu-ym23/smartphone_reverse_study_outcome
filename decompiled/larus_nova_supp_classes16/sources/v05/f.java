package v05;

import android.content.Context;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public static final Map<String, a> a = null;

    public f() {
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static void c(String r3, Class<? extends BaseFragment> r4) {
        Map<String, a> r0 = a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.put(r3, new a(r4, 2131560124));
    }

    public static void d(String r1, a r2) {
        ((ConcurrentHashMap) a).put(r1, r2);
    }

    public static View a(Context r2, ViewGroup r3, a r4) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return b(r2, r3, r4);
    L6:
        monitor-enter(f.class);
        View r5 = b(r2, r3, r4);     // Catch: Throwable -> L10
        monitor-exit(f.class);     // Catch: Throwable -> L10
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    public static View b(Context r2, ViewGroup r3, a r4) {
        View r5 = LayoutInflater.from(new ContextThemeWrapper(r2, 2131952057)).inflate(r4.b, r3, false);
        r5.findViewById(2131369338).setCustomTitleView(g.a(r2).getView());
        return r5;
    }
}
