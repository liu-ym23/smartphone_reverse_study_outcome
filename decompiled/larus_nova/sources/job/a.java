package job;

import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.keyboard.base.n;
import cya.f;
import cya.g;
import cya.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements g<com.ss.android.lark.keyboard.inputstate.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.inputstate.a f499919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f499920b;

    public a(com.ss.android.lark.keyboard.inputstate.a r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f499919a = r100;
    }

    @Override // cya.g
    public final void a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f499919a.l(r100.f465978a);
        this.f499919a.e();
    }

    @Override // cya.g
    public final void b(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        f r101 = this.f499920b;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r101 = null;
    L6:
        r101.b(r100);
    }

    @Override // cya.g
    public final void c(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        n r101 = this.f499919a.y();
        cya.a.C5608a r102 = cya.a.f465968c;
        cya.a r103 = (cya.a) r101.a(r102);
        n r104 = this.f499919a.y();
        QueryStatusInfo.a r105 = QueryStatusInfo.Companion;
        QueryStatusInfo r106 = (QueryStatusInfo) r104.a(r105);
        r100.f465978a.b(r102, r103);
        r100.f465978a.b(r105, r106);
    }

    @Override // cya.g
    public final void e(f r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f499920b = r100;
    }

    @Override // cya.g
    public final void f(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        f r101 = this.f499920b;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r101 = null;
    L6:
        r101.b(r100);
    }

    @Override // cya.g
    public final void d(h r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r101 != 61441) goto L10;
        r100.f465978a.b(h.f465975d, Boolean.TRUE);
        f r102 = this.f499920b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r102 = null;
    L8:
        r102.b(r100);
        return;
    }
}
