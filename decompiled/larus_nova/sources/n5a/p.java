package n5a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformViewPlugin;

/* JADX INFO: loaded from: classes32.dex */
public final class p implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v5a.b f518074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f518075b;

    @Override // n5a.k
    public final void b() {
        this.f518074a.invalidate();
    }

    @Override // n5a.k
    public final void onViewDetached() {
        d(this.f518074a);
    }

    @Override // n5a.k
    public final void release() {
        v5a.b r100 = this.f518074a;
        r100.f553286e = null;
        Surface r101 = r100.f553287f;
        if (r101 == null) goto L5;
        r101.release();
        r100.f553287f = null;
    L5:
        r100.getContext().unregisterComponentCallbacks(r100.f553298q);
        d(this.f518075b);
    }

    public static void d(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100.getParent() instanceof ViewGroup) == false) goto L8;
        ((ViewGroup) r100.getParent()).removeView(r100);
        return;
    }

    @Override // n5a.k
    public final void a(FlutterView r100) {
        if (this.f518074a.willNotDraw() == false) goto L5;
        return;
    L5:
        d(this.f518074a);
        r100.addView(this.f518074a, 0);
        v5a.b r101 = this.f518074a;
        if (r101.f553296o == false) goto L9;
        r101.f553297p = Math.max(r101.f553297p, 2);
        r101.postInvalidateOnAnimation();
        return;
    }

    @Override // n5a.k
    public final Size c(int r100, int r101, int r102, int r103) {
        ViewGroup.LayoutParams r104 = this.f518074a.getLayoutParams();
        if ((r104 instanceof FrameLayout.LayoutParams) == false) goto L5;
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r104;
    L6:
        r105.height = r103;
        r105.width = r102;
        r105.leftMargin = r100;
        r105.topMargin = r101;
        this.f518074a.setLayoutParams(r105);
        if (r102 <= this.f518074a.getBufferWidth()) goto L9;
    L10:
        v5a.b r106 = this.f518074a;
        r106.f553284c = r102;
        r106.f553285d = r103;
        SurfaceTexture r107 = r106.f553286e;
        if (r107 == null) goto L13;
        r107.setDefaultBufferSize(r102, r103);
    L13:
        if (r102 <= 0) goto L19;
        if (r103 <= 0) goto L19;
        v5a.b r108 = this.f518074a;
        if (r108.f553296o == false) goto L19;
        r108.f553297p = Math.max(r108.f553297p, 2);
        r108.postInvalidateOnAnimation();
    L19:
        return new Size(this.f518074a.getBufferWidth(), this.f518074a.getBufferHeight());
    L9:
        if (r103 <= this.f518074a.getBufferHeight()) goto L13;
    L5:
        r105 = new FrameLayout.LayoutParams(r102, r103);
        goto L6
    }

    public p(Context r100, SurfaceTexture r101, View r102, boolean r103, boolean r104, n r105, PlatformViewPlugin.a r106) {
        v5a.b r107 = new v5a.b(r100);
        this.f518074a = r107;
        this.f518075b = r102;
        r107.setPostDrawRedrawEnabled(true);
        r107.setTexture(r101);
        r107.setWillNotDraw(true ^ r103);
        r107.setSystemTouchDispatchEnabled(r104);
        r107.setTouchDispatchTargetChecker(r105);
        r107.setTouchDispatchResultListener(r106);
        r107.addView(r102, new FrameLayout.LayoutParams(-1, -1));
    }
}
