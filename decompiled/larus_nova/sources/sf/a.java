package sf;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lg.c;
import lg.i;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<i> f541678a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f541679b = null;

    /* JADX INFO: renamed from: sf.a$a, reason: collision with other inner class name */
    public static final class CallableC7604a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f541680a;

        public CallableC7604a(c r100) {
            this.f541680a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            a r100 = a.f541679b;     // Catch: Throwable -> L19
            c r101 = this.f541680a;     // Catch: Throwable -> L19
            monitor-enter(r100);     // Catch: Throwable -> L19
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L5:
            if ((r101 instanceof lg.a) == false) goto L13;
            Iterator<i> r102 = a.f541678a.iterator();     // Catch: Throwable -> L15
        L8:
            if (r102.hasNext() == false) goto L11;
            r102.next().a((lg.a) r101);     // Catch: Throwable -> L15
            goto L26
        L11:
            monitor-exit(r100);     // Catch: Throwable -> L19
            return;
        L13:
            monitor-exit(r100);     // Catch: Throwable -> L19
            return;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public a() {
    }

    static {
        f541679b = new a();
        f541678a = new ArrayList();
    }

    public static void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Single.fromCallable(new CallableC7604a(r100)).subscribeOn(Schedulers.io()).subscribe();
    }
}
