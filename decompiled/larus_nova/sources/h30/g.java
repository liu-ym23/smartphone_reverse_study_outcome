package h30;

import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.b f483667a;

    public g(f.b r100) {
        this.f483667a = r100;
    }

    @Override // h30.a
    public final void a(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        f.b r101 = this.f483667a;
        String r102 = f.f483665c;
        r101.getClass();
        r101.finishWithResult(f.b.j(r102));
    }

    @Override // h30.a
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        f.b r101 = this.f483667a;
        String r102 = f.f483666d;
        r101.getClass();
        r101.finishWithResult(f.b.j(r102));
    }

    @Override // h30.a
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        f.b r101 = this.f483667a;
        String r102 = f.f483664b;
        r101.getClass();
        r101.finishWithResult(f.b.j(r102));
    }
}
