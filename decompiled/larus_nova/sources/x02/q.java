package x02;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f562045a;

    public q(String r100) {
        this.f562045a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        jy0.b.d("GiftSendTimeoutReportPlugin", "report prop success, traceId = " + this.f562045a);
        c0 r102 = c0.f130474a;
        c0.h(0);
    }
}
