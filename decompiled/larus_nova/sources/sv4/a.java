package sv4;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f543660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f543661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f543662c;

    /* JADX INFO: renamed from: sv4.a$a, reason: collision with other inner class name */
    public static final class C7661a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f543663a;

        public b(a r100) {
            this.f543663a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f543663a.f543660a.setVisibility(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f543664a;

        public c(a r100) {
            this.f543664a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f543664a.f543660a.setVisibility(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingView");
        this.f543660a = r100;
        r100.setVisibility(8);
        this.f543661b = new c(this);
        this.f543662c = new b(this);
    }
}
