package d85;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.cache.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements d {
    public final com.bytedance.ee.bear.drive.config.strategy.d a;
    public final t b;
    public final a95.a c;

    @Override // d85.d
    public final boolean a(w75.c r6, w75.c r7) {
        if (TextUtils.equals(r6.h(), r7.h()) == false) goto L13;
        return false;
    L13:
        String r0 = this.a.i(r6.getDetails());     // Catch: Exception -> L7
        t r1 = this.b;     // Catch: Exception -> L7
        String r2 = r6.getFileToken();     // Catch: Exception -> L7
        String r3 = r6.h();     // Catch: Exception -> L7
        a95.a r4 = this.c;     // Catch: Exception -> L7
        r1.getClass();     // Catch: Exception -> L7
        tt5.a.h("DRIVE_PREVIEW_FLOW", du5.b.g(r6.getFileToken()) + " clear cache result " + ((Boolean) t.p(r0, r2, r3, r4).blockingSingle()).booleanValue());     // Catch: Exception -> L7
        return true;
    L7:
        e = move-exception;
        tt5.a.j("DRIVE_PREVIEW_FLOW", e);
        return true;
    }

    public a(com.bytedance.ee.bear.drive.config.strategy.d r1, t r2, a95.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
