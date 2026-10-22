package n5a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import com.lynx.clay.embedding.android.FlutterView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes32.dex */
public final class o implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f518065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SurfaceTexture f518066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f518067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f518068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f518069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f518070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v5a.e f518071g;

    public class a implements v5a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f518072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f518073b;

        public a(o r100, View r101) {
            this.f518073b = r100;
            this.f518072a = r101;
        }
    }

    public class b implements View.OnFocusChangeListener {
        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
        }

        public b() {
        }
    }

    public class c implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
        }

        public c() {
        }
    }

    @Override // n5a.k
    public final void a(FlutterView r100) {
    }

    @Override // n5a.k
    public final void onViewDetached() {
    }

    @Override // n5a.k
    public final void b() {
        View r100 = this.f518068d;
        if (r100 == null) goto L6;
        r100.invalidate();
        return;
    }

    @Override // n5a.k
    public final void release() {
        a r100 = this.f518069e;
        if (r100 == null) goto L8;
        v5a.e r101 = r100.f518073b.f518071g;
        if (r101 == null) goto L9;
        r101.f553326a.cancel();
        v5a.c r102 = r101.f553326a;
        r102.f553307d.removeAllViews();
        r102.f553306c.removeAllViews();
        r101.f553332g.release();
        return;
    L9:
        return;
    }

    public o(Context r100, SurfaceTexture r101, int r102, View r103) {
        this.f518065a = r100;
        this.f518066b = r101;
        this.f518067c = r102;
        this.f518068d = r103;
        this.f518069e = new a(this, r103);
        this.f518070f = new b();
    }

    @Override // n5a.k
    public final Size c(int r210, int r211, int r212, int r213) {
        v5a.e r110 = this.f518071g;
        View r111 = null;
        v5a.e r112 = null;
        r112 = null;
        r112 = null;
        v5a.a r113 = null;
        if (r110 != null) goto L14;
        Context r114 = this.f518065a;
        a r115 = this.f518069e;
        SurfaceTexture r116 = this.f518066b;
        int r117 = this.f518067c;
        b r118 = this.f518070f;
        Resources r100 = r114.getResources();
        WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        if (r212 == 0) goto L12;
        if (r213 == 0) goto L12;
        r116.setDefaultBufferSize(r212, r213);
        Surface r101 = new Surface(r116);
        DisplayManager r102 = (DisplayManager) r114.getSystemService("display");
        Resources r103 = r114.getResources();
        VirtualDisplay r104 = r102.createVirtualDisplay("flutter-vd", r212, r213, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).densityDpi, r101, 0);
        if (r104 == null) goto L12;
        r112 = new v5a.e(r114, r104, r115, r101, r116, r118, r117);
        r112.f553333h = r212;
        r112.f553334i = r213;
    L12:
        this.f518071g = r112;
    L39:
        if (this.f518071g == null) goto L41;
        v5a.e r105 = this.f518071g;
        return new Size(r105.f553333h, r105.f553334i);
    L41:
        return new Size(0, 0);
    L14:
        if (r212 == r110.f553333h) goto L16;
    L17:
        c r119 = new c();
        v5a.c r106 = r110.f553326a;
        if (r106 != null) goto L20;
        View r107 = null;
    L24:
        boolean r120 = r107.isFocused();
        v5a.c r108 = r110.f553326a;
        r108.f553307d.removeAllViews();
        r108.f553306c.removeAllViews();
        v5a.c.e r121 = r108.f553308e;
        r110.f553332g.setSurface(null);
        r110.f553332g.release();
        r110.f553333h = r212;
        r110.f553334i = r213;
        r110.f553331f.setDefaultBufferSize(r212, r213);
        r110.f553332g = ((DisplayManager) r110.f553327b.getSystemService("display")).createVirtualDisplay("flutter-vd", r212, r213, r110.f553328c, r110.f553330e, 0);
        v5a.c r109 = r110.f553326a;
        if (r109 == null) goto L32;
        v5a.a r122 = r109.f553308e.f553318a;
        if (r122 == null) goto L31;
        r113 = r122;
    L31:
        r111 = ((a) r113).f518072a;
    L32:
        r111.addOnAttachStateChangeListener(new v5a.d(r111, r119));
        v5a.c r123 = new v5a.c(r110.f553327b, r110.f553332g.getDisplay(), r121, r110.f553329d, r120);
        if (DialogLancet.shouldBlockDialogShow(r123) == false) goto L45;
        DialogLancet.handleBlockedDialogShow(r123);
    L37:
        r110.f553326a.cancel();
        r110.f553326a = r123;
        goto L39
    L45:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
    L36:
        DialogLancet.beforeDialogShow(r123);
        r123.show();
        DialogLancet.afterDialogShow(r123);
        goto L37
    L20:
        v5a.a r124 = r106.f553308e.f553318a;
        if (r124 != null) goto L23;
        r124 = null;
    L23:
        r107 = ((a) r124).f518072a;
        goto L24
    L16:
        if (r213 == r110.f553334i) goto L39;
        goto L17
    }
}
