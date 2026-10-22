package kk9;

import com.bytedance.map.api.model.IMarker;
import kotlin.jvm.internal.Intrinsics;
import wq9.f;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IMarker f503828a;

    @Override // wq9.f
    public final void destroy() {
        this.f503828a.destroy();
    }

    public b(IMarker r100) {
        Intrinsics.checkNotNullParameter(r100, "marker");
        this.f503828a = r100;
    }
}
