package hwc;

import kotlin.jvm.internal.Intrinsics;
import org.koin.core.error.KoinAppAlreadyStartedException;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f487464a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static org.koin.core.a f487465b;

    static {
        f487464a = new a();
    }

    public a() {
    }

    public static org.koin.core.a a() {
        org.koin.core.a r100 = f487465b;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("KoinApplication has not been started".toString());
    }

    public final void b(org.koin.core.b r100) {
        Intrinsics.checkNotNullParameter(r100, "koinApplication");
        if (f487465b != null) goto L7;
        f487465b = r100.f526127a;
        return;
    L7:
        throw new KoinAppAlreadyStartedException("A Koin Application has already been started");
    }
}
