package v00;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f552296a;

    public b(Function1 r100) {
        this.f552296a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Function1 r102 = this.f552296a;
        if (r101 != null) goto L5;
        r101 = new Throwable("auth error");
    L5:
        r102.invoke(r101);
    }
}
