package hia;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<a> f485388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArraySet<hga.a> f485389b = null;

    static {
        f485388a = new AtomicReference(null);
        f485389b = new CopyOnWriteArraySet();
    }

    public static void a(a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        AtomicReference<a> r101 = f485388a;
    L6:
        if (r101.compareAndSet(r100, null) == true) goto L10;
        if (r101.get() == r100) goto L6;
        return;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        a r101 = f485388a.getAndSet(null);
        if (r101 != null) goto L5;
        return;
    L5:
        FLogger.f375446a.i("ObricContTalkSessionStore", "stopCurrentImmediately: reason=".concat(r100));
        r101.c();
    }
}
