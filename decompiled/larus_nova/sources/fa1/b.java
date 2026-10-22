package fa1;

import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f476010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f476011b;

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        String r101 = rm3.c.f538539a;
        rm3.c.f(this.f476010a.getContext(), R.string.ttlive_save_image_failed, true, 16);
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        this.f476010a.e(this.f476011b);
    }

    public b(a r100, String r101) {
        this.f476010a = r100;
        this.f476011b = r101;
    }
}
