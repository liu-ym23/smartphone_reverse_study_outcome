package o49;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends p49.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f522007b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b f522008c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f522009a;

    public static final class a {
        public final b a() {
            b r100 = b.f522008c;
            if (r100 != null) goto L15;
            monitor-enter(this);
            r100 = b.f522008c;     // Catch: Throwable -> L9
            if (r100 != null) goto L11;
            r100 = new b();     // Catch: Throwable -> L9
            b.f522008c = r100;     // Catch: Throwable -> L9
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r100;
        }

        public a() {
        }
    }

    static {
        f522007b = new a();
    }

    @Override // p49.a
    public final void a() {
    }

    public b() {
        this.f522009a = LazyKt.lazy(new o49.a());
    }
}
