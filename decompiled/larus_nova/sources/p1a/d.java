package p1a;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d extends f<BaseContentWidget> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f527337c;

    public d() {
    }

    @Override // p1a.f
    public final void b(ComponentFeature r100) {
        BaseContentWidget r101 = (BaseContentWidget) r100;
        Intrinsics.checkNotNullParameter(r101, "feature");
        r101.X2(this.f527337c);
    }
}
