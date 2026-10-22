package nea;

import android.app.Application;

/* JADX INFO: loaded from: classes33.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f518909a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f518910a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static volatile b f518911b;

        static {
            f518910a = new a();
        }

        public a() {
        }

        public final c a() {
            b r100 = f518911b;
            if (r100 != null) goto L13;
            monitor-enter(this);
            r100 = f518911b;     // Catch: Throwable -> L10
            if (r100 != null) goto L8;
            r100 = b.f518906b;     // Catch: Throwable -> L10
            f518911b = r100;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r100;
        }
    }

    static {
        f518909a = a.f518910a;
    }

    Application getContext();
}
