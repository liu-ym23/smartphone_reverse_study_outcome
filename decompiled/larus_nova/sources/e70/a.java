package e70;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import h70.b;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a<T extends h70.b> extends j70.h<T> implements j70.e {
    public abstract d<T> N();

    public abstract e<T> O();

    public abstract f<T> P();

    @Override // j70.h
    @Deprecated(message = "no more use")
    public final f70.b L() {
        d<T> r100 = N();
        if ((r100 instanceof c) == false) goto L6;
        return ((c) r100).getLayerType();
    L6:
        if ((r100 instanceof i) == false) goto L9;
        return ((i) r100).getLayerType();
    L9:
        return f70.b.f475744c;
    }

    public a() {
    }

    @Override // j70.d
    @Deprecated(message = "no more use", replaceWith = @ReplaceWith(expression = "getLoadConfig().needLoad(layerContext)", imports = {}))
    public final boolean B(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return O().r(r100);
    }

    @Override // j70.d
    @Deprecated(message = "no more use", replaceWith = @ReplaceWith(expression = "getComponentConfig().elementType(layerContext)", imports = {}))
    public final j70.f C(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return P().p(r100);
    }

    @Override // j70.d
    @Deprecated(message = "no more use")
    public final LayerIndex E(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        d<T> r101 = N();
        if ((r101 instanceof c) == false) goto L6;
        return ((c) r101).getLayerIndex();
    L6:
        if ((r101 instanceof i) == false) goto L9;
        return LayerIndex.INDEX_XML;
    L9:
        return LayerIndex.INDEX_SERVICE;
    }

    @Override // j70.h
    @Deprecated(message = "no more use")
    public final ElementConstraint J(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        d<T> r101 = N();
        if ((r101 instanceof c) == true) goto L5;
        r101 = null;
    L5:
        c r102 = (c) r101;
        if (r102 == null) goto L10;
        ElementConstraint r103 = r102.t();
        if (r103 == null) goto L10;
        return r103;
    L10:
        return new ElementConstraint(0.0f, 3);
    }

    @Override // j70.h
    @Deprecated(message = "no more use")
    public final com.bytedance.android.live.core.tetris.layer.view.b K(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        d<T> r101 = N();
        if ((r101 instanceof c) == true) goto L5;
        r101 = null;
    L5:
        c r102 = (c) r101;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.d();
    }
}
