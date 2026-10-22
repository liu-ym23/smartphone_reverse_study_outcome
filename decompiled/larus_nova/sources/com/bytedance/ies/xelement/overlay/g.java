package com.bytedance.ies.xelement.overlay;

import android.content.Context;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g extends com.lynx.tasm.behavior.ui.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxOverlayViewProxy f250210a;

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    public g(Context r100, LynxOverlayViewProxy r101) {
        this.f250210a = r101;
        new LinkedHashMap();
        super(r100);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        if (r101 != 0) goto L5;
        this.f250210a.onAttach();
        return;
    L5:
        if (r101 != 4) goto L7;
    L9:
        this.f250210a.onDetach();
        return;
    L7:
        if (r101 == 8) goto L9;
    }
}
