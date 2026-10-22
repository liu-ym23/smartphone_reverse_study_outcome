package k20;

import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f501466a = null;

    static {
        f501466a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        int r102 = q.f60744a;
        q.f("XplayTerminateService", new Object[]{"on app stop success"});
    }
}
