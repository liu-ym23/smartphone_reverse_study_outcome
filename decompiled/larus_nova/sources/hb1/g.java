package hb1;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.soloktv.permission.BaseCheckException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f484474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Cert f484475b;

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        k<rh0.a> r101 = this.f484474a.f484469a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.b(new BaseCheckException(BaseCheckException.CheckType.AndroidPermission, "android permission denied."));
        boolean r102 = true;
        if (ArraysKt.contains(r100, "android.permission.RECORD_AUDIO") == true) goto L9;
        r102 = false;
    L9:
        if (r102 == false) goto L12;
        f2.b(R.string.ttlive_solo_ktv_audio_permission, 0);
        return;
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        k<rh0.a> r101 = this.f484474a.f484469a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.c();
    }

    public g(e r100, TokenCert r101) {
        this.f484474a = r100;
        this.f484475b = r101;
    }
}
