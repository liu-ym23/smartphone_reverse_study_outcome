package o85;

import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends c0c.b implements com.bytedance.ee.bear.drive.services.c {
    public final /* synthetic */ com.bytedance.ee.bear.drive.services.c b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.drive.services.c> d;

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean B9(List<String> r2) {
        return this.b.B9(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean H(String r2, String r3) {
        return this.b.H(r2, r3);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final List<DriveCache> K4(long r7, String r9, String r10, UserSession r11) {
        return this.b.K4(r7, r9, r10, r11);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean M9(DriveCache r2, String r3, UserSession r4) {
        return this.b.M9(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean Re(long r2, long r4) {
        return this.b.Re(r2, r4);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean S(String r2) {
        return this.b.S(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean T5(String r2, int r3, int r4, UserSession r5) {
        return this.b.T5(r2, r3, r4, r5);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean Va(long r2) {
        return this.b.Va(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final List<DriveCache> X2(UserSession r2) {
        return this.b.X2(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final DriveCache Zc(String r2, boolean r3, UserSession r4) {
        return this.b.Zc(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final long d5(int r3) {
        return this.b.d5(2);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean h1() {
        return this.b.h1();
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final long l2() {
        return this.b.l2();
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final List o2(int r2) {
        return this.b.o2(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean p1(v85.a r2, String r3, String r4, UserSession r5) {
        return this.b.p1(r2, r3, r4, r5);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean remove(String r2) {
        return this.b.remove(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean removeAll() {
        return this.b.removeAll();
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean y9(String r2) {
        return this.b.y9(r2);
    }

    public a(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.drive.services.c> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), com.bytedance.ee.bear.drive.services.c.class), com.bytedance.ee.bear.drive.services.c.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (com.bytedance.ee.bear.drive.services.c) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r1, g r2) {
        v r3 = this.c;
        if (r2 == null) goto L6;
        UserSession r4 = r2.b;
        if (r4 == null) goto L6;
    L7:
        com.bytedance.ee.bear.drive.services.c r5 = (com.bytedance.ee.bear.drive.services.c) k.b(r3.c(r4), com.bytedance.ee.bear.drive.services.c.class);
        this.d.e(r5);
        return;
    L6:
        r4 = ContainerConstsKt.a();
        goto L7
    }
}
