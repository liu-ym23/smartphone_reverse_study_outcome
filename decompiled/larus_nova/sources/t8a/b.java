package t8a;

import android.content.Context;
import x6a.d;

/* JADX INFO: loaded from: classes32.dex */
public class b extends com.lynx.tasm.behavior.ui.view.a {
    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        d.k(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        d.l(this, r100);
    }

    public b(Context r100) {
        super(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (getChildCount() <= 0) goto L6;
        getChildAt(0).measure(r100, r101);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (getChildCount() <= 0) goto L6;
        getChildAt(0).layout(0, 0, getWidth(), getHeight());
        return;
    }
}
