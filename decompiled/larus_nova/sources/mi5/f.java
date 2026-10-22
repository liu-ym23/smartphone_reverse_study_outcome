package mi5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f514077a;

    public f(a r100) {
        this.f514077a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        a r102 = this.f514077a;
        Intrinsics.checkNotNull(r101);
        r102.getClass();
        a.d(r101);
        tt5.a.h("DocShareInfoBehavior", "docPublicPermFlow error");
    }
}
