package hb1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements o60.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f484466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Cert f484467b;

    public d(a r100, TokenCert r101) {
        this.f484466a = r100;
        this.f484467b = r101;
    }

    @Override // o60.d
    public final void a() {
        ALogger.d("ttlive_link", "skip bluetooth permission denied and go to settings");
        k<rh0.a> r100 = this.f484466a.f484459a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r100.c();
    }
}
