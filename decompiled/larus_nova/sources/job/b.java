package job;

import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.base.n;
import com.ss.android.lark.log.Log;
import cya.f;
import cya.g;
import cya.h;
import cya.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements g<com.ss.android.lark.keyboard.inputstate.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.inputstate.a f499921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f499922b;

    public static final class a {
    }

    static {
    }

    public final void g() {
        h.b r100 = new h.b();
        n r101 = r100.f465978a;
        r101.b(ReEditInfo.Companion, new ReEditInfo("", 0, false, 6, null));
        r101.b(h.f465975d, Boolean.TRUE);
        f r102 = this.f499922b;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r102 = null;
    L6:
        r102.b(r100);
    }

    public b(com.ss.android.lark.keyboard.inputstate.a r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f499921a = r100;
    }

    @Override // cya.g
    public final void a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        g();
        this.f499921a.l(r100.f465978a);
        ReEditInfo r101 = (ReEditInfo) r100.f465978a.a(ReEditInfo.Companion);
        if (r101 != null) goto L5;
        r101 = new ReEditInfo("", 0, false, 6, null);
    L5:
        this.f499921a.g(r101, (i) r100.f465978a.a(i.f465980h));
        this.f499921a.e();
    }

    @Override // cya.g
    public final void b(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (Intrinsics.areEqual(r100.f465978a.a(com.ss.android.lark.keyboard.inputstate.b.f429427h), Boolean.TRUE) == false) goto L5;
        Log.i("ReEditStateConsumer", "consumePop: finish reedit mode is true , remove reedit draft");
        g();
    L10:
        this.f499921a.z();
        return;
    L5:
        r100.f465978a.b(h.f465975d, Boolean.FALSE);
        f r101 = this.f499922b;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r101 = null;
    L9:
        r101.b(r100);
        goto L10
    }

    @Override // cya.g
    public final void c(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        n r101 = this.f499921a.y();
        cya.a.C5608a r102 = cya.a.f465968c;
        cya.a r103 = (cya.a) r101.a(r102);
        r100.f465978a.b(r102, r103);
    }

    @Override // cya.g
    public final void e(f r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f499922b = r100;
    }

    @Override // cya.g
    public final void f(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        r100.f465978a.b(h.f465975d, Boolean.FALSE);
        f r101 = this.f499922b;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r101 = null;
    L6:
        r101.b(r100);
        this.f499921a.z();
    }

    @Override // cya.g
    public final void d(h r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r101 != 61441) goto L10;
        r100.f465978a.b(h.f465975d, Boolean.TRUE);
        f r102 = this.f499922b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r102 = null;
    L8:
        r102.b(r100);
        return;
    }
}
