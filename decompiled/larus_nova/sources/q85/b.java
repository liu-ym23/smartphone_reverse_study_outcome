package q85;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f532025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, d> f532026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f532027c;

    public static final class a {
    }

    static {
    }

    @Override // q85.c
    public final void a() {
    L10:
        th = move-exception;
        tt5.a.d("DriveTemplatePreloadManager", "preload template error " + th.getMessage());
        Iterator<Map.Entry<Integer, d>> r100 = this.f532026b.entrySet().iterator();
    L13:
        if (r100.hasNext() == false) goto L21;
        r100.next().getValue().reset();
        goto L13
    L21:
        return;
    L3:
        if (this.f532027c == true) goto L15;
        Iterator<Map.Entry<Integer, d>> r101 = this.f532026b.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().getValue().a(this.f532025a);     // Catch: Throwable -> L10
        goto L6
    L8:
        this.f532027c = true;     // Catch: Throwable -> L10
        return;
    }

    @Override // q85.c
    public final q85.a b() {
        d r100 = this.f532026b.get(1);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    public final Context getContext() {
        return this.f532025a;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f532025a = r100;
        ConcurrentHashMap<Integer, d> r101 = new ConcurrentHashMap();
        this.f532026b = r101;
        int r102 = q75.b.f531970a;
        if (q75.b.a.a() == false) goto L6;
        r101.put(1, new r85.a());
        return;
    }
}
