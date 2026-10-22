package q85;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements c {
    public final Context a;
    public final ConcurrentHashMap<Integer, d> b;
    public boolean c;

    public static final class a {
    }

    static {
    }

    @Override // q85.c
    public final void a() {
    L10:
        th = move-exception;
        tt5.a.d("DriveTemplatePreloadManager", "preload template error " + th.getMessage());
        Iterator<Map.Entry<Integer, d>> r0 = this.b.entrySet().iterator();
    L13:
        if (r0.hasNext() == false) goto L21;
        r0.next().getValue().reset();
        goto L13
    L21:
        return;
    L3:
        if (this.c == true) goto L15;
        Iterator<Map.Entry<Integer, d>> r1 = this.b.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().getValue().a(this.a);     // Catch: Throwable -> L10
        goto L6
    L8:
        this.c = true;     // Catch: Throwable -> L10
        return;
    }

    @Override // q85.c
    public final q85.a b() {
        d r0 = this.b.get(1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public final Context getContext() {
        return this.a;
    }

    public b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r3;
        ConcurrentHashMap<Integer, d> r4 = new ConcurrentHashMap();
        this.b = r4;
        int r0 = q75.b.a;
        if (q75.b.a.a() == false) goto L6;
        r4.put(1, new r85.a());
        return;
    }
}
