package fk;

import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends rj.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f477554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ck.b f477555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g f477556f;

    @Override // rj.a, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadSuccess() {
        super.onLoadSuccess();
        this.f477554d.getClass();
    }

    @Override // rj.a, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadFailed(ECLynxCardErrorType r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        super.onLoadFailed(r100, r101, r102);
        this.f477554d.getClass();
        Lazy r103 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.e.f47505b, "PopupCard Load failed code-" + r101 + " msg-" + r102);
        this.f477555e.f(this.f477554d);
    }

    public c(e r100, ck.b r101, g r102, com.bytedance.android.ec.hybrid.card.api.e r103, String r104) {
        this.f477554d = r100;
        this.f477555e = r101;
        this.f477556f = r102;
        super(r103, r104);
    }
}
