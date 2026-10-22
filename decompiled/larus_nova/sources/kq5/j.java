package kq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.SidebarHomeTreeView;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SidebarHomeTreeView f505597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ vd5.c f505598b;

    public j(SidebarHomeTreeView r100, vd5.c r101) {
        this.f505597a = r100;
        this.f505598b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Pair r101 = (Pair) r100;
        Intrinsics.checkNotNullParameter(r101, "workspace");
        SidebarHomeTreeView.b(this.f505597a, this.f505598b, r101);
        return Boolean.TRUE;
    }
}
