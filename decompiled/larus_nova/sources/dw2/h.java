package dw2;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h extends n<e0> {
    @Override // j70.o
    public final boolean h() {
        return true;
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        xo2.b r100 = (xo2.b) l.d().b().a(xo2.b.class);
        if (r100 == null) goto L5;
        Class<? extends LiveRecyclableWidget> r101 = r100.a();
    L6:
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public h() {
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return false;
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.f467538l;
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return LayerIndex.INDEX_6;
    }

    @Override // j70.h
    public final ElementConstraint J(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return new ElementConstraint(-1.0f, -1.0f);
    }
}
