package kq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.SidebarHomeTreeView;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l<T, R> implements Function {
    public final /* synthetic */ SidebarHomeTreeView a;
    public final /* synthetic */ vd5.c b;

    public l(SidebarHomeTreeView r1, vd5.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r3) {
        Pair r4 = (Pair) r3;
        Intrinsics.checkNotNullParameter(r4, "workspace");
        SidebarHomeTreeView.b(this.a, this.b, r4);
        return Boolean.TRUE;
    }
}
