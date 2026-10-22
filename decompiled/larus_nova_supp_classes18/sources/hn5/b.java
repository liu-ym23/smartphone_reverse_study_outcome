package hn5;

import com.bytedance.ee.bear.domain.BearUrl;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements a {
    public final qm5.a a;

    @Override // hn5.a
    public final void b() {
        qm5.b.d("finish");
    }

    public b() {
        this.a = new qm5.a();
    }

    @Override // hn5.a
    public final void a(BearUrl r2) {
        this.a.a = r2;
    }

    @Override // hn5.a
    public final void c(boolean r4) {
        qm5.a r0 = this.a;
        r0.getClass();
        HashMap r1 = new HashMap();
        if (r4 == false) goto L5;
        String r5 = "last button";
    L6:
        r1.put("op_item", r5);
        r0.c("find_item", r1);
        return;
    L5:
        r5 = "next button";
        goto L6
    }
}
