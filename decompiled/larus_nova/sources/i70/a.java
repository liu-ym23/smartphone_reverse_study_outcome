package i70;

import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import j70.d;
import j70.f;
import java.util.Set;

/* JADX INFO: loaded from: classes45.dex */
public interface a {
    void F(d<h70.b> r100);

    Element<?> f2(f r100);

    Set<d<h70.b>> getDescriptorSet();

    LayerDelegate<? extends a, ? extends h70.b> getLayerDelegate();

    LayerIndex getLayerIndex();

    f70.b getLayerTypeV2();
}
