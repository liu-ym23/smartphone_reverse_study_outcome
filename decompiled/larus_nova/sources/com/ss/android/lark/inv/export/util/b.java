package com.ss.android.lark.inv.export.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes36.dex */
public abstract class b implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f428149c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f428150d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f428151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f428152b;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.f428149c = true;     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        }
    }

    static {
        f428150d = new a();
    }

    public b() {
        this.f428152b = false;
        this.f428151a = 1000;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        boolean r100 = false;
        if (this.f428152b == true) goto L5;
        long r101 = this.f428151a;
        Map<String, Long> r102 = h9b.e.f484354a;
        String r103 = String.valueOf(r110.hashCode());
        if (TextUtils.isEmpty(r103) == false) goto L11;
        Log.e("InvDebouncingUtils", "The key is null.");
    L27:
        if (r100 == false) goto L37;
        ((com.ss.android.lark.inv.export.util.a) this).f428148e.onClick(r110);
        return;
    L37:
        return;
    L11:
        if (r101 >= 0) goto L13;
        Log.e("InvDebouncingUtils", "The duration is less than 0.");
        goto L27
    L13:
        long r104 = SystemClock.elapsedRealtime();
        ConcurrentHashMap r105 = (ConcurrentHashMap) h9b.e.f484354a;
        if (r105.size() < 64) goto L22;
        Iterator r106 = r105.entrySet().iterator();
    L18:
        if (r106.hasNext() == false) goto L22;
        if (r104 < ((Long) ((Map.Entry) r106.next()).getValue()).longValue()) goto L18;
        r106.remove();
    L22:
        ConcurrentHashMap r107 = (ConcurrentHashMap) h9b.e.f484354a;
        Long r108 = (Long) r107.get(r103);
        if (r108 != null) goto L25;
    L26:
        r107.put(r103, Long.valueOf(r104 + r101));
        r100 = true;
        goto L27
    L25:
        if (r104 < r108.longValue()) goto L27;
    L5:
        if (f428149c == false) goto L35;
        f428149c = false;
        r110.postDelayed(f428150d, this.f428151a);
        ((com.ss.android.lark.inv.export.util.a) this).f428148e.onClick(r110);
        return;
    }
}
