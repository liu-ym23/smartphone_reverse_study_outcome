package sea;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f541633a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f541634b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference<String> f541635c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReference<String> f541636d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicLong f541637e = null;

    static {
        f541633a = new AtomicBoolean(false);
        f541634b = new AtomicBoolean(false);
        f541635c = new AtomicReference(null);
        f541636d = new AtomicReference(null);
        f541637e = new AtomicLong(0);
    }

    public static String b() {
        return f541635c.get();
    }

    public static void a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        f541635c.set(null);
        f541636d.set(null);
        return;
    L12:
        AtomicReference<String> r102 = f541635c;
        if (Intrinsics.areEqual(r102.get(), r100) == false) goto L16;
        r102.set(null);
        f541636d.set(null);
        return;
    L16:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L9
    }

    public static void c(boolean r100) {
        f541633a.set(r100);
    }

    public static void d(boolean r100) {
        f541634b.set(r100);
    }

    public static void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        a(null);
        return;
    L12:
        f541635c.set(r100);
        f541636d.set(r101);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
