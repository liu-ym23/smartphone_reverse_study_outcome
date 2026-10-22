package tq1;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f547120a;

    public d(b r100) {
        this.f547120a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("ReplayListDataProvider", "fetch series error", (Throwable) r100);
        this.f547120a.f547109g.setValue(Boolean.FALSE);
    }
}
