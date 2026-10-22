package kk9;

import com.bytedance.map.api.model.IPolyline;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;
import wq9.g;

/* JADX INFO: loaded from: classes30.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IPolyline f503829a;

    @Override // wq9.g
    public final void remove() {
        this.f503829a.remove();
    }

    public c(IPolyline r100) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.POLYLINE);
        this.f503829a = r100;
    }
}
