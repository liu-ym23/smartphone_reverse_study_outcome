package up4;

import com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.AsyncFetchResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f551040a;

    public c(b r100) {
        this.f551040a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        b r101 = this.f551040a;
        r101.f551035u = (cp4.b) ((AsyncFetchResult) r100).f209050a;
        rp4.a r102 = r101.f207866j;
        if (r102 == null) goto L6;
        r101.g(r102);
        return;
    }
}
