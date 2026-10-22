package je0;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f498789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f498790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f498791c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f498792a;

        public a(c r100) {
            this.f498792a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f498792a.f498791c.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.f498789a.getHeight() <= 0) goto L13;
        ViewTreeObserver r100 = this.f498789a.getViewTreeObserver();
        if (r100 == null) goto L7;
        r100.removeOnGlobalLayoutListener(this);
    L7:
        long r101 = this.f498790b;
        if (r101 != 0) goto L11;
        this.f498791c.invoke();
        return;
    L11:
        this.f498789a.postDelayed(new a(this), r101);
        return;
    }

    public c(View r100, long r101, Function0 r102) {
        this.f498789a = r100;
        this.f498790b = r101;
        this.f498791c = r102;
    }
}
