package wj5;

import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends com.bytedance.ee.bear.more.protocol3.extension.u<oj5.a> {
    public final BearUrl c;
    public final oj5.a d;

    /* JADX INFO: renamed from: wj5.a$a, reason: collision with other inner class name */
    public static final class C0325a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.u
    public final void a() {
        tt5.a.h("DocMoreInfoBehavior", "create.");
        e(this.d);
        if (TextUtils.isEmpty(this.c.m) == false) goto L8;
        if (sbb.g.b(this.c.a()) == false) goto L8;
        BearUrl r0 = this.c;
    L12:
        int r6 = r0.a();
        String r4 = r0.b;
        String r5 = this.c.b;
        if (r6 != 16) goto L15;
        boolean r3 = true;
    L16:
        Flowable r1 = ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).b(r4, r6);
        Flowable r7 = ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).e(r4, r6);
        Flowable<DocPermission> r8 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r4, r6);
        Flowable<DocVersion> r9 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).g(r4, r6);
        rc5.a r2 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
        if (r3 == false) goto L19;
        String r10 = r4;
    L20:
        Flowable<Boolean> r11 = r2.S(r10);
        b(r1.subscribe(new c(this), d.a));
        b(r7.subscribe(new e(this), f.a));
        b(r8.subscribe(new g(this), h.a));
        b(r9.subscribe(new i(this), j.a));
        b(r11.observeOn(fo5.d.d()).subscribe(new k(this, r3, r4, r5, r6), b.a));
        return;
    L19:
        r10 = r5;
        goto L20
    L15:
        r3 = false;
    L8:
        if (TextUtils.isEmpty(this.c.m) == true) goto L10;
        String r12 = this.c.m;
    L11:
        r0 = s45.p.a().Z(r12);
        goto L12
    L10:
        r12 = this.c.e;
        goto L11
    }

    public a(BearUrl r2, oj5.a r3) {
        Intrinsics.checkNotNullParameter(r2, "bearUrl");
        Intrinsics.checkNotNullParameter(r3, "initState");
        this.c = r2;
        this.d = r3;
    }
}
