package p8a;

import android.content.Context;
import android.view.Choreographer;
import android.view.View;

/* JADX INFO: loaded from: classes32.dex */
public final class c extends com.lynx.tasm.behavior.ui.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f528232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f528233b;

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

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        d r100 = this.f528232a;
        if (r100 == null) goto L6;
        r100.invalidate();
        return;
    }

    public c(Context r100) {
        super(r100);
        this.f528233b = null;
        setWillNotDraw(true);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [p8a.b] */
    public void setBundle(a r100) {
        if (this.f528233b != null) goto L5;
        this.f528233b = new b(this);
        Choreographer.getInstance().postFrameCallback(this.f528233b);
    L5:
        if (r100 == null) goto L12;
        View r101 = r100.f528230a;
        View r102 = this.f528232a;
        if (r101 == r102) goto L13;
        if (r102 == null) goto L10;
        removeView(r102);
    L10:
        d r103 = r100.f528230a;
        this.f528232a = r103;
        addView(r103);
        return;
    L13:
        return;
    }
}
