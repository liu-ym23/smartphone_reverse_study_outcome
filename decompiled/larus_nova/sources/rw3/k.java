package rw3;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Set<String> f539644c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f539645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<jx3.a> f539646b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f539647a;

        @Override // java.lang.Runnable
        public final void run() {
            k r100 = this.f539647a;     // Catch: Throwable -> L7
            if (r100.f539646b.isEmpty() == true) goto L10;
            ArrayList r101 = new ArrayList(r100.f539646b);     // Catch: Throwable -> L7
            r100.f539646b.clear();     // Catch: Throwable -> L7
            f r102 = ((c) r100.f539645a).f539598a;     // Catch: Throwable -> L7
            r102.getClass();     // Catch: Throwable -> L7
            lx3.l r103 = lx3.l.d();     // Catch: Throwable -> L7
            g r104 = new g(r102, r101);     // Catch: Throwable -> L7
            r103.e().post(r104);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }

        public a(k r100) {
            this.f539647a = r100;
        }
    }

    public interface b {
    }

    static {
        f539644c = new HashSet();
    }

    public k(Handler r100, c r101) {
        this.f539646b = new ArrayList();
        new a(this);
        this.f539645a = r101;
    }
}
