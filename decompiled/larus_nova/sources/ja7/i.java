package ja7;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes19.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f497918a;

    public static class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f497919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f497920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f497921c;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.f497919a.get() == false) goto L5;
            return false;
        L5:
            if (this.f497920b.isAlive() == false) goto L7;
            this.f497920b.removeOnPreDrawListener(this);
            return true;
        L7:
            this.f497921c.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }

        public a(AtomicBoolean r100, ViewTreeObserver r101, View r102) {
            this.f497919a = r100;
            this.f497920b = r101;
            this.f497921c = r102;
        }
    }

    public static class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f497922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f497923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f497924c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Runnable f497925d;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this.f497922a.isAlive() == false) goto L5;
            this.f497922a.removeGlobalOnLayoutListener(this);
        L6:
            this.f497924c.set(false);
            this.f497925d.run();
            return;
        L5:
            this.f497923b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            goto L6
        }

        public b(ViewTreeObserver r100, View r101, AtomicBoolean r102, Runnable r103) {
            this.f497922a = r100;
            this.f497923b = r101;
            this.f497924c = r102;
            this.f497925d = r103;
        }
    }

    public static class c implements qa7.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f497926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f497927b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f497928c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f497929d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Runnable f497930e;

        @Override // qa7.b.a
        public final void onCancel() {
            if (this.f497926a.isAlive() == false) goto L5;
            this.f497926a.removeGlobalOnLayoutListener(this.f497927b);
        L6:
            this.f497929d.set(false);
            this.f497930e.run();
            return;
        L5:
            this.f497928c.getViewTreeObserver().removeGlobalOnLayoutListener(this.f497927b);
            goto L6
        }

        public c(ViewTreeObserver r100, b r101, View r102, AtomicBoolean r103, Runnable r104) {
            this.f497926a = r100;
            this.f497927b = r101;
            this.f497928c = r102;
            this.f497929d = r103;
            this.f497930e = r104;
        }
    }

    public i() {
    }

    public abstract void a(ja7.a r100, ja7.a r101, Runnable r102, qa7.b r103);

    public abstract void b(ja7.a r100, ja7.a r101, Runnable r102, qa7.b r103);

    public abstract void c();

    public static void d(View r100, qa7.b r110, Runnable r111) {
        if (r100 != r100.getRootView()) goto L7;
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        AtomicBoolean r102 = new AtomicBoolean(true);
        r101.addOnPreDrawListener(new a(r102, r101, r100));
        b r103 = new b(r101, r100, r102, r111);
        r110.b(new c(r101, r103, r100, r102, r111));
        r101.addOnGlobalLayoutListener(r103);
        return;
    L7:
        throw new IllegalArgumentException("Need View.getRootView()");
    }
}
