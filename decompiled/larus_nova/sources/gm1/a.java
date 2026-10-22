package gm1;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.replay.toolbar.widget.ReplayPortraitBottomToolbarWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import uq1.b;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends ReplayWidgetDescriptor<b> {
    @Override // j70.o
    public final boolean h() {
        return false;
    }

    public a() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return ReplayPortraitBottomToolbarWidget.class;
    }

    @Override // j70.d
    public final f C(h70.b r100) {
        b r101 = (b) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f551200d.getClass();
        return uq1.a.f551174a;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final boolean N(h70.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter((b) r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        if (((Boolean) r101.invoke(4)).booleanValue() == false) goto L5;
    L9:
        return false;
    L5:
        if (((Boolean) r101.invoke(1)).booleanValue() == true) goto L9;
        if (((Boolean) r101.invoke(2)).booleanValue() == true) goto L9;
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final ElementConstraint O(h70.b r100, Function1 r101) {
        b r102 = (b) r100;
        Intrinsics.checkNotNullParameter(r102, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        ElementConstraint r103 = new ElementConstraint(-2.0f, 36.0f);
        int r104 = lr1.a.f510387b;
        lr1.a.C6730a.a(r102.f551201e).getClass();
        ElementConstraint.Side r105 = ElementConstraint.Side.BOTTOM;
        r103.d(r105, r105, 20.0f);
        ElementConstraint.Side r106 = ElementConstraint.Side.RIGHT;
        r103.d(r106, r106, 12.0f);
        return r103;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final LayerIndex P(h70.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter((b) r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        return LayerIndex.INDEX_5;
    }
}
