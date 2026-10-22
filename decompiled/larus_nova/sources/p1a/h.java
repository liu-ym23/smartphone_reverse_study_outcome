package p1a;

import com.larus.ui.arch.component.external.LazySlotComponent;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h extends f<LazySlotComponent> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f527340c;

    public h() {
    }

    @Override // p1a.f
    public final void b(ComponentFeature r100) {
        LazySlotComponent r101 = (LazySlotComponent) r100;
        Intrinsics.checkNotNullParameter(r101, "feature");
        r101.f375157k = this.f527340c;
    }
}
