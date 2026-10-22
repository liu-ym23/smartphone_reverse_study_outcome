package jr0;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.openplatform.api.utils.OpenPlatformHostInfoPresenter;
import com.bytedance.android.live.openplatform.impl.minigameaudience.widget.AudienceMiniGameWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import d90.d;
import h70.b;
import j70.f;
import j70.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends n<d90.a> {
    @Override // j70.o
    public final boolean h() {
        return true;
    }

    public a() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return AudienceMiniGameWidget.class;
    }

    @Override // j70.d
    public final boolean B(b r100) {
        d90.a r101 = (d90.a) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        if (jr1.b.a(r101) == false) goto L5;
    L7:
        return false;
    L5:
        if (OpenPlatformHostInfoPresenter.a() == false) goto L7;
        return true;
    }

    @Override // j70.d
    public final f C(b r100) {
        d90.a r101 = (d90.a) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d.a.D3;
    }

    @Override // j70.d
    public final LayerIndex E(b r100) {
        Intrinsics.checkNotNullParameter((d90.a) r100, "layerContext");
        return LayerIndex.INDEX_6;
    }

    @Override // j70.h
    public final double H(b r100) {
        Intrinsics.checkNotNullParameter((d90.a) r100, "layerContext");
        return 0.2d;
    }

    @Override // j70.h
    public final ElementConstraint J(b r100) {
        Intrinsics.checkNotNullParameter((d90.a) r100, "layerContext");
        ElementConstraint r101 = ElementConstraint.f65822n;
        return ElementConstraint.b.a();
    }
}
