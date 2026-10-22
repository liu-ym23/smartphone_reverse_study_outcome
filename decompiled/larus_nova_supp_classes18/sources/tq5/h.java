package tq5;

import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T, R> implements Function {
    public static final h<T, R> a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final Object apply(Object r3) {
        WikNodePerm r4 = (WikNodePerm) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        tt5.a.h("Wiki_WikiMovToFragment", "get node perm success, perm = " + r4.can_create);
        return Boolean.valueOf(r4.can_create);
    }
}
