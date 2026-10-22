package x5a;

import android.graphics.drawable.Drawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.parser.SVG;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f562553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f562554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SVG f562555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.lynx.component.svg.a f562556d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Drawable f562557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f562558b;

        public final void a() {
            if (this.f562558b.f562556d.f380992v == false) goto L6;
            this.f562558b.f562556d.f380986p = false;
            return;
        L6:
            com.lynx.component.svg.a r100 = this.f562558b.f562556d;
            r100.f380987q = this.f562557a;
            this.f562558b.f562556d.e(0);
            com.lynx.component.svg.a.k(this.f562558b.f562556d);
            this.f562558b.f562556d.f380986p = false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100, e r101) {
            this.f562558b = r100;
            this.f562557a = r101;
        }
    }

    /* JADX INFO: renamed from: x5a.b$b, reason: collision with other inner class name */
    public class RunnableC8197b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f562559a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f562559a.f562556d.f380986p = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC8197b(b r100) {
            this.f562559a = r100;
        }
    }

    public final void a() {
        com.lynx.component.svg.parser.c r100 = new com.lynx.component.svg.parser.c(this.f562556d.f562743d.f382179d.getUIBody().getFontSize(), this.f562556d.f562743d.f382179d.getUIBody().getFontSize());     // Catch: Exception -> L4
        r100.f381198a = new SVG.b(0.0f, 0.0f, this.f562553a, this.f562554b);     // Catch: Exception -> L4
        UIThreadUtils.runOnUiThread(new a(this, new e(this.f562555c, r100, this.f562556d.f380989s)));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("lynx_SVGRenderer", "renderLegacySVG failed: " + e.getMessage());
        UIThreadUtils.runOnUiThread(new RunnableC8197b(this));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(com.lynx.component.svg.a r100, int r101, int r102, SVG r103) {
        this.f562556d = r100;
        this.f562553a = r101;
        this.f562554b = r102;
        this.f562555c = r103;
    }
}
