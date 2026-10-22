package qq5;

import android.content.Context;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.reactivex.Flowable;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final Map<Integer, Queue<View>> a = null;
    public static final Queue<a> b = null;
    public static volatile boolean c;

    public static class a {
        public Context a;
        public ViewGroup b;
        public int c;

        public a() {
        }
    }

    public d() {
    }

    static {
        a = new ConcurrentHashMap();
        b = new LinkedBlockingDeque();
        c = false;
    }

    public static void c() {
        if (((LinkedBlockingDeque) b).size() <= 0) goto L5;
        c = true;
        Flowable.timer(3, TimeUnit.SECONDS).observeOn(fo5.d.d()).subscribe(new qq5.a(), new b(), new c());
        return;
    L5:
        c = false;
    }

    public static void b(Context r2, ViewGroup r3) {
        tt5.a.h("ViewFactory", "ViewFactory.prepare, layoutRes: 2131568236");
        if (r2 != null) goto L5;
        return;
    L5:
        a r0 = new a();
        r0.a = r2;
        r0.b = r3;
        r0.c = 2131568236;
        ((LinkedBlockingDeque) b).offer(r0);
        if (c == true) goto L9;
        c();
        return;
    }

    public static View a(Context r4, ViewGroup r5, int r6) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return LayoutInflater.from(new ContextThemeWrapper(r4, 2131952057)).inflate(r6, r5, false);
    L6:
        monitor-enter(d.class);
        View r7 = LayoutInflater.from(new ContextThemeWrapper(r4, 2131952057)).inflate(r6, r5, false);     // Catch: Throwable -> L10
        monitor-exit(d.class);     // Catch: Throwable -> L10
        return r7;
    L10:
        th = move-exception;
        throw th;
    }
}
