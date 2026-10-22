package ss3;

import android.text.TextUtils;
import com.bytedance.apm.d;
import com.bytedance.apm.util.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class g$c {
    public String a;
    public g$c b;
    public long c;
    public int d;
    public int e;
    public boolean f;
    public long g;
    public boolean h;
    public final /* synthetic */ g i;

    public g$c(g r1) {
        this.i = r1;
    }

    public final void a(long r8) {
        long r0 = this.c + r8;
        this.c = r0;
        int r9 = this.e + 1;
        this.e = r9;
        g$c r2 = this.b;
        if (r2 == null) goto L43;
        int r3 = this.d;
        if (r9 != r3) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L10;
        return;
    L10:
        if (this.h == false) goto L12;
        r2.h = true;
    L12:
        g r11 = this.i;
        if (r0 >= r11.j) goto L15;
    L27:
        this.b.a(this.c);
        if (this.f == false) goto L31;
        this.i.i(this.a, this.c, this.d, this.g);
    L31:
        if (TextUtils.equals(this.a, g.B) == false) goto L34;
        g r12 = this.i;
        r12.o = this.c;
        return;
    L34:
        if (TextUtils.equals(this.a, g.C) == false) goto L37;
        g r13 = this.i;
        r13.p = this.c;
        return;
    L37:
        if (TextUtils.equals(this.a, this.i.m) == false) goto L40;
        g r14 = this.i;
        r14.q = this.c;
        return;
    L40:
        if (TextUtils.equals(this.a, this.i.n) == false) goto L48;
        g r15 = this.i;
        r15.r = this.c;
        return;
    L48:
        return;
    L15:
        if (this.h == true) goto L27;
        String r4 = this.a;
        r11.getClass();
        if (d.j() == true) goto L20;
    L20:
        if (r0 <= 17179869184L) goto L23;
    L26:
        this.b.h = true;
        goto L27
    L23:
        if (r11.z != null) goto L25;
        r11.z = new v(r11.k);
    L25:
        r11.z.a(new g$b(r4, r0, r3));
        goto L26
    L7:
        r10 = false;
        goto L8
    }
}
