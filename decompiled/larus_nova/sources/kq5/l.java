package kq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.SidebarHomeTreeView;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SidebarHomeTreeView f505601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ vd5.c f505602b;

    public l(SidebarHomeTreeView r100, vd5.c r101) {
        this.f505601a = r100;
        this.f505602b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Pair r101 = (Pair) r100;
        Intrinsics.checkNotNullParameter(r101, "workspace");
        SidebarHomeTreeView.b(this.f505601a, this.f505602b, r101);
        return Boolean.TRUE;
    }
}
