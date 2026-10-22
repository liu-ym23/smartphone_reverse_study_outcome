package hd5;

import ax4.d;
import com.bytedance.ee.bear.contract.d0;
import io.reactivex.functions.Consumer;
import lc5.f;
import lc5.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ d0 a;

    public b(d0 r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        if (d.b((Throwable) r9, 4007) == false) goto L5;
        String r10 = "failed_cross_unit";
    L6:
        String r4 = r10;
        f.a r11 = f.a;
        com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        d0 r0 = this.a;
        String r2 = r0.h;
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        String r5 = r0.g;
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        int r6 = r0.getType();
        String r3 = this.a.b;
        if (r3 != null) goto L15;
        String r7 = "";
    L16:
        f.a.H(new o(r1, r2, r5, r4, r6, r7));
        return;
    L15:
        r7 = r3;
        goto L16
    L5:
        r10 = "failed";
        goto L6
    }
}
