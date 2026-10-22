package v5a;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import n5a.o;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f553323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f553324b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f553325a;

        @Override // java.lang.Runnable
        public final void run() {
            d r100 = this.f553325a;     // Catch: Throwable -> L4
            r100.f553323a.postDelayed(r100.f553324b, 128);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r100) {
            this.f553325a = r100;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        View r101 = this.f553323a;
        e.a r102 = new e.a(r101, new a(this));
        r101.getViewTreeObserver().addOnDrawListener(r102);
        this.f553323a.removeOnAttachStateChangeListener(this);
    }

    public d(View r100, o.c r101) {
        this.f553323a = r100;
        this.f553324b = r101;
    }
}
