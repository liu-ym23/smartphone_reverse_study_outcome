package pd5;

import android.content.Context;
import com.bytedance.ee.bear.list.recent.v;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f528680b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f528681a;

    public final void a() {
        v r100 = this.f528681a;
        if (r100 == null) goto L6;
        r100.destroy();
        this.f528681a = null;
        return;
    }

    public e(Context r100) {
        v r101 = new v(r100);
        this.f528681a = r101;
        r101.create();
    }

    public static e b(Context r100) {
        if (f528680b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f528680b != null) goto L9;
        f528680b = new e(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f528680b;
    }
}
