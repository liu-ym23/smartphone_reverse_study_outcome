package pn1;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f529952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ef1.a f529953b;

    public b(a r100, ef1.a r101) {
        this.f529952a = r100;
        this.f529953b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        this.f529952a.f529946d.remove(Integer.valueOf(this.f529953b.b()));
        this.f529952a.f529947e.f(this.f529953b);
        a r102 = this.f529952a;
        r102.f529947e.a(r102.f529946d.size(), this.f529952a.f529945c);
    }
}
