package tz4;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.container.f;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.s2;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.list.create.r0;
import com.larus.office.base.service.OfficeSdkServiceV2;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends c0c.b implements ik5.a {
    public final /* synthetic */ ik5.a b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<ik5.a> d;

    public static final class a {
    }

    static {
    }

    public final qd5.a A4() {
        return this.b.A4();
    }

    public final com.bytedance.ee.bear.list.recent.b Bb() {
        return this.b.Bb();
    }

    public final Fragment C6(String r8, Long r9, String r10, hk5.a r11, f r12) {
        Intrinsics.checkNotNullParameter(r8, "url");
        return this.b.C6(r8, r9, r10, r11, r12);
    }

    public final com.bytedance.ee.bear.list.move.e D2() {
        return this.b.D2();
    }

    public final com.bytedance.ee.bear.list.cover.a F9() {
        return this.b.F9();
    }

    public final String J9() {
        return this.b.J9();
    }

    public final void Ka(sbb.e r2, v4 r3) {
        Intrinsics.checkNotNullParameter(r2, "documentType");
        Intrinsics.checkNotNullParameter(r3, "strategy");
        this.b.Ka(r2, r3);
    }

    public final r0 Q3() {
        return this.b.Q3();
    }

    public final void Qd(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.b.Qd(r2);
    }

    public final com.bytedance.ee.bear.list.delete.f R() {
        return this.b.R();
    }

    public final j15.a R4(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        return this.b.R4(r2, r3);
    }

    public final nd5.a T2() {
        return this.b.T2();
    }

    public final void Ta(OfficeSdkServiceV2.d r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.b.Ta(r2);
    }

    public final v4 a5(sbb.e r2) {
        Intrinsics.checkNotNullParameter(r2, "documentType");
        return this.b.a5(r2);
    }

    public final jk5.a ff() {
        return this.b.ff();
    }

    public final void ga() {
        this.b.ga();
    }

    public final void r2(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, DocRedirectToDocxPlugin.FROM);
        this.b.r2(r2, r3);
    }

    public final rd5.a t2() {
        return this.b.t2();
    }

    public final j15.b y4(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        return this.b.y4(r2, r3);
    }

    public final void z2(s2 r2) {
        Intrinsics.checkNotNullParameter(r2, "resInfo");
        this.b.z2(r2);
    }

    public e(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<ik5.a> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), ik5.a.class), ik5.a.class);
        Intrinsics.checkNotNullParameter(r4, "passportService");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (ik5.a) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r2, g r3) {
        tt5.a.h("UserDocsSdkProxy", "preparing");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        ik5.a r6 = (ik5.a) k.b(r4.c(r5), ik5.a.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
