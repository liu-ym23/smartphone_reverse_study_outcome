package tq1;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f547122a;

    public f(b r100) {
        this.f547122a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("ReplayListDataProvider", "fetch more error", (Throwable) r100);
        this.f547122a.f547109g.setValue(Boolean.FALSE);
    }
}
