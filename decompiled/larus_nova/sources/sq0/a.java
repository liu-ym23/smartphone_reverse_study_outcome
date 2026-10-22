package sq0;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.openplatform.api.utils.OpenPlatformHostInfoPresenter;
import com.bytedance.android.live.openplatform.impl.miniappaudience.widget.AudienceMiniAppWidget;
import com.bytedance.android.livesdk.config.c6;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import d90.c;
import d90.d;
import h70.b;
import j70.f;
import j70.n;
import java.util.List;
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
        return AudienceMiniAppWidget.class;
    }

    @Override // j70.d
    public final boolean B(b r100) {
        d90.a r101 = (d90.a) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        if (jr1.b.a(r101) == false) goto L5;
    L9:
        return false;
    L5:
        if (OpenPlatformHostInfoPresenter.a() == false) goto L9;
        if (c.i(r101) == false) goto L9;
        return true;
    }

    @Override // j70.d
    public final f C(b r100) {
        d90.a r101 = (d90.a) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d.a.B3;
    }

    @Override // j70.d
    public final LayerIndex E(b r100) {
        Intrinsics.checkNotNullParameter((d90.a) r100, "layerContext");
        return LayerIndex.INDEX_6;
    }

    @Override // j70.h
    public final double H(b r100) {
        d90.a r101 = (d90.a) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        Room r102 = c.q(r101);
        c6 r103 = com.bytedance.android.livesdk.config.setting.d.f121208a;
        Intrinsics.checkNotNullParameter("AudienceMiniApp", "widget");
        if (r102 != null) goto L5;
    L20:
        boolean r104 = false;
    L22:
        if (r104 == false) goto L25;
        return 1.1d;
    L25:
        if (de0.f120026a.getValue().n() == false) goto L28;
        return 0.2d;
    L28:
        return 1.1d;
    L5:
        if (r102.isVsRoom() == true) goto L20;
        if (r102.isMergeVSRoom() == true) goto L20;
        if (r102.isMediaRoom() == true) goto L20;
        c6 r105 = com.bytedance.android.livesdk.config.setting.d.f121208a;
        if (r105.b() == false) goto L20;
        r104 = true;
        if (r102.isGameRoom() != 1) goto L20;
        List<String> r106 = r105.a();
        if (r106 == null) goto L20;
        if (r106.contains("AudienceMiniApp") != true) goto L20;
        goto L20
    }

    @Override // j70.h
    public final ElementConstraint J(b r100) {
        Intrinsics.checkNotNullParameter((d90.a) r100, "layerContext");
        ElementConstraint r101 = ElementConstraint.f65822n;
        return ElementConstraint.b.a();
    }
}
