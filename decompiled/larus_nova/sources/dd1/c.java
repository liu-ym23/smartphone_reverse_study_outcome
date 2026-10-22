package dd1;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.bytedance.android.livesdk.revenue.service.network.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublishSubject f467921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ApiServerException f467922b;

    @Override // com.bytedance.android.livesdk.revenue.service.network.b
    public final void a() {
        this.f467922b.setBlockNotice(true);
        this.f467921a.onError(this.f467922b);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.network.b
    public final void b() {
        ApiServerException r100 = new ApiServerException(42200);
        r100.setAlert(s1.B(R.string.wallet_minor_intercept_content));
        this.f467921a.onError(r100);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.network.b
    public final void onVerifySuccess() {
        this.f467921a.onNext(1);
    }

    public c(PublishSubject r100, ApiServerException r101) {
        this.f467921a = r100;
        this.f467922b = r101;
    }
}
