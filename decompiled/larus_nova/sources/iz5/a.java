package iz5;

import hz5.l;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f496698a = null;

    public a() {
    }

    static {
        f496698a = new a();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r100, Throwable r101) {
        r100.getName();
        Objects.toString(r101);
        r101.printStackTrace();
        l.b(new b(r100, r101, "DefaultUncaughtExceptionHandler", null, 24));
    }
}
