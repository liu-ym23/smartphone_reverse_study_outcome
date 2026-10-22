package p1a;

import com.larus.ui.arch.component.external.api.Component;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends f<Component> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Function1<a, ComponentFeature>> f527333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Function1<j, ComponentFeature>> f527334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Function1<e, ComponentFeature>> f527335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<ContainerFilter> f527336f;

    public b() {
        this.f527333c = new ArrayList();
        this.f527334d = new ArrayList();
        this.f527335e = new ArrayList();
        this.f527336f = new ArrayList();
    }

    @Override // p1a.f
    public final void b(ComponentFeature r100) {
        Component r101 = (Component) r100;
        Intrinsics.checkNotNullParameter(r101, "feature");
        ArrayList<Function1<e, ComponentFeature>> r102 = this.f527335e;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f375137j = r102;
        ArrayList<Function1<j, ComponentFeature>> r103 = this.f527334d;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.f375136i = r103;
        ArrayList<Function1<a, ComponentFeature>> r104 = this.f527333c;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r101.f375135h = r104;
        ArrayList<ContainerFilter> r105 = this.f527336f;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r101.f375138k = r105;
        Intrinsics.checkNotNullParameter(r101, "feature");
    }

    public final void e(ContainerFilter r100) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        this.f527336f.add(r100);
    }

    public final void f(Function1<? super a, ? extends ComponentFeature> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        this.f527333c.add(r100);
    }

    public final void g(Function1<? super e, ? extends ComponentFeature> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        this.f527335e.add(r100);
    }

    public final void h(Function1<? super j, ? extends ComponentFeature> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        this.f527334d.add(r100);
    }
}
