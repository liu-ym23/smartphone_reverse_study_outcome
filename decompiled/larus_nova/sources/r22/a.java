package r22;

import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f535752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r22.b<T> f535753b;

    /* JADX INFO: renamed from: r22.a$a, reason: collision with other inner class name */
    public static final class C7426a {
    }

    public interface b<T> {
        void a(T r100);
    }

    public static final class c implements b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f535754a;

        public c(a r100) {
            this.f535754a = r100;
        }

        @Override // r22.a.b
        public final void a(T r100) {
            this.f535754a.e(r100);
        }
    }

    static {
    }

    public boolean c(T r100) {
        return false;
    }

    public abstract Queue<T> h();

    public void i(T r100) {
    }

    public abstract T j();

    public final void d() {
        h().clear();
    }

    public final void k() {
        if (f().a() == false) goto L8;
        T r100 = j();
        if (r100 == null) goto L9;
        f().b(r100);
        return;
    L9:
        return;
    }

    public r22.b<T> f() {
        return this.f535753b;
    }

    public b<T> g() {
        return this.f535752a;
    }

    public a(r22.b<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "danmakuReceiver");
        this.f535753b = r100;
        this.f535752a = new c(this);
    }

    public final void a(T r100) {
        if (c(r100) == false) goto L6;
        i(r100);
        return;
    L6:
        b(r100, g());
    }

    public void e(T r100) {
        if (c(r100) == false) goto L7;
        i(r100);
        return;
    L7:
        if (h().size() < 200) goto L9;
        h().poll();
    L9:
        h().add(r100);
        k();
    }

    public void b(T r100, b<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "notifier");
        r101.a(r100);
    }
}
