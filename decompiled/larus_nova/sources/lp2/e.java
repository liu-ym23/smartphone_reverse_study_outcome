package lp2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.pushpreload.LivePushPreloadNetResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePushPreloadNetResult f510208a;

    public e(LivePushPreloadNetResult r100) {
        this.f510208a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.i("LivePushLandPreload", "preload called, error");
        LivePushPreloadNetResult r101 = this.f510208a;
        r101.setError((Throwable) r100).setStatus(false);
    }
}
