package wj5;

import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l extends com.bytedance.ee.bear.more.protocol3.extension.u<oj5.a> {
    public final BearUrl c;
    public final String d;
    public final oj5.a e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.u
    public final void a() {
        tt5.a.h("DocShortcutMoreInfoBehavior", "create.");
        e(this.e);
        com.bytedance.ee.bear.d r0 = (com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6);
        BearUrl r3 = this.c;
        b(r0.b(r3.b, r3.a()).subscribe(new p(this), q.a));
        com.bytedance.ee.bear.appsetting.c r1 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r1.g("ccm.workspace.wiki_to_quickaccess_enabled") == false) goto L13;
        BearUrl r4 = this.c;
        String r5 = r4.b;
        int r6 = r4.a();
        if (TextUtils.isEmpty(this.c.m) == true) goto L11;
        BearUrl r7 = s45.p.a().Z(this.c.m);
        String r8 = r7.a;
        sbb.e r9 = sbb.e.n;
        if (Intrinsics.areEqual(r8, r9.getType()) == false) goto L11;
        if (TextUtils.isEmpty(r7.b) == true) goto L11;
        r5 = r7.b;
        r6 = r9.b;
    L11:
        b(((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).e(r5, r6).subscribe(new r(this), s.a));
    L13:
        if (r1.g("ccm.workspace.wiki_to_quickaccess_enabled") == false) goto L15;
    L21:
        b(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().c(this.d, 25).subscribe(new v(this), w.a));
        jg5.j r2 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        BearUrl r10 = this.c;
        b(r2.c(r10.b, r10.a()).subscribe(new x(this), m.a));
        jg5.j r11 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        BearUrl r12 = this.c;
        b(r11.b(r12.b, r12.a()).subscribe(new n(this), new o(this)));
        return;
    L15:
        if (TextUtils.isEmpty(this.c.m) == true) goto L21;
        BearUrl r13 = s45.p.a().Z(this.c.m);
        if (Intrinsics.areEqual(r13.a, sbb.e.n.getType()) == false) goto L21;
        if (TextUtils.isEmpty(r13.b) == true) goto L21;
        int r14 = com.bytedance.ee.bear.more.protocol3.extension.s.a;
        b(com.bytedance.ee.bear.more.protocol3.extension.s.a(r13.b).subscribe(new t(this), u.a));
        goto L21
    }

    public l(BearUrl r2, String r3, oj5.a r4) {
        Intrinsics.checkNotNullParameter(r2, "bearUrl");
        Intrinsics.checkNotNullParameter(r3, "shortcutToken");
        Intrinsics.checkNotNullParameter(r4, "initState");
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
