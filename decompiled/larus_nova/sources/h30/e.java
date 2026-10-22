package h30;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.a f483662a;

    public e(f.a r100) {
        this.f483662a = r100;
    }

    @Override // h30.a
    public final void a(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        f.a r101 = this.f483662a;
        String r102 = f.f483665c;
        r101.getClass();
        r101.finishWithResult(f.a.j(r102));
    }

    @Override // h30.a
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        f.a r101 = this.f483662a;
        String r102 = f.f483666d;
        r101.getClass();
        r101.finishWithResult(f.a.j(r102));
    }

    @Override // h30.a
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        f.a r101 = this.f483662a;
        String r102 = f.f483664b;
        r101.getClass();
        r101.finishWithResult(f.a.j(r102));
    }
}
