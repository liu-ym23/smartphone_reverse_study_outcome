package i70;

import com.bytedance.android.live.core.tetris.layer.core.delegate.DefaultServiceLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.ServiceLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import j70.d;
import j70.f;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ServiceLayerDelegate f488451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f70.b f488452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LayerIndex f488453c;

    @Override // i70.a
    public final Set<d<h70.b>> getDescriptorSet() {
        return this.f488451a.f65647e;
    }

    @Override // i70.a
    public final LayerDelegate<? extends a, ? extends h70.b> getLayerDelegate() {
        return this.f488451a;
    }

    @Override // i70.a
    public final LayerIndex getLayerIndex() {
        return this.f488453c;
    }

    @Override // i70.a
    public final f70.b getLayerTypeV2() {
        return this.f488452b;
    }

    @Override // i70.a
    public final void F(d<h70.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        ServiceLayerDelegate r101 = this.f488451a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        r101.f65647e.add(r100);
    }

    @Override // i70.a
    public final Element<?> f2(f r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        return this.f488451a.f(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(f70.b r100, LayerIndex r101, h70.b r102, Class<ServiceLayerDelegate<h70.b>> r103) {
        Intrinsics.checkNotNullParameter(r100, "layerType");
        Intrinsics.checkNotNullParameter(r101, "layerIndex");
        Intrinsics.checkNotNullParameter(r102, "layerContext");
        this.f488452b = r100;
        this.f488453c = r101;
        if (r103 == null) goto L9;
        ServiceLayerDelegate<h70.b> r104 = r103.newInstance();
        if (r104 == null) goto L8;
        ServiceLayerDelegate<h70.b> r105 = r104;
    L10:
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r105.f65643a = this;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r105.f65645c = r102;
        this.f488451a = r105;
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.delegate.ServiceLayerDelegate<com.bytedance.android.live.core.tetris.layer.LayerContext>");
    L9:
        r105 = new DefaultServiceLayerDelegate();
        goto L10
    }
}
