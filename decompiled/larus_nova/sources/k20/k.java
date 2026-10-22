package k20;

import com.bytedance.android.live.broadcastgame.opengame.q;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f501470a = null;

    static {
        f501470a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = q.f60744a;
        q.i((Throwable) r100, "XplayTerminateService", "on game_stop fail");
    }
}
