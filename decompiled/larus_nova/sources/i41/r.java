package i41;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static r f488201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f488202c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q> f488203a;

    public static final class a {
        public final synchronized r a() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (r.f488201b != null) goto L6;
            r.f488201b = new r();     // Catch: Throwable -> L9
        L6:
            r r100 = r.f488201b;     // Catch: Throwable -> L9
            Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L9
            monitor-exit(this);
            return r100;
        }

        public a() {
        }
    }

    static {
        f488202c = new a();
    }

    public final void a() {
        Iterator r100 = ((ArrayList) this.f488203a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((q) r100.next()).onEnd();
        goto L4
    }

    public r() {
        this.f488203a = new ArrayList();
    }
}
