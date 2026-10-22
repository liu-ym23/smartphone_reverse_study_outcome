package tq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T, R> implements Function {
    public static final g<T, R> a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final Object apply(Object r3) {
        SpacePerm r4 = (SpacePerm) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        tt5.a.h("Wiki_WikiMovToFragment", "get root perm success, perm = " + r4.canEditFirstLevel);
        return Boolean.valueOf(r4.canEditFirstLevel);
    }
}
