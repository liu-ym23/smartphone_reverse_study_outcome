package xk2;

import com.bytedance.android.livesdk.livecommerce.network.response.ECRedPacketResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f564188a;

    public c(a r100) {
        this.f564188a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ECRedPacketResponse r101 = (ECRedPacketResponse) r100;
        if (r101.statusCode != 0) goto L5;
        a.a(this.f564188a, r101);
        return;
    L5:
        a.a(this.f564188a, null);
    }
}
