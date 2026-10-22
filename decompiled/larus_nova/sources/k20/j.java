package k20;

import com.bytedance.android.live.broadcastgame.opengame.q;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f501469a = null;

    static {
        f501469a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        int r102 = q.f60744a;
        q.f("XplayTerminateService", new Object[]{"on game_stop success"});
    }
}
