package gb5;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f480729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f480730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f480731c;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f480732a;

        public b(e r100) {
            this.f480732a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f480732a.f480729a.setVisibility(8);     // Catch: Throwable -> L4
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
        public final /* synthetic */ e f480733a;

        public c(e r100) {
            this.f480733a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f480733a.f480729a.setVisibility(0);     // Catch: Throwable -> L4
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

    public e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingView");
        this.f480729a = r100;
        r100.setVisibility(8);
        this.f480730b = new c(this);
        this.f480731c = new b(this);
    }
}
