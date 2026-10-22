package kq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.SidebarHomeTreeView;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SidebarHomeTreeView f505599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ vd5.c f505600b;

    public k(SidebarHomeTreeView r100, vd5.c r101) {
        this.f505599a = r100;
        this.f505600b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Pair r101 = (Pair) r100;
        Intrinsics.checkNotNullParameter(r101, "workspace");
        SidebarHomeTreeView.b(this.f505599a, this.f505600b, r101);
        return Boolean.TRUE;
    }
}
