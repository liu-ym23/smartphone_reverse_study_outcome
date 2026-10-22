package d71;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f467215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f467216b;

    public a(b r100, Function0 r101) {
        this.f467215a = r100;
        this.f467216b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Disposable r102 = this.f467215a.f467217c;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        this.f467216b.invoke();
    }
}
