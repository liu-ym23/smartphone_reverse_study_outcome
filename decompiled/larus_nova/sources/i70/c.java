package i70;

import android.content.Context;
import com.bytedance.android.live.core.tetris.layer.core.delegate.DefaultXMLLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.XMLLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.ss.android.lark.utils.statistics.PerfLog;
import j70.d;
import j70.f;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XMLLayerDelegate f488454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f70.b f488455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LayerIndex f488456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f488457d;

    @Override // i70.a
    public final Set<d<h70.b>> getDescriptorSet() {
        return this.f488454a.f65647e;
    }

    public final Context getContext() {
        return this.f488457d;
    }

    @Override // i70.a
    public final LayerDelegate<? extends a, ? extends h70.b> getLayerDelegate() {
        return this.f488454a;
    }

    @Override // i70.a
    public final LayerIndex getLayerIndex() {
        return this.f488456c;
    }

    @Override // i70.a
    public final f70.b getLayerTypeV2() {
        return this.f488455b;
    }

    @Override // i70.a
    public final void F(d<h70.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        XMLLayerDelegate r101 = this.f488454a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        r101.f65647e.add(r100);
    }

    @Override // i70.a
    public final Element<?> f2(f r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        return this.f488454a.f(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(f70.b r100, LayerIndex r101, h70.b r102, Context r103, Class<XMLLayerDelegate<h70.b>> r104) {
        Intrinsics.checkNotNullParameter(r100, "layerType");
        Intrinsics.checkNotNullParameter(r101, "layerIndex");
        Intrinsics.checkNotNullParameter(r102, "layerContext");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f488455b = r100;
        this.f488456c = r101;
        this.f488457d = r103;
        if (r104 == null) goto L9;
        XMLLayerDelegate<h70.b> r105 = r104.newInstance();
        if (r105 == null) goto L8;
        XMLLayerDelegate<h70.b> r106 = r105;
    L10:
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r106.f65643a = this;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r106.f65645c = r102;
        this.f488454a = r106;
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.delegate.XMLLayerDelegate<com.bytedance.android.live.core.tetris.layer.LayerContext>");
    L9:
        r106 = new DefaultXMLLayerDelegate();
        goto L10
    }
}
