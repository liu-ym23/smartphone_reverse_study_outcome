package go1;

import com.bytedance.android.livesdk.chatroom.ui.framework.widget.PopupWindowCompositeWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d3 extends e70.b<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    @Override // e70.b
    public final e70.e N() {
        return this;
    }

    @Override // e70.b
    public final e70.f O() {
        return this;
    }

    @Override // e70.h
    public final Widget l(h70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return null;
    }

    @Override // e70.h
    public final void s(h70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
    }

    @Override // e70.e
    public final /* synthetic */ void u() {
    }

    public d3() {
    }

    @Override // e70.h
    public final Class<? extends Widget> m() {
        return PopupWindowCompositeWidget.class;
    }

    @Override // e70.h
    public final boolean o(h70.b r100) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r100, "layerContext");
        return true;
    }

    @Override // e70.f
    public final j70.f p(h70.b r100) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r100, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.f113007z0;
    }

    @Override // e70.e
    public final boolean r(h70.b r100) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r100, "layerContext");
        return true;
    }
}
