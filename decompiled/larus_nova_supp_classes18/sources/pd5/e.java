package pd5;

import android.content.Context;
import com.bytedance.ee.bear.list.recent.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static volatile e b;
    public v a;

    public final void a() {
        v r0 = this.a;
        if (r0 == null) goto L6;
        r0.destroy();
        this.a = null;
        return;
    }

    public e(Context r2) {
        v r0 = new v(r2);
        this.a = r0;
        r0.create();
    }

    public static e b(Context r2) {
        if (b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new e(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }
}
