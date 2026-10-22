package sna;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f542676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f542677b = null;

    static {
        f542677b = LazyKt.lazy(new e());
    }

    public static c b() {
        return (c) f542677b.getValue();
    }

    public final Context getContext() {
        Context r100 = f542676a;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public static int a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c r102 = b();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        return r102.a().getInt(r100, r101);
    }

    public static void c(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c r102 = b();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        r102.a().storeInt(r100, r101);
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        c r102 = b();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        r102.a().storeString(r100, r101);
    }
}
