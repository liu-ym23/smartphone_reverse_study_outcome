package zb9;

import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c<ITEM> implements d<ITEM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s<ITEM> f571184b;

    @Override // zb9.d
    public final String a() {
        return this.f571183a;
    }

    @Override // zb9.d
    public final s<ITEM> getDataSource() {
        return this.f571184b;
    }

    @Override // zb9.d
    public final void c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f571184b.f(r100);
    }

    @Override // zb9.d
    public final void d(GroupSortPolicy r100) {
        Intrinsics.checkNotNullParameter(r100, "policy");
        this.f571184b.h(r100);
    }

    @Override // zb9.d
    public final void e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f571184b.d(r100);
    }

    public c(String r100, s<ITEM> r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceId");
        Intrinsics.checkNotNullParameter(r101, "dataSource");
        this.f571183a = r100;
        this.f571184b = r101;
    }

    @Override // zb9.d
    public final void b(int r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "ext");
        this.f571184b.a(new j(r100, r101));
    }

    @Override // zb9.d
    public final void f(int r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "ext");
        this.f571184b.g(new j(r100, r101));
    }
}
