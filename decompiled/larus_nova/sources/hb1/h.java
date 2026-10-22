package hb1;

import com.bytedance.android.live.soloktv.permission.BaseCheckException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements o60.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f484476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Cert f484477b;

    public h(e r100, TokenCert r101) {
        this.f484476a = r100;
        this.f484477b = r101;
    }

    @Override // o60.d
    public final void a() {
        k<rh0.a> r100 = this.f484476a.f484469a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r100.b(new BaseCheckException(BaseCheckException.CheckType.AndroidPermission, "android permission denied and go to settings."));
    }
}
