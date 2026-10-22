package tq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T, R> f547153a = null;

    static {
        f547153a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        SpacePerm r101 = (SpacePerm) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        tt5.a.h("Wiki_WikiMovToFragment", "get root perm success, perm = " + r101.canEditFirstLevel);
        return Boolean.valueOf(r101.canEditFirstLevel);
    }
}
