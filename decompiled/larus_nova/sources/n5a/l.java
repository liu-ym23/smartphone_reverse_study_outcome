package n5a;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.engine.FlutterEngine;
import com.lynx.clay.plugin.platform.PlatformViewsController;

/* JADX INFO: loaded from: classes32.dex */
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f518060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f518061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PlatformViewsController f518062c;

    @Override // n5a.k
    public final void a(FlutterView r100) {
    }

    @Override // n5a.k
    public final void onViewDetached() {
    }

    @Override // n5a.k
    public final void release() {
    }

    @Override // n5a.k
    public final void b() {
        View r100 = this.f518061b;
        if (r100 == null) goto L6;
        r100.invalidate();
        return;
    }

    public final void d(m r100) {
        PlatformViewsController r101 = this.f518062c;
        int r102 = this.f518060a;
        r101.f380947e.put(r102, true);
        r101.f380948f.put(r102, r100);
        e5a.a r103 = r101.f380949g.get(r102);
        if (r103 == null) goto L6;
        r103.setSystemTouchDispatchEnabled(true);
        r103.setTouchDispatchResultListener(r100);
        return;
    }

    public l(FlutterView r100, int r101, View r102, boolean r103) {
        this.f518060a = r101;
        this.f518061b = r102;
        FlutterEngine r104 = r100.getAttachedFlutterEngine();
        if (r104 == null) goto L20;
        PlatformViewsController r105 = r104.f380699f;
        this.f518062c = r105;
        r105.getClass();
        r102.setWillNotDraw(false);
        r105.f380946d.put(r101, r102);
        View r106 = r105.f380946d.get(r101);
        if (r106 == null) goto L7;
        r106.setWillNotDraw(!r103);
    L7:
        e5a.a r107 = r105.f380949g.get(r101);
        if (r107 == null) goto L21;
        ViewGroup r108 = (ViewGroup) r107.getParent();
        if (r103 == true) goto L13;
        if (r108 == null) goto L13;
        r108.removeView(r107);
        return;
    L13:
        if (r103 == false) goto L23;
        FlutterView r109 = r105.f380945c;
        if (r109 == null) goto L24;
        if (r108 != null) goto L25;
        r109.addView(r107);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L21:
        return;
    L20:
        throw new IllegalStateException("FlutterEngine is not attached to FlutterView");
    }

    @Override // n5a.k
    public final Size c(int r100, int r101, int r102, int r103) {
        return new Size(r102, r103);
    }
}
