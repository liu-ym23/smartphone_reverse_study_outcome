package usa;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public abstract class d implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f551561b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f551562c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f551563a;

    public static class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.f551561b = true;     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        }
    }

    public abstract void a();

    static {
        f551562c = new a();
    }

    public d() {
        this.f551563a = 500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (f551561b == false) goto L6;
        f551561b = false;
        r100.postDelayed(f551562c, this.f551563a);
        a();
        return;
    }
}
