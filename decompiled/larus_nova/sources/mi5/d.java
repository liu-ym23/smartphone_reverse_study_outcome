package mi5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f514075a;

    public d(a r100) {
        this.f514075a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        a r102 = this.f514075a;
        Intrinsics.checkNotNull(r101);
        r102.getClass();
        a.d(r101);
        tt5.a.e("DocShareInfoBehavior", "fetch metaInfo and permission failed", r101, false);
    }
}
