package tq5;

import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h<T, R> f547154a = null;

    static {
        f547154a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        WikNodePerm r101 = (WikNodePerm) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        tt5.a.h("Wiki_WikiMovToFragment", "get node perm success, perm = " + r101.can_create);
        return Boolean.valueOf(r101.can_create);
    }
}
