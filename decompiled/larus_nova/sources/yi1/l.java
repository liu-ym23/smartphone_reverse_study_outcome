package yi1;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f567893a = null;

    static {
        f567893a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        NewBroadcastMonitor.a r102 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_PING_ANCHOR_FAILED, null, null, 14);
        r102.c(String.valueOf(3));
        r102.d("audience_exit_jump");
        r102.a().report();
    }
}
