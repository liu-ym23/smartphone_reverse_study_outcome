package n8b;

import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes35.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConditionalAccessNetDependency f518376a;

    public f(ConditionalAccessNetDependency r100) {
        this.f518376a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Disposable r101 = (Disposable) r100;
        this.f518376a.f418076a.i();
    }
}
