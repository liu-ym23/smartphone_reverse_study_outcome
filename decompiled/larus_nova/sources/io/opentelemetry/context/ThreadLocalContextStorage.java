package io.opentelemetry.context;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
final enum ThreadLocalContextStorage extends Enum<ThreadLocalContextStorage> implements c {
    public static final ThreadLocalContextStorage INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f492688a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<b> f492689b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ThreadLocalContextStorage[] f492690c = null;

    public static final enum NoopScope extends Enum<NoopScope> implements h {
        public static final NoopScope INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NoopScope[] f492691a = null;

        @Override // java.lang.AutoCloseable
        public void close() {
        }

        static {
            NoopScope r100 = new NoopScope();
            INSTANCE = r100;
            f492691a = new NoopScope[]{r100};
        }

        public NoopScope() {
            super("INSTANCE", 0);
        }

        public static NoopScope[] values() {
            return (NoopScope[]) f492691a.clone();
        }

        public static NoopScope valueOf(String r100) {
            return (NoopScope) r27.a.a(NoopScope.class, r100);
        }
    }

    public class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final b f492692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f492693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f492694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ThreadLocalContextStorage f492695d;

        @Override // java.lang.AutoCloseable
        public final void close() {
            if (this.f492694c == false) goto L5;
        L7:
            ThreadLocalContextStorage.access$200().log(Level.FINE, " Trying to close scope which does not represent current context. Ignoring the call.");
            return;
        L5:
            if (this.f492695d.current() != this.f492693b) goto L7;
            this.f492694c = true;
            ThreadLocalContextStorage.access$100().set(this.f492692a);
        }

        public a(ThreadLocalContextStorage r100, b r101, b r102) {
            this.f492695d = r100;
            this.f492692a = r101;
            this.f492693b = r102;
        }
    }

    @Override // io.opentelemetry.context.c
    public b root() {
        return io.opentelemetry.context.a.f492696b;
    }

    static {
        ThreadLocalContextStorage r100 = new ThreadLocalContextStorage();
        INSTANCE = r100;
        f492690c = new ThreadLocalContextStorage[]{r100};
        f492688a = Logger.getLogger(ThreadLocalContextStorage.class.getName());
        f492689b = new ThreadLocal();
    }

    public ThreadLocalContextStorage() {
        super("INSTANCE", 0);
    }

    public static ThreadLocalContextStorage[] values() {
        return (ThreadLocalContextStorage[]) f492690c.clone();
    }

    @Override // io.opentelemetry.context.c
    @Nullable
    public b current() {
        return f492689b.get();
    }

    public static /* synthetic */ ThreadLocal access$100() {
        return f492689b;
    }

    public static /* synthetic */ Logger access$200() {
        return f492688a;
    }

    public static ThreadLocalContextStorage valueOf(String r100) {
        return (ThreadLocalContextStorage) r27.a.a(ThreadLocalContextStorage.class, r100);
    }

    public h attach(b r100) {
        if (r100 == null) goto L4;
        b r101 = current();
        if (r100 == r101) goto L8;
        f492689b.set(r100);
        return new a(this, r101, r100);
    L8:
        return NoopScope.INSTANCE;
    L4:
        return NoopScope.INSTANCE;
    }
}
