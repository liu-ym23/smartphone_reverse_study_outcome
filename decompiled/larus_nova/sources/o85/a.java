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

/* JADX INFO: loaded from: classes16.dex */
public final class a extends c0c.b implements com.bytedance.ee.bear.drive.services.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.drive.services.c f522373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f522374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.drive.services.c> f522375d;

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean B9(List<String> r100) {
        return this.f522373b.B9(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean H(String r100, String r101) {
        return this.f522373b.H(r100, r101);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final List<DriveCache> K4(long r100, String r101, String r110, UserSession r111) {
        return this.f522373b.K4(r100, r101, r110, r111);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean M9(DriveCache r100, String r101, UserSession r102) {
        return this.f522373b.M9(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean Re(long r100, long r101) {
        return this.f522373b.Re(r100, r101);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean S(String r100) {
        return this.f522373b.S(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean T5(String r100, int r101, int r102, UserSession r103) {
        return this.f522373b.T5(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean Va(long r100) {
        return this.f522373b.Va(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final List<DriveCache> X2(UserSession r100) {
        return this.f522373b.X2(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final DriveCache Zc(String r100, boolean r101, UserSession r102) {
        return this.f522373b.Zc(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final long d5(int r100) {
        return this.f522373b.d5(2);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean h1() {
        return this.f522373b.h1();
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final long l2() {
        return this.f522373b.l2();
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final List o2(int r100) {
        return this.f522373b.o2(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean p1(v85.a r100, String r101, String r102, UserSession r103) {
        return this.f522373b.p1(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean remove(String r100) {
        return this.f522373b.remove(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean removeAll() {
        return this.f522373b.removeAll();
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean y9(String r100) {
        return this.f522373b.y9(r100);
    }

    public a(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.drive.services.c> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), com.bytedance.ee.bear.drive.services.c.class), com.bytedance.ee.bear.drive.services.c.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f522373b = r103.b();
        this.f522374c = r101;
        this.f522375d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f522374c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        com.bytedance.ee.bear.drive.services.c r104 = (com.bytedance.ee.bear.drive.services.c) k.b(r102.c(r103), com.bytedance.ee.bear.drive.services.c.class);
        this.f522375d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
