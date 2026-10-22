package sc5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ tk5.d<vk5.a> a;
    public final /* synthetic */ c b;

    public d(f r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        sk5.a r4 = (sk5.a) r3;
        Intrinsics.checkNotNullParameter(r4, "iOnBoarding");
        r4.g(this.a, this.b.getActivity());
    }
}
