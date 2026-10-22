package yt3;

import com.bytedance.apm.util.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class c$c {
    public String a;
    public c$c b;
    public long c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public final /* synthetic */ c h;

    public c$c(c r1) {
        this.h = r1;
    }

    public final void a(long r17, v<c$b> r19, v<c$b> r20) {
        long r8 = this.c + r17;
        this.c = r8;
        boolean r4 = true;
        int r3 = this.e + 1;
        this.e = r3;
        c$c r5 = this.b;
        if (r5 == null) goto L37;
        int r10 = this.d;
        if (r3 != r10) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L10;
        return;
    L10:
        if (this.g == false) goto L12;
        r5.g = true;
    L12:
        c r7 = this.h;
        if (r8 >= r7.j.b) goto L15;
    L26:
        this.b.a(this.c, r19, r20);
        if (this.f == false) goto L39;
        c r2 = this.h;
        long r9 = this.c;
        r2.getClass();
        if (r9 >= 104857600) goto L31;
    L33:
        r4 = false;
    L34:
        if (r4 == false) goto L40;
        final c r11 = this.h;
        final String r12 = this.a;
        final long r13 = this.c;
        final int r14 = this.d;
        final long r15 = r14;
        r19.a(new c$d(r11, r12, r13, r14, r15));
        return;
    L40:
        return;
    L31:
        if (r9 > 17179869184L) goto L33;
    L39:
        return;
    L15:
        if (this.g == true) goto L26;
        if (r8 >= 0) goto L19;
    L22:
        boolean r16 = true;
    L23:
        if (r16 == true) goto L25;
        r20.a(new c$b(r7, this.a, r8, r10));
    L25:
        this.b.g = true;
        goto L26
    L19:
        if (r8 > 17179869184L) goto L22;
        r16 = false;
        goto L23
    L7:
        r6 = false;
        goto L8
    }
}
