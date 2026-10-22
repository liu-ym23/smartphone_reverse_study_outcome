package v5a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.display.VirtualDisplay;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import n5a.o;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f553326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f553327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f553328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View.OnFocusChangeListener f553329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Surface f553330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SurfaceTexture f553331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public VirtualDisplay f553332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f553333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f553334i;

    public static class a implements ViewTreeObserver.OnDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f553335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f553336b;

        /* JADX INFO: renamed from: v5a.e$a$a, reason: collision with other inner class name */
        public class RunnableC7965a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f553337a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f553337a.f553335a.getViewTreeObserver().removeOnDrawListener(this.f553337a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC7965a(a r100) {
                this.f553337a = r100;
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            Runnable r100 = this.f553336b;
            if (r100 != null) goto L5;
            return;
        L5:
            r100.run();
            this.f553336b = null;
            this.f553335a.post(new RunnableC7965a(this));
        }

        public a(View r100, d.a r101) {
            this.f553335a = r100;
            this.f553336b = r101;
        }
    }

    public e(Context r100, VirtualDisplay r101, o.a r102, Surface r110, SurfaceTexture r111, o.b r112, int r113) {
        this.f553327b = r100;
        this.f553329d = r112;
        this.f553330e = r110;
        this.f553331f = r111;
        this.f553332g = r101;
        Resources r103 = r100.getResources();
        this.f553328c = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).densityDpi;
        c r104 = new c(r100, this.f553332g.getDisplay(), r102, r113, r112);
        this.f553326a = r104;
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r104);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
    }
}
