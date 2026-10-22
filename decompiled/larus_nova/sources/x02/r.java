package x02;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f562046a;

    public r(String r100) {
        this.f562046a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof RuntimeException) == true) goto L6;
        jy0.b.c("GiftSendTimeoutReportPlugin", "report prop fail, traceId = " + this.f562046a + ", errmsg = " + r101.getMessage(), null, 4);
        c0 r102 = c0.f130474a;
        c0.h(1);
        ToastUtil.a(R.string.ttlive_send_gift_fail, 0);
        return;
    }
}
