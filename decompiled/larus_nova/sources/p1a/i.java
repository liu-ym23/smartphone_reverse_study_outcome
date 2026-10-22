package p1a;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseSlotWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i extends f<BaseSlotWidget> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f527341c;

    public i() {
    }

    @Override // p1a.f
    public final void b(ComponentFeature r100) {
        BaseSlotWidget r101 = (BaseSlotWidget) r100;
        Intrinsics.checkNotNullParameter(r101, "feature");
        r101.f375157k = this.f527341c;
    }
}
