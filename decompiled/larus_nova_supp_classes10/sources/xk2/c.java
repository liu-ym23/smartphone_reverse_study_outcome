package xk2;

import com.bytedance.android.ec.model.g;
import com.bytedance.android.livesdk.livecommerce.network.response.ECRedPacketResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ECRedPacketResponse r3 = (ECRedPacketResponse) r2;
        if (((g) r3).statusCode != 0) goto L5;
        a.a(this.a, r3);
        return;
    L5:
        a.a(this.a, null);
    }
}
