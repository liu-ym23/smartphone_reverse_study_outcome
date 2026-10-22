package q8a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b extends com.lynx.tasm.behavior.ui.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f532046a;

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

    public final boolean getHandleGesture() {
        return this.f532046a;
    }

    public b(Context r100) {
        new LinkedHashMap();
        super(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getActionMasked() != 0) goto L10;
        if (this.f532046a == false) goto L10;
        ViewParent r101 = getParent();
        if (r101 == null) goto L10;
        r101.requestDisallowInterceptTouchEvent(true);
    L10:
        return super.dispatchTouchEvent(r100);
    }

    public final void setHandleGesture(boolean r100) {
        this.f532046a = r100;
    }
}
