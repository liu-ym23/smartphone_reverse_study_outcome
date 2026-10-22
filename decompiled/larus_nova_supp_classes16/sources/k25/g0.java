package k25;

import android.content.Context;
import com.bytedance.ee.util.db.DBController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g0 implements DBController.b {
    public final /* synthetic */ e0 a;

    public final void a(String r4) {
        e0 r0 = this.a;
        r0.b = new e1(r4.toCharArray(), false);
    }

    public g0(e0 r1, Context r2) {
        this.a = r1;
    }
}
