package x02;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f562043a;

    public o(String r100) {
        this.f562043a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        jy0.b.d("GiftSendTimeoutReportPlugin", "report gift success, traceId = " + this.f562043a);
        c0 r102 = c0.f130474a;
        c0.m(0);
    }
}
