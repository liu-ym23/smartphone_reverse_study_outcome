package wj5;

import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l extends com.bytedance.ee.bear.more.protocol3.extension.u<oj5.a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BearUrl f560001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f560002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final oj5.a f560003e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.u
    public final void a() {
        tt5.a.h("DocShortcutMoreInfoBehavior", "create.");
        e(this.f560003e);
        com.bytedance.ee.bear.d r100 = (com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6);
        BearUrl r101 = this.f560001c;
        b(r100.b(r101.f222561b, r101.a()).subscribe(new p(this), q.f560008a));
        com.bytedance.ee.bear.appsetting.c r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        if (r102.g("ccm.workspace.wiki_to_quickaccess_enabled") == false) goto L13;
        BearUrl r103 = this.f560001c;
        String r104 = r103.f222561b;
        int r105 = r103.a();
        if (TextUtils.isEmpty(this.f560001c.f222572m) == true) goto L11;
        BearUrl r106 = s45.p.a().Z(this.f560001c.f222572m);
        String r107 = r106.f222560a;
        sbb.e r108 = sbb.e.f541303n;
        if (Intrinsics.areEqual(r107, r108.getType()) == false) goto L11;
        if (TextUtils.isEmpty(r106.f222561b) == true) goto L11;
        r104 = r106.f222561b;
        r105 = r108.f541317b;
    L11:
        b(((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).e(r104, r105).subscribe(new r(this), s.f560010a));
    L13:
        if (r102.g("ccm.workspace.wiki_to_quickaccess_enabled") == false) goto L15;
    L21:
        b(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().c(this.f560002d, 25).subscribe(new v(this), w.f560014a));
        jg5.j r109 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        BearUrl r110 = this.f560001c;
        b(r109.c(r110.f222561b, r110.a()).subscribe(new x(this), m.f560004a));
        jg5.j r111 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        BearUrl r112 = this.f560001c;
        b(r111.b(r112.f222561b, r112.a()).subscribe(new n(this), new o(this)));
        return;
    L15:
        if (TextUtils.isEmpty(this.f560001c.f222572m) == true) goto L21;
        BearUrl r113 = s45.p.a().Z(this.f560001c.f222572m);
        if (Intrinsics.areEqual(r113.f222560a, sbb.e.f541303n.getType()) == false) goto L21;
        if (TextUtils.isEmpty(r113.f222561b) == true) goto L21;
        int r114 = com.bytedance.ee.bear.more.protocol3.extension.s.f234843a;
        b(com.bytedance.ee.bear.more.protocol3.extension.s.a(r113.f222561b).subscribe(new t(this), u.f560012a));
        goto L21
    }

    public l(BearUrl r100, String r101, oj5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bearUrl");
        Intrinsics.checkNotNullParameter(r101, "shortcutToken");
        Intrinsics.checkNotNullParameter(r102, "initState");
        this.f560001c = r100;
        this.f560002d = r101;
        this.f560003e = r102;
    }
}
