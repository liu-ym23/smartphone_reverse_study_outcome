package kv2;

import com.bytedance.common.utility.Logger;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements Observer<f.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f506244a;

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        Logger.d("LiveFontManager", "local font load complete.");
        this.f506244a.a();
    }

    public g(f r100) {
        this.f506244a = r100;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Logger.d("LiveFontManager", "local font load failed: " + r100.getMessage());
        this.f506244a.a();
    }

    @Override // io.reactivex.Observer
    public final void onNext(f.d r100) {
        f.d r101 = r100;
        Logger.d("LiveFontManager", "local font loaded: " + r101.f506243b);
        this.f506244a.f506234a.onNext(r101);
    }
}
